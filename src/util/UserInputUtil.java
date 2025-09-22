package util;

import java.util.Scanner;

public class UserInputUtil {

    private UserInputUtil() {

    }

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

    public static String[] getAuthor() {

        int numAuthor = 0;
        while (true) {
            try {
                System.out.println(" How many authors?");
                numAuthor = Integer.parseInt(input.nextLine());


                String[] authors = new String[numAuthor];

                for (int i = 0; i < numAuthor; i++) {
                    System.out.println("Enter Author " + (i + 1) + " Name");
                    authors[i] = input.nextLine().trim();
                }

                return authors;

            } catch (NumberFormatException e) {
                System.out.println("Please enter numeric value ");
            }
        }
    }
}
