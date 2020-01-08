package Com.FreeCRM.Qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.FreeCRM.Qa.Base.TestBase;
import Com.FreeCRM.Qa.Pages.HomePage;
import Com.FreeCRM.Qa.Pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		Initialization();
		homePage= new HomePage();
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test
	public void validateHomePageTitle()
	{
		String title= homePage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test
	public void validateUserName()
	{
		Boolean bl= homePage.verifyUserName();
		Assert.assertTrue(bl);
	}
	
	@Test
	public void clickonContacts()
	{
		driver.switchTo().frame("mainpanel");
		homePage.clickonContactslink();
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
