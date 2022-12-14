package demo.nopcommerce.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import PageFactory.RegisterPageFactory;
import pageObjects.RegisterPageObject;

public class TS_00_Precondition extends BaseTest {
	WebDriver driver;
	
	RegisterPageObject registerPage;
//	RegisterPageFactory registerPageFactory;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		registerPage = new RegisterPageObject(driver);
//		registerPageFactory = new RegisterPageFactory(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_CreateAccountForTesting() {
		registerPage.inputToFirstNameTextbox("autoTest");
		registerPage.inputToLastNameTextbox("auto");
		registerPage.inputToEmailTextbox("Cuongtest133@gmail.com");
		registerPage.inputToPasswordTextbox("abc123");
		registerPage.inputToConfirmPasswordTextbox("abc123");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccess("Your registration completed"));
	}
	
	//@Test
	//public void TC_01_CreateAccountForTestingUsingPageFactory() {
	//	registerPageFactory.inputToFirstNameTextbox("auto");
	//	registerPageFactory.inputToLastNameTextbox("tester");
	//	registerPageFactory.inputToEmailTextbox(GlobalContants.email);
	//	registerPageFactory.inputToPasswordTextbox(GlobalContants.password);
	//	registerPageFactory.inputToConfirmPasswordTextbox(GlobalContants.password);
	//	registerPageFactory.clickToRegisterButton();
	//	Assert.assertTrue(registerPageFactory.isRegisterSuccess());
	//}
	
}