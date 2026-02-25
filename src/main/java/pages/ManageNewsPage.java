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
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newNewsButton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement newsContentTextArea;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveNewsButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchNewsButton;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement searchNewsTitleInputField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchNewsSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement noSearchResultText;

	public ManageNewsPage clickAddNewNewsButton() {
		wait.waitUntilElementToBeClickable(driver, newNewsButton);
		newNewsButton.click();
		return this;
	}

	public ManageNewsPage enterNewsContent(String newsTextValue) {
		newsContentTextArea.sendKeys(newsTextValue);
		return this;
	}

	public ManageNewsPage clickSaveNewsButton() {
		wait.waitUntilElementToBeClickable(driver, saveNewsButton);
		saveNewsButton.click();
		return this;
	}

	public boolean isSuccessAlertMessageDisplayed() {
		return successAlertMessage.isDisplayed();
	}

	public ManageNewsPage clickSearchNewsButton() {
		wait.waitUntilElementToBeClickable(driver, searchNewsButton);
		searchNewsButton.click();
		return this;
	}

	public ManageNewsPage enterNewsTitleToSearch(String newsTextValueToSearch) {
		searchNewsTitleInputField.sendKeys(newsTextValueToSearch);
		return this;
	}

	public ManageNewsPage clickSearchButtonAfterEnteringNews() {
		searchNewsSubmitButton.click();
		return this;
	}

	public ManageNewsPage clickResetButton() {
		wait.waitUntilElementToBeClickable(driver, resetButton);
		resetButton.click();
		return this;
	}

	public boolean isNoSearchResultMessageDisplayed() {
		try {
			return noSearchResultText.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
