package com.encore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.encore.base.ConfigEncorEBase;
//Object Repositatory for EH PatientList Page

public class EHPatientList extends ConfigEncorEBase {
	
	@FindBy(xpath="//h1[contains(text(),'Patient List')]")
	WebElement PatientListLabel;
	
	
	public EHPatientList(){
		PageFactory.initElements(driver, EHPatientList.this);
	}
	
	public String VerifyPatientListTitle(){
		return driver.getTitle();
	}
	
	public  String verifyPatientListLable(){
		return PatientListLabel.getText();
		
	}

}
