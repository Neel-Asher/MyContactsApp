package com.mycontactapp.contact.search;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.repository.ContactRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ContactSearchService {

    private ContactRepository repo =
            ContactRepository.getInstance();

    public List<Contact> search(CriteriaChain chain){

        return repo.getAllContacts()
                .stream()
                .filter(chain.buildPredicate())
                .collect(Collectors.toList());

    }

}