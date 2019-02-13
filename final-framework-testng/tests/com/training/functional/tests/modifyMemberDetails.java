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

public class modifyMemberDetails {
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
  
//	To Verify whether application allows member to modify the profile details in My Profile Page  
@Test
public void cytc_005() throws InterruptedException {
	  Thread.sleep(3000);
	  cyclosPOM.cyclosGenericLogin("srivalli2","pass12345");
	  screenShot.captureScreenShot("CYTC00501");
	  Thread.sleep(3000);
	  cyclosPOM.myProfileOption();
	  screenShot.captureScreenShot("CYTC00502");
	  Thread.sleep(2000);
	  cyclosPOM.changeProfileBtn();
	  screenShot.captureScreenShot("CYTC00503");
	  Thread.sleep(1000);
	  cyclosPOM.changeAddress("Raidurgam");
	  cyclosPOM.saveButton();
	  screenShot.captureScreenShot("CYTC00504");
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();
	  screenShot.captureScreenShot("CYTC00505");
	  String Actual = cyclosPOM.verifyAddress();
	  String Expected = "Raidurgam";
	  Assert.assertEquals(Actual, Expected);
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
