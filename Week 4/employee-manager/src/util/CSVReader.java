package util;

import model.DepartmentModel;
import model.EmployeeModel;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<DepartmentModel> readDepartments() throws IOException {
        List<DepartmentModel> departmentList=new ArrayList<DepartmentModel>() ;
        String fileName ="departments.csv";
         try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
             reader.readLine(); //escaping header

             String expenseLine = reader.readLine();
             while(expenseLine!=null){
                 String[] line=expenseLine.split(",");

                 // unpacking array
                 int departmentId=Integer.parseInt(line[0]);
                 String name=line[1].trim();
                 String description=line[2].trim();

                 DepartmentModel department =new DepartmentModel(departmentId,name,description);
                 departmentList.add(department);

                 expenseLine=reader.readLine();

             }
         }

         return departmentList;
    }

    public List<EmployeeModel> readEmployees() throws IOException{
        List<EmployeeModel> employeeList=new ArrayList<EmployeeModel>() ;
        String fileName ="employees.csv";
        try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            reader.readLine(); //escaping header

            String expenseLine = reader.readLine();
            while(expenseLine!=null){
                String[] line=expenseLine.split(",");

                // unpacking array
                int employeeId=Integer.parseInt(line[0].trim());
                int departmentId=Integer.parseInt(line[1].trim());
                String name=line[2].trim();
                String email=line[3].trim();
                String phone=line[4].trim();
                LocalDate dob=LocalDate.parse(line[5].trim(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                LocalDate hireDate=LocalDate.parse(line[6].trim(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                String postion=line[7].trim();

                EmployeeModel employee=new EmployeeModel(employeeId,departmentId,name,email,phone,dob,hireDate,postion);
                employeeList.add(employee);

                expenseLine=reader.readLine();

            }
        }

        return employeeList;

    }










}
