package com.encore.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.encore.base.ConfigEncorEBase;

//Object Repositatory for EH HomePage

public class EncorEHomePage extends ConfigEncorEBase{
	
		//Page Factory [OR] Object Repository 
	
		//Verify Juniper   test
		@FindBy(xpath="//img[@src='/juniper-sh-qa-f-25/Content/Encor-electronics-logo.png']")
		public WebElement EncorELogo;
		
		//Defaul HomePAge Icon
		@FindBy(xpath="//ul[@id='homepage-navigation']//a[text()='Home']")
		public WebElement HomeIcon;
		
		//Verify Reporting Icon
		@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Reporting ']")
		public WebElement ReportingIcon;
		
		//Verify EncorD Icon
		@FindBy(xpath="//li[@class='homepage-low-resolution-hide eh-section ep-section']//a[@href='http://msv-qa-web/encord-sh-qa-x-02']")
		public WebElement EncorDIcon;
		
		//Verify EncorA Icon
		@FindBy(xpath="//li[@class='homepage-low-resolution-hide eh-section ep-section']//a[@href='http://msv-qa-web/encor-mh-qa-c-40']")
		public WebElement EncorAIcon;
		
		//Verify EncorE Administration Icon
		@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Administration ']")
		public WebElement EncorAdminstrationIcon;
		
		//Verify EncorE ValueSet Icon
		@FindBy(xpath="//li[@class='homepage-low-resolution-hide']")
		public WebElement ValueSetIcon;
		
		//Verify EncorE EH and EC Load Details 
		@FindBy(id="homepage-load-information")////div[@id='homepage-load-information']
		public WebElement EH_EC_Load_Info_Status;
		
		//Verify Juniper CurrentVersion	
		@FindBy(xpath="//a[@class='navbar-brand']")
		public  WebElement EncorE_Current_Version;
		
		//Verify Current UserName	
		@FindBy(xpath="//a[./span[@class='glyphicon glyphicon-user']]")
		public  WebElement EncorE_Current_user;
		
		
		//ALl Header MenuList:
		@FindBy(xpath="//ul[@class='navbar-nav nav']")
		public WebElement All_Header_Menu;
		
		@FindBy(xpath="//a[contains(text(),'Reporting')]")
		WebElement ClickOnReporting;
		
		//Create a Constructor to Initialize Page Object or WebElements using PageFactory.initElements methods
		public EncorEHomePage(){
			PageFactory.initElements(driver, EncorEHomePage.this); //OR this
		}
		
		//Actions:
		public String validateEncorEPageTitle(){
			return driver.getTitle();
		}
		public boolean validateEcnorEImage(){
			return EncorELogo.isDisplayed();
		}
		public boolean validateHomeIcon(){
			return HomeIcon.isDisplayed();
		}
		public String validateReportingIcon(){
			return ReportingIcon.getText();
		}
		public String validateEncorDIcon(){
			return EncorDIcon.getText();
		}
		public String validateEncorAIcon(){
			return EncorAIcon.getText();
		}
		public String validateAdministrationIcon(){
			return EncorAdminstrationIcon.getText();
		}
		public String validateValueSetsIcon(){
			return ValueSetIcon.getText();
		}
		public String validateEH_EC_Load_Status(){
			return EH_EC_Load_Info_Status.getText();
		}
		
		public String validate_AllHeader_Menu(){
			return All_Header_Menu.getText();
		}
		public String validateEncoreEVersion(){
			return EncorE_Current_Version.getAttribute("title");
		}
		public WebElement validateCurrentUser(){
			WebElement username=(EncorE_Current_user);
			System.out.println("Current User Name is : "+username.getText().trim());
			return username;
		}
		
		public EHReportingPage CickReprting(){
			ClickOnReporting.click();
			return new EHReportingPage();
		}
		// New code for getAll link
		
		public String getAlllink(){
			String url="";
			List <WebElement> AllLink=driver.findElements(By.tagName("a"));
			System.out.println("Total Number of Link  is "+AllLink.size());
			Iterator<WebElement> it=AllLink.iterator();
			while(it.hasNext())
			{
				url=it.next().getAttribute("href");
				String str=it.next().getText();
				System.out.println(url);
				System.out.println(str);
				
			if(url == null || url.isEmpty())
				{
					System.out.println("URL is either not configured for anchor tag or it is empty"+url);
					continue;
				}
			else if (str == null || str.isEmpty())
				{
					System.out.println("String anchor tag or it is empty"+str);
					continue;
				}
			}
			return url;
			
		}
			

}
