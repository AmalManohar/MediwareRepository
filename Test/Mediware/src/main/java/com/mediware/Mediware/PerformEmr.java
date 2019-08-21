package com.mediware.Mediware;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PerformEmr extends Base{
	

	@Test
	public void doctorSelect() throws Exception {
		PerformEmr_elements elements = new PerformEmr_elements();
		WebElement doctor_note = elements.selectDoctor();
		doctor_note.click();
		
		WebElement noteSave = elements.notes_save();
		noteSave.click();
		
		driver.switchTo().defaultContent();
		
		WebElement diagnosis = elements.select_diagnosis();
		diagnosis.click();
		
		WebElement enterDiagnosis = elements.enter_diagnosis();
		enterDiagnosis.click();
		
		//WebElement selectInvest = elements.select_investigation();
		//selectInvest.click();
		
		
		
		WebElement enterInvest = elements.enter_investigation();
		enterInvest.click();
		
	}

}
