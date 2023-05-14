package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjects.BSSignUpPage;

public class TestCase2 extends BaseTest {

//	public WebDriver driver;
	public BSSignUpPage bs;

	@Test
	public void verifySignInPage() {
		Test = Report.createTest("verifySignInPage ", "PASSED test case");

		bs = new BSSignUpPage(driver);
		bs.clickSignIn();
		Test.log(Status.INFO, "Clicked on SignIn Page");
		bs.verifySignInPage();
		Test.log(Status.INFO, "Verified the SignIn page is loaded");
		Report.flush();
		
	}

	@Test
	public void pricingPage() {
		Test = Report.createTest("pricingPage ", "PASSED test case");
		bs = new BSSignUpPage(driver);
		bs.clickPricingPage();
		Test.log(Status.INFO, "Clicked on Pricing Page");
		bs.verifyPricingPage();
		Test.log(Status.INFO, "Verified the pricing page is loaded");
		Report.flush();
		
	}

}
