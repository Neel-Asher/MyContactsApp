package com.mycontactapp.user;

import java.util.Optional;
import java.util.Scanner;

import com.mycontactapp.user.auth.BasicAuthStrategy;
import com.mycontactapp.user.model.User;
import com.mycontactapp.user.repository.UserRepository;
import com.mycontactapp.user.service.AuthenticationService;
import com.mycontactapp.user.service.RegistrationService;
import com.mycontactapp.user.session.SessionManager;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RegistrationService registrationService = new RegistrationService();
        AuthenticationService authService =
                new AuthenticationService(new BasicAuthStrategy());

        UserRepository repo = UserRepository.getInstance();

        try {

            System.out.println("=== REGISTER USER ===");

            System.out.print("First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            System.out.print("User Type (Free/Premium): ");
            User.UserType type = User.UserType.valueOf(sc.nextLine());

            registrationService.registerUser(type, email, password, firstName, lastName);

            System.out.println("\nRegistration successful!");

            repo.printAllUsers();

            System.out.println("\n=== LOGIN ===");

            System.out.print("Email: ");
            String loginEmail = sc.nextLine();

            System.out.print("Password: ");
            String loginPassword = sc.nextLine();

            Optional<User> loggedUser = authService.login(loginEmail, loginPassword);

            if (loggedUser.isPresent()) {

                System.out.println("Login successful!");

                System.out.println(
                        "Welcome " +
                        SessionManager.getInstance().getCurrentUser().getFirstName()
                );

            } else {

                System.out.println("Invalid credentials.");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}