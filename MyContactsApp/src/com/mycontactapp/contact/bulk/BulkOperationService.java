package com.mycontactapp.contact.bulk;

import java.util.List;

import com.mycontactapp.contact.composite.ContactComponent;
import com.mycontactapp.contact.model.Contact;

public class BulkOperationService {

    public void bulkDelete(ContactComponent component) {

        component.getContacts()
                .stream()
                .forEach(c -> c.setDeleted(true));
    }

    public void addTag(ContactComponent component,String tag){

        component.getContacts()
                .stream()
                .forEach(c -> c.addTag(tag));

    }

}