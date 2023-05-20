package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private By finishButtonLocator = By.id("finish");
    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By itemTotalLocator =By.cssSelector(".summary_subtotal_label");
    private By itemItemTaxLocator =By.cssSelector(".summary_tax_label");
    private By totalPriceLocator = By.cssSelector(".summary_info_label.summary_total_label");
    private By cancelButtonLocator = By.id("cancel");


    public boolean finishButtonIsDisplayed() {
        return driver.findElement(finishButtonLocator).isDisplayed();
    }

    public String getItemName(String itemName) {
        return driver.findElement(itemNameLocator).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(itemDescriptionLocator).getText();
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(itemPriceLocator).getText();

    }
    public String getItemTotal(String itemName){
        return driver.findElement(itemTotalLocator).getText();
    }
    public String getItemTax(String itemName){
        return driver.findElement(itemItemTaxLocator).getText();
    }
    public String getTotalPrice(String itemName){
        return driver.findElement(totalPriceLocator).getText();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButtonLocator).click();

    }
    public void clickFinishButton(){
        driver.findElement(finishButtonLocator).click();
    }
}

