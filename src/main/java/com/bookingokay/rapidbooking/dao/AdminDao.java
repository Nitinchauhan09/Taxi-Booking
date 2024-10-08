package com.bookingokay.rapidbooking.dao;

import com.bookingokay.rapidbooking.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);



}
