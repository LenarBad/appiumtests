package io.lenar.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends Page {

    private static final By SEARCH_INPUT_BY = By.id("search_src_text");
    private static final By SEARCH_RESULTS_BY = By.id("page_list_item_description");
    private static final String ACTIVITY_NAME = "org.wikipedia.search.SearchActivity";

    private MobileElement searchInput;

    public SearchPage(AndroidDriver driver) {
        super(driver, ACTIVITY_NAME);
    }

    private MobileElement searchInput() {
        if (searchInput == null) {
            searchInput = findElementWithWait(SEARCH_INPUT_BY);
        }
        return searchInput;
    }

    private List<MobileElement> searchResults() {
        return getDriver().findElements(SEARCH_RESULTS_BY);
    }

    public SearchPage type(String text) {
        searchInput().sendKeys(text);
        return this;
    }

    public List<String> getSearchResultsText() {
        return searchResults().stream().map(element -> element.getText()).collect(Collectors.toList());
    }

}
