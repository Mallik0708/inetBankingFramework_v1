package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;      
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;   
		PageFactory.initElements(driver, this);     
	}
	
	//Page Elements
	@FindBy(name="uid")
	public WebElement UsernameTxtBox;
	
	@FindBy(name="password")
	public WebElement PasswordTxtBox;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	public WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name='btnReset']")
	public WebElement ResetBtn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	public WebElement LogoutBtn;
	
	
	//Page Methods
	public void setUserName(String username)
	{
		UsernameTxtBox.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		PasswordTxtBox.sendKeys(password);
	}
	
	public void clickLoginBtn()
	{
		LoginBtn.click();
	}
	
	public void clickResetBtn()
	{
		ResetBtn.click();
	}
	
	public void clickLogoutBtn()
	{
		LogoutBtn.click();
	}
	
}
