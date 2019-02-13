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

public class verifySystemPaymentMember {
		private static WebDriver driver;
		private static String baseUrl;
		private static Properties properties;
		private static ScreenShot screenShot;
		private static CyclosPOM cyclosPOM;

	  @BeforeClass
	  public static void setUpBeforeClass() throws IOException {
		  properties = new Properties();
		  FileInputStream inStream = new FileInputStream("./resources/others.properties");
		  properties.load(inStream);
	  }
	  
	  @BeforeMethod
	  public static void beforeMethod() {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);
		  baseUrl = properties.getProperty("baseURL");
		  cyclosPOM = new CyclosPOM(driver);
		  screenShot = new ScreenShot(driver); 
		  // open the browser
		  driver.get(baseUrl);
	  }

//To verify whether application allows member to perform system payment & details get displayed in Account information module
  @Test
  public void cytc_035() throws InterruptedException {
	  cyclosPOM.cyclosGenericLogin("srivalli","srivalli");
	  screenShot.captureScreenShot("CYTC03501");
	  Thread.sleep(1000);
	  cyclosPOM.accountOption();
	  Thread.sleep(1000);
	  cyclosPOM.clickSystemPayment();
	  cyclosPOM.enterAmount("500");
	  cyclosPOM.transactionType("Member to community");
	  cyclosPOM.descriptionText("Charity amount");
	  screenShot.captureScreenShot("CYTC03502");
	  Thread.sleep(1000);
	  cyclosPOM.submitPayment();
	  screenShot.captureScreenShot("CYTC03503");
	  Thread.sleep(1000);
	  cyclosPOM.accountInformation();
	  screenShot.captureScreenShot("CYTC03506");
	  String Expected = "Charity amount";
	  String Actual = cyclosPOM.ActDetails();
	  Assert.assertEquals(Actual, Expected);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  //Close browser
	  Thread.sleep(3000);
	  driver.quit();
  }
  
}
