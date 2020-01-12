package io.automation;


import io.automation.base.BaseTest;
import io.automation.pages.AmazonHomePage;
import io.automation.pages.AmazonSearchResultPage;
import io.automation.utils.BrowserUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class AmazonSearchTest extends BaseTest {
    private static final String AMAZON_URL = "http://www.amazon.in/";
    private static Logger LOGGER = LogManager.getLogger(AmazonSearchTest.class);

    @Test
    void searchComputer() {
        LOGGER.info("Launching {}", Thread.currentThread().getStackTrace()[1].getMethodName());
        AmazonHomePage amazonHomePage = BrowserUtil.launchUrl(AMAZON_URL, AmazonHomePage.class);
        AmazonSearchResultPage amazonSearchResultPage = amazonHomePage.searchFor("Computer");
    }

    @Test
    void searchLaptop() {
        LOGGER.info("Launching {}", Thread.currentThread().getStackTrace()[1].getMethodName());
        AmazonHomePage amazonHomePage = BrowserUtil.launchUrl(AMAZON_URL, AmazonHomePage.class);
        AmazonSearchResultPage amazonSearchResultPage = amazonHomePage.searchFor("Laptop");
    }
}
