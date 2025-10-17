package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInputUtil {
    static Scanner input = new Scanner(System.in);

    public static String getStringInput(String inputName) {
        String value=null;
        while(true){
            System.out.println("Enter " + inputName + " : ");
            value= input.nextLine();
             if(value!=null && !value.isBlank()){
                 return value;
             }
             else{
                 System.out.println(" Please do not leave the field empty\n");
             }
        }
    }

    public static int getIntInput(String inputName) {
        int value = 0;
        while (true) {
            try {
                System.out.println("Enter " + inputName + " : ");
                value = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter only  numeric " + inputName+"\n");
            }
        }
        return value;

    }

    public static double getDoubleInput(String inputName){
        double value=0;
        while(true){
            try{
                System.out.println("Enter "+inputName+" : ");
                value=Double.parseDouble(input.nextLine());
                break;
            }catch(NumberFormatException e){
                System.out.println("Please enter numeric value only \n");
            }
        }

        return value;
    }

    public static LocalDate getDateInput(String inputName){
        LocalDate value=null;
        while(true){
            try{
                System.out.println("Enter "+ inputName+" (yyyy/MM/dd)");
                value= LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                break;
            } catch(DateTimeParseException e){
                System.out.println("Please enter date in correct format yyyy/MM/dd  \n");}
        }
        return value;
    }





}
