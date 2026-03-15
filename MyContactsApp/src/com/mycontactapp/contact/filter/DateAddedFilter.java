package com.mycontactapp.contact.filter;

import com.mycontactapp.contact.model.Contact;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class DateAddedFilter implements ContactFilter {

    private LocalDateTime after;

    public DateAddedFilter(LocalDateTime after) {
        this.after = after;
    }

    @Override
    public Predicate<Contact> apply() {

        return contact ->
                contact.getCreatedAt().isAfter(after);

    }
}