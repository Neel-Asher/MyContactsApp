package com.mycontactapp.user.auth;

import java.util.Optional;

import com.mycontactapp.user.model.User;

public class OAuthStrategy implements AuthenticationStrategy {

    @Override
    public Optional<User> authenticate(String email, String password) {

        System.out.println("OAuth authentication not implemented yet.");

        return Optional.empty();
    }
}