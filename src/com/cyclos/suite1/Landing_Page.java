package com.cyclos.suite1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import org.testng.asserts.*;

import com.cyclos.tests.TestBase;
import com.cyclos.util.TestUtil;

public class Landing_Page extends TestBase{
	
	@BeforeMethod
	public static void testDemoLogin() throws Throwable{
		
		System.out.println("Starting Test");
		TestUtil.launchLoginSite();
	}
		
	//Change Password
	@Test(priority = 1)
	public static void changePassword() throws InterruptedException{
		/*change password by click on the link in the login page
		 * RUN THIS TEST IN DEBUG MODE. THIS TEST REQUIRES VISULA VALIDATION
		 * ENATER EMAIL AND VISULA CODE.
		 * VALIDATE NOTIFICATION MESSSAGE
		 */
		
		WebElement change_pssword = driver.findElement(By.partialLinkText("if you have forgotten your login name"));
		change_pssword.click();
		
		
			
	   driver.findElement(By.xpath(OR.getProperty("first_input"))).sendKeys("bharathi.ramapatnam@gmail.com");;//first input box
        System.out.println("please input validation code");
		//driver.findElement(By.xpath(OR.getProperty("new_code"))).sendKeys("");//enter new code
		driver.findElement(By.xpath(OR.getProperty("submit_button"))).click();//enter new code
		String Notification = driver.findElement(By.xpath(OR.getProperty("notification_text"))).getText();
		String actual = "You will receive shortly an e-mail with your login name and instructions on how to reset your password";
		Assert.assertEquals(actual, Notification);
		System.out.println(actual);
		driver.findElement(By.xpath(OR.getProperty("close_button"))).click();//enter new code
		
	}
		
			
		
	@Test(groups = { "LandingPageTest" })
	public static void validateFileds() throws InterruptedException{
		/*VALIDATE REGISTER LINK
		 * VALIDATE CHANGE PASSWORD LINK
		 * PRINT ALL INPUT FILED NAME
		 * PRINT ALL BUTTONS ON THIS PAGE
		 */
		 
		WebElement register_link = driver.findElement(By.linkText("Click here to register"));
		
        register_link.click();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
		driver.navigate().back();
		
		WebElement change_pssword = driver.findElement(By.partialLinkText("if you have forgotten your login name"));
		change_pssword.click();
		System.out.println(driver.getTitle());
		
		//print all inputs
		List<WebElement> inputs = driver.findElements(By.xpath(OR.getProperty("allInput")));
		List<WebElement> buttons = driver.findElements(By.xpath(OR.getProperty("allButton")));
		
		for (int i=0;i<inputs.size();i++){
			System.out.print(inputs.get(i).getText());
		}
		
		//print all buttons
		for (int j=0;j<buttons.size();j++){
			System.out.print(buttons.get(j).getText());
		
	
	
	}
		
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("------------");
	}

}
