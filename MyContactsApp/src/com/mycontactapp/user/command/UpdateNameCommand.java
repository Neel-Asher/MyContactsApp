package com.mycontactapp.user.command;

import com.mycontactapp.user.model.User;

public class UpdateNameCommand implements ProfileCommand {

    private User user;
    private String firstName;
    private String lastName;

    public UpdateNameCommand(User user,String firstName,String lastName) {
        this.user=user;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public void execute() {
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }
}