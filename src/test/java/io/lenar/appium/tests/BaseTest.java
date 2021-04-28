package io.lenar.appium.tests;

import io.appium.java_client.android.AndroidDriver;
import io.lenar.appium.props.Props;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.URL;

public class BaseTest {

    private static Props props;
    protected static AndroidDriver driver;

    @BeforeClass
    public void setupClass() throws IOException {
        props = new Props();
    }

    @BeforeMethod
    public void setup() throws IOException {
        driver = new AndroidDriver(new URL(props.getHubUrl()), props.getDesiredCapabilities());
    }

    @AfterTest
    public void teardown() {
    }

    protected boolean isOnboardingPage() {
        return driver.currentActivity().endsWith(".InitialOnboardingActivity");
    }

}
