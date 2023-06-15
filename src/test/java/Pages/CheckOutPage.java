package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage {
    @Override
    public CheckOutPage open() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;

    }

    @Override
    public CheckOutPage isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(canselButtonLocator));
        return this;

    }

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameInputLocator = By.id("first-name");
    private By lastNameInputLocator = By.id("last-name");
    private By postalCodeInputLocator = By.id("postal-code");
    private By continueButtonLocator = By.id("continue");
    private By canselButtonLocator = By.id("cancel");


    public boolean firstNameInputIsDisplayed() {
        return driver.findElement(firstNameInputLocator).isDisplayed();
    }

    public CheckOutPage setFirstNameValue(String firstName) {
        driver.findElement(firstNameInputLocator).sendKeys(firstName);
        return this;
    }

    public CheckOutPage setLastNameValue(String lastName) {
        driver.findElement(lastNameInputLocator).sendKeys(lastName);
        return this;
    }

    public CheckOutPage setPostalCodeValue(String postalCode) {
        driver.findElement(postalCodeInputLocator).sendKeys(postalCode);
        return this;
    }

    public CheckoutOverviewPage checkOut(String firstname, String lastName, String postalCode) {
        this.setFirstNameValue(firstname);
        this.setLastNameValue(lastName);
        this.setPostalCodeValue(postalCode);
        this.clickContinueButton();
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutOverviewPage clickContinueButton() {
        driver.findElement(continueButtonLocator).click();
        return new CheckoutOverviewPage(driver);
    }

    public ShoppingCartPage clickCancelButton() {
        driver.findElement(canselButtonLocator).click();
        return new ShoppingCartPage(driver);
    }
}

