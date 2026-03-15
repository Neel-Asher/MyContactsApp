package com.mycontactapp.contact.bulk;

import com.mycontactapp.contact.composite.ContactComponent;
import com.mycontactapp.contact.tag.Tag;

public class BulkOperationService {

    public void bulkDelete(ContactComponent component) {

        component.getContacts()
                .stream()
                .forEach(c -> c.setDeleted(true));
    }

    public void addTag(ContactComponent component,Tag tag){

        component.getContacts()
                .stream()
                .forEach(c -> c.addTag(tag));

    }

}