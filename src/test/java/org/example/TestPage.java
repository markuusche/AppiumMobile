package org.example;

import org.junit.jupiter.api.Test;

public class TestPage extends baseTest{

    @Test
    void selectDestination() {
        MainPage page = new MainPage(driver);
        page.Destination();
    }

    @Test
    void sampleOnly() {
        MainPage page = new MainPage(driver);
        page.Destination();
    }
}
