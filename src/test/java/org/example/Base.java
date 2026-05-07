package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

class baseTest {

    private AndroidDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("ANQL6R3330008390")
                .setAutomationName("UiAutomator2")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setAppPackage("com.waze");

       driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

