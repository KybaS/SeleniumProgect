package configure;

import org.openqa.selenium.WebDriver;

public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public void open(String url) {
        getWebDriver().get(url);
    }
}
