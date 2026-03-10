package com.mycontactapp.user.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycontactapp.user.model.User;
import com.mycontactapp.user.repository.UserRepository;

public class RegistrationServiceTest {

    private RegistrationService service = new RegistrationService();
    private UserRepository repo = UserRepository.getInstance();

    @Test
    void testRegisterFreeUser() {

        User user = service.registerUser(
                User.UserType.Free,
                "test@gmail.com",
                "password123",
                "John",
                "Doe"
        );

        assertNotNull(user);
        assertEquals(User.UserType.Free, user.getUserType());
        assertTrue(repo.existsByEmail("test@gmail.com"));
    }
}