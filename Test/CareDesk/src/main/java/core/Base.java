package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	//*****************************************************************************
	// Function	Name	  : init
	// Summary	          : Chrome driver initialization function
	// Author             : Amal
	// Date				  : 31-07-2019 
	// Last Modified Date :
	// Last Modified Name : 
	//*****************************************************************************
	
	@BeforeTest
	public void init() {
		
			System.setProperty("webdriver.chrome.driver","C:\\eclipse-workspace\\amal\\Test\\CareDesk\\chromedriver.exe");
	        ChromeOptions options=new ChromeOptions();
	        options.addArguments("--disable-infobars");
	        driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://mediwarecloud.com/MediwareQC/login.aspx");
	
		}
		
	}