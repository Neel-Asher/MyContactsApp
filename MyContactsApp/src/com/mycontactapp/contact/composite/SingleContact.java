package com.mycontactapp.contact.composite;

import java.util.List;

import com.mycontactapp.contact.model.Contact;

public class SingleContact implements ContactComponent {

    private Contact contact;

    public SingleContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public List<Contact> getContacts() {

        return List.of(contact);

    }
}