package com.training.functional.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_001 {
	private WebDriver driver;
	private String baseUrl;
	private RegisterUserPOM registerUserPOM;
	private static Properties properties;
	private ScreenShot screenShot;

  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	  properties = new Properties();
	  FileInputStream inStream = new FileInputStream("./resources/others.properties");
	  properties.load(inStream);
  }
	
//	To verify whether application allows the user to get registered  by entering valid credentials
  @Test
  public void cytc_001() throws InterruptedException {
	  Thread.sleep(3000);
	  screenShot.captureScreenShot("CYTC00101");
	  registerUserPOM.registerBtn();
	  Thread.sleep(3000);
	  screenShot.captureScreenShot("CYTC00102");
	  registerUserPOM.enterUserName("srivalli");
	  registerUserPOM.enterFullName("Srivalli");
	  registerUserPOM.enterEmail("srivalli@gmail.com");
	  registerUserPOM.enterDOB("20/01/1994");
	  registerUserPOM.genderSelect("Female");
	  registerUserPOM.enterAddress("Gachibowli", "500032", "Hyderabad", "Example Area");
	  registerUserPOM.enterPhone("9876543222", "8765432229", "7654322298");
	  registerUserPOM.enterUrl("www.google.com");
	  registerUserPOM.enterPasswords("pass12345", "pass12345");
	  //Enter captcha manually
	  Thread.sleep(15000);
	  screenShot.captureScreenShot("CYTC00103");
	  registerUserPOM.submitButton();
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("CYTC00104");
	  String confText = registerUserPOM.confirmtext();
	  registerUserPOM.confirmation();
	  boolean Actual = (confText.contains("Thanks for registering!"));
	  boolean Expected = true;
	  Assert.assertEquals(Actual, Expected);
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  //Launch URL
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		registerUserPOM = new RegisterUserPOM(driver);
		screenShot = new ScreenShot(driver); 
		// open the browser
		driver.get(baseUrl);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  //Close browser
	  Thread.sleep(3000);
	  driver.quit();
  }

}
