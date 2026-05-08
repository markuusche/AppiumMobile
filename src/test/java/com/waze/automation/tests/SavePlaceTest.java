package com.waze.automation.tests;

import com.waze.automation.base.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import waze.pages.SavePlace;

public class SavePlaceTest extends Base {

    @Test
    void savePlaces() {
        SavePlace destination = new SavePlace(driver);
        destination.addSavePlace();
    }
}
