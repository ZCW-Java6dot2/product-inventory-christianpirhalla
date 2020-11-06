package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CoffeeTest {

    @Test
    public void constructorTest(){
        int expectedQty = 3;
        double expectedPrice = 3.45;
        int expectedSize = 16;
        String expectedDrinkType = "regular";
        String expectedFlavor = "none";
        Boolean expectedCream = false;
        Boolean expectedSugar = false;

        Coffee testCoffee = new Coffee(expectedQty, expectedPrice, expectedSize,
                expectedDrinkType, expectedFlavor, expectedCream, expectedSugar);

        Assertions.assertEquals(expectedQty, testCoffee.getQty());
        Assertions.assertEquals(expectedPrice, testCoffee.getPrice());
        Assertions.assertEquals(expectedSize, testCoffee.getSize());
        Assertions.assertEquals(expectedDrinkType, testCoffee.getDrinkType());
        Assertions.assertEquals(expectedFlavor, testCoffee.getFlavor());
        Assertions.assertEquals(expectedCream, testCoffee.getCream());
        Assertions.assertEquals(expectedSugar, testCoffee.getSugar());
    }

    @Test
    public void setQtyTest(){
        // given
        int expected = 5;

        // when
        Coffee testCoffee = new Coffee();
        testCoffee.setQty(5);

        //then
        int actual = testCoffee.getQty();
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void setPriceTest(){
        //given
        double expected = 3.45;

        //when
        Coffee testCoffee = new Coffee();
        testCoffee.setPrice(3.45);

        //then
        double actual = testCoffee.getPrice();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void setSizeTest(){
        //given
        int expected = 32;

        //when
        Coffee testCoffee = new Coffee();
        testCoffee.setSize(32);

        //then
        int actual = testCoffee.getSize();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setDrinkTypeTest(){
        //given
        String expected = "latte";

        //when
        Coffee testCoffee = new Coffee();
        testCoffee.setDrinkType("latte");

        //then
        String actual = testCoffee.getDrinkType();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setFlavorTest(){
        //given
        String expected = "caramel";

        //when
        Coffee testCoffee = new Coffee();
        testCoffee.setFlavor("caramel");

        //then
        String actual = testCoffee.getFlavor();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setCreamTest(){
        //given
        Boolean expected = true;

        //when
        Coffee testCoffee = new Coffee();
        testCoffee.setCream(true);

        //then
        Boolean actual = testCoffee.getCream();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setSugarTest(){
        //given
        Boolean expected = true;

        //when
        Coffee testCoffee = new Coffee();
        testCoffee.setSugar(true);

        //then
        Boolean actual = testCoffee.getSugar();
        Assertions.assertEquals(expected, actual);
    }



}
