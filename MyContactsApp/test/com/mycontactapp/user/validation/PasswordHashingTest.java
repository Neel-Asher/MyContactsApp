package com.mycontactapp.user.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PasswordHashingTest {

    @Test
    void testHashPassword() {

        String hash = PasswordHashing.hashPassword("password123");

        assertNotNull(hash);
        assertEquals(64, hash.length()); // SHA256 length
    }
}