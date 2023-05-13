package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestCase1 extends BaseTest {

	@Test
	public void LoginTest() throws InterruptedException {
		driver.manage().window().maximize();
		System.out.println("browser launched successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath(props.getProperty("signin"))).click();
	}
}
