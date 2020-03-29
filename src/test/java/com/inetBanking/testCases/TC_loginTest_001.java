
package com.inetBanking.testCases;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_loginTest_001 extends TestBase {   

	
	@Test(priority=1)
	public void loginTest() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");       
		lp.setPassword(password);
		logger.info("Entered Password");    
		lp.clickLoginBtn();      
		
		String homePageExpectedTitle = "Guru99 Bank Manager HomePage";
		String homePageActualTitle = driver.getTitle();
		
		if(homePageExpectedTitle.equals(homePageActualTitle))
			{     
				Assert.assertTrue(true);
				System.out.println("Login is Successful......Test is Passed");	
			}   
		else
			{	
				captureScreen(driver, "loginTest");
				System.out.println("Login is not Successful......Test is Failed");
				Assert.assertTrue(false);
				
			}				
	}
	
	@Test(priority=2,dataProvider="LoginData")
	public void loginDDT(String username, String password) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");       
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickLoginBtn(); 
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			captureScreen(driver,"loginDDT");
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			Thread.sleep(2000);
			lp.clickLogoutBtn();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();	
			logger.info("Logout Successful");
		}
	}   
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/TestData.xlsx";
		/*
		String path= System.getProperty("C:\\Users\\Mallik\\eclipse-workspace\\inetBankingFramework\\"
				+ "src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx");   
		*/
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	
	
	
}
