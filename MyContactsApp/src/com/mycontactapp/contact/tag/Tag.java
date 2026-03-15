package com.mycontactapp.contact.tag;

import java.util.List;
import java.util.Objects;

import com.mycontactapp.contact.model.Contact;

public class Tag {

    private String name;

    public Tag(String name) {

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Tag name invalid");
        }

        this.name = name.toLowerCase();
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o){

        if(this == o) return true;

        if(!(o instanceof Tag)) return false;

        Tag tag = (Tag)o;

        return name.equals(tag.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString(){
        return name;
    }
    
	public boolean contains(Tag other){
		return this.name.contains(other.name);
	}

	public List<Contact> getContacts() {
		return TagService.getInstance().getContactsByTag(this);
	}

	public void addContact(Contact contact) {
		TagService.getInstance().addTag(this, contact);
		
	}
}