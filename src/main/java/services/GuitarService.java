package services;

import models.Guitar;

import java.util.ArrayList;

public class GuitarService {
    private static int nextId = 1;

    private ArrayList<Guitar> inventory = new ArrayList<Guitar>();

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
}
