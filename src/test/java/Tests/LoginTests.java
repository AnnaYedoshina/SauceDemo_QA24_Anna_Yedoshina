package Tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void positiveLoginPage() {
        loginPage.setUsernameValue("standard_user");
        loginPage.setPasswordValue("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartLinkDisplayed());
    }

    @Test
    public void negativeLoginPage() {
        loginPage.login("", "secret_sauce");
        Assert.assertTrue(loginPage.isErrormessageIsDisplayed());

    }
}

