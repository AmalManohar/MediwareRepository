package com.mediware.Mediware;

import static org.testng.Assert.assertTrue;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appointment_take_elements extends Appointment_take{

	public WebElement applicationSelector() throws Exception {
		Thread.sleep(2000);
		WebDriverWait wait=getWait();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("application_icon"))));
		WebElement application_selector=driver.findElement(By.xpath(prop.getProperty("application_icon")));
		//js.executeScript("arguments[0].click();",application_selector);
		return application_selector;
		
	}	
	public WebElement appointment_click() {
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("callingpagediv")));
		driver.switchTo().frame(switch_frame);
		WebElement appointment_select=driver.findElement(By.xpath(prop.getProperty("appointment_icon")));
		return appointment_select;
		
	}
	public WebElement hospitalSelect() {
		WebElement hospitalSelect=driver.findElement(By.xpath(prop.getProperty("hospitalSelect")));
		return hospitalSelect;
	}
	public WebElement nextClick() {
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnNext")));
		 WebElement next = driver.findElement(By.id("btnNext"));
		 return next;
	}
	public WebElement appointment_take() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("newAppointmentSlot"))));
		WebElement element = driver.findElement(By.xpath(prop.getProperty("newAppointmentSlot")));
		action.moveToElement(element).build().perform();
		Thread.sleep(1000); 
		WebElement element2=driver.findElement(By.xpath(prop.getProperty("hoverDownArrow")));
        action.moveToElement(element2).build().perform();
        Thread.sleep(2000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("appointmentAddButton"))));
       // assertTrue(driver.findElement(By.xpath(prop.getProperty("appointmentAddButton"))).isDisplayed());
        WebElement btn_click=driver.findElement(By.xpath(prop.getProperty("appointmentAddButton")));
        return btn_click;
	}
	public WebElement add_appointment() throws Exception {
		Row row2 = sheet.getRow(1);
		Cell salutation = row2.getCell(1);
		String salute=""+salutation;
		Cell firstname=row2.getCell(2);
		String first_name=""+firstname;
		Cell mobile_no=row2.getCell(3);
		String mob_no=""+mobile_no;
		
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("appointmentDiv")));
		driver.switchTo().frame(switch_frame);
		assertTrue(driver.findElement(By.xpath(prop.getProperty("firstName"))).isDisplayed());
		WebElement Salutation=driver.findElement(By.xpath(prop.getProperty("salutation")));
		Select select=new Select(Salutation);
		select.selectByVisibleText(salute);
		Thread.sleep(1000);
		WebElement firstName=driver.findElement(By.id("txtFirstName"));
		firstName.sendKeys(first_name);
		Thread.sleep(1000);
		WebElement mobile_number=driver.findElement(By.id("txtMobile"));
		mobile_number.sendKeys(mob_no);
		WebElement confirm_check=driver.findElement(By.xpath(prop.getProperty("confirmCheck")));
		confirm_check.click();
		WebElement new_ap=driver.findElement(By.xpath(prop.getProperty("radioClick")));
		new_ap.click();
		WebElement save_appointment=driver.findElement(By.xpath(prop.getProperty("saveAppointment")));
		return save_appointment;
	}
}
