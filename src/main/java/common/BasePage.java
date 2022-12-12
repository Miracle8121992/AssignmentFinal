package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriverWait explicitWait;
	public long timeout = GlobalContants.explicit_timeout;
	private Select select;

	// getter
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	/////////////////////////////////
	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	//////////////////////
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public By getByXpath(String locator, String... params) {
		return By.xpath(String.format(locator, (Object[]) params));
	}
	
	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public WebElement findElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(locator, params));
	}
	
	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		findElement(driver, locator).clear();
		findElement(driver, locator).sendKeys(valueInput);
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		findElement(driver, locator).click();
	}
	
	public String getTextOfElement(WebDriver driver, String locator) {
		return findElement(driver, locator).getText();
	}
	
	public String getTextOfElement(WebDriver driver, String locator, String... params) {
		return findElement(driver, locator, params).getText();
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	//dropdown
	public void selectDropdownByText(WebDriver driver, String locator, String textItem) {
		select = new Select(findElement(driver, locator));
		select.selectByVisibleText(textItem);
	}
	
	///////////////////////////////////////////////
	///////// USE FOR PAGE FACTORY ///////////////
	public void sendKeysToElement(WebDriver driver, WebElement element, String valueInput) {
		element.clear();
		element.sendKeys(valueInput);
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
}