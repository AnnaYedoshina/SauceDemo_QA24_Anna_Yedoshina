package Tests;

import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Retry;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test(groups = {"smoke"}, description = "Тестирование Login формы", retryAnalyzer = Retry.class)
    @Description("Позитивный тест")
    @Link(name = "Home page", type = "href", url = "https://www.saucedemo.com/")
    @Severity(SeverityLevel.CRITICAL)
    public void positiveLoginTest() {
        loginPage.setUsernameValue("standard_user");
        loginPage.setPasswordValue("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartLinkDisplayed());
    }

    @Test(groups = {"smoke"}, description = "Тестирование Login формы негатив", dataProvider = "negativeLoginTestData")
    @Description("3 негативных теста формы Login")
    @Severity(SeverityLevel.CRITICAL)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }
}


