package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[normalize-space(text())='Admin']")WebElement adminText;
	@FindBy(xpath="//a[@href='#' and @data-toggle='dropdown']") WebElement adminButton;
	@FindBy(xpath="//a[contains(@class,'dropdown-item') and contains(.,'Logout')]")WebElement logoutBtn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboardText;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminUserPagelink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement manageNewslink;
	
	
	
	public void adminUserLogin()
	{
		adminText.click();
		System.out.println("The Text inside HomePage: " +dashboardText.getText());	}
	
	public void logout()
	{	adminButton.click();
		logoutBtn.click();
	}
	
	
	public boolean isLoggedout()
	{
		return driver.getCurrentUrl().contains("login");
	}
	
	public void clickOnMoreInfoAdminUsersPage()
	{
		adminUserPagelink.click();
	}
	
	public void clickOnMoreInfoMangeNewsPage()
	{
		manageNewslink.click();
	}

}
