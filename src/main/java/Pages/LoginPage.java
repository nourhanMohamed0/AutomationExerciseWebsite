package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginPage {
    WebDriver driver;
    By loginBtn=By.xpath("//button[@data-qa='login-button']");
    By passwordLoginField=By.name("password");
    By emailLoginField=By.name("email");
    By signUpLoginBtn=By.linkText("Signup / Login");
    By logOut=By.linkText("Logout");

    public LoginPage (WebDriver driver){
        this.driver=driver;
    }

    public void enterLogin_RegisterPage()  {
        driver.findElement(signUpLoginBtn).click();
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
    public void enterEmailLogin(String email){
        driver.findElement(emailLoginField).sendKeys(email);
    }
    public void enterPasswordLogin(String password){
        driver.findElement(passwordLoginField).sendKeys(password);
    }
    public WebElement logOutElement(){
        return driver.findElement(logOut);
    }
    public void clickLogOut(){
        driver.findElement(logOut).click();
    }


}
