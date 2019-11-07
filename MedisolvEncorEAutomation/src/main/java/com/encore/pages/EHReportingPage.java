package com.encore.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.encore.Utility.GlobalWaitDeclaration;
import com.encore.base.ConfigEncorEBase;


public class EHReportingPage extends ConfigEncorEBase {
	
	@FindBy(xpath="//a[contains(text(),'Reporting')]")
	WebElement ClickOnReporting;
	
	@FindBy(xpath="//li[@class='open']/ul")////li[@class='open']/ul[1]
	WebElement AllReprtingMenu;
	
	//This will chick on Hospital Measures
	@FindBy(xpath="//a[contains(text(),'Hospital Measures')]")
	WebElement Hospital_Measures;
	
	//This will chick on Hospital Measures
	@FindBy(xpath="//a[contains(text(),'Hospital Measures')]/following-sibling::ul")
	List<WebElement> EHMenuList;
	
	//a[contains(text(),'Hospital Measures')]/following-sibling::ul
	
	//Click On Patient List
	
	@FindBy(xpath="//li[@class='ecqm-section']/a[@href='/juniper-sh-qa-f-25/Reporting/PatientList']")
	WebElement EHPatientListPageLanding;
	
	//We have to write Constructor to initialize Page Object  so we wrote Constructor here
	public EHReportingPage(){
		PageFactory.initElements(driver, EHReportingPage.this);
	}
	
	public String verifyEHPageTitle(){
		return driver.getTitle();
	}
	
	//Actions: 
	public void ValidateClickONReporting(){
		ClickOnReporting.click();
	}
	
	public String Validate_AllReprting_MenuList(){
		  return AllReprtingMenu.getText();
	}
	public String Validate_HospMeasure(){
		  return Hospital_Measures.getText();
	}
	public  void Validate_EHMenu(){
		
	}
	public  EHPatientList ClickonPatientList(){
		try{
		Actions action = new Actions(driver);
		action.moveToElement(Hospital_Measures).clickAndHold().build().perform();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(EHPatientListPageLanding));
		//action.click(EHPatientListPageLanding).perform();
		EHPatientListPageLanding.click();
		driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return new EHPatientList();
	}

}
