package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterUserPOM {
	private WebDriver driver; 
	
	public RegisterUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='loginRegistrationDiv']/child::input")
	private WebElement loginRegister;
	
	@FindBy(name="member(user).username")
	private WebElement userName;
	
	@FindBy(name="member(name)")
	private WebElement fullName;
	
	@FindBy(name="member(email)")
	private WebElement eMail;
	
	@FindBy(id="calendarTrigger0")
	private WebElement calendarBtn;
	
	@FindBy(xpath="//img[@id='calendarTrigger0']/preceding-sibling::input[@fieldname='birthday']")
	private WebElement dateField;
	
	@FindBy(id="_radio_2_0")
	private WebElement femaleRadioBtn;
	
	@FindBy(id="_radio_2_1")
	private WebElement maleRadioBtn;
	
	@FindBy(xpath="//input[@id='hidden_3']/following-sibling::input[2][@fieldname='address']")
	private WebElement addressField;
	
	@FindBy(xpath="//input[@id='hidden_4']/following-sibling::input[2][@fieldname='postalCode']")
	private WebElement postalCode;
	
	@FindBy(xpath="//input[@id='hidden_5']/following-sibling::input[2][@fieldname='city']")
	private WebElement cityName;
	
	@FindBy(id="custom_field_select_6")
	private WebElement areaDropDown;
	//selectByValue("Example Area")
	
	@FindBy(xpath="//input[@id='hidden_7']/following-sibling::input[2][@fieldname='phone']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//input[@id='hidden_8']/following-sibling::input[2][@fieldname='mobilePhone']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='hidden_9']/following-sibling::input[2][@fieldname='fax']")
	private WebElement faxNumber;
	
	@FindBy(xpath="//input[@id='hidden_10']/following-sibling::input[2][@fieldname='url']")
	private WebElement url;
	
	@FindBy(name="member(user).password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="saveButton")
	private WebElement submitForm;
	
	@FindBy(id="btn")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//table[@class='defaultTable']//td[@align='center']")
	private WebElement confirmText;
	
	public void registerBtn() {
		this.loginRegister.click();
	}
	
	public void enterUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void enterFullName(String fullName) {
		this.fullName.clear();
		this.fullName.sendKeys(fullName);
	}
	
	public void enterEmail(String eMail) {
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
	}
	
	public void enterDOB(String dobValue) {
//		this.calendarBtn.click();
		this.dateField.clear();
		this.dateField.sendKeys(dobValue);
	}
	
	public void genderSelect(String gender) {
		switch(gender)
		{
		case "Male":
			this.maleRadioBtn.click();
			break;
		case "Female":
			this.femaleRadioBtn.click();
			break;
		default:
			System.out.println("Invaid Gender input");
		}
	}
	
	public void enterAddress(String address, String postal, String city, String area) {
		this.addressField.clear();
		this.addressField.sendKeys(address);
		this.postalCode.clear();
		this.postalCode.sendKeys(postal);
		this.cityName.clear();
		this.cityName.sendKeys(city);
		Select s = new Select(this.areaDropDown);
		s.selectByIndex(1);
	}
	
	public void enterPhone(String phone, String mobile, String fax) {
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phone);
		this.mobileNumber.clear();
		this.mobileNumber.sendKeys(mobile);
		this.faxNumber.clear();
		this.faxNumber.sendKeys(fax);
	}
	
	public void enterUrl(String urlName) {
		this.url.clear();
		this.url.sendKeys(urlName);
	}
	
	public void enterPasswords(String passWord, String confirmPassWord) {
		this.password.clear();
		this.password.sendKeys(passWord);
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassWord);
	}
	
	public void submitButton() {
		this.submitForm.click();
	}
	
	public void confirmation() {
		this.confirmBtn.click();
	}
	
	public String confirmtext() {
		return this.confirmText.getText();
	}

}
