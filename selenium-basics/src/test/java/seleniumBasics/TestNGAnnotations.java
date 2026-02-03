package seleniumBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	@Test    //only we can execute @Test... @Beforetest @After and all will be executed automatically.
	public void sampleTestCase() {
		
		System.out.println("This is a sample test");
	}
	@BeforeMethod
	public void sampleBeforeMethod()
	{
		System.out.println("Sample Before Method");
		//normally the BrowserLaunch and all are given inside Before Method. 
	}
	@AfterMethod
	public void sampleAfterMethod() {
		//usually browser quit 
		System.out.println("Sample After Method");
	}
	@BeforeClass
	public void sampleBeforeClass() {
		System.out.println("Sample Before Class"); //Something to come Before Method 
	}
	@AfterClass
	public void sampleAfterClass() {
		System.out.println("Sample After Class"); //Something to come After Method 
	}
	@BeforeTest
	public void sampleBeforeTest()
	{
		System.out.println("Before Test");
	}
	@AfterTest
	public void sampleAfterTest() {
		System.out.println("After Test");
	}
	@BeforeSuite
	public void sampleBeforeSuite()
	{
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void sampleAfterSuite()
	{
		System.out.println("After Suite");
	}

}
