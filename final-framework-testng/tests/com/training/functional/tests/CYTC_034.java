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

public class CYTC_034 {
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
  
  @Test
  public void cytc_034() throws Exception {
	  cyclosPOM.cyclosGenericLogin("srivalli","srivalli");
	  screenShot.captureScreenShot("CYTC03401");
	  Thread.sleep(2000);
	  cyclosPOM.accountOption();
	  Thread.sleep(1000);
	  cyclosPOM.clickLoansLink();
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("CYTC03402");
	  cyclosPOM.viewLoanDetails("Education Loan");
	  Thread.sleep(1000);
	  cyclosPOM.repayLoanAmount("100");
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("CYTC03403");
	  cyclosPOM.clickRepayBtn();
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("CYTC03404");
	  cyclosPOM.memberLogout();
	  Thread.sleep(1000);
	  cyclosPOM.cyclosGenericLogin("admin","12345");
	  cyclosPOM.enterMemberName("srivalli");
	  Thread.sleep(2000);
	  cyclosPOM.searchLoan();
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("CYTC03405");
	  cyclosPOM.viewLoanDetails("Education Loan");
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("CYTC03406");
	  String Actual=cyclosPOM.remainingAmount();
	  String Expected="995,00 units";
	  Assert.assertEquals(Actual, Expected);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  //Close browser
	  Thread.sleep(3000);
	  driver.quit();
  }
}
