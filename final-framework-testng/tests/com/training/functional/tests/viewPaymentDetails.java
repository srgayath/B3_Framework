package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CyclosPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class viewPaymentDetails {
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
  
  //To Verify whether application allows member to view payment details made by admin
  @Test
  public void cytc_032() throws InterruptedException {
	  cyclosPOM.cyclosGenericLogin("admin","12345");
	  screenShot.captureScreenShot("CYTC03201");
	  Thread.sleep(2000);
	  cyclosPOM.enterMemberName("srivalli");
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("CYTC03202");
	  cyclosPOM.paymentToMember();
	  Thread.sleep(2000);
	  cyclosPOM.enterAmount("500");
	  cyclosPOM.transactionType("Debit to member");
	  cyclosPOM.descriptionText("Bonus");
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("CYTC03203");
	  cyclosPOM.submitPayment();
	  screenShot.captureScreenShot("CYTC03204");
	  cyclosPOM.cyclosLogout();
	  cyclosPOM.cyclosGenericLogin("srivalli","srivalli");
	  Thread.sleep(1000);
	  cyclosPOM.accountOption();
	  cyclosPOM.accountInformation();
	  screenShot.captureScreenShot("CYTC03205");
	  String Actual = cyclosPOM.ActDetails();
	  String Expected = "Bonus";
	  Assert.assertEquals(Actual, Expected);
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  //Launch URL
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		cyclosPOM = new CyclosPOM(driver);
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
