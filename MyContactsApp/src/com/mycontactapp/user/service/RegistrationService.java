package com.mycontactapp.user.service;

import com.mycontactapp.user.builder.UserBuilder;
import com.mycontactapp.user.exception.InvalidUserDataException;
import com.mycontactapp.user.model.User;
import com.mycontactapp.user.repository.UserRepository;

public class RegistrationService {
	
	private final UserRepository userRepository = UserRepository.getInstance();
	
	public User registerUser(User.UserType type,String email,String password,String firstName,String lastName) {
		if (userRepository.existsByEmail(email))
			throw new InvalidUserDataException("Email already registered!");
		
		User user = new UserBuilder().setUserType(type).setEmail(email).setPassword(password).setFirstName(firstName).setLastName(lastName).build();
		userRepository.save(user);
		
		return user;
	}
}