package com.mycontactapp.user.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycontactapp.user.model.FreeUser;
import com.mycontactapp.user.model.User;

public class UpdateNameCommandTest {

    @Test
    void testUpdateName() {

        User user = new FreeUser(
                "test@mail.com",
                "hash",
                "John",
                "Doe"
        );

        UpdateNameCommand cmd =
                new UpdateNameCommand(user, "Alice", "Smith");

        cmd.execute();

        assertEquals("Alice", user.getFirstName());
        assertEquals("Smith", user.getLastName());
    }
}