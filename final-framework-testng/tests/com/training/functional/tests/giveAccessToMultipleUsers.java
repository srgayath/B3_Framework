package com.training.functional.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.AccessToMultipleMembersDataProvider;
import com.training.dataproviders.GiveAccessToMemberDataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.CyclosPOM;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class giveAccessToMultipleUsers {
	private static WebDriver driver;
	private static String baseUrl;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static CyclosPOM cyclosPOM;

  @BeforeClass
  public static void setUpBeforeClass() throws IOException, InterruptedException {
	  properties = new Properties();
	  FileInputStream inStream = new FileInputStream("./resources/others.properties");
	  properties.load(inStream);
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
	  cyclosPOM = new CyclosPOM(driver);
	  baseUrl = properties.getProperty("baseURL");
	  new RegisterUserPOM(driver);
	  screenShot = new ScreenShot(driver); 
	  // open the browser 
	  driver.get(baseUrl);
	  Thread.sleep(3000);
	  cyclosPOM.cyclosGenericLogin("admin","12345");
  }
  
//To Verify whether application allows admin to provide access to registered member
@Test (dataProvider="test-data", dataProviderClass=AccessToMultipleMembersDataProvider.class)
public void cytc_003(String memberName) throws InterruptedException {
		screenShot.captureScreenShot("TC06501"+memberName);
	  cyclosPOM.enterMemberName(memberName);
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("TC06502"+memberName);
	  cyclosPOM.changeMemberSubmit();
	  Thread.sleep(1000);
	  cyclosPOM.selectNewGroup("Full members");
	  cyclosPOM.enterComments("Full access to member");
	  screenShot.captureScreenShot("TC06503"+memberName);
	  cyclosPOM.submitChange();
	  screenShot.captureScreenShot("TC06504"+memberName);
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);
	  String Expected = "Full members";
	  String Actual = cyclosPOM.getNewGroup();
	  cyclosPOM.clickHomeMenu();
	  Thread.sleep(2000);
	  Assert.assertEquals(Actual, Expected);	  
}

  @AfterClass
  public void afterMethod() throws InterruptedException {
	  //Close browser
	  Thread.sleep(3000);
	  driver.quit();
  }

}
