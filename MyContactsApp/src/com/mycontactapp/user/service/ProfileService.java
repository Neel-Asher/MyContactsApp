package com.mycontactapp.user.service;

import com.mycontactapp.user.command.ProfileCommand;

public class ProfileService {

    public void executeCommand(ProfileCommand command) {
        command.execute();
    }
}