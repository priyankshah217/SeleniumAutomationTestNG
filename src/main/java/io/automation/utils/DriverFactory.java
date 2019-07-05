package io.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
  private static Logger LOGGER = LogManager.getLogger(DriverFactory.class);
  private static ThreadLocal<RemoteWebDriver> webDriverThreadLocal = null;

  public static RemoteWebDriver getWebDriverThreadLocal() {
    return webDriverThreadLocal.get();
  }

  public static void createDriver(String browserName, String hubUrl) {
    RemoteWebDriver driver = null;
    if (browserName.toLowerCase().contains("local")) {
      if (browserName.toLowerCase().contains("chrome")) {
        LOGGER.debug("Launching instance of {}", browserName);
        driver = new ChromeDriver();
      } else {
        LOGGER.debug("Launching instance of {}", browserName);
        driver = new FirefoxDriver();
      }
    } else {
      try {
        LOGGER.debug("Launching instance on docker hub, Hub Url is {}", hubUrl);
        LOGGER.debug("Launching instance of {}", browserName);
        driver = new RemoteWebDriver(new URL(hubUrl), CapabilityFactory.getCapabilities(browserName));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    if (webDriverThreadLocal == null) {
      RemoteWebDriver finalDriver = driver;
      webDriverThreadLocal = ThreadLocal.withInitial(() -> finalDriver);
    }
    LOGGER.debug("Setting up {} driver in threadLocal", browserName);
    webDriverThreadLocal.set(driver);
  }

  public static void quiteDriver() {
    RemoteWebDriver remoteWebDriver = webDriverThreadLocal.get();
    if (remoteWebDriver != null) {
      remoteWebDriver.quit();
    }
    LOGGER.debug("Cleaning up {} session", remoteWebDriver.getCapabilities().getBrowserName());
  }

}
