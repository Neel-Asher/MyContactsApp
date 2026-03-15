# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC5: View Contact Details

+ Allows a logged-in user to view complete information of a specific contact stored in the system.
+ Retrieves contact data using the ContactService and ContactRepository layers.
+ Uses Optional<Contact> to safely handle cases where a contact may not exist.
+ Demonstrates getter methods in the Contact class to access contact attributes.
+ Implements custom display formatting using a display() method instead of exposing raw data.
+ Applies the Decorator Pattern to enhance contact display formatting dynamically.
+ Uses decorators such as UpperCaseNameDecorator and MaskEmailDecorator to modify output behavior.
+ Supports flexible formatting extensions without modifying existing contact classes.
+ Demonstrates string formatting and structured console output for readable contact details.
+ Integrates seamlessly with UC1–UC4 so only authenticated users can view stored contacts.
