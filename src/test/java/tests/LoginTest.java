package tests;

import base.BaseTest;
import extentUtility.ExtentReport;
import help.ElementMethods;
import propertyUtility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseTest {

    public PropertiesFile propertiesFile;
    public ElementMethods elementMethods;
    public ExtentReport reportHtml;

    @Test
    public void LoginAutomation(){
        propertiesFile = new PropertiesFile("LoginData");
        elementMethods = new ElementMethods(driver);
        reportHtml = new ExtentReport("LoginTest");

        //declaram elementul SignIn si dam click pe el
        WebElement SignInWeb = driver.findElement(By.id("btn1"));
        elementMethods.ClickElement(SignInWeb);
        reportHtml.AttachReport("pass","I click on Sign In button");


        //declaram Email element si completam o valoare dorita
        WebElement EmailWeb = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String EmailValue = propertiesFile.GetValueBasedONKey("EmailKey");
        elementMethods.FillElement(EmailWeb, EmailValue);

        WebElement PasswordWeb = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String PasswordValue = propertiesFile.GetValueBasedONKey("PasswordKey");
        elementMethods.FillElement(PasswordWeb, PasswordValue);

        WebElement EnterButtonWeb = driver.findElement(By.id("enterbtn"));
        elementMethods.ClickElement(EnterButtonWeb);
        reportHtml.AttachReport("pass","I click on Enter button");


        //declaram elementul de eroare + validam textul de pe acesta
        WebElement ErrorMessageWeb = driver.findElement(By.id("errormsg"));
        elementMethods.ValidateElementMessage(ErrorMessageWeb, propertiesFile.GetValueBasedONKey("MessageKey"));
        reportHtml.AttachReport("pass","I validate error message displayed");
        reportHtml.GenerateReport();

    }
}
