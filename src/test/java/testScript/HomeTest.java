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
	
	@Test
	public void verifyUserLoginAndLogout() throws IOException {
		
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernamevalue);
		login.enterPassword(passwordvalue);
		login.enterSubmitbutton();
		
		HomePage home = new HomePage(driver);
		home.adminUserLogin();
		home.logout();
		boolean logoutResult = home.isLoggedout();
		Assert.assertTrue(logoutResult, Constants.ERRORMSGFORLOGOUTFAILURE);
		
		System.out.println("Display Result of Logout "+home.isLoggedout()); 

	}
}
