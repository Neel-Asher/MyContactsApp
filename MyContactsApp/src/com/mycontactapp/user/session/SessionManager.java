package com.mycontactapp.user.session;

import com.mycontactapp.user.model.User;

public class SessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private User currentUser;

    private SessionManager() {}

    public static SessionManager getInstance() {
        return INSTANCE;
    }

    public void login(User user) {
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}