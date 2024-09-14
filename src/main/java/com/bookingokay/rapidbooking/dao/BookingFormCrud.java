package com.bookingokay.rapidbooking.dao;

import com.bookingokay.rapidbooking.model.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFormCrud extends JpaRepository<BookingForm, Integer> {

    @Override
    public <S extends BookingForm> S save(S entity);
}
