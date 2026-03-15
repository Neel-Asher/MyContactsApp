package com.mycontactapp.contact.service;

import java.util.Optional;
import java.util.UUID;

import com.mycontactapp.contact.builder.ContactBuilder;
import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.repository.ContactRepository;

public class ContactService {

    private final ContactRepository repo =
            ContactRepository.getInstance();

    public Contact createContact(ContactBuilder builder){

        Contact contact = builder.build();

        repo.save(contact);

        return contact;
    }
    
    public Optional<Contact> getContact(UUID id){
        return repo.findById(id);
    }
}