package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	public RegisteredUserAccount(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	
	@FindBy(xpath="//a[@title='View my customer account")
	WebElement userName;
	
	public String getUserName() {
		String text = userName.getText();
		return text;
	}
	
}
