package io.lenar.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public abstract class Page {

    private static final int WAIT_TIMEOUT_SEC = 5;
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
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < WAIT_TIMEOUT_SEC * 1000)
            if (getDriver().currentActivity().equals(activityName))
                break;
        assertEquals(getDriver().currentActivity(), activityName, "Current Activity ");
    }

    protected AndroidDriver getDriver() {
        return this.driver;
    }

    protected MobileElement findElementWithWait(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT_SEC);
        MobileElement element = (MobileElement) (wait.until(presenceOfElementLocated(by)));
        System.out.println("Successfully Found element <" + by + ">");
        return element;
    }

    protected List<MobileElement> findElementsWithWait(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT_SEC);
        wait.until(numberOfElementsToBeMoreThan(by, 1));
        List<MobileElement> elements = wait.until(numberOfElementsToBeMoreThan(by, 1)).stream().map(element -> (MobileElement) element).collect(Collectors.toList());
        System.out.println("Successfully Found elements <" + by + ">");
        return elements;
    }

}
