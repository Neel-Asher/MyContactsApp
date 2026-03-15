package com.mycontactapp.contact.bulk;

import com.mycontactapp.contact.composite.ContactComponent;
import com.mycontactapp.contact.model.Contact;

public class ExportService {

    public void exportContacts(ContactComponent component){

        component.getContacts()
                .stream()
                .forEach(c -> System.out.println(
                        c.getName()+" | "+c.getId()
                ));

    }

}