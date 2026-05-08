package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.datafaker.Faker;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
import java.time.Duration;

public class MainPage {

    AndroidDriver driver;
    Utils helper;

    private String whereTo = "//android.widget.TextView[@text=\"Where to?\"]";
    private String searchBox = "//*[@resource-id='com.waze:id/coordinatorsView']//android.widget.EditText";
    private String searchResult = "//*[@content-desc=\"SEARCH_AUTOCOMPLETE_LIST\"]/android.view.View[1]";
    private String streetInfo = "//android.widget.ScrollView/android.view.View[1]";

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
        this.helper = new Utils(driver);
    }

    public void Destination() {

        String locationName = "Bonifacio High Street";
        String viewRoutes = "//*[@content-desc=\"CALL_TO_ACTION_BAR_FIRST_ACTION\"]";
        String tripOverview = "//*[@resource-id=\"com.waze:id/tripOverviewDetails\"]";
        String goNow = "//*[@text='Go now']";

        searchNavigation(locationName);

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

    public void savePlace() {

        Faker faker = new Faker(Locale.of("en", "PH"));

        String destinationName = faker.name().firstName();
        String InfoBody = "//android.widget.ScrollView";
        String saveIcon = "//android.widget.HorizontalScrollView/android.view.View[1]/android.view.View";

        searchNavigation(destinationName);
        WebDriverWait delayWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        delayWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(streetInfo)));
        helper.WaitForElement(InfoBody);
        helper.clickElement(saveIcon);
        helper.WaitForElement("//android.view.ViewGroup/android.view.View[1]");
        helper.clickElement("//*[@content-desc=\"CALL_TO_ACTION_BAR_FIRST_ACTION\"]");
        helper.WaitForElement("//*[@resource-id=\"com.waze:id/coordinatorsView\"]");
        helper.clickElement("//android.view.View[2]/android.widget.Button[1]");
        helper.WaitForElement(whereTo);
        helper.clickElement(whereTo);
        helper.WaitForElement(saveIcon);
        helper.clickElement(saveIcon);
        helper.WaitForElement("//*[@resource-id=\"com.waze:id/titleBarTitleText\"]");

        List<WebElement> savedPlace = driver.findElements(AppiumBy.xpath("//*[@resource-id=\"com.waze:id/cellTitle\" and not(@text=\"\")]"));
        boolean exist = savedPlace.stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(destinationName));
        assertTrue(exist);

        helper.clickElement("//*[@resource-id=\"com.waze:id/titleBarCloseButtonFake\"]");
    }

    void searchNavigation(String destinationName) {
        helper.WaitForElement(whereTo);
        helper.clickElement(whereTo);
        driver.findElement(AppiumBy.xpath(searchBox)).sendKeys(destinationName);
        helper.WaitForElement(searchResult);
        helper.clickElement(searchResult);
        helper.WaitElementInvisibility(searchResult);
    }
}
