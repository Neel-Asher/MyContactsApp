package com.mycontactapp.contact.view;

public abstract class ContactViewDecorator implements ContactView {

    protected ContactView decorated;

    public ContactViewDecorator(ContactView decorated) {
        this.decorated = decorated;
    }

    @Override
    public String display() {
        return decorated.display();
    }
}