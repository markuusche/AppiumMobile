package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    AndroidDriver driver;

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void Destination() {
        Utils helper = new Utils(driver);

        String locationName = "Bonifacio High Street";
        String whereTo = "//android.widget.TextView[@text=\"Where to?\"]";
        String searchBox = "//*[@resource-id='com.waze:id/coordinatorsView']//android.widget.EditText";
        String searchResult = "//*[@content-desc=\"SEARCH_AUTOCOMPLETE_LIST\"]/android.view.View[1]";
        String viewRoutes = "//*[@content-desc=\"CALL_TO_ACTION_BAR_FIRST_ACTION\"]";
        String streetInfo = "//android.widget.ScrollView/android.view.View[1]";
        String tripOverview = "//*[@resource-id=\"com.waze:id/tripOverviewDetails\"]";
        String goNow = "//*[@text='Go now']";

        helper.WaitForElement(whereTo);
        helper.clickElement(whereTo);
        driver.findElement(AppiumBy.xpath(searchBox)).sendKeys(locationName);
        helper.WaitForElement(searchResult);
        helper.clickElement(searchResult);
        helper.WaitElementInvisibility(searchResult);

        WebDriverWait delayWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            delayWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(streetInfo)));
            helper.scrollUp("new UiSelector().className(\"android.widget.ScrollView\")");
            helper.clickElement(viewRoutes);

        } catch (Exception e) {
            //
        }

        helper.WaitForElement(tripOverview);
        helper.clickElement(goNow);

        // assert
        helper.WaitForElement("//*[@resource-id=\"com.waze:id/dragHandle\"]");
        helper.scrollUp("new UiSelector().resourceId(\"com.waze:id/dragHandle\")");

        WebElement street = driver.findElement(AppiumBy.xpath("//*[@resource-id=\"com.waze:id/lblAddress\"]"));
        assertTrue(street.getText().contains(locationName));

        WebElement stopButton = driver.findElement(AppiumBy.xpath("//*[@resource-id=\"com.waze:id/lblStopNav\"]"));
        assertTrue(stopButton.getText().contains("Stop"));

        stopButton.click();
    }
}
