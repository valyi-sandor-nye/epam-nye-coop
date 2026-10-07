Example of composition (has-a relationship) in Java and interfaces over inheritance.
This example intentionally breaks the SOLID principles:
- The Helper class still breaks Single Responsibility Principle (SRP) by having multiple responsibilities.
- The Helper class still breaks the Interface Segregation Principle (ISP) by forcing clients to depend on methods they do not use.
