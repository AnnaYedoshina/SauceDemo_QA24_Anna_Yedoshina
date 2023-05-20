package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    private final static String URL = "https://www.saucedemo.com/";
    protected final static String USERNAME = "standard_user";
    protected final static String PASSWORD = "secret_sauce";

    protected final static String FIRSTNAME = "Anna";
    protected final static String LASTNAME = "Yedoshina";
    protected final static String POSTALCODE = "12345";
    protected WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;
    ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    @BeforeMethod
    public void navigate() {
        driver.get(URL);
    }

}
