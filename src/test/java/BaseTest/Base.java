package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public abstract class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String baseURL="https://automationexercise.com/";
    protected static SoftAssert softAssert;
    @BeforeSuite
    @Parameters("browser")
    public static void SetUp(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver();
        }
        driver.get(baseURL);
        softAssert=new SoftAssert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
}
