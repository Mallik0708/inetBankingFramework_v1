package com.inetBanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomer;

public class TC_NewCustomer_003 extends TestBase {

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);          
		lp.setUserName(username);
		logger.info("Username is Entered");
		lp.setPassword(password);
		logger.info("Password is Entered");
		lp.clickLoginBtn();
		Thread.sleep(5000);
		
		NewCustomer nc = new NewCustomer(driver);
		nc.clickNewCustomer();
		logger.info("Providing Customer Details......");
		
		Thread.sleep(3000);
		nc.setCustomerName("Arjun");
		nc.selectGender("male");
		nc.setDateOfBirth("08", "09", "1996");
		nc.setAddress("Flat 101 RoadNo2 Banjara Hills");
		nc.setCity("Hyderabad");
		nc.setState("Telangana");
		nc.enterPIN(500061);
		nc.enterMobileNumber("5421212454");
		String email = randomEmailString()+"@gmail.com";   
		nc.enterEmail(email);
		nc.setPassword("abcdeF");
		nc.clickSubmitButton();
		Thread.sleep(5000);
		
		logger.info("Validation is Started....");
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed..");
		}
		else
		{
			captureScreen(driver, "addNewCustomer");     
			Assert.assertTrue(false);
			logger.info("test case failed....");
		}
		
	}
	
	
	
}
