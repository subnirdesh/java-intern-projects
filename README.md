# Expense I/O

Expense I/O is a simple command-line application for tracking personal expenses. It allows users to add new expenses and view a list of all their recorded expenses. Each user's expense data is stored in a separate text file.

## Features

*   **Add Expenses:** Users can add new expenses by providing details such as an expense ID, name, amount, category, payment method (via), and date.
*   **View Expenses:** Users can view a list of all their previously entered expenses, displayed in a clear and organized table format.
*   **User-Specific Storage:** Each user's expenses are saved in a dedicated text file, ensuring data privacy and organization.
*   **Duplicate ID Check:** The application prevents the entry of duplicate expense IDs for the same user.

## Project Structure

The project is organized into the following packages:

*   **`manager`:** Contains the `ExpenseManager` class, which handles the business logic of the application, such as checking for duplicate expense IDs and displaying expenses.
*   **`model`:** Contains the `ExpenseModel` class, which represents the data structure for a single expense.
*   **`util`:** Contains utility classes for handling file I/O (`ExpenseReaderUtil`, `ExpenseWriterUtil`) and user input (`UserInputUtil`).
*   **`view`:** Contains the `ExpenseioApp` class, which is the main entry point of the application and handles user interaction.
