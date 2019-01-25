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
import com.training.pom.CyclosPOM;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_002 {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private CyclosPOM cyclosPOM;

  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	  properties = new Properties();
	  FileInputStream inStream = new FileInputStream("./resources/others.properties");
	  properties.load(inStream);
  }
  
//	To verify whether application allows admin to get logged in into application
  @Test
  public void cytc_002() throws InterruptedException {
	  Thread.sleep(3000);
	  cyclosPOM.cyclosGenericLogin("admin","12345");
	  screenShot.captureScreenShot("CYTC00201");
	  Thread.sleep(2000);
	  String Expected = "Logged user: admin - Administrator";
	  String Actual = cyclosPOM.getLoginUser();
	  Assert.assertEquals(Actual, Expected);
	  cyclosPOM.cyclosLogout();
	  screenShot.captureScreenShot("CYTC00202");
	  Thread.sleep(2000);
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  //Launch URL
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		cyclosPOM = new CyclosPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		new RegisterUserPOM(driver);
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
