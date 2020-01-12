package io.automation.pages;

import io.automation.base.BasePage;
import io.automation.utils.PageUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleHomePage extends BasePage {
    private static Logger LOGGER = LogManager.getLogger(GoogleHomePage.class);

    public GoogleSearchResultPage searchFor(String search) {
        LOGGER.debug("Searching for {} on Google", search);
        enterText(By::name, "q", search);
        enterText(By::name, "q", Keys.ENTER);
        return PageUtils.getPage(GoogleSearchResultPage.class);
    }
}
