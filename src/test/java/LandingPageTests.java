import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LandingPageTests {

    private static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeClass
    public static void setUp() {
        // Set the path to the ChromeDriver executable (if necessary)
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");


        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setHeadless(true);

        driver.get("https://commitquality.com/");
    }

    @Test
    public void testLandingPage() {
        String expectedTitle = "CommitQuality - Test Automation Demo";

        // Get the actual title of the webpage
        String actualTitle = driver.getTitle();

        // Verify that the actual title matches the expected title
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void checkTableRowCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-list-table")));
        // Select the table element using its class name
        WebElement table = driver.findElement(By.className("product-list-table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rowCount = rows.size();
        assertEquals(rowCount,11);
    }

    //verify page objects, create separate objects class
    //test filter
    //test reset
    //test add a product

    // Close the browser
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
