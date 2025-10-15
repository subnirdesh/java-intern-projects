package util;


import model.DepartmentModel;
import model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {



    public  static boolean isDuplicateEmployee(ArrayList<EmployeeModel> employeeList,int employeeId){
        for(EmployeeModel employeeModel:employeeList){
            if(employeeId==employeeModel.getEmployeeId()){
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicatePhone(ArrayList<EmployeeModel> employeeList, String phone){
        for(EmployeeModel employeeModel:employeeList){
            if(phone.trim().equals(employeeModel.getPhone().trim())){
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicateEmail(ArrayList<EmployeeModel> employeeList,String email){
        for(EmployeeModel employeeModel:employeeList){
            if(email.trim().equals(employeeModel.getEmail().trim())){
                return true;
            }
        }
        return false;
    }

    public static boolean isInvalidDepartment(List<DepartmentModel> departmentList, int departmentId){
        for(DepartmentModel deptModel:departmentList){
            if(departmentId!=deptModel.getDepartmentId()){
                return true;
            }
        }
        return false;
    }







}
