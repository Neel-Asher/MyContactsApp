package com.mycontactapp.user;

import java.util.Scanner;

import com.mycontactapp.user.model.User;
import com.mycontactapp.user.repository.UserRepository;
import com.mycontactapp.user.service.RegistrationService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RegistrationService registrationService = new RegistrationService();
        UserRepository userRepository = UserRepository.getInstance();	

        try {

            System.out.print("Enter First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            System.out.print("Enter User Type: ");
            String typeInput = sc.nextLine();

            User.UserType userType = User.UserType.valueOf(typeInput.trim());

            User user = registrationService.registerUser(userType,email,password,firstName,lastName);

            System.out.println("Registration Successful!");
            System.out.print("Registration details: ");
            
            userRepository.printAllUsers();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}