package com.mycontactapp.user.auth;

import java.util.Optional;
import com.mycontactapp.user.model.User;

public interface AuthenticationStrategy {

    Optional<User> authenticate(String email, String password);

}