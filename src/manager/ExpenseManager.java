package manager;

import model.ExpenseModel;
import util.ExpenseReaderUtil;


import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private final List<ExpenseModel> expenseList;


    public ExpenseManager(){ this.expenseList=new ArrayList<>();}


    public boolean isDuplicateExpenseId(int expenseId,String username) {
        String fileName=username+".txt";
        File file =new File(fileName);
        if(file.exists()&& file.length()>0) {
            ArrayList<ExpenseModel> expenseList = ExpenseReaderUtil.readExpense(fileName);
            for (ExpenseModel expense : expenseList) {
                if (expense.getExpenseId() == expenseId) {
                    return true;
                }
            }
        }

        return false;
    }


    public void showExpense(List<ExpenseModel> expenseList){
        System.out.printf("%-5s | %-20s | %-15s |%-15s | %-15s | %-10s%n",
                "ID", "Name", "Amount","Category", "Via", "Date");
            for(ExpenseModel expenseModel:expenseList){
                System.out.println(expenseModel.toTableString());
        }
    }
}
