package com.mycontactapp.user.service;

import java.util.Optional;

import com.mycontactapp.user.auth.AuthenticationStrategy;
import com.mycontactapp.user.model.User;
import com.mycontactapp.user.session.SessionManager;

public class AuthenticationService {

    private final AuthenticationStrategy strategy;
    private final SessionManager sessionManager = SessionManager.getInstance();

    public AuthenticationService(AuthenticationStrategy strategy) {
        this.strategy = strategy;
    }

    public Optional<User> login(String email, String password) {

        Optional<User> user = strategy.authenticate(email, password);

        user.ifPresent(sessionManager::login);

        return user;
    }

    public void logout() {
        sessionManager.logout();
    }
}