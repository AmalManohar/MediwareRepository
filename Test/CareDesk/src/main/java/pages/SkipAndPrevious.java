package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.CommonLib;

public class SkipAndPrevious {

	WebDriver driver;
	By vitalskipbutton = By.xpath(CommonLib.readElementPropertyFile("VITAL_SKIP_BUTTON_XPATH"));
	By vitalpreviousbutton = By.xpath(CommonLib.readElementPropertyFile("VITAL_PREVIOUS_BUTTON_XPATH"));
	By vitaldetailframe = By.xpath(CommonLib.readElementPropertyFile("VITAL_DETAILS_FRAME_XPATH"));
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	public SkipAndPrevious(WebDriver driver) {
		this.driver = driver;
	}
	public void skipNextClick() throws Exception {
		
		driver.switchTo().defaultContent();
		WebElement switchframe = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchframe);
		WebElement switchFrame = driver.findElement(vitaldetailframe);
		CommonLib.frameSwitch(switchFrame);
		Thread.sleep(1000);
		driver.findElement(vitalskipbutton).click();	
	}
	public void previousButton() throws Exception {
		driver.switchTo().defaultContent();
		WebElement switchframe = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchframe);
		WebElement switchFrame = driver.findElement(vitaldetailframe);
		CommonLib.frameSwitch(switchFrame);
		Thread.sleep(1000);
		driver.findElement(vitalpreviousbutton).click();
	}
}
