package io.automation.utils;

import io.automation.base.BasePage;

public class BrowserUtil {

    public static <T extends BasePage> T launchUrl(String url,
                                                   Class<? extends BasePage> page) {
        DriverFactory.getWebDriver().get(url);
        return PageUtils.getPage(page);
    }
}
