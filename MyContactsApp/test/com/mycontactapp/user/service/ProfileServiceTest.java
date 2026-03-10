package com.mycontactapp.user.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycontactapp.user.command.UpdateNameCommand;
import com.mycontactapp.user.model.FreeUser;
import com.mycontactapp.user.model.User;

public class ProfileServiceTest {

    @Test
    void testExecuteCommand() {

        User user = new FreeUser(
                "user@mail.com",
                "hash",
                "John",
                "Doe"
        );

        ProfileService service = new ProfileService();

        service.executeCommand(
                new UpdateNameCommand(user,"Bob","Taylor")
        );

        assertEquals("Bob", user.getFirstName());
    }
}