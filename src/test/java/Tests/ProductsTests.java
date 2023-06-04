package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ProductsTests extends BaseTest {
    @Test(groups = {"regression"}, description = "Тестирование валидной информации о товарах в каталоге")
    public void productInfoTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        String actualItemPrice = productsPage.getItemPrice(testItemName);
        String expectedItemPrice = "$29.99";
        assertEquals(actualItemPrice, expectedItemPrice);
        String actualItemDescription = productsPage.getItemDescription(testItemName);
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined " +
                "Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        assertEquals(actualItemDescription, expectedItemDescription);
    }

    @Test(groups = {"smoke"}, description = "Тестирование кнопки addToCart")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCartButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        Assert.assertTrue(productsPage.removeButtonIsDisplayed());
    }

    @Test(groups = {"regression"}, description = "Тестирование кнопки Remove")
    public void removeButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickRemoveButton(testItemName);
        Assert.assertTrue(productsPage.addToCartButtonIsDisplayed());
    }

    @Test(groups = {"regression"}, description = "Тестирование открытия формы товара")
    public void openItemTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItem(testItemName);
        Assert.assertTrue(productDetailsPage.addToCartButtonIsDisplayed());

    }

    @Test(groups = {"regression"}, dataProvider = "productsInfoTestData")
    public void productInfoTestNew(String ItemName, String expectedItemPrice, String expectedDescription) {
        loginPage.login(USERNAME, PASSWORD);
        assertEquals(productsPage.getItemPrice(ItemName), expectedItemPrice);
        assertEquals(productsPage.getItemDescription(ItemName), expectedDescription);

    }

    @DataProvider
    public Object[][] productsInfoTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined " +
                        "Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when " +
                        "riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. " +
                        "From American Apparel, 100% ringspun combed cotton, " +
                        "heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip " +
                        "fleece jacket capable of handling everything from a relaxing " +
                        "day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, " +
                        "two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. " +
                        "Super-soft and comfy ringspun combed cotton."}
        };
    }

}


