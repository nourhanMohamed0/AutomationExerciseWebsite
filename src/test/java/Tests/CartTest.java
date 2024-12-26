package Tests;

import BaseTest.Base;
import Pages.CartPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTest extends Base {
    CartPage cartPage;
    @BeforeTest
    public void setup(){
        cartPage=new CartPage(driver);
        cartPage.getCartBtn().click();
        softAssert.assertTrue(cartPage.getCartBtn().isEnabled());
    }
    @Test(dependsOnMethods = {"Tests.ProductTest.addToCartFunctionality"}, alwaysRun = true)
    public void test(){
        System.out.println("Hello");
    }
}
