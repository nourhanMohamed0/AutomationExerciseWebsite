package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;
    By cartBtn= By.linkText("Cart");
    By productCartNames=By.xpath("//h4/a[contains(text(),'')]");
    By productPrices=By.xpath("//td[@class='cart_price']/p[contains(text(),'Rs')]");
    By productQuantities=By.xpath("//td[@class='cart_quantity']/button[@class='disabled']");
    By productTotal=By.xpath("//p[@class='cart_total_price']");
    /**********************************************************************************************/
    public CartPage(WebDriver driver){
     this.driver=driver;
    }
    public WebElement getCartBtn(){
        return driver.findElement(cartBtn);
    }
    public List<String> getProductCartNames(){
        List<WebElement> productsName=driver.findElements(productCartNames);
        List<String> productString=new ArrayList<>();
        for(WebElement products:productsName){
            productString.add(products.getText());
        }
        return productString;
    }
    public List<Integer> getProductsQuantitiesInCart(){
        List <WebElement> quantities=driver.findElements(productQuantities);
        List<Integer> quantitiesInteger=new ArrayList<>();
        for(WebElement iterator:quantities){
            quantitiesInteger.add(Integer.parseInt(iterator.getText()));
        }
        return(quantitiesInteger);
    }
public List<Integer> getProductsPricesInCart(){
        List <WebElement> prices=driver.findElements(productPrices);
        List<Integer> PricesInteger=new ArrayList<>();
        for(WebElement iterator:prices){
            String numberOnly = iterator.getText().replaceAll("[^0-9]", "");
            PricesInteger.add(Integer.parseInt(numberOnly));
        }
        return (PricesInteger);
    }
public List<Integer> getProductsTotalInCart(){
        List <WebElement> prices=driver.findElements(productTotal);
        List<Integer> PricesInteger=new ArrayList<>();
        for(WebElement iterator:prices){
            String numberOnly = iterator.getText().replaceAll("[^0-9]", "");
            PricesInteger.add(Integer.parseInt(numberOnly));
        }
        return (PricesInteger);
    }

}
