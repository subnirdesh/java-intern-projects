package model;

import java.time.LocalDate;

public class EmployeeModel {
    private int employeeId;
    private int departmentId;
    private String name;
    private String email;
    private String phone;
    private LocalDate dob;
    private LocalDate hireDate;
    private String postion;

    public EmployeeModel(int employeeId, int departmentId, String name, String email, String phone, LocalDate dob, LocalDate hireDate, String postion) {
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.hireDate = hireDate;
        this.postion = postion;
    }
    public EmployeeModel(){

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    @Override
    public String toString() {
        return String.format("| %-12d | %-14d | %-20s | %-25s | %-15s | %-12s | %-12s | %-20s |",
                employeeId,
                departmentId,
                name,
                email,
                phone,
                dob,
                hireDate,
                postion);
    }

    public static String getTableHeader() {
        return String.format("| %-12s | %-14s | %-20s | %-25s | %-15s | %-12s | %-12s | %-20s |",
                "Employee ID", "Department ID", "Name", "Email", "Phone",
                "DOB", "Hire Date", "Position") +
                "\n" + "-".repeat(165);
    }


}
