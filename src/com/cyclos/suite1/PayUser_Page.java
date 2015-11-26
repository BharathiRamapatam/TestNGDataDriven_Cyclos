package com.cyclos.suite1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.asserts.*;

import com.cyclos.tests.TestBase;
import com.cyclos.util.TestUtil;

public class PayUser_Page extends TestBase{
	
	@BeforeMethod
	public static void payUSerTest(){
     //launchLoginSite();
	//TestUtil.dodemoLogin("demo2", "1234" );
	driver.findElement(By.xpath(OR.getProperty("pay_user"))).click();
	}

	
   @AfterMethod
   public static void payUSerAfterMetnod(){
	System.out.println("pay user test complete");
   }
	
	
	@Test
	public static void paymentsTest() throws InterruptedException{
	
		
	    
	    Thread.sleep(5000);
		
		List<WebElement> radio_Buttons = driver.findElements(By.xpath(OR.getProperty("List_Radio_payUser")));
		System.out.println(radio_Buttons.size());
		
		for(int i= 0; i<radio_Buttons.size(); i++){
			System.out.println(( radio_Buttons).get(i).getText());
			//System.out.println(( radio_Buttons).get(i).getAttribute(""));
			
			/*
			for (WebElement radio : radio_Buttons) {
				if(radio.getAttribute("value").equals("Contact")){
				if(radio.getAttribute("checked")==null){
					radio.click();
					break;
				   }
				*/
			}

}
	@Test// verify if user radio button is enabled by default. 
	public static void checkRadioButtons() throws InterruptedException{


		
		WebElement user_rarioButton = driver.findElement(By.xpath(OR.getProperty("user_radioButton")));
		System.out.println("Enabled" + user_rarioButton.getAttribute("Class"));
		
		WebElement contact_rarioButton = driver.findElement(By.xpath(OR.getProperty("contact_radioButton")));
		System.out.println("Unchecked" + contact_rarioButton.getAttribute("Class"));
		
		contact_rarioButton.click();
		WebElement reFreshcontact_rarioButton = driver.findElement(By.xpath(OR.getProperty("contact_radioButton")));
		
		
		
		Thread.sleep(5000);
		//checkableImage STYLE_ICON-RADIOBUTTON_UNCHECKED_ENABLED
		//checkableImage STYLE_ICON-RADIOBUTTON_CHECKED_ENABLED
		Assert.assertEquals("checkableImage STYLE_ICON-RADIOBUTTON_CHECKED_ENABLED", reFreshcontact_rarioButton.getAttribute("Class"));
			
}
	
	@Test
	public static void docontactPayment() throws InterruptedException{
		
		throw new SkipException("Skipping the test ");
	}
	
	@Test
	public void dropdownTest(){//verify contact input box has text please select on option 
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("input_contact"))).getText(), "Please, select an option");
		//Please, select an option
		
		driver.findElement(By.xpath("dropdown_contact")).click();
		List<WebElement>list = driver.findElements(By.xpath(OR.getProperty("list_contact")));
		System.out.println(list.size());
	
		
	}
	
	
	
	
	

}
