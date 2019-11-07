package com.encore.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import net.bytebuddy.asm.Advice.Return;

import com.encore.base.ConfigEncorEBase;

public class GlobalWaitDeclaration extends ConfigEncorEBase {

	static Workbook book; 
	static Sheet Sheet;
	public static String TESTDATA_SHEET_PATH="";
	
	public static long PAGE_LOAD_TIMEOUT=30; //Time out function return long so take long variable
	public static long IMPLICIT_WAIT=40;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainPanel");
	}
	
	public static Object[][]getTestData(String sheetName){
		FileInputStream file= null;
		try{
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
			book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e){
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		Sheet= book.getSheet(sheetName);
		Object [][]data=new Object[Sheet.getLastRowNum()][Sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<Sheet.getLastRowNum();i++){
			for(int k=0; k < Sheet.getRow(0).getLastCellNum();k++){
				data[i][k]=Sheet.getRow(i+k).getCell(k).toString();
			}
		}
		return data;
	}
	
	

}
