package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.CommonLib;

public class NewVitals {

	WebDriver driver;
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By vitalEditButton = By.xpath(CommonLib.readElementPropertyFile("VITAL_EDIT_BUTTON_XPATH"));
	By vitaltempfield = By.id(CommonLib.readElementPropertyFile("VITAL_TEMP_ID"));
	By vitalpulsefield = By.id(CommonLib.readElementPropertyFile("VITAL_PULSE_ID"));
	By vitalbp1field = By.id(CommonLib.readElementPropertyFile("VITAL_BP1_ID"));
	By vitalbp2field = By.id(CommonLib.readElementPropertyFile("VITAL_BP2_ID"));
	By vitaldetailframe = By.xpath(CommonLib.readElementPropertyFile("VITAL_DETAILS_FRAME_XPATH"));
	public NewVitals(WebDriver driver) {
		this.driver = driver;
	}
	public void frame() {
		driver.switchTo().defaultContent();
	}
	public void editVitals() throws Exception {
		
		WebElement switch_frame=driver.findElement(vitaldetailframe);
		CommonLib.frameSwitch(switch_frame);
		driver.findElement(vitalEditButton).click();
		Thread.sleep(2000);
		driver.findElement(vitaltempfield).clear();
		driver.findElement(vitalpulsefield).clear();
		driver.findElement(vitalbp1field).clear();
		driver.findElement(vitalbp2field).clear();
		Thread.sleep(2000);
		String check = null;
		assertEquals(check, null);
		driver.switchTo().defaultContent();
		switch_frame=driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switch_frame);
		
		
	}
}
