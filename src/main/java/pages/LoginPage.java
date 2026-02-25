package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	WaitUtility wait = new WaitUtility(); // Creating Object for the WaitUtility
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameInputField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordInputField;
	@FindBy(xpath = "//button[text() = 'Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardTile;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginPageHeaderTitle;

	public LoginPage enterUsernameValueInUsernameField(String usernameValue) {
		usernameInputField.sendKeys(usernameValue);
		return this;
	}

	public LoginPage enterPasswordValueInPasswordField(String passwordValue) {
		passwordInputField.sendKeys(passwordValue);
		return this;
	}

	public HomePage clickSignInButtonOnLoginPage() {
		wait.waitUntilElementToBeClickable(driver, signInButton);
		signInButton.click();
		return new HomePage(driver);
	}

//chaining of pages not needed in assertion Methods.
	public boolean isDashboardTileDisplayed() {
		try {
			return dashboardTile.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getLoginPageHeaderText() {
		return loginPageHeaderTitle.getText();
	}

}