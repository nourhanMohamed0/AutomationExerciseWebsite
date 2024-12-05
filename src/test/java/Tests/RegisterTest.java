package Tests;

import BaseTest.Base;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

public class RegisterTest extends Base {
    RegisterPage registerPage;
    String emailAddress="user1@x.com";
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
    @BeforeTest
    public void setup()  {
        // Pass the driver from the Base class to RegisterPage
        registerPage = new RegisterPage(driver);
        registerPage.enterLogin_Register();
    }
    @Test
    public void signUp(){
        registerPage.signUpName(name);
        registerPage.signUpEmail(emailAddress);
        registerPage.clickOnSignUp1();
    }
    @Test(dependsOnMethods = "signUp")
    public void fillRegisterDataValidData() throws InterruptedException {
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
    }
}
