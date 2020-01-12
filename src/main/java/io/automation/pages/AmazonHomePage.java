package io.automation.pages;

import io.automation.base.BasePage;
import io.automation.utils.PageUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AmazonHomePage extends BasePage {
    private static Logger LOGGER = LogManager.getLogger(AmazonHomePage.class);

    public AmazonSearchResultPage searchFor(String search) {
        LOGGER.debug("Searching for {} on Amazon", search);
        final WebElement searchTextBox = getElement(By::id, "twotabsearchtextbox");
        click(By::id, "twotabsearchtextbox");
        enterText(By::id, "twotabsearchtextbox", search);
        enterText(By::id, "twotabsearchtextbox", Keys.RETURN);
        return PageUtils.getPage(AmazonSearchResultPage.class);
    }
}
