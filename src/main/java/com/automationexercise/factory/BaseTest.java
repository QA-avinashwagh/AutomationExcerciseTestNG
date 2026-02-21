package com.automationexercise.factory;

import com.automationexercise.actiondriver.ActionDriver;
import com.automationexercise.utilities.ConfigReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    protected ActionDriver actionDriver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional String browser, Method method){

        logger.info("===== Starting Test Setup | Thread: {} | Test: {} =====",
                Thread.currentThread().getName(),
                method.getName());

        // 1. Browser fallback logic
        if (browser == null || browser.trim().isEmpty()) {
            browser = ConfigReader.getProperty("browser");
            logger.info("Browser not provided via TestNG. Using config value: {}", browser);
        } else {
            logger.info("Browser selected from TestNG parameter: {}", browser);
        }

        // 2. Initialize WebDriver (ThreadLocal)
        DriverFactory.initDriver(browser);
        logger.debug("WebDriver initialized successfully");

        // 3. Initialize ActionDriver
        actionDriver = new ActionDriver(DriverFactory.getDriver());
        logger.debug("ActionDriver initialized");

        // 4. Configure browser
        configureBrowser();

        logger.info("===== @BeforeMethod completed =====");
    }


    private void configureBrowser() {
        logger.info("Configuring browser settings");

        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        DriverFactory.getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(implicitWait));

        logger.debug("Implicit wait set to {} seconds", implicitWait);

        DriverFactory.getDriver().manage().window().maximize();
        logger.debug("Browser window maximized");

        String url = ConfigReader.getProperty("url");
        try {
            DriverFactory.getDriver().get(url);
            logger.info("Navigated to URL: {}", url);
        } catch (Exception e) {
            logger.error("Failed to navigate to URL: {}", url, e);
            throw new RuntimeException("Failed to load URL", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("===== Starting Test Teardown | Thread: {} =====",
                Thread.currentThread().getName());

        try {
            DriverFactory.quitDriver();
            logger.info("WebDriver quit successfully");
        } catch (Exception e) {
            logger.warn("Error while quitting WebDriver", e);
        }
    }
}
