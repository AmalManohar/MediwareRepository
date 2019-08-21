package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.CommonLib;

public class TreatmentSummary {

	WebDriver driver;
	By patientClick = By.xpath(CommonLib.readElementPropertyFile("PATIENT_CLICK_XPATH"));
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By treatmentSummaryFrame = By.xpath(CommonLib.readElementPropertyFile("TREATMENT_SUMMARY_FRAME_XPATH"));
	By downArrow = By.xpath(CommonLib.readElementPropertyFile("TREATMENT_SUMMARY_DOWN_ARROW_XPATH"));
	By patientTreatmentSummary = By.xpath(CommonLib.readElementPropertyFile("PATIENT_TREATMENTSUMMARY_XPATH"));
	By patientStatusList = By.xpath(CommonLib.readElementPropertyFile("PATIENT_STATUS_LIST_XPATH"));
	By patientList = By.xpath(CommonLib.readElementPropertyFile("PATIENT_LIST_XPATH"));
	By treatmentsummaryClickAlert = By.xpath(CommonLib.readElementPropertyFile("TREATMENT_SUMMARY_ALERT_CLOSE_BUTTON_XPATH"));
	By treatmentsummaryDateClick = By.xpath(CommonLib.readElementPropertyFile("TREATMENT_SUMMARY_DATE_CLICK_XPATH"));
	By patientClickTest = By.xpath(CommonLib.readElementPropertyFile("PATIENT_CLICK_TEST_XPATH"));
	public TreatmentSummary(WebDriver driver) {
		this.driver = driver;
	}

	public void patientClick() throws Exception {
		// TODO Auto-generated method stub
		//List<WebElement> patient_List = driver.findElements(patientList); 
		List<WebElement> status_List = driver.findElements(patientStatusList);
		//WebElement patient;
//		for(int i=0;i<status_List.size();i++) {
//		System.out.println(status_List.get(i).getText());
//		}
//		System.out.println(status_List);
		for(int i=0;i<status_List.size();i++) {
			String status = status_List.get(i).getText();
			
			//System.out.println(status);
			if((status.equalsIgnoreCase("Re-consult") ) || (status.equalsIgnoreCase("Revisited")) || (status.equalsIgnoreCase("Reopened"))) {	
				
				//List<WebElement> status_List1 = driver.findElements(patientStatusList);
				Thread.sleep(2000);
				status_List.get(i).isEnabled();
				//System.out.println("Enabled");
				CommonLib.executescriptclick(status_List.get(i));
			}
			else {
				System.out.println("no treatment summary available");
			}
				
		}
		//System.out.println(status_List.get(0).getText());

		
		//driver.findElement(patientClick).click();
	}
	public void patientTreatmentSummaryClick() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		WebElement switchFrame = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchFrame);	
		Thread.sleep(2000);
		assertTrue(driver.findElement(patientClickTest).isDisplayed());
		driver.findElement(patientTreatmentSummary).click();
		WebElement switchframe = driver.findElement(treatmentSummaryFrame);
		CommonLib.frameSwitch(switchframe);	
		Thread.sleep(2000);
		//driver.findElement(treatmentsummaryClickAlert).click();
	}
	public void downArrowClick() throws Exception {
		Thread.sleep(2000);
		assertTrue(driver.findElement(downArrow).isDisplayed());
		driver.findElement(downArrow).click();
		Thread.sleep(3000);
		driver.findElement(treatmentsummaryDateClick).click();
	}
}
