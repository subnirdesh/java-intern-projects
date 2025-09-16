package view;

import service.BookManager;

import java.util.Scanner;

public class LibraryApp {
    private BookManager bookManager;

    public LibraryApp(){
        bookManager= new BookManager();
    }

    public static void main(String[] args) {
        Scanner myObj=new Scanner(System.in);

        // Prompting for Book ID
        System.out.println(" Enter BookId: ");
        int  bookId= myObj.nextInt();

        //Prompting for book name
        System.out.println("Enter book name:");
        String bookName=myObj.nextLine();

        // Prompting for ISBN
        System.out.println("Enter ISBN: ");
        String ISBN= myObj.nextLine();

        //Prompting for author
        System.out.println("Enter author name: ");
        String author=myObj.nextLine();

        //Prompting for genre
        System.out.println("Enter book's genre :");
        String genre=myObj.nextLine();

        //Prompting for totalCopies
        System.out.println("Enter no of total Copies for the book: ");
        int noOfCopies=myObj.nextInt();






    }

}
