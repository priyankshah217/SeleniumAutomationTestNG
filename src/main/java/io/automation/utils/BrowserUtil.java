package io.automation.utils;

import io.automation.base.BasePage;

import java.lang.reflect.InvocationTargetException;

public class BrowserUtil {

  public static <T extends BasePage> T launchUrl(String url,
                                                 Class<? extends BasePage> page) {
    T t = null;
    try {
      DriverFactory.getWebDriverThreadLocal().get(url);
      t = (T) Class.forName(page.getName()).getDeclaredConstructor().newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return t;
  }
}
