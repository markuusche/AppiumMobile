package com.waze.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Base {

    public AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("ANQL6R3330008390")
                .setAutomationName("UiAutomator2")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setEnforceAppInstall(true)
                .setAppPackage("com.waze")
                .setAppWaitActivity("com.waze.*");

        options.setCapability("appium:shouldTerminateApp", true);
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            try {
                driver.terminateApp("com.waze");
                driver.quit();
            } catch (Exception e) {
                //
            }
        }
    }
}

