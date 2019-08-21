//********************************************************************************
// Class Description  : Contains functions for registration of new user
// Author             : Akhil
// Date				  : 21-09-2018 
// Last Modified Date :
// Last Modified Name : 
//********************************************************************************
package pages;
import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import core.commonLib;

public class RegistrationNewUser{
	
	WebDriver driver;
	
	By RegisterButton=By.xpath(commonLib.readElementPropertyFile("REGISTER_BUTTON_XP"));
	By RegisterEmail=By.xpath(commonLib.readElementPropertyFile("REGISTEREMAIL_EDIT_XP"));
	By RegisterPass=By.xpath(commonLib.readDataPropertyFile("USER_PASSWORD"));
	By RegisterConfirmPass=By.xpath(commonLib.readElementPropertyFile("REGISTERCONFPASS_EDIT_XP"));
	By RegisterCheckbox=By.xpath(commonLib.readElementPropertyFile("REGISTER_CHECKBOX_XP"));
	By RegisterSignUp=By.xpath(commonLib.readElementPropertyFile("REGISTERSIGNUP_BUTTON_XP"));
	By RegisterMessage=By.xpath(commonLib.readElementPropertyFile("REGSUCCESS_TEXT_XP"));
	By Email=By.id(commonLib.readElementPropertyFile("EMAIL_EDIT_ID"));
	By CheckInbox=By.xpath(commonLib.readElementPropertyFile("CHECKINBOX_XP"));
	By Verify=By.xpath(commonLib.readElementPropertyFile("VERIFY_BUTTON_XP"));
	By RightMessage=By.xpath(commonLib.readElementPropertyFile("RIGHT_MESSAGE_XP"));
	By LoginEmail=By.id(commonLib.readElementPropertyFile("LOGINEMAIL_EDIT_ID"));
	By LoginPassword=By.id(commonLib.readElementPropertyFile("LOGINPASSWORD_EDIT_ID"));
	By LoginSubmit=By.xpath(commonLib.readElementPropertyFile("LOGINSUBMIT_BUTTON_XP"));
	By LoginMessage=By.xpath(commonLib.readElementPropertyFile("LOGINMESSAGE_TEXT_XP"));
	By MyProfile=By.xpath(commonLib.readElementPropertyFile("MYPROFILE_TEXT_XP"));
	By MailIframe=By.name(commonLib.readElementPropertyFile("MAIL_IFRAME_NM"));
	
	public RegistrationNewUser(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//********************************************************************************
	// Function	Name	  : clickOnRegistration
	// Summary	          : To click on Registration Button
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	public void clickOnRegistration() 
	{	
		driver.findElement(RegisterButton).click();
	}
	
	//********************************************************************************
	// Function	Name	  : registerUserWithCredentials
	// Summary	          : Registration a new user using Email
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Last Modified Date :
	// Last Modified Name :
	// Parameter 1		  : strUserName - UserName for the registration
	// Parameter 2		  : strPassword - Password for the registration
	//********************************************************************************
	public void registerUserWithCredentials(String strUserName,String strPassword) 
	{		
		// Entering user details
		driver.findElement(RegisterEmail).sendKeys(strUserName);
		driver.findElement(RegisterPass).sendKeys(strPassword);
		driver.findElement(RegisterConfirmPass).sendKeys(strPassword);
		driver.findElement(RegisterCheckbox).click();
	
		// Handling captcha
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String captcha;   
	    System.out.println("Please Enter the CAPTCHA Code:: ");
	    try 
	    {
			captcha = br.readLine();
			System.out.println("Entered  CAPTCHA Code is:: "+captcha);
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	    
	    // Signing in using new credentials
	    driver.findElement(RegisterSignUp).click();
	}
	
	//********************************************************************************
	// Function	Name	  : verifyRegistrationMessage
	// Summary	          : Verify Registration Message
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	public void verifyRegistrationMessage() throws InterruptedException, FileNotFoundException, IOException	
	{
		commonLib.verifyString(driver.findElement(RegisterMessage),commonLib.readDataPropertyFile("REG_SUCCESS_MSG"));		
	}

	//********************************************************************************
	// Function	Name	  : openMailInbox
	// Summary	          : To open mail inbox
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	public void openMail(String strMailId) throws InterruptedException, FileNotFoundException, IOException 
	{ 
	    driver.get(commonLib.readDataPropertyFile("MAIL_URL"));	    
	    Thread.sleep(5000);
	    driver.findElement(Email).sendKeys(strMailId);
	    Thread.sleep(5000);
	    driver.findElement(CheckInbox).click();
	    Thread.sleep(5000);
	    driver.switchTo().frame(driver.findElement(MailIframe));
		driver.findElement(Verify).click();
	}
	
	//********************************************************************************
	// Function	Name	  : verifyRegistrationCompletionMsg
	// Summary	          : Verify Registration completion Message
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
    public void verifyRegistrationCompletionMsg() throws InterruptedException, FileNotFoundException, IOException 
    {   
    	commonLib.verifyString(driver.findElement(RightMessage),commonLib.readDataPropertyFile("RIGHT_MESSAGE_XP"));
	}
	
    //********************************************************************************
  	// Function	Name	  : openApplication
  	// Summary	          : To open mail application
  	// Author             : Akhil
  	// Date				  : 21-09-2018 
  	// Last Modified Date :
  	// Last Modified Name : 
  	//********************************************************************************
    public void openApplication(String strUserName,String strPassword) throws InterruptedException
	{
		driver.findElement(LoginEmail).sendKeys(strUserName);
		driver.findElement(LoginPassword).sendKeys(strPassword);
		driver.findElement(LoginSubmit).click();
	}
	    
    //********************************************************************************
  	// Function	Name	  : verifyLoginMsg
  	// Summary	          : To verify login message
  	// Author             : Akhil
  	// Date				  : 21-09-2018 
  	// Last Modified Date :
  	// Last Modified Name : 
  	//********************************************************************************
    public void verifyLoginMsg() throws InterruptedException, FileNotFoundException, IOException 
	{
    	Thread.sleep(5000);
    	commonLib.verifyString(driver.findElement(LoginMessage),commonLib.readDataPropertyFile("LOGIN_MESSAGE_XP"));
	}
	
  //********************************************************************************
  	// Function	Name	  : verifyProfileIsDisplayed
  	// Summary	          : To verify profile is displayed
  	// Author             : Akhil
  	// Date				  : 21-09-2018 
  	// Last Modified Date :
  	// Last Modified Name : 
  	//********************************************************************************
    public void verifyProfileIsDisplayed() throws InterruptedException 
    {
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(MyProfile).isDisplayed(),"Checking My Profile is Displayed");
		commonLib.highlights( driver.findElement(MyProfile));
	}
}
