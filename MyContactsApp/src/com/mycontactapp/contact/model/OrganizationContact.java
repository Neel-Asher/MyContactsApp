package com.mycontactapp.contact.model;

import java.util.List;

public class OrganizationContact extends Contact {

    private String companyName;

    public OrganizationContact(String name,
                               String companyName,
                               List<PhoneNumber> phones,
                               List<EmailAddress> emails) {

        super(name,phones,emails);
        this.companyName=companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String getContactType() {
        return "ORGANIZATION";
    }
}