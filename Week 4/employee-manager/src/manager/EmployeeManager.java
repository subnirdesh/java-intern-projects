package manager;

import config.DatabaseConfig;
import model.EmployeeModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeManager {
    private Connection connection;


    public EmployeeManager(){
        try{
            connection= DatabaseConfig.getDbConnection();
        } catch (SQLException  | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public EmployeeModel createEmployeeModel(int employeeId, int departmentId, String name, String email, String phone, LocalDate dob, LocalDate hireDate, String postion){
        return new EmployeeModel(employeeId, departmentId, name,  email, phone, dob, hireDate,postion);
    }


    public  Boolean addEmployee(EmployeeModel employee){
        if(connection==null){
            System.out.println("Could not connect to database");
            return null;
        }

        String addQuery= "INSERT INTO employees (employee_id,department_id,name,email,phone,dob,hire_date,position)"+
                        "VALUES(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement addStatement=connection.prepareStatement(addQuery);
            addStatement.setInt(1,employee.getEmployeeId());
            addStatement.setInt(2,employee.getDepartmentId());
            addStatement.setString(3, employee.getName());
            addStatement.setString(4,employee.getEmail());
            addStatement.setString(5,employee.getPhone());
            addStatement.setDate(6, Date.valueOf(employee.getDob()));
            addStatement.setDate(7,Date.valueOf(employee.getHireDate()));
            addStatement.setString(8, employee.getPostion());

            return addStatement.executeUpdate()>0;


        } catch (SQLException e) {
            System.out.println("Error while adding employee"+ e.getMessage());
            return null;
        }
    }

    public Boolean deleteEmployee(int employeeId){
        if(connection==null){
            System.out.println("Could not connect to database");
            return null;
        }

        String deleteQuery=" DELETE FROM employees WHERE employee_id=?";
        try{
            PreparedStatement deleteStatement=connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1,employeeId);

            return deleteStatement.executeUpdate()>0;

        } catch (SQLException e) {
            System.out.println("Error deleting the required employee"+e.getMessage());
            return null;
        }
    }


}
