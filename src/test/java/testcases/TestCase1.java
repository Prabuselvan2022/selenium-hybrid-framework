package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import base.BaseTest;
import utilities.ReadXlsxData;

public class TestCase1 extends BaseTest {

	@Test(dataProviderClass = ReadXlsxData.class, dataProvider = "Testdata" )
	public void LoginTest(String username, String password) throws InterruptedException {
		driver.manage().window().maximize();
		System.out.println("browser launched successfully");
		Thread.sleep(3000);
		System.out.println("Inside Test username is "+username);
		System.out.println("Inside Test password is "+password);
//		driver.findElement(By.linkText(props.getProperty("signin"))).click();
//		driver.findElement(By.id(props.getProperty("emailid"))).sendKeys("prabu211989@gmail.com");
//		System.out.println("Entered the Email");
//		driver.findElement(By.xpath(props.getProperty("nextbtn"))).click();
//		System.out.println("Clicked on Nextbtn1 button");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath(props.getProperty("pwd"))).sendKeys("Hitler@89");
//		System.out.println("Entered sendkeys as password");
//		driver.findElement(By.xpath(props.getProperty("Next2btn"))).click();
//		System.out.println("Clicked on Nextbtn2 button");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath(props.getProperty("usericon"))).click();
//		System.out.println("Clicked on usericon button");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(props.getProperty("signout"))).click();
//		Thread.sleep(2000);
//		System.out.println("Clicked on Signout button");
	}


	public Object[][] testData() {

		return new Object[][] { 
			{"prabu211989@gmail.com","Hitler@89"},
			{"prabu211989@gmail1.com","Hitler1@89"},
			{"prabu211989@gmail2.com","Hitler2@89"},
			{"prabu211989@gmail3.com","Hitler3@89"}
		};

	}
	
	@Test(dataProvider = "login")
	public void testLogin(String username, String pwd) {
		System.out.println("username is "+ username +"------"+ "password is "+ pwd);		
	}
}
