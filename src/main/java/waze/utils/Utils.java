package waze.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Utils {

    AndroidDriver driver;

    public Utils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void WaitForElement (String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(locator)));
        } catch (Exception e) {
            //
        }
    }

    public void WaitClickable (String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(locator)));
        button.click();
    }

    public void WaitElementInvisibility (String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy.xpath(locator)));
        } catch (Exception e) {
            //
        }
    }

    public void clickElement (String locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver.findElement(AppiumBy.xpath(locator)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
    }

    public void scrollUp (String locator) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(" + locator + ")" +
                        ".setAsVerticalList().flingToEnd(5)"));
    }

    public void searchFlow (String name, String whereTo, String box, String result) {
        WaitForElement(whereTo);
        clickElement(whereTo);
        driver.findElement(AppiumBy.xpath(box)).sendKeys(name);
        WaitForElement(result);
        clickElement(result);
        WaitElementInvisibility(result);
    }
}

