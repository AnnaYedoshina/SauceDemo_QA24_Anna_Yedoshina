package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTests extends BaseTest {
    @Test
    public void productInfoTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        String actualItemPrice = productsPage.getItemPrice(testItemName);
        String expectedItemPrice = "$29.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
        String actualItemDescription = productsPage.getItemDescription(testItemName);
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined " +
                "Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
    }
    @Test
    public void addToCartButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        Assert.assertTrue(productsPage.removeButtonIsDisplayed());
    }
    @Test
    public void removeButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickRemoveButton(testItemName);
        Assert.assertTrue(productsPage.addToCartButtonIsDisplayed());
    }
    @Test
    public void openItemTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItem(testItemName);
        Assert.assertTrue(productDetailsPage.addToCartButtonIsDisplayed());

    }
}


