package io.automation.base;

import io.automation.listners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import static io.automation.utils.DriverFactory.createDriver;
import static io.automation.utils.DriverFactory.quitDriver;

@Listeners(TestListener.class)
public class BaseTest {
    private static Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    @Parameters(value = {"browserName", "hubUrl"})
    public void setup(String browserName, String hubUrl) {
        createDriver(browserName, hubUrl);
    }

    @AfterMethod
    public void tearDown() {
        LOGGER.debug("Quitting driver");
        quitDriver();
    }

}
