package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import core.CommonLib;

public class Login{
	WebDriver driver;
	By UserName = By.id(CommonLib.readElementPropertyFile("LOGIN_USERNAME_ID"));
	By Password = By.id(CommonLib.readElementPropertyFile("LOGIN_PASSWORD_ID"));
	By Login =By.id(CommonLib.readElementPropertyFile("LOGIN_BUTTON_ID"));
	By OutPatient = By.xpath(CommonLib.readElementPropertyFile("CAREDESK_OUTPATIENT_ID"));
	By DoctorLabel = By.xpath(CommonLib.readElementPropertyFile("DOCTOR_LABEL_ID"));
	
	
		
	public Login(WebDriver driver){
		this.driver=driver;		
	}
	public void ClickonLogin( String userName,String pass) {
		driver.findElement(UserName).sendKeys(userName);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(Login).click();
	}
}
