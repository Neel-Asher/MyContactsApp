# MyContactsApp
MyContacts App is a Java-based, console-driven application implemented use-case wise to demonstrate object-oriented design, design patterns, and core Java concepts through a contact management system.

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
