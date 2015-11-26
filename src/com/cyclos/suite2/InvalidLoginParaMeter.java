package com.cyclos.suite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cyclos.datatable.Xls_Reader;
import com.cyclos.tests.TestBase;
import com.cyclos.util.ErrorUtil;
import com.cyclos.util.TestUtil;

public class InvalidLoginParaMeter extends TestBase{
	
	@BeforeMethod
	public static void launchLoginSite(){
		TestUtil.launchLoginSite();
		
	}
	
	@Test(dataProvider = "getData")
	public void doInVaidLoginParam(String runmode, String UN, String PW){
		
		logger.info("Loggin intoCyclos");// log
		try {
			Thread.sleep(8000);
			
			driver.findElement(By.cssSelector(OR.getProperty("username_field"))).sendKeys(UN);
			driver.findElement(By.xpath(OR.getProperty("password_filed"))).sendKeys(PW);
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("submit_Login"))).click();
			
			
			
			//collect the error messages And include to take screenshots
			//http://stackoverflow.com/questions/13832322/how-to-capture-the-screenshot-of-only-a-specific-element-using-selenium-webdrive
			
			TestUtil.takeScreenShot("InvalidLogin");
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("closeError_button"))).click();
			driver.findElement(By.cssSelector(OR.getProperty("username_field"))).clear();
			driver.findElement(By.xpath(OR.getProperty("password_filed"))).clear();
		} catch (InterruptedException e) {
			
		ErrorUtil.addVerificationFailure(new Throwable(e));
			e.printStackTrace();
		}
		
	}

		@DataProvider
	public Object[][] getData(){
			
			Xls_Reader xls1 = new Xls_Reader(System.getProperty("user.dir")+"\\src\\config\\suite1.xlsx");
			return TestUtil.getData("InvalidLoginParaMeter", xls1);
			
		
	}
  @AfterMethod
		public static void endinvalidLogin(){
			System.out.println("END");
		
  }	

}
