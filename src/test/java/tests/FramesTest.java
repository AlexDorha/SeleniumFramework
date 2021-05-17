package tests;

import base.BaseTest;
import extentUtility.ExtentReport;
import help.ElementMethods;
import help.FrameMethods;
import help.PageMethods;
import propertyUtility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FramesTest extends BaseTest {

    public PropertiesFile propertiesFile;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;
    public ExtentReport reportHtml;

    @Test
    public void FrameAutomation(){
        propertiesFile = new PropertiesFile("FramesData");
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        reportHtml = new ExtentReport("FramesTestReport");

        //validam pagina pe care ne aflam
        pageMethods.ValidateTitlePage("Index");

        WebElement SkipSignInWeb = driver.findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipSignInWeb);
        reportHtml.AttachReport("pass","I click on Skip Sign In button");


        //mutam mouse-ul pe un anumit element (hover)
        WebElement SwitchToMenuWeb = driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]"));
        elementMethods.HoverElement(SwitchToMenuWeb);

        elementMethods.WaitVisibleElement(By.xpath("//a[contains(text(),'Frames')]"));
        WebElement FramesSubMenuWeb = driver.findElement(By.xpath("//a[contains(text(),'Frames')]"));
        elementMethods.ClickElement(FramesSubMenuWeb);
        reportHtml.AttachReport("pass","I navigate to Frames page");


        pageMethods.NavigateToPage("http://demo.automationtesting.in/Frames.html");

        pageMethods.ValidateTitlePage("Frames");

        List<WebElement> iframeListOptions = driver.findElements(By.xpath("//ul[@class='nav nav-tabs ']/li/a"));
        //single iframe
        iframeListOptions.get(0).click();
        frameMethods.SwithToIFrameByIdName("singleframe");
        WebElement InputSingleIFrame = driver.findElement(By.xpath("//input[@type='text']"));
        elementMethods.FillElement(InputSingleIFrame, propertiesFile.GetValueBasedONKey("SingleFrameKey"));
        frameMethods.SwitchToDefaultFrame();

        //multiple iframe
        iframeListOptions.get(1).click();
        frameMethods.SwithToIFrameByIdentificator(By.xpath("//iframe[@src='MultipleFrames.html']"));
        frameMethods.SwithToIFrameByIdentificator(By.xpath("//iframe[@src='SingleFrame.html']"));
        WebElement InputMultipleIFrame = driver.findElement(By.xpath("//input[@type='text']"));
        elementMethods.FillElement(InputMultipleIFrame, propertiesFile.GetValueBasedONKey("MultipleFrameKey"));
        frameMethods.SwitchToDefaultFrame();
        reportHtml.AttachReport("pass","I deal with all types of iframes");
        reportHtml.GenerateReport();

    }
}
