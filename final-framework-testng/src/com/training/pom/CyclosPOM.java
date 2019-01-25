package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CyclosPOM {
	private WebDriver driver;

	public CyclosPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement cyclosUser;

	@FindBy(id="cyclosPassword")
	private WebElement cyclosPass; 
	
	@FindBy(xpath="//td/input[@class='button'][@type='submit']")
	private WebElement cyclosSubmit;
	
	@FindBy(id="menu15")
	private WebElement cyclosLogOut;
	
	@FindBy(id="memberUsername")
	private WebElement memberName;
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'changeMemberGroup')][@class='linkButton']")
	private WebElement changeMemberGroup;
	
	@FindBy(name="newGroupId")
	private WebElement selectGroup;
	
	@FindBy(id="comments")
	private WebElement comments;
	
	@FindBy(xpath="//input[@class='button'][@type='submit']")
	private WebElement submitChange;
	
	@FindBy(xpath="//tr[3]/td[@class='tdHeaderContents']/following-sibling::td[1]")
	private WebElement newGroupValue;
	
	@FindBy(xpath="//div[@id='loginDataBar']/span[1]")
	private WebElement getLoginBar;
	
	@FindBy(xpath="//td/a[contains(.,'My profile')]")
	private WebElement myProfileLink;
	
	@FindBy(id="modifyButton")
	private WebElement changeProfileBtn;
	
	@FindBy(xpath="//input[@type='text'][@fieldname='address']")
	private WebElement changeAddressField;
	
	@FindBy(id="saveButton")
	private WebElement saveChangesBtn;
	
	public void cyclosLogout() {
		this.cyclosLogOut.click();
		driver.switchTo().alert().accept();
	}
	
	public void enterMemberName(String memberUser) {
		this.memberName.clear();
		this.memberName.sendKeys(memberUser);
	}
	
	public void changeMemberSubmit() {
		this.changeMemberGroup.click();
	}
	
	public void selectNewGroup(String groupName) {
		Select s = new Select(this.selectGroup);
		s.selectByVisibleText(groupName);
	}
	
	public void enterComments(String comment) {
		this.comments.clear();
		this.comments.sendKeys(comment);
	}
	
	public void submitChange() {
		this.submitChange.click();
	}
	
	public String getNewGroup() {
		String newGroup = this.newGroupValue.getText();
		return newGroup;
	}
	
	public String getLoginUser() {
		String userName = this.getLoginBar.getText();
		return userName;
	}
	
	public void myProfileOption() {
		this.myProfileLink.click();
	}
	
	public void changeProfileBtn() {
		this.changeProfileBtn.click();
	}
	
	public void changeAddress(String newAddress) throws InterruptedException {
		this.changeAddressField.clear();
		Thread.sleep(1000);
		this.changeAddressField.sendKeys(newAddress);
	}
	
	public void saveButton() {
		this.saveChangesBtn.click();
	}
	public String verifyAddress() {
		String newAddress = this.changeAddressField.getAttribute("value");
		return newAddress;
	}
	
//	This method is used to login using any credentials to the cyclos application
	public void cyclosGenericLogin(String userName,String password) throws InterruptedException {
		this.cyclosUser.clear();
		this.cyclosUser.sendKeys(userName);
		this.cyclosPass.clear();
		this.cyclosPass.sendKeys(password);
		Thread.sleep(1000);
		this.cyclosSubmit.click();
	}
	
}