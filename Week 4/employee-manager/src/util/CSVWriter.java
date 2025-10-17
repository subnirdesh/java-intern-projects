package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CSVWriter {

    public static void writeObject(List<Map<String, Object>> listOfMap) throws IOException {
        if(listOfMap==null||listOfMap.isEmpty()){
            throw new IllegalArgumentException(" List is empty. Nothing to write! ");
        }
        String fileName = "departments.csv";
        File file = new File(fileName);
        Set<String> keys= listOfMap.getFirst().keySet();
        boolean makeHeader = !file.exists() || file.length() == 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (makeHeader) {
                writer.write(String.join(",",keys));
                writer.newLine();
            }

            for(Map<String,Object> map: listOfMap ){
                List<String> values=new ArrayList<>();

                for(String key:keys){
                    Object value=map.get(key);
                    String safeString=(value==null) ? "": value.toString().replace(",","");
                    values.add(safeString);
                }
                writer.write(String.join(",",values));
            }
        }
    }
}
