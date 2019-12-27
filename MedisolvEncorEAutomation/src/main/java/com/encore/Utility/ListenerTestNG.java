package com.encore.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener for generate Log 


public class ListenerTestNG implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println(result.getName()+" test case started");					

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    System.out.println("The name of the testcase passed is :"+result.getName());					

	}

	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("The name of the testcase failed is :"+result.getName());					

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	    System.out.println("The name of the testcase Skipped is :"+result.getName());					

		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
