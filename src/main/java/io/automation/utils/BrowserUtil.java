package io.automation.utils;

public class BrowserUtil {

    public static void launchUrl(String url) {
        DriverFactory.getWebDriver().get(url);
    }
}
