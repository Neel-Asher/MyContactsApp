package com.mycontactapp.contact.observer;

import com.mycontactapp.contact.model.Contact;

public class NotificationService implements ContactObserver {

    @Override
    public void onContactDeleted(Contact contact) {

        System.out.println(
                "Notification: Contact " +
                contact.getName() +
                " was removed."
        );
    }
}