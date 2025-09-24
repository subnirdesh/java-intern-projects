package util;

import model.ExpenseModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExpenseReaderUtil {


    public static ArrayList<ExpenseModel> readExpense(String filename)  {
        ArrayList<ExpenseModel> expenses = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader(filename))){
            String expenseLine=reader.readLine(); // reading header to escape it

            expenseLine=reader.readLine();
            while(expenseLine!=null){
                 String[] line= expenseLine.split(",");

                 // unpacking the array to an expense model
                int expenseId= Integer.parseInt(line[0].trim());
                String name=line[1].trim();
                double amount=Double.parseDouble(line[2]);
                String category=line[3].trim();
                String via=line[4].trim();
                LocalDate date= LocalDate.parse(line[5].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                 // Creating ExpenseModel Instance
                ExpenseModel expenseModel=new ExpenseModel(expenseId,name,amount,category,via,date);
                expenses.add(expenseModel);

                expenseLine=reader.readLine();
            }


        }catch(IOException e){
            System.out.println(" File is not found");
        }

        return expenses;
    }
}
