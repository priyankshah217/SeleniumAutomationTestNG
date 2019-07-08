package io.automation.base;

import io.automation.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage implements WebUtils {
  private static Logger LOGGER = LogManager.getLogger(BasePage.class);

  @Override
  public boolean isElementPresent(By by) {
    try {
      DriverFactory.getWebDriver().findElement(by);
      return true;
    } catch (NoSuchElementException ex) {
      ex.getStackTrace();
      return false;
    }
  }

  @Override
  public boolean waitForElementToBePresent(By by) {
    WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(),
        Duration.ofSeconds(30));
    return wait.until(new ExpectedCondition<Boolean>() {
      @Nullable
      @Override
      public Boolean apply(@Nullable WebDriver webDriver) {
        return isElementPresent(by);
      }
    });
  }

  @Override
  public WebElement getElement(By by) {
    return waitForElementToBePresent(by) ?
        DriverFactory.getWebDriver().findElement(by) : null;
  }

  @Override
  public String getPageTitle() {
    return DriverFactory.getWebDriver().getTitle();
  }

}
