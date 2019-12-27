package com.encore.testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Class for Retry Failed TestCases

public class RetryFailedTestCases implements IRetryAnalyzer{
	
    private int retryCnt = 0;
    private int maxRetryCnt = 4;
    /*
     * You could mentioned maxRetryCnt (Maximiun Retry Count) as per your requirement. Here I took 2,
     * If any failed test cases then it runs two times
     * (non-Javadoc)
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     * 
     * This method decides how many times a test needs to be rerun.
     * TestNg will call this method every time a test fails. So we 
     * can put some code in here to decide when to rerun the test.
     * 
     * Note: This method will return true if a tests needs to be retried
     * and false it not.
     *
     */

	@Override
	public boolean retry(ITestResult result) {
		if (retryCnt < maxRetryCnt) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
		return false;
	}

}
