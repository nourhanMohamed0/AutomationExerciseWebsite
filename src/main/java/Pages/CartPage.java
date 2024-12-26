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

}
