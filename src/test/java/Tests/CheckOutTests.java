package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTests extends BaseTest {

    @Test(groups = {"smoke"}, description = "Тестирование формы checkOut")
    public void positiveCheckout() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.setFirstNameValue("Anna");
        checkOutPage.setLastNameValue("Yedoshina");
        checkOutPage.setPostalCodeValue("12345");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.finishButtonIsDisplayed());
    }

    @Test(groups = {"regression"}, description = "Тестирование кнопки cancel")
    public void cancelButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.clickCancelButton();
        Assert.assertTrue(shoppingCartPage.isContinueShoppingIsDisplayed());

    }
}
