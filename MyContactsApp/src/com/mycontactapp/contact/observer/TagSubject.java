package com.mycontactapp.contact.observer;

import java.util.ArrayList;
import java.util.List;

public class TagSubject {

    private List<TagObserver> observers = new ArrayList<>();

    public void addObserver(TagObserver observer){

        observers.add(observer);

    }

    public void notifyTagAssigned(Object contact, Object tag){

        for(TagObserver o : observers){

            o.onTagAssigned((com.mycontactapp.contact.model.Contact)contact,
                            (com.mycontactapp.contact.tag.Tag)tag);

        }

    }

    public void notifyTagRemoved(Object contact, Object tag){

        for(TagObserver o : observers){

            o.onTagRemoved((com.mycontactapp.contact.model.Contact)contact,
                           (com.mycontactapp.contact.tag.Tag)tag);

        }

    }
}