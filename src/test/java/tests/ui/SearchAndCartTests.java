package tests.ui;

import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

@Listeners(utils.TestListener.class)
public class SearchAndCartTests extends BaseTest {

    @Test(priority = 1)
    public void testCautareProdus() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct(TestData.UI_SEARCH_KEYWORD);
        String titluProdus = homePage.getFirstProductTitle(TestData.UI_SEARCH_KEYWORD);
        Assert.assertTrue(titluProdus.contains(TestData.UI_SEARCH_KEYWORD),
                "Eroare: Primul produs afișat nu conține cuvântul căutat!");
    }

    @Test(priority = 2)
    public void testAdaugareInCos() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct(TestData.UI_SEARCH_KEYWORD);
        homePage.getFirstProductTitle(TestData.UI_SEARCH_KEYWORD);
        homePage.clickFirstProduct();
        ProductPage productPage = new ProductPage(driver);
        String expectedProductName = productPage.getProductName();
        productPage.clickAddToCart();
        productPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductDisplayed(), "Produsul nu a apărut în coș!");
        Assert.assertEquals(cartPage.getProductName(), expectedProductName, "Numele produsului din coș este greșit!");
    }
}
