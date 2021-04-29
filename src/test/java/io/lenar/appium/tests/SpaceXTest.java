package io.lenar.appium.tests;

import io.lenar.appium.pages.OnboardingPage;
import io.lenar.appium.pages.MainPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpaceXTest extends BaseTest {

    @Test
    public void spaceXTest() {

        MainPage mainPage = isOnboardingPage() ? new OnboardingPage(driver).skip() : new MainPage(driver);

        List<String> results = mainPage
                .clickSearchIcon()
                .type("SpaceX")
                .getSearchResultsText();

        assertTrue(!results.isEmpty(), "No search results found");
        assertEquals(results.get(0), "American private aerospace company", "First element in search results: ");

    }

}
