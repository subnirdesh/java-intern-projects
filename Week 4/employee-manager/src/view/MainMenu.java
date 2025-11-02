package view;


import controller.MainController;
import java.util.List;
import java.util.Map;


public class MainMenu {
    private  MainController mainController;

    public MainMenu(){
        this.mainController= new MainController();
    }




     static void main(String[] args) {
        MainMenu menu=new MainMenu();
        boolean isSuccessful=menu.execute();
        if(isSuccessful){
            System.out.println(" Successfully exported to DB");
        }else{
            System.out.println("Export Failed" );
        }
     }

     public  boolean execute(){
        List<Map<String,Object>> listofMaps=mainController.readFile("data.csv");
       return  mainController.exportToDB(listofMaps,"employees");
     }



}































