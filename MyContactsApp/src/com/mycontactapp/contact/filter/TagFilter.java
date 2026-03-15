package com.mycontactapp.contact.filter;

import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.tag.Tag;

import java.util.function.Predicate;

public class TagFilter implements ContactFilter {

    private Tag tag;

    public TagFilter(Tag tag) {
        this.tag = tag;
    }

    public TagFilter(String string) {
		this.tag = new Tag(string);
    }
				
	@Override
    public Predicate<Contact> apply() {

        return contact ->
                contact.getTags()
                       .stream()
                       .anyMatch(t -> t.contains(tag));

    }
}