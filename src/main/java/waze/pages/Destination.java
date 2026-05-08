package waze.pages;

import waze.base.Base;
import java.time.Duration;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Destination extends Base {

    public Destination (AndroidDriver driver) {
        super(driver);
    }
    //
    public void setDestination() {

        String destinationName = faker.name().firstName();

        helper.searchFlow(
                destinationName,
                element.whereTo,
                element.searchBox,
                element.searchResult
        );

        WebDriverWait delayWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            delayWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(element.streetInfo)));
            helper.WaitForElement(element.InfoBody);
            helper.WaitForElement(element.lastInfoBodyItem);
            helper.scrollUp(element.routeInfo);
            helper.clickElement(element.doneButton);
        } catch (Exception e) {
            //
        }

        helper.WaitForElement(element.tripOverview);
        helper.clickElement(element.goNow);
        helper.WaitForElement(element.activeRouteModal);
        helper.scrollUp(element.scrollActiveRouteModal);
        helper.WaitForElement(element.shareDrive);

        WebElement street = driver.findElement(AppiumBy.xpath(element.activeRouteAddress));
        WebElement stopButton = driver.findElement(AppiumBy.xpath(element.stopButton));
        assertTrue(street.getText().toLowerCase().trim().contains(destinationName.toLowerCase().trim()));
        assertTrue(stopButton.getText().contains("Stop"));

        stopButton.click();
    }
}
