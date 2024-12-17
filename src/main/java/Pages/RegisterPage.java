package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;
    /*
    *************************Locators*************************
    */
    By emailAddress=By.xpath("(//input[@name='email'])[2]");
    By name=By.name("name");
    By signUpLoginBtn=By.linkText("Signup / Login");
    By signup1=By.xpath("//button[contains(text(),'Signup')]");
    By alreadyExistMsg=By.xpath("//p[contains(text(),'Email Address already exist!')]");

    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    public void signUpEmail(String email){
        driver.findElement(emailAddress).sendKeys(email);
    }
    public void signUpName(String nameSign){
        driver.findElement(name).sendKeys(nameSign);
    }
    public void clickOnSignUp1(){
        driver.findElement(signup1).click();
    }
    public void enterLogin_RegisterPage()  {
        driver.findElement(signUpLoginBtn).click();
    }
    public WebElement getNameField(){
        return driver.findElement(name);
    }
    public WebElement getEmailField(){
        return driver.findElement(emailAddress);
    }

    public WebElement getAlreadyExistMsg(){
        return driver.findElement(alreadyExistMsg);
    }

    public void signUp(String name, String emailAddress){
        signUpName(name);
        signUpEmail(emailAddress);
        clickOnSignUp1();
    }

}
