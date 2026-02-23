package seleniumBasics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWebElements extends Base

{
	public void verifyWebElement()
	{
		//sendkeys -> used to input a value in a textbox. 
		
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement msgbox = driver.findElement(By.id("single-input-field"));
		msgbox.sendKeys("Welcome"); //to input value
		
		WebElement showmsg = driver.findElement(By.id("button-one"));
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(showmsg));
		//Fluent Wait
		Wait <WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
		.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(showmsg));

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
