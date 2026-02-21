package com.automationexercise.pages;

import com.automationexercise.actiondriver.ActionDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class LoginPage {

    private final ActionDriver actionDriver ;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    //Initialize the action drive object by passing the webdriver instance
    public LoginPage(ActionDriver actionDriver){
        this.actionDriver = actionDriver;
    }

    private final By inpEmail = By.xpath("//input[@data-qa='login-email']");
    private final By inpPassword = By.xpath("//input[@placeholder='Password']");
    private final By btnLogin = By.xpath("//button[normalize-space()='Login']");

    private final By errorMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    private final By userNameOnNavBar = By.xpath("//ul[@class='nav navbar-nav']//b");
    private final By logoutLnk = By.xpath("//a[normalize-space()='Logout']");

    public void login(String email, String password){
        actionDriver.waitForPageLoad();
        actionDriver.waitForElementToBeClickable(inpEmail);
        actionDriver.enterText(inpEmail, email);
        actionDriver.waitForElementToBeClickable(inpPassword);
        actionDriver.enterText(inpPassword, password);
        actionDriver.click(btnLogin);
        logger.info("Clicked on Login Button");
    }

    public String getUserNameOnNavBar(){
        actionDriver.waitForPageLoad();
        actionDriver.isDisplayed(userNameOnNavBar);
        logger.info("User name displayed after login");

        return actionDriver.getText(userNameOnNavBar);
    }

    public void clickOnLogout(){
        actionDriver.waitForPageLoad();
        actionDriver.click(logoutLnk);
        logger.info("User Click on Logout Link");
    }

    public String getErrorMsgOnLogin(){
        boolean errorStatus = actionDriver.isDisplayed(errorMessage);
        logger.info("The error message on login page is {}",errorStatus);
        return  actionDriver.getErrorMessage(errorMessage);
    }


}
