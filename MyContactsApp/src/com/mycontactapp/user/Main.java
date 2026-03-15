package com.mycontactapp.user;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import com.mycontactapp.contact.builder.ContactBuilder;
import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.service.ContactService;
import com.mycontactapp.contact.view.BaseContactView;
import com.mycontactapp.contact.view.ContactView;
import com.mycontactapp.contact.view.MaskEmailDecorator;
import com.mycontactapp.contact.view.UpperCaseNameDecorator;
import com.mycontactapp.user.auth.BasicAuthStrategy;
import com.mycontactapp.user.command.ChangePasswordCommand;
import com.mycontactapp.user.command.UpdateNameCommand;
import com.mycontactapp.user.command.UpdatePreferencesCommand;
import com.mycontactapp.user.model.User;
import com.mycontactapp.user.repository.UserRepository;
import com.mycontactapp.user.service.AuthenticationService;
import com.mycontactapp.user.service.ProfileService;
import com.mycontactapp.user.service.RegistrationService;
import com.mycontactapp.user.session.SessionManager;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RegistrationService registrationService = new RegistrationService();
        AuthenticationService authService =
                new AuthenticationService(new BasicAuthStrategy());
        ProfileService profileService = new ProfileService();

        UserRepository repo = UserRepository.getInstance();
        
        ContactService contactService = new ContactService();

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

                User currentUser = SessionManager.getInstance().getCurrentUser();

                System.out.println("Welcome " + currentUser.getFirstName());

                System.out.println("\n=== PROFILE MANAGEMENT ===");

                System.out.println("1. Update Name");
                System.out.println("2. Change Password");
                System.out.println("3. Update Preference");
                System.out.println("4. Create Contact");
                System.out.println("5. View Contacts");

                System.out.print("Choose option: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("New First Name: ");
                        String fn = sc.nextLine();

                        System.out.print("New Last Name: ");
                        String ln = sc.nextLine();

                        profileService.executeCommand(
                                new UpdateNameCommand(currentUser, fn, ln));

                        System.out.println("Name updated successfully.");
                        break;

                    case 2:

                        System.out.print("New Password: ");
                        String newPass = sc.nextLine();

                        profileService.executeCommand(
                                new ChangePasswordCommand(currentUser, newPass));

                        System.out.println("Password updated successfully.");
                        break; 

                    case 3:

                        System.out.print("Preference Key: ");
                        String key = sc.nextLine();

                        System.out.print("Preference Value: ");
                        String value = sc.nextLine();

                        profileService.executeCommand(
                                new UpdatePreferencesCommand(currentUser, key, value));

                        System.out.println("Preference updated.");
                        break;
                    
                    case 4:
                    	
                    	ContactBuilder builder = new ContactBuilder()
                        .setType(ContactBuilder.ContactType.PERSON)
                        .setName("Rohan Malhotra")
                        .addPhone("9999999999")
                        .addEmail("rohan@mail.com");

                    	Contact contact = contactService.createContact(builder);

                    	System.out.println("Contact created successfully.");
                    	System.out.println("Contact ID: " + contact.getId());
						break;

                    case 5:

                        System.out.print("Enter Contact ID: ");
                        String idInput = sc.nextLine();

                        UUID contactId = UUID.fromString(idInput);

                        Optional<Contact> contactOpt =
                                contactService.getContact(contactId);

                        if (contactOpt.isPresent()) {

                            ContactView view =
                                    new MaskEmailDecorator(
                                            new UpperCaseNameDecorator(
                                                    new BaseContactView(contactOpt.get())
                                            )
                                    );

                            System.out.println("\n=== CONTACT DETAILS ===");
                            System.out.println(view.display());

                        } else {

                            System.out.println("Contact not found.");

                        }

                        break;
                    
                    default:
                        System.out.println("Invalid option.");
                }

            } else {

                System.out.println("Invalid credentials.");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}