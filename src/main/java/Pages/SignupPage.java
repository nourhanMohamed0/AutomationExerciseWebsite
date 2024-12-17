package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignupPage {
    WebDriver driver;
    /*
     *************************Locators*************************
     */
    By titleMrButton=By.id("id_gender1");
    By titleMrsButton=By.id("id_gender2");
    By nameField=By.id("name");
    By mailField=By.id("email");
    By passwordField=By.id("password");
    By dropDownDay=By.id("days");
    By dropDownMonth=By.id("months");
    By dropDownYears=By.id("years");
    By FirstNameField=By.id("first_name");
    By LastNameField=By.id("last_name");
    By companyField=By.id("company");
    By addressField=By.id("address1");
    By addressOptionalField=By.id("address2");
    By dropDownCountry=By.id("country");
    By stateField=By.id("state");
    By cityField=By.id("city");
    By ZipcodeField=By.id("zipcode");
    By mobileNumberField=By.id("mobile_number");
    By newsLetterButton=By.id("newsletter");
    By specialOfferButton=By.id("optin");
    By signup2=By.xpath("//button[contains(text(),'Create Account')]");
    By accountCreated=By.xpath("//h2[@class='title text-center']");
    By signup1=By.xpath("//button[contains(text(),'Signup')]");
    By emailSignUp=By.xpath("(//input[@name='email'])[2]");
    By nameSignUp=By.name("name");
    By signUpLoginBtn=By.linkText("Signup / Login");
    By deleteAccountBtn=By.linkText("Delete Account");

    public SignupPage(WebDriver driver){
        this.driver=driver;
    }
    public WebElement enterPassword(){
        return driver.findElement(passwordField);
    }
    public void enterDay(String day){
        Select selectDay=new Select(driver.findElement(dropDownDay));
        selectDay.selectByValue(day);
    }
    public void enterMonth(String monthNumber){
        Select selectMonth=new Select(driver.findElement(dropDownMonth));
        selectMonth.selectByValue(monthNumber);
    }
    public void enterYear(String year){
        Select selectYear=new Select(driver.findElement(dropDownYears));
        selectYear.selectByValue(year);
    }
    public void subscribeNewsLetter(){
        driver.findElement(newsLetterButton).click();
    }
    public void receiveSpecialOffer(){
        driver.findElement(specialOfferButton).click();
    }
    public WebElement enterFirstName(){
       return driver.findElement(FirstNameField);
    }
    public WebElement enterLastName(){
        return driver.findElement(LastNameField);
    }

    public WebElement enterCompany(){
        return driver.findElement(companyField);
    }
    public WebElement enterAddress1(){
       return driver.findElement(addressField);
    }
    public WebElement enterAddress2(String address){
        return driver.findElement(addressOptionalField);
    }
    public void enterCountry(String country){
        Select selectCountry=new Select(driver.findElement(dropDownCountry));
        selectCountry.selectByValue(country);
    }
    public WebElement enterState(){
        return driver.findElement(stateField);
    }
    public WebElement enterCity(){
        return driver.findElement(cityField);
    }
    public WebElement enterZipcode(){
        return driver.findElement(ZipcodeField);
    }
    public WebElement enterMobileNumber(){
        return driver.findElement(mobileNumberField);
    }
    public void clickOnSignUp2(){
        driver.findElement(signup2).click();
    }
    public void chooseMrButton(){
        driver.findElement(titleMrButton).click();
    }
    public void chooseMrsButton(){
        driver.findElement(titleMrsButton).click();
    }
    public void enterNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public WebElement confirmationCreationMsg(){
        return driver.findElement(accountCreated);
    }
    public void signUpEmail(String email){
        driver.findElement(emailSignUp).sendKeys(email);
    }
    public void signUpName(String nameSign){
        driver.findElement(nameSignUp).sendKeys(nameSign);
    }
    public void clickOnSignUp1(){
        driver.findElement(signup1).click();
    }
    public void signUp(String name, String emailAddress){
        signUpName(name);
        signUpEmail(emailAddress);
        clickOnSignUp1();
    }
    public void enterLogin_RegisterPage()  {
        driver.findElement(signUpLoginBtn).click();
    }
    public WebElement getDeleteAccountBtn(){
        return driver.findElement(deleteAccountBtn);
    }
    public void fillRegisterData(String pass,String day,String month,String year,String firstName,String lastName,
                                          String company,String Address,String country,String state,String city,String zipcode,
    String mobile,String gender) {
        if(gender.equalsIgnoreCase("female"))
        chooseMrsButton();
        else if(gender.equalsIgnoreCase("male")) chooseMrButton();
        enterPassword().sendKeys(pass);
        enterDay(day);
        enterMonth(month);
        enterYear(year);
        enterFirstName().sendKeys(firstName);
        enterLastName().sendKeys(lastName);
        enterCompany().sendKeys(company);
        enterAddress1().sendKeys(Address);
        enterCountry(country);
        enterState().sendKeys(state);
        enterCity().sendKeys(city);
        enterZipcode().sendKeys(zipcode);
        enterMobileNumber().sendKeys(mobile);
        clickOnSignUp2();
    }
}
