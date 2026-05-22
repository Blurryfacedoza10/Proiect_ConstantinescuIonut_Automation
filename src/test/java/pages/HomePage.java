package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    private By searchInput = By.cssSelector("[data-test='search-query']");
    private By searchButton = By.cssSelector("[data-test='search-submit']");
    private By firstProductTitle = By.cssSelector(".card-title");
    private By firstProductCard = By.cssSelector(".card");
    private By sortDropdown = By.cssSelector("[data-test='sort']");
    private By productPrices = By.cssSelector("[data-test='product-price']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public String getFirstProductTitle(String expectedKeyword) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(firstProductTitle, expectedKeyword));
        return driver.findElement(firstProductTitle).getText();
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductCard)).click();
    }

    public void selectSortBy(String visibleText) {
        WebElement firstProductBeforeSort = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductCard));
        Select sortSelect = new Select(wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)));
        sortSelect.selectByVisibleText(visibleText);
        wait.until(ExpectedConditions.stalenessOf(firstProductBeforeSort));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductCard));
    }

    public List<Double> getAllProductPrices() {
        List<WebElement> priceElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrices));
        List<Double> pricesList = new ArrayList<>();

        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("$", "").replace("€", "").trim();
            pricesList.add(Double.parseDouble(priceText));
        }
        return pricesList;
    }
}