package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
	public AccountCreationPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(id="id=id_gender2")
	WebElement titleMrs;
	
	@FindBy(id="id_gender1")
	WebElement titleMr;
	
	@FindBy(name="customer_firstname")
	WebElement  custormerFirstName;
	
	@FindBy(name="customer_lastname")
	WebElement customerLastName;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="passwd")
	WebElement passwordField;

	@FindBy(id="firstname")
	WebElement addFirstname;

	@FindBy(id="lastname")
	WebElement addLastname;

	//address1
	@FindBy(id="address1")
	WebElement address1;

	@FindBy(id="city")
	WebElement city;

	//id_state
	@FindBy(id="id_state")
	WebElement state;

	@FindBy(id="postcode")
	WebElement postcode;


	@FindBy(id="id_country")
	WebElement country;

	//phone_mobile
	@FindBy(id="phone_mobile")
	WebElement phone_mobile;

	//alias
	@FindBy(id="alias")
	WebElement alias;


	@FindBy(id="submitAccount")
	WebElement register;
	//identify actions to be performed on web elements
	
	
	
	public  void selectTitleMrs()
	{
		titleMrs.click();
	}

	public void selectTitleMr()
	{
		titleMr.click();
	}
	public void enterCustomerFirstName(String fname)
	{
		custormerFirstName.sendKeys(fname);
	}

	public void enterCustomerLastName(String lname)
	{
		customerLastName.sendKeys(lname);
	}

	public void enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
	}

	public void enterAddressFirstName(String fname)
	{
		addFirstname.clear();

		addFirstname.sendKeys(fname);
	}

	public void enterAddressLastName(String lname)
	{
		addLastname.clear();

		addLastname.sendKeys(lname);
	}

	public void enterAddress(String address)
	{
		address1.sendKeys(address);
	}

	public void enterCity(String cityName)
	{
		city.sendKeys(cityName);
	}

	public void enterPostcode(String postcodeData)
	{
		postcode.sendKeys(postcodeData);
	}

	

	public void enterMobilePhone(String mobile)
	{
		phone_mobile.sendKeys(mobile);
	}

	public void enterAlias(String text)
	{
		alias.clear();
		alias.sendKeys(text);
	}

	public void clickOnRegister()
	{
		register.click();
	}
	
	
	//state is the webElement(look above findBy)
	//stateName is name of country that u want to pass to the method	
	public void selectState(String stateName) {
		Select obj = new Select(state);
		obj.selectByVisibleText(stateName);
	}
	
	
	//country is the webElement(look above findBy)
	//countryName is name of country that u want to pass to the method
	public void selectCountry(String countryName) {
		Select obj = new Select(country);
		obj.selectByVisibleText(countryName);
	}
	
	
}
