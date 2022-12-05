package demo.nopcommerce.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;

public class TS_03_MyAccount extends BaseTest {
	WebDriver driver;
	MyAccountPageObject myAccountPage;
	LoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass (String browserName) {
		driver = getBrowserDriver (browserName, "https://demo.nopcommerce.com/customer/info");
		myAccountPage = new MyAccountPageObject(driver);
		loginPage = new LoginPageObject(driver);
	}
	
	@AfterClass
	public void afterClass () {
		//driver.quit();
	}
	//chua tim duoc cach verify do khi an nut save, website khong tra thong bao
	@Test
	public void TC_01_updateCustomerInfor() {
		loginAccount("Cuongtest133@gmail.com","abc123");
		myAccountPage.checkMaleOption();
		myAccountPage.inputCompanyName("Test Company");
		myAccountPage.clickSaveButton();
		}
	
	@Test
	public void TC_02_addAddressInfo() {
		myAccountPage.clickAddressesTab();
		myAccountPage.clickToAddNewAddressButton();
		myAccountPage.inputFirstNameTextboxAddress("Manh Cuong");
		myAccountPage.inputLastNameTextBoxAddress("Nguyen");
		myAccountPage.inputEmailTextboxAddress("testaddress@gmail.com");
		myAccountPage.selectCountryAddress();
		myAccountPage.inputCityTextboxAddress("HCM");
		myAccountPage.inputAddress1Textbox("1 Bui Vien, Q1, HCM");
		myAccountPage.inputZipPostalCodeTextboxAddress("11223");
		myAccountPage.inputPhoneNumberTextboxAddress("0933123123");
		myAccountPage.clickSaveButtonAddress();
		//verify thong tin
		Assert.assertTrue(myAccountPage.isNameDisplayed("Manh Cuong Nguyen"));
		Assert.assertTrue(myAccountPage.isEmailDisplayed("Email: testaddress@gmail.com"));
		Assert.assertTrue(myAccountPage.isPhoneNumberDisplayed("Phone number: 0933123123"));
		Assert.assertTrue(myAccountPage.isAddress1Displayed("1 Bui Vien, Q1, HCM"));
		Assert.assertTrue(myAccountPage.isCityZipCodeDisplayed("HCM, 11223"));
		Assert.assertTrue(myAccountPage.isCountryDisplayed("Afghanistan"));
		
	}
	
	@Test
	public void TC_03_ChangePasswordAndLoginAgain() {
		myAccountPage.clickToChangePasswordTab();
		myAccountPage.inputOldPasswordTextbox("abc123");
		myAccountPage.inputToNewPasswordTextbox("abc124");
		myAccountPage.inputToConfirmPasswordTextbox("abc124");
		myAccountPage.clickToChangePasswordButton();
		myAccountPage.openUrl(driver, "https://demo.nopcommerce.com");
		myAccountPage.clickToLogoutButton();
		loginAccount("Cuongtest133@gmail.com","abc125");
	}
	
	public void loginAccount(String email, String password) {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
	}
}
