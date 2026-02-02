package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableHandling extends Base
{	
	
	public void verifyTable()
	
	{
		driver.navigate().to("https://money.rediff.com/indices/nse");
		WebElement fulltable = driver.findElement(By.id("dataTable"));
		//System.out.println(fulltable.getText());
		WebElement tablerow = driver.findElement(By.xpath("//table[@id='dataTable']//tbody//tr[2]"));
		System.out.println(tablerow.getText());
		
	}

	public static void main(String[] args) 
	{
		TableHandling table = new TableHandling();
		table.browserLaunch();
		table.verifyTable();
	}

}
