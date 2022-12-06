package demo.nopcommerce.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.FooterObject;
import pageObjects.LoginPageObject;
import pageObjects.SearchPageObject;

public class TS_04_Search extends BaseTest {
	WebDriver driver;
	SearchPageObject searchPage;
	FooterObject footer;
	LoginPageObject loginPage;

	@Parameters ("browser")
	@BeforeClass
	public void beforeClass (String browserName) {
		driver = getBrowserDriver (browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		searchPage = new SearchPageObject(driver);
		footer = new FooterObject(driver);
		loginPage = new LoginPageObject(driver);
	}
	@AfterClass
	public void afterClass () {
		driver.quit();
	}
	
	@Test
	public void TC_01_SearchWithEmptyData() {
		loginAccount("Cuongtest133@gmail.com", "abc124");
		footer.clickToSearchButton();
		searchPage.inputToSearchTextbox("");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isSearchEmptyErrorMessage("Search term minimum length is 3 characters"));
	}
	
	@Test
	public void TC_02_SearchWithWrongData() {
		searchPage.inputToSearchTextbox("Macbook Pro 2040");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isWrongDataErrorMessage("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_03_SearchWithKeywordLenovo() {
		searchPage.inputToSearchTextbox("Lenovo");
		
	}
	
	public void loginAccount(String email, String password) {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
	}
}
