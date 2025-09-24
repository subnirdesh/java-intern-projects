package view;

import manager.ExpenseManager;
import model.ExpenseModel;
import util.ExpenseReaderUtil;
import util.ExpenseWriterUtil;
import util.UserInputUtil;

import javax.imageio.IIOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ExpenseioApp {

    public static void main(String[] args) {

        ExpenseioApp app=new ExpenseioApp();
        Scanner scanner = new Scanner(System.in);
        ExpenseManager  expenseManager=new ExpenseManager();

        String userName =null;
        boolean askUserName=true;
        while(askUserName) {
            try{
                userName = UserInputUtil.getStringInput("username ");
                if (userName == null || userName.isEmpty()) {
                    throw new IllegalArgumentException(" Username cannot be empty");
                } else {
                    askUserName=false;
                }
            }catch(IllegalArgumentException e) {
                System.out.println(" Username cannot be empty.");
            }
        }


        while(true){
            System.out.println("Enter 1 to add expense");
            System.out.println("Enter 2 to view expense");
            System.out.println("Enter 3 to exit");
            System.out.println(" Enter your choice: ");



            try {
                int userChoice = Integer.parseInt(scanner.nextLine().trim());


                switch(userChoice){

                    case 1:
                       ExpenseModel expenseModel=app.askExpense(expenseManager,userName);
                       ExpenseWriterUtil.writeExpense(expenseModel,userName);
                       break;

                    case 2:
                        expenseManager.showExpense(ExpenseReaderUtil.readExpense(userName+".txt"));
                        break;

                    case 3:
                        System.out.println("Exiting......");
                        return;

                    default:
                        System.out.println(" Please enter number between 1-3");
                        break;


                }


            } catch (NumberFormatException e) {
                System.out.println(" Please enter only numeric value");
                }
            }
    }


    public ExpenseModel askExpense(ExpenseManager expenseManager,String userName){
        ExpenseModel expenseModel=new ExpenseModel();
        boolean asking=true;
        while(asking){
            //Prompting for expense id
            int expenseId= UserInputUtil.getIntInput(" Expense ID");
            if(expenseManager.isDuplicateExpenseId(expenseId,userName)){
                System.out.println("Expense Id already exists ");
                continue;
            }


            expenseModel.setExpenseId(expenseId);

            // Prompting for name
            String name=UserInputUtil.getStringInput("Name of Expense ");
            expenseModel.setName(name);

            // Prompting for amount
            double amount= UserInputUtil.getDoubleInput("Amount ");
            expenseModel.setAmount(amount);



            //Prompting for category
            boolean askingForCategory=true;
            while(askingForCategory) {
                System.out.println("Enter 1 for Utilities \n Enter 2 for Groceries \n Enter 3 for Food and Beverages \n " +
                        "Enter 4 for Transportation \n Enter 5 for Miscellaneous ");
                int categoryInt = UserInputUtil.getIntInput(" Category Type");
                String category;
                switch (categoryInt) {
                    case 1:
                        category = "Utilities";
                        break;
                    case 2:
                        category = "Grocerires";
                        break;
                    case 3:
                        category = "Food and Beverages";
                        break;
                    case 4:
                        category = "Transportation";
                        break;
                    case 5:
                        category = "Misc";
                        break;
                    default:
                        System.out.println("Please enter values between 1-5 ");
                        continue;
                }
                expenseModel.setCategory(category);
                askingForCategory=false;
            }



            //Prompting for category
            boolean askingForVia=true;
            while(askingForVia) {

                System.out.println("Enter 1 for Card \n Enter 2 for Fonepay \n Enter 3 for Cash ");
                int viaInt = UserInputUtil.getIntInput(" Via Type");
                String via;
                switch (viaInt) {
                    case 1:
                        via = "Card";
                        break;
                    case 2:
                        via = "Fonepay";
                        break;
                    case 3:
                        via = "Cash";
                        break;
                    default:
                        System.out.println("Please enter values between 1-3 ");
                        continue;
                }
                expenseModel.setVia(via);
                askingForVia=false;
            }


            String dateString = UserInputUtil.getStringInput(" Date (yyyy-MM-DD) ");
            LocalDate date=LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            expenseModel.setDate(date);
            asking=false;

        }

        return expenseModel;

    }

}
