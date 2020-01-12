package io.automation.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static Logger LOGGER = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Starting {}", result.getMethod());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test {} Executed Successfully {}", result.getMethod(), result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test {} Executed with failure {}", result.getMethod(), result.getStatus());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Test {} is skipped", result.getMethod());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
