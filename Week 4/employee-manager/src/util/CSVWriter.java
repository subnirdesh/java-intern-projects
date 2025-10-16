package util;

import model.DepartmentModel;
import model.EmployeeModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

    public static void  writeDepartment(DepartmentModel department ) throws IOException{
        String fileName="department.csv";
        File file=new File(fileName); //this creates a reference to a file
        boolean makeHeader=!file.exists() || file.length()==0;

        try(BufferedWriter writer =new BufferedWriter(new FileWriter(fileName,true))){
            if(makeHeader){
                writer.write("department_id, name, description");
                writer.newLine();
            }

            writer.write(department.toString());
            writer.newLine();

        }
    }

    public static void  writeEmployee(EmployeeModel employee ) throws IOException{
        String fileName="employees.csv";
        File file=new File(fileName);
        boolean makeHeader=!file.exists() || file.length()==0;

        try(BufferedWriter writer =new BufferedWriter(new FileWriter(fileName,true))){
            if(makeHeader){
                writer.write("employee_id,department_id,name,email,phone,dob,hire_date,position");
                writer.newLine();
            }

            writer.write(employee.toString());
            writer.newLine();

        }
    }

}
