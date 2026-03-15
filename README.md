# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC7: Delete Contact

+ Enables a logged-in user to remove a contact from their contact list with a confirmation step.
+ Implements soft delete by marking contacts as deleted instead of permanently removing them.
+ Uses lifecycle management principles to control creation, modification, and deletion of contact entities.
+ Applies the Observer Pattern to notify system components when a contact is deleted.
+ Introduces observer implementations such as ContactDeletionLogger and NotificationService for system reactions.
+ Ensures related components can respond to deletion events without tight coupling.
+ Demonstrates exception handling with a custom ContactNotFoundException when invalid IDs are provided.
+ Updates repository queries to exclude soft-deleted contacts from normal operations.
+ Includes a confirmation prompt to prevent accidental contact deletion.
+ Integrates seamlessly with UC1–UC6 while preserving edit history, authentication, and contact management features.
