package service;

import config.DatabaseConfig;
import config.DatabaseHelper;
import model.EmployeeModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeService {
    private DatabaseHelper databaseHelper;



    public EmployeeService(){
        this.databaseHelper=new DatabaseHelper();

    }



    public boolean createEmployeeTable(){
        String query= "CREATE TABLE IF NOT EXISTS employees ("
                        + "employee_id INT PRIMARY KEY AUTO_INCREMENT, "
                        + "department_id INT, "
                        + "name VARCHAR(100) NOT NULL, "
                        + "email VARCHAR(100) UNIQUE, "
                        + "phone VARCHAR(20), "
                        + "dob DATE, "
                        + "hire_date DATE, "
                        + "position VARCHAR(50), "
                        + "CONSTRAINT fk_department "
                        + "FOREIGN KEY (department_id) REFERENCES departments(department_id) "
                        + ");";

        return databaseHelper.executeDefintion(query);

    }
    //String addQuery= "INSERT INTO employees (employee_id,department_id,name,email,phone,dob,hire_date,position)"+
    //"VALUES(?,?,?,?,?,?,?,?)";
    public  Boolean addEmployee(EmployeeModel employee){
        String query=" INSERT INTO employees(department_id,name,email,phone,dob,hire_date,position)"+
                        "VALUES(?,?,?,?,?,?,?)";

        int rowChanged=databaseHelper.executeManipulation(query,employee.getDepartmentId(),employee.getName(),employee.getEmail(),
                        employee.getPhone(),employee.getDob(),employee.getHireDate(),employee.getPostion());

        return rowChanged>0;

    }


    public Boolean deleteEmployee(int employeeId){
        String query=" DELETE FROM employees WHERE employee_id=?";

        int rowChanged=databaseHelper.executeManipulation(query,employeeId);

        return rowChanged>0;
    }



}
