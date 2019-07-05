package io.automation.pages;

import io.automation.base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AmazonHomePage extends BasePage {
  private static Logger LOGGER = LogManager.getLogger(AmazonHomePage.class);

  public AmazonSearchResultPage searchFor(String search) {
    LOGGER.debug("Searching for {} on Amazon", search);
    final WebElement searchTextBox = getElement(By.id("twotabsearchtextbox"));
    searchTextBox.click();
    searchTextBox.sendKeys(search);
    searchTextBox.sendKeys(Keys.RETURN);
    return new AmazonSearchResultPage();
  }
}
