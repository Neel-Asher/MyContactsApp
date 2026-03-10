# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

## UC3: User Profile Management

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
