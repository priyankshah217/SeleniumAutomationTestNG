package io.automation.base;

import io.automation.utils.DriverFactory;
import io.automation.utils.PageActions;
import io.automation.utils.WebUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;


public class BasePage implements WebUtils, PageActions {
    private static Logger LOGGER = LogManager.getLogger(BasePage.class);

    @Override
    public boolean isElementPresent(Function<String, By> function, String locatorString) {
        try {
            LOGGER.debug("Checking element is present {}", locatorString);
            DriverFactory.getWebDriver().findElement(function.apply(locatorString));
            LOGGER.debug("Element is present {} is present", locatorString);
            return true;
        } catch (NoSuchElementException ex) {
            ex.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean waitForElementToBePresent(Function<String, By> function, String locatorString) {
        int timeout = 30;
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(),
                Duration.ofSeconds(timeout));
        LOGGER.debug("Wait for element to load {} with timeout {} in seconds", locatorString, timeout);
        Boolean isElementPresent = wait.until((ExpectedCondition<Boolean>) webDriver -> isElementPresent(function, locatorString));
        LOGGER.debug("Element {} is loaded", locatorString);
        return isElementPresent;
    }

    @Override
    public WebElement getElement(Function<String, By> function, String locatorString) {
        return waitForElementToBePresent(function, locatorString) ?
                DriverFactory.getWebDriver().findElement(function.apply(locatorString)) : null;
    }

    @Override
    public String getPageTitle() {
        return DriverFactory.getWebDriver().getTitle();
    }

    @Override
    public void click(Function<String, By> function, String locatorString) {
        getElement(function, locatorString).click();
    }

    @Override
    public void enterText(Function<String, By> function, String locatorString, CharSequence... text) {
        getElement(function, locatorString).sendKeys(text);
    }
}
