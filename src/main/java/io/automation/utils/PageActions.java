package io.automation.utils;

import org.openqa.selenium.By;

import java.util.function.Function;

public interface PageActions {
    void click(Function<String, By> function, String locatorString);

    void enterText(Function<String, By> function, String locatorString, CharSequence... text);
}
