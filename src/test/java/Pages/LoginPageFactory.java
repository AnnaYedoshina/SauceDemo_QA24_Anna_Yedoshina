package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageFactory extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = ".error-message-container")
    private WebElement errorMessage;

    @Override
    public LoginPageFactory open() {
        driver.get("https://www.saucedemo.com/");
        return this;

    }

    @Override
    public LoginPageFactory isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        return this;

    }

    public LoginPageFactory(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("setting username input value={username}")
    public LoginPageFactory setUsernameValue(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("setting password input value={password}")
    public LoginPageFactory setPasswordValue(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public ProductsPage clickLoginButton() {
        loginButton.click();
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
        return errorMessage.isDisplayed();

    }

    @Step
    public String getErrorMessageText() {
        return errorMessage.getText();

    }
}
