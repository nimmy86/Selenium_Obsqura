package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;

	@Test(description = "Verify user login and logout functionality", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginAndLogout() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue);
		home=login.clickSignInButtonOnLoginPage();

		//HomePage home = new HomePage(driver);
		home.clickOnHomeButtonOnHomePage();
		login=home.clickLogoutOptionOnHomePage();
		boolean logoutResult = home.isRedirectedToLoginPage();
		Assert.assertTrue(logoutResult, Constants.ERRORMSGFORLOGOUTFAILURE);

	}
}
