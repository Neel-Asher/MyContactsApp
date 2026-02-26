package com.mycontactapp.user.factory;

import com.mycontactapp.user.model.FreeUser;
import com.mycontactapp.user.model.PremiumUser;
import com.mycontactapp.user.model.User;

public class UserFactory {
	public static User createUser(User.UserType type,String email,String passwordHash,String firstName,String lastName) {

		switch (type) {
		
			case Free:
				return new FreeUser(email,passwordHash,firstName,lastName);
			
			case Premium:
				return new PremiumUser(email,passwordHash,firstName,lastName,generateSubscriptionId());

			default:
				throw new IllegalArgumentException("Invalid user type");
			}
	}

	private static String generateSubscriptionId() {
		return "SUB-" + System.currentTimeMillis();
	}
}