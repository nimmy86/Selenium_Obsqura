package seleniumBasics;

import org.openqa.selenium.By;

public class Locators extends Base {
	
	
public void verifyLocators()
{
	
	driver.findElement(By.id("button-one"));
	driver.findElement(By.className("btn btn-primary"));
	driver.findElement(By.tagName("button"));
	driver.findElement(By.name("viewport"));
	driver.findElement(By.linkText("Simple Form Demo"));
	driver.findElement(By.partialLinkText("Simple"));
	driver.findElement(By.cssSelector("button[id='button-one']"));
	driver.findElement(By.xpath("//button[@id='button-one']")); //Locate using attribute
	driver.findElement(By.xpath("//button[text()='Show Message']")); //Locate using text
	driver.findElement(By.xpath(" //button[@id='button-one' and @type='button']")); //using and operator
	driver.findElement(By.xpath(" //button[@id='button-one' or @type='superbutton']")); //using or operator - any one condition need to be satisfied.
	// //div[contains (text(), 'Single Input Field')]/.. -> to identify the parent of the previously located element  /.. 
	
	//xpath access method 
	//parent 
	driver.findElement(By.xpath("//div[contains(text(), 'Single Input Field')]//parent::div[@class='card']"));
	
	//child
	driver.findElement(By.xpath("//div[@class='card']//child::button[@id='button-one']"));
	
	//following 
	driver.findElement(By.xpath(" //button[@id='button-one']//following::div[@class='card']")); 
	
	
	//preceeding 
	driver.findElement(By.xpath("//button[@id='button-one']//preceding:: div[@class='card']"));
	
	driver.findElement(By.xpath("//button[@id='button-one']//ancestor::div"));
	
	driver.findElement(By.xpath("//div[@class='card']//descendant::div"));
}


/* /html/body/section/div/div/div[2]/div[1]/div/div[2]/form/button */
	public static void main(String[] args) 
	{
		Locators locators = new Locators(); 
		locators.browserLaunch();
		locators.verifyLocators();
	}

}
