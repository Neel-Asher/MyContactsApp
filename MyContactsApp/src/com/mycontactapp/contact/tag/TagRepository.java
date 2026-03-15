package com.mycontactapp.contact.tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mycontactapp.contact.model.Contact;

public class TagRepository {

    private static TagRepository instance;

    private Set<Tag> tags = new HashSet<>();

    private TagRepository(){}

    public static TagRepository getInstance(){

        if(instance == null){

            instance = new TagRepository();

        }

        return instance;
    }

    public void addTag(Tag tag){

        tags.add(tag);

    }

    public Set<Tag> getAllTags(){

        return tags;

    }

	public List<Contact> getContactsByTag(Tag workTag) {
		return workTag.getContacts();
	}

	public void addTagToContact(Tag workTag, Contact contact) {
		workTag.addContact(contact);
		
	}
}