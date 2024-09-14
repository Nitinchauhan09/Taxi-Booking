package com.bookingokay.rapidbooking.dao;

import com.bookingokay.rapidbooking.model.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer> {

    @Override
    public <S extends ContactForm> S save(S entity);
}
