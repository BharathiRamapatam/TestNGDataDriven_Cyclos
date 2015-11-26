package com.cyclos.suite1;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cyclos.tests.TestBase;
import com.cyclos.util.TestUtil;
import com.sun.jna.platform.win32.GL;



public class DataDrivenTests extends TestBase {
	
	@BeforeSuite
	public static void beforeSuite(){
		TestUtil.dodemoLogin("demo2", "1234");
		
	}
	@AfterSuite
	public static void afterSuite(){
		System.out.println("logout");
	}
	
	
	@BeforeTest
	public void L1(){
		
	
		//Go to to user link from home page. This test is for demo 2 only
		Actions act = new Actions(driver);
		WebElement banking_link = driver.findElement(By.xpath(OR.getProperty("banking_MainLink")));
		act.moveToElement(banking_link).perform();
		
		WebElement to_user_link = driver.findElement(By.linkText(OR.getProperty("toUserLink"))); 
		act.moveToElement(to_user_link).build().perform();
		to_user_link.click();
		
		
		
	}
	
	/*Payment to existing contact from the contact list
	 * 
	 * 
	 */
	
	@Test(priority=2, groups = { "paymentTest" } )
	public void payment_to_contact( ) throws InterruptedException{
		
		driver.findElement(By.xpath(OR.getProperty("contact_radioButton"))).click();//click on contact radiobuton
		driver.findElement(By.cssSelector(OR.getProperty("dropdown_arrow"))).click();//click on contact dropdown
		driver.findElement(By.cssSelector(OR.getProperty("input_filed"))).sendKeys("demo user");//input demo
		driver.findElement(By.linkText(OR.getProperty("demo_User"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("amount_inputBox"))).sendKeys("1");
		Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.xpath(OR.getProperty("amount_inputBox"))).getText());
		
		driver.findElement(By.xpath(OR.getProperty("description"))).sendKeys("Test payment to demo user ");
		
		driver.findElement(By.xpath(OR.getProperty("submit_contact_payment"))).click();
		
		System.out.println(driver.findElement(By.xpath(OR.getProperty("review_paymentMessage"))).getText());
		
		//insert assert for amout and user type
		driver.findElement(By.xpath(OR.getProperty("confirm_button"))).click();
		
		
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath(OR.getProperty("confirm_messsage"))).getText());
		
		
		Assert.assertEquals("The payment was successful", driver.findElement(By.xpath(OR.getProperty("confirm_messsage"))).getText());
		
		//String first_col = "html/body/div[3]/div[3]/div/div/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr/td[1]";
		//String Second_col = "html/body/div[3]/div[3]/div/div/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr/td[2]";
		
		String Transaction_id = OR.getProperty("transaction_id");
		String dateTime=OR.getProperty("date_time");
		
		java.util.List<WebElement> id  = driver.findElements(By.xpath(Transaction_id));
		
		java.util.List<WebElement> date_time  = driver.findElements(By.xpath(dateTime));
	    for (int i=0;i<id.size();i++){
	    	
	        String result = id.get(i).getText() + date_time.get(i).getText();
	    	System.out.println(result);
	    }
	    
	    		
		
		
	    }
	
	@AfterTest
	private void log_out(){
		
		System.out.println("test complete");
	  
		
	}
	
	
    @Test
	public void anotherTest(){
    	//this test to parameterise for contact string.
		
		List<WebElement> el = driver.findElements(By.xpath(OR.getProperty("List_Radio_payUser")));
	    String button_name = "Contact"  ;
	    String button_user = "User";
	    for(int i=0;i<el.size();i++){
		System.out.println(el.get(i).getText());
	    
	
		if(el.get(i).getText().equals(button_name))
			el.get(i).click();
		}
	    driver.findElement(By.cssSelector(OR.getProperty("dropdown_arrow"))).click();
	    
	    
		String contact = "Nirmala";
		List<WebElement> anchors = driver.findElements(By.cssSelector(OR.getProperty("listContact_css")));
	    for( int i=0;i<anchors.size();i++){
	    	System.out.println(anchors.get(i).getText());
	    }
		Iterator<WebElement> i = anchors.iterator();
	 
	    while(i.hasNext()) {
	        WebElement anchor = i.next();
	        if(anchor.getText().equals(contact)) {
	        	
	            anchor.click();
	            break;
	        }
	        
	        
	    }
		
		
	}
		
	}
	    	
	    	
	    		
	    	
	    	
	    	
	    
	

	    		
	    			
	    	
	    				
	    			
	    		
	    
	    		
	    		
	    	
	    	
	    		    		
	    
	    		
	    	
	    	
	    		      
	    	
	    			
	    		
	    	
	    	
	    	
	    		
	    		
	    	
	    	
	    		
	    		
	    	
	    
	    
	    	//Assert.assertEquals(list.get(j).getText().equals("contact"), contact);
	    	/*
	    	if(list.get(j).equals("contact")){
	    		break;
	    	}
	    	Assert.assertEquals(actual, expected);
	    		System.out.println(contact + "contact is found ");
	    		list.get(j).click();
	    		*/
	    		
	    	
	    
	
		
		
		
	
		
		

	
	
	
	
	
	    
	    
	    
		
		
		
		
		
		
	
		
		
				
		
		
		
		
		
		
	
	


