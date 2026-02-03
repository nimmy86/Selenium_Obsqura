package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void browserLaunch()
	{
	driver = new ChromeDriver(); 
	driver.get("https://www.saucedemo.com/"); 

	driver.manage().window().maximize(); 
	}
	/*@AfterMethod
	public void browserCloseQuit()
	{
		driver.quit(); 
	}*/

}
//each page needs each test class eg login page one test case