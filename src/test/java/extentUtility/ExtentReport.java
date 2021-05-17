package extentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReport {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest testReport;
    public String PathToProject;

    public ExtentReport(String reportName){
        DeleteFiles(reportName);
        CreateDirectory();
        CreateReport(reportName);
    }

    public void CreateDirectory(){
        PathToProject = System.getProperty("user.dir") + "/target/extentReports/";
        File directory = new File(PathToProject);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }

    public void CreateReport(String reportName){
        htmlReporter = new ExtentHtmlReporter(PathToProject+reportName+"Report.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        testReport = extent.createTest(""+reportName+" process - reportTest");
        testReport.log(Status.INFO,"---START TEST--- "+reportName+" starts to run");
    }

    public void AttachReport(String attachType,String message){
        if(attachType.equals("info")){
            testReport.log(Status.INFO, message);
        }
        if(attachType.equals("pass")){
            testReport.log(Status.PASS, message);
        }
    }

    public static String getScreenshot(WebDriver driver, String reportName){
        String path = System.getProperty("user.dir")+"/target/extentReports/"+reportName+"Report.png";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File pathFile = new File(path);
        try {
            FileUtils.copyFile(src,pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public void AttachReport(String attachType, String message, WebDriver driver, String reportName){
        if (attachType.equals("failed")){
            try {
                testReport.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver,reportName)).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void GenerateReport(){
        testReport.log(Status.INFO,"---FINISH TEST--- The automation test is finished");
        extent.flush();
    }

    public void DeleteFiles(String reportName){
        String path = System.getProperty("user.dir");
        File report = new File(path+"/target/extentReports/"+reportName+"Report.html");
        report.delete();
        File screenshot = new File(path+"/target/extentReports/"+reportName+"Report.png");
        screenshot.delete();
    }

}
