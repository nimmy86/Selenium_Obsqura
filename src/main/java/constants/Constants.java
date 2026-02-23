package constants;

public class Constants {
	public static final String TESTDATAFILE = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties\\";
	public static final String INVALIDCREDENTIALERROR = "User was unable to login with valid credentials";
	public static final String ERRORMESSAGEFORLOGIN = "Dashboard should NOT be visible for invalid login";
	public static final String ERRORMESSAGEFORINVALIDLOGIN = "User was able to login with Invalid password";
	public static final String EXISTINGUSER = "Amanda";
	public static final String USERTYPEADMIN = "Admin";
	public static final String ERRORMSGFORNEWUSERCREATION = "User Creation Failed as this user already exists";
	public static final String MANAGENEWSMESSAGE = "This is a test data to add in the Manage News Page";
	public static final String MANAGENEWSEXISTINGMESSAGE = "Repellendus natus nisi labore.";
	public static final String ERRORMSGFORMANAGENEWSADDITION = "Failed to create new News";
	public static final String ERRORMSGFORLOGOUTFAILURE = "Logout not successful";
	public static final String NOSEARCHRESULTFOUNDMSG = "No search results displayed";
	public static final String ERRORMESSAGEFORRESETFAIL = "Reset failed: 'RESULT NOT FOUND' message is still displayed";
	

}
