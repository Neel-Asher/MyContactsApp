package com.mycontactapp.contact.observer;

import com.mycontactapp.contact.model.Contact;

public interface ContactObserver {

    void onContactDeleted(Contact contact);

}