package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BSSignUpPage {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"primary-menu\"]/li[5]/a")
	WebElement signin;

	@FindBy(xpath = "//*[@id=\"signin_signup_form\"]/div[1]/div/div[1]/fieldset/h1")
	WebElement signpage;

	@FindBy(xpath = "//*[@id=\"product-nav\"]/ul/li[4]/a")
	WebElement pricing;

	public BSSignUpPage(WebDriver driver) {
//		super();
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void clickSignIn() {
		signin.click();
	}

	public void verifySignInPage() {
		String title = driver.getTitle();
		System.out.println("title is " + title);
		Assert.assertEquals(title, "BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool");
	}

	public void clickPricingPage() {
		pricing.click();
	}
	public void verifyPricingPage() {
		String title = driver.getTitle();
		System.out.println("title is " + title);
		Assert.assertEquals(title, "BrowserStack Pricing | Plans Starting From Just $12.50 A Month");
	}
	

}
