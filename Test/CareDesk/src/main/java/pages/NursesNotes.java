package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.CommonLib;

public class NursesNotes {

	WebDriver driver;
	By assesmentnentry = By.id(CommonLib.readElementPropertyFile("ASSESMENTENTRY_OPTION_ID"));
	By vitaldetailframe = By.xpath(CommonLib.readElementPropertyFile("VITAL_DETAILS_FRAME_XPATH"));
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By chiefcomplaintId = By.id(CommonLib.readElementPropertyFile("ASSESMENTENTRY_CHIEFCOMPLAINT_ID"));
	By nursesnotesId = By.id(CommonLib.readElementPropertyFile("ASSESMENTENTRY_NURSESNOTES_ID"));
	By pasthistoryId = By.id(CommonLib.readElementPropertyFile("ASSESMENTENTRY_PASTHISTORY_ID"));
	By familyhistoryId = By.id(CommonLib.readElementPropertyFile("ASSESMENTENTRY_FAMILYHISTORY_ID"));
	By arrivalmode = By.xpath(CommonLib.readElementPropertyFile("ASSESMENTENTRY_ARRIVALENTRY_ID"));
	By accompaniedby = By.xpath(CommonLib.readElementPropertyFile("ASSESMENTENTRY_ACCOMPANIED_ID"));
	By waitingtime = By.xpath(CommonLib.readElementPropertyFile("ASSESMENTENTRY_WAITINGTIME_ID"));
	By assesmentsave = By.id(CommonLib.readElementPropertyFile("ASSESMENTENTRY_SAVE_ID"));
	
	By psychosocialtab = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_TAB_ID"));
	By livingwith = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_LIVINGWITHFIELD_ID"));
	By relationship = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_RELATIONSHIP_ID"));
	By siblings = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_SIBLINGS_ID"));
	By fatherjob = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_FATHERSJOB_ID"));
	By educationneeded = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_EDUCATIONNEEDED_XPATH"));
	By smoking = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_SMOKING_XPATH"));
	By smokingnumber = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_SMOKING_NUMBER_ID"));
	By alocoholic = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_ALCOHOLIC_XPATH"));
	By alocoholicquantity = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_ALCOHOLIC_QUANTITY_ID"));
	By saveButton = By.id(CommonLib.readElementPropertyFile("ASSESMENT_PSYCHOSOCIAL_SAVE_BUTTON_ID"));
	
