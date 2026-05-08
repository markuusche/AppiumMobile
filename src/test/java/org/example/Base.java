package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

class baseTest {

    public AndroidDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("ANQL6R3330008390")
                .setAutomationName("UiAutomator2")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setEnforceAppInstall(true)
                .setAppPackage("com.waze")
                .setAppWaitActivity("com.waze.*");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.activateApp("com.waze");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

