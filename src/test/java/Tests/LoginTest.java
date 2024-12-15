package Tests;

import BaseTest.Base;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    String AlreadyExistEmail="user1@x.com";
    String Password="123456";
    LoginPage loginPage;
    String inValidMail="invalidUser@x.com";
    String emailAddress="user@x.com";
    @BeforeClass
    public void setUp(){
        loginPage =new LoginPage(driver);
        loginPage.enterLogin_RegisterPage();
    }

        @Test
    public void loginWithExistingEmail() {
        loginPage.enterEmailLogin(AlreadyExistEmail);
        loginPage.enterPasswordLogin(Password);
        loginPage.clickLoginBtn();
        wait.until(ExpectedConditions.visibilityOf(loginPage.logOutElement()));
        loginPage.clickLogOut();
    }
    @Test
    public void LoginWithValidCredentials(){
        loginPage.login(emailAddress,Password);
        Assert.assertTrue(loginPage.LogoutBtn().isDisplayed());
    }
    @Test
    public void LoginWithEmptyMail(){
        loginPage.login("",Password);
        Assert.assertEquals(loginPage.getLoginMailField().getAttribute("validationMessage"),"Please fill out this field.");
    }@Test
    public void LoginWithEmptyPassword(){
        loginPage.login(emailAddress,"");
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("validationMessage"),"Please fill out this field.");
    }
    @Test
    public void LoginWithInvalidMails(){
        loginPage.login(inValidMail,Password);
        Assert.assertTrue(loginPage.incorrectMailPassword().isDisplayed());
    }
    @Test
    public void LoginWithHeadingAndTrailingSpaces(){
        loginPage.login("           "+emailAddress+"    ",Password);
        Assert.assertTrue(loginPage.LogoutBtn().isDisplayed());
    }
//    @Test(dataProvider = "browsers")
//    public void loginWithDifferentBrowsers(String browser){
//        if(browser.equals("firefox")){
//            driver=new FirefoxDriver();
//            driver.get(baseURL);
//            driver.manage().window().maximize();
//        }
//    }
}
