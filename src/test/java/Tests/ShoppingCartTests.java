package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {

    @Test(groups = {"regression"}, description = "Тестирование формы Корзина, после добавления в нее товара")
    public void shoppingCartTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        String actualItemName = shoppingCartPage.getItemName();
        String expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName, expectedItemName);
        String actualItemDescription = shoppingCartPage.getItemDescription();
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
        String actualItemPrice = shoppingCartPage.getItemPrice();
        String expectedItemPrice = "$29.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
    }

    @Test(groups = {"smoke"}, description = "Тестирование конпки ContinueShoppingButton")
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

    @Test(groups = {"smoke"}, description = "тестирование кнопки CheckOuе")
    public void shoppingCartCheckOutButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutPage.firstNameInputIsDisplayed());
    }
}
