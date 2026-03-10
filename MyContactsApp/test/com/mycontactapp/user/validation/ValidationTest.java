package com.mycontactapp.user.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycontactapp.user.exception.InvalidUserDataException;

public class ValidationTest {

    @Test
    void testValidEmail() {
        assertDoesNotThrow(() ->
            Validation.validateEmail("test@gmail.com")
        );
    }

    @Test
    void testInvalidEmail() {
        assertThrows(InvalidUserDataException.class, () ->
            Validation.validateEmail("invalid-email")
        );
    }

    @Test
    void testInvalidPassword() {
        assertThrows(InvalidUserDataException.class, () ->
            Validation.validatePassword("123")
        );
    }
}