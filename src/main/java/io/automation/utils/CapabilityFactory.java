package io.automation.utils;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
  public static Capabilities capabilities;

  public static Capabilities getCapabilities(String browser) {
    if (browser.toLowerCase().contains("firefox")) {
      capabilities = OptionsManager.getFirefoxOptions();
    } else {
      capabilities = OptionsManager.getChromeOptions();
    }
    return capabilities;
  }
}