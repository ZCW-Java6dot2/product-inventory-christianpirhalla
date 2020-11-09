package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Guitar;
import utils.CSVUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuitarService {
    private static int nextId = 1;

    private ArrayList<Guitar> inventory = new ArrayList<Guitar>();

    public GuitarService() {

    }

    public Guitar create(int expectedQty, Double expectedPrice, String expectedBrand, int expectedNumStrings, String expectedColor, Boolean expectedHasActivePickups) {

        Guitar createdGuitar = new Guitar(nextId++, expectedQty, expectedPrice, expectedBrand, expectedNumStrings,
                expectedColor, expectedHasActivePickups);

        inventory.add(createdGuitar);

        return createdGuitar;
    }

    public Guitar[] findAll() {
        Guitar[] invArray = new Guitar[inventory.size()];
        return inventory.toArray(invArray);
    }

    public Guitar find(int id) {
        for (Guitar g : inventory){
            if (g.getId() == id){
                return g;
            }
        }
        //if we got here, then it's not in there
        return null;
    }

    public Boolean delete(int idToRemove) {
        for (Guitar g : inventory){
            if (g.getId() == idToRemove){
                //we got him
                inventory.remove(g);
                return true;
            }
        }
        //if we got here, then it's not in there
        return false;
    }

    public void writeDataToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/christian/Desktop/Guitars.json"), inventory);
    }

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("/Users/christian/Desktop/Guitars.json"), new TypeReference<ArrayList<Guitar>>(){ });
    }

    /* O L D   M E T H O D
    public void writeDataToFile() throws IOException {
        String csvFile = "/Users/christian/Desktop/Guitars.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Guitar g : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(g.getId()));
            list.add(String.valueOf(g.getQty()));
            list.add(String.valueOf(g.getPrice()));
            list.add(g.getBrand());
            list.add(String.valueOf(g.getNumStrings()));
            list.add(g.getColor());
            list.add(String.valueOf(g.getHasActivePickups()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();
    }
    */

    /* O L D   M E T H O D
    private void loadData(){
        // (1)
        String csvFile = "/Users/christian/Desktop/Guitars.csv";
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
                int qty = Integer.parseInt(beer[1]);
                Double price = Double.parseDouble(beer[2]);
                String brand = beer[3];
                int numStrings = Integer.parseInt(beer[4]);
                String color = beer[5];
                Boolean pickups = Boolean.parseBoolean(beer[6]);

                // (5)
                inventory.add(new Guitar(id, qty, price, brand, numStrings, color, pickups));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
