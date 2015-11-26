package com.cyclos.suite2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cyclos.datatable.Xls_Reader;
import com.cyclos.tests.TestBase;
import com.cyclos.util.TestUtil;

public class SearchUserDataDrivenTest extends TestBase{
	
	@BeforeTest
	public void init(){
		//TestUtil.launchLoginSite();
		//TestUtil.dodemoLogin("demo2", "1234");
		
		Actions act = new Actions(driver);
		WebElement userMain = driver.findElement(By.xpath(OR.getProperty("userMain_link")));
		act.moveToElement(userMain).perform();
		
		List<WebElement> userDropdown = driver.findElements(By.xpath(OR.getProperty("list_user")));
	    for( int i=0;i<userDropdown.size();i++){
	    	System.out.println(userDropdown.get(i).getText());
	    }
		
		WebElement search = driver.findElement(By.linkText(OR.getProperty("search_link"))); 
		act.moveToElement(search).build().perform();
		search.click();
		
	}
	
	@Test(enabled = false)
	//Test Prints all the elements in main heading
	public void searchUser(){
		String contact = "User";
		List<WebElement> anchors = driver.findElements(By.xpath(OR.getProperty("allMainHeading_Elements")));
	    for( int i=0;i<anchors.size();i++){
	    	System.out.println(anchors.get(i).getText());
	    }
	    System.out.println("------------------------");
	}
	
	@Test(dataProvider = "getData")
	public void searchUser1(String runmode, String searchString) throws InterruptedException{
		/*Search for users
		 * verify if the seach result contains the search string
		 
		Actions act = new Actions(driver);
		WebElement userMain = driver.findElement(By.xpath(OR.getProperty("userMain_link")));
		act.moveToElement(userMain).perform();
		
		List<WebElement> userDropdown = driver.findElements(By.xpath(OR.getProperty("list_user")));
	    for( int i=0;i<userDropdown.size();i++){
	    	System.out.println(userDropdown.get(i).getText());
	    }
		
		WebElement search = driver.findElement(By.linkText(OR.getProperty("search_link"))); 
		act.moveToElement(search).build().perform();
		search.click();
		*/
		
		System.out.println("Starting test for "+ "---" + searchString );
		
		driver.findElement(By.cssSelector(OR.getProperty("input_box"))).sendKeys(searchString);
		driver.findElement(By.xpath(OR.getProperty("searchButton"))).click();
		Thread.sleep(5000);
		
		List<WebElement> searchResult = driver.findElements(By.xpath(OR.getProperty("searchItems")));
    	System.out.println(searchResult.size());
	    for( int j=0;j<searchResult.size();j++){
	    	System.out.println(searchResult.get(j).getText());
		
	    }
	    driver.findElement(By.cssSelector(OR.getProperty("input_box"))).clear();
	    Thread.sleep(5000);
	    
	    
	    
}
	@DataProvider
	public Object[][] getData(){
		
		Xls_Reader xls1 = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\cyclos\\datatable\\suite1.xlsx");
		return TestUtil.getData("SearchUserDataDrivenTest", xls1);
		
		/*
		
		Object[][] data = new Object[3][1];

		//return TestUtil.getData("RegisterTest");
		 //1st row 
		data[0][0]="User";
		data[1][0]="bharathi";
		data[2][0]="Test";
		
		return data;
	*/
	}
	
}

	        	
	            
	     
	        
	        
	        
	        
	    


		
	
	
	


