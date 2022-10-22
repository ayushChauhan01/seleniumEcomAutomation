package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClassV2;
import pageObjects.AccountCreationPage;
import pageObjects.IndexPage;
import pageObjects.MyAccount;
import pageObjects.RegisteredUserAccount;

public class TC_01_myAccountTest extends BaseClassV2 {
	
	
	@Test
	
	public void verifyRegistrationAndLogin() throws IOException, InterruptedException {
		
		//passing the driver obj form BaseClass
		//here we creating an new account by adding email
		IndexPage obj = new IndexPage(driver);
		obj.clickOnSignIn();

		System.out.println(conf.getEmail());

		MyAccount accObj = new MyAccount(driver);
		accObj.createAccount(conf.getEmail());
		logger.info("-account created button clicked-");
		/*
		accObj.singIn(getEmail(), getBrowser());
		logger.info("-signed in-");
		Thread.sleep(3000);
		*/
		AccountCreationPage acp = new AccountCreationPage(driver);

		//We can remove the hardcode value by creating required methods in config.properties
		//or directory read a new properties file for these values to read the values directly
		//that it will way easier but currently I am leaving it hardcoded.
		acp.selectTitleMr();
		acp.enterCustomerFirstName("Ayush");
		acp.enterCustomerLastName("Chauhan");
		acp.enterPassword("cs923");
		acp.enterAddressFirstName("Ayush");
		acp.enterAddressLastName("Chauhan");
		acp.enterAddress("18/8 worli road");

		acp.enterCity("Delhi");
		acp.selectState("Alabama");

		acp.enterPostcode("00000");
		acp.selectCountry("United States");
		acp.enterMobilePhone("9891778192");
		acp.enterAlias("Home");

		logger.info("entered user details on account creation page.");
		Thread.sleep(10000);
		
		acp.clickOnRegister();
		logger.info("clicked on Register button");
		/*
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		String userName = rua.getUserName();
		Assert.assertEquals("Ayush Chauhan", userName);
		logger.info("***************TestCase Verify Registration and Login ends*****************");
		*/
		
	}
}
