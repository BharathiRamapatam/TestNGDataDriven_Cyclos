package com.cyclos.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cyclos.datatable.Xls_Reader;
import com.cyclos.tests.TestBase;

public class TestUtil extends TestBase{
	
	public static boolean isTestCaseRunnable(String testCase){
		for(int i=2; i<=datatable.getRowCount("suite");i++ ){
	    	  if(datatable.getCellData("suite", "TestCaseName", i).equals(testCase)){
	    		  if(datatable.getCellData("suite", "Runmode", i).equals("Y"))
	    			  return false;
	    		  else
	    			  return true;
	    	  }
	    	  
	      }
		
		return false;
	}
	
	public static void launchLoginSite(){
		driver.get((config.getProperty("loginSiteURL")));
		
	}

	public static  void dodemoLogin(String uname, String pword ){
		if(isLoggedIn){
			return;
		}
		
		
		    TestUtil.launchLoginSite();
			//launchLoginSite();
			logger.info("Loggin intoCyclos");// log
			driver.findElement(By.cssSelector(OR.getProperty("username_field"))).sendKeys(uname);;
			driver.findElement(By.xpath(OR.getProperty("password_filed"))).sendKeys(pword);
			
			driver.findElement(By.xpath(OR.getProperty("submit_Login"))).click();
			
			try {
			String welcome_Message = driver.findElement(By.xpath(OR.getProperty("welcome_demoMessage"))).getText();
			System.out.println(welcome_Message);
		    Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("welcome_demoMessage"))).getText(), "Welcome to the Cyclos4 Demo", "Successful Login");
		    WebElement loginName = driver.findElement(By.xpath(OR.getProperty("demo_loginName")));
		    String logName=loginName.getText();
		    System.out.println(logName);
		    if(logName.equals("uname")){
		    	isLoggedIn=true;
		    	
		    }else{
		    	isLoggedIn=false;
		    }
		    	
		    
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
	public static boolean isElementPresent(By by){
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			 
			e.printStackTrace();
		}
	
	return false;
			
		}
	
	public static Object[][]  getData(String testName, Xls_Reader xls){
		
		int rows = xls.getRowCount("DataProviderTests");
		System.out.println("Total rows - "+ rows);
		
		// row number for testCase
		int testCaseRowNum=1;
		
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++){
			String testNameXls = xls.getCellData("DataProviderTests", 0, testCaseRowNum);
			if(testNameXls.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test Starts from row Number - "+ testCaseRowNum);
		
		int dataStartRowNum=testCaseRowNum+2;
		int colStartRowNum=testCaseRowNum+1;
		
		// rows of data
		int testRows=1;
		while(!xls.getCellData("DataProviderTests", 0, dataStartRowNum+testRows).equals("")){
			testRows++;
		}
		System.out.println("Total rows of data are - "+testRows);
		
		// cols of data
		int testCols=0;
		while(!xls.getCellData("DataProviderTests",testCols,colStartRowNum).equals("")){
			testCols++;
		}

		
		Object[][] data = new Object[testRows][testCols];
		System.out.println("Total cols "+testCols );
		int r=0;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			for(int cNum=0;cNum<testCols;cNum++){
				//System.out.println(xls.getCellData("DataProviderTests", cNum, rNum));
				data[r][cNum]=xls.getCellData("DataProviderTests", cNum, rNum);
			}
			r++;
			
		}
		return data;
	}
	
	//Take screenshot of webelement
	public static void takeScreenshotElement(String element, String fileName) throws Exception{
		
		WebElement ele = driver.findElement(By.xpath(element));   
		//Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		//Get the location of element on the page
		Point point = ele.getLocation();
		//Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		//Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,
		    eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		//Copy the element screenshot to disk
		FileUtils.copyFile(screenshot, new File("c:\\images\\"+fileName+".png"));
	}
	
	//store screenshots
		public static void takeScreenShot(String fileName) {
			
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//take screenshot by calendar date and time 
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		    try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+formater.format(calendar.getTime())+fileName+".jpg"));
			} catch (Throwable t) {
				
				t.printStackTrace();
			}
				
				
			}
		
	}

		


	


		
		
		
		
	
	
	


