# Library Management System

A simple command-line application for managing a library's book inventory and borrowing system. This project demonstrates fundamental concepts of core Java.

## Features

- **Add Books:** Add new books to the library with details like Book ID, name, ISBN, author, genre, and the number of copies.
- **View Books:** View a list of all books in the library or search for a specific book by its ID.
- **Borrow Books:** Manage book borrowing by recording transaction details, including transaction ID, book ID, return date, and user name.
- **Return Books:** Process book returns and update the number of available copies.

## Core Java Concepts Used

- **Object-Oriented Programming (OOP):** The project is structured using classes and objects, demonstrating encapsulation by bundling data (attributes) and methods that operate on the data into single units (e.g., `BookModel`, `TransactionModel`).
- **Collections Framework:** `ArrayList` is used to manage the collections of books and transactions, showcasing dynamic data structures.
- **Exception Handling:** The application gracefully handles invalid user input using `try-catch` blocks to prevent crashes (e.g., `NumberFormatException`).
- **Console Input/Output:** The `java.util.Scanner` class is used to read user input from the command line, and `System.out.println` is used for output.
- **Date and Time API:** `java.time.LocalDate` is used for handling dates, such as the return date for a borrowed book.
- **Modular Design:** The codebase is organized into different packages (`model`, `service`, `util`, `view`) to separate concerns and improve maintainability.
