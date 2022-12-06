package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;
	
	//Constructor
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToSearchTextbox(String keyword) {
		sendKeysToElement(driver, SearchPageUI.SEARCH_TEXTBOX, keyword);
	}
	
	public void clickToSearchButton() {
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	
	public boolean isSearchEmptyErrorMessage(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_EMPTY_ERROR_MESSAGE);
		return message.equals(value);
		}
	
	public boolean isWrongDataErrorMessage(String value) {
	String message = getTextOfElement(driver, SearchPageUI.SEARCH_WRONG_DATA_ERROR_MESSAGE);
	return message.equals(value);
	}
}
