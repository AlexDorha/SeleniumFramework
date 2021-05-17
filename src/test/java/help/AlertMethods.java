package help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver){
        this.driver = driver;
    }

    public void AlertAccept(){
        new WebDriverWait(driver,20).until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    public void AlertDismiss(){
        new WebDriverWait(driver,20).until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    public void AlertTextAccept(String value){
        new WebDriverWait(driver,20).until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys(value);
        driver.switchTo().alert().accept();
    }
}
