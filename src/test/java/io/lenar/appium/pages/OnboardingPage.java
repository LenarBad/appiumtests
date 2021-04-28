package io.lenar.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class OnboardingPage extends Page {

    private static final By SKIP_BUTTON_BY = By.id("fragment_onboarding_skip_button");
    private static final String ACTIVITY_NAME = "org.wikipedia.onboarding.InitialOnboardingActivity";

    private MobileElement skipButton;

    public OnboardingPage(AndroidDriver driver) {
        super(driver, ACTIVITY_NAME);
    }

    private MobileElement skipButton() {
        if (skipButton == null) {
            skipButton = findElementWithWait(SKIP_BUTTON_BY);
        }
        return skipButton;
    }

    public MainPage skip() {
        skipButton().click();
        return new MainPage(getDriver());
    }

}
