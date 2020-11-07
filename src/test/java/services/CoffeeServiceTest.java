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

    @Test
    public void findCoffeeTest(){
        //given
        int expectedQty = 1;
        double expectedPrice = 2.25;
        int expectedSize = 12;
        String expectedDrinkType = "regular";
        String expectedFlavor = "none";
        Boolean expectedCream = false;
        Boolean expectedSugar = false;

        CoffeeService coffeeServiceTest = new CoffeeService();
        Coffee expectedCoffee = coffeeServiceTest.create(expectedQty, expectedPrice, expectedSize, expectedDrinkType, expectedFlavor,
                expectedCream, expectedSugar);

        //when
        int actualId = coffeeServiceTest.findAll()[0].getId();
        Coffee actualCoffee = coffeeServiceTest.findCoffee(actualId);

        //then
        Assertions.assertEquals(expectedCoffee, actualCoffee);
    }

    @Test
    public void findCoffeeTest2(){//Look for one that isn't there
        //given
        Coffee expectedCoffee = null;
        CoffeeService coffeeServiceTest = new CoffeeService();

        //When
        Coffee actualCoffee = coffeeServiceTest.findCoffee(2);

        //then
        Assertions.assertEquals(expectedCoffee, actualCoffee);


         }

    @Test
    public void findAllTest(){
        //given
        CoffeeService coffeeServiceTest = new CoffeeService();
        Coffee expectedCoffee1 = coffeeServiceTest.create(1, 2.25, 12, "regular", "none", false, false);
        Coffee expectedCoffee2 = coffeeServiceTest.create(2, 3.50, 18, "latte", "caramel", true, true);
        Coffee[] expectedCoffeeList = {expectedCoffee1, expectedCoffee2};
        //When
        Coffee[] actualCoffeeList = coffeeServiceTest.findAll();

        //then
        Assertions.assertArrayEquals(expectedCoffeeList, actualCoffeeList);
    }



    @Test
    public void deleteTest(){
        //given
        CoffeeService coffeeServiceTest2 = new CoffeeService();
        Coffee expectedCoffee1 = coffeeServiceTest2.create(1, 2.25, 12, "regular", "none", false, false);
        Coffee expectedCoffee2 = coffeeServiceTest2.create(2, 3.50, 18, "latte", "caramel", true, true);
        Coffee[] expectedCoffeeList = {expectedCoffee1};
        Boolean expectedResult = true;

        //When
        int idToRemove = coffeeServiceTest2.findAll()[1].getId();

        Boolean actualResult = coffeeServiceTest2.delete(idToRemove);
        Coffee[] actualCoffeeList = coffeeServiceTest2.findAll();


        //then
        Assertions.assertArrayEquals(expectedCoffeeList, actualCoffeeList);
        Assertions.assertEquals(expectedResult, actualResult);

    }


}
