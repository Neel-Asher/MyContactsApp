package com.mycontactapp.contact.search;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.model.EmailAddress;

import java.util.function.Predicate;

public class EmailCriteria implements SearchCriteria {

    private String email;

    public EmailCriteria(String email) {
        this.email = email.toLowerCase();
    }

    @Override
    public Predicate<Contact> toPredicate() {

        return contact ->
                contact.getEmails()
                        .stream()
                        .map(EmailAddress::getEmail)
                        .anyMatch(e -> e.toLowerCase().contains(email));
    }
}