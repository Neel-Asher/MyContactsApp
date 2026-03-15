package com.mycontactapp.contact.service;

import java.util.Optional;
import java.util.UUID;

import com.mycontactapp.contact.builder.ContactBuilder;
import com.mycontactapp.contact.command.EditContactCommand;
import com.mycontactapp.contact.history.CommandHistory;
import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.repository.ContactRepository;

public class ContactService {

    private final ContactRepository repo =
            ContactRepository.getInstance();
    
    private CommandHistory history = new CommandHistory();

    public Contact createContact(ContactBuilder builder){

        Contact contact = builder.build();

        repo.save(contact);

        return contact;
    }
    
    public Optional<Contact> getContact(UUID id){
        return repo.findById(id);
    }
    
    public void editContact(Contact contact,String newName){

        EditContactCommand cmd =
                new EditContactCommand(contact,newName);

        history.execute(cmd);

    }

    public void undoEdit(){

        history.undo();

    }

    public void redoEdit(){

        history.redo();

    }
}