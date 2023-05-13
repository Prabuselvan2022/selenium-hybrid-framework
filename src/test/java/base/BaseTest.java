package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public  WebDriver driver;
	public static FileReader filereader;
	public static FileReader filereader1;
	public static Properties props = new Properties();
	
	@BeforeMethod
	public void setup() throws IOException {
		
		if(driver==null) { //checking the driver is null 
			System.out.println("directory is "+ System.getProperty("user.dir"));
			filereader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/config.properties");
			filereader1 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/location.properties");
			props.load(filereader);
			props.load(filereader1);
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
	public void teardown() {
		driver.close();
		System.out.println("closed the browser ");
	}
}
