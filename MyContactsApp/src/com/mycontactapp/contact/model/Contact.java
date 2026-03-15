package com.mycontactapp.contact.model;

import java.time.LocalDateTime;
import java.util.*;

import com.mycontactapp.contact.memento.ContactMemento;

public abstract class Contact {

    private final UUID id;
    private String name;

	private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private List<EmailAddress> emails = new ArrayList<>();

    private final LocalDateTime createdAt;
    
    private List<String> tags = new ArrayList<>();
    
    private int interactionCount;

    protected Contact(String name,List<PhoneNumber> phones,List<EmailAddress> emails) {

        this.id = UUID.randomUUID();
        this.name = name;

        if(phones!=null)
            this.phoneNumbers.addAll(phones);

        if(emails!=null)
            this.emails.addAll(emails);

        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }

    public String getName() { return name; }

    public List<PhoneNumber> getPhoneNumbers() { return phoneNumbers; }

    public List<EmailAddress> getEmails() { return emails; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public abstract String getContactType();
    
    public void setName(String name) {
		this.name = name;
	}
    
    public ContactMemento saveState() {

        return new ContactMemento(
                this.name,
                new ArrayList<>(this.phoneNumbers),
                new ArrayList<>(this.emails)
        );
    }

    public void restoreState(ContactMemento memento) {

        this.name = memento.getName();
        this.phoneNumbers = new ArrayList<>(memento.getPhones());
        this.emails = new ArrayList<>(memento.getEmails());
    }
    
    private boolean deleted = false;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    public void addTag(String tag){

        tags.add(tag);

    }

    public List<String> getTags(){

        return tags;

    }
    
    public int getInteractionCount(){
        return interactionCount;
    }

    public void incrementInteraction(){
        interactionCount++;
    }
}