package com.bookingokay.rapidbooking.config;

import com.bookingokay.rapidbooking.dao.AdminDao;
import com.bookingokay.rapidbooking.model.Admin;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AdminDao adminDao;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @PostConstruct
    public void init(){
        Long count = adminDao.count();
        if(count == 0){
            Admin admin = new Admin();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            adminDao.save(admin);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // select sn, username, password from admin where username = ?
        Optional<Admin> byUsername = adminDao.findByUsername(username);
        Admin admin = byUsername.orElseThrow(()-> new UsernameNotFoundException("ADMIN DOESN'T EXIST"));

        return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();

    }
}
