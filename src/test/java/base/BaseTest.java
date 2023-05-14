package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public  WebDriver driver;
	public static FileReader filereader;
	public static FileReader filereader1;
	public static Properties props = new Properties();
	public static ExtentHtmlReporter HtmlReporter;
	public static ExtentReports Report;
	public static ExtentTest Test;

			
	
	
	@BeforeMethod
	public void setup() throws IOException {

		
		if(driver==null) { //checking the driver is null 
			System.out.println("directory is "+ System.getProperty("user.dir"));
			filereader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/config.properties");
			filereader1 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/location.properties");
			props.load(filereader);
			props.load(filereader1);
			HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/testReport.html");
			Report = new ExtentReports();
			Report.attachReporter(HtmlReporter);
			Report.setSystemInfo("OS", "MacOSX");
			Report.setSystemInfo("Browser", props.getProperty("browser"));
			HtmlReporter.config().setChartVisibilityOnOpen(true);
			HtmlReporter.config().setDocumentTitle("Extent Report Demo");
			HtmlReporter.config().setReportName("Test Report");
			HtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			HtmlReporter.config().setTheme(Theme.STANDARD);
			HtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		}
		
		if(props.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get(props.getProperty("testurl"));
		} else if(props.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(props.getProperty("testurl"));
		} else if(props.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
			driver.get(props.getProperty("testurl"));
			
		}


		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		
		System.out.println("result.getStatus() "+ result.getStatus());
		 if(result.getStatus() == ITestResult.FAILURE) {
			 Test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
			 Test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	        	Test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	        	Test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	        	Test.skip(result.getThrowable());
	        }
		 Report.flush();
		driver.close();
		System.out.println("closed the browser ");
	}
	

}
