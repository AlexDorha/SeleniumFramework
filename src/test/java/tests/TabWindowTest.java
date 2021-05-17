package tests;

import base.BaseTest;
import extentUtility.ExtentReport;
import help.ElementMethods;
import help.PageMethods;
import help.TabWindowMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest extends BaseTest {

    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public TabWindowMethods tabWindowMethods;
    public ExtentReport reportHtml;

    @Test
    public void TabWindowAutomation(){

        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        tabWindowMethods = new TabWindowMethods(driver);
        reportHtml = new ExtentReport("TabWindowTest");

        //validam pagina pe care ne aflam
        pageMethods.ValidateTitlePage("Index");

        WebElement SkipSignInWeb = driver.findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipSignInWeb);
        reportHtml.AttachReport("pass","I click on Skip Sign In button");


        //mutam mouse-ul pe un anumit element (hover)
        WebElement SwitchToMenuWeb = driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]"));
        elementMethods.HoverElement(SwitchToMenuWeb);

        elementMethods.WaitVisibleElement(By.xpath("//li[@class='dropdown']/ul/li/a[contains(text(),'Windows')]"));
        WebElement WindowsSubMenuWeb = driver.findElement(By.xpath("//li[@class='dropdown']/ul/li/a[contains(text(),'Windows')]"));
        elementMethods.ClickElement(WindowsSubMenuWeb);
        reportHtml.AttachReport("pass","I enter on Windows page");


        pageMethods.NavigateToPage("http://demo.automationtesting.in/Windows.html");

        List<WebElement> tabWindowOptions = driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        //new tab
        tabWindowOptions.get(0).click();
        WebElement ClickTabButton = driver.findElement(By.xpath("//div[@id='Tabbed']/a/button"));
        ClickTabButton.click();
        tabWindowMethods.SwitchToSpecificTabWindowByIndex(1);
        tabWindowMethods.CloseCurrentTabWindow();
        tabWindowMethods.SwitchToSpecificTabWindowByIndex(0);

        //new window
        tabWindowOptions.get(1).click();
        WebElement ClickWindowButton = driver.findElement(By.xpath("//div[@id='Seperate']/button"));
        ClickWindowButton.click();
        tabWindowMethods.SwitchToSpecificTabWindowByIndex(1);
        tabWindowMethods.CloseCurrentTabWindow();
        tabWindowMethods.SwitchToSpecificTabWindowByIndex(0);

        //multiple tabs
        tabWindowOptions.get(2).click();
        WebElement ClickMultipleTabsButton = driver.findElement(By.xpath("//div[@id='Multiple']/button"));
        ClickMultipleTabsButton.click();
        tabWindowMethods.SwitchToSpecificTabWindowByIndex(2);
        tabWindowMethods.CloseCurrentTabWindow();
        tabWindowMethods.SwitchToSpecificTabWindowByIndex(1);
        tabWindowMethods.CloseCurrentTabWindow();
        tabWindowMethods.SwitchToSpecificTabWindowByIndex(0);
        reportHtml.AttachReport("pass","I deal with all types of tabs and windows");
        reportHtml.GenerateReport();

    }
}
