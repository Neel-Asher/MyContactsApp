package com.mycontactapp.contact.filter;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.repository.ContactRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterService {

    private ContactRepository repo =
            ContactRepository.getInstance();

    public List<Contact> filter(ContactFilter filter){

        return repo.getAllContacts()
                .stream()
                .filter(filter.apply())
                .collect(Collectors.toList());

    }

    public List<Contact> filterAndSort(ContactFilter filter,
                                       Comparator<Contact> comparator){

        return repo.getAllContacts()
                .stream()
                .filter(filter.apply())
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}