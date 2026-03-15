# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC9: Search Contacts

+ Enables a logged-in user to search contacts using different attributes such as name, phone number, email address, or tags.
+ Implements a SearchCriteria interface with multiple concrete implementations for different search filters.
+ Applies the Specification Pattern to encapsulate individual search conditions in separate classes.
+ Supports combining multiple search criteria to build complex queries (e.g., name + tag).
+ Uses the Chain of Responsibility pattern through a CriteriaChain to process multiple filters sequentially.
+ Utilizes the Java Predicate interface to represent flexible filtering logic.
+ Implements Java Streams API filtering to efficiently process and search through contact collections.
+ Supports case-insensitive comparison for user-friendly searching.
+ Demonstrates regex-style pattern matching for partial matches in names, emails, and phone numbers.
+ Integrates seamlessly with UC1–UC8 while preserving contact lifecycle management, bulk operations, and edit history.
