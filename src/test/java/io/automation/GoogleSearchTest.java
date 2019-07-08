package io.automation;


import io.automation.base.BaseTest;
import io.automation.pages.GoogleHomePage;
import io.automation.pages.GoogleSearchResultPage;
import io.automation.utils.BrowserUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchTest extends BaseTest {
  private static final String GOOGLE_URL = "http://www.google.co.in/";
  private static Logger LOGGER = LogManager.getLogger(GoogleSearchTest.class);

  @Test
  void searchSelenium() {
    LOGGER.info("Launching {}", Thread.currentThread().getStackTrace()[1].getMethodName());
    GoogleHomePage googleHomePage = BrowserUtil.launchUrl(GOOGLE_URL, GoogleHomePage.class);
    GoogleSearchResultPage googleSearchResultPage = googleHomePage.searchFor("Selenium");
    assertThat(googleSearchResultPage.getPageTitle()).containsIgnoringCase("Selenium");
  }

  @Test
  void searchComputer() {
    LOGGER.info("Launching {}", Thread.currentThread().getStackTrace()[1].getMethodName());
    GoogleHomePage googleHomePage = BrowserUtil.launchUrl(GOOGLE_URL, GoogleHomePage.class);
    GoogleSearchResultPage googleSearchResultPage = googleHomePage.searchFor("Computer");
    assertThat(googleSearchResultPage.getPageTitle()).containsIgnoringCase("Computer");
  }
}
