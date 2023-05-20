package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {

    @Test
    public void shoppingCartTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        String actualItemName = shoppingCartPage.getItemName(testItemName);
        String expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName, expectedItemName);
        String actualItemDescription = shoppingCartPage.getItemDescription(testItemName);
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
        String actualItemPrice = shoppingCartPage.getItemPrice(testItemName);
        String expectedItemPrice = "$29.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
    }

    @Test
    public void shoppingCartContinueShoppingButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickContinueShoppingButton();
        productsPage.getItemDescription(testItemName);
        String actualItemDescriptionNew = productsPage.getItemDescription(testItemName);
        String expectedItemDescriptionNew = "carry.allTheThings() with the sleek, streamlined " +
                "Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescriptionNew, expectedItemDescriptionNew);
    }

    @Test
    public void shoppingCartCheckOutButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutPage.firstNameInputIsDisplayed());


    }
}
