package Tests;

import BaseTest.Base;
import Pages.CartPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends Base {
    CartPage cartPage;
    @BeforeTest
    public void setup(){
        cartPage=new CartPage(driver);
        cartPage.getCartBtn().click();
        softAssert.assertTrue(cartPage.getCartBtn().isEnabled());
    }
    @Test(dependsOnMethods = {"Tests.ProductTest.addToCartFunctionality"}, alwaysRun = true)
    public void CheckOnTotalByQuantity(){
        List<Integer> quantities=cartPage.getProductsQuantitiesInCart();
        List<Integer> prices=cartPage.getProductsPricesInCart();
        List<Integer> totals=cartPage.getProductsTotalInCart();
        for(int i=0;i<quantities.size();i++){
            softAssert.assertEquals(
                    Integer.valueOf(quantities.get(i) * prices.get(i)),
                    totals.get(i));
        }

    }
}
