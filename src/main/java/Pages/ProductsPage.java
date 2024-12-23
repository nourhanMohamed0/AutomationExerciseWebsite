package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    By searchBar = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By allProductsTxt = By.xpath("//h2[contains(text(),'All Products')]");
    By productsName = By.cssSelector(".productinfo.text-center p");
    By womenCategory = By.linkText("Women");
    By productsBtn = By.partialLinkText("Prod");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductsBtn() {
        return driver.findElement(productsBtn);
    }

    public List<String> getAllProducts() {
        List<String> productNames = new ArrayList<>(); // Initialize a fresh list
        List<WebElement> products = driver.findElements(productsName);

        for (WebElement product : products) {
            productNames.add(product.getText());
        }

        return productNames;
    }

    public void Search(String search) {
        driver.findElement(searchBar).sendKeys(search);
        driver.findElement(searchBtn).click();
    }

    public WebElement getAllProductTxt() {
        return driver.findElement(allProductsTxt);
    }

    public void clearSearchBar() {
        driver.findElement(searchBar).clear();
    }
    public WebElement getProductsNames(){
        return driver.findElement(productsName);
    }
}
