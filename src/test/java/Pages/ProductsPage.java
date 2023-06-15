package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsPage extends BasePage {
    private By shoppingCartLink = By.cssSelector("a.shopping_cart_link");
    private By itemsLocator = By.cssSelector(".inventory_item");

    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By addToCartButtonLocator = By.cssSelector("button[id |= 'add-to-cart']");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By removeButtonLocator = By.cssSelector("button[id |= 'remove']");

    @Override
    public ProductsPage open() {
        driver.get("https://www.saucedemo.com/inventory.html");
        return this;


    }

    @Override
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        return this;

    }

    public ProductsPage(WebDriver driver) {

        super(driver);
    }

    public boolean isShoppingCartLinkDisplayed() {

        return driver.findElement(shoppingCartLink).isDisplayed();
    }

    public boolean removeButtonIsDisplayed() {

        return driver.findElement(removeButtonLocator).isDisplayed();
    }

    public boolean addToCartButtonIsDisplayed() {

        return driver.findElement(addToCartButtonLocator).isDisplayed();
    }

    @Step
    public ProductsPage clickAddToCartButton(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(addToCartButtonLocator).click();
        return this;
    }

    @Step
    public ProductsPage clickRemoveButton(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(removeButtonLocator).click();
        return this;
    }

    @Step
    public ProductDetailsPage openItem(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(itemNameLocator).click();
        return new ProductDetailsPage(driver);
    }

    @Step("getting item price")
    public String getItemPrice(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        return itemContainer.findElement(itemPriceLocator).getText();
    }

    @Step("getting item description")
    public String getItemDescription(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        return itemContainer.findElement(itemDescriptionLocator).getText();
    }

    @Step
    public ShoppingCartPage clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
        return new ShoppingCartPage(driver);
    }

    private WebElement getItemContainerByName(String itemName) {
        List<WebElement> allItems = driver.findElements(itemsLocator);
        for (WebElement item : allItems) {
            if (item.findElement(itemNameLocator).getText().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

}
