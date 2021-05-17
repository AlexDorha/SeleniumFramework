package help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TabWindowMethods {

    public WebDriver driver;

    public TabWindowMethods(WebDriver driver){
        this.driver = driver;
    }

    public void SwitchToSpecificTabWindowByIndex(int index){
        ArrayList<String> tabWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabWindows.get(index));
        System.out.println(driver.getTitle());
    }

    public void CloseCurrentTabWindow(){
        driver.close();
    }
}
