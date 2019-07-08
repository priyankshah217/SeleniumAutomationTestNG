package io.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface WebUtils {
  boolean isElementPresent(By by);

  boolean waitForElementToBePresent(By by);

  WebElement getElement(By by);

  String getPageTitle();
}
