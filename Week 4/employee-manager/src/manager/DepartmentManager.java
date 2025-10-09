package manager;

import config.DatabaseConfig;
import model.DepartmentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentManager {
    private Connection connection;

    public DepartmentManager(){
        try{
            connection= DatabaseConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public DepartmentModel createDepartmentModel(int departmentId, String name, String description){
        return new DepartmentModel(departmentId, name, description);
    }

    public Boolean addDepartment(DepartmentModel department){
        if(connection==null){
            System.out.println(" Error connecting to database");
            return null;
        }

        String insertQuery="INSERT INTO departments(department_id,department_name,description)"+
                            "VALUES (?,?,?)";
        try{
            PreparedStatement insertStatement= connection.prepareStatement(insertQuery);
            insertStatement.setInt(1,department.getDepartmentId());
            insertStatement.setString(2,department.getName());
            insertStatement.setString(3, department.getDescription());

            return insertStatement.executeUpdate()>0;

        } catch (SQLException e) {
            System.out.println(" Error while adding department "+e.getMessage());
            return null;
        }
    }

    public Boolean deleteDepartment(int  deptId){
        if(connection==null){
            System.out.println("Could not connect to database");
            return null;
        }

        String deleteQuery=" DELETE FROM departments WHERE department_id=?";
        try{
            PreparedStatement deleteStatement=connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, deptId);

            return deleteStatement.executeUpdate()>0;

        } catch (SQLException e) {
            System.out.println("Error deleting the required department"+e.getMessage());
            return null;
        }
    }
}
