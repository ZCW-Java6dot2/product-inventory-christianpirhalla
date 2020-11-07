import io.Console;
import models.Coffee;
import services.CoffeeService;
import services.GuitarService;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class App {

    private CoffeeService coffeeService = new CoffeeService();
    private GuitarService guitarService = new GuitarService();
    private Console console = new Console();

    public CoffeeService getCoffeeService(){
        return coffeeService;
    }


    public static void main(String args[]){
        App application = new App();
        application.init();
    }

    public void init(){
        //application logic here
        // call methods to take user input and interface with services

        console.printWelcome();


    }

    public void createProduct(){
        String productType = console.getStringInput("What type of product would you like to create? (Coffee/Guitar?)");
            if (productType.equalsIgnoreCase("Coffee")){
                int qty = console.getIntegerInput("Enter Quantity");
                double price = console.getDoubleInput("Enter Price");
                int size = console.getIntegerInput("Enter Size");
                String drinkType = console.getStringInput("Enter drink type");
                String flavor = console.getStringInput("Enter flavor");
                boolean cream = Boolean.parseBoolean(console.getStringInput("Cream? (true/false)"));
                boolean sugar = Boolean.parseBoolean(console.getStringInput("Sugar? (true/false)"));
                coffeeService.create(qty, price, size, drinkType, flavor, cream, sugar);
            }

            if (productType.equalsIgnoreCase("guitar")){
                int qty = console.getIntegerInput("Enter Quantity");
                double price = console.getDoubleInput("Enter Price");
                String brand = console.getStringInput("Enter Brand");
                int strings = console.getIntegerInput("Enter number of strings");
                String color = console.getStringInput("Enter Color");
                boolean pickups = Boolean.parseBoolean(console.getStringInput("Active pickups? (true/false)"));
                guitarService.create(qty, price, brand, strings, color, pickups);
            }

    }

    public void getProductInfo(){
        String productType = console.getStringInput("What type of product are you searching for?(Coffee/Guitar)");
        if (productType.equalsIgnoreCase("coffee")){
            int idToFind = console.getIntegerInput("Please enter the product id");
            Coffee foundCoffee = coffeeService.findCoffee(idToFind);
            if (foundCoffee == null) {
                System.out.println("Sorry, no product with that id exists.");
            }
            System.out.println(foundCoffee);
        }
    }

    public void updateProduct(){
        System.out.println("update");
    }

    public void deleteProduct(){
        System.out.println("delete");
    }

    public void getReports(){
        System.out.println("get reports");
    }

    public void exit(){
        System.out.println("exit");
    }

    }

