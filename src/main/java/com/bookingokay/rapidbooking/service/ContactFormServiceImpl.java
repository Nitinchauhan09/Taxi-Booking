package com.bookingokay.rapidbooking.service;

import com.bookingokay.rapidbooking.dao.ContactFormCrud;
import com.bookingokay.rapidbooking.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactFormServiceImpl implements ContactFormService{

    private ContactFormCrud contactFormCrud;

    @Autowired
    public void setContactFormCrud(ContactFormCrud contactFormCrud) {
        this.contactFormCrud = contactFormCrud;
    }

    @Override
    public ContactForm saveContactFormService(ContactForm contactForm) {
        return contactFormCrud.save(contactForm);
    }
}
