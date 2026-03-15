package com.mycontactapp.contact.service;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.model.ContactTag;
import com.mycontactapp.contact.observer.TagSubject;
import com.mycontactapp.contact.tag.Tag;

import java.util.HashSet;
import java.util.Set;

public class ContactTagService {

    private TagSubject subject = new TagSubject();

    private Set<ContactTag> associations = new HashSet<>();

    public void assignTag(Contact contact, Tag tag){

        ContactTag ct = new ContactTag(contact,tag);

        associations.add(ct);

        contact.addTag(tag);

        subject.notifyTagAssigned(contact,tag);

    }

    public void removeTag(Contact contact, Tag tag){

        associations.removeIf(a ->
                a.getContact().equals(contact) &&
                a.getTag().equals(tag)
        );

        contact.getTags().remove(tag);

        subject.notifyTagRemoved(contact,tag);

    }

    public Set<Tag> getTags(Contact contact){

        return contact.getTags();

    }
}