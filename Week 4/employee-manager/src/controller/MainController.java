package controller;

import model.DepartmentModel;
import model.EmployeeModel;
import service.DepartmentService;
import util.CSVWriter;
import util.UserInputUtil;
import util.ValidationUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    public EmployeeModel getEmployeeFields(){

        //1. Employee Id
        int employeeId= UserInputUtil.getIntInput("Employee ID");

        // 2. DepartmentId
        int departmentId=UserInputUtil.getIntInput("Department ID");

        //3. Name
        String name=UserInputUtil.getStringInput("Name");

        //4. Phone
        String phone=UserInputUtil.getStringInput("Phone");

        //5. Email
        String email=UserInputUtil.getStringInput("Email");

        //6. Date of Birth
        LocalDate dob=UserInputUtil.getDateInput("Date of Birth");

        //7. Hire Date
        LocalDate hireDate=UserInputUtil.getDateInput(" Date of Hire");

        //8. Position
        String postion=UserInputUtil.getStringInput("Position");

        return new EmployeeModel(employeeId,departmentId,name,email,phone,dob,hireDate,postion);

    }

    public DepartmentModel getDepartmentFields(List<DepartmentModel> deptList) {

        while (true) {

            boolean isValidId = true;
            int departmentId = 0;
            while (isValidId) {
                departmentId = UserInputUtil.getIntInput("Department Id");
                if (!ValidationUtil.isInvalidDepartment(deptList, departmentId)) {
                    isValidId = false;
                }
            }


            //2. Department Name
            String name = UserInputUtil.getStringInput(" Department Name");

            //3. Description
            String description = UserInputUtil.getStringInput("Description");

            return new DepartmentModel(departmentId, name, description);

        }

        }


    public void writeDepartment(DepartmentModel department){
        try{
            CSVWriter.writeDepartment(department);
            System.out.println( department.getName() + " : Department written successfully ");

        } catch (IOException e) {
            System.out.println(" Error while writing in CSV file: "+e.getMessage());
        }
    }

    public void writeEmployee(EmployeeModel employee){
        try{
            CSVWriter.writeEmployee(employee);
            System.out.println( employee.getName()+ " : Employee written successfully ");
        } catch (IOException e) {
            System.out.println(" Error while writing in CSV file: "+e.getMessage());
        }
    }

    public List<DepartmentModel> readDepartments(DepartmentService deptService){
        List<DepartmentModel> deptList =new ArrayList<>();
        try{
            deptList= deptService.selectAllDepartment();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Error while reading in database: "+e.getMessage());
        }

        return deptList;
    }

}

