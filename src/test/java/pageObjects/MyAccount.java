package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccount  {
	public MyAccount(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(id="email_create")
	WebElement emailSignUpEnter; 
	
	@FindBy(id="SubmitCreate")
	WebElement submitCreateBttn;
	
	@FindBy(id="email")
	WebElement emailSignInEnter;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitBttn;
	
	public void createAccount(String email) {
		emailSignUpEnter.sendKeys(email);
		submitCreateBttn.click();
	}
	
	public void singIn(String email, String pswd) {
		emailSignInEnter.sendKeys(email);
		password.sendKeys(pswd);
		submitBttn.click();
	}
	
}
