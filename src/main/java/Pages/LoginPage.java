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
    By logOutBtn=By.linkText("Logout");
    By incorrectCredentials=By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    By loginMail=By.name("email");
    By loginPassword=By.name("password");
    By deleteAccount=By.linkText("Delete Account");
    By accountDeletedMsg=By.xpath("//p[contains(text(),'Your account has been permanently deleted!')]");


    public LoginPage (WebDriver driver){
        this.driver=driver;
    }

    public void enterLogin_RegisterPage()  {
        driver.findElement(signUpLoginBtn).click();
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }public WebElement LoginBtn(){
        return driver.findElement(loginBtn);
    }
    public void enterEmailLogin(String email){
        driver.findElement(emailLoginField).sendKeys(email);
    }
    public void enterPasswordLogin(String password){
        driver.findElement(passwordLoginField).sendKeys(password);
    }
    public WebElement logOutElement(){
        return driver.findElement(logOutBtn);
    }
    public void clickLogOut(){
        driver.findElement(logOutBtn).click();
    }
    public WebElement LogoutBtn(){
        return driver.findElement(logOutBtn);
    }
    public WebElement incorrectMailPassword(){
        return driver.findElement(incorrectCredentials);
    }
    public void loginWithMail(String mail){
        driver.findElement(loginMail).sendKeys(mail);
    }
    public void clearMailField(){
        driver.findElement(loginMail).clear();
    }public void clearPasswordField(){
        driver.findElement(loginPassword).clear();
    }
    public void loginWithPassword(String password){
        driver.findElement(loginPassword).sendKeys(password);
    }
    public void login(String mail,String password){
        loginWithMail(mail);
        loginWithPassword(password);
        driver.findElement(loginBtn).click();
    }
    public WebElement getLoginMailField(){
        return driver.findElement(loginMail);
    }
    public WebElement getPasswordField(){
        return driver.findElement(loginPassword);
    }
    public WebElement getDeleteAccountBtn(){
        return driver.findElement(deleteAccount);
    }
    public WebElement getUserName(String name){
        return driver.findElement(By.xpath("//b[contains(text(),'"+name+"')]"));

    }


}
