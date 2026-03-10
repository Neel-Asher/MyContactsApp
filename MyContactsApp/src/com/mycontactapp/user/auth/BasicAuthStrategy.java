package com.mycontactapp.user.auth;

import java.util.Optional;

import com.mycontactapp.user.model.User;
import com.mycontactapp.user.repository.UserRepository;
import com.mycontactapp.user.validation.PasswordHashing;

public class BasicAuthStrategy implements AuthenticationStrategy {

    private final UserRepository repository = UserRepository.getInstance();

    @Override
    public Optional<User> authenticate(String email, String password) {

        User user = repository.findByEmail(email);

        if (user == null)
            return Optional.empty();

        String hashed = PasswordHashing.hashPassword(password);

        if (user.getPassword().equals(hashed))
            return Optional.of(user);

        return Optional.empty();
    }
}