# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC4: Create Contact

+ Enables a logged-in user to create and store contacts in the application.
+ Supports multiple contact types using a class hierarchy (Contact, PersonContact, OrganizationContact).
+ Demonstrates composition where a Contact contains multiple PhoneNumber and EmailAddress objects.
+ Uses the Builder Pattern (ContactBuilder) to construct complex contact objects step-by-step.
+ Applies the Factory Pattern (ContactFactory) to instantiate the appropriate contact type.
+ Stores contacts using a Singleton ContactRepository backed by a HashMap.
+ Supports multiple phone numbers and email addresses using Java List collections.
+ Generates a unique identifier (UUID) for every contact created in the system.
+ Records the creation timestamp using LocalDateTime for tracking contact history.
+ Integrates with UC1–UC3 architecture so that only authenticated users can manage contacts.
