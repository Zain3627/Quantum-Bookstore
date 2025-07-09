# Quantum Bookstore
Quantum Bookstore is a Java-based project that simulates a bookstore inventory management system. It supports adding, searching, purchasing, and removing books, with different types of books such as paper books, eBooks, and showcase books.  
## Features
### Singleton Design Pattern: Ensures a single instance of the InventoryManagement class.
### Book Types:
1- PaperBook: Includes stock management and shipping functionality.
2- EBook: Includes file type and email delivery functionality.
3- ShowcaseBook: Not for sale.
### Inventory Operations:
1- Add, search, and remove books.
2- Purchase books with error handling for invalid operations.
3- Remove outdated books based on publication year.
## Project Structure
src/InventoryManagement.java: Singleton class for managing the bookstore inventory.
src/Book.java: Base class for all book types.
src/PaperBook.java, src/EBook.java, src/ShowcaseBook.java: Subclasses of Book with specific features.
src/QuantumBookstoreTest.java: Test class to demonstrate the functionality of the project.
## How to Run
Clone the repository.
Open the project in IntelliJ IDEA or any Java IDE.
Run the QuantumBookstoreTest class to execute the test cases.
