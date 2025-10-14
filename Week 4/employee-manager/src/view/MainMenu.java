package view;

import config.DatabaseHelper;
import service.DepartmentService;
import model.DepartmentModel;
import model.EmployeeModel;
import service.EmployeeService;
import util.CSVReader;
import util.CSVWriter;
import java.io.IOException;
import java.time.LocalDate;


public class MainMenu {


    public static void main(String[] args) {
        MainMenu menu= new MainMenu();
        DepartmentService departmentService =new DepartmentService();
        EmployeeService employeeService=new EmployeeService();



        // 1. Writing department in CSV file
        // 2. Writing employee in CSV file
        //3. Reading department from CSV file
        // 4. Reading employee from CSV file
        //5. Writing  department rows in database
        //6. Writing employee rows in database

    }

    public void writeDepartment(int departmentId, String name, String description){
        DepartmentModel department =new DepartmentModel(departmentId,name,description);
        try{
            CSVWriter.writeDepartment(department);
            System.out.println( name + " : Department written successfully ");

        } catch (IOException e) {
            System.out.println(" Error while writing in CSV file: "+e.getMessage());
        }
    }

    public void writeEmployee(int employeeId, int departmentId, String name, String email, String phone, LocalDate dob, LocalDate hireDate, String postion){
        EmployeeModel employee =new EmployeeModel(employeeId,departmentId,name,email,phone,dob,hireDate,postion);
        try{
            CSVWriter.writeEmployee(employee);
            System.out.println( name+ " : Employee written successfully ");
        } catch (IOException e) {
            System.out.println(" Error while writing in CSV file: "+e.getMessage());
        }


        }
    }













    }



