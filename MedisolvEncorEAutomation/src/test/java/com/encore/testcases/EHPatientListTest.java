package com.encore.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.encore.Utility.GlobalWaitDeclaration;
import com.encore.base.ConfigEncorEBase;
import com.encore.pages.EHPatientList;
import com.encore.pages.EHReportingPage;
import com.encore.pages.EncorEHomePage;
//Add @Listeners for Reporting as well as Log and also to run failed test Cases
@Listeners(com.encore.Utility.ListenerTestNG.class)	
public class EHPatientListTest extends ConfigEncorEBase{
	
	EncorEHomePage homepage;
	EHReportingPage Reportingpage;
	EHPatientList PatientList;
	
	
	public EHPatientListTest(){
	//Create a Constructor to call ConfigEncorEBase Constructor to initialization prop file 
		super();
	}
	
	//test case should be separated 
	//Before each test case --launch the browser and Login  --- @Before Method
	//@test --execute each test cases                       ----@Test
	//After each test case-- close the browser				----@After Method
	
	@BeforeMethod
	public void setUp(){
		initialization();
	//Create aObject ReportingEHPatientList and make this Object Variable on Class level so that we can use it entire code
		homepage= new EncorEHomePage();
		Reportingpage= new EHReportingPage();
		PatientList=new EHPatientList();
	}
	@Test(priority=1)
	public void ValidatePatientListTitle(){
		homepage.validateCurrentUser();
		homepage.validateEncoreEVersion();
		Reportingpage.ValidateClickONReporting();
		PatientList=Reportingpage.ClickonPatientList();
		//driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Compare Patient List Title
		String Plist_title=PatientList.VerifyPatientListTitle();
		driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertEquals(Plist_title, "Patient List","Invalid Page Title ---Test Case Failed -Or Page is not Redirect to Patient List");
		System.out.println("Patient List Page title is: "+Plist_title);
		System.out.println("Test_19");
		
	}
	@Test(priority=2)
	public void ValidatePatientListLabel(){
		homepage.validateCurrentUser();
		homepage.validateEncoreEVersion();
		Reportingpage.ValidateClickONReporting();
		PatientList=Reportingpage.ClickonPatientList();
		String PListLabel=PatientList.verifyPatientListLable();
		Assert.assertEquals(PListLabel, "Patient List", "Invalid Label has been Print Test Case Failed");
		System.out.println("Label Name is : " +PListLabel);
		System.out.println("Test_10");
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
