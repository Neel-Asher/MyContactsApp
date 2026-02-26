package com.mycontactapp.user.repository;

import java.util.*;

import com.mycontactapp.user.exception.InvalidUserDataException;
import com.mycontactapp.user.model.User;
public class UserRepository {
	
	private static final UserRepository Instance = new UserRepository();
	private final Map<String,User> users = new HashMap<>();
	
	private UserRepository() {};
	
	public static UserRepository getInstance() {
		return Instance;
	}
	
	public void save(User user) {
		if (users.containsKey(user.getEmail())) 
			throw new InvalidUserDataException("User with this email already exists!");
		users.put(user.getEmail(),user);
	}
	
	public User findByEmail(String email) {
		return users.get(email);
	}
	
	public boolean existsByEmail(String email) {
		return users.containsKey(email);
	}
	
	public void printAllUsers() {
		for (User user:users.values()) 
			System.out.println(user.getUserType()+" | "+user.getEmail()+" | "+user.getFirstName()+" "+user.getLastName());
	}
}