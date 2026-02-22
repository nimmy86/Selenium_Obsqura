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
	
@BeforeMethod
public void adminUserLogin() throws IOException {
	String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
	
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernamevalue);
	login.enterPassword(passwordvalue);
	login.enterSubmitbutton();	
	HomePage home = new HomePage(driver);
	home.clickOnMoreInfoMangeNewsPage();
}
@Test
public void verifyUserIsAbleToAddNews() throws IOException {
	ManageNewsPage	managenews = new ManageNewsPage(driver);

	managenews.clickOnNewButton();
	String addNewValueforManageNews=ExcelUtility.getStringData(0, 0, "ManageNewsPage");

	managenews.enterNewsInfo(addNewValueforManageNews);
	managenews.enterSaveButtonAfterEnteringNews();
	boolean alertMsgForManageNews = managenews.isSuccessAlertDisplayed();
	Assert.assertTrue(alertMsgForManageNews, Constants.ERRORMSGFORMANAGENEWSADDITION);
}
@Test
public void verifyUserIsAbleToSearchNews() throws IOException {
	ManageNewsPage	managenews = new ManageNewsPage(driver);

	managenews.clickOnSearchNews();
	String existingNewsValue=ExcelUtility.getStringData(1, 0, "ManageNewsPage");

	managenews.enterNewsToBeSearched(existingNewsValue);
	managenews.clickOnSearchButtonAfterEnteringSearchValues();
}
@Test
public void verifyUserIsAbleToResetNews() {
	ManageNewsPage	managenews = new ManageNewsPage(driver);
	managenews.clickOnResetButton();
}
}
