package com.automationexercise.pages;

import com.automationexercise.actiondriver.ActionDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage {

    private final ActionDriver actionDriver ;

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    //Initialize the action drive object by passing the webdriver instance
    public HomePage(ActionDriver actionDriver){
        this.actionDriver = actionDriver;
    }

    // Define locators for home page
    // login and sign up page locator
    private final By lnkSigningAndSignup = By.xpath("//a[normalize-space()='Signup / Login']");
    private final By logo = By.xpath("//img[@alt='Website for automation practice']");

    public void clickOnLoginAndSignup(){
        actionDriver.waitForElementToBeClickable(lnkSigningAndSignup);
        actionDriver.click(lnkSigningAndSignup);
    }

    public boolean isLogoDisplayed(){
        actionDriver.waitForPageLoad();
        boolean logoStatus = actionDriver.isDisplayed(logo);
        logger.info("The Logo status on page load is : {}", logoStatus);
        return logoStatus;
    }








}
