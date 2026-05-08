package waze.pages;

import waze.base.Base;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavePlace extends Base {

    public SavePlace(AndroidDriver driver) {
        super(driver);
    }

    public void addSavePlace () {

        String destinationName = faker.name().firstName();

        helper.searchFlow(destinationName, element.whereTo, element.searchBox, element.searchResult);

        WebDriverWait delayWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        delayWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(element.InfoBody)));
        helper.WaitForElement(element.lastInfoBodyItem);
        helper.WaitClickable(element.saveIcon);
        helper.WaitForElement(element.givePlaceAName);
        helper.clickElement(element.doneButton);
        helper.WaitForElement(element.searchResultPage);
        helper.clickElement(element.searchBackButton);
        helper.WaitForElement(element.whereTo);
        helper.clickElement(element.whereTo);
        helper.WaitForElement(element.saveIcon);
        helper.clickElement(element.saveIcon);
        helper.WaitForElement(element.savePlaceModalTitle);

        List<WebElement> savedPlace = driver.findElements(AppiumBy.xpath(element.savePlacesList));
        boolean exist = savedPlace.stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.trim().toLowerCase().contains(destinationName.toLowerCase().trim()));
        assertTrue(exist);

        helper.clickElement(element.backButton);
    }
}
