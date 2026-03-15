package com.mycontactapp.contact.dto;

import java.util.List;
import java.util.UUID;

public final class ContactViewDTO {

    private final UUID id;
    private final String name;
    private final List<String> phones;
    private final List<String> emails;

    public ContactViewDTO(UUID id,String name,
                          List<String> phones,
                          List<String> emails) {

        this.id=id;
        this.name=name;
        this.phones=phones;
        this.emails=emails;
    }

    public UUID getId(){ return id; }
    public String getName(){ return name; }
    public List<String> getPhones(){ return phones; }
    public List<String> getEmails(){ return emails; }
}