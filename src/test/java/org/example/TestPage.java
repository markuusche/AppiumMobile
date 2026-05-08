package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPage extends baseTest{

    @Test
    void selectDestination() {
        MainPage page = new MainPage(driver);
        page.Destination();
    }

    @Test
    void savePlace() {
        MainPage page = new MainPage(driver);
        page.savePlace();
    }
}
