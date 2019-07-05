package io.automation.pages;

import io.automation.base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleHomePage extends BasePage {
  private static Logger LOGGER = LogManager.getLogger(GoogleHomePage.class);

  public GoogleSearchResultPage searchFor(String search) {
    LOGGER.debug("Searching for {} on Google", search);
    getElement(By.name("q")).sendKeys(search);
    getElement(By.name("q")).sendKeys(Keys.ENTER);
    return new GoogleSearchResultPage();
  }
}
