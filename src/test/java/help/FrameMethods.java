package help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameMethods {

    public WebDriver driver;

    public FrameMethods(WebDriver driver){
        this.driver = driver;
    }

    public void SwithToIFrameByIdName(String name){
        driver.switchTo().frame(name);
    }

    public void SwithToIFrameByIdentificator(By identificator){
        driver.switchTo().frame(driver.findElement(identificator));
    }

    public void SwitchToDefaultFrame(){
        driver.switchTo().defaultContent();
    }

}
