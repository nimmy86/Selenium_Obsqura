package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandlingActions extends Base
{
	public void verifyRightClick()
	{
		WebElement others = driver.findElement(By.id("others"));
		Actions action = new Actions(driver); //pass this driver inside the ()
		action.contextClick(others).build().perform(); //pass inside contextClick (web element others)
		
	}
	
	public void verifyMouseHover()
	{
		WebElement others = driver.findElement(By.id("others"));
		Actions action = new Actions(driver); //pass this driver inside the ()
		action.moveToElement(others).build().perform();
	}
	
	public void verifyDragAndDrop()
	{
		driver.navigate().to("https://demoqa.com/droppable");
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver); 
		action.dragAndDrop(drag, drop).build().perform();

	}
	public void verifyKeyboardAction() throws AWTException 
	{ //predefined class Robot for performing keyboard actions.
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}
	 

	public static void main(String[] args) 
	{
		HandlingActions handleaction = new HandlingActions();
		handleaction.browserLaunch();
		//handleaction.verifyRightClick();
		//handleaction.verifyMouseHover();
		//handleaction.verifyDragAndDrop();
		try {
			handleaction.verifyKeyboardAction();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
