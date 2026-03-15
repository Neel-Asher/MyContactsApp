# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC6: Edit Contact

+ Enables a logged-in user to modify existing contact information such as name, phone numbers, or email addresses.
+ Uses setter methods with validation in the Contact class to ensure data integrity during updates.
+ Implements the Command Pattern to encapsulate contact edit operations as command objects.
+ Introduces EditContactCommand to perform modifications while keeping logic decoupled from the UI layer.
+ Applies the Memento Pattern to preserve the previous state of a contact before any modification.
+ Uses a ContactMemento object to store snapshots of contact data for safe restoration.
+ Supports Undo and Redo functionality using a CommandHistory class with stack-based tracking.
+ Demonstrates deep copying and defensive copying when saving and restoring contact states.
+ Ensures state changes occur only after validation to prevent invalid contact updates.
+ Integrates seamlessly with UC1–UC5 so authenticated users can edit contacts while maintaining full history control.
