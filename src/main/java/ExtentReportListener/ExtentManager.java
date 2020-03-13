package ExtentReportListener;

import org.testng.IReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager implements IReporter {
	
private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		if(extent == null){
			String location = ("F:\\workspace\\PageObjectModelBasics\\com.PTC.uiFramework\\test-output\\Extent.html");
			return createInstance(location);
		}
		else{
			return extent;
		}
	}
	
	public static ExtentReports createInstance(String fileName){
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

}

