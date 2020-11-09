import io.Console;
import models.Coffee;
import models.Guitar;
import services.CoffeeService;
import services.GuitarService;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class App {

    private boolean isOn = true;

    private CoffeeService coffeeService = new CoffeeService();
    private GuitarService guitarService = new GuitarService();
    private Console console = new Console();

    public App() {
    }

    public CoffeeService getCoffeeService(){
        return coffeeService;
    }


    public static void main(String args[]) throws IOException {
        App application = new App();
        application.init();
    }

    public void init() throws IOException {
        //application logic here
        // call methods to take user input and interface with services
        console.printWelcome();
        while(isOn){
            String action = console.getStringInput("What would you like to do? (Create/Read/Update/Delete/Reports/Load data/Save data/Exit)");
            switch (action.toLowerCase()){
                case "create":
                    createProduct();
                    break;

                case "read":
                    getProductInfo();
                    break;

                case "update":
                    updateProduct();
                    break;

                case "delete":
                    deleteProduct();
                    break;

                case "reports":
                    getReports();
                    break;

                case "save data":
                    guitarService.writeDataToFile();
                    coffeeService.writeDataToFile();
                    break;

                case "load data":
                    guitarService.loadData();
                    coffeeService.loadData();
                    break;

                case "exit":
                    exit();
                    break;

                default:
                    console.printInvalidCommandError();
                    break;

            }
        }


    }

    /** This searches for a coffee by id and returns that coffee if it exists. Otherwise, it returns null. **/
    public Coffee verifyCoffeeExists(){
        int idToFind = console.getIntegerInput("Please enter the product id");
        Coffee foundCoffee = coffeeService.findCoffee(idToFind);
        if (foundCoffee == null) {
            System.out.println("Sorry, no product with that id exists.");
        }
        return foundCoffee;
    }

    public Guitar verifyGuitarExists(){
        int idToFind = console.getIntegerInput("Please enter the product id");
        Guitar foundGuitar = guitarService.find(idToFind);
        if (foundGuitar == null) {
            System.out.println("Sorry, no product with that id exists.");
        }
        return foundGuitar;
    }

    //
    // C R E A T E
    //

    /** Prompts the user for input to create a new Coffee **/
    public void createCoffee(){
        int qty = console.getIntegerInput("Enter Quantity");
        double price = console.getDoubleInput("Enter Price");
        int size = console.getIntegerInput("Enter Size");
        String drinkType = console.getStringInput("Enter drink type");
        String flavor = console.getStringInput("Enter flavor");
        boolean cream = Boolean.parseBoolean(console.getStringInput("Cream? (true/false)"));
        boolean sugar = Boolean.parseBoolean(console.getStringInput("Sugar? (true/false)"));
        Coffee created = coffeeService.create(qty, price, size, drinkType, flavor, cream, sugar);
        System.out.println("Coffee created. ID: " + created.getId());
    }

    /** Prompts the user for input to create a new Guitar **/
    public void createGuitar(){
        int qty = console.getIntegerInput("Enter Quantity");
        double price = console.getDoubleInput("Enter Price");
        String brand = console.getStringInput("Enter Brand");
        int strings = console.getIntegerInput("Enter number of strings");
        String color = console.getStringInput("Enter Color");
        boolean pickups = Boolean.parseBoolean(console.getStringInput("Active pickups? (true/false)"));
        Guitar created = guitarService.create(qty, price, brand, strings, color, pickups);
        System.out.println("Guitar created. ID: " + created.getId());
    }

    public void createProduct(){
        String productType = console.getStringInput("What type of product would you like to create? (Coffee/Guitar?)");
            switch (productType.toLowerCase()){
                case "coffee":
                    createCoffee();
                    break;

                case "guitar":
                    createGuitar();
                    break;

                default:
                    console.printInvalidProductError();
                    break;
            }
    }

    //
    // R E A D
    //

    public void readCoffeeInfo(){
        Coffee foundCoffee = verifyCoffeeExists();
        System.out.println(foundCoffee);
    }

    public void readGuitarInfo(){
        Guitar foundGuitar = verifyGuitarExists();
        System.out.println(foundGuitar);
    }

    public void getProductInfo(){
        String productType = console.getStringInput("What type of product are you searching for?(Coffee/Guitar)");
        if (productType.equalsIgnoreCase("coffee")){
            readCoffeeInfo();
        }
        else if (productType.equalsIgnoreCase("guitar")){
            readGuitarInfo();
        }
        else
            console.printInvalidProductError();
    }


    //
    // U P D A T E
    //


    public void updateCoffee(){
        Coffee coffeeToUpdate = verifyCoffeeExists();
        System.out.println("Current product info: " + coffeeToUpdate.toString());

        int qty = console.getIntegerInput("Enter Quantity");
        double price = console.getDoubleInput("Enter Price");
        int size = console.getIntegerInput("Enter Size");
        String drinkType = console.getStringInput("Enter drink type");
        String flavor = console.getStringInput("Enter flavor");
        boolean cream = Boolean.parseBoolean(console.getStringInput("Cream? (true/false)"));
        boolean sugar = Boolean.parseBoolean(console.getStringInput("Sugar? (true/false)"));

        coffeeToUpdate.setQty(qty);
        coffeeToUpdate.setPrice(price);
        coffeeToUpdate.setSize(size);
        coffeeToUpdate.setDrinkType(drinkType);
        coffeeToUpdate.setFlavor(flavor);
        coffeeToUpdate.setCream(cream);
        coffeeToUpdate.setSugar(sugar);
        System.out.println("Product updated.");
    }

    public void updateGuitar(){
        Guitar guitarToUpdate = verifyGuitarExists();
        System.out.println("Current product info: " + guitarToUpdate.toString());

        int qty = console.getIntegerInput("Enter Quantity");
        double price = console.getDoubleInput("Enter Price");
        String brand = console.getStringInput("Enter Brand");
        int strings = console.getIntegerInput("Enter number of strings");
        String color = console.getStringInput("Enter Color");
        boolean pickups = Boolean.parseBoolean(console.getStringInput("Active pickups? (true/false)"));

        guitarToUpdate.setQty(qty);
        guitarToUpdate.setPrice(price);
        guitarToUpdate.setBrand(brand);
        guitarToUpdate.setNumStrings(strings);
        guitarToUpdate.setColor(color);
        guitarToUpdate.setHasActivePickups(pickups);
        System.out.println("Product updated");
    }

    public void updateProduct(){
        String productToUpdate = console.getStringInput("What type of product do you want to update?");
        if (productToUpdate.equalsIgnoreCase("coffee")){
            updateCoffee();
        }
        else if (productToUpdate.equalsIgnoreCase("guitar")){
            updateGuitar();
        }
        else
            console.printInvalidProductError();
    }

    //
    // D E L E T E
    //

    public void deleteCoffee(){
        Coffee coffeeToDelete = verifyCoffeeExists();
        if (coffeeToDelete != null) {
            int deleteId = coffeeToDelete.getId();
            coffeeService.delete(deleteId);
            System.out.println("Product deleted.");
        }
        else {
            System.out.println("Product cannot be deleted since it doesn't exist.");
        }
    }

    public void deleteGuitar(){
        Guitar guitarToDelete = verifyGuitarExists();
        if (guitarToDelete != null) {
            int deleteId = guitarToDelete.getId();
            guitarService.delete(deleteId);
            System.out.println("Product deleted.");
        }
        else {
            System.out.println("Product cannot be deleted since it doesn't exist.");
        }
    }

    public void deleteProduct(){
        String productToDelete = console.getStringInput("What type of product do you want to delete?");
        if (productToDelete.equalsIgnoreCase("coffee")){
            deleteCoffee();
        }
        else if (productToDelete.equalsIgnoreCase("guitar")){
            deleteGuitar();
        }
        else
            console.printInvalidProductError();
    }

    //
    // R E P O R T S
    //
    public void lowInventoryReport(String productType){
        switch (productType) {
            case "guitar":
                System.out.println("The following items have a quantity less than 3: ");
                for (Guitar g : guitarService.findAll()) {
                    if (g.getQty() < 3) {
                        System.out.println(g);
                    }
                }
                break;

            case "coffee":
                System.out.println("The following items have a quantity less than 3: ");
                for (Coffee c : coffeeService.findAll()) {
                    if (c.getQty() < 3) {
                        System.out.println(c);
                    }
                }
                break;
        }

    }

    public void surplusInventoryReport(String productType){
        switch (productType) {
            case "guitar":
                System.out.println("The following items have a quantity greater than 10: ");
                for (Guitar g : guitarService.findAll()) {
                    if (g.getQty() > 10) {
                        System.out.println(g);
                    }
                }
                break;

            case "coffee":
                System.out.println("The following items have a quantity greater than 10: ");
                for (Coffee c : coffeeService.findAll()) {
                    if (c.getQty() > 10) {
                        System.out.println(c);
                    }
                }
                break;
        }

    }

    public void inventoryByBrandReport(){
        String brand = console.getStringInput("What brand would you like to search by?");
        System.out.println("The following products are of brand " + brand);
        for (Guitar g : guitarService.findAll()){
            if (g.getBrand().toLowerCase().equals(brand.toLowerCase())){
                System.out.println(g);
            }
        }
    }

    public void getGuitarReports(){
        String reportType = console.getStringInput("What type of report would you like to generate? \n"
                +"(Low inventory/Surplus inventory/Inventory by brand)");
        switch (reportType.toLowerCase()){
            case "low inventory":
                lowInventoryReport("guitar");
                break;

            case "surplus inventory":
                surplusInventoryReport("guitar");
                break;

            case "inventory by brand":
                inventoryByBrandReport();
                break;

            default:
                console.printInvalidCommandError();
                break;
        }

    }

    public void getCoffeeReports(){
        String reportType = console.getStringInput("What type of report would you like to generate? \n"
                +"(Low inventory/Surplus inventory)");
        switch (reportType.toLowerCase()){
            case "low inventory":
                lowInventoryReport("coffee");
                break;

            case "surplus inventory":
                surplusInventoryReport("coffee");
                break;

            default:
                console.printInvalidCommandError();
                break;
        }

    }

    public void getReports() throws IOException {
        String productType = console.getStringInput("What type of product do you want to generate reports on?");
            switch (productType.toLowerCase()){
                case "guitar":
                    getGuitarReports();
                    break;

                case "coffee":
                    getCoffeeReports();
                    break;

                default:
                    console.printInvalidProductError();
            }
    }

    public void exit(){
        isOn = false;
    }

    }

