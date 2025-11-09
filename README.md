# Student Record Manager

This is a simple command-line application for managing student records.

## How to Compile and Run

To compile the Java code, use the following command:

```bash
javac src/StudentManager.java src/StudentModel.java
```

To run the application, use the following command:

```bash
java -cp src StudentManager
```

## Features

* **Add Student:** Add a new student to the record.
* **Update Student:** Update an existing student's information.
* **Delete Student:** Remove a student from the record.
* **Display All Students:** Show a list of all students.
* **Display Specific Student:** Show the details of a specific student.

## Usage Example

```java
public static void main(String[] args) {
    StudentManager manager = new StudentManager();

    manager.addStudent(1, "Sanjay Sharma", 20, "sanjay.sharma@email.com", "Computer Science");
    manager.addStudent(2, "Anita Karki", 19, "anita.karki@email.com", "Mathematics");
    manager.addStudent(3, "Ramesh Thapa", 21, "ramesh.thapa@email.com", "Physics");
    manager.displayAllStudents();
    manager.displaySpecificStudent(1);
}
```
