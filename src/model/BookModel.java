package model;

public class BookModel {
    private int bookId;
    private String bookName;
    private String ISBN;
    private String author;
    private String genre;
    private int totalCopies;


    public BookModel(int bookId, String bookName, String ISBN, String author, String genre, int totalCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    @Override
    public String toString() {
        return String.format("%-5d | %-20s | %-15s | %-15s | %-10s | %-5d",
                bookId, bookName, ISBN, author, genre, totalCopies);
    }
}
