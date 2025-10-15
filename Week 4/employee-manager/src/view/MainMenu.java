package view;

import com.sun.tools.javac.Main;
import controller.MainController;
import model.DepartmentModel;
import model.EmployeeModel;
import service.DepartmentService;
import service.EmployeeService;
import util.CSVWriter;
import util.UserInputUtil;
import util.ValidationUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MainMenu {
    private DepartmentService departmentService;
    private EmployeeService employeeService;
    private MainController mainController;


    public MainMenu(){
     this.departmentService= new DepartmentService();
    this.employeeService=new EmployeeService();
    this.mainController= new MainController();
    }


     static void main(String[] args) {



        }


        public void menu(){
            // 1. Writing department in CSV file
            DepartmentModel departmentModel=mainController.getDepartmentFields();
            mainController.writeDepartment(departmentModel);

            // 2. Writing employee in CSV file
            EmployeeModel employeeModel =mainController.getEmployeeFields();
            mainController.writeEmployee(employeeModel);
    }
}




























