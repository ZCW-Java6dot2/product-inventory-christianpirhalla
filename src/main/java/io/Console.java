package io;
import java.util.Scanner;

public class Console {
    public static void printWelcome(){
        System.out.println(""+
                "***************************************************" +
                "|           Welcome and Bem-vindo                 |" +
                "|                    to                           |" +
                "|     The Guitar & Coffee Shop Inventory Manager  |" +
                "***************************************************" );
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
        int userInput = scanner.nextInt();
        return userInput;
    }

    public double getDoubleInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        double userInput = scanner.nextDouble();
        return userInput;
    }

}
