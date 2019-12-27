package com.encore.testcases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;

//Class for Retry Failed TestCases using IAnnotationTransformer
public class RetryListenerClass implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass,Constructor testConstructor, Method testMethod) 
	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();
		if (retry == null)	
		{
			testannotation.setRetryAnalyzer(com.encore.testcases.RetryFailedTestCases.class);
		}
		
	}

}
