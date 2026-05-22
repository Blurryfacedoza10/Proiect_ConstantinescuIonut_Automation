package tests.ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactPage;

@Listeners(utils.TestListener.class)
public class ContactTests extends BaseTest {

    @Test
    public void testTrimitereMesajContact_HappyFlow() {

        driver.findElement(By.cssSelector("[data-test='nav-contact']")).click();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillContactForm(
                "Ionut",
                "Constantinescu",
                "test@automation.com",
                "Webmaster",
                "Acesta este un mesaj automat de testare trimis prin Selenium WebDriver. Proiectul final QA funcționează perfect!"
        );
        contactPage.clickSubmit();
        String mesajConfirmare = contactPage.getSuccessMessage();
        Assert.assertTrue(mesajConfirmare.contains("Thanks for your message!"),
                "Eroare: Mesajul de confirmare nu a apărut sau este incorect!");
    }
}