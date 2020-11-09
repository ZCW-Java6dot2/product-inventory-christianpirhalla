package io;
import java.util.Scanner;

public class Console {

    public static void printWelcome(){
        System.out.println(""+
                "***************************************************" + "\n" +
                "|           Welcome and Bem-vindo                 |" + "\n" +
                "|                    to                           |" + "\n" +
                "|     The Guitar & Coffee Shop Inventory Manager  |" + "\n" +
                "***************************************************" );
    }

    public void printInvalidProductError(){
        System.out.println("You have entered an invalid product type.");
    }

    public void printInvalidCommandError(){
        System.out.println("You have entered an invalid command.");
    }

    public String getStringInput(String prompt) { // use this to get boolean input too
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public int getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        //this will prevent the user from crashing the program by entering something other than an int OR from entering a negative number
        while (!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Please enter a positive integer.");
        }
        int userInput = scanner.nextInt();
        return userInput;
    }

    public double getDoubleInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        while (!scanner.hasNextDouble()){
            scanner.next();
            System.out.println("Please enter a valid price. You do not need to include $.");
        }
        double userInput = scanner.nextDouble();
        return userInput;
    }

}
