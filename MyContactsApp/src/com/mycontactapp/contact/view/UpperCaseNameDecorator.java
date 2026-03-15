package com.mycontactapp.contact.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpperCaseNameDecorator extends ContactViewDecorator {

    public UpperCaseNameDecorator(ContactView decorated) {
        super(decorated);
    }

    @Override
    public String display() {

        String result = decorated.display();
        Pattern pattern = Pattern.compile("(Name: )(.*)");
        Matcher matcher = pattern.matcher(result);

        String output = matcher.replaceAll(m -> m.group(1) + m.group(2).toUpperCase());
        return output;
    }
}