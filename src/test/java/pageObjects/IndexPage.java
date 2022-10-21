package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	/*
	 * Note - a constructor does'nt have any return type in method signature not even void
	 * if u add void to the constructor method the compiler will interpret it as a normal
	 * method with same name as class and void return type and not a constructor.
	 * */
	public IndexPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(className="login")
	WebElement signInLink;
	
	public void clickOnSignIn(){
		signInLink.click();
	}
}
