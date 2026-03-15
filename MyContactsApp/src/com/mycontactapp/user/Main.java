package com.mycontactapp.user;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import com.mycontactapp.contact.builder.ContactBuilder;
import com.mycontactapp.contact.bulk.BulkOperationService;
import com.mycontactapp.contact.bulk.ExportService;
import com.mycontactapp.contact.composite.ContactGroup;
import com.mycontactapp.contact.composite.SingleContact;
import com.mycontactapp.contact.filter.CompositeFilter;
import com.mycontactapp.contact.filter.ContactFilter;
import com.mycontactapp.contact.filter.FilterService;
import com.mycontactapp.contact.filter.FrequentContactFilter;
import com.mycontactapp.contact.filter.TagFilter;
import com.mycontactapp.contact.model.Contact;
import com.mycontactapp.contact.search.ContactSearchService;
import com.mycontactapp.contact.search.CriteriaChain;
import com.mycontactapp.contact.search.NameCriteria;
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
        
        BulkOperationService bulkService = new BulkOperationService();
        
        ContactSearchService searchService = new ContactSearchService();
        
        FilterService filterService = new FilterService();	

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
                System.out.println("6. Edit Contact");
                System.out.println("7. Delete Contact");
                System.out.println("8. Bulk Delete");
                System.out.println("9. Search Contacts");
                System.out.println("10. Advanced Search");

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
                    
                    case 6:
                    	
                    	System.out.print("Enter Contact ID: ");

                    	UUID id = UUID.fromString(sc.nextLine());

                    	Optional<Contact> contactOpt1 =
                    	        contactService.getContact(id);

                    	if(contactOpt1.isPresent()){

                    	    System.out.print("Enter New Name: ");

                    	    String newName = sc.nextLine();

                    	    contactService.editContact(contactOpt1.get(),newName);

                    	    System.out.println("Contact updated.");
                    	}
                    	break;
                    
                    case 7:

                        System.out.print("Enter Contact ID: ");

                        UUID deleteId = UUID.fromString(sc.nextLine());

                        System.out.print("Are you sure? (yes/no): ");

                        String confirm = sc.nextLine();

                        if(confirm.equalsIgnoreCase("yes")){

                            contactService.deleteContact(deleteId);

                            System.out.println("Contact deleted.");

                        } else {

                            System.out.println("Deletion cancelled.");

                        }

                        break;
                    
                    case 8:
                    	
                    	List<Contact> contacts = contactService.getAllContacts();

                    	ContactGroup group = new ContactGroup();

                    	contacts.forEach(c -> group.add(new SingleContact(c)));

                    	bulkService.bulkDelete(group);

                    	System.out.println("Bulk delete completed.");
                    	break;
                    
                    case 9:
                    	
                    	CriteriaChain chain = new CriteriaChain();

                    	chain.addCriteria(new NameCriteria("rohan"));

                    	List<Contact> results = searchService.search(chain);

                    	results.forEach(c ->
                    	        System.out.println(c.getName()+" "+c.getId())
                    	);
                    	break;
                    
                    case 10:
                    	
                    	ContactFilter filter = new TagFilter("work");

                    	List<Contact> results1 =
                    	        filterService.filter(filter);

                    	results1.forEach(c -> System.out.println(c.getName()));
                    	
                    	CompositeFilter filter1 = new CompositeFilter();

                    	filter1.addFilter(new TagFilter("work"));
                    	filter1.addFilter(new FrequentContactFilter(5));
                    	
                    	List<Contact> results2 =
                    	        filterService.filterAndSort(
                    	                filter1,
                    	                Comparator.comparing(Contact::getName)
                    	        );
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