package com.mycontactapp.user.model;

public abstract class User {
	
	public enum UserType {
		Free,
		Premium
	}

	private final String email;
	private final String password;
	private final String firstName;
	private final String lastName;

	protected User(String email, String password,String firstName, String lastName) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public abstract UserType getUserType();
}