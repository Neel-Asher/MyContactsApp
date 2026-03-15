package com.mycontactapp.contact.filter;

import com.mycontactapp.contact.model.Contact;

import java.util.function.Predicate;

public class FrequentContactFilter implements ContactFilter {

    private int threshold;

    public FrequentContactFilter(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public Predicate<Contact> apply() {

        return contact ->
                contact.getInteractionCount() >= threshold;

    }
}