package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {

	WebDriver driver;
	WaitUtility wait = new WaitUtility();

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']")
	WebElement homeButton;
	@FindBy(xpath = "//a[@href='#' and @data-toggle='dropdown']")
	WebElement adminButton;
	@FindBy(xpath = "//a[contains(@class,'dropdown-item') and contains(.,'Logout')]")
	WebElement logoutBtn;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminUserPagelink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement manageNewslink;

	public HomePage clickOnHomeButtonOnHomePage() {
		wait.waitUntilElementToBeClickable(driver, homeButton);
		homeButton.click();
		return this;
	}

	public LoginPage clickLogoutOptionOnHomePage() {
		adminButton.click();

		wait.waitUntilElementToBeClickable(driver, logoutBtn);
		logoutBtn.click();
		return new LoginPage(driver);
	}

	public boolean isRedirectedToLoginPage() {
		return driver.getCurrentUrl().contains("login");
	}

	public AdminUserPage clickOnMoreInfoAdminUsersPage() {
		adminUserPagelink.click();
		return new AdminUserPage(driver);
	}

	public ManageNewsPage clickOnMoreInfoMangeNewsPage() {
		manageNewslink.click();
		return new ManageNewsPage(driver);
	}

}
