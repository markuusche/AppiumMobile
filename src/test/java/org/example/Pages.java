package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Pages {

    AndroidDriver driver;

    public Pages(AndroidDriver driver) {
        this.driver = driver;
    }

    public void Destination() {
        Utils helper = new Utils(driver);

        String whereTo = "//android.widget.TextView[@text=\"Where to?\"]";
        String searchBox = "//*[@resource-id='com.waze:id/coordinatorsView']//android.widget.EditText";
        String searchResult = "//*[@content-desc=\"SEARCH_AUTOCOMPLETE_LIST\"]/android.view.View[1]";
        String viewRoutes = "//*[@content-desc=\"CALL_TO_ACTION_BAR_FIRST_ACTION\"]";
        String streetInfo = "//android.widget.ScrollView/android.view.View[1]";
        String goNow = "//*[@text='Go now']";

        helper.WaitForElement(whereTo);
        helper.clickElement(whereTo);
        driver.findElement(AppiumBy.xpath(searchBox)).sendKeys("Bonifacio High Street");
        helper.WaitForElement(searchResult);
        helper.clickElement(searchResult);
        helper.WaitElementInvisibility(searchResult);

        try {
            helper.WaitForElement(streetInfo);
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" +
                ".setAsVerticalList().flingToEnd(5)"
            ));
            helper.clickElement(viewRoutes);

        } catch (Exception e) {
            //
        }

        helper.WaitForElement(goNow);
        helper.clickElement(goNow);
    }
}
