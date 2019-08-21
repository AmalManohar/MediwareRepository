package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.CommonLib;

public class AllergiesDelete {

	WebDriver driver;
	By patientStatusList = By.xpath(CommonLib.readElementPropertyFile("PATIENT_STATUS_LIST_XPATH"));
	By arrivedStatus = By.xpath(CommonLib.readElementPropertyFile("ARRIVED_PATIENT_STATUS_XPATH"));
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By vitaldetailframe = By.xpath(CommonLib.readElementPropertyFile("VITAL_DETAILS_FRAME_XPATH"));
	By allergiesOption = By.id(CommonLib.readElementPropertyFile("ALLERGIES_OPTION_ID"));
	By allergiesNKA = By.id(CommonLib.readElementPropertyFile("ALLERGIES_NO_KNOWN_ALLERGIES_CHKBOX_ID"));
	By genericAllergies = By.id(CommonLib.readElementPropertyFile("ALLERGIES_GENERIC_NAME_FIELD_ID"));
	By genericAllergiesName = By.xpath(CommonLib.readElementPropertyFile("ALLERGIES_GENERIC_NAME"));
	By otherallergiesItem = By.id(CommonLib.readElementPropertyFile("OTHER_ALLERGIES_ITEM"));
	
	public AllergiesDelete(WebDriver driver) {
		this.driver = driver;
		
	}
	public void arrivedStatusPatient() throws Exception {

		driver.findElement(arrivedStatus).click();
	}
	public void allergyDelete() throws Exception {
		//driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement switchframe = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchframe);
		Thread.sleep(2000);
		driver.findElement(allergiesOption).click();
		switchframe = driver.findElement(vitaldetailframe);
		CommonLib.frameSwitch(switchframe);
		Thread.sleep(2000);
		if(driver.findElement(allergiesNKA).isSelected()) {
			driver.findElement(genericAllergies).click();
			Thread.sleep(3000);
			driver.findElement(genericAllergiesName).click();
			Thread.sleep(2000);
			driver.findElement(otherallergiesItem).sendKeys(CommonLib.readDataPropertyFile("OTHER_ALLERGY_TYPE"));

		}
		else {
			driver.findElement(allergiesNKA).click();
			driver.findElement(genericAllergies).click();
			Thread.sleep(3000);
			driver.findElement(genericAllergiesName).click();
			Thread.sleep(2000);
			driver.findElement(otherallergiesItem).sendKeys(CommonLib.readDataPropertyFile("OTHER_ALLERGY_TYPE"));
			Thread.sleep(2000);
		}
		
	}
}
