package com.cyclos.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("b/M method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("a/M method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("b/T test"); 
  }

  
  @AfterTest
  public void afterTest() {
	  System.out.println("a/T test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("suite");
  }

}
