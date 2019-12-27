package com.encore.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.encore.Utility.GlobalWaitDeclaration;
import com.encore.base.ConfigEncorEBase;
import com.encore.pages.EHPatientList;
import com.encore.pages.EHReportingPage;
import com.encore.pages.EncorEHomePage;

//Test Cases for ReportingPage_TestCases
@Listeners(com.encore.Utility.ListenerTestNG.class)	

public class ReportingPage_TestCases extends ConfigEncorEBase {
	EncorEHomePage homepage;
	EHReportingPage Reportingpage;
	EHPatientList PatientList;

	
	public ReportingPage_TestCases(){
		//Create a Constructor to call ConfigEncorEBase Constructor to initialization prop file 
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		//Create aObject ReportingEHPatientList and make this Object Variable on Class level so that we can use it entire code
		homepage= new EncorEHomePage();
		Reportingpage= new EHReportingPage();
		//PatientList=new EHPatientList();
	}
	//This invocationCount determined how many times TestNG should run this test method.
	@Test(priority=1,invocationCount = 2)
	public void VerifyReportingPageTitle(){
		String title=Reportingpage.verifyEHPageTitle();
		Assert.assertEquals(title, "EncorE");
		System.out.println("EncorE Page title is: "+title);
		System.out.println("Test_14");
		Reporter.log("Testing for Reporter.log use it only use in TESTNG ");
		
	}
	
	@Test(priority=2)
	public void ClickOn_Reporting_Test(){
			//driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Reportingpage.ValidateClickONReporting();
			System.out.println("User Has clicked on Reprting Sucessfully !!");
			driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
			System.out.println("Test_15");
	}
	@Test(priority=3)
	public void Display_All_ReportingMenu_Test(){
			//driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Reportingpage.ValidateClickONReporting();
			Reportingpage.Validate_AllReprting_MenuList();
			String MenuList=Reportingpage.Validate_AllReprting_MenuList();
			System.out.println("Default Menu List : "+MenuList);
			System.out.println("Test_16");
	}
	
	@Test(priority=4)
	public void Display_HospMenu_Test(){
			//driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Reportingpage.ValidateClickONReporting();
			String EHMeasure=Reportingpage.Validate_HospMeasure();
			Assert.assertEquals("Hospital Measures", Reportingpage.Validate_HospMeasure(),"Expected is : Hospital Measures: TestCase Failed !!!");
			System.out.println("EncorE Header Menu is : " + EHMeasure + ":-->  As Expeted ");
			System.out.println("Test_17");
	}
	
	@Test(priority=5)
	public void Display_EH_MenuList_Test(){
			Reportingpage.ValidateClickONReporting();
			//It will redirect to Patient List page
			//PatientList=Reportingpage.ClickonPatientList();
			System.out.println("Clicked on Reporting -Nevigate to Patient List");
			driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
			System.out.println("Test_18");
	}
	
	/*
	@Test(priority=6)
	public void VerifyMovetoPatientListPage_Test(){
		
		
	}*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
