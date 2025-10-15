package config;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public  boolean executeDefintion(String query) throws SQLException,ClassNotFoundException{
        try(PreparedStatement stmt = ensureConnection().prepareStatement(query)){
            stmt.execute();
            return true;
        }
    }

    public int executeManipulation (String query, Object... params) throws SQLException,ClassNotFoundException{
        try(PreparedStatement stmt=ensureConnection().prepareStatement(query)){
            for(int i=0;i<params.length;i++){
                stmt.setObject(i+1,params[i]);
              }
            return stmt.executeUpdate();
        }
    }


    public List<Map<String,Object>> executeSelection(String query,Object... params) throws SQLException,ClassNotFoundException{
        List<Map<String,Object>> results=new ArrayList<>();

        try(PreparedStatement stmt=ensureConnection().prepareStatement(query)) {
            for(int i=0;i<params.length;i++){
                stmt.setObject(i+1,params[i]);
            }
            ResultSet rs=stmt.executeQuery();

            ResultSetMetaData metaData=rs.getMetaData();
            int columnCount=metaData.getColumnCount();

            while(rs.next()){
                Map<String,Object> row =new HashMap<>();
                for(int i=0;i<columnCount;i++){
                    row.put(metaData.getColumnName(i),rs.getObject(i));
                }
                results.add(row);
            }
            return results;
        }
    }


}





