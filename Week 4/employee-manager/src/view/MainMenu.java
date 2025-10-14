package view;

import config.DatabaseHelper;
import service.DepartmentService;
import model.DepartmentModel;
import model.EmployeeModel;
import service.EmployeeService;
import util.UserInputUtil;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainMenu {


    public static void main(String[] args) {
        MainMenu menu= new MainMenu();
        DepartmentService departmentService =new DepartmentService();
        EmployeeService employeeService=new EmployeeService();

        // Creating Department Table
        boolean isDepartmentTable= departmentService.createDepartmentTable();
        System.out.println(isDepartmentTable);

        //Creating Employee Table
        boolean isEmployeeTable=employeeService.createEmployeeTable();
        System.out.println(isEmployeeTable);


    }









    }



