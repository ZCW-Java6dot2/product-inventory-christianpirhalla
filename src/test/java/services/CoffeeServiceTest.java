package services;

import models.Coffee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CoffeeServiceTest {

    @Test
    public void createTest(){
        int expectedQty = 1;
        double expectedPrice = 2.25;
        int expectedSize = 12;
        String expectedDrinkType = "regular";
        String expectedFlavor = "none";
        Boolean expectedCream = false;
        Boolean expectedSugar = false;

        CoffeeService coffeeService = new CoffeeService();
        Coffee testCoffee = coffeeService.create(expectedQty, expectedPrice, expectedSize, expectedDrinkType, expectedFlavor,
                expectedCream, expectedSugar);

        int actualId = testCoffee.getId();
        int actualQty = testCoffee.getQty();
        double actualPrice = testCoffee.getPrice();
        int actualSize = testCoffee.getSize();
        String actualDrinkType = testCoffee.getDrinkType();
        String actualFlavor = testCoffee.getFlavor();
        Boolean actualCream = testCoffee.getCream();
        Boolean actualSugar = testCoffee.getSugar();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedDrinkType, actualDrinkType);
        Assertions.assertEquals(expectedFlavor, actualFlavor);
        Assertions.assertEquals(expectedCream, actualCream);
        Assertions.assertEquals(expectedSugar, actualSugar);


    }
}
