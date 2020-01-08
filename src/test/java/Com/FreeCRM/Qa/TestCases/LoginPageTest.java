package Com.FreeCRM.Qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.FreeCRM.Qa.Base.TestBase;
import Com.FreeCRM.Qa.Pages.HomePage;
import Com.FreeCRM.Qa.Pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp()
	{
		Initialization();
		loginpage= new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title= loginpage.validateLoginPageTilte();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		Boolean flag= loginpage.validateCrmlogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void loginTest() throws Exception
	{
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
