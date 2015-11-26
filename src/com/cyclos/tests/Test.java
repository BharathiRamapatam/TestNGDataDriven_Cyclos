package com.cyclos.tests;

import com.cyclos.datatable.Xls_Reader;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

      Xls_Reader datatable=new Xls_Reader(System.getProperty("user.dir")+"//src//config\\suite1.xlsx");
      String testCase="PayUser_Page";
      
      System.out.println(datatable.getCellData("suite", "TestCaseName", 2));
      System.out.println(datatable.getRowCount("suite"));
      
      for(int i=2; i<=datatable.getRowCount("suite");i++ ){
    	  //System.out.println(datatable.getCellData("suite", "TestCaseName", i));
          if(datatable.getCellData("suite", "TestCaseName", i).equals(testCase)){
        	  if(datatable.getCellData("suite", "Runmode", i).equals("Y"))
    	        	 System.out.println("Runmode is Yes");
    	  
        	  else
        		  System.out.println("Runmode is No");
        	  }
    	         
      }	     
    	          
      }    
    			  
}	  
      



		
		
		
		
	


