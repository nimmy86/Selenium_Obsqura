package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//study click method with the help of JS Executor Interface.
public class JSExecutor extends Base {
	
	public void verifyJSExecutor() {
		
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement txtbox = driver.findElement(By.id("single-input-field"));
		txtbox.sendKeys("Nimmy");
		WebElement showbtn = driver.findElement(By.id("button-one"));
		JavascriptExecutor js = (JavascriptExecutor)driver; //casting the control from entire page to the interface.
		js.executeScript("arguments[0].click();", showbtn);
		js.executeScript("window.scrollBy(0,350)", ""); //to scroll up -ve value.. to scroll down +ve value
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public static void main(String[] args) {
		
		JSExecutor js = new JSExecutor();
		js.browserLaunch();
		js.verifyJSExecutor();
		

	}

}
