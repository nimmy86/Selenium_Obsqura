package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingFileUpload extends Base {
	
	public void verifyFileUploadUsingSendKeys() {
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement uploadButton = driver.findElement(By.id("uploadfile_0"));
		uploadButton.sendKeys("C:\\Users\\Admin\\git\\repository\\selenium-basics\\src\\test\\resources\\satellites - Copy.jpeg");
		WebElement terms = driver.findElement(By.id("terms"));
		terms.click();
		WebElement submitbtn = driver.findElement(By.id("submitbutton"));
		submitbtn.click();
	}
	
	public void verifyFileUploadUsingRobot() throws AWTException {
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");	
		WebElement uploadpdfbtn = driver.findElement(By.id("pickfiles"));
		uploadpdfbtn.click();
		StringSelection select = new StringSelection("C:\\Users\\Admin\\git\\repository\\selenium-basics\\src\\test\\resources\\Neethu Nich- DXB CV (2).pdf");
		Robot r=new Robot();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		r.delay(2500); //delay is a method of robot class.
		r.keyPress(KeyEvent.VK_ENTER); //for the cursor to come to the select area text box. 
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_CONTROL); // value stored in the clipboard will be paste here.
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		}

	public static void main(String[] args) {
		HandlingFileUpload file = new HandlingFileUpload();
		file.browserLaunch();
		//file.verifyFileUploadUsingSendKeys();
		try {
			file.verifyFileUploadUsingRobot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
