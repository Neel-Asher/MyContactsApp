package com.mycontactapp.contact.filter;

import com.mycontactapp.contact.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompositeFilter implements ContactFilter {

    private List<ContactFilter> filters = new ArrayList<>();

    public void addFilter(ContactFilter filter) {

        filters.add(filter);

    }

    @Override
    public Predicate<Contact> apply() {

        Predicate<Contact> predicate = c -> true;

        for(ContactFilter f : filters){

            predicate = predicate.and(f.apply());

        }

        return predicate;

    }
}