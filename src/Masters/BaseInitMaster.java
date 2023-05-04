package Masters;



import Parent.BaseInit;
import Utility.UtilityMethods;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

public class BaseInitMaster extends BaseInit{
 
  @BeforeSuite
  public void CheckExecutionModeTestSuite() throws IOException {
	  
	  startup();
	  if(!UtilityMethods.checkExecutionModeTestSuite(Test_suite, "Masters", "TestSuite"))
	  {
			throw new SkipException("Execution mode of the test suite is set to NO");
	}	
	  
	  
  }

}
