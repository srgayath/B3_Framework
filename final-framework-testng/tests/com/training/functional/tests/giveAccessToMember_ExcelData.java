package com.training.functional.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.GiveAccessToMemberDataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterUserPOM;
import com.training.pom.CyclosPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class giveAccessToMember_ExcelData {
	private static WebDriver driver;
	private static String baseUrl;
	private static RegisterUserPOM registerUserPOM;
	private static CyclosPOM cyclosPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		registerUserPOM = new RegisterUserPOM(driver);
		cyclosPOM = new CyclosPOM(driver);
		screenShot = new ScreenShot(driver); 
		// open the browser
		driver.get(baseUrl);
	}
	
//	To verify whether application allows the user to get registered  by entering valid credentials
  @Test(dataProvider = "test-data", dataProviderClass = GiveAccessToMemberDataProvider.class)
  public void cytc_064 (String userName, String fullName, String eMail, String dob, String gender, String address, String postalCode, String city, String phoneNumber, String mobileNumber, String faxNumber, String url, String password, String confirmPassword) throws UnhandledAlertException, InterruptedException {
	  Thread.sleep(3000);
	  screenShot.captureScreenShot("TC06401"+userName);
	  registerUserPOM.registerBtn();
	  Thread.sleep(3000);
	  screenShot.captureScreenShot("TC06402"+userName);
	  registerUserPOM.enterUserName(userName);
	  registerUserPOM.enterFullName(fullName);
	  registerUserPOM.enterEmail(eMail);
	  registerUserPOM.enterDOB(dob);
	  registerUserPOM.genderSelect(gender);
	  registerUserPOM.enterAddress(address, postalCode, city);
	  registerUserPOM.enterPhoneNumber(phoneNumber, mobileNumber, faxNumber);
	  registerUserPOM.enterUrl(url);
	  registerUserPOM.enterPasswords(password, confirmPassword);
	  //Enter captcha manually
	  Thread.sleep(20000);
	  screenShot.captureScreenShot("TC06403"+userName);
	  registerUserPOM.submitButton();
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("TC06404"+userName);
//	  boolean Expected = true;
//	  boolean Actual = driver.findElement(By.tagName("td")).getText().contains("Thanks for registering!") ;
	  Thread.sleep(1000);
	  registerUserPOM.confirmation();
	  cyclosPOM.cyclosGenericLogin("admin", "12345");
	  cyclosPOM.enterMemberName(userName);
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("TC06405"+userName);
	  cyclosPOM.changeMemberSubmit();
	  Thread.sleep(1000);
	  cyclosPOM.selectNewGroup("Full members");
	  cyclosPOM.enterComments("Full access to member");
	  screenShot.captureScreenShot("CYTC00303");
	  cyclosPOM.submitChange();
	  driver.switchTo().alert().accept();
	  String Expected = "Full members";
	  String Actual = cyclosPOM.getNewGroup();
	  cyclosPOM.cyclosLogout();
	  Assert.assertEquals(Actual, Expected);
//	  screenShot.captureScreenShot("TC06205"+userName);
//	  Assert.assertEquals(Actual, Expected);
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  //Close browser
	  Thread.sleep(3000);
	  driver.quit();
  }

}
