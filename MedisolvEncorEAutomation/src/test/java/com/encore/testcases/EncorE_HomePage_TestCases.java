package com.encore.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.encore.base.ConfigEncorEBase;
import com.encore.pages.EHReportingPage;
import com.encore.pages.EncorEHomePage;
//The first way is to use Listeners annotation (@Listeners) as shown below:
//Test Cases for EncorE_HomePage_TestCases

@Listeners(com.encore.Utility.ListenerTestNG.class)			


public class EncorE_HomePage_TestCases extends ConfigEncorEBase{
EncorEHomePage homepage;
EHReportingPage Reportingpage;
	
	public EncorE_HomePage_TestCases(){
		//It will call ConfigEncorEBase Constructor to Initilize prop file 
			super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		//Create a Object EncorEHomePage and make this Object Variable on Class level so that we can use it entire code
		homepage= new EncorEHomePage();
		//Reportingpage= new EHReportingPage();
		
	}
	
	@Test(priority=1)
	public void EncorE_Title_Test(){
		String title=homepage.validateEncorEPageTitle();
		Assert.assertEquals(title, "EncorE");
		System.out.println("EncorE Page title is: "+title);
		System.out.println("Test1");
	}
	
	@Test(priority=2)
	public void EncorE_Logo_Test(){
		boolean EncorElogo=homepage.validateEcnorEImage();
		Assert.assertTrue(EncorElogo);
		System.out.println("EncorE Page Logo Status is : "+EncorElogo);
		System.out.println("Test2");
	}
	
	@Test(priority=3)
	public void EncorE_HomeIcon_Test(){
		boolean falg=homepage.validateHomeIcon();
		Assert.assertTrue(falg);
		System.out.println("EncorE Home Icon Status is : "+falg);
		System.out.println("Test3");
	}
	@Test(priority=4)
	public void EncorE_CurrentVersion_Test(){
		String tooltip=homepage.validateEncoreEVersion();
		System.out.println("Juniper Application Current Version is : "+tooltip);
		System.out.println("Test4");
	}
	@Test(priority=5)
	public void EncorE_CurrentUser_Test(){
		homepage.validateCurrentUser();
		System.out.println("Test5");
	}
	
	@Test(priority=6)
	public void EncorE_Reporting_Icon_Test(){
		String reporting=homepage.validateReportingIcon();
		Assert.assertEquals("Reporting", homepage.validateReportingIcon(),"Expected is :Reporting: TestCase Failed !!!");
		System.out.println("EncorE Header Menu is : " + reporting + ":-->   As Expeted ");
		System.out.println("Test6");
	}
	@Test(priority=7)
	public void EncorE_EncorD_Test(){
		String encorD=homepage.validateEncorDIcon();
		Assert.assertEquals(" Encor-D", homepage.validateEncorDIcon(),"Expected is : Encor-D: TestCase Failed !!!");
		System.out.println("EncorE Header Menu is : " + encorD + ":-->   As Expeted ");
		System.out.println("Test7");
		
	}
	@Test(priority=8)
	public void EncorE_EncorA_Test(){
		String encorA=homepage.validateEncorAIcon();
		Assert.assertEquals(" Encor-A", homepage.validateEncorAIcon(),"Expected is : Encor-A: TestCase Failed !!!");
		System.out.println("EncorE Header Menu is : " + encorA + ":-->   As Expeted ");
		System.out.println("Test8");
	}
	@Test(priority=9)
	public void EncorE_Administration_Test(){
		String Adminstr=homepage.validateAdministrationIcon();
		Assert.assertEquals("Administration", homepage.validateAdministrationIcon(),"Expected is : Administration: TestCase Failed !!!");
		System.out.println("EncorE Header Menu is : " + Adminstr + ":-->   As Expeted ");
		System.out.println("Test9");
	}
	
	//used RetryAnalyzer class as Parameter it will run failed test cases 2 times
	@Test(priority=10,retryAnalyzer = com.encore.testcases.RetryFailedTestCases.class)
	public void EncorE_ValueSet_Test(){
		String ValeSET=homepage.validateValueSetsIcon();
		Assert.assertEquals("Value Set", homepage.validateValueSetsIcon(),"Expected is : Value Sets: TestCase Failed !!!");
		System.out.println("EncorE Header Menu is : " + ValeSET + ":-->  As Expeted ");
		System.out.println("Test_10 ");
		
	}
	@Test(priority=11)
	public void EncorE_EH_EC_Load_Status_Test(){
		String EH_EC_Status=homepage.validateEH_EC_Load_Status();
		System.out.println("Last Load EH and EC Status is : "+EH_EC_Status);
		System.out.println("*********************************");
		System.out.println("Test_11");
	}
	@Test(priority=12)
	public void EncorE_HeaderMenus_Test(){
		String ValeSET=homepage.validate_AllHeader_Menu();
		System.out.println("EncorE Header Menu List : " + ValeSET);
		System.out.println("Test_12----USED {throw new SkipException(to test skeep test cases)} ");
		//Used SkeepExceptiopn
		throw new SkipException("test casnot ready to test -- Test SkeepExceptiopn");
	}
	
	@Test(priority=13)
	public void VerifyMovetoReportingPage_Test(){
		
		//Here will click some element so will move to reporting page
		Reportingpage=homepage.CickReprting();
		System.out.println("Test_13");
		System.out.println("EncorE Home to Reporting Redirect Suessfully");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
