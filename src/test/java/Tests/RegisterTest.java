package Tests;

import BaseTest.Base;
import Pages.RegisterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterTest extends Base {
    RegisterPage registerPage;
    String emailAddress="user4@x.com";
    String AlreadyExistEmail="user1@x.com";
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

}
