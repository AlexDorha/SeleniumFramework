package tests;

import base.BaseTest;
import extentUtility.ExtentReport;
import help.ElementMethods;
import propertyUtility.PropertiesFile;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends BaseTest {

    public PropertiesFile propertiesFile;
    public ElementMethods elementMethods;
    public ExtentReport reportHtml;

    @Test
    public void RegisterAutomation(){
        propertiesFile = new PropertiesFile("RegisterData");
        elementMethods = new ElementMethods(driver);
        reportHtml = new ExtentReport("RegisterTest");

        WebElement SkipSignInWeb = driver.findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipSignInWeb);
        reportHtml.AttachReport("pass","I click on Skip Sign In button");


        WebElement FirstNameWeb = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String FirstNameValue = propertiesFile.GetValueBasedONKey("FirstNameKey");
        elementMethods.FillElement(FirstNameWeb,FirstNameValue);

        WebElement LastNameWeb = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String LastNameValue = propertiesFile.GetValueBasedONKey("LastNameKey");
        elementMethods.FillElement(LastNameWeb, LastNameValue);

        WebElement EmailWeb = driver.findElement(By.xpath("//input[@type='email']"));
        String EmailValue = propertiesFile.GetValueBasedONKey("EmailKey");
        elementMethods.FillElement(EmailWeb, EmailValue);

        WebElement PhoneWeb = driver.findElement(By.xpath("//input[@type='tel']"));
        String PhoneValue = propertiesFile.GetValueBasedONKey("PhoneKey");
        elementMethods.FillElement(PhoneWeb,PhoneValue);

        WebElement GenderWeb = driver.findElement(By.xpath("//input[@value='Male']"));
        elementMethods.ClickElement(GenderWeb);

        WebElement HobbyWeb = driver.findElement(By.id("checkbox2"));
        elementMethods.ClickElement(HobbyWeb);

        //interactionam cu un webelement de tipul select(dropDown)
        WebElement CountryDropDownWeb = driver.findElement(By.id("countries"));
        elementMethods.SelectElementByText(CountryDropDownWeb,propertiesFile.GetValueBasedONKey("CountryKey"));

        WebElement YearDropDownWeb = driver.findElement(By.id("yearbox"));
        elementMethods.SelectElementByValue(YearDropDownWeb, propertiesFile.GetValueBasedONKey("YearKey"));

        WebElement MonthDropDownWeb = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        elementMethods.SelectElementByText(MonthDropDownWeb, propertiesFile.GetValueBasedONKey("MonthKey"));

        WebElement DayDropDownWeb = driver.findElement(By.id("daybox"));
        elementMethods.SelectElementByValue(DayDropDownWeb, propertiesFile.GetValueBasedONKey("DayKey"));

        WebElement PasswordWeb = driver.findElement(By.id("firstpassword"));
        String PasswordValue = propertiesFile.GetValueBasedONKey("PasswordKey");
        elementMethods.FillElement(PasswordWeb, PasswordValue);

        WebElement ConfirmPasswordWeb = driver.findElement(By.id("secondpassword"));
        String ConfirmPasswordValue = propertiesFile.GetValueBasedONKey("ConfirmPasswordKey");
        elementMethods.FillElement(ConfirmPasswordWeb, ConfirmPasswordValue);

        //interactionam cu un webelement care arata ca un select => acesta nu este un select
        WebElement LanguagesWeb = driver.findElement(By.id("msdd"));
        elementMethods.ClickElement(LanguagesWeb);
        String LanguagesValue = propertiesFile.GetValueBasedONKey("LanguagesKey");
        List<WebElement> LanguagesValuesListWeb = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
        for(int index=0;index<LanguagesValuesListWeb.size();index++){
            String CurrentTextValue = LanguagesValuesListWeb.get(index).getText();
            if (CurrentTextValue.equals(LanguagesValue)){
                elementMethods.ClickElement(LanguagesValuesListWeb.get(index));
            }
        }

        reportHtml.AttachReport("pass","I fill all mandatory fields with valid values");

        WebElement SubmitWeb = driver.findElement(By.id("submitbtn"));
        SubmitWeb.click();
        reportHtml.AttachReport("pass","I click on Submit button");
        reportHtml.GenerateReport();

    }
}
