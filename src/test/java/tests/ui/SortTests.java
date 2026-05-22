package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

@Listeners(utils.TestListener.class)
public class SortTests extends BaseTest {

    @Test
    public void testSortarePretDescrescator() {
        HomePage homePage = new HomePage(driver);
        homePage.selectSortBy("Price (High - Low)");
        List<Double> prices = homePage.getAllProductPrices();
        boolean isSortedCorrectly = true;
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                isSortedCorrectly = false;
                System.out.println("Eroare de sortare găsită: " + prices.get(i) + " nu este mai mare decât " + prices.get(i + 1));
                break;
            }
        }

        Assert.assertTrue(isSortedCorrectly, "Lista de prețuri nu a fost sortată descrescător în mod corect!");
    }
}