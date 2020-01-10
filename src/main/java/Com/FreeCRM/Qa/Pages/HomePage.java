package Com.FreeCRM.Qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FreeCRM.Qa.Base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//*[text()='Deals']")
	WebElement deals;
	
	@FindBy(xpath="//*[text()='Tasks']")
	WebElement tasks;
	
	@FindBy(xpath="//td[contains(text(),'User: MOHAMMAD ASHIQUE')]")
	WebElement username;
	

	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}

	public Boolean verifyUserName()
	{
		driver.switchTo().frame("mainpanel");
		return username.isDisplayed();
	}
	
	public ContactsPage clickonContactslink()
	{
		contacts.click();
		return new ContactsPage();
	}
	
	
}

