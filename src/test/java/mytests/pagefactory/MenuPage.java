package mytests.pagefactory;

import configure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MenuPage extends BasePage {

    public void selectDeserts() {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-internal='27803']")));
        driver.findElement(By.xpath("//*[@data-internal='27803']")).click();
    }

    public void selectCheesecakes() {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-internal='31312']")));
        driver.findElement(By.xpath("//*[@data-internal='31312']")).click();
    }

    public void selectOriginal() {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-internal='26316']")));
        driver.findElement(By.xpath("//*[@data-internal='26316']")).click();
    }

    public void assertCopyright(String text) {
        WebElement copyright = driver.findElement(By.xpath("//div[@class='copyright']"));
        assertEquals(text, copyright.getText());
    }

    public void assertTitle(String title) {
        assertTrue(driver.getTitle().equals(title));
    }

    public void assertCheesecakesDescription(String excepted) {
        WebElement description = driver.findElement(By.className("food-menu-item-description"));
        assertEquals(excepted, description.getText());
    }

    @FindBy(xpath = "//a[@class='head-menu']")
    public WebElement menu;

    public MenuPage(WebDriver driver) {
        super(driver);
    }
}
