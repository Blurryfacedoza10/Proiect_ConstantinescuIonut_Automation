package pages;

//Clasele Page Object Model (POM) care izolează locatorii web și acțiunile specifice: `CartPage`, `ContactPage`, `HomePage`, `LoginPage` și `ProductPage`.//

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private By productTitle = By.cssSelector("[data-test='product-title']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).isDisplayed();
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText().trim();
    }
}