package com.mycontactapp.user.model;

public class FreeUser extends User {
	
	public FreeUser(String email,String password,String firstName,String lastName) {
		super (email,password,firstName,lastName);
	}
	
	@Override
	public UserType getUserType() {
		return UserType.Free;
	}
}