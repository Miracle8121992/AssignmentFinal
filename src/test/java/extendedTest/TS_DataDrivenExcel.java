package extendedTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import utils.ExcelUtil;

public class TS_DataDrivenExcel extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	
	HomePageObject homePage;
//	RegisterPageFactory registerPageFactory;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
		
//		registerPageFactory = new RegisterPageFactory(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_LoginWithExcelData() throws IOException {
		// Đọc dữ liệu từ file Excel
		ExcelUtil.setExcelFile("Auto");
		String excelEmail = ExcelUtil.getCellData(1, 1);
		String excelPassWord = ExcelUtil.getCellData(1, 2);
		
		loginPage.inputToEmailTextbox(excelEmail);
		loginPage.inputToPasswordTextbox(excelPassWord);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		String url = homePage.getCurrentPageUrl(driver);
		if (url.equals("https://demo.nopcommerce.com/")) {
			ExcelUtil.setCellData("Passed", 1, 3);
		} else {
			ExcelUtil.setCellData("Failed", 1, 3);
		}
	}
}