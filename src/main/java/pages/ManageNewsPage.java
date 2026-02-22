package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	WebDriver driver;
	WaitUtility wait = new WaitUtility();
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement newButton;
@FindBy(xpath = "//textarea[@placeholder='Enter the news']") WebElement newsTextField;
@FindBy(xpath = "//button[@class='btn btn-danger']") WebElement saveButton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successAlertMsg;
@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchButton;
@FindBy(xpath = "//input[@placeholder='Title']") WebElement searchTextField;
@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchNewsButton;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetButton;

public void clickOnNewButton() {
	wait.waitUntilElementToBeClickable(driver, newButton);
	newButton.click();
}
public void enterNewsInfo(String newsTextValue) {
	wait.waitUntilVisibilityOfElement(driver, newsTextField);
	newsTextField.sendKeys(newsTextValue);
}
public void enterSaveButtonAfterEnteringNews() {
	wait.waitUntilElementToBeClickable(driver, saveButton);
	saveButton.click();
}

public boolean isSuccessAlertDisplayed() {
	return successAlertMsg.isDisplayed();
}
public void clickOnSearchNews() {
	wait.waitUntilElementToBeClickable(driver, searchButton);
	searchButton.click();
}
public void enterNewsToBeSearched(String newsTextValueToSearch) {
	wait.waitUntilVisibilityOfElement(driver, searchTextField);
	searchTextField.sendKeys(newsTextValueToSearch);
}
public void clickOnSearchButtonAfterEnteringSearchValues() {
	wait.waitUntilElementToBeClickable(driver, searchNewsButton);
	searchNewsButton.click();
}
public void clickOnResetButton() {
	wait.waitUntilElementToBeClickable(driver, resetButton);
	resetButton.click();
}
}