	By painAssesmentTab = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_TAB_ID"));
	By painAssesmentPresencePain = By.xpath(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_PRESENCEOFPAIN_XPATH"));
	By painScore = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_PAINSCORE_ID"));
	By painAsses = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_PAINASSES_ID"));
	By painIntensity = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_PAININTENSITY_ID"));
	By painFrequency = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_PAINFREQUENCY_ID"));
	By painCharacter = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_PAINCHARACTER_ID"));
	By Character = By.xpath(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_CHARACTER_XPATH"));
	By painDuration = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_PAINDURATION_ID"));
	By painAdd = By.id(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_ADD_BTN_ID"));
	By intensity = By.xpath(CommonLib.readElementPropertyFile("PAIN_ASSESMENT_INTENSITY_XPATH"));
	By painNutritionalFunctionalCheckBox = By.xpath(CommonLib.readElementPropertyFile("PAIN_NUTRITIONAL_FUNCTIONAL_CHECKBOX_XPATH"));
	By nutritionalTab = By.id(CommonLib.readElementPropertyFile("PAIN_NUTRITIONAL_FUNCTIONAL_TAB_ID"));
	By painNutritionalFunctionalTextField = By.xpath(CommonLib.readElementPropertyFile("PAIN_NUTRITIONAL_FUNCTIONAL_TEXT_FIELD_XPATH"));
	By painNutritionalFunctionalSave = By.id(CommonLib.readElementPropertyFile("PAIN_NUTRITIONAL_FUNCTIONAL_SAVE_BTN_ID"));
	
	By pediatricAssesmentTab = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_TAB_ID"));
	By pediatricAssesmentSocialSmile = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_SOCIALSMILE_ID"));
	By pediatricAssesmentTeethingStart = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_TEETHINGSTART_ID"));
	By pediatricAssesmentSatAlone = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_SATALONE_ID"));
	By pediatricAssesmentWalkedAlone = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_WALKEDALONE_ID"));
	By pediatricAssesmentUsedWords = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_USEDWORDS_ID"));
	By pediatricAssesmentUsedSentences = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_USEDSENTENCES_ID"));
	By pediatricAssesmentTotalTraining = By.id(CommonLib.readElementPropertyFile("PEDIATRIC_ASSESMENT_TOTALTRAINING_ID"));
	By data = By.xpath(CommonLib.readElementPropertyFile("DATA_XPATH"));
	
	By medicationproceduresTab = By.id(CommonLib.readElementPropertyFile("MEDICATION_PROCEDURES_TAB_ID"));
	By lastTetanus = By.id(CommonLib.readElementPropertyFile("MEDICATION_PROCEDURES_LAST_TETANUS_ID"));
	By lastTetanusDate = By.id(CommonLib.readElementPropertyFile("MEDICATION_PROCEDURES_LAST_TETANUS_DATE_FIELD_ID"));
	By lastTetanusDateMonth = By.xpath(CommonLib.readElementPropertyFile("MEDICATION_PROCEDURES_LAST_TETANUS_DATE_FIELD_MONTH_XPATH"));
	By lastTetanusday = By.xpath(CommonLib.readElementPropertyFile("MEDICATION_PROCEDURES_LAST_TETANUS_DAY_XPATH"));
	
	By lastTetanusProcedures = By.id(CommonLib.readElementPropertyFile("MEDICATION_PROCEDURES_LAST_TETANUS_PROCEDURES_ID"));
	By lastTetanusProceduresAdd = By.id(CommonLib.readElementPropertyFile("MEDICATION_PROCEDURES_LAST_TETANUS_PROCEDURES_ADD_BTN_ID"));
	By save_Button = By.id(CommonLib.readElementPropertyFile("SAVE_BTN_ID"));
	
	By emergencyTab = By.id(CommonLib.readElementPropertyFile("EMERGENCY_TAB"));
	By emergencyTriage = By.id(CommonLib.readElementPropertyFile("EMERGENCY_TRIAGE_CHKBOX_ID"));
	By emergencyAssesmentchkbox1 = By.id(CommonLib.readElementPropertyFile("EMERGENCY_NEUROLOGICAL_ASSESMENT_CHKBOX1_ID"));
	By emergencyAssesmentchkbox2 = By.id(CommonLib.readElementPropertyFile("EMERGENCY_NEUROLOGICAL_ASSESMENT_CHKBOX2_ID"));
	By emergencyAssesmentEyesopen = By.id(CommonLib.readElementPropertyFile("EMERGENCY_EYESOPENING_ID"));
	By medicationproceduresMotor = By.id(CommonLib.readElementPropertyFile("EMERGENCY_MOTOR_ID"));
	By medicationproceduresVerbal = By.id(CommonLib.readElementPropertyFile("EMERGENCY_VERBAL_ID"));
	By medicationproceduresGcs = By.id(CommonLib.readElementPropertyFile("EMERGENCY_GCS_ID"));
	By medicationproceduresChangesnoted = By.id(CommonLib.readElementPropertyFile("EMERGENCY_CHANGESNOTED_ID"));
	By medicationproceduresRespiration = By.id(CommonLib.readElementPropertyFile("EMERGENCY_RESPIRATION_ID"));
	By medicationproceduresBreathsound = By.id(CommonLib.readElementPropertyFile("EMERGENCY_BREATHSOUNDS_ID"));
	
	By newAssesmentbtn = By.id(CommonLib.readElementPropertyFile("NEW_ASSESMENT_BTN_ID"));
	//By previousbtn = By.id(CommonLib.readElementPropertyFile("PREVIOUS_BTN_ID"));
	By previousbtn = By.xpath(CommonLib.readElementPropertyFile("PREVIOUS_BTN_XP"));
	By closebtn = By.id(CommonLib.readElementPropertyFile("CLOSE_BTN_ID"));
	
	public NursesNotes(WebDriver driver)
	{
		this.driver=driver;
	}
	public void assesmentEnteryclick() throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement switchframe = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchframe);
		driver.findElement(assesmentnentry).click();
		WebElement switchFrame = driver.findElement(vitaldetailframe);
		CommonLib.frameSwitch(switchFrame);
		Thread.sleep(2000);
	}
	public void nursesNotes() throws Exception {

		driver.findElement(chiefcomplaintId).clear();
		driver.findElement(nursesnotesId).clear();
		driver.findElement(pasthistoryId).clear();
		driver.findElement(familyhistoryId).clear();
		driver.findElement(chiefcomplaintId).sendKeys(CommonLib.readDataPropertyFile("CHIEF_COMPLAINT"));
		Thread.sleep(2000);
		driver.findElement(nursesnotesId).sendKeys(CommonLib.readDataPropertyFile("NURSES_NOTES"));
		Thread.sleep(2000);
		driver.findElement(pasthistoryId).sendKeys(CommonLib.readDataPropertyFile("PAST_HISTORY"));
		Thread.sleep(2000);
		driver.findElement(familyhistoryId).sendKeys(CommonLib.readDataPropertyFile("FAMILY_HISTORY"));
		Thread.sleep(2000);
		driver.findElement(arrivalmode).click();
		driver.findElement(accompaniedby).click();
		driver.findElement(waitingtime).click();
		driver.findElement(assesmentsave).click();
		Thread.sleep(2000);
		
	}
	public void psychosocial() throws Exception {

		driver.findElement(psychosocialtab).click();
		
		driver.findElement(livingwith).clear();
		driver.findElement(relationship).clear();
		driver.findElement(siblings).clear();
		driver.findElement(fatherjob).clear();
		//driver.findElement(educationneeded).;
		//driver.findElement(alocoholic).click();
		Thread.sleep(2000);
		
		driver.findElement(livingwith).sendKeys(CommonLib.readDataPropertyFile("LIVINGWITH"));
		driver.findElement(relationship).sendKeys(CommonLib.readDataPropertyFile("RELATIONSHIP"));
		driver.findElement(siblings).sendKeys(CommonLib.readDataPropertyFile("SIBLINGS"));
		driver.findElement(fatherjob).sendKeys(CommonLib.readDataPropertyFile("FATHERS_JOB"));
		while(true)
		{
		if(driver.findElement(By.id("ChkEducation")).isSelected()) {
			break;
		}
		else {
			driver.findElement(educationneeded).click();
		}
		}
		if(driver.findElement(By.id("chkSmoking")).isSelected())
		{
			driver.findElement(smokingnumber).clear();
			driver.findElement(smokingnumber).sendKeys(CommonLib.readDataPropertyFile("CIG_NO"));
		}
		else {
			driver.findElement(smoking).click();
			Thread.sleep(2000);
			driver.findElement(smokingnumber).clear();
			driver.findElement(smokingnumber).sendKeys(CommonLib.readDataPropertyFile("CIG_NO"));
		}

		Thread.sleep(2000);
		if(driver.findElement((By.id("chkAlcoholic"))).isSelected())
		{
			driver.findElement(alocoholicquantity).clear();
			driver.findElement(alocoholicquantity).sendKeys(CommonLib.readDataPropertyFile("ALCOHOL"));
		}
		else {
			driver.findElement(alocoholic).click();
			Thread.sleep(2000);
			driver.findElement(alocoholicquantity).clear();
			driver.findElement(alocoholicquantity).sendKeys(CommonLib.readDataPropertyFile("ALCOHOL"));
		}

		Thread.sleep(2000);
		driver.findElement(saveButton).click();
	}
	public void painAssesment() throws Exception {
		Thread.sleep(2000);
		driver.findElement(painAssesmentTab).click();
		Thread.sleep(2000);
		driver.findElement(painAssesmentPresencePain).click();
		driver.findElement(painScore).click();
		driver.findElement(painAsses).sendKeys(CommonLib.readDataPropertyFile("LOCATION"));
		driver.findElement(painIntensity).click();
		driver.findElement(intensity).click();
		driver.findElement(painFrequency).sendKeys(CommonLib.readDataPropertyFile("FREQUENCY"));
		driver.findElement(painCharacter).click();
		driver.findElement(Character).click();
		driver.findElement(painDuration).sendKeys(CommonLib.readDataPropertyFile("DURATION"));
		driver.findElement(painAdd).click();
	}
	
	public void nutritionalAndFunctionalAssesment() throws Exception {
		Thread.sleep(2000);
		driver.findElement(nutritionalTab).click();
		Thread.sleep(2000);
		List<WebElement> checkBoxList = CommonLib.getList(painNutritionalFunctionalCheckBox);
		int listSize = checkBoxList.size();
		for(int i = 0;i<listSize;i++) {
			if(checkBoxList.get(i).isSelected()) {
			//Thread.sleep(1000);
				break;
			}
			else {
				checkBoxList.get(i).click();
			}
			
		}
		List<WebElement> textFieldList = CommonLib.getList(painNutritionalFunctionalTextField);
		int textFieldListSize = textFieldList.size();
		for(int i = 0;i<textFieldListSize;i++) {
			//Thread.sleep(1000);
			if(textFieldList.get(i).getText().equalsIgnoreCase(""))
			{
			textFieldList.get(i).sendKeys(CommonLib.readDataPropertyFile("TEXTFIELD_DEMO_VALUE"));
			}
			else {
				break;
			}
		}
		driver.findElement(painNutritionalFunctionalSave).click();
	}
	public void pediatricAssesment() throws Exception {
		Thread.sleep(2000);
		driver.findElement(pediatricAssesmentTab).click();
		Thread.sleep(3000);
		//driver.findElement(pediatricAssesmentSocialSmile).click();
		Select select = new Select(driver.findElement(pediatricAssesmentSocialSmile));
		select.selectByValue("2");
		
		select = new Select(driver.findElement(pediatricAssesmentTeethingStart));
		select.selectByValue("2");
		
		select = new Select(driver.findElement(pediatricAssesmentSatAlone));
		select.selectByValue("2");
		
		select = new Select(driver.findElement(pediatricAssesmentWalkedAlone));
		select.selectByValue("2");
		
		select = new Select(driver.findElement(pediatricAssesmentUsedWords));
		select.selectByValue("2");
		
		select = new Select(driver.findElement(pediatricAssesmentUsedSentences));
		select.selectByValue("2");
		
		select = new Select(driver.findElement(pediatricAssesmentTotalTraining));
		select.selectByValue("2");
		
		driver.findElement(painNutritionalFunctionalSave).click();
	}
	
	public void medicationprocedures() throws Exception {
		Thread.sleep(2000);
		driver.findElement(medicationproceduresTab).click();
		Thread.sleep(2000);
		driver.findElement(lastTetanus).click();
		
		driver.findElement(lastTetanusDate).click();
		//driver.findElement(lastTetanusDateMonth).click();
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(lastTetanusDateMonth));
		select.selectByValue("4");
		driver.findElement(lastTetanusday).click();
		Thread.sleep(2000);
		select = new Select(driver.findElement(lastTetanusProcedures));
		select.selectByValue("K616");
		Thread.sleep(2000);
		driver.findElement(lastTetanusProceduresAdd).click();
		driver.findElement(save_Button).click();
	}
	public void emergency() throws Exception {
		Thread.sleep(2000);
		driver.findElement(emergencyTab).click();
		Thread.sleep(1000);
		while(true) {
			if(driver.findElement(emergencyTriage).isSelected())
			{
				break;
			}
			else {
				driver.findElement(emergencyTriage).click();
				Thread.sleep(1000);
				driver.findElement(emergencyAssesmentchkbox1).click();
				driver.findElement(emergencyAssesmentchkbox2).click();
				driver.findElement(medicationproceduresChangesnoted).click();
				Thread.sleep(1000);
				driver.findElement(medicationproceduresRespiration).click();
				driver.findElement(medicationproceduresBreathsound).click();
				Thread.sleep(1000);
			}
		}
		
		
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(emergencyAssesmentEyesopen));
		Thread.sleep(1000);
		select.selectByValue("4");
		
		select = new Select(driver.findElement(medicationproceduresMotor));
		Thread.sleep(1000);
		select.selectByValue("6");
		
		select = new Select(driver.findElement(medicationproceduresVerbal));
		Thread.sleep(1000);
		select.selectByValue("3");
		driver.findElement(medicationproceduresGcs).clear();
		driver.findElement(medicationproceduresGcs).sendKeys(CommonLib.readDataPropertyFile("EMERGENCY_GCS"));
		

		driver.findElement(save_Button).click();
	}
	public void newAssesment() throws Exception {
		Thread.sleep(2000);
		WebElement newAssesment = driver.findElement(newAssesmentbtn);
		 CommonLib.highLighterMethod(driver,newAssesment);
		//driver.findElement(newAssesmentbtn).click();
	}
	public void goToPrevious() throws Exception {
		
		WebElement previous = driver.findElement(previousbtn);
		 //CommonLib.highLighterMethod(driver,previous);
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", previous);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement switchFrame = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switchFrame);
		Thread.sleep(2000);
		driver.findElement(closebtn).click();
	}
}
