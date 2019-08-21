package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentCheckObjects {
	
	WebDriver driver;
	
	public AppointmentCheckObjects(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id = "")
	WebElement application_selector;
	
	
	
	
	public WebElement applicationSelector() {
		return application_selector;
		
	}
	

}
