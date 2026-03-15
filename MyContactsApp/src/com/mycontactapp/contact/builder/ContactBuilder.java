package com.mycontactapp.contact.builder;

import java.util.*;

import com.mycontactapp.contact.factory.ContactFactory;
import com.mycontactapp.contact.model.*;

public class ContactBuilder {

    private String name;
    private String companyName;

    private List<PhoneNumber> phones = new ArrayList<>();
    private List<EmailAddress> emails = new ArrayList<>();

    private ContactType type;

    public enum ContactType {
        PERSON,
        ORGANIZATION
    }

    public ContactBuilder setName(String name){
        this.name=name;
        return this;
    }

    public ContactBuilder setCompanyName(String companyName){
        this.companyName=companyName;
        return this;
    }

    public ContactBuilder setType(ContactType type){
        this.type=type;
        return this;
    }

    public ContactBuilder addPhone(String phone){
        phones.add(new PhoneNumber(phone));
        return this;
    }

    public ContactBuilder addEmail(String email){
        emails.add(new EmailAddress(email));
        return this;
    }

    public Contact build(){

        return ContactFactory.createContact(
                type,
                name,
                companyName,
                phones,
                emails
        );
    }
}