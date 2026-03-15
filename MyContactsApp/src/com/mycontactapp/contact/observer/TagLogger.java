package com.mycontactapp.contact.observer;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.tag.Tag;

public class TagLogger implements TagObserver {

    @Override
    public void onTagAssigned(Contact contact, Tag tag) {

        System.out.println("Tag "+tag+" assigned to "+contact.getName());

    }

    @Override
    public void onTagRemoved(Contact contact, Tag tag) {

        System.out.println("Tag "+tag+" removed from "+contact.getName());

    }
}