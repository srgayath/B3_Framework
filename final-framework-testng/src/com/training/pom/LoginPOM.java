package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(id="cyclosUsername")
	private WebElement cyclosUser;

	@FindBy(id="cyclosPassword")
	private WebElement cyclosPass; 
	
	@FindBy(xpath="//td/input[@class='button'][@type='submit']")
	private WebElement cyclosSubmit;
	
	@FindBy(id="menu15")
	private WebElement cyclosLogOut;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement memLogout;
	
	public void memberLogout() throws InterruptedException {
		this.memLogout.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	
	public void cyclosGenericLogin(String userName,String password) throws InterruptedException {
		this.cyclosUser.clear();
		this.cyclosUser.sendKeys(userName);
		this.cyclosPass.clear();
		this.cyclosPass.sendKeys(password);
		Thread.sleep(1000);
		this.cyclosSubmit.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}
