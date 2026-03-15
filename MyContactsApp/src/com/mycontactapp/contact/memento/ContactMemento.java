package com.mycontactapp.contact.memento;

import java.util.List;

import com.mycontactapp.contact.model.EmailAddress;
import com.mycontactapp.contact.model.PhoneNumber;

public class ContactMemento {

    private final String name;
    private final List<PhoneNumber> phones;
    private final List<EmailAddress> emails;

    public ContactMemento(String name,
                          List<PhoneNumber> phones,
                          List<EmailAddress> emails) {

        this.name = name;
        this.phones = phones;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }
}