package com.mycontactapp.contact.filter;

import com.mycontactapp.contact.model.Contact;

import java.util.function.Predicate;

public interface ContactFilter {

    Predicate<Contact> apply();

}