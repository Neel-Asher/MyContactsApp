package com.mycontactapp.contact.search;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.model.PhoneNumber;

import java.util.function.Predicate;

public class PhoneCriteria implements SearchCriteria {

    private String phone;

    public PhoneCriteria(String phone) {
        this.phone = phone;
    }

    @Override
    public Predicate<Contact> toPredicate() {

        return contact ->
                contact.getPhoneNumbers()
                        .stream()
                        .map(PhoneNumber::getNumber)
                        .anyMatch(p -> p.contains(phone));
    }
}