package utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		// initializing the objects
		htmlReporter = new ExtentSparkReporter("ExtendListenerReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add system info/environment info to reports
		reports.setSystemInfo("Machine", "Laptop");
		reports.setSystemInfo("Os", "Windows_11");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("user_name", "Ayush");
		reports.setSystemInfo("ProjectName", "[EcomSite]V1");
	}

	// called when any Test is executed
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("On Start method invoked.....");
	}

	// called when after all Test are executed
	public void onFinish(ITestContext Result) {
		System.out.println("On Finished method invoked.....");
		reports.flush();// It is mandatory to call flush() to ensure info is written to the started report.
	}

	// When Test case get failed, this method is called.
	// ItestResult call describes the result of a test
	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());// creates entry in html report
		test.log(Status.FAIL,
				// logging the test on entry created
				MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));
		String screenShotPath = System.getProperty("user.dir") + "\\screenShots\\" + Result.getName() + ".png";
		File screenShotFile =  new File(screenShotPath);
		if (screenShotFile.exists()) {
			test.fail("ScreenShot is Captured Below: " + test.addScreenCaptureFromPath(screenShotPath));
		}
		
		
		
	}

	// When Test case get failed, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method skipped: " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is: " + Result.getName(), ExtentColor.YELLOW));
	}

	// When Test case get failed, this method is called.
	public void onTestStart(ITestResult Result) {
		// Not logging this info to report
		System.out.println("Name of test method started: " + Result.getName());
	}

}