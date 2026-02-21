package com.automationexercise.pages;

import com.automationexercise.actiondriver.ActionDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

    private final ActionDriver actionDriver;
    private static final Logger logger = LogManager.getLogger(SignupPage.class);

    //Initialize the action drive object by passing the webdriver instance
    public SignupPage(ActionDriver actionDriver) {
        this.actionDriver = actionDriver;
    }

    private final By inpUserName= By.xpath("//input[@data-qa='signup-name']");
    private final By inputEmail= By.xpath("//input[@data-qa='signup-email']");
    private final By btnSignup = By.xpath("//button[normalize-space()='Signup']");

    private final By inpPassword = By.id("password");
    private final By selectDay = By.id("days");
    private final By selectMonth = By.id("months");
    private final By selectYear = By.id("years");

    public void SetUserNameAndEmailForSignup(String username, String email){
        actionDriver.waitForPageLoad();
        actionDriver.waitForElementToBeClickable(inpUserName);
        actionDriver.enterText(inpUserName, username);

        actionDriver.waitForElementToBeClickable(inputEmail);
        actionDriver.enterText(inputEmail, email);
        logger.info("User name and Email set For Signup fields");
    }
    public void clickOnSignupButton(){
        actionDriver.waitForElementToBeClickable(btnSignup);
        actionDriver.click(btnSignup);
        logger.info("Click on signup button...");
    }

    public void clickOnTitle(String title){
        actionDriver.waitForPageLoad();

        By radTitle = By.xpath("//input[@type='radio' and @value='" + title + "']");
        actionDriver.waitForElementToBeClickable(radTitle);
        actionDriver.click(radTitle);
        logger.info("Click on radio button for title......");
    }

    public void setInpPassword(String password){
        actionDriver.waitForElementToBeClickable(inpPassword);
        actionDriver.enterText(inpPassword, password);
        logger.info("Set password on signup field....");
    }


    // incomplete method
    public void setDOB(String date, String month, String year){

        WebElement drpDownDate =
        Select DateSelect = new Select(selectDay.findElement());

    }






}
