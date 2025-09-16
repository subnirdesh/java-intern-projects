package service;

import model.BookModel;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private  final List<BookModel> bookStore;


    public BookManager(){
        bookStore= new ArrayList<BookModel>();
    }

    /**
     *  Creates a BookModel instances and stores it in bookStore arraylist
     *
     * @param bookId
     * @param bookName
     * @param ISBN
     * @param author
     * @param genre
     * @param totalCopies
     */
    public void addBook(int bookId, String bookName, String ISBN, String author, String genre, int totalCopies){
        BookModel bookModel =new BookModel(bookId,bookName,ISBN,author,genre,totalCopies);
        bookStore.add(bookModel);
    }

    /**
     * Updates(increases)  the no of copies of a book
     *
     * @param bookId
     * @param noOfCopies
     */
    public void addCopy(int bookId, int noOfCopies){
        for( BookModel book: bookStore){
            if( book.getBookId()==bookId){
                book.setTotalCopies(book.getTotalCopies()+noOfCopies);
            }
            else{
                System.out.println(" Book not found");
            }
        }
    }

    /**
     * Updates(decreases) the no of copies of a book
     *
     * @param bookId
     * @param noOfCopies
     */
    public void removeCopy(int bookId, int noOfCopies){
        for( BookModel book: bookStore){
            if( book.getBookId()==bookId){
                book.setTotalCopies(book.getTotalCopies()-noOfCopies);
            }
            else{
                System.out.println(" Book not found");
            }
        }
    }

    /**
     * Deletes the book from the list
     *
     * @param bookId
     */
    public void removeBook(int bookId){
        for(BookModel book:bookStore){
            if(book.getBookId()==bookId){
                bookStore.remove(book);
            }
            else{
                System.out.println(" Book not found");
            }
        }
    }


    public void viewAllBook(){
        System.out.printf("%-5s | %-20s | %-15s | %-15s | %-10s | %-5s%n",
                "ID", "Name", "ISBN", "Author", "Genre", "Copies");
        for(BookModel book:bookStore){
            System.out.println(book);
        }
    }

    /**
     * Display the detail of the book based on provided bookId
     *
     * @param bookId
     */
     public  void viewSpecificBook(int bookId){
        for(BookModel book:bookStore){
            if(book.getBookId()==bookId){
                System.out.printf("%-5s | %-20s | %-15s | %-15s | %-10s | %-5s%n",
                        "ID", "Name", "ISBN", "Author", "Genre", "Copies");
                System.out.println(book);
            }
        }
     }





}
