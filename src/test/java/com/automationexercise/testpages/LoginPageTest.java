package com.automationexercise.testpages;

import com.automationexercise.factory.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @Test
    public void verifyLoginWithValidCredential() {
        homepage.clickOnLoginAndSignup();
        loginPage.login("david123@yopmail.com", "David@1234");
    }

}
