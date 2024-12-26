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
    By addToCartBtn=By.xpath("//a[text()='Add to cart']");
    By addToCartConfirm=By.className("modal-content");
    By cartButton=By.linkText("Cart");
    By viewProductBtn=By.xpath("//a[contains(text(),'View Product')]");
    By productPrice=By.xpath("//span[contains(text(),'Rs')]");
    By productName=By.xpath("(//h2[contains(text(),'')])[3]");
    By productCategory=By.xpath("(//p[contains(text(),'')])[3]");
    By productAvailability=By.xpath("//p[b[text()='Availability:']]");
    By productCondition=By.xpath("//p[b[text()='Condition:']]");
    By productBrand=By.xpath("//p[b[text()='Brand:']]");
    By continueShoppingBtn=By.xpath("//button[text()='Continue Shopping']");
    By productsNameInCart=By.xpath("//h4/a[contains(text(),'')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductsBtn() {
        return driver.findElement(productsBtn);
    }
    public List<WebElement> getProductsNameInCart() {
        return driver.findElements(productsNameInCart);
    }
public WebElement getContinueShoppingBtn() {
        return driver.findElement(continueShoppingBtn);
    }

    public List<String> getAllProducts() {
        List<String> productNames = new ArrayList<>(); // Initialize a fresh list
        List<WebElement> products = driver.findElements(productsName);

        for (WebElement product : products) {
            productNames.add(product.getText());
        }

        return productNames;
    }
    public String getProductPrice(){
        String price=driver.findElement(productPrice).getText();
        return price.replace("Rs.","").trim();
    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public String getProductBrand(){
        String brand=driver.findElement(productBrand).getText();
        return brand.replace("Brand:","").trim();
    }
    public String getProductAvailability(){
         String availability= driver.findElement(productAvailability).getText();
         return availability.replace("Availability:","").trim();
    }
public String getProductCondition(){
         String condition= driver.findElement(productCondition).getText();
    return condition.replace("Condition:","").trim();
    }
public String getProductCategory(){
        return driver.findElement(productCategory).getText();
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
    public WebElement getAddToCartBtn(){
        return driver.findElement(addToCartBtn);
    }
    public WebElement getAddToCartConfirm(){
        return driver.findElement(addToCartConfirm);
    }
    public WebElement getCartBtn(){
        return driver.findElement(cartButton);
    }
public List<WebElement> getViewProductBtn(){
        return driver.findElements(viewProductBtn);
    }
public List<WebElement> getAddToCartButtons(){
        return driver.findElements(addToCartBtn);
    }


}
