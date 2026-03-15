# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC8: Bulk Operations

+ Enables a logged-in user to perform operations on multiple contacts simultaneously, such as delete, tag, or export.
+ Uses collection-based processing to handle batches of contacts efficiently.
+ Implements the Composite Pattern to treat individual contacts and groups of contacts uniformly.
+ Introduces ContactComponent, SingleContact, and ContactGroup to represent leaf and composite structures.
+ Supports bulk delete operations by marking multiple contacts as deleted in a single action.
+ Allows bulk tagging of contacts to categorize or group them for easier management.
+ Provides a contact export feature to display or output multiple contacts at once.
+ Utilizes the Java Streams API for efficient batch processing and iteration over collections.
+ Demonstrates lambda expressions and method references for concise functional-style operations.
+ Integrates seamlessly with UC1–UC7 while maintaining authentication, editing history, and observer-based notifications.
