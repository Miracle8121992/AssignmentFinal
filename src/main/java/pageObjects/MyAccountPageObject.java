package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;
	
	//constructor
	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}
	//Customer info
	public void checkMaleOption () {
		waitForElementClickable(driver, MyAccountPageUI.MALE_RADIO_BUTTON);
		clickToElement(driver, MyAccountPageUI.MALE_RADIO_BUTTON);
	}
	
	public void inputCompanyName(String companyName) {
		sendKeysToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}
	
	public void clickSaveButton() {
		clickToElement(driver, MyAccountPageUI.SAVE_CUSTOMER_INFO_BUTTON);
	}
	//Address tab
	public void clickAddressesTab() {
		clickToElement(driver, MyAccountPageUI.ADDRESSES_TAB);
	}
	
	public void clickToAddNewAddressButton() {
		clickToElement(driver, MyAccountPageUI.ADD_NEW_ADDRESS_BUTTON);
	}
	
	public void inputFirstNameTextboxAddress(String firstName) {
		sendKeysToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX_ADDRESS, firstName);
	}
	
	public void inputLastNameTextBoxAddress(String lastName) {
		sendKeysToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX_ADDRESS, lastName);
	}
	
	public void inputEmailTextboxAddress(String email) {
		sendKeysToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX_ADDRESS, email);
	}
	
	public void selectCountryAddress() {
		clickToElement(driver, MyAccountPageUI.SELECT_COUNTRY_OPTION_3);
	}
	
	public void inputCityTextboxAddress(String city) {
		sendKeysToElement(driver, MyAccountPageUI.CITY_TEXTBOX_ADDRESS, city);
	}
	
	public void inputAddress1Textbox(String address) {
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_1_TEXTBOX, address);
	}
	
	public void inputZipPostalCodeTextboxAddress(String zip) {
		sendKeysToElement(driver, MyAccountPageUI.ZIP_POSTAL_CODE_TEXTBOX_ADDRESS, zip);
	}
	
	public void inputPhoneNumberTextboxAddress(String phone) {
		sendKeysToElement(driver, MyAccountPageUI.PHONE_NUMBER_ADDRESS, phone);
	}
	
	public void clickSaveButtonAddress() {
		clickToElement(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
	}
}
