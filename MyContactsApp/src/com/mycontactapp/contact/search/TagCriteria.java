package com.mycontactapp.contact.search;

import com.mycontactapp.contact.model.Contact;

import java.util.function.Predicate;

public class TagCriteria implements SearchCriteria {

    private String tag;

    public TagCriteria(String tag) {
        this.tag = tag.toLowerCase();
    }

    @Override
    public Predicate<Contact> toPredicate() {

        return contact ->
                contact.getTags()
                       .stream()
                       .anyMatch(t -> t.toLowerCase().contains(tag));
    }
}