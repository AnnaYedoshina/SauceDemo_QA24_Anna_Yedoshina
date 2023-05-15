import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemo1 {
    private static final String URL = "https://www.saucedemo.com/";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void loginTest() {
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("standard_user");
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[type = submit]"));
        loginButton.click();
        WebElement productsTitle = driver.findElement(By.cssSelector("span[class=title]"));
        Assert.assertTrue(productsTitle.isDisplayed());
        WebElement addToCartButtonBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButtonBackpack.click();
        WebElement removeButton = driver.findElement(By.cssSelector("button[name=remove-sauce-labs-backpack]"));
        Assert.assertTrue(removeButton.isDisplayed());
        WebElement cartButton = driver.findElement(By.cssSelector("a[class=shopping_cart_link]"));
        cartButton.click();
        WebElement yourCartTitle = driver.findElement(By.cssSelector("span[class = title]"));
        Assert.assertTrue(yourCartTitle.isDisplayed());
        WebElement backPackName = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']"));
        String expectedBackPackName = "Sauce Labs Backpack";
        Assert.assertEquals(backPackName.getText(), expectedBackPackName);
        WebElement backPackPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals("$29.99", backPackPrice.getText());


    }
}
