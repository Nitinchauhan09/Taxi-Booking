package com.bookingokay.rapidbooking.service;

import com.bookingokay.rapidbooking.dao.BookingFormCrud;
import com.bookingokay.rapidbooking.model.BookingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingFormServiceImpl implements BookingFormService{

    private BookingFormCrud bookingFormCrud;

    @Autowired
    public void setBookingFormCrud(BookingFormCrud bookingFormCrud) {
        this.bookingFormCrud = bookingFormCrud;
    }

    @Override
    public BookingForm saveBookingFormService(BookingForm bookingForm) {
        return bookingFormCrud.save(bookingForm);

    }
}
