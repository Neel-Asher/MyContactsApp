package com.mycontactapp.contact.model;

import java.util.List;

public class PersonContact extends Contact {

    public PersonContact(String name,
                         List<PhoneNumber> phones,
                         List<EmailAddress> emails) {

        super(name,phones,emails);
    }

    @Override
    public String getContactType() {
        return "PERSON";
    }
}