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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class insertNewAdByAdmin {
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
  
//  To verify whether application allows member  to view added advertisement by the admin  
  @Test
  public void cytc_031() throws InterruptedException {
	  cyclosPOM.cyclosGenericLogin("admin","12345");
	  screenShot.captureScreenShot("CYTC03101");
	  Thread.sleep(2000);
	  cyclosPOM.enterMemberName("srivalli");
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("CYTC03102");
	  cyclosPOM.manageAdvertisements();
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("CYTC03103");
	  cyclosPOM.insertNewAdBtn();
	  screenShot.captureScreenShot("CYTC03104");
	  Thread.sleep(2000);
	  String ExpectedTitle = "New ad";
	  cyclosPOM.createNewAd(ExpectedTitle, "Example ad category", "600", "Ad for a member");
	  screenShot.captureScreenShot("CYTC03105");
	  Thread.sleep(2000);
	  cyclosPOM.cyclosLogout();
	  Thread.sleep(1000);
	  cyclosPOM.cyclosGenericLogin("srivalli","srivalli");
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("CYTC03105");
	  cyclosPOM.personalTabOpt();
	  Thread.sleep(1000);
	  cyclosPOM.advertisementsLink();
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("CYTC03106");
	  String Actual = driver.findElement(By.xpath("//div[@class='productTitle']/a")).getText();
	  cyclosPOM.memberLogout();
	  Thread.sleep(1000);
	  Assert.assertEquals(Actual, ExpectedTitle);
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
