package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By emailField = By.id("email");
    private By subjectDropdown = By.id("subject");
    private By messageField = By.id("message");
    private By submitButton = By.cssSelector("[data-test='contact-submit']");
    private By successAlert = By.cssSelector(".alert-success");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillContactForm(String firstName, String lastName, String email, String subject, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        Select subjectSelect = new Select(driver.findElement(subjectDropdown));
        subjectSelect.selectByVisibleText(subject);

        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert)).getText().trim();
    }
}