package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By productName = By.cssSelector("[data-test='product-name']");
    private By addToCartButton = By.cssSelector("[data-test='add-to-cart']");
    private By cartMenu = By.cssSelector("[data-test='nav-cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText().trim();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartMenu)).click();
    }
}