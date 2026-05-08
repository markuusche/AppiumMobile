package com.waze.automation.tests;

import com.waze.automation.base.*;
import org.junit.jupiter.api.RepeatedTest;
import waze.pages.Destination;
import org.junit.jupiter.api.Test;

public class DestinationTest extends Base {

    @Test
    void selectDestination() {
        Destination destination = new Destination(driver);
        destination.setDestination();
    }
}
