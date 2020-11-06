package services;

import models.Coffee;

import java.util.ArrayList;

public class CoffeeService {
    private static int nextId = 1;

    private ArrayList<Coffee> inventory = new ArrayList<>();

    public Coffee create(int expectedQty, double expectedPrice, int expectedSize, String expectedDrinkType, String expectedFlavor, Boolean expectedCream, Boolean expectedSugar) {
        Coffee createdCoffee = new Coffee(nextId++, expectedQty, expectedPrice, expectedSize, expectedDrinkType, expectedFlavor, expectedCream,
        expectedSugar);

        inventory.add(createdCoffee);
        return createdCoffee;
    }
}
