package help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver = driver;
    }

    public void ValidateTitlePage(String title){
        new WebDriverWait(driver, 20).until(ExpectedConditions.titleIs(title));
        Assert.assertEquals("The desired title page was not displayed...",title, driver.getTitle());
    }

    public void NavigateToPage(String url){
        driver.navigate().to(url);
    }
}
