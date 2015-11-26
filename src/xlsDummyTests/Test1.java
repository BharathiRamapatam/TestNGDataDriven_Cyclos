package xlsDummyTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cyclos.datatable.Xls_Reader;
import com.cyclos.util.TestUtil;


public class Test1  {
	
	@Test(dataProvider ="getData")
	public  void test1(String col1,String col3){
		System.out.println("Test1");
		
	}
	
	
	@DataProvider
	public Object[][]  getData(){
		Xls_Reader xls1 = new Xls_Reader("C://Users//bharathi.ramapatnam//Documents//testngBackup//Suite1.xlsx");
		//C:\\Users\\bharathi.ramapatnam\\Documents\\MavenProjects\\SeleniumTestTG_DataDriven\\src\\com\\cyclos\\datatable\\suite1.xlsx
		return TestUtil.getData("SearchUserDataDrivenTest", xls1);
		
		
		
		
		
	}

}
