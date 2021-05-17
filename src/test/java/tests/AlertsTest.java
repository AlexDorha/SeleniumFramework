package tests;

import base.BaseTest;
import extentUtility.ExtentReport;
import help.AlertMethods;
import help.ElementMethods;
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

import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AlertsTest extends BaseTest {

    public PropertiesFile propertiesFile;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;
    public ExtentReport reportHtml;


    @Test
    public void AlertsAutomation(){
        propertiesFile = new PropertiesFile("AlertsData");
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);
        reportHtml = new ExtentReport("AlertsTest");

        //validam pagina pe care ne aflam
        pageMethods.ValidateTitlePage("Index");

        WebElement SkipSignInWeb = driver.findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipSignInWeb);
        reportHtml.AttachReport("pass","I click on Skip Sign In button");

        //mutam mouse-ul pe un anumit element (hover)
        WebElement SwitchToMenuWeb = driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]"));
        elementMethods.HoverElement(SwitchToMenuWeb);

        //declaram un wait explicit
        elementMethods.WaitVisibleElement(By.xpath("//a[contains(text(),'Alerts')]"));
        WebElement AlertsSubMenuWeb = driver.findElement(By.xpath("//a[contains(text(),'Alerts')]"));
        elementMethods.ClickElement(AlertsSubMenuWeb);
        reportHtml.AttachReport("pass","I enter on Alerts page");


        //navigam catre un anumit url
        pageMethods.NavigateToPage("http://demo.automationtesting.in/Alerts.html");

        //validam pagina de Alerts
        pageMethods.ValidateTitlePage("Alerts");

        List<WebElement> AlertTypesWeb = driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        //alert with ok
        AlertTypesWeb.get(0).click();
        WebElement ClickAlertOk = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        ClickAlertOk.click();
        alertMethods.AlertAccept();

        //alert with cancel
        AlertTypesWeb.get(1).click();
        WebElement ClickAlertOkCancel = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        ClickAlertOkCancel.click();
        alertMethods.AlertDismiss();

        //alert with text
        AlertTypesWeb.get(2).click();
        WebElement ClickAlertText = driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        ClickAlertText.click();
        alertMethods.AlertTextAccept(propertiesFile.GetValueBasedONKey("AlertText"));
        reportHtml.AttachReport("pass","I deal with all types of alerts");
        reportHtml.GenerateReport();

    }
}
