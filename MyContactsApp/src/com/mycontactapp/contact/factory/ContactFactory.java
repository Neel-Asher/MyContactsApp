package com.mycontactapp.contact.factory;

import java.util.List;

import com.mycontactapp.contact.builder.ContactBuilder.ContactType;
import com.mycontactapp.contact.model.*;

public class ContactFactory {

    public static Contact createContact(
            ContactType type,
            String name,
            String companyName,
            List<PhoneNumber> phones,
            List<EmailAddress> emails) {

        switch(type){

        case PERSON:
            return new PersonContact(name,phones,emails);

        case ORGANIZATION:
            return new OrganizationContact(name,companyName,phones,emails);

        default:
            throw new IllegalArgumentException("Invalid contact type");
        }
    }
}