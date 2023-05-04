package Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.unicodetechnologies.xlsConnectivity.XLSDatatable_Connectivity;

import Parent.BaseInit;
import Utility.UtilityMethods.operationtype;

public class UtilityMethods extends BaseInit{
	
	
	//public static void SingIn()
	//{
		
	//}
	
	public static boolean checkExecutionModeTestSuite(XLSDatatable_Connectivity data, String TestSuiteName, String sheetName)
	{
	
		int rows = data.totalRow(sheetName);
		for(int row=2;row<=rows;row++)
		{
			if(data.getData(sheetName, "TestSuiteID", row).equalsIgnoreCase(TestSuiteName))
			{
				if(data.getData(sheetName, "Execute", row).equalsIgnoreCase("y"))
					return true;
				else 
					return false;
			}
		} return false;
	}
	
	public static boolean checkExecutionModeTestCase(XLSDatatable_Connectivity data, String TestCaseName, String sheetName)
	{
		int rows = data.totalRow(sheetName);
		//int cols = data.totalColumn(sheetName);
		
		for(int row=2;row<=rows;row++)
		{
		if(data.getData(sheetName, "TestID", row).equalsIgnoreCase(TestCaseName))
		{
			if(data.getData(sheetName, "Execute", row).equalsIgnoreCase("y"))
				return true;
			else 
				return false;
				
			}
		} return false;
	}
	
	public enum operationtype{
		esendkeys,eclear,eclick;
	}
	public static void ExplicitWait_Operation(String Locator , operationtype OT, String optionalsendkeys, String type)
	
	{
		
		
		try {
			WebElement operational_Wait = null;
			if(type=="XPATH")
				operational_Wait = CheckXpath(Locator);
			if(type=="CSS")
				operational_Wait = CheckCss(Locator);
			if(type=="ID")
				operational_Wait = CheckID(Locator);
			if(type=="LINK")
				operational_Wait = CheckLink(Locator);
			WebElement wait = (new WebDriverWait(driver,50).until(ExpectedConditions.elementToBeClickable(operational_Wait)));
			switch(OT)
			{
			
			case eclick:
				wait.click();
				break;
			case eclear:
				wait.clear();
			case esendkeys:
				wait.sendKeys(optionalsendkeys);
				break;
			}
		}catch(Exception e)
		{	
			
		}
	}
	
	public static Object[][] getTestDataFromXLS(XLSDatatable_Connectivity data, String sheetName)
	{	
		
		int rows = data.totalRow(sheetName);
		int cols = data.totalColumn(sheetName);
		Object[][] mydata = null;
		
		 mydata = new Object[rows-1][cols];	
		 
		for(int row=2;row<=rows;row++)
		{		
			for(int col=0;col<cols;col++){			
				mydata[row-2][col] = data.getData(sheetName, col, row);
			}
		}	
		return mydata;			
	}
	
	public static void captureScreenshot(WebDriver driver, String screenshotname)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		try {
			
			TakesScreenshot screenshot =  (TakesScreenshot)driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:/Users/Vipul/eclipse-workspace/GyrusPractical/Screenshot/Screenshot_"+screenshotname+dateFormat.format(date)+".png"));
			
			System.out.println("-----SCREEN SHOT TAKEN");
			
		}
		catch(Exception excep)
		{
			System.out.println("Throwing exception while taking screenshot" +excep.getMessage());
		}
			
		}
	}


