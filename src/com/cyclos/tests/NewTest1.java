package com.cyclos.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest1 {
  @Test
  public void f() {
	  System.out.println("test2");
  }
  @Test
  public void f1() {
	  System.out.println("test3");
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
	  System.out.println("b/T method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("a/T method");
  }

}
