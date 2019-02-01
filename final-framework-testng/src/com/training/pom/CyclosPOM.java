package com.training.pom;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'memberAds')][@class='linkButton']")
	private WebElement manageAds;
	
	@FindBy(id="newButton")
	private WebElement newAdBtn;
	
	@FindBy(name="ad(title)")
	private WebElement adTitle;
	
	@FindBy(name="ad(category)")
	private WebElement adCategory;
	
	@FindBy(name="ad(price)")
	private WebElement adPrice;
	
	@FindBy(name="ad(permanent)")
	private WebElement adExpirable;
	
	@FindBy(id="menu1")
	private WebElement personalTab;
	
	@FindBy(id="submenu1.2")
	private WebElement adsLink;
	
	@FindBy(xpath="//iframe[@title='Rich text editor, descriptionText']")
	private WebElement descTextBox;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement memLogout;
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'payment')][@class='linkButton']")
	private WebElement paymentToMemBtn;
	
	@FindBy(id="amount")
	private WebElement amtField;
	
	@FindBy(id="type")
	private WebElement transType;
	
	@FindBy(id="description")
	private WebElement descBox;
	
	@FindBy(id="submitButton")
	private WebElement submitPayment;
	
	@FindBy(id="menu2")
	private WebElement accountMenu;
	
	@FindBy(id="submenu2.0")
	private WebElement acctInfo;
	
	@FindBy(id="submenu2.3")
	private WebElement loansLink;
	
	@FindBy(xpath="//tr[2]/td[3]")
	private WebElement description;
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'grantLoan')][@class='linkButton']")
	private WebElement grantLoanBtn;
	
	@FindBy(name="loan(amount)")
	private WebElement loanAmount;
	
	@FindBy(name="loan(description)")
	private WebElement loanDescription;
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'searchLoans')][@class='linkButton']")
	private WebElement searchLoansBtn;
	
	@FindBy(xpath="(//table[1]/tbody[1]/tr)[last()]/td[1]")
	private WebElement loanDesc;
	
	@FindBy(id="amountText")
	private WebElement loanAmt;
	
	@FindBy(xpath="//input[@value='Repay']")
	private WebElement repayBtn;
	
	@FindBy(xpath="//tr/td[text()='Remaining amount']/following-sibling::td")
	private WebElement remainingAmt;
	
	@FindBy(id="submenu2.5")
	private WebElement systemPayment;
	
	public void cyclosLogout() throws InterruptedException {
		this.cyclosLogOut.click();
		Thread.sleep(1000);
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
	
	public void manageAdvertisements() {
		this.manageAds.click();
	}
	
	public void insertNewAdBtn() {
		this.newAdBtn.click();
	}
	
	public void createNewAd(String title, String category, String price, String description) throws InterruptedException {
		this.adTitle.sendKeys(title);
		this.adCategory.sendKeys(category);
		this.adPrice.sendKeys(price);
		this.adExpirable.click();
		this.descTextBox.sendKeys(description);
		this.saveChangesBtn.click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	public void personalTabOpt() {
		this.personalTab.click();
	}
	
	public void advertisementsLink() {
		this.adsLink.click();
	}
	
	public void memberLogout() throws InterruptedException {
		this.memLogout.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	
	public void paymentToMember() {
		this.paymentToMemBtn.click();
	}
	
	public void enterAmount(String amount) {
		this.amtField.sendKeys(amount);
	}
	
	public void transactionType(String transaction) {
		Select s = new Select(this.transType);
		s.selectByVisibleText(transaction);
	}
	
	public void descriptionText(String description) {
		this.descBox.sendKeys(description);
	}
	
	public void submitPayment() throws InterruptedException {
		this.submitPayment.click();
		Thread.sleep(1000);
		this.cyclosSubmit.click();
	}
	
	public void accountOption() {
		this.accountMenu.click();
	}
	
	public void accountInformation() {
		this.acctInfo.click();
	}
	
	public String ActDetails() {
		String desc = this.description.getText();
		return desc;
	}
	
	public void grantLoan() {
		this.grantLoanBtn.click();
	}
	
	public void enterLoanAmount(String amount) {
		this.loanAmount.sendKeys(amount);
	}
	
	public void enterLoanDescription(String description) {
		this.loanDescription.sendKeys(description);
	}
	
	public void submitLoan() throws InterruptedException {
		this.cyclosSubmit.click();
		Thread.sleep(2000);
		this.cyclosSubmit.click();
		Thread.sleep(2000);
	}
	
	public void searchLoan() {
		this.searchLoansBtn.click();
	}
	
	public String getLoanDesc() {
		return this.loanDesc.getText();
	}
	
	public void clickLoansLink() {
		this.loansLink.click();
	}
	
	public void viewLoanDetails(String loanName) throws Exception {
	        driver.findElement(By.xpath("//td[contains(text(),'"+loanName+"')]/following-sibling::td/img")).click();
	}
	
	public void repayLoanAmount(String repayAmount) {
		this.loanAmt.clear();
		this.loanAmt.sendKeys(repayAmount);
	}
	
	public void clickRepayBtn() {
		this.repayBtn.click();
	}
	
	public String remainingAmount() {
		return this.remainingAmt.getText();
	}
	
	public int loanToRepay(String loanName) {
		String loanAmt = driver.findElement(By.xpath("//td[contains(text(),'"+loanName+"')]/following-sibling::td[2]")).getText();
		String[] arrSplit = loanAmt.split(", ");
		return Integer.parseInt(arrSplit[0]);
	}
	
	public void clickSystemPayment() {
		this.systemPayment.click();
	}
	
}