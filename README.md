# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC12: Apply Tags to Contacts

+ Enables a logged-in user to assign one or multiple tags to contacts for better categorization and organization.
+ Introduces a ContactTag association class to represent the relationship between Contact and Tag.
+ Maintains a many-to-many relationship, where one contact can have multiple tags and a tag can belong to multiple contacts.
+ Implements bidirectional relationship management so that tag assignments remain consistent across the system.
+ Uses Set collections to ensure that a contact cannot have duplicate tags.
+ Provides add and remove tag operations through ContactTagService to centralize tag assignment logic.
+ Applies the Observer Pattern (TagObserver, TagSubject) to notify UI or system components whenever tags are assigned or removed.
+ Supports real-time updates such as logging or UI refresh when a tag change occurs.
+ Integrates with UC9 (Search) and UC10 (Advanced Filtering) so contacts can be searched or filtered based on assigned tags.
+ Fully compatible with UC1–UC11, enhancing the contact organization system without breaking existing functionality.
