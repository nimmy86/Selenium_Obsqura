package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingWebElements extends Base

{
	public void verifyWebElement()
	{
		//sendkeys -> used to input a value in a textbox. 
		
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement msgbox = driver.findElement(By.id("single-input-field"));
		msgbox.sendKeys("Welcome");
		
		WebElement showmsg = driver.findElement(By.id("button-one"));
		showmsg.click();
				
	}
	public static void main(String[] args)
	
	{
		HandlingWebElements webelements = new HandlingWebElements();
		webelements.browserLaunch();
		webelements.verifyWebElement();
	}

	
}
