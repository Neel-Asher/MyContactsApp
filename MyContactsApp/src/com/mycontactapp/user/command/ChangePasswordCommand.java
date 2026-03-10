package com.mycontactapp.user.command;

import com.mycontactapp.user.model.User;
import com.mycontactapp.user.validation.PasswordHashing;
import com.mycontactapp.user.validation.Validation;

public class ChangePasswordCommand implements ProfileCommand {

    private User user;
    private String newPassword;

    public ChangePasswordCommand(User user,String newPassword) {
        this.user=user;
        this.newPassword=newPassword;
    }

    @Override
    public void execute() {

        Validation.validatePassword(newPassword);

        String hashed = PasswordHashing.hashPassword(newPassword);

        user.setPassword(hashed);
    }
}