package service;

import config.DatabaseHelper;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class DBService {
    private DatabaseHelper dbHelper;

    public DBService(){
        dbHelper=new DatabaseHelper();
    }

    public void  exportToDatabase(List<Map<String,Object>> listOfMaps,String tableName) throws SQLException,ClassNotFoundException {

        // Creating table in DB, the attributes/rows are equivalent to keys in the maps
        String query=createTableQuery(listOfMaps,tableName);
        // helper function from DBHelper class  to actually run the query
        dbHelper.executeDefinition(query);


        for(Map<String,Object> map: listOfMaps){
            Object[] values=map.values().toArray();
            dbHelper.executeManipulation(insertQuery(listOfMaps,tableName),values);
        }

    }


    public String createTableQuery(List<Map<String,Object>> listOfMaps,String tableName){
        if(listOfMaps==null||listOfMaps.isEmpty()){
            throw new IllegalArgumentException(" The provided map is empty. Nothing to process");
        }

        // getting the keys of the maps ; equivalent to column name
        List<String> keys=new ArrayList<>(listOfMaps.getFirst().keySet());

        //getting first row for type detection
        Map<String,Object> firstRow=listOfMaps.getFirst();

        // string builder to create query ; faster and efficient than array
        StringBuilder query =new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        query.append(tableName).append(" (");
        query.append(keys.getFirst().trim()).append(" INT AUTO_INCREMENT PRIMARY KEY");


        for(int i=1;i< keys.size();i++){
            String columnName=keys.get(i).trim();
            String type=detectType(firstRow.get(keys.get(i)));
            query.append(" ,").append(columnName).append(" ").append(type);
            }

        query.append(" )");

        return query.toString();
    }

    public String insertQuery(List<Map<String,Object>> listOfMaps,String tableName){
        Set<String> keys= listOfMaps.getFirst().keySet();
        int columnCount= keys.size();
        String attributes=String.join(",",keys);
        StringBuilder query=new StringBuilder("INSERT INTO ").append(tableName).append("( ");
        query.append(attributes).append(")").append(" VALUES").append(" (");
        String que="?,";
        query.append(que.repeat(columnCount-1)).append("?)");


        return query.toString();
    }




    public String detectType(Object value){
        if(value==null){
            return "VARCHAR(255)";
        }

        if(value instanceof Integer){
            return "INT";
        }else if(value instanceof Double || value instanceof Float){
            return "DECIMAL(10,2)";
        } else if (value instanceof Boolean) {
            return "BOOLEAN";
        }else if(value instanceof LocalDate ){
            return "DATE";
        }else{
            return "VARCHAR(255)";
        }


    }


}
