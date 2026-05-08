package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Utils {

    AndroidDriver driver;

    public Utils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void WaitForElement(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(locator)));
        } catch (Exception e) {
            //
        }
    }

    public void WaitElementInvisibility(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy.xpath(locator)));
        } catch (Exception e) {
        //
        }
    }

    public void clickElement(String locator) {
        driver.findElement(AppiumBy.xpath(locator)).click();
    }

    void scrollUp (String locator) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(" + locator + ")" +
                        ".setAsVerticalList().flingToEnd(5)"));
    }
}

