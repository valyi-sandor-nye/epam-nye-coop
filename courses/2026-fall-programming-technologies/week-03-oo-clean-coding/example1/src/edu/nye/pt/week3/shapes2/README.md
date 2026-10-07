Example of composition (has-a relationship) in Java and interfaces over inheritance.
This example intentionally breaks the SOLID principles:
- The Helper class breaks Single Responsibility Principle (SRP) by having multiple responsibilities.
- The Helper class also breaks the Open/Closed Principle (OCP) by being closed for extension but open for modification.
- The Helper class breaks the Interface Segregation Principle (ISP) by forcing clients to depend on methods they do not use.
- The Rectangle, Triangle and Circle classes break the Dependency Inversion Principle (DIP) by depending on concrete implementations rather than abstractions.