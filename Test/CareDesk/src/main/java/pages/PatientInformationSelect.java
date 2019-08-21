package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import core.CommonLib;

public class PatientInformationSelect {

	WebDriver driver;
	By patientHover = By.xpath(CommonLib.readElementPropertyFile("PATIENT_SELECT_XPATH"));
	By patientInfo = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_XPATH"));
	
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By patientTreatmentSummary = By.xpath(CommonLib.readElementPropertyFile("PATIENT_TREATMENTSUMMARY_XPATH"));
	By patientInfoFrameCloseButton = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_CLOSEBUTTON_XPATH"));
	By patientStatusList = By.xpath(CommonLib.readElementPropertyFile("PATIENT_STATUS_LIST_XPATH"));
	By patientInfoPage = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_PAGE_TEST"));
	By callingpagediv = By.xpath(CommonLib.readElementPropertyFile("CALLING_PAGEDIV_XPATH"));
	By divmainpage = By.xpath(CommonLib.readElementPropertyFile("DIVMAIN_PAGE_XPATH"));
	
	
	
	public PatientInformationSelect(WebDriver driver) {
		this.driver = driver;
	}
	public void patientHover() throws Exception {

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(patientHover)).perform();
		Thread.sleep(2000);
	}
	public void patientInfoClick() throws Exception {
		Thread.sleep(2000);
		driver.findElement(patientInfo).click();
		Thread.sleep(2000);

		WebElement switch_frame = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switch_frame);	
		Thread.sleep(2000);
		//	CommonLib.frameSwitch(switch_frame);
		driver.findElement(patientInfoFrameCloseButton).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
	}

}
