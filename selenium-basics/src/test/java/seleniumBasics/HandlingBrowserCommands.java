package seleniumBasics;

public class HandlingBrowserCommands extends Base
{
	public void verifyBrowserCommands()
	{
		String title = driver.getTitle();
		System.out.println(title);
		//To get the current url...
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//to get the current url
		
		String id = driver.getWindowHandle();
		System.out.println(id);
		//handle multiple windows
		
		String source = driver.getPageSource();
		System.out.println(source);
	}
	
	public void verifyNavigationCommands()
	{
		driver.navigate().to("https://www.flipkart.com/");
		driver.navigate().back(); //Back to Obsqura
		driver.navigate().forward(); // back to flipkart
		driver.navigate().refresh(); // to refresh
		
		}
	

	public static void main(String[] args) 
	{
		HandlingBrowserCommands browser = new HandlingBrowserCommands();
		browser.browserLaunch();
		//browser.verifyBrowserCommands();
		browser.verifyNavigationCommands();
	}

}
