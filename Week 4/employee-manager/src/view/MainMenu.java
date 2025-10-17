package view;

import com.sun.tools.javac.Main;
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
import java.util.Arrays;
import java.util.List;


public class MainMenu {
    private DepartmentService departmentService;
    private EmployeeService employeeService;


    public MainMenu(){
     this.departmentService= new DepartmentService();
    this.employeeService=new EmployeeService();

    }


     static void main(String[] args) {



        }



}




























