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

    private final By chkBxNewsLetter = By.xpath("//label[normalize-space()='Sign up for our newsletter!']");
    private final By chxBxOffer = By.xpath("//label[normalize-space()='Receive special offers from our partners!']");

    private final By inpFirstName = By.id("first_name");
    private final By inpLastName = By.id("last_name");
    private final By inpCompanyName = By.id("company");

    private final By inpAddress1 = By.id("address1");
    private final By inpAddress2 = By.id("address2");
    private final By selectCountry = By.id("country");
    private final By inpState= By.id("state");
    private final By inpCity = By.id("city");
    private final By inpZipcode = By.id("zipcode");
    private final By inpPhoneNumber = By.id("mobile_number");

    private final By btnCreateAccount = By.xpath("//button[normalize-space()='Create Account']");
    private final By successMSGCreateAccount = By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')");



    public void setUserNameAndEmailForSignup(String username, String email){
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

    public void setDOB(String date, String month, String year){
        actionDriver.selectByVisibleText(selectDay, date);
        actionDriver.selectByVisibleText(selectMonth, month);
        actionDriver.selectByVisibleText(selectYear,year);
    }

    public void clickOnCheckBoxNewsLetter(){
        actionDriver.waitForElementToBeClickable(chkBxNewsLetter);
        actionDriver.click(chkBxNewsLetter);
        logger.info("Click on checkbox for news letter.....");
    }

    public void clickOnCheckBoxOffer(){
        actionDriver.waitForElementToBeClickable(chxBxOffer);
        actionDriver.scrollToElement(chxBxOffer);
        actionDriver.click(chxBxOffer);
        logger.info("Click on check box for offers.....");
    }

    public void setUserDetails(String firstname, String lastName, String companyName){

        actionDriver.scrollToElement(inpFirstName);
        actionDriver.waitForElementToBeClickable(inpFirstName);
        actionDriver.waitForElementToBeClickable(inpFirstName);
        actionDriver.waitForElementToBeClickable(inpCompanyName);

        actionDriver.enterText(inpFirstName, firstname);
        actionDriver.enterText(inpLastName, lastName);
        actionDriver.enterText(inpCompanyName, companyName);

        logger.info("User details are set successfully......");
    }

    public void setUserContactDetails(String address1, String address2, String country, String state,String city, String zipcode, String phoneNumber ){

        actionDriver.scrollToElement(inpAddress1);
        actionDriver.enterText(inpAddress1, address1);
        actionDriver.enterText(inpAddress2, address2);

        actionDriver.selectByVisibleText(selectCountry, country);

        actionDriver.enterText(inpState, state);
        actionDriver.enterText(inpCity, city);
        actionDriver.enterText(inpZipcode, zipcode);
        actionDriver.enterText(inpPhoneNumber, phoneNumber);

        logger.info("user contact info added successfully.....");
    }

    public void clickOnCreateAccount(){
        actionDriver.waitForElementToBeClickable(btnCreateAccount);
        actionDriver.scrollToElement(btnCreateAccount);
        actionDriver.click(btnCreateAccount);
        logger.info("click on create account btn from signup....");
    }

    public String getSuccessMsgForAccountCreate(){
        actionDriver.waitForElementToVisible(successMSGCreateAccount);
        return actionDriver.getText(successMSGCreateAccount);
    }


}
