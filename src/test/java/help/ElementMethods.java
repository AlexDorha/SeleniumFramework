package help;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMethods {

    public WebDriver driver;

    public ElementMethods(WebDriver driver){
        this.driver = driver;
    }

    public void WaitVisibleElement(By identificator){
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(identificator));
    }

    public void WaitVisibleElement(WebElement element){
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(element));
    }

    public void ClickElement(WebElement element){
        WaitVisibleElement(element);
        element.click();
    }

    public void FillElement(WebElement element, String value){
        WaitVisibleElement(element);
        element.sendKeys(value);
    }

    public void HoverElement(WebElement element){
        WaitVisibleElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void SelectElementByText(WebElement element, String value){
        WaitVisibleElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void SelectElementByValue(WebElement element, String value){
        WaitVisibleElement(element);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void ValidateElementMessage(WebElement element, String value){
        WaitVisibleElement(element);
        Assert.assertEquals("The element message was not as expected...",value,element.getText());
    }
}
