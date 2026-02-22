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
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath= "//input[@id='username']") WebElement userNameValue;
	@FindBy(xpath= "//input[@id='password']") WebElement passwordValue;
	@FindBy(xpath= "//select[@id=\"user_type\"]") WebElement userSelectDrpdwn;
	@FindBy(xpath= "//button[@class='btn btn-block-sm btn-danger' and @name='Create']") WebElement saveBtn;
	@FindBy(xpath= "//div[@class='alert alert-success alert-dismissible']") WebElement alertDisplayed;
	@FindBy(xpath= "//a[@onclick='click_button(2)']") WebElement searchBtn;
	@FindBy(xpath= "//input[@id='un']") WebElement searchUserNameValue;
	@FindBy(xpath = "//select[@id='ut']") WebElement searchUserType;
	@FindBy(xpath= "//button[@class='btn btn-block-sm btn-danger' and @name='Search']") WebElement searchButtonAfterInputs;
	@FindBy(xpath= "//a[@class='btn btn-rounded btn-warning']") WebElement resetButton;
	
	public void clickOnNewButton() {
		wait.waitUntilElementToBeClickable(driver, newButton);
		newButton.click();
		
	}
	public void createNewUsers(String usernameInput, String passwordInput) { 
		wait.waitUntilVisibilityOfElement(driver, userNameValue);
		userNameValue.clear();
		userNameValue.sendKeys(usernameInput);
		wait.waitUntilVisibilityOfElement(driver, passwordValue);
		passwordValue.clear();
		passwordValue.sendKeys(passwordInput);
	}
	public void selectUserType(String usertypeValue) {
		wait.waitUntilVisibilityOfElement(driver, userSelectDrpdwn);
		/*Calling Dropdown select methods from PageUtility */
		page.selectDropdownByVisibleText(userSelectDrpdwn, usertypeValue); 
		/*Select select = new Select(userSelectDrpdwn);
		select.selectByVisibleText(usertypeValue);*/
	}
	public void clickSave() {
		wait.waitUntilElementToBeClickable(driver, saveBtn);
		saveBtn.click();
	}
	
	public boolean isSuccessAlertDisplayed() {
		wait.waitUntilVisibilityOfElement(driver, alertDisplayed);
		return alertDisplayed.isDisplayed();		
	}
	
	public void clickOnSearchButton() {
		wait.waitUntilElementToBeClickable(driver, searchBtn);
		searchBtn.click();
	}
	
	public void searchForExistingUsers(String searchUserNameValueInput, String searchUserTypeInput) {
		wait.waitUntilVisibilityOfElement(driver, searchUserNameValue);
		searchUserNameValue.sendKeys(searchUserNameValueInput);
		wait.waitUntilVisibilityOfElement(driver, searchUserType);
		/*Select select = new Select(searchUserType);
		 select.selectByVisibleText(searchUserTypeInput); */
		page.selectDropdownByVisibleText(searchUserType, searchUserTypeInput);
		wait.waitUntilVisibilityOfElement(driver, searchButtonAfterInputs);
		searchButtonAfterInputs.click();
	}
	
	public void clickOnResetButton() {
		wait.waitUntilElementToBeClickable(driver, resetButton);
		resetButton.click();
	}
}
