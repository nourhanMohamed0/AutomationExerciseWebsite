package Tests;

import BaseTest.Base;
import Pages.RegisterPage;
import TestData.TestData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class RegisterTest extends Base {
    RegisterPage registerPage;
    String emailAddress="testUser2@x.com";
    String AlreadyExistEmail="user1@x.com";
    String name="testUser2";
    @BeforeClass
    protected void setup()  {
        // Pass the driver from the Base class to RegisterPage
        registerPage = new RegisterPage(driver);
        registerPage.enterLogin_RegisterPage();
    }
    @Test
    public void RegisterWithExistingUser(){
        registerPage.signUp(name,AlreadyExistEmail);
        Assert.assertTrue(registerPage.getAlreadyExistMsg().isDisplayed());
    }
    @Test
    public void registerWithNameFieldOnly(){
        registerPage.signUp("",emailAddress);
        registerPage.clickOnSignUp1();
       Assert.assertEquals(registerPage.getNameField().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test
    public void registerWithEmailFieldOnly(){
        registerPage.signUp(name,"");
        registerPage.clickOnSignUp1();
       Assert.assertEquals(registerPage.getEmailField().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test(dataProvider = "Invalid mail format",dataProviderClass = TestData.class)
    public void registerWithInValidEmailAfterSymbol(String mail,String errorMsg){
            registerPage.getEmailField().clear();
            registerPage.signUp(name,mail);
            registerPage.clickOnSignUp1();
            Assert.assertEquals(registerPage.getEmailField().getAttribute("validationMessage"),errorMsg);
    }
    @Test
    public void registerWithInValidEmailWithoutLTD(){
        registerPage.signUp("testUser","user@x");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
    }
    @Test(dataProvider = "initial signup data",dataProviderClass = TestData.class)
    public void registerWithInValidName(String name,String mail){

            registerPage.getNameField().clear();
            registerPage.signUp(name,mail);
//            Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login","Helllo"); //Hard Assertion
            wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
            softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
            registerPage.enterLogin_RegisterPage();
        softAssert.assertAll();
    }
    @Test(dataProvider = "Exceeding number of characters",dataProviderClass = TestData.class)
    public void signupWithExceedingCharacters(String name,String mail){
        registerPage.signUp(name,mail);
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
        registerPage.enterLogin_RegisterPage();
        softAssert.assertAll();
    }

}
