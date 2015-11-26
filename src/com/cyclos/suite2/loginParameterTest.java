package com.cyclos.suite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cyclos.datatable.Xls_Reader;
import com.cyclos.tests.TestBase;
import com.cyclos.util.ErrorUtil;
import com.cyclos.util.TestUtil;

public class loginParameterTest extends TestBase {
	
	
	
@Test(dataProvider = "getData", groups = { "ParameterTest" })
public void doLoginParam(String runmode, String UN, String PW) throws InterruptedException{
	
	logger.info("Loggin intoCyclos");// log
	Thread.sleep(5000);
	TestUtil.launchLoginSite();
	driver.findElement(By.cssSelector(OR.getProperty("username_field"))).sendKeys(UN);;
	driver.findElement(By.xpath(OR.getProperty("password_filed"))).sendKeys(PW);
	
	driver.findElement(By.xpath(OR.getProperty("submit_Login"))).click();
	
	try {
	String welcome_Message = driver.findElement(By.xpath(OR.getProperty("welcome_demoMessage"))).getText();
	System.out.println(welcome_Message);
	TestUtil.takeScreenShot(welcome_Message);
    Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("welcome_demoMessage"))).getText(), "Welcome to the Cyclos4 Demo", "Successful Login");
    WebElement loginName = driver.findElement(By.xpath(OR.getProperty("demo_loginName")));
    String logName=loginName.getText();
    System.out.println(logName);
	
	} catch (Exception e) {
		ErrorUtil.addVerificationFailure(e);
		
		e.printStackTrace();
	}
	TestUtil.dologout();
	}
	

	@DataProvider
public Object[][] getData(){
		
		Xls_Reader xls1 = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\cyclos\\datatable\\suite1.xlsx");
		return TestUtil.getData("loginParameterTest", xls1);
		
	
}
	

}
