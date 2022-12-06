package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HeaderUI;

public class HeaderObject extends BasePage {
	WebDriver driver;
	
	//Constructor
	public HeaderObject (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToLogOutButton () {
		clickToElement(driver, HeaderUI.LOG_OUT_BUTTON);
	}
	
	public void clickToLogInButton() {
		clickToElement(driver, HeaderUI.LOG_IN_BUTTON);
	}
}
