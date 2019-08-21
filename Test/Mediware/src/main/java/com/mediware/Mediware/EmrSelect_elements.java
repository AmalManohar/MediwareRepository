package com.mediware.Mediware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmrSelect_elements extends Appointment_take_elements{

	public WebElement application_select() throws Exception {
		Appointment_take_elements elements=new Appointment_take_elements();
		WebElement application=elements.applicationSelector();
		return application;
	}
	
	public WebElement emr() throws Exception {
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("callingpagediv")));
		driver.switchTo().frame(switch_frame);
		WebElement emr_select=driver.findElement(By.xpath(prop.getProperty("emrSelect")));
		return emr_select;
	}
}
