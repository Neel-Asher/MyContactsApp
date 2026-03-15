# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC11: Create & Manage Tags

+ Enables a logged-in user to create and manage custom tags such as Family, Work, Friends to organize contacts efficiently.
+ Introduces a Tag class with validation rules to ensure tag names are meaningful and consistent.
+ Implements a many-to-many relationship where a contact can have multiple tags and a tag can belong to multiple contacts.
+ Uses the Flyweight Pattern (TagFactory) to reuse tag instances and avoid duplicate objects in memory.
+ Stores tags using a Set collection to guarantee uniqueness and prevent duplicate tag assignments.
+ Implements equals() and hashCode() in the Tag class to support proper comparison and storage in collections.
+ Adds TagRepository and TagService layers to manage tag creation and retrieval in a centralized manner.
+ Supports optional predefined tags through the use of EnumSet for commonly used categories.
+ Integrates seamlessly with UC9 (Search) and UC10 (Filtering) so users can search and filter contacts based on tags.
+ Maintains full compatibility with UC1–UC10 while enhancing contact organization and categorization capabilities.
