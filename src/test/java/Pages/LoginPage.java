package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container");

    @Override
    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;

    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        return this;

    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("setting username input value={username}")
    public LoginPage setUsernameValue(String username) {
        driver.findElement(usernameInput).sendKeys(username);
        return this;
    }

    @Step("setting password input value={password}")
    public LoginPage setPasswordValue(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step
    public ProductsPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    @Step
    public ProductsPage login(String userName, String password) {
        this.setUsernameValue(userName);
        this.setPasswordValue(password);
        this.clickLoginButton();
        return new ProductsPage(driver);
    }

    public boolean isErrormessageIsDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();

    }

    @Step
    public String getErrorMessageText() {
        return driver.findElement(this.errorMessage).getText();

    }
}
