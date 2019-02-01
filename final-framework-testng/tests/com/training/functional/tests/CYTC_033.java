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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_033 {
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
  
  @Test
  public void cytc_033() throws InterruptedException{
	  cyclosPOM.cyclosGenericLogin("admin","12345");
	  screenShot.captureScreenShot("CYTC03301");
	  Thread.sleep(2000);
	  cyclosPOM.enterMemberName("srivalli");
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("CYTC03302");
	  cyclosPOM.grantLoan();
	  Thread.sleep(2000);
	  cyclosPOM.enterLoanAmount("10000");
	  Thread.sleep(1000);
	  cyclosPOM.enterLoanDescription("Misc Loan");
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("CYTC03303");
	  cyclosPOM.submitLoan();
	  screenShot.captureScreenShot("CYTC03304");
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	  cyclosPOM.searchLoan();
	  screenShot.captureScreenShot("CYTC03305");
	  String Actual = cyclosPOM.getLoanDesc();
	  String Expected = "Misc Loan";
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
