package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home; //ref variable
	@Test(priority = 1, description = "Validating User Login With Valid Credentials", groups = { "smoke" })
	public void verifyValidUserNameWithValidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernameValue).enterPasswordValueInPasswordField(passwordValue); //driver control is still in login page
		home=login.clickSignInButtonOnLoginPage(); //control goes to login page
		boolean dashboardDisplay = login.isDashboardTileDisplayed();
		Assert.assertTrue(dashboardDisplay, Constants.INVALIDCREDENTIALERROR); // if fail then the msg to be displayed
																				// in 2nd parameter
	}

	@Test(priority = 2, description = "Validating User Login with Valid Username and Invalid Password")
	public void verifyValidUserNameWithInValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue);
		login.enterPasswordValueInPasswordField(passwordvalue);
		login.clickSignInButtonOnLoginPage();
		boolean dashboardVisible = login.isDashboardTileDisplayed();
		// System.out.println("Dashboard visible? " + dashboardVisible);
		Assert.assertFalse(dashboardVisible, Constants.ERRORMESSAGEFORLOGIN);
	}

	@Test(priority = 3, description = "Validating User Login with Invalid Username and Valid Password")
	public void verifyInValidUserNameWithdValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue).clickSignInButtonOnLoginPage();
		//invalid creds, so control won't go to next page
		String expectedText = "7rmart supermarket";
		String actual = login.getLoginPageHeaderText();
		Assert.assertEquals(actual, expectedText, Constants.ERRORMESSAGEFORINVALIDLOGIN);

	}

	@Test(priority = 4, description = "Validating User Login with Invalid Username and Invalid Password", dataProvider = "loginProvider")
	public void verifyInValidUserNameWithInValidPassword(String usernamevalue, String passwordvalue)
			throws IOException {
		// String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
		// String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue).clickSignInButtonOnLoginPage();
		String expectedText = "7rmart supermarket";
		String actual = login.getLoginPageHeaderText();
		Assert.assertEquals(actual, expectedText, Constants.ERRORMESSAGEFORINVALIDLOGIN);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
