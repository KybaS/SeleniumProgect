package configure;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends ConciseAPI {

    public static WebDriver driver = new FirefoxDriver();
    // public static WebDriver driver = new ChromeDriver();

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
