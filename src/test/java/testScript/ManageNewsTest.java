package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	HomePage home;
	ManageNewsPage managenews;

	@Test(description = "Verify user can add news successfully")
	public void verifyUserIsAbleToAddNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue);
		home = login.clickSignInButtonOnLoginPage();
		// HomePage home = new HomePage(driver);
		managenews = home.clickOnMoreInfoMangeNewsPage();

		// ManageNewsPage managenews = new ManageNewsPage(driver);

		managenews.clickAddNewNewsButton();
		String addNewValueforManageNews = ExcelUtility.getStringData(0, 0, "ManageNewsPage");

		managenews.enterNewsContent(addNewValueforManageNews).clickSaveNewsButton();
		boolean alertMsgForManageNews = managenews.isSuccessAlertMessageDisplayed();
		Assert.assertTrue(alertMsgForManageNews, Constants.ERRORMSGFORMANAGENEWSADDITION);
	}

	@Test(description = "Verify user can search existing news")
	public void verifyUserIsAbleToSearchNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue);
		home = login.clickSignInButtonOnLoginPage();
		// HomePage home = new HomePage(driver);
		managenews = home.clickOnMoreInfoMangeNewsPage();

		// ManageNewsPage managenews = new ManageNewsPage(driver);

		managenews.clickSearchNewsButton();
		String existingNewsValue = ExcelUtility.getStringData(1, 0, "ManageNewsPage");

		managenews.enterNewsTitleToSearch(existingNewsValue).clickSearchButtonAfterEnteringNews();
		Assert.assertFalse(managenews.isNoSearchResultMessageDisplayed(), Constants.NOSEARCHRESULTFOUNDMSG);
	}

	@Test(description = "Verify user can reset news search results")
	public void verifyUserIsAbleToResetNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue);
		home = login.clickSignInButtonOnLoginPage();
		// HomePage home = new HomePage(driver);
		managenews = home.clickOnMoreInfoMangeNewsPage();

		// ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickResetButton();
		Assert.assertFalse(managenews.isNoSearchResultMessageDisplayed(), Constants.ERRORMESSAGEFORRESETFAIL);
	}
}
