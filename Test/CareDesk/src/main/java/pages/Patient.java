package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.CommonLib;

public class Patient {

	WebDriver driver;
	By vitaldetailframe = By.xpath(CommonLib.readElementPropertyFile("VITAL_DETAILS_FRAME_XPATH"));
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By vitalFrameCloseButton = By.id(CommonLib.readElementPropertyFile("VITAL_CLOSEBUTTON_ID"));
	By opPatientSearch = By.xpath(CommonLib.readElementPropertyFile("PATIENT_OP_SEARCH_FIELD_XPATH"));
	By consultedOpPatientSearch = By.xpath(CommonLib.readElementPropertyFile("PATIENT_CONSULTEDOP_SEARCH_FIELD_XPATH"));
	By patientList = By.xpath(CommonLib.readElementPropertyFile("PATIENT_LIST_XPATH"));
	By patientStatusList = By.xpath(CommonLib.readElementPropertyFile("PATIENT_STATUS_LIST_XPATH"));
	
	By vistedPatientCount = By.xpath(CommonLib.readElementPropertyFile("COUNT_VISITED_PATIENT"));
	By vistedPatientLabel = By.xpath(CommonLib.readElementPropertyFile("LABEL_VISITED_PATIENT"));
	By pendingPatientCount = By.xpath(CommonLib.readElementPropertyFile("COUNT_PENDING_PATIENT"));
	By pendingPatientLabel = By.xpath(CommonLib.readElementPropertyFile("LABEL_PENDING_PATIENT"));
	By pendingNewCount = By.xpath(CommonLib.readElementPropertyFile("COUNT_NEW_PATIENT"));
	By pendingNewLabel = By.xpath(CommonLib.readElementPropertyFile("LABEL_NEW_PATIENT"));
	By totalCount = By.xpath(CommonLib.readElementPropertyFile("COUNT_TOTAL_PATIENT"));
	By totalLabel = By.xpath(CommonLib.readElementPropertyFile("LABEL_TOTAL_PATIENT"));
	
	By datepicker = By.id(CommonLib.readElementPropertyFile("DATE_PICKER_ID"));
	By year = By.xpath(CommonLib.readElementPropertyFile("DATE_YEAR_XPATH"));
	By yearSelect = By.xpath(CommonLib.readElementPropertyFile("DATE_YEAR"));
	By month = By.xpath(CommonLib.readElementPropertyFile("DATE_MONTH_XPATH"));
	By monthSelect = By.xpath(CommonLib.readElementPropertyFile("DATE_MONTH"));
	By daySelect = By.xpath(CommonLib.readElementPropertyFile("DATE_DAY_XPATH"));
	
	By futureyear = By.xpath(CommonLib.readElementPropertyFile("DATE_FUTURE_YEAR_XPATH"));
	By futureyearSelect = By.xpath(CommonLib.readElementPropertyFile("DATE_FUTURE_YEAR"));
	By futuremonth = By.xpath(CommonLib.readElementPropertyFile("DATE_FUTURE_MONTH_XPATH"));
	By futuremonthSelect = By.xpath(CommonLib.readElementPropertyFile("DATE_FUTURE_MONTH"));
	By futuredaySelect = By.xpath(CommonLib.readElementPropertyFile("DATE_FUTURE_DAY_XPATH"));
	By today = By.xpath(CommonLib.readElementPropertyFile("TODAY_SELECT"));
	By clickleft = By.xpath(CommonLib.readElementPropertyFile("CLICK_LEFT_XPATH"));
	By clickright = By.xpath(CommonLib.readElementPropertyFile("CLICK_RIGHT_XPATH"));
	
	By selectpatient = By.xpath(CommonLib.readElementPropertyFile("ALLERGY_PATIENT_SELECT"));
	By allergiesOption = By.id(CommonLib.readElementPropertyFile("ALLERGIES_OPTION_ID"));
	By genericAllergies = By.id(CommonLib.readElementPropertyFile("ALLERGIES_GENERIC_NAME_FIELD_ID"));
	By genericAllergiesName = By.xpath(CommonLib.readElementPropertyFile("ALLERGIES_GENERIC_NAME"));
	By brandAllergies = By.id(CommonLib.readElementPropertyFile("ALLERGIES_BRAND_NAME_FIELD_ID"));
	By brandAllergiesName = By.xpath(CommonLib.readElementPropertyFile("ALLERGIES_BRAND_NAME"));
	By allergiesRemark = By.id(CommonLib.readElementPropertyFile("ALLERGIES_REMARKS_FIELD_ID"));
	By allergiesadd = By.id(CommonLib.readElementPropertyFile("ALLERGIES_ADD_ID"));
	By otherallergies = By.id(CommonLib.readElementPropertyFile("OTHER_ALLERGIES_TYPE_ID"));
	By otherallergiesRemarks = By.id(CommonLib.readElementPropertyFile("OTHER_ALLERGIES_REMARKS_ID"));
	By otherallergiesItem = By.id(CommonLib.readElementPropertyFile("OTHER_ALLERGIES_ITEM"));
	By otherallergiesadd = By.xpath(CommonLib.readElementPropertyFile("OTHER_ALLERGIES_ADD_XPATH"));
	By allergiessave = By.id(CommonLib.readElementPropertyFile("ALLERGIES_SAVE_BUTTON_ID"));
	By assesmentnentry = By.id(CommonLib.readElementPropertyFile("ASSESMENTENTRY_OPTION_ID"));
	
	public Patient(WebDriver driver) {
		this.driver = driver;
		
	}
	public void waitingOpPatientSearch() throws Exception {
		String searchkeyword1 = CommonLib.readDataPropertyFile("PATIENT_SEARCH_KEYWORD1");
		WebElement switchFrame = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchFrame);
		driver.findElement(vitalFrameCloseButton).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(opPatientSearch).sendKeys(searchkeyword1);
		Thread.sleep(2000);
		driver.findElement(opPatientSearch).clear();
		
	}
	public void consultedOpPatientSearch() throws Exception {
		String searchkeyword2 = CommonLib.readDataPropertyFile("PATIENT_SEARCH_KEYWORD2");

		driver.findElement(consultedOpPatientSearch).sendKeys(searchkeyword2);
	}
	public void patientCount() throws Exception {
		List<WebElement> patient_List = driver.findElements(patientList); 
		int count = patient_List.size();
		System.out.println(count);
		
		 WebElement visitedCount = driver.findElement(vistedPatientCount);
		 CommonLib.highLighterMethod(driver,visitedCount);
		 WebElement visitedPatient = driver.findElement(vistedPatientLabel);
		 CommonLib.highLighterMethod(driver,visitedPatient);

		 WebElement pendingCount = driver.findElement(pendingPatientCount);
		 CommonLib.highLighterMethod(driver,pendingCount);
		 WebElement pendingPatient = driver.findElement(pendingPatientLabel);
		 CommonLib.highLighterMethod(driver,pendingPatient);

		 WebElement newCount = driver.findElement(pendingNewCount);
		 CommonLib.highLighterMethod(driver,newCount);
		 WebElement newPatient = driver.findElement(pendingNewLabel);
		 CommonLib.highLighterMethod(driver,newPatient);

		 WebElement totalcount = driver.findElement(totalCount);
		 CommonLib.highLighterMethod(driver,totalcount);
		 WebElement totalPatient = driver.findElement(totalLabel);
		 CommonLib.highLighterMethod(driver,totalPatient);

	}
	
	public void pastDateCheck() throws Exception {
		// TODO Auto-generated method stub
		driver.findElement(datepicker).click();
		Thread.sleep(1000);
		
		driver.findElement(year).click();
	    driver.findElement(yearSelect).click();
	    Thread.sleep(1000);
	    
		driver.findElement(month).click();
	    driver.findElement(monthSelect).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(daySelect).click();
	}
	
	public void futureDateCheck() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		driver.findElement(datepicker).click();
		Thread.sleep(1000);
		
		driver.findElement(futureyear).click();
	    driver.findElement(futureyearSelect).click();
	    Thread.sleep(1000);
	    
		driver.findElement(futuremonth).click();
	    driver.findElement(futuremonthSelect).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(futuredaySelect).click();
	}
	public void today() throws Exception {
		driver.findElement(datepicker).click();
		Thread.sleep(1000);
		driver.findElement(today).click();
		Thread.sleep(1000);
		driver.findElement(clickleft).click();
		Thread.sleep(1000);
		driver.findElement(datepicker).click();
		Thread.sleep(1000);
		driver.findElement(today).click();
		Thread.sleep(1000);
		driver.findElement(clickright).click();
		driver.findElement(datepicker).click();
		Thread.sleep(1000);
		driver.findElement(today).click();
	}
	public void patientSelect() throws Exception {
		Thread.sleep(2000);
		driver.findElement(selectpatient).click();
		
		WebElement switchFrame = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchFrame);
		Thread.sleep(2000);
	}
	
	public void allergies() throws Exception {

		
		driver.findElement(allergiesOption).click();
		
		WebElement switchframe = driver.findElement(vitaldetailframe);
		CommonLib.frameSwitch(switchframe);
		
		driver.findElement(genericAllergies).click();
		Thread.sleep(3000);
		driver.findElement(genericAllergiesName).click();
		Thread.sleep(2000);
		driver.findElement(brandAllergies).click();
		Thread.sleep(2000);
		driver.findElement(brandAllergiesName).click();
		Thread.sleep(2000);
		String remark = CommonLib.readDataPropertyFile("ALLERGY_REMARK");
		driver.findElement(allergiesRemark).sendKeys(remark);
		driver.findElement(allergiesadd).click();
		Thread.sleep(2000);
	    WebElement other_allergy=driver.findElement(otherallergies);
	    Select otherAllergy=new Select(other_allergy);
	    otherAllergy.selectByVisibleText(CommonLib.readDataPropertyFile("OTHER_ALLERGY"));
		Thread.sleep(2000);
		driver.findElement(otherallergiesItem).sendKeys(CommonLib.readDataPropertyFile("OTHER_ALLERGY_TYPE"));
		Thread.sleep(2000);
	    driver.findElement(otherallergiesRemarks).sendKeys(CommonLib.readDataPropertyFile("OTHER_ALLERGY_REMARK"));
	    Thread.sleep(2000);
	    driver.findElement(otherallergiesadd).click();
	    Thread.sleep(2000);
		driver.findElement(allergiessave).click();
		
	}
	
}
