package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseTest {

    @Test(groups = {"smoke"}, description = "Тестирование checkOut формы")
    public void positiveCheckoutTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        Assert.assertTrue(checkoutOverviewPage.finishButtonIsDisplayed());
    }

    @Test(groups = {"regression"}, description = "Тестирование информации продукта в форме CheckOutOverview")
    public void checkProductTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        String actualItemName = checkoutOverviewPage.getItemName();
        String expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName, expectedItemName);
        String actualItemDescription = checkoutOverviewPage.getItemDescription();
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
        String actualItemPrice = checkoutOverviewPage.getItemPrice();
        String expectedItemPrice = "$29.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
        String actualItemTotal = checkoutOverviewPage.getItemTotal();
        String expectedItemTotal = "Item total: $29.99";
        Assert.assertEquals(actualItemTotal, expectedItemTotal);
        String actualItemTax = checkoutOverviewPage.getItemTax();
        String expectedItemTax = "Tax: $2.40";
        Assert.assertEquals(actualItemTax, expectedItemTax);
        String actualTotalPrice = checkoutOverviewPage.getTotalPrice();
        String expectedTotalPrice = "Total: $32.39";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    @Test(groups = {"regression"}, description = "Тестирование кнопки cancel в форме CheckOutOverview")
    public void cancelButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        checkoutOverviewPage.clickCancelButton();
        productsPage.getItemDescription(testItemName);
        String actualItemDescriptionNew = productsPage.getItemDescription(testItemName);
        String expectedItemDescriptionNew = "carry.allTheThings() with the sleek, streamlined " +
                "Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescriptionNew, expectedItemDescriptionNew);
    }
}

