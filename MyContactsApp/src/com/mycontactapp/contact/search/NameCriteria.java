package com.mycontactapp.contact.search;

import com.mycontactapp.contact.model.Contact;

import java.util.function.Predicate;

public class NameCriteria implements SearchCriteria {

    private String name;

    public NameCriteria(String name) {
        this.name = name.toLowerCase();
    }

    @Override
    public Predicate<Contact> toPredicate() {

        return contact ->
                contact.getName()
                       .toLowerCase()
                       .contains(name);
    }
}