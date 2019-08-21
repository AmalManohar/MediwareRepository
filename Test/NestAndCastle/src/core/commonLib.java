//********************************************************************************
// Class Description  : Contains functions that are common for all test
// Author             : Akhil
// Date				  : 21-09-2018 
// Last Modified Date :
// Last Modified Name : 
//********************************************************************************
package core;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class commonLib extends BaseClass
{
	//********************************************************************************
	// Function	Name	  : readElementPropertyFile
	// Summary	          : To get element from Element.properties
	// Author             : Akhil
	// Date				  : 21-09-2018
	// Parameter 1		  : strQuery - Variable name of Element
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	public static String readElementPropertyFile(String strQuery)
	{
		Properties prop = new Properties();
		File file = new File("C:\\Users\\Mentor\\eclipse-workspace\\NestAndCastle\\configs\\Element.properties");
		String strData=""; 
		FileInputStream fileInput = null;
		
		try 
		{
			fileInput = new FileInputStream(file);			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			prop.load(fileInput);
			strData = prop.getProperty(strQuery);
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return strData;
	}
    
	//********************************************************************************
	// Function	Name	  : readDataPropertyFile
	// Summary	          : To get data from TestData.properties
	// Author             : Akhil
	// Date				  : 21-09-2018
	// Parameter 1		  : strQuery - Variable name of TestData
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	public static String readDataPropertyFile(String strQuery)
    {
		Properties prop = new Properties();
		File file = new File("C:\\Users\\Mentor\\eclipse-workspace\\NestAndCastle\\configs\\TestData.properties");
		String strData=""; 
		FileInputStream fileInput = null;
		try 
		{
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			prop.load(fileInput);
			strData = prop.getProperty(strQuery);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return strData;
	}	
	
	//********************************************************************************
	// Function	Name	  : verifyString
	// Summary	          : To verify the displayed message of an element
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Parameter 1		  : element - Element which contains the actual message
	// Parameter 2		  : strExpectedMessage - Expected Message
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	public static void verifyString(WebElement element,String strExpectedMessage) 
	{
		String strActualMessage = element.getText();
		Assert.assertTrue(strActualMessage.equals(strExpectedMessage));
	}
	
	//********************************************************************************
	// Function	Name	  : highlights
	// Summary	          : To highlight the element
	// Author             : Akhil
	// Date				  : 21-09-2018
	// Parameter 1		  : element - Element to be highlighted
	// Last Modified Date :
	// Last Modified Name : 
	//********************************************************************************
	public static void highlights(WebElement element) throws InterruptedException		
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background:red; border: 2px solid black;');", element);
		Thread.sleep(3000);
		js.executeScript("arguments[0].setAttribute('style', 'background:#ffffff; border: 0px solid black;');", element);
	}
}