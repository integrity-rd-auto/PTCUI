package TestUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Test Completed");

	}

	public void onStart(ITestContext arg0) {
		System.out.println("Test suite starts here");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Tests failed but marked as passed");

	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test Failed");
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped");

	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started");

	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test Passed");

	}

}
