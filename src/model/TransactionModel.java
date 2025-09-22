package model;

import java.time.LocalDate;
import java.util.Arrays;

public class TransactionModel {
    private int transactionId;
    private int bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String user;



    public TransactionModel(int transactionId, int bookId, LocalDate returnDate,String user) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.borrowDate = LocalDate.now();
        this.returnDate = returnDate;
        this.user=user;
    }



    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("%-5d| %-5d | %-15s | %-15s | %-20s",
                transactionId, bookId, borrowDate, returnDate,user);
    }


}
