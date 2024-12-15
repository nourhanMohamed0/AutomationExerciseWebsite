package Tests;

import BaseTest.Base;
import Pages.RegisterPage;
import TestData.TestData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class RegisterTest extends Base {
    RegisterPage registerPage;
    String emailAddress="user@x.com";
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
//    @Test
//    public void LoginWithValidCredentials(){
//        registerPage.login(emailAddress,Password);
//        Assert.assertTrue(registerPage.LogoutBtn().isDisplayed());
//    }
//    @Test
//    public void LoginWithEmptyMail(){
//        registerPage.login("",Password);
//        Assert.assertEquals(registerPage.getLoginMailField().getAttribute("validationMessage"),"Please fill out this field.");
//    }@Test
//    public void LoginWithEmptyPassword(){
//        registerPage.login(emailAddress,"");
//        Assert.assertEquals(registerPage.getPasswordField().getAttribute("validationMessage"),"Please fill out this field.");
//    }
//    @Test
//    public void LoginWithInvalidMails(){
//        registerPage.login(inValidMail,Password);
//        Assert.assertTrue(registerPage.incorrectMailPassword().isDisplayed());
//    }
//    @Test
//    public void LoginWithHeadingAndTrailingSpaces(){
//        registerPage.login("           "+emailAddress+"    ",Password);
//        Assert.assertTrue(registerPage.LogoutBtn().isDisplayed());
//    }
//    @Test(dataProvider = "browsers")
//    public void loginWithDifferentBrowsers(String browser){
//        if(browser.equals("firefox")){
//            driver=new FirefoxDriver();
//            driver.get(baseURL);
//            driver.manage().window().maximize();
//        }
//    }

}
