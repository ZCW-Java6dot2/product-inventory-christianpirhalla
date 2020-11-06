package services;

import models.Coffee;

import java.util.ArrayList;

public class CoffeeService {
    //fields
    private static int nextId = 1;
    private ArrayList<Coffee> inventory = new ArrayList<Coffee>();

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
}
