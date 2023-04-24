import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class LandingPageTests {

    private static WebDriver driver;

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

    // Close the browser
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
