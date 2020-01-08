package Com.FreeCRM.Qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FreeCRM.Qa.Base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action
	public String validateLoginPageTilte()
	{
		return driver.getTitle();
	}
	
	public boolean validateCrmlogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String ur, String pwd) throws Exception
	{
		username.sendKeys(ur);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginbtn.click();
		
		return new HomePage();
	}
}
