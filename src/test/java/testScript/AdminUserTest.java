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
	@BeforeMethod(description ="This Method is used to Login into the page and Navigate to the Admin Users Page")
	public void adminUserLogin() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernamevalue);
		login.enterPassword(passwordvalue);
		login.enterSubmitbutton();	
		HomePage home = new HomePage(driver);
		home.clickOnMoreInfoAdminUsersPage();
	}

	@Test
	public void verifyIfUserIsAbleToAddNewUsers() {	
		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnNewButton();
		FakerUtility faker = new FakerUtility();
		String newUserName = faker.createRandomUserName();
		String newPassWord = faker.createRandomPassword();
		admin.createNewUsers(newUserName, newPassWord);
		admin.selectUserType(Constants.USERTYPEADMIN);
		admin.clickSave();
		
		boolean alertMsgforUserCreation = admin.isSuccessAlertDisplayed();
		Assert.assertTrue(alertMsgforUserCreation, Constants.ERRORMSGFORNEWUSERCREATION);
	}
	@Test
	public void verifyIfUserIsAbleToSearchExistingUsers () throws IOException {
		String existingUsername=ExcelUtility.getStringData(0, 0, "AdminUserPage");

		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnSearchButton();
		admin.searchForExistingUsers(existingUsername, Constants.USERTYPEADMIN);
	}
	@Test
	public void verifyIfUserIsAbleToResetPage()
	{
		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnResetButton();	
	}

}
