package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Coffee;
import models.Guitar;
import utils.CSVUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeService {
    //fields
    private static int nextId = 1;
    private ArrayList<Coffee> inventory = new ArrayList<Coffee>();

    public CoffeeService(){
        //loadData();
    }

    //methods
    public Coffee create(int expectedQty, double expectedPrice, int expectedSize, String expectedDrinkType, String expectedFlavor, Boolean expectedCream, Boolean expectedSugar) {
        Coffee createdCoffee = new Coffee(nextId++, expectedQty, expectedPrice, expectedSize, expectedDrinkType, expectedFlavor, expectedCream,
        expectedSugar);

        inventory.add(createdCoffee);
        return createdCoffee;
    }

    public Coffee findCoffee(int i) {
        for (Coffee c : inventory){
            if (c.getId() == i){
                return c;
            }
        }
        // if we make it here, then an object with that id wasn't in there
        return null;
    }


    public Coffee[] findAll() {
        Coffee[] invArray = new Coffee[inventory.size()];
        return inventory.toArray(invArray);
    }


    public Boolean delete(int i) {
        for (Coffee c : inventory){
            if (c.getId() == i){
                // we got him
                inventory.remove(c);
                return true;
            }
        }
        // if we make it here, then an object of that id wasn't in there
        return false;
    }

    public void writeDataToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/christian/Desktop/Coffee.json"), inventory);
    }

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("/Users/christian/Desktop/Coffee.json"), new TypeReference<ArrayList<Coffee>>(){ });
    }

    /*
    public void writeDataToFile() throws IOException {
        String csvFile = "/Users/christian/Desktop/Coffee.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Coffee c : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(c.getId()));
            list.add(c.getDrinkType());
            list.add(c.getFlavor());
            list.add(String.valueOf(c.getCream()));
            list.add(String.valueOf(c.getSugar()));
            list.add(String.valueOf(c.getSize()));
            list.add(String.valueOf(c.getPrice()));
            list.add(String.valueOf(c.getQty()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();
    }

    private void loadData(){
        // (1)
        String csvFile = "/Users/christian/Desktop/Coffee.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                String drinkType = beer[1];
                String flavor = beer[2];
                Boolean cream = Boolean.parseBoolean(beer[3]);
                Boolean sugar = Boolean.parseBoolean(beer[4]);
                int size = Integer.parseInt(beer[5]);
                Double price = Double.parseDouble(beer[6]);
                int qty = Integer.parseInt(beer[7]);

                // (5)
                inventory.add(new Coffee(id, qty, price, size, drinkType, flavor, cream, sugar));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

}
