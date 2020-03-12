package TestUtility;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Base.TestBase;

public class ExtentListener implements ITestListener  {
	
	Logger logger = Logger.getLogger(ExtentListener.class);

	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onFinish(ITestContext arg0) {
		// extent.flush();
		//Reporter.log(arg0.getName() + " Test Finished..");
		logger.info(arg0.getName() + " Test Finished");
	}

	public void onStart(ITestContext arg0) {

		//Reporter.log(arg0.getCurrentXmlTest().getName() + " Class Started..");
		logger.info(arg0.getCurrentXmlTest().getName() + " Class Started..");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		// test.log(Status.FAIL, arg0.getThrowable());
		//Reporter.log(arg0.getMethod().getMethodName() + " Test Failed.." + arg0.getThrowable());
		logger.error(arg0.getMethod().getMethodName() + " Test Failed.." + arg0.getThrowable());

		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// test.log(Status.SKIP, arg0.getThrowable());
		//Reporter.log(arg0.getMethod().getMethodName() + " Test Skipped.." + arg0.getThrowable());
		logger.warn(arg0.getMethod().getMethodName() + " Test Skipped.." + arg0.getThrowable());
	}

	public void onTestStart(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName()+" started..");
		Reporter.log(arg0.getMethod().getMethodName() + " Test Started..");
		logger.info(arg0.getMethod().getMethodName() + " Test Started..");
	}

	public void onTestSuccess(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName()+" Passed..");
		//Reporter.log(arg0.getMethod().getMethodName() + " Test Passed..");
		logger.info(arg0.getMethod().getMethodName() + " Test Passed..");
	}

}
