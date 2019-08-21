package com.mediware.Mediware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EmrSelect extends Base{

	@Test
	public void emrSelect() throws Exception {
	
		EmrSelect_elements elements = new EmrSelect_elements();
		driver.switchTo().defaultContent();
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("application_icon"))));
		WebElement application = elements.application_select();
		application.click();
		Thread.sleep(1000);
		
		WebElement emrSelect = elements.emr();
		emrSelect.click();
	}
}
