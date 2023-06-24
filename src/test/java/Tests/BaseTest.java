package Tests;

import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.InvokedListener;
import utils.PropertyReader;
import utils.TestLiner;

import java.time.Duration;

@Listeners({TestLiner.class, InvokedListener.class})
public abstract class BaseTest {
    private final static String URL = PropertyReader.getProperty("url");
    protected final static String USERNAME = PropertyReader.getProperty("username");
    protected final static String PASSWORD = PropertyReader.getProperty("password");
    protected final static String FIRSTNAME = "Anna";
    protected final static String LASTNAME = "Yedoshina";
    protected final static String POSTALCODE = "12345";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckOutPage checkOutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected ProductDetailsPage productDetailsPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext context) throws Exception {
        String browserName = System.getProperty("browser", PropertyReader.getProperty("browser"));
        String isHeadless = System.getProperty("headless", PropertyReader.getProperty("isHeadless"));
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless.equals("true")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        } else {
            throw new Exception("Unsupported browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
}
