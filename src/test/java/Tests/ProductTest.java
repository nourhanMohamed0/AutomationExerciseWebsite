package Tests;

import BaseTest.Base;
import Pages.ProductsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest extends Base {
    ProductsPage productsPage;

    @BeforeTest
    public void setup() {
        productsPage = new ProductsPage(driver);
        productsPage.getProductsBtn().click();
        Assert.assertTrue(productsPage.getAllProductTxt().isDisplayed());
    }

    @Test
    public void testRelevantSearch()  {
        List<String> allSearchedItems = productsPage.getAllProducts(); // Get all products initially

        for (String product : allSearchedItems) {
            productsPage.clearSearchBar(); // Clear search bar before typing
            productsPage.Search(product); // Search for the product
            List<String> afterSearchedItems = productsPage.getAllProducts();
            wait.until(ExpectedConditions.visibilityOf(productsPage.getProductsNames()));
            softAssert.assertTrue(afterSearchedItems.contains(product),
                    "Product '" + product + "' not found after search");
        }
        softAssert.assertAll();
    }
}
