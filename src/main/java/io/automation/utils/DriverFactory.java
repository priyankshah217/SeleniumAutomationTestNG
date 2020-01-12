package io.automation.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public class DriverFactory {
    private static Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    private static ThreadLocal<RemoteWebDriver> webDriverThreadLocal = null;

    /**
     * @return WebDriver
     */

    public static RemoteWebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    /**
     * @param browserName
     * @param hubUrl
     */
    public static void createDriver(String browserName, String hubUrl) {
        final RemoteWebDriver driver = getRemoteWebDriver(browserName, hubUrl);
        if (webDriverThreadLocal == null) {
            webDriverThreadLocal = ThreadLocal.withInitial(() -> driver);
            webDriverThreadLocal.set(driver);
        }
        LOGGER.debug("Setting up {} driver in threadLocal", browserName);
        webDriverThreadLocal.set(driver);
    }

    private static RemoteWebDriver getRemoteWebDriver(String browserName, String hubUrl) {
        if (browserName.toLowerCase().contains("local")) {
            if (browserName.toLowerCase().contains("chrome")) {
                LOGGER.debug("Launching instance of {}", browserName);
                return new ChromeDriver();
            } else {
                LOGGER.debug("Launching instance of {}", browserName);
                return new FirefoxDriver();
            }
        } else {
            try {
                LOGGER.debug("Launching instance on docker hub, Hub Url is {}", hubUrl);
                LOGGER.debug("Launching instance of {}", browserName);
                return new RemoteWebDriver(new URL(hubUrl),
                        CapabilityFactory.getCapabilities(browserName));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Quit Driver
     */
    public static void quitDriver() {
        RemoteWebDriver remoteWebDriver = webDriverThreadLocal.get();
        if (remoteWebDriver != null) {
            remoteWebDriver.quit();
        }
        LOGGER.debug("Cleaning up {} session", Objects.requireNonNull(remoteWebDriver)
                .getCapabilities().getBrowserName());
    }

}
