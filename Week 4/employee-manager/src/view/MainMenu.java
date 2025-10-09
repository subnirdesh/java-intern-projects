package view;

import com.sun.tools.javac.Main;
import manager.DepartmentManager;
import manager.EmployeeManager;
import model.DepartmentModel;
import model.EmployeeModel;
import util.UserInputUtil;

import java.time.LocalDate;

public class MainMenu {

    public static void main(String[] args) {

        MainMenu newMenu =new MainMenu();
        EmployeeManager employeeManager =new EmployeeManager();
        DepartmentManager departmentManager=new DepartmentManager();


        EmployeeModel employee= newMenu.inputEmployeeFields();
        boolean isEmployeeAdded = employeeManager.addEmployee(employee);
        if(isEmployeeAdded){
            System.out.println("Employee added successfully");
        }

        DepartmentModel department =newMenu.inputDepartmentField();
        boolean isDepartmentAdded= departmentManager.addDepartment(department);
        if(isDepartmentAdded){
            System.out.println("Department Added Successfully ");
        }

        employeeManager.deleteEmployee(UserInputUtil.getIntInput("Employee ID"));


    }


    public EmployeeModel inputEmployeeFields(){

        int employeeId= UserInputUtil.getIntInput("Employee ID");
        int departmentId= UserInputUtil.getIntInput("Department ID");
        String name= UserInputUtil.getStringInput("Employee Name");
        String phone= UserInputUtil.getStringInput("Phone");
        String email= UserInputUtil.getStringInput("Email");
        LocalDate dob=UserInputUtil.getDateInput(" Date of Birth");
        LocalDate hireDate=UserInputUtil.getDateInput(" Hire Date ");
        String postion=UserInputUtil.getStringInput("Postion");

        return new EmployeeModel(employeeId,departmentId,name,email, phone, dob,hireDate,postion);

    }

    public DepartmentModel inputDepartmentField(){

        int departmentId=UserInputUtil.getIntInput("Department ID");
        String  departmentName=UserInputUtil.getStringInput("Department Name");
        String description =UserInputUtil.getStringInput("Description");

        return new DepartmentModel(departmentId,departmentName,description);
    }

}
