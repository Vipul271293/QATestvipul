package Parent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.unicodetechnologies.xlsConnectivity.XLSDatatable_Connectivity;

public class BaseInit {
	
	public static Logger Log = null;
	public static WebDriver driver = null;
	public static Properties prop = null;
	public static XLSDatatable_Connectivity Test_suite = null;
	public static XLSDatatable_Connectivity Test_Cases = null;
	public static XLSDatatable_Connectivity Test_Data = null;
	
	
	
	public void startup() throws IOException
	{
		if(driver ==null)
			
		{
			Log = Logger.getLogger("devpinoyLogger");
			Log.info("Properties Loading...");
			prop = new Properties();
			FileInputStream f1 = new FileInputStream(System.getProperty("user.dir")+"//src//Properties//sitedata.properties");
			prop.load(f1);
			
			Log.info("Properties file loaded successfully");
			Log.info("browser Launching is start");
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\Files\\chromedriver.exe");
				driver = new ChromeDriver();
				
				Log.info("Browser Launch Done");
			}	
				
			}
		
		Log.info("browser launch");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Test_suite = new XLSDatatable_Connectivity(System.getProperty("user.dir")+"//src//XLSFiles//TestSuite.xlsx");
		Test_Cases = new XLSDatatable_Connectivity(System.getProperty("user.dir")+"//src//XLSFiles//TestCase.xlsx");
		Test_Data = new XLSDatatable_Connectivity(System.getProperty("user.dir")+"//src//XLSFiles//TestData.xlsx");
		
		}
	
	public static WebElement CheckXpath(String key) {
		try {
			return driver.findElement(By.xpath(prop.getProperty(key)));
			
		}catch(Throwable t) {
			t.getMessage();
			return null;
			
		}
		
	}
	public static WebElement CheckCss(String key) {
		
		try {
			return driver.findElement(By.cssSelector(key));
		}catch(Throwable t) {
			t.getMessage();
			return null;
			
		}
	}
	
	public static WebElement CheckID(String key) {
		
		try {
			return driver.findElement(By.id(key));
			
		}
		catch(Throwable t)
		{
			t.getMessage();
			return null;
		}
	}
	public static WebElement CheckLink(String key)
	{
		try {
		return driver.findElement(By.linkText(key));
		}
	
	catch(Throwable t) {
		t.getMessage();
		return null;
		
	}
	
	}
}



