package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ShoppingCartPage extends BasePage {
    public By continueShoppingButton = By.cssSelector("#continue-shopping");
    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By removeButtonLocator = By.cssSelector("button[id |= 'remove'");
    private By checkOutButtonLocator = By.cssSelector("#checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isContinueShoppingIsDisplayed() {

        return driver.findElement(continueShoppingButton).isDisplayed();
    }

    @Step
    public void clickContinueShoppingButton() {

        driver.findElement(continueShoppingButton).click();
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
    public void clickRemoveButton() {

        driver.findElement(removeButtonLocator).click();
    }

    public boolean itemNameIsNotDisplayed() {

        return driver.findElement(itemNameLocator).isDisplayed();
    }

    @Step
    public void clickCheckOutButton() {

        driver.findElement(checkOutButtonLocator).click();
    }
}

