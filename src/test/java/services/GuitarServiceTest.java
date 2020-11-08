package services;

import models.Guitar;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class GuitarServiceTest {

    @Test
    public void createTest() throws IOException {

        int expectedQty = 1;
        Double expectedPrice = 300.00;
        String expectedBrand = "Ibanez";
        int expectedNumStrings = 7;
        String expectedColor = "Black";
        Boolean expectedHasActivePickups = false;

        GuitarService guitarService = new GuitarService();
        Guitar testGuitar = guitarService.create(expectedQty, expectedPrice, expectedBrand, expectedNumStrings,
                expectedColor, expectedHasActivePickups);

        int actualId = testGuitar.getId();
        int actualQty = testGuitar.getQty();
        String actualBrand = testGuitar.getBrand();
        int actualNumStrings = testGuitar.getNumStrings();
        String actualColor = testGuitar.getColor();
        Boolean actualHasActivePickups = testGuitar.getHasActivePickups();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedNumStrings, actualNumStrings);
        Assertions.assertEquals(expectedColor, actualColor);
        Assertions.assertEquals(expectedHasActivePickups, actualHasActivePickups);
    }

    @Test
    public void findGuitarTest() throws IOException {
        //given
        GuitarService guitarServiceTest = new GuitarService();
        Guitar expectedGuitar = guitarServiceTest.create(1, 300.00, "Ibanez", 7,"Black",false);

        //when
        int actualId = guitarServiceTest.findAll()[0].getId();
        Guitar actualGuitar = guitarServiceTest.find(actualId);

        //then
        Assertions.assertEquals(expectedGuitar, actualGuitar);


    }

    @Test
    public void findAllTest() throws IOException {
        //given
        GuitarService guitarServiceTest = new GuitarService();
        Guitar expectedGuitar1 = guitarServiceTest.create(1, 300.00, "Ibanez", 7,"Black",false);
        Guitar expectedGuitar2 = guitarServiceTest.create(1, 180.00, "Epiphone", 6, "Sunburst", false);
        Guitar[] expectedGuitarList = {expectedGuitar1, expectedGuitar2};

        //when
        Guitar[] actualGuitarList = guitarServiceTest.findAll();

        //Then
        Assertions.assertArrayEquals(expectedGuitarList, actualGuitarList);
    }

    @Test
    public void deleteTest() throws IOException {
        //given
        GuitarService guitarServiceTest = new GuitarService();
        Guitar expectedGuitar1 = guitarServiceTest.create(1, 300.00, "Ibanez", 7,"Black",false);
        Guitar expectedGuitar2 = guitarServiceTest.create(1, 180.00, "Epiphone", 6, "Sunburst", false);
        Guitar[] expectedGuitarList = {expectedGuitar1};
        Boolean expectedResult = true;

        //when
        int idToRemove = guitarServiceTest.findAll()[1].getId();

        Boolean actualResult = guitarServiceTest.delete(idToRemove);
        Guitar[] actualGuitarList = guitarServiceTest.findAll();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
        Assertions.assertArrayEquals(expectedGuitarList, actualGuitarList);


    }

}
