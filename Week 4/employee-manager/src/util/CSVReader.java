package util;

import model.DepartmentModel;
import model.EmployeeModel;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {

    public List<Map<String,Object>> readCSV(String filename) throws IOException,FileNotFoundException{
        List<Map<String,Object>> listOfMap=new ArrayList<>();

        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line=reader.readLine();
            String[] header=line.split(",");

            line=reader.readLine();
            while(line!=null){
                Map<String,Object> map=new HashMap<>();
                String[] record=line.split(",");
                for(int i =0;i< header.length&&  i <record.length;i++){
                    map.put(header[i].trim(),record[i].trim());
                }
                listOfMap.add(map);
            }
        }
        return listOfMap;
    }


}










