package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class MyFirstTest {

	public static void main(String[] args) throws InterruptedException {
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =  new FirefoxDriver();
		
		driver.get("https://www.zoho.com");
		driver.manage().window().maximize();
		
		System.out.println("browser launched successfully");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class=\"head-sign-in zh_innr_nav\"]//div[@class=\"signupcontainer\"]//a[text()='Sign in']")).click();
		
		driver.quit();
		
		System.out.println("closed the browser ");
		
		
	}
}
