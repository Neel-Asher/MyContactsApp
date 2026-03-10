package com.mycontactapp.user.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycontactapp.user.model.FreeUser;
import com.mycontactapp.user.model.User;
import com.mycontactapp.user.validation.PasswordHashing;

public class ChangePasswordCommandTest {

    @Test
    void testPasswordChange() {

        User user = new FreeUser(
                "test@mail.com",
                "oldhash",
                "John",
                "Doe"
        );

        ChangePasswordCommand cmd =
                new ChangePasswordCommand(user, "newpassword123");

        cmd.execute();

        String expected =
                PasswordHashing.hashPassword("newpassword123");

        assertEquals(expected, user.getPassword());
    }
}