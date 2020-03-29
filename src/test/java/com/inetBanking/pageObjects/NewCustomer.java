package com.inetBanking.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
		
		public WebDriver driver;
		public NewCustomer(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[text()='New Customer']")
		public WebElement clickNewCustomer;
		
		@FindBy(css="input[name='name']")
		public WebElement enterCustomerName;
		
		@FindBy(xpath="//input[@type='radio'][1]")
		public WebElement maleGender;
		
		@FindBy(xpath="//input[@type='radio'][2]")
		public WebElement femaleGender;
		
		@FindBy(xpath="//input[@name='dob']")
		public WebElement enterDOB;
		
		@FindBy(xpath="//*[@name='addr']")
		public WebElement enterAddress;
		
		@FindBy(xpath="//input[@name='city']")
		public WebElement enterCity;
		
		@FindBy(xpath="//input[@name='state']")
		public WebElement enterState;
		
		@FindBy(xpath="//input[@name='pinno']")
		public WebElement enterPinCode;
		
		@FindBy(xpath="//input[@name='telephoneno']")
		public WebElement enterMobileNumber;
		
		@FindBy(xpath="//input[@name='emailid']")
		public WebElement enterEmailId;
		
		@FindBy(xpath="//input[@name='password']")
		public WebElement enterPassword;
		
		@FindBy(xpath="//input[@type='submit']")
		public WebElement submitButton;
		
		public void clickNewCustomer()
		{
			clickNewCustomer.click();
		}
		
		public void setCustomerName(String cname)
		{
			enterCustomerName.sendKeys(cname);
		}
		
		public void selectGender(String gender)
		{
			if(gender.equalsIgnoreCase("Male"))
				maleGender.click();
			else if(gender.equalsIgnoreCase("Female"))
				femaleGender.click();
		}
		
		public void setDateOfBirth(String dd,String mm,String yyyy)
		{
			enterDOB.sendKeys(dd);
			enterDOB.sendKeys(mm);
			enterDOB.sendKeys(yyyy);
		}
		
		public void setAddress(String address)
		{
			enterAddress.sendKeys(address);
		}
		
		public void setCity(String city)
		{
			enterCity.sendKeys(city);
		}
		
		public void setState(String state)
		{
			enterState.sendKeys(state);
		}
		
		public void enterPIN(int pinno)
		{
			enterPinCode.sendKeys(String.valueOf(pinno));
		}

		public void enterMobileNumber(String phoneNumber)
		{
			enterMobileNumber.sendKeys(phoneNumber);
		}
		
		public void enterEmail(String email)
		{
			enterEmailId.sendKeys(email);
		}
		
		
		public void setPassword(String password)
		{
			enterPassword.sendKeys(password);
		}
		
		public void clickSubmitButton()
		{
			submitButton.click();
		}
	}

	