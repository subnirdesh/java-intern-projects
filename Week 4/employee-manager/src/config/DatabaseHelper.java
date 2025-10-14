package config;

import model.DepartmentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public  boolean executeDefintion(String query){
        try(PreparedStatement stmt = ensureConnection().prepareStatement(query)){
            stmt.execute();
            return true;

        }catch(SQLException |ClassNotFoundException e){
            System.out.println(" Error occured "+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public int executeManipulation(String query, Object... params){
        try(PreparedStatement stmt=ensureConnection().prepareStatement(query)){
            for(int i=0;i<params.length;i++){
                stmt.setObject(i+1,params[i]);
              }
            return stmt.executeUpdate();

        } catch (SQLException| ClassNotFoundException e) {
            System.out.println("An error occured "+ e.getMessage());
            e.printStackTrace();
            return  -1;
        }
    }



    }


