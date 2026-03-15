package com.mycontactapp.contact.search;

import com.mycontactapp.contact.model.Contact;

import java.util.function.Predicate;

public interface SearchCriteria {

    Predicate<Contact> toPredicate();

}