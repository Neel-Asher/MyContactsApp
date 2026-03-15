package com.mycontactapp.contact.repository;

import java.util.*;

import com.mycontactapp.contact.model.Contact;

public class ContactRepository {

    private static final ContactRepository INSTANCE =
            new ContactRepository();

    private Map<UUID,Contact> contacts = new HashMap<>();

    private ContactRepository(){}

    public static ContactRepository getInstance(){
        return INSTANCE;
    }

    public void save(Contact contact){
        contacts.put(contact.getId(),contact);
    }

    public List<Contact> findAll(){
        return new ArrayList<>(contacts.values());
    }
    
    public Optional<Contact> findById(UUID id){
        return Optional.ofNullable(contacts.get(id));
    }
}