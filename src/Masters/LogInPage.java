package Masters;

import org.testng.annotations.Test;

import Utility.UtilityMethods;
import Utility.UtilityMethods.operationtype;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class LogInPage extends BaseInitMaster{

	@BeforeTest
	public void CheckTestCaseExecution() {

		if(!UtilityMethods.checkExecutionModeTestCase(Test_Cases, this.getClass().getSimpleName(), "TestScripts"))
		{
			throw new SkipException("Execution mode of the test case is set to NO");
		}
	}

	@Test(dataProvider ="getTestData")
	public static void LogIn(String username, String password) throws InterruptedException, IOException {
		
	System.out.println("Vipul");
	System.out.println("Arti");
	
<<<<<<< HEAD
	System.out.println("VCP QA");
	

=======
	System.out.println("Cygnet");
	
>>>>>>> master
		driver.get("https://lmsgyrus.gyrusaim.net/auth/login");
		Thread.sleep(5000);
		UtilityMethods.ExplicitWait_Operation("USER_NAME", operationtype.esendkeys,username, "XPATH");
		UtilityMethods.ExplicitWait_Operation("PASSWORD", operationtype.esendkeys,password, "XPATH");
		Thread.sleep(5000);
		UtilityMethods.ExplicitWait_Operation("BTN_LOGIN", operationtype.eclick, "", "XPATH");
		System.out.println("Login Done Successfully");

		Thread.sleep(5000);
		UtilityMethods.ExplicitWait_Operation("LINK_IDP", operationtype.eclick, "", "XPATH");
		System.out.println("IDP Form Loaded Successfully");

		Thread.sleep(5000);
		UtilityMethods.ExplicitWait_Operation("TXT_SEARCH", operationtype.esendkeys, "Vipul27", "XPATH");
		Thread.sleep(7000);
		UtilityMethods.ExplicitWait_Operation("BTN_EXTERNAL_LINK", operationtype.eclick, "", "XPATH");

		Thread.sleep(5000);
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
			Thread.sleep(7000);
			String parent = driver.getWindowHandle();
			System.out.println("Parent window id is" +parent);
			Set<String> allwindows = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allwindows);

			driver.switchTo().window(tabs.get(1));
			driver.close();

			driver.switchTo().window(tabs.get(0));
		}
		else{

			System.out.println("No Alert Present");

		}

		

		Thread.sleep(5000);
		UtilityMethods.ExplicitWait_Operation("BTN_ACTION", operationtype.eclick, "", "XPATH");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Complete Training")).click();
		UtilityMethods.ExplicitWait_Operation("BTN_YES", operationtype.eclick, "", "XPATH");
		System.out.println("Training Completed Successfully");

		Thread.sleep(8000);
		UtilityMethods.ExplicitWait_Operation("GRID_BTN_MORE", operationtype.eclick, "", "XPATH");
		UtilityMethods.ExplicitWait_Operation("GRID_BTN_EDIT", operationtype.eclick, "", "XPATH");


		Thread.sleep(5000);	
		UtilityMethods.ExplicitWait_Operation("BTN_START_ASS", operationtype.eclick, "", "XPATH");
        System.out.println("Assignment is start...");

		Thread.sleep(5000);
		UtilityMethods.ExplicitWait_Operation("TXT_ANS1", operationtype.esendkeys, "100", "XPATH");
		UtilityMethods.ExplicitWait_Operation("TXT_ANS2", operationtype.esendkeys, "81", "XPATH");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@title='Submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@ng-click='dialog.hide()']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@class='layout-row ally-focus-within']//button[2]")).click();
		System.out.println("Assignment is Completed");
		Thread.sleep(5000);
		UtilityMethods.ExplicitWait_Operation("LOG_OUT", operationtype.eclick, "", "XPATH");
		System.out.println("LogOut Done Successfully");
	}

	@AfterMethod
	public void testIT(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			UtilityMethods.captureScreenshot(driver, result.getName());
		}

	}

	public static boolean isAlertPresent(){

		try{

			driver.switchTo().alert();

			return true;

		}catch(NoAlertPresentException ex){

			return false;

		}

	}

	@DataProvider(name ="getTestData")
	public Object[][] getTestData()
	{
		return UtilityMethods.getTestDataFromXLS(Test_Data, "InputData");
	}

}
