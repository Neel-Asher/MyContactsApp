package com.mycontactapp.user.validation;

import java.util.regex.Pattern;

import com.mycontactapp.user.exception.InvalidUserDataException;
public class Validation {
	
	public static final String email_regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	public static final Pattern email_pattern = Pattern.compile(email_regex);
	
	public static void validateEmail(String email) {
		if (email == null || !email_pattern.matcher(email).matches()) {
			throw new InvalidUserDataException("Invalid email format!");
	    }
	}
	
	public static void validatePassword(String password) {
		if (password == null || password.length()<8) {
			throw new InvalidUserDataException("Password should have atleast 8 characters!");
		}
	}
}