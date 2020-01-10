package Com.FreeCRM.Qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.FreeCRM.Qa.util.Util;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{	
		
		try {
			prop= new Properties();
			FileInputStream src = new FileInputStream("D:\\workspace\\clone project\\freeCRM\\src\\main\\java\\Com\\FreeCRM\\Qa\\Config\\Config.properties");
			prop.load(src);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	public void Initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Util.implicitTimeOut,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Util.pageLoadTimeout, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			System.out.println(" Tabish just try to print meaning less");
		}
		
		
	}
	
	
	
}
