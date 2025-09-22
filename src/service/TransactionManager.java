package service;


import model.TransactionModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private final List<TransactionModel> transactionList;

    public TransactionManager(){
        this.transactionList=new ArrayList<>();
    }

    public void addtransaction( int bookId, int transactionId,LocalDate returnDate,String user){
        TransactionModel  newTransaction= new TransactionModel(transactionId,bookId,returnDate,user);
        transactionList.add(newTransaction);
    }

    public void viewAllTransaction(){
        System.out.printf("%-15s | %-15s | %-20s | %-20s | %-20s%n",
                "Transaction Id", "Book Id", "Borrow Date", "Return Date", "User");

        for (TransactionModel transaction : transactionList) {
            System.out.println(transaction);
        }
    }

    public void viewSpecificTransaction(int transactionId){
        for (TransactionModel transaction : transactionList){
            if(transactionId==transaction.getTransactionId()){
                System.out.printf("%-15s | %-15s | %-20s | %-20s | %-20s%n",
                        "Transaction Id", "Book Id", "Borrow Date", "Return Date", "User");
                System.out.println(transaction);
            }
        }
    }
}
