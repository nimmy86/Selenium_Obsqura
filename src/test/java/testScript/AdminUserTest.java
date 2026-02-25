package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	HomePage home;
	AdminUserPage admin;

	@Test(description = "This Method is used to Add New Users in the Admin User Page")
	public void verifyIfUserIsAbleToAddNewUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue);
		home = login.clickSignInButtonOnLoginPage();
		// HomePage home = new HomePage(driver);
		admin = home.clickOnMoreInfoAdminUsersPage();

		// AdminUserPage admin = new AdminUserPage(driver);
		admin.clickAddNewUserButton();
		FakerUtility faker = new FakerUtility();
		String newUserName = faker.createRandomUserName();
		String newPassWord = faker.createRandomPassword();

		// change & chain
		admin.enterNewUserCredentials(newUserName, newPassWord).selectUserTypeForNewUser(Constants.USERTYPEADMIN)
				.clickSaveButtonAfterEnteringNewUserDetails();

		boolean alertMsgforUserCreation = admin.isSuccessAlertMessageDisplayed();
		Assert.assertTrue(alertMsgforUserCreation, Constants.ERRORMSGFORNEWUSERCREATION);
	}

	@Test(description = "This Method is used to search for exisiting users in the Admin User Page")
	public void verifyIfUserIsAbleToSearchExistingUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue);
		home = login.clickSignInButtonOnLoginPage();
		// HomePage home = new HomePage(driver);
		admin = home.clickOnMoreInfoAdminUsersPage();

		String existingUsername = ExcelUtility.getStringData(0, 0, "AdminUserPage");

		// AdminUserPage admin = new AdminUserPage(driver);
		admin.clickSearchUserButton().searchUserByUsernameAndType(existingUsername, Constants.USERTYPEADMIN);

		Assert.assertFalse(admin.isNoResultMessageDisplayed(), Constants.NOSEARCHRESULTFOUNDMSG);
	}

	@Test(description = "This Method is used to Reset the Admin User Page")
	public void verifyIfUserIsAbleToResetPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue).enterPasswordValueInPasswordField(passwordvalue);
		home = login.clickSignInButtonOnLoginPage();
		// HomePage home = new HomePage(driver);
		admin = home.clickOnMoreInfoAdminUsersPage();

		// AdminUserPage admin = new AdminUserPage(driver);
		admin.clickResetButton();
		Assert.assertFalse(admin.isNoResultMessageDisplayed(), Constants.ERRORMESSAGEFORRESETFAIL

		);

	}

}
