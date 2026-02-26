package com.mycontactapp.user.builder;

import com.mycontactapp.user.exception.InvalidUserDataException;
import com.mycontactapp.user.factory.UserFactory;
import com.mycontactapp.user.model.User;
import com.mycontactapp.user.model.User.UserType;
import com.mycontactapp.user.validation.PasswordHashing;
import com.mycontactapp.user.validation.Validation;

public class UserBuilder {
	
	private String email;
    private String password;
    private String firstName;
    private String lastName;
    private User.UserType userType;

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setUserType(User.UserType userType) {
        this.userType = userType;
        return this;
    }

    public User build() {

        Validation.validateEmail(email);
        Validation.validatePassword(password);

        if (userType == null) {
            throw new InvalidUserDataException("User type must be specified");
        }

        String hashedPassword = PasswordHashing.hashPassword(password);
        

        return UserFactory.createUser(
                userType,
                email,
                hashedPassword,
                firstName,
                lastName
        );
    }
}