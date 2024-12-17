package Tests;

import BaseTest.Base;
import Pages.SignupPage;
import TestData.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupTest extends Base {
    SignupPage signupPage;
    String Name="testUser2";
    String email="testUser3@x.com";
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
    String zipcode="12872";
    String mobile="0123456789";

    @BeforeTest
    public void Setup(){
        signupPage=new SignupPage(driver);
        signupPage.enterLogin_RegisterPage();
        signupPage.signUp(Name,email);
    }
    @Test
    public void fillRegisterDataValidData() {
        signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,Address,country,state,city,zipcode,mobile,"female");
        Assert.assertTrue(signupPage.confirmationCreationMsg().isDisplayed());
    }
    @Test
    public void fillRegisterDataWithEmptyPassword() {
        signupPage.fillRegisterData("",day,month,year,firstName,lastName,company,Address,country,state,city,zipcode,mobile,"female");
        Assert.assertEquals(signupPage.enterPassword().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test
    public void fillRegisterDataWithEmptyFirstName() {
        signupPage.fillRegisterData(Password,day,month,year,"",lastName,company,Address,country,state,city,zipcode,mobile,"female");
        Assert.assertEquals(signupPage.enterFirstName().getAttribute("validationMessage"),"Please fill out this field.");
    }@Test
    public void fillRegisterDataWithEmptyLastName() {
        signupPage.fillRegisterData(Password,day,month,year,firstName,"",company,Address,country,state,city,zipcode,mobile,"female");
        Assert.assertEquals(signupPage.enterFirstName().getAttribute("validationMessage"),"Please fill out this field.");
    }@Test
    public void fillRegisterDataWithEmptyAddress() {
        signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,"",country,state,city,zipcode,mobile,"female");
        Assert.assertEquals(signupPage.enterFirstName().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test
    public void fillRegisterDataWithEmptyState() {
        signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,Address,country,"",city,zipcode,mobile,"female");
        Assert.assertEquals(signupPage.enterFirstName().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test
    public void fillRegisterDataWithEmptyCity() {
        signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,Address,country,state,"",zipcode,mobile,"female");
        Assert.assertEquals(signupPage.enterFirstName().getAttribute("validationMessage"),"Please fill out this field.");
    }@Test
    public void fillRegisterDataWithEmptyZipCode() {
        signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,Address,country,state,city,"",mobile,"female");
        Assert.assertEquals(signupPage.enterFirstName().getAttribute("validationMessage"),"Please fill out this field.");}
    @Test
    public void fillRegisterDataWithEmptyMobileNumber() {
        signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,Address,country,state,city,zipcode,"","female");
        Assert.assertEquals(signupPage.enterFirstName().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test(dataProvider = "first last Name",dataProviderClass = TestData.class)
    public void fillRegisterDataWithInvalidFirstName(String FirstName) {
        signupPage.fillRegisterData(Password,day,month,year,FirstName,lastName,company,Address,country,state,city,zipcode,mobile,"female");
        softAssert.assertFalse(signupPage.confirmationCreationMsg().isDisplayed());
        signupPage.enterLogin_RegisterPage();
        signupPage.getDeleteAccountBtn().click();
        signupPage.enterLogin_RegisterPage();
        signupPage.signUp(Name,email);
    }@Test(dataProvider = "first last Name",dataProviderClass = TestData.class)
    public void fillRegisterDataWithInvalidLastName(String LastName) {
        signupPage.fillRegisterData(Password,day,month,year,firstName,LastName,company,Address,country,state,city,zipcode,mobile,"female");
        softAssert.assertFalse(signupPage.confirmationCreationMsg().isDisplayed());
        signupPage.enterLogin_RegisterPage();
        signupPage.getDeleteAccountBtn().click();
        signupPage.enterLogin_RegisterPage();
        signupPage.signUp(Name,email);
    }@Test(dataProvider = "valid ZIP Code",dataProviderClass = TestData.class)
    public void fillRegisterDataWithValidZIPCode(String zip) {
        signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,Address,country,state,city,zip,mobile,"female");
        softAssert.assertTrue(signupPage.confirmationCreationMsg().isDisplayed());
        signupPage.enterLogin_RegisterPage();
        signupPage.getDeleteAccountBtn().click();
        signupPage.enterLogin_RegisterPage();
        signupPage.signUp(Name,email);
    }
@Test(dataProvider = "invalid ZIP Code",dataProviderClass = TestData.class)
    public void fillRegisterDataWithInValidZIPCode(String zip) {
    signupPage.fillRegisterData(Password,day,month,year,firstName,lastName,company,Address,country,state,city,zip,mobile,"female");
        softAssert.assertFalse(signupPage.confirmationCreationMsg().isDisplayed());
        signupPage.enterLogin_RegisterPage();
        signupPage.getDeleteAccountBtn().click();
        signupPage.enterLogin_RegisterPage();
        signupPage.signUp(Name,email);
    }

}
