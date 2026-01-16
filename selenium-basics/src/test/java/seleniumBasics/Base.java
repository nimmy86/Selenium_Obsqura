package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

public WebDriver driver; //global declaration
//WebDriver -> Interface..
public void browserLaunch()
	{
	//Need to use browser class to launch the browsers... 
	driver = new ChromeDriver(); //No need to write WebDriver driver since we have globally declared it... 
	driver.get("https://selenium.qabible.in/"); //give the url to launch in the get method.
	//At a time only one url. We can use navigation commands to go to other windows. 
	driver.manage().window().maximize(); //command to maximize the screen...
	}
public void browserCloseQuit()
{
	
	//driver.close(); -> To close only one browser/window
	driver.quit(); // For Multiple
}

	public static void main(String[] args) 
	{
		Base base = new Base();
		base.browserLaunch();
		base.browserCloseQuit();
	}

}
