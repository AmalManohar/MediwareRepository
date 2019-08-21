//********************************************************************************
// Class Description  : BaseClass for handling Chrome Driver
// Author             : Akhil
// Date				  : 21-09-2018 
// Last Modified Date :
// Last Modified Name : 
//********************************************************************************
package core;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass
{
	public static WebDriver driver;
	
	//*****************************************************************************
	// Function	Name	  : init
	// Summary	          : Chrome driver initialization function
	// Author             : Akhil
	// Date				  : 21-09-2018 
	// Last Modified Date :
	// Last Modified Name : 
	//*****************************************************************************
	@BeforeTest
	public void init()
    {	 
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.get("https://nestandcastle.emvigotechnologies.com/");
	    driver.manage().window().maximize();	    
	}
	
	
}

