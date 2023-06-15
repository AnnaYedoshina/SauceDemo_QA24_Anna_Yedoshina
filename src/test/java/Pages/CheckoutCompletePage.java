package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage {
    @Override
    public CheckoutCompletePage open() {
        driver.get("https://www.saucedemo.com/checkout-complete.html");
        return this;

    }

    @Override
    public CheckoutCompletePage isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButtonLocator));
        return this;

    }

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private By backHomeButtonLocator = By.id("back-to-products");

    public boolean backHomeButtonIsDisplayed() {

        return driver.findElement(backHomeButtonLocator).isDisplayed();
    }
}

