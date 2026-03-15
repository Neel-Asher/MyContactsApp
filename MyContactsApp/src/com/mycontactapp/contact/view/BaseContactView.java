package com.mycontactapp.contact.view;

import com.mycontactapp.contact.model.Contact;

public class BaseContactView implements ContactView {

    protected Contact contact;

    public BaseContactView(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String display() {

        StringBuilder sb = new StringBuilder();

        sb.append("Contact ID: ").append(contact.getId()).append("\n");
        sb.append("Name: ").append(contact.getName()).append("\n");
        sb.append("Type: ").append(contact.getContactType()).append("\n");

        sb.append("Phones:\n");
        contact.getPhoneNumbers()
               .forEach(p -> sb.append(" - ").append(p.getNumber()).append("\n"));

        sb.append("Emails:\n");
        contact.getEmails()
               .forEach(e -> sb.append(" - ").append(e.getEmail()).append("\n"));

        return sb.toString();
    }
}