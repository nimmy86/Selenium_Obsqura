package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {

	WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility page = new PageUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addNewUserButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameInputField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordInputField;
	@FindBy(xpath = "//select[@id=\"user_type\"]")
	WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchUserButton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUsernameInputField;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchUserTypeDropdown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
	WebElement searchButtonAfterEnteringSearchCriteria;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement noResultFoundText;

	public AdminUserPage clickAddNewUserButton() {
		wait.waitUntilElementToBeClickable(driver, addNewUserButton);
		addNewUserButton.click();
		return this;

	}

	public AdminUserPage enterNewUserCredentials(String usernameInput, String passwordInput) {
		wait.waitUntilVisibilityOfElement(driver, usernameInputField);
		usernameInputField.clear();
		usernameInputField.sendKeys(usernameInput);
		wait.waitUntilVisibilityOfElement(driver, passwordInputField);
		passwordInputField.clear();
		passwordInputField.sendKeys(passwordInput);
		return this;
	}

	public AdminUserPage selectUserTypeForNewUser(String usertypeValue) {
		/* Calling Dropdown select methods from PageUtility */
		page.selectDropdownByVisibleText(userTypeDropdown, usertypeValue);
		return this;

	}

	public AdminUserPage clickSaveButtonAfterEnteringNewUserDetails() {
		wait.waitUntilElementToBeClickable(driver, saveButton);
		saveButton.click();
		return this;
	}

	public boolean isSuccessAlertMessageDisplayed() {
		wait.waitUntilVisibilityOfElement(driver, successAlertMessage);
		return successAlertMessage.isDisplayed();
	}

	public AdminUserPage clickSearchUserButton() {
		searchUserButton.click();
		return this;
	}

	public AdminUserPage searchUserByUsernameAndType(String searchUserNameValueInput, String searchUserTypeInput) {
		searchUsernameInputField.sendKeys(searchUserNameValueInput);

		page.selectDropdownByVisibleText(searchUserTypeDropdown, searchUserTypeInput);
		searchButtonAfterEnteringSearchCriteria.click();
		return this;
	}

	public AdminUserPage clickResetButton() {
		wait.waitUntilElementToBeClickable(driver, resetButton);
		resetButton.click();
		return this;
	}

	public boolean isNoResultMessageDisplayed() {
		try {
			return noResultFoundText.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
