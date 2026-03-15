package com.mycontactapp.contact.filter;

import com.mycontactapp.contact.model.Contact;

import java.util.function.Predicate;

public class TagFilter implements ContactFilter {

    private String tag;

    public TagFilter(String tag) {
        this.tag = tag.toLowerCase();
    }

    @Override
    public Predicate<Contact> apply() {

        return contact ->
                contact.getTags()
                       .stream()
                       .anyMatch(t -> t.toLowerCase().contains(tag));

    }
}