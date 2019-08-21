package core;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLib extends Base{
	


	//********************************************************************************
		// Function	Name	  : readElementPropertyFile
		// Summary	          : To get element from Element.properties
		// Author             : Amal
		// Date				  : 31-07-2019
		// Parameter 1		  : strQuery - Variable name of Element
		// Last Modified Date :
		// Last Modified Name : 
		//********************************************************************************
		public static String readElementPropertyFile(String strQuery)
		{
			Properties prop = new Properties();
			File file = new File("C:\\eclipse-workspace\\amal\\Test\\CareDesk\\configs\\Element.properties");
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
		// Author             : Amal
		// Date				  : 31-07-2019
		// Parameter 1		  : strQuery - Variable name of TestData
		// Last Modified Date :
		// Last Modified Name : 
		//********************************************************************************
		public static String readDataPropertyFile(String strQuery)
	    {
			Properties prop = new Properties();
			File file = new File("C:\\eclipse-workspace\\amal\\Test\\CareDesk\\configs\\TestData.properties");
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
		
		public WebDriverWait getWait() {
			wait = new WebDriverWait(driver, 60);
			wait.pollingEvery(250, TimeUnit.MILLISECONDS);
			wait.ignoring(NoSuchElementException.class);
			return wait;
		}
		
		public static void frameSwitch(WebElement switch_frame) {
			driver.switchTo().frame(switch_frame);
		}


		public static void executescriptclick(WebElement myWebElement) {
			// TODO Auto-generated method stub
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", myWebElement);
		}
	    
		public static void highLighterMethod(WebDriver driver, WebElement element){
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].setAttribute('style', 'background: lightblue; border: 2px solid blue;');", element);
			 }
		public static List<WebElement> getList(By element) {
			
			List<WebElement> list = driver.findElements(element);
			return list;
		}
		public static void assertTrueFn(By element) {
			assertTrue(driver.findElement(element).isDisplayed());
		}
		public static void assertEqualsFn(String actual,String expected) {
			assertEquals(actual, expected);
		}
}
