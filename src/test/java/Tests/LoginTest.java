package Tests;

import BaseTest.Base;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    String AlreadyExistEmail="user1@x.com";
    String Password="123456";
    LoginPage loginPage;
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
}
