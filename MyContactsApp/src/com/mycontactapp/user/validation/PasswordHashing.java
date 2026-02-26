package com.mycontactapp.user.validation;

import java.security.*;
public class PasswordHashing {
	
	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			
			for (byte b:hash) {
				sb.append(String.format("%02x",b));
			}
			
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Hashing error",e);
		}
	}
}