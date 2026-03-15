# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC1: User Registration

+ Enables new users to create an account using email, password, first name, last name, and user type.
+ Implements encapsulation through the abstract User model with private fields and getters.
+ Uses the Builder Pattern (UserBuilder) to construct user objects step-by-step.
+ Applies the Factory Pattern (UserFactory) to create FreeUser or PremiumUser instances.
+ Performs input validation using the Validation class with regex-based email checks.
+ Secures passwords using SHA-256 hashing (PasswordHashing) before storage.
+ Persists users in memory using a Singleton UserRepository backed by a HashMap.
+ Prevents duplicate registrations by checking existing emails in the repository.
+ Implements custom exception handling (InvalidUserDataException) for validation and business errors.
+ Demonstrates clean layered architecture: Model → Builder/Factory → Service → Repository.

## UC2: User Authentication & Login

+ Allows registered users to log in using their email and password.
+ Introduces an AuthenticationStrategy interface to support multiple authentication mechanisms.
+ Implements Strategy Pattern with BasicAuthStrategy and extensible OAuthStrategy.
+ Validates login credentials by hashing the input password and comparing with stored hash.
+ Uses Optional<User> to safely represent successful or failed authentication attempts.
+ Introduces a Singleton SessionManager to maintain the current logged-in user session.
+ Encapsulates authentication logic inside the AuthenticationService layer.
+ Keeps UC1 registration logic unchanged, ensuring backward compatibility.
+ Demonstrates polymorphism by switching authentication methods via strategy injection.
+ Establishes the foundation for future secured features like profile management and contact access.

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

## UC10: Advanced Filtering

+ Enables a logged-in user to apply advanced filters on contacts based on attributes such as tags, date added, and frequency of interaction.
+ Introduces a ContactFilter interface hierarchy where each filter encapsulates its own filtering logic.
+ Implements the Strategy Pattern to allow different filtering algorithms (tag-based, date-based, frequency-based).
+ Applies the Composite Pattern through CompositeFilter to combine multiple filters into a single filtering operation.
+ Supports multi-level filtering pipelines where several conditions can be applied sequentially.
+ Utilizes the Java Streams API to perform efficient filtering operations over contact collections.
+ Demonstrates use of functional interfaces (Predicate) to represent filtering behavior.
+ Uses Comparator implementations to sort filtered results (e.g., by name or date added).
+ Enables flexible queries such as contacts tagged “work” added after a certain date and frequently contacted.
+ Integrates seamlessly with UC1–UC9 while maintaining search capabilities, bulk operations, and contact lifecycle management.

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
