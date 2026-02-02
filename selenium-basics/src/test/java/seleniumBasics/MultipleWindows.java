package seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MultipleWindows extends Base {
	
	public void verifyMultipleWindow() {
		
		driver.navigate().to("https://demo.guru99.com/popup.php");
		String parentwindow = driver.getWindowHandle(); //fetch the window handle of parent page.
		System.out.println(parentwindow); //only if we need to view 
		WebElement clickbtn = driver.findElement(By.xpath("//a[text() = 'Click Here']"));
		clickbtn.click();
		//to store the multiple handle id use sets 
		Set <String> handleids = driver.getWindowHandles();
		System.out.println(handleids);
		
		Iterator<String> it = handleids.iterator();
		while(it.hasNext()) //to go to the next element (hasNext)
		{	
			String currentid = it.next(); //store the id to another variable. 
			if(!currentid.equals(parentwindow)) //if parent & currentid are different, then only perform the below
			{
				driver.switchTo().window(currentid);
				WebElement name = driver.findElement(By.name("emailid"));
				name.sendKeys("nimmy205@gmail.com");
				WebElement submitbtn = driver.findElement(By.name("btnLogin"));
				submitbtn.click();
				
			}
			
		}
		
	}


	public static void main(String[] args) {
		
		MultipleWindows multiwindow = new MultipleWindows();
		multiwindow.browserLaunch();
		multiwindow.verifyMultipleWindow();

	}

}
