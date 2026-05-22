package tests.ui;

import data.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(utils.TestListener.class)
public class LoginTests extends BaseTest {

    @Test
    public void testAutentificareValida_HappyFlow() {
        driver.findElement(By.cssSelector("[data-test='nav-sign-in']")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestData.UI_VALID_EMAIL, TestData.UI_VALID_PASS);

        Assert.assertEquals(driver.findElement(By.cssSelector("[data-test='page-title']")).getText(), "My account");
    }

    @Test
    public void testAutentificareInvalida_ValidareEroare() {
        driver.findElement(By.cssSelector("[data-test='nav-sign-in']")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestData.UI_INVALID_EMAIL, "ParolaGresita");

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password");
    }
}