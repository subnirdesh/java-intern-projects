package config;

import java.sql.*;

public class DatabaseHelper {
    private  Connection connection;

    public DatabaseHelper(){
        try{
            connection=DatabaseConfig.makeConnection();
        } catch (SQLException| ClassNotFoundException e) {
            System.out.println(" Could make any connection "+e.getMessage());
        }
    }

    public Connection ensureConnection() throws SQLException,ClassNotFoundException{
        if(connection==null || connection.isClosed()){
            connection=DatabaseConfig.makeConnection();
        }

        return connection;
    }

    public boolean executeDefinition(String query) throws SQLException, ClassNotFoundException {
        try (Connection conn = ensureConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.execute();
            return true;
        }
    }

    public int executeManipulation (String query, Object... params) throws SQLException,ClassNotFoundException{
        try(Connection conn = ensureConnection();
            PreparedStatement stmt=conn.prepareStatement(query)){
            for(int i=0;i<params.length;i++){
                stmt.setObject(i+1,params[i]);
              }
            return stmt.executeUpdate();
        }
    }





}





