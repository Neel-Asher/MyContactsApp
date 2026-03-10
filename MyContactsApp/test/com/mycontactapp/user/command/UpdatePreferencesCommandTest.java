package com.mycontactapp.user.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycontactapp.user.model.FreeUser;
import com.mycontactapp.user.model.User;

public class UpdatePreferencesCommandTest {

    @Test
    void testUpdatePreference() {

        User user = new FreeUser(
                "test@mail.com",
                "hash",
                "John",
                "Doe"
        );

        UpdatePreferencesCommand cmd =
                new UpdatePreferencesCommand(user,
                        "theme",
                        "dark");

        cmd.execute();

        assertEquals(
                "dark",
                user.getPreferences().get("theme")
        );
    }
}