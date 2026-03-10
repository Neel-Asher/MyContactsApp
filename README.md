# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC3: User Profile Management

+ Enables a logged-in user to manage their profile information after successful authentication.
+ Supports operations such as updating name, changing password, and managing user preferences.
+ Follows JavaBeans conventions by providing getter and setter methods in the User class.
+ Applies the Command Pattern to encapsulate profile update operations as separate command objects.
+ Introduces command classes like UpdateNameCommand, ChangePasswordCommand, and UpdatePreferencesCommand.
+ Uses a ProfileService as the command invoker to execute profile-related actions.
+ Ensures password updates follow security best practices by validating and hashing the new password.
+ Stores user preferences using a key–value mapping structure for extensibility.
+ Maintains clean separation of concerns between model, command, and service layers.
+ Integrates seamlessly with UC1 (Registration) and UC2 (Authentication) without altering existing functionality.
