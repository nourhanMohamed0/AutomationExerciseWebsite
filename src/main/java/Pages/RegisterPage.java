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
    By titleMrButton=By.id("id_gender1");
    By titleMrsButton=By.id("id_gender2");
    By nameField=By.id("name");
    By emailAddress=By.xpath("(//input[@name='email'])[2]");
    By name=By.name("name");
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
    By signUpLoginBtn=By.linkText("Signup / Login");
    By signup1=By.xpath("//button[contains(text(),'Signup')]");
    By signup2=By.xpath("//button[contains(text(),'Create Account')]");
    By alreadyExistMsg=By.xpath("//p[contains(text(),'Email Address already exist!')]");
    By accountCreated=By.xpath("//h2[@class='title text-center']");
//    By loginMail=By.name("email");
//    By loginPassword=By.name("password");
    By loginBtn=By.xpath("//button[contains(text(),'Login')]");
    By logoutBtn=By.linkText("Logout");
    By incorrectCredentials=By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }
//    public WebElement LogoutBtn(){
//        return driver.findElement(logoutBtn);
//    }
//    public WebElement incorrectMailPassword(){
//        return driver.findElement(incorrectCredentials);
//    }
//    public void loginWithMail(String mail){
//        driver.findElement(loginMail).sendKeys(mail);
//    }
//    public void loginWithPassword(String password){
//        driver.findElement(loginPassword).sendKeys(password);
//    }
//    public void login(String mail,String password){
//        loginWithMail(mail);
//        loginWithPassword(password);
//        driver.findElement(loginBtn).click();
//    }

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
    public void chooseMrButton(){
        driver.findElement(titleMrButton).click();
    }
    public void chooseMrsButton(){
        driver.findElement(titleMrsButton).click();
    }
    public WebElement getNameField(){
        return driver.findElement(name);
    }
    public WebElement getEmailField(){
        return driver.findElement(emailAddress);
    }

    public void enterNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
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
    public void enterFirstName(String firstName){
        driver.findElement(FirstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(LastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company){
        driver.findElement(companyField).sendKeys(company);
    }
    public void enterAddress1(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void enterAddress2(String address){
        driver.findElement(addressOptionalField).sendKeys(address);
    }
    public void enterCountry(String country){
        Select selectCountry=new Select(driver.findElement(dropDownCountry));
        selectCountry.selectByValue(country);
    }
    public WebElement getAlreadyExistMsg(){
        return driver.findElement(alreadyExistMsg);
    }
    public void enterState(String state){
        driver.findElement(stateField).sendKeys(state);
    }
    public void enterCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void enterZipcode(String zipcode){
        driver.findElement(ZipcodeField).sendKeys(zipcode);
    }
    public void enterMobileNumber(String mobileNumber){
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }
    public void clickOnSignUp2(){
        driver.findElement(signup2).click();
    }
    public void signUp(String name, String emailAddress){
        signUpName(name);
        signUpEmail(emailAddress);
        clickOnSignUp1();
    }
    public WebElement confirmationCreationMsg(){
        return driver.findElement(accountCreated);
    }

}
