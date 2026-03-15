package com.mycontactapp.contact.observer;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.tag.Tag;

public interface TagObserver {

    void onTagAssigned(Contact contact, Tag tag);

    void onTagRemoved(Contact contact, Tag tag);

}