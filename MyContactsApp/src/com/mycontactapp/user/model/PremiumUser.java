package com.mycontactapp.user.model;

public class PremiumUser extends User {
	
	private final String subId;
	
	public PremiumUser(String email,String password,String firstName,String lastName,String subId) {
		super (email,password,firstName,lastName);
		this.subId = subId;
	}
	
	public String getSubId() {
		return subId;
	}
	
	@Override
	public UserType getUserType() {
		return UserType.Premium;
	}
}