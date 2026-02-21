package com.automationexercise.testpages;

import com.automationexercise.factory.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupPage;
import com.automationexercise.utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupPageTest extends BaseTest {

    private final static Logger logger = LogManager.getLogger(SignupPageTest.class);

    private HomePage homepage;
    private SignupPage signupPage;

    @BeforeMethod
    public void setUpPages(){
        homepage = new HomePage(actionDriver);
        signupPage = new SignupPage(actionDriver);
    }

    @Test(description = "Verify creating account with valid credential")
    public void VerifyCreateAccountWithValidCredential(){
        homepage.clickOnLoginAndSignup();

        signupPage.setUserNameAndEmailForSignup("Smith Law", "smith.law@yopmail.com");
        signupPage.clickOnSignupButton();

        signupPage.clickOnTitle("Mr");
        signupPage.setInpPassword("Smith@123");
        signupPage.setDOB("17", "August", "2003");

        signupPage.clickOnCheckBoxNewsLetter();
        signupPage.clickOnCheckBoxOffer();

        signupPage.setUserDetails("Smith", "law", "SmithBrothers");
        signupPage.setUserContactDetails("High street 25", "Affile tower", "India", "Gujarat", "Surat", "394210", "9106162016");

        signupPage.clickOnCreateAccount();

        String actualMessage = signupPage.getSuccessMsgForAccountCreate();
        String expectedMessage = ConfigReader.getProperty("AccountCreateMessage");

        Assert.assertEquals(actualMessage, expectedMessage, "Message does not match on create account");





    }

}
