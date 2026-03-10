package com.mycontactapp.user.command;

import com.mycontactapp.user.model.User;

public class UpdatePreferencesCommand implements ProfileCommand {

    private User user;
    private String key;
    private String value;

    public UpdatePreferencesCommand(User user,String key,String value) {
        this.user=user;
        this.key=key;
        this.value=value;
    }

    @Override
    public void execute() {
        user.setPreference(key,value);
    }
}