package com.mycontactapp.contact.command;

import com.mycontactapp.contact.memento.ContactMemento;
import com.mycontactapp.contact.model.Contact;

public class EditContactCommand implements ContactCommand {

    private Contact contact;

    private String newName;

    private ContactMemento backup;

    public EditContactCommand(Contact contact,String newName) {

        this.contact = contact;
        this.newName = newName;

    }

    @Override
    public void execute() {

        backup = contact.saveState();

        contact.setName(newName);

    }

    @Override
    public void undo() {

        if(backup!=null){

            contact.restoreState(backup);

        }

    }
}