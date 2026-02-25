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

	@Test(description = "This Method is used to Add New Users in the Admin User Page")
	public void verifyIfUserIsAbleToAddNewUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue);
		login.enterPasswordValueInPasswordField(passwordvalue);
		login.clickSignInButtonOnLoginPage();
		HomePage home = new HomePage(driver);
		home.clickOnMoreInfoAdminUsersPage();
		
		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickAddNewUserButton();
		FakerUtility faker = new FakerUtility();
		String newUserName = faker.createRandomUserName();
		String newPassWord = faker.createRandomPassword();
		admin.enterNewUserCredentials(newUserName, newPassWord);
		admin.selectUserTypeForNewUser(Constants.USERTYPEADMIN);
		admin.clickSaveButtonAfterEnteringNewUserDetails();

		boolean alertMsgforUserCreation = admin.isSuccessAlertMessageDisplayed();
		Assert.assertTrue(alertMsgforUserCreation, Constants.ERRORMSGFORNEWUSERCREATION);
	}

	@Test(description = "This Method is used to search for exisiting users in the Admin User Page")
	public void verifyIfUserIsAbleToSearchExistingUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue);
		login.enterPasswordValueInPasswordField(passwordvalue);
		login.clickSignInButtonOnLoginPage();
		HomePage home = new HomePage(driver);
		home.clickOnMoreInfoAdminUsersPage();
		
		String existingUsername = ExcelUtility.getStringData(0, 0, "AdminUserPage");

		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickSearchUserButton();
		admin.searchUserByUsernameAndType(existingUsername, Constants.USERTYPEADMIN);

		Assert.assertFalse(admin.isNoResultMessageDisplayed(), Constants.NOSEARCHRESULTFOUNDMSG);
	}

	@Test(description = "This Method is used to Reset the Admin User Page")
	public void verifyIfUserIsAbleToResetPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameValueInUsernameField(usernamevalue);
		login.enterPasswordValueInPasswordField(passwordvalue);
		login.clickSignInButtonOnLoginPage();
		HomePage home = new HomePage(driver);
		home.clickOnMoreInfoAdminUsersPage();
		
		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickResetButton();
		Assert.assertFalse(admin.isNoResultMessageDisplayed(), Constants.ERRORMESSAGEFORRESETFAIL

		);

	}

}
