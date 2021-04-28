package io.lenar.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public abstract class Page {

    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SEC = 5;
    private final String activityName;

    private AndroidDriver driver;

    private Page() {
        this.activityName = null;
    }

    public Page(AndroidDriver driver, String activityName) {
        this.driver = driver;
        this.activityName = activityName;
        verifyPageIsLoaded();
        System.out.println("New Page - " + activityName);
    }

    protected void verifyPageIsLoaded() {
        assertEquals(getDriver().currentActivity(), activityName, "Current Activity ");
    }

    protected AndroidDriver getDriver() {
        return this.driver;
    }

    protected MobileElement findElementWithWait(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_FOR_ELEMENT_TIMEOUT_SEC);
        MobileElement element = (MobileElement) (wait.until(presenceOfElementLocated(by)));
        System.out.println("Successfully Found element <" + by + ">");
        return element;
    }

}
