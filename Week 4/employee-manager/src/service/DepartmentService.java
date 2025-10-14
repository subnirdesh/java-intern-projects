package service;


import config.DatabaseHelper;
import model.DepartmentModel;
import java.sql.SQLException;

public class DepartmentService {
   private DatabaseHelper databaseHelper;


   public DepartmentService(){
       this.databaseHelper=new DatabaseHelper();
   }


    public Boolean createDepartmentTable() throws SQLException,ClassNotFoundException{
      String query="CREATE TABLE IF NOT EXISTS departments(" +
                    "department_id  int primary key," +
                    "department_name varchar(50) not null,"+
                    "description varchar(100))";


          if (databaseHelper.executeDefintion(query)) {
              System.out.println(" Department created successfully");
              return true;

          }

          return false;
      }




    public Boolean addDepartment(DepartmentModel department)  throws SQLException,ClassNotFoundException{
       String query = "INSERT INTO departments(department_id,department_name,description)"+
                        "VALUES (?,?,?)";

       int rowChanged= databaseHelper.executeManipulation(query,department.getDepartmentId(),department.getName(),department.getDescription());

        return rowChanged > 0;
    }


    public boolean deleteDepartment(int departmentId) throws SQLException,ClassNotFoundException{
        String query= "DELETE FROM departments WHERE department_id=?";

        int rowChanged=databaseHelper.executeManipulation(query,departmentId);

        return rowChanged>0;
    }
}









