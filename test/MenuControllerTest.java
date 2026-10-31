import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuControllerTest {

    //1
    @Test
    void menuController_returnStringInput() {

        Scanner testScanner = new Scanner("Hello");
        MenuController input = new MenuController(testScanner);
        assertEquals("Hello",input.getString());

    }

    //2
    @Test
    void menuController_returnsIntegerInput() {

        Scanner testScanner = new Scanner(String.valueOf(123));
        MenuController input = new MenuController(testScanner);
        assertEquals(123, input.getInteger());

    }

}