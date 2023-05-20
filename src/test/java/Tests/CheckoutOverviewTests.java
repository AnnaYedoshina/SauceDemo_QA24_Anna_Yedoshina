package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseTest {

    @Test
    public void positiveCheckoutTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        Assert.assertTrue(checkoutOverviewPage.finishButtonIsDisplayed());
    }
    @Test
            public void checkProductTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        String actualItemName = checkoutOverviewPage.getItemName(testItemName);
        String expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName, expectedItemName);
        String actualItemDescription = checkoutOverviewPage.getItemDescription(testItemName);
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
        String actualItemPrice = checkoutOverviewPage.getItemPrice(testItemName);
        String expectedItemPrice = "$29.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
        String actualItemTotal = checkoutOverviewPage.getItemTotal(testItemName);
        String expectedItemTotal = "Item total: $29.99";
        Assert.assertEquals(actualItemTotal, expectedItemTotal);
        String actualItemTax = checkoutOverviewPage.getItemTax(testItemName);
        String expectedItemTax = "Tax: $2.40";
        Assert.assertEquals(actualItemTax, expectedItemTax);
        String actualTotalPrice = checkoutOverviewPage.getTotalPrice(testItemName);
        String expectedTotalPrice = "Total: $32.39";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }
    @Test
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
    @Test
            public void finishButtonTest(){
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME,LASTNAME,POSTALCODE);
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.backHomeButtonIsDisplayed());











    }
}
