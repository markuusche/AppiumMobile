package waze.base;

import waze.utils.Utils;
import net.datafaker.Faker;
import waze.constants.Elements;
import io.appium.java_client.android.AndroidDriver;

import java.util.Locale;


public class Base {

    protected AndroidDriver driver;
    protected Utils helper;
    protected Elements element;
    protected Faker faker;

    public Base(AndroidDriver driver) {
        this.driver = driver;
        this.helper = new Utils(driver);
        this.element = new Elements();
        this.faker = new Faker(Locale.of("en", "PH"));
    }
}
