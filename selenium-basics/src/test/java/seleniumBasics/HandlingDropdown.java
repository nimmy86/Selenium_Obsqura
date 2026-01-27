package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown extends Base 
{

public void verifyDropdown()
{
	driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
	
	WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
	
	//To create object for predefined class 
	
	Select select = new Select(dropdown); //give the WebElement's name inside ()
	//select.selectByIndex(2); //To select a dropdown using index value
	
	//select.selectByValue("c#"); //to select using value of the attribute. 
	
	select.selectByVisibleText("SQL"); //to select using the display text.
}


public void verifyCheckBox()
{
	driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

	WebElement checkbox = driver.findElement(By.xpath("//input[@value='option-2']"));
	checkbox.click();
	checkbox.click(); //click again to de-select

}

public void verifyRadioButton()
{
driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

WebElement radio = driver.findElement(By.xpath("//input[@value='blue']"));
radio.click();
}
	public static void main(String[] args) 
	
	{
		HandlingDropdown drop = new HandlingDropdown();
		drop.browserLaunch();
		//drop.verifyDropdown();
		//drop.verifyCheckBox();
		drop.verifyRadioButton();
	}

}
