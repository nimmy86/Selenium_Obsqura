package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
																			// be shared accross the application

	public synchronized static ExtentReports createExtentReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		// create a folder extend-report,and the file format is mentioned here
		reporter.config().setReportName("7RMartSupermarketProject"); // Report's Name
		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Nimmy"); // provides context of the report
		return extentReports;

	}

}
