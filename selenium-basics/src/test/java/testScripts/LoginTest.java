package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumBasics.TestNGBase;

public class LoginTest extends TestNGBase {
	@Test
	public void verifyUserLoginWithValidCredentials() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement submitbtn = driver.findElement(By.id("login-button"));
		submitbtn.click();
	}
	@Test
	public void verifyUserLoginValidUserNameInvalidPassword()
	{
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("abcdee");
		WebElement submitbtn = driver.findElement(By.id("login-button"));
		submitbtn.click();
	}
	@Test
	public void verifyUserLoginInvalidUserNameValidPassword() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("maker");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement submitbtn = driver.findElement(By.id("login-button"));
		submitbtn.click();
	}
	@Test
		public void verifyUserWithInvalidCredentials() {
			WebElement username = driver.findElement(By.id("user-name"));
			username.sendKeys("maker-4");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("password");
			WebElement submitbtn = driver.findElement(By.id("login-button"));
			submitbtn.click();
		}
	}
	


