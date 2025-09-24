package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ExpenseModel {
    private int expenseId;
    private String name;
    private double amount;
    private String category; // Utilities, Groceries, Food and Beverage, Transportation, Misc
    private String via; // Card, Fonepay, Cash
    private LocalDate date;

    public ExpenseModel(int expenseId, String name, double amount,String category, String via, LocalDate date) {
        this.expenseId = expenseId;
        this.name = name;
        this.amount=amount;
        this.category = category;
        this.via = via;
        this.date = date;
    }

    public ExpenseModel(){

    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return expenseId + "," + name + "," +amount+","+ category+ "," + via +","+date;
    }

    public String toTableString(){
        return String.format("%-5d | %-20s | %-15.2f|%-15s | %-15s | %-10s ",
                expenseId, name, amount,category,via, date.toString());
    }
}
