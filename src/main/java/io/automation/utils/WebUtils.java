package io.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

public interface WebUtils {
    boolean isElementPresent(Function<String, By> function, String locatorString);

    boolean waitForElementToBePresent(Function<String, By> function, String locatorString);

    WebElement getElement(Function<String, By> function, String locatorString);

    String getPageTitle();
}
