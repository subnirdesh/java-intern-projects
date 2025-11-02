package controller;


import service.DBService;
import util.CSVReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class MainController {
    private DBService dbService;
    private CSVReader csvReader;

    public MainController() {
        this.dbService = new DBService();
        this.csvReader = new CSVReader();
    }


    public List<Map<String, Object>> readFile(String fileName) {
        List<Map<String, Object>> listOfMaps = new ArrayList<>();

        try {
            listOfMaps = csvReader.readCSV(fileName);
        } catch (IOException e) {
            System.out.println("Error while reading CSV file: " + e.getMessage());
            e.printStackTrace();
        }

        return listOfMaps;
    }

    public boolean exportToDB(List<Map<String,Object>> listOfMaps,String tableName){
        boolean isCreated=true;
        try{
            dbService.exportToDatabase(listOfMaps,tableName);


        } catch (SQLException|ClassNotFoundException e) {
            System.out.println("Error while creating exporting to Database" +e.getMessage());
            e.printStackTrace();
            isCreated=false;
        }
        return isCreated;
    }






}




