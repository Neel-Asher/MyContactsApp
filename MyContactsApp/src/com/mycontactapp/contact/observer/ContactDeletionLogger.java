package com.mycontactapp.contact.observer;

import com.mycontactapp.contact.model.Contact;

public class ContactDeletionLogger implements ContactObserver {

    @Override
    public void onContactDeleted(Contact contact) {

        System.out.println(
                "LOG: Contact deleted -> " + contact.getName()
        );
    }
}