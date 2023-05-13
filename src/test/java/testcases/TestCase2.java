package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.BSSignUpPage;

public class TestCase2 extends BaseTest {

//	public WebDriver driver;
	public BSSignUpPage bs;

	@Test
	public void verifySignInPage() {
		bs = new BSSignUpPage(driver);
		bs.clickSignIn();
		bs.verifySignInPage();
	}

	@Test
	public void pricingPage() {
		bs = new BSSignUpPage(driver);
		bs.clickPricingPage();
		bs.verifyPricingPage();
	}

}
