package util;

import java.util.Scanner;

public class UserInputUtil {
    static Scanner input = new Scanner(System.in);

    public static String getStringInput(String inputName) {
        System.out.println("Enter " + inputName + " : ");
        return input.nextLine();
    }

    public static int getIntInput(String inputName) {
        int value = 0;
        while (true) {
            try {
                System.out.println("Enter " + inputName + " : ");
                value = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter only  numeric " + inputName);
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
                System.out.println("Please enter numeric value only");
            }
        }

        return value;
    }
}
