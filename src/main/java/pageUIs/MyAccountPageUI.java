package pageUIs;

public class MyAccountPageUI {
	public static final String MALE_RADIO_BUTTON = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";
	public static final String SAVE_CUSTOMER_INFO_BUTTON = "//button[@id='save-info-button']";
	
	public static final String ADDRESSES_TAB = "//a[text()='Downloadable products']/parent::li/preceding-sibling::li[@class='customer-addresses inactive']/a";
	public static final String ADD_NEW_ADDRESS_BUTTON = "//button[normalize-space()='Add new']";
	public static final String FIRST_NAME_TEXTBOX_ADDRESS = "//input[@id='Address_FirstName']";
	public static final String LAST_NAME_TEXTBOX_ADDRESS = "//input[@id='Address_LastName']";
	public static final String EMAIL_TEXTBOX_ADDRESS = "//input[@id='Address_Email']";
	public static final String SELECT_COUNTRY_OPTION_3 = "//select[@name='Address.CountryId']/option[position()=3]";
	public static final String CITY_TEXTBOX_ADDRESS = "//input[@id='Address_City']";
	public static final String ADDRESS_1_TEXTBOX = "//input[@id='Address_Address1']";
	public static final String ZIP_POSTAL_CODE_TEXTBOX_ADDRESS = "//input[@id='Address_ZipPostalCode']";
	public static final String PHONE_NUMBER_ADDRESS = "//input[@id='Address_PhoneNumber']";
	public static final String SAVE_ADDRESS_BUTTON = "//button[normalize-space()='Save']";
}
