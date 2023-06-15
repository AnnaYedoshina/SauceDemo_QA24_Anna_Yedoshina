package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage {
    @Override
    public ProductDetailsPage open() {
        driver.get("https://www.saucedemo.com/inventory-item.html?id=4");
        return this;

    }

    @Override
    public ProductDetailsPage isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        return this;

    }

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButtonLocator = By.cssSelector("button[id |= 'add-to-cart'");

    public boolean addToCartButtonIsDisplayed() {

        return driver.findElement(addToCartButtonLocator).isDisplayed();
    }
}
