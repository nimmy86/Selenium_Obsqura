package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingAlerts extends Base 
{
public void verifySimpleAlerts()
{	 driver.navigate().to("https://demoqa.com/alerts");

	WebElement alertbtn = driver.findElement(By.id("alertButton"));
	alertbtn.click();	
	
//To switch the control from entire webpage to the alert only. 
// creating ref variable for Alert interface
	Alert alert = driver.switchTo().alert();
	alert.accept();
}

public void verifyConfirmAlert()
{
	 driver.navigate().to("https://demoqa.com/alerts");
		WebElement confirmbtn = driver.findElement(By.id("confirmButton"));
		confirmbtn.click();
		Alert alert = driver.switchTo().alert();
		//alert.accept();
		alert.dismiss();
}

public void verifyPromptAlert()
{	driver.navigate().to("https://demoqa.com/alerts");
	WebElement prmptbtn = driver.findElement(By.id("promtButton"));
	prmptbtn.click();
	Alert alert = driver.switchTo().alert();
	alert.sendKeys("Nimmy");
	alert.accept();
	
}

	public static void main(String[] args) 
	{
		HandlingAlerts alerts = new HandlingAlerts();
		alerts.browserLaunch();
		//alerts.verifySimpleAlerts();
		alerts.verifyConfirmAlert();
		alerts.verifyPromptAlert();
	}

}
