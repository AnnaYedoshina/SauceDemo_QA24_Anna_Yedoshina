package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ShoppingCartPage extends BasePage {
    public By continueShoppingButton = By.cssSelector("#continue-shopping");
    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By removeButtonLocator = By.cssSelector("button[id |= 'remove'");
    private By checkOutButtonLocator = By.cssSelector("#checkout");

    @Override
    public ShoppingCartPage open() {
        driver.get("https://www.saucedemo.com/cart.html");
        return this;

    }

    @Override
    public ShoppingCartPage isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButtonLocator));
        return this;

    }

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isContinueShoppingIsDisplayed() {

        return driver.findElement(continueShoppingButton).isDisplayed();
    }

    @Step
    public ProductsPage clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
        return new ProductsPage(driver);
    }

    public String getItemName() {

        return driver.findElement(itemNameLocator).getText();
    }

    public String getItemDescription() {

        return driver.findElement(itemDescriptionLocator).getText();
    }

    public String getItemPrice() {

        return driver.findElement(itemPriceLocator).getText();
    }

    @Step
    public ShoppingCartPage clickRemoveButton() {
        driver.findElement(removeButtonLocator).click();
        return this;
    }

    public boolean itemNameIsNotDisplayed() {

        return driver.findElement(itemNameLocator).isDisplayed();
    }

    @Step
    public CheckOutPage clickCheckOutButton() {
        driver.findElement(checkOutButtonLocator).click();
        return new CheckOutPage(driver);
    }
}

