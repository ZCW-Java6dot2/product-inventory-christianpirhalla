package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GuitarTest {

    @Test
    public void setQtyTest(){
        //given
        int expected = 20;

        //when
        Guitar testGuitar = new Guitar();
        testGuitar.setQty(20);

        //then
        int actual = testGuitar.getQty();
        Assertions.assertEquals(expected,actual);
    }

    public void setPriceTest(){
        //given
        double expected = 200.00;

        //when
        Guitar testGuitar = new Guitar();
        testGuitar.setPrice(200.00);

        //then
        double actual = testGuitar.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    public void setBrandTest(){
        //given
        String expected = "Fender";

        //when
        Guitar testGuitar = new Guitar();
        testGuitar.setBrand("Fender");

        //then
        String actual = testGuitar.getBrand();
        Assertions.assertEquals(expected, actual);
    }

    public void setNumStringsTest(){
        //given
        int expected = 7;

        //when
        Guitar testGuitar = new Guitar();
        testGuitar.setNumStrings(7);

        //then
        int actual = testGuitar.getNumStrings();
        Assertions.assertEquals(expected, actual);
    }

    public void setColor() {
        //given
        String expected = "black";

        //when
        Guitar testGuitar = new Guitar();
        testGuitar.setColor("black");

        //then
        String actual = testGuitar.getColor();
        Assertions.assertEquals(expected, actual);
    }

    public void setHasActivePickupsTest() {
        //given
        Boolean expected = false;

        //when
        Guitar testGuitar = new Guitar();
        testGuitar.setHasActivePickups(false);

        //then
        Boolean actual = testGuitar.getHasActivePickups();
        Assertions.assertEquals(expected, actual);
    }

}
