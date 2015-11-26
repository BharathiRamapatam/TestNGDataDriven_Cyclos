package com.cyclos.suite2;

import org.testng.annotations.Test;

import com.cyclos.tests.TestBase;
import com.cyclos.util.TestUtil;

public class Personal_Page extends TestBase {
	
	@Test
	public static void changeProfilePic(){
		TestUtil.launchLoginSite();
		TestUtil.dodemoLogin("demo", "1234");
		
		
	}
	

}
