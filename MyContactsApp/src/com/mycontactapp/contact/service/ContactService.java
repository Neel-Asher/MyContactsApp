package com.mycontactapp.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mycontactapp.contact.builder.ContactBuilder;
import com.mycontactapp.contact.command.EditContactCommand;
import com.mycontactapp.contact.exception.ContactNotFoundException;
import com.mycontactapp.contact.history.CommandHistory;
import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.repository.ContactRepository;
import com.mycontactapp.contact.observer.ContactObserver;

public class ContactService {

    private final ContactRepository repo =
            ContactRepository.getInstance();
    
    private CommandHistory history = new CommandHistory();
    
    private List<ContactObserver> observers = new ArrayList<>();

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
    
    public void registerObserver(ContactObserver observer){

        observers.add(observer);

    }
    
    private void notifyDeletion(Contact contact){

        for(ContactObserver observer : observers){

            observer.onContactDeleted(contact);

        }
    }
    
    public void deleteContact(UUID id){

        Optional<Contact> contactOpt = repo.findById(id);

        if(contactOpt.isEmpty()){

            throw new ContactNotFoundException("Contact not found");

        }

        Contact contact = contactOpt.get();

        contact.setDeleted(true);

        notifyDeletion(contact);

    }
}