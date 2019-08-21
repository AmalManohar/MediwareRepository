package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import core.CommonLib;

public class DoctorSelect {
	
	WebDriver driver;
	By doctorLabelId = By.id(CommonLib.readElementPropertyFile("DOCTOR_LABEL_ID"));
	By DoctorName = By.xpath(CommonLib.readElementPropertyFile("DOCTOR_NAME"));
	By clickleft = By.xpath(CommonLib.readElementPropertyFile("CLICK_LEFT_XPATH"));
	public DoctorSelect(WebDriver driver) {
		this.driver = driver;
	}

	public void doctorSelect(String doctorName) throws Exception {
		// TODO Auto-generated method stub
		//driver.findElement(clickleft).click();
		//driver.findElement(clickleft).click();
		Thread.sleep(1000);
		driver.findElement(doctorLabelId).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(DoctorName)).perform();
		//driver.findElement(DoctorName).click();
		
	}

}
