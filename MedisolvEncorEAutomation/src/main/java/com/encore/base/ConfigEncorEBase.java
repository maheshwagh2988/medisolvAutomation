package com.encore.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import com.encore.Utility.GlobalWaitDeclaration;

public class ConfigEncorEBase {
	//Global Variable  //Test New ver adde
	public static WebDriver driver;
	public static Properties prop; //To initialization Properties files we have create prop variable 
	
	//Create a Construcot for ConfigEncorEBase Class
	public ConfigEncorEBase(){
		try{
			prop=new Properties();
			FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/encore/config/config.properties");
			prop.load(fn);
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("IE")){
			
			System.setProperty("webdriver.ie.driver", "D:/Automation/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("Internet Explorer Browser Open Sucessfully"); 
			/*
			WebDriverManager.iedriver().setup();
			WebDriverManager.iedriver().clearPreferences();
			driver = new InternetExplorerDriver();
			Reporter.log("Internet Explorer Browser Open Successfully");
			*/
		 }
		else if(browserName.equals("Chrome")){
			WebDriverManager.chromedriver().clearPreferences();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("Chrome Browser Open Sucessfully");
			/*
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Chrome Browser Open Sucessfully");*/
		 }
		driver.manage().window().maximize();
		Reporter.log("Windos maximize Sucessfully"); 
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(GlobalWaitDeclaration.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(GlobalWaitDeclaration.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
