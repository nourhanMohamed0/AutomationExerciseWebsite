package Tests;

import BaseTest.Base;
import Pages.RegisterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class RegisterTest extends Base {
    RegisterPage registerPage;
    String emailAddress="user5@x.com";
    String AlreadyExistEmail="user1@x.com";
    String invalidEmail="user1";
    String name="User2";
    String Password="123456";
    String day="10";
    String month="9";
    String year="2001";
    String firstName="Nourhan";
    String lastName="Mohamed";
    String Address="Cairo";
    String country="India";
    String company="myCompany";
    String state="cairo";
    String city="cairo";
    String zipcode="1287";
    String mobile="0123456789";
    @BeforeClass
    protected void setup()  {
        // Pass the driver from the Base class to RegisterPage
        registerPage = new RegisterPage(driver);
        registerPage.enterLogin_RegisterPage();

    }
    @Test
    public void fillRegisterDataValidData() {
        registerPage.signUp(name,emailAddress);
        registerPage.chooseMrsButton();
        registerPage.enterPassword(Password);
        registerPage.enterDay(day);
        registerPage.enterMonth(month);
        registerPage.enterYear(year);
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterCompany(company);
        registerPage.enterAddress1(Address);
        registerPage.enterCountry(country);
        registerPage.enterState(state);
        registerPage.enterCity(city);
        registerPage.enterZipcode(zipcode);
        registerPage.enterMobileNumber(mobile);
        registerPage.clickOnSignUp2();
        Assert.assertTrue(registerPage.confirmationCreationMsg().isDisplayed());
    }
    @Test
    public void RegisterWithExistingUser(){
        registerPage.signUp(name,AlreadyExistEmail);
        Assert.assertTrue(registerPage.getAlreadyExistMsg().isDisplayed());
    }
    @Test
    public void registerWithNameField(){
        registerPage.signUp("",emailAddress);
        registerPage.clickOnSignUp1();
       Assert.assertEquals(registerPage.getNameField().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test
    public void registerWithEmailField(){
        registerPage.signUp(name,"");
        registerPage.clickOnSignUp1();
       Assert.assertEquals(registerPage.getEmailField().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test
    public void registerWithInValidEmail(){
        registerPage.signUp(name,invalidEmail);
        registerPage.clickOnSignUp1();
       Assert.assertEquals(registerPage.getEmailField().getAttribute("validationMessage"),"Please include an '@' in the email address. '"+invalidEmail+"' is missing an '@'.");
//       System.out.println(registerPage.getEmailField().getAttribute("validationMessage"));
    }
//    @Test
//    public void test(){
//        registerPage.signUpEmail("Hello");
//        registerPage.getEmailField().clear();
//    }
    @Test
    public void registerWithInValidEmailAfterSymbol(){
        List<String> invalidMails = Arrays.asList(
                "user@!domain.com",  // Invalid '!'
                "user@#domain.com",  // Invalid '#'
                "user@%domain.com",  // Invalid '%'
                "user@domain$.com",  // Invalid '$'
                "user@domain^com",   // Invalid '^'
                "user@domain&com"    // Invalid '&'
        );
        List<String> expectedMessages = Arrays.asList(
                "A part following '@' should not contain the symbol '!'.",
                "A part following '@' should not contain the symbol '#'.",
                "A part following '@' should not contain the symbol '%'.",
                "A part following '@' should not contain the symbol '$'.",
                "A part following '@' should not contain the symbol '^'.",
                "A part following '@' should not contain the symbol '&'."
        );
        for (int i=0;i<expectedMessages.size();i++){
            registerPage.getEmailField().clear();
            registerPage.signUp(name,invalidMails.get(i));
            registerPage.clickOnSignUp1();
            Assert.assertEquals(registerPage.getEmailField().getAttribute("validationMessage"),expectedMessages.get(i));
        }
//       System.out.println(registerPage.getEmailField().getAttribute("validationMessage"));
    }
    @Test
    public void registerWithInValidEmailWithoutLTD(){
        registerPage.signUp("testUser","user@x");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
    }
    @Test
    public void registerWithInValidName(){
        SoftAssert softAssert=new SoftAssert();
        List<String> invalidNames = Arrays.asList(
                "123456789", "           ","user55 ","!@#$%^&&"
        );
        for (int i=0;i<invalidNames.size();i++){
            registerPage.getNameField().clear();
            registerPage.signUp(invalidNames.get(i),"user50@x.com");
//            Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login","Helllo"); //Hard Assertion
            wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
            softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
            registerPage.enterLogin_RegisterPage();
    }
        softAssert.assertAll();
    }

}
