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

import com.training.dataproviders.AddMemberDataProvider2;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class addMemberFromExcel_Valid {
	private static WebDriver driver;
	private static String baseUrl;
	private static RegisterUserPOM registerUserPOM;
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
		screenShot = new ScreenShot(driver); 
		// open the browser
		driver.get(baseUrl);
	}
	
//	To verify whether application allows the user to get registered  by entering valid credentials
  @Test(dataProvider = "test-data", dataProviderClass = AddMemberDataProvider2.class)
  public void cytc_062 (String userName, String fullName, String eMail, String dob, String gender, String address, String postalCode, String city, String phoneNumber, String mobileNumber, String faxNumber, String url, String password, String confirmPassword) throws UnhandledAlertException, InterruptedException {
	  Thread.sleep(3000);
	  screenShot.captureScreenShot("TC06201"+userName);
	  registerUserPOM.registerBtn();
	  Thread.sleep(3000);
	  screenShot.captureScreenShot("TC06202"+userName);
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
	  screenShot.captureScreenShot("TC06203"+userName);
	  registerUserPOM.submitButton();
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("TC06204"+userName);
//	  driver.switchTo().alert().accept();
	  boolean Expected = true;
	  boolean Actual = driver.findElement(By.tagName("td")).getText().contains("Thanks for registering!") ;
	  Thread.sleep(1000);
	  registerUserPOM.confirmation();
	  screenShot.captureScreenShot("TC06205"+userName);
	  Assert.assertEquals(Actual, Expected);
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  //Close browser
	  Thread.sleep(3000);
	  driver.quit();
  }

}
