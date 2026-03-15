package com.mycontactapp.contact.view;

public class MaskEmailDecorator extends ContactViewDecorator {

    public MaskEmailDecorator(ContactView decorated) {
        super(decorated);
    }

    @Override
    public String display() {

        String text = decorated.display();

        return text.replaceAll(
                "([a-zA-Z0-9._%+-]+)@",
                "***@"
        );
    }
}