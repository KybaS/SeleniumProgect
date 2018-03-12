package mytests;

import configure.BaseTest;
import mytests.pagefactory.MenuPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void myTest() {

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://www.thecheesecakefactory.com/");
        menuPage.assertTitle("Welcome to The Cheesecake Factory");
        menuPage.assertCopyright("© 2002-" + getCurrentYear() + " TCF Co. LLC. All Rights Reserved.");

        menuPage.menu.click();
        menuPage.selectDeserts();
        menuPage.selectCheesecakes();
        menuPage.selectOriginal();

        menuPage.assertCheesecakesDescription("The One that Started it All! Our Famous Creamy Cheesecake with a Graham Cracker Crust and Sour Cream Topping.\n" +
                "Ship this cheesecake almost anywhere in the U.S.\n" +
                "Food Tags:  sour cream, cream cheese");
    }

    MenuPage menuPage = new MenuPage(driver);

    @After
    public void after() {
        driver.quit();
    }

    private static int getCurrentYear() {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }
}