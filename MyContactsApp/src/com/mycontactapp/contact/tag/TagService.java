package com.mycontactapp.contact.tag;

import java.util.List;

import com.mycontactapp.contact.model.Contact;

public class TagService {

    private TagRepository repo = TagRepository.getInstance();

    public Tag createTag(String name){

        Tag tag = TagFactory.getTag(name);

        repo.addTag(tag);

        return tag;
    }

	public List<Contact> getContactsByTag(Tag workTag) {
				return repo.getContactsByTag(workTag);
				
	}

	public static TagService getInstance() {
				return TagServiceHolder.INSTANCE;
	}

	private static class TagServiceHolder {
		private static final TagService INSTANCE = new TagService();
	}

	public void addTag(Tag workTag, Contact contact) {
		repo.addTagToContact(workTag, contact);
		
	}

	
}