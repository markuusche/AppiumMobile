package org.example;

import org.junit.jupiter.api.Test;

public class TestPage extends baseTest{

    @Test
    void selectDestination() {
        Pages page = new Pages(driver);
        page.Destination();
    }
}
