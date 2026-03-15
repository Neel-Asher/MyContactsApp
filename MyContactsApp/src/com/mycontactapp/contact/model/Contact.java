package com.mycontactapp.contact.model;

import java.time.LocalDateTime;
import java.util.*;

public abstract class Contact {

    private final UUID id;
    private String name;

    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private List<EmailAddress> emails = new ArrayList<>();

    private final LocalDateTime createdAt;

    protected Contact(String name,List<PhoneNumber> phones,List<EmailAddress> emails) {

        this.id = UUID.randomUUID();
        this.name = name;

        if(phones!=null)
            this.phoneNumbers.addAll(phones);

        if(emails!=null)
            this.emails.addAll(emails);

        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }

    public String getName() { return name; }

    public List<PhoneNumber> getPhoneNumbers() { return phoneNumbers; }

    public List<EmailAddress> getEmails() { return emails; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public abstract String getContactType();
}