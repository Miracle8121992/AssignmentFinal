package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;

public class HomePageObjective extends BasePage{
	WebDriver driver;
	
	//constructor
	public HomePageObjective (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isMyAccountDisplayed(String value) {
		String message = getTextOfElement(driver, HomePageUI.MY_ACCOUNT_BUTTON);
		return message.equals(value);
		
	}

}
