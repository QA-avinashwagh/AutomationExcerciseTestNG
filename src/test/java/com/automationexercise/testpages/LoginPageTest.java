package com.automationexercise.testpages;

import com.automationexercise.factory.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    private final static Logger logger = LogManager.getLogger(LoginPageTest.class);

    private HomePage homepage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setupPages() {
        homepage = new HomePage(actionDriver);
        loginPage= new LoginPage(actionDriver);
    }

    @Test(description = "Verify Login with valid credential")
    public void verifyLoginWithValidCredential() {
        homepage.clickOnLoginAndSignup();
        String email = ConfigReader.getProperty("validEmail");
        String password = ConfigReader.getProperty("validPassword");
        loginPage.login(email, password);

        String actualUserName =loginPage.getUserNameOnNavBar();
        String expectedUserName = ConfigReader.getProperty("userNameOnNavBar");
        Assert.assertEquals(actualUserName, expectedUserName, "User name after login does not match");

        logger.info("Performing logout after Login ");
        loginPage.clickOnLogout();

    }

    @Test(description = "Verify login with invalid credential")
    public void verifyLoginWithInvalidTest(){
        homepage.clickOnLoginAndSignup();
        String email = ConfigReader.getProperty("invalidEmail");
        String password = ConfigReader.getProperty("invalidPassword");
        loginPage.login(email, password);

       String actualMSG = loginPage.getErrorMsgOnLogin();
       String expectedMSG = ConfigReader.getProperty("invalidLoginAttemptMsg");

        Assert.assertEquals(actualMSG,expectedMSG, "Message on Invalid attempt does not match");

    }





}
