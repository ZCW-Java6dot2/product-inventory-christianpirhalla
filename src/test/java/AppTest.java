import models.Coffee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import services.CoffeeService;

public class AppTest {

    /* how do I test this??
    @Test
    public void createProductTest(){
        //given
        int expectedQty = 1;
        double expectedPrice = 2.50;
        int expectedSize = 12;
        String expectedDrinkType = "latte";
        String expectedFlavor = "caramel";
        boolean expectedCream = true;
        boolean expectedSugar = true;

        //when
        App application = new App();
        application.createProduct();
        Coffee[] invArray = application.getCoffeeService().findAll();
        Coffee actualCoffee = invArray[0];

        //then
        Assertions.assertEquals(expectedQty, actualCoffee.getQty());
        Assertions.assertEquals(expectedSize, actualCoffee.getSize());
        Assertions.assertEquals(expectedPrice, actualCoffee.getPrice());
        Assertions.assertEquals(expectedDrinkType, actualCoffee.getDrinkType());
        Assertions.assertEquals(expectedFlavor, actualCoffee.getFlavor());
        Assertions.assertEquals(expectedCream, actualCoffee.getCream());
        Assertions.assertEquals(expectedSugar, actualCoffee.getSugar());


    }
*/
}
