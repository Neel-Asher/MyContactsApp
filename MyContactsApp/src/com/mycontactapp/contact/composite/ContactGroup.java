package com.mycontactapp.contact.composite;

import java.util.ArrayList;
import java.util.List;

import com.mycontactapp.contact.model.Contact;

public class ContactGroup implements ContactComponent {

    private List<ContactComponent> components = new ArrayList<>();

    public void add(ContactComponent component) {

        components.add(component);

    }

    @Override
    public List<Contact> getContacts() {

        List<Contact> result = new ArrayList<>();

        for(ContactComponent c : components){

            result.addAll(c.getContacts());

        }

        return result;
    }
}