package com.cyclos.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.fluent.Request;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.cyclos.datatable.Xls_Reader;



public class TestBase {
	public static Properties config;
	public static Properties OR;
	public static WebDriver driver;
	public static EventFiringWebDriver ed;
	public static WebElement Webelement;
	public static Xls_Reader datatable;
	public static boolean isLoggedIn = false;
	
	public static Logger logger = Logger.getLogger(TestBase.class.getName());
	
	@BeforeSuite
	public void initialise() throws Exception{
		
		
		
//load config properties file
		logger.debug(" initilising properties file");// log
		
		 config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\cyclos\\config\\config.properties");
		config.load(fis);
		//C:\Users\bharathi.ramapatnam\Documents\MavenProjects\SeleniumTestTG_DataDriven\\src\\config\\config.properties
		
		
//load or.properties file
	OR = new Properties();
	FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\cyclos\\config\\or.properties");
	OR.load(fis1);
	
//initilise xls data table
	new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\cyclos\\datatable\\suite1.xlsx");
	
	//initiliase the log file
	//String log4jConfPath = "C:\\Users\\bharathi.ramapatnam\\Documents\\MavenProjects\\SeleniumTestTG_DataDriven\\src\\log4j.properties";
	//PropertyConfigurator.configure(log4jConfPath);
	
	//initialise browser
	logger.debug(" initilising browsers");// log
		if(config.getProperty("browser").equals("Firefox")){
			 driver = new FirefoxDriver ();
		}else if(config.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\bharathi.ramapatnam\\Downloads\\chromedriver_win32\\chromedriver.exe");
		     driver= new ChromeDriver();
			
		}else if(config.getProperty("browser").equals("IE")){
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();					
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);					
			System.setProperty("webdriver.ie.driver", "C:\\Users\\bharathi.ramapatnam\\Downloads\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");	
		//"C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Jars\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		}
		
		
		//initiliase the event firing webdriver
		driver = new EventFiringWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80,TimeUnit.SECONDS);
		
		
		
		
	
		
	
	
	}
	
	//create functions to get elements by xpath,css,linktext
	/*
	public static WebElement getxpath(String xpathKey){
	 ed.findElements(By.xpath("xpathKey"));
	    return WebElement;
	 
		
	}
	
	public static  WebElement getcss(String cssKey){
		ed.findElements(By.cssSelector("cssKey"));
		return WebElement;
	
	}
	public static WebElement getLinkText(String linkText){
		return (WebElement) ed.findElements(By.linkText("linkText"));
	}
	*/
	public static void launchLoginSite(){
		driver.get((config.getProperty("loginSiteURL")));
		
	}
	//make demo login as an re-usable function
	
    public static void dologout(){
		logger.debug("loggin out of Cyclos");// log
		driver.findElement(By.xpath(OR.getProperty("logout_link"))).click();
	}
	
	public static boolean isElementPreanet(String xpathExpression){
		List<WebElement> element = driver.findElements(By.xpath(xpathExpression));
		if(element.size()==0)
			return false;
		else
			return true;
		
	}
	
	// check if the given url is working or not
	public static void checkResponse(String url){
		try {
            int resp_code= Request.Get(url).execute().returnResponse().getStatusLine()
                    .getStatusCode();
            System.out.println("Respose code for URL "+ url +" is -> "+ resp_code);
           if(resp_code == 200)
        	   //return true;
        	   System.out.println("Responce code received");
           else
        	   System.out.println("Fail to receive responce code");
        } catch (Exception e) {
     	   
        	System.out.println("Fail");
        }
	}
	
	
	
	
		
	}
	
	
		
		
		
		
	
	
	
	

