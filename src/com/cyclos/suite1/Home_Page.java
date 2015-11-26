package com.cyclos.suite1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.asserts.*;

import com.cyclos.tests.TestBase;
import com.cyclos.util.TestUtil;

public class Home_Page  extends TestBase{
	
	
	@Test
	public static void checkForLinks( ){
		/*verify if the links on the home page have response code of 200.
		 * And also links are present on the home page
		 * 
		 */
		//Go to Homepage
		driver.findElement(By.cssSelector(OR.getProperty("main_home"))).click();
		
		System.out.println(driver.findElement(By.linkText("Google play store")).getAttribute("href"));
		Assert.assertEquals("https://play.google.com/store/apps/details?id=org.cyclos.mobile&hl=en", driver.findElement(By.linkText("Google play store")).getAttribute("href"));
		
		
	}
	@Test//check if google.com/stores link is working or not
	public static void checkResponce(){
	checkResponse("https://play.google.com/store/apps/details?id=org.cyclos.mobile&hl=en");
	}
	
	
	
	
		
		
		
		
		
		
		
	}


 