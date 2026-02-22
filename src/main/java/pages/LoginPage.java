package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	WaitUtility wait = new WaitUtility(); //Creating Object for the WaitUtility 
	public WebDriver driver;


public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//input[@placeholder='Username']")WebElement username;
@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
@FindBy(xpath= "//button[text() = 'Sign In']")WebElement signInbtn;
@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboardTile;
@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginText; 

public void enterUserName(String usernamevalue) {
	username.sendKeys(usernamevalue);
}
public void enterPassword(String passwordvalue) {
	password.sendKeys(passwordvalue);
}

public void enterSubmitbutton() { 	
	wait.waitUntilElementToBeClickable(driver, signInbtn); 
	signInbtn.click();
}

public boolean isDashboardDisplayed() {
    try {
        return dashboardTile.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}


public String getLoginText() {
	return loginText.getText();
			}


}