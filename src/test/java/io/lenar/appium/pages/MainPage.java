package io.lenar.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends Page {

    private static final String ACTIVITY_NAME = "org.wikipedia.main.MainActivity";
    private static final By SEARCH_ICON_BY = By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']");
    private MobileElement searchIcon;

    public MainPage(AndroidDriver driver) {
        super(driver, ACTIVITY_NAME);
    }

    private MobileElement searchIcon() {
        if (searchIcon == null) {
            searchIcon = findElementWithWait(SEARCH_ICON_BY);
        }
        return searchIcon;
    }

    public SearchPage clickSearchIcon() {
        searchIcon().click();
        return new SearchPage(getDriver());
    }

}
