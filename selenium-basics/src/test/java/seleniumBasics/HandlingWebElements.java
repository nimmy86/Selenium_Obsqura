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
		msgbox.sendKeys("Welcome"); //to input value
		
		WebElement showmsg = driver.findElement(By.id("button-one"));
		showmsg.click();
		
		WebElement displaymsg = driver.findElement(By.id("message-one"));
		System.out.println(displaymsg.getText()); //to fetch a text from the webpage
		
		msgbox.clear(); //to clear the value added in msgbox text field. 
		
		System.out.println(showmsg.getTagName()); // to get the Tag Name of the showmsg button.
		
				
	}
	public static void main(String[] args)
	
	{
		HandlingWebElements webelements = new HandlingWebElements();
		webelements.browserLaunch();
		webelements.verifyWebElement();
	}

	
}
