package util;

import model.ExpenseModel;

import java.io.*;


public class ExpenseWriterUtil {

    public static void writeExpense(ExpenseModel expenseModel,String username){
        String fileName=username+".txt";
        File file=new File(fileName);

        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName,true))){
            if(!file.exists()||file.length()==0 ){
                writer.write("Expense Id,Name,Amount,Category,Via,Date");
                writer.newLine();
            }

            writer.write(expenseModel.toString());
            writer.newLine();

        }catch (IOException e){
            System.out.println("An unexpected error occured");
        }
    }


}

