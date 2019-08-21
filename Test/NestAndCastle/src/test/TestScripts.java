//********************************************************************************
// Class Description  : Contains testcases
// Author             : Akhil
// Date				  : 21-09-2018 
// Last Modified Date :
// Last Modified Name : 
//********************************************************************************
package test;
import java.io.IOException;

import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sementor.DataManager.GenerateData;
import com.sementor.DataManager.GenerateData.Case;

import core.BaseClass;
import core.commonLib;
import pages.RegistrationNewUser;

public class TestScripts extends BaseClass
{	
	
	public RegistrationNewUser objUser;
	
	@BeforeClass
	public void InitObjects() 
	{
		objUser = new RegistrationNewUser(driver);
	}
	//********************************************************************************
	// Testcase ID		  : TC_290
	// Description        : Registration for a new user using Email
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	@Test 
	public void TC_290() throws InterruptedException, IOException
  	{				
		String strUserName = "";
		String strPassword = commonLib.readDataPropertyFile("USER_PASSWORD");
		GenerateData GD = new GenerateData();
		
		objUser.clickOnRegistration();
				
  		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
  		driver.switchTo().window(windowHandles.get(2));
  		
  		strUserName = GD.generateRandomString(12, Case.LOWERCASE) + commonLib.readDataPropertyFile("URL_STRING");  		
  		objUser.registerUserWithCredentials(strUserName,strPassword);
  		objUser.verifyRegistrationMessage();
  		    	    
  		ArrayList<String> WindowOne = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window((String) WindowOne.get(1));
	    objUser.openMail(strUserName);
	        
	    ArrayList<String> windowHandles1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(windowHandles1.get(3));
	
	    objUser.verifyRegistrationCompletionMsg();
	    objUser.openApplication(strUserName,strPassword);
	      		
  		objUser.verifyLoginMsg();  		
		objUser.verifyProfileIsDisplayed();
  	}
}
