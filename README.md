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
