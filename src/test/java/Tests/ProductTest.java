package Tests;

import BaseTest.Base;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductTest extends Base {
    ProductsPage productsPage;

    @BeforeTest
    public void setup() {
        productsPage = new ProductsPage(driver);
        productsPage.getProductsBtn().click();
        Assert.assertTrue(productsPage.getAllProductTxt().isDisplayed());
        Assert.assertTrue(productsPage.getProductsNames().isDisplayed());
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
    @Test
    public void testPartialSearch(){
        List <String> allProducts=productsPage.getAllProducts();
        for(String product :allProducts){
            productsPage.clearSearchBar();
            String partialWord=(product.length())>=5?product.substring(0,5):product;
            productsPage.Search(partialWord);
            List<String>afterSearchedItems=productsPage.getAllProducts();
            wait.until(ExpectedConditions.visibilityOf(productsPage.getProductsNames()));

            // Check if any product name contains the partial search term
            boolean isProductFound=false;
            for(String afterSearch:afterSearchedItems){
                if(afterSearch.toLowerCase().contains(partialWord.toLowerCase())){
                    isProductFound=true;
                    break;
                }
            }
            softAssert.assertTrue(isProductFound);
        }
    }
    @Test
    public void searchBlank(){
        productsPage.clearSearchBar();
        List<String> beforeProducts=productsPage.getAllProducts();
        productsPage.Search("");
        List<String> afterProducts=productsPage.getAllProducts();
        Assert.assertEquals(afterProducts, beforeProducts);
    }
    @Test
    public void searchWithMultipleProducts(){
        String product1="Blue Top";
        String product2="Men Tshirt";
        productsPage.Search(product1+" "+product2);
        List<String> afterResult=productsPage.getAllProducts();
        if (afterResult.isEmpty())
            Assert.fail();
        else{
            for(String product:afterResult){
                if(afterResult.contains(product1)||afterResult.contains(product2))
                    Assert.assertTrue(true);
            }
        }
    }
    @Test
    public void testWithDifferentLanguage(){
        String productWithDifferentLanguage="تيشيرت رجالي";
        String productWithSameLanguage="Men Tshirt";
        productsPage.Search(productWithDifferentLanguage);
        List<String> listWithDifferentLanguage=productsPage.getAllProducts();
        productsPage.clearSearchBar();
        productsPage.Search(productWithSameLanguage);
        List<String> listWithSameLanguage=productsPage.getAllProducts();
        Set<String> set1=new HashSet<>(listWithDifferentLanguage);
        Set<String> set2=new HashSet<>(listWithSameLanguage);
        Assert.assertEquals(set1,set2);
    }@Test
    public void testWithUnderScore(){
        String productWithUnderScore="Men_Tshirt";
        String OriginalProduct="Men Tshirt";
        productsPage.Search(productWithUnderScore);
        List<String> listWithUnderScore =productsPage.getAllProducts();
        productsPage.clearSearchBar();
        productsPage.Search(OriginalProduct);
        List<String> listWithOriginalProduct =productsPage.getAllProducts();
        Set<String> set1=new HashSet<>(listWithUnderScore);
        Set<String> set2=new HashSet<>(listWithOriginalProduct);
        Assert.assertEquals(set1,set2);
    }@Test
    public void testWithHyphens(){
        String productWithHyphens="Men-Tshirt";
        String OriginalProduct="Men Tshirt";
        productsPage.Search(productWithHyphens);
        List<String> listWithHyphens =productsPage.getAllProducts();
        productsPage.clearSearchBar();
        productsPage.Search(OriginalProduct);
        List<String> listWithOriginalProduct =productsPage.getAllProducts();
        Set<String> set1=new HashSet<>(listWithHyphens);
        Set<String> set2=new HashSet<>(listWithOriginalProduct);
        Assert.assertEquals(set1,set2);
    }
    @Test
    public void testWithCaseSensitive(){
        String OriginalProduct="Men Tshirt";
        String productLowerCase=OriginalProduct.toLowerCase();
        String productCapitalCase=OriginalProduct.toUpperCase();
        productsPage.Search(OriginalProduct);
        List<String> listWithOriginalProduct =productsPage.getAllProducts();
        productsPage.clearSearchBar();
        productsPage.Search(productLowerCase);
        List<String> listWithLowerCase =productsPage.getAllProducts();
        productsPage.clearSearchBar();
        productsPage.Search(productCapitalCase);
        List<String> listWithCapitalCase =productsPage.getAllProducts();
        Set<String> originalSet=new HashSet<>(listWithOriginalProduct);
        Set<String> lowerSet=new HashSet<>(listWithLowerCase);
        Set<String> capitalSet=new HashSet<>(listWithCapitalCase);
        softAssert.assertEquals(originalSet,lowerSet);
        softAssert.assertEquals(originalSet,capitalSet);
        softAssert.assertAll();
    }
    @Test
    public void VerifyAllProductsAndProductDetailPage(){
        List<WebElement> Btn=productsPage.getViewProductBtn2();
        for(WebElement button:Btn){
            button.click();
            softAssert.assertFalse(productsPage.getProductBrand().isEmpty());
            softAssert.assertFalse(productsPage.getProductAvailability().isEmpty());
            softAssert.assertFalse(productsPage.getProductCategory().isEmpty());
            softAssert.assertFalse(productsPage.getProductPrice().isEmpty());
            softAssert.assertFalse(productsPage.getProductName().isEmpty());
            softAssert.assertFalse(productsPage.getProductCondition().isEmpty());
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOf(productsPage.getAllProductTxt()));
        }
        softAssert.assertAll();}
}
