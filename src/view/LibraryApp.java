package view;

import service.BookManager;
import service.TransactionManager;
import util.UserInputUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp  {


    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        BookManager bookManager = new BookManager();
        TransactionManager transactionManager = new TransactionManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, Welcome to Library Management System");
        boolean running = true;
        while (running) {
            System.out.println("_____________________________");
            System.out.println(" \n\nInput 1 to add Books");
            System.out.println("Input 2 to view books");
            System.out.println("Input 3 to borrow books");
            System.out.println("Input 4 to return books");
            System.out.println("Input 5 to exit");
            System.out.print("Enter your choice: ");


            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        System.out.println("Enter the number of books you want to add");
                        int bookCount = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println("Enter details for book " + (i + 1));
                            app.addBook(bookManager);
                            System.out.println("Book " + (i + 1) + " Added Successfully\n");
                        }
                        break;


                    case 2:
                        System.out.println(" Do you want to view all books or specific book?");
                        System.out.println("Enter 1 to view all books \n Enter 2 to view specific book");
                        int viewChoice = Integer.parseInt(scanner.nextLine());
                        if (viewChoice == 1) {
                            bookManager.viewAllBook();
                        } else {
                            int bookId = UserInputUtil.getIntInput("Book Id");
                            bookManager.viewSpecificBook(bookId);
                        }
                        break;


                    case 3:
                        System.out.println("Choose book from the list ");
                        bookManager.viewAllBook();
                        app.borrowBook(transactionManager, bookManager);
                        System.out.println(" Book borrowed successfully");
                        break;


                    case 4:
                        System.out.println("Enter Book Id");
                        int bookId = Integer.parseInt(scanner.nextLine());
                        bookManager.addCopy(bookId, 1);
                        break;


                    case 5:
                        System.out.println("Exiting.........");
                        running = false;
                        break;


                    default:
                        System.out.println("Please enter values between 1-5");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter number between 1-5");
            }
        }
    }



         private void addBook(BookManager bookManager) {

            // Prompting for Book ID
             while(true) {


                 int bookId = UserInputUtil.getIntInput("Book ID");
                 if (bookManager.isDuplicateBookId(bookId)) {
                     System.out.println("Book Id already exists");
                     continue;
                 }


                 //Prompting for book name
                 String bookName = UserInputUtil.getStringInput("Book Name ");

                 // Prompting for ISBN
                 String ISBN = UserInputUtil.getStringInput("ISBN");

                 //Prompting for author
                 String[] author = UserInputUtil.getAuthor();

                 //Prompting for genre
                 String genre = UserInputUtil.getStringInput("Genre");

                 //Prompting for totalCopies
                 int noOfCopies = UserInputUtil.getIntInput(" Total no. of Copies");
                 if(noOfCopies<=0){
                     System.out.println("Number of copiees must be greater than 0 ");
                     continue;
                 }

                 bookManager.addBook(bookId, bookName, ISBN, author, genre, noOfCopies);
                 break;
             }
        }


        private void borrowBook(TransactionManager transactionManager, BookManager bookManager){

            //Prompting for BookId
            int bookId = UserInputUtil.getIntInput("Book ID");

            //Prompting for transction id
            int transactionId=UserInputUtil.getIntInput(" Transaction Id");

            // Prompting for returnDate
            String stringReturnDate=UserInputUtil.getStringInput(" Return Date(YYYY-mm-dd) ");
            LocalDate returnDate=LocalDate.parse(stringReturnDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            //Prompting for user name
            String userName=UserInputUtil.getStringInput("User Name ");

            transactionManager.addtransaction(transactionId,bookId,returnDate,userName);
            bookManager.removeCopy(bookId,1);
    }




    }




