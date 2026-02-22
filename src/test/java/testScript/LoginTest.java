package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
@Test(priority=1,description="Validating User Login With Valid Credentials",groups = {"smoke"})
public void verifyValidUserNameAndValidPassword() throws IOException {
	String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernamevalue);
	login.enterPassword(passwordvalue);
	login.enterSubmitbutton();
	boolean dashboardDisplay = login.isDashboardDisplayed();
	Assert.assertTrue(dashboardDisplay, Constants.INVALIDCREDENTIALERROR); //if fail then the msg to be displayed in second parameter.
	}

@Test(priority=2,description="Validating User Login with Valid Username and Invalid Password")
public void verifyValidUserNameAndInValidPassword() throws IOException {
	String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernamevalue);
	login.enterPassword(passwordvalue);
	login.enterSubmitbutton();
	boolean dashboardVisible = login.isDashboardDisplayed();
	System.out.println("Dashboard visible? " + dashboardVisible);

	Assert.assertFalse(dashboardVisible, Constants.ERRORMESSAGEFORLOGIN);

	}

@Test(priority=3,description="Validating User Login with Invalid Username and Valid Password")
public void verifyInValidUserNameAndValidPassword() throws IOException {
	String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(2, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernamevalue);
	login.enterPassword(passwordvalue);
	login.enterSubmitbutton();
	String expectedText = "7rmart supermarket";
	String actual = login.getLoginText();
	Assert.assertEquals(actual, expectedText, Constants.ERRORMESSAGEFORINVALIDLOGIN);

	}
@Test(priority=4,description="Validating User Login with Invalid Username and Invalid Password", dataProvider = "loginProvider")
public void verifyInValidUserNameAndInValidPassword(String usernamevalue, String passwordvalue) throws IOException {
	//String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
	//String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernamevalue);
	login.enterPassword(passwordvalue);
	login.enterSubmitbutton();
	String expectedText = "7rmart supermarket";
	String actual = login.getLoginText();
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
