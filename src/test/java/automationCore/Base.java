package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
//import constants.Constants;
import utilities.ScreenShotUtility;

public class Base {

	public WebDriver driver;
	Properties prop;
	FileInputStream fs;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserLaunch(String browser) throws Exception {
		prop = new Properties();
		fs = new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs); // --------------------------> method to load the file

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalid Browser");
		}
		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Duration is a pre-defined class class
	}

	@AfterMethod(alwaysRun = true)
	/*
	 * Screenshot methods should be called after @Test Method ITestResult is a
	 * pre-defined Interface that defines the lifecycle of a test case decides
	 * whether the TC is pass or fail. If the result given by ITestResult is
	 * fail,then only SS is needed.
	 */

	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenShotUtility screenShot = new ScreenShotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		 driver.quit();

	}
}
