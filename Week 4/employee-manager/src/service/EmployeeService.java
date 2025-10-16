package service;

import config.DatabaseHelper;
import model.DepartmentModel;
import model.EmployeeModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    private DatabaseHelper databaseHelper;



    public EmployeeService(){
        this.databaseHelper=new DatabaseHelper();

    }



    public boolean createEmployeeTable() throws SQLException, ClassNotFoundException {
        String query= "CREATE TABLE IF NOT EXISTS employees ("
                        + "employee_id INT PRIMARY KEY , "
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
    public  Boolean addEmployee(EmployeeModel employee) throws SQLException, ClassNotFoundException {
        String query=" INSERT INTO employees(employee_id,department_id,name,email,phone,dob,hire_date,position)"+
                        "VALUES(?,?,?,?,?,?,?,?)";

        int rowChanged=databaseHelper.executeManipulation(query,employee.getEmployeeId(),employee.getDepartmentId(),employee.getName(),employee.getEmail(),
                        employee.getPhone(),employee.getDob(),employee.getHireDate(),employee.getPostion());

        return rowChanged>0;

    }


    public Boolean deleteEmployee(int employeeId) throws SQLException, ClassNotFoundException {
        String query=" DELETE FROM employees WHERE employee_id=?";

        int rowChanged=databaseHelper.executeManipulation(query,employeeId);

        return rowChanged>0;
    }

    public List<EmployeeModel> selectAllEmployees() throws SQLException,ClassNotFoundException{
        String query="SELECT * from employees";

        List<EmployeeModel> employeeList =new ArrayList<>();
        List<Map<String,Object>> employeeMap =databaseHelper.executeSelection(query);

        for(Map<String,Object> map: employeeMap){
           EmployeeModel employee =new EmployeeModel();
           employee.setEmployeeId((Integer)map.get("employee_id") );
           employee.setDepartmentId((Integer)map.get("department_id"));
           employee.setName(map.get("name").toString());
           employee.setEmail(map.get("email").toString());
           employee.setPhone(map.get("phone").toString());
           employee.setDob((LocalDate) map.get("dob"));
           employee.setHireDate((LocalDate) map.get("hire_date"));
           employee.setPostion(map.get("position").toString());

            employeeList.add(employee);
        }

        return employeeList;
    }



}
