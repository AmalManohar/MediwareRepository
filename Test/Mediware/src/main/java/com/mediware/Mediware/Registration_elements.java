package com.mediware.Mediware;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Registration_elements extends Registration{
	WebElement patient_id;
	
	public WebElement regClick() throws Exception {

		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("appointSlot"))));
		WebElement element = driver.findElement(By.xpath(prop.getProperty("appointSlot")));
		Actions action = new Actions(driver);
	    action.moveToElement(element).build().perform();
	    Thread.sleep(1000);
	    WebElement element2=driver.findElement(By.xpath(prop.getProperty("newRegTool")));
	    action.moveToElement(element2).build().perform();
	    Thread.sleep(1000);
	    WebElement new_reg=driver.findElement(By.xpath(prop.getProperty("regButton")));
	    return new_reg;
	}
	
	public WebElement date() throws InterruptedException, Exception {
		Row row3 = sheet.getRow(2);
		//Cell year_select = row3.getCell(1);
		//String year=""+year_select;
		int year= (int)workbook.getSheetAt(0).getRow(2).getCell(1).getNumericCellValue();
		String year1=""+year;
		Cell month_select=row3.getCell(2);
		String month=""+month_select;
		//Cell day_select=row3.getCell(3);
		//String day = ""+day_select;
		
		WebElement switch_frame=driver.findElement(By.xpath("//iframe[@id='AppointmentDiv']"));
		driver.switchTo().frame(switch_frame);
		Thread.sleep(2000);
		patientId = driver.findElement(By.xpath(prop.getProperty("patient_id")));
		String patient_Id = patientId.getAttribute("value");
		XSSFSheet sheet = workbook.getSheetAt(1);
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(1);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(patient_Id);
		FileOutputStream fileout = new FileOutputStream("C:\\Users\\sementor\\eclipse-workspace\\amal\\mediware_data.xlsx");
		workbook.write(fileout);
		fileout.close();
		
		//assertTrue(driver.findElement(By.xpath("//input[@id='txtDOB']")).isDisplayed());
		Thread.sleep(1000);
		WebElement dob=driver.findElement(By.xpath(prop.getProperty("date_of_birth")));
		dob.click();
		Thread.sleep(1000);
		
		WebElement dob_year=driver.findElement(By.xpath(prop.getProperty("year_select")));
		Select yearSelect=new Select(dob_year);
		yearSelect.selectByVisibleText(year1);
		
		WebElement dob_month=driver.findElement(By.xpath(prop.getProperty("month_select")));
		Thread.sleep(1000);
		Select monthSelect=new Select(dob_month);
		monthSelect.selectByVisibleText(month);
		Thread.sleep(2000);
		
		WebElement dob_date=driver.findElement(By.xpath(prop.getProperty("date_select")));
		return dob_date;	
	}
	
	public WebElement nationality() throws Exception {
		WebElement nationality=driver.findElement(By.xpath(prop.getProperty("nationality_select")));
		return nationality;
	}
	
	public WebElement emirates() throws Exception {
	    Thread.sleep(1000);
	    WebElement emirates_click=driver.findElement(By.xpath(prop.getProperty("emirates_select")));
	    return emirates_click;
	}
	
	public WebElement visastat() {
		
		WebElement visa_stat=driver.findElement(By.xpath(prop.getProperty("visaStat")));
		return visa_stat;
		
	}
	
	public WebElement cor() {

	    WebElement cor=driver.findElement(By.xpath(prop.getProperty("cor")));
	    return cor;

	}
	
	public WebElement foreigner() throws Exception {
	    WebElement na_emirates=driver.findElement(By.xpath(prop.getProperty("naEmirates")));
		na_emirates.click();
	    WebElement na_email=driver.findElement(By.xpath(prop.getProperty("naEmail")));
	    na_email.click();
		Thread.sleep(1000);
	    WebElement foreigner=driver.findElement(By.xpath("//a[@id='tab2']"));
	    return foreigner;
	}
	public WebElement passportNo() {
	    WebElement passport_no=driver.findElement(By.xpath(prop.getProperty("passport_no")));
	    return passport_no;
	}
	
	public WebElement passportExpiry() throws Exception {
		WebElement passport_expiry=driver.findElement(By.xpath(prop.getProperty("passport_expiry")));
	    passport_expiry.click();
	    
	    Row row10 = sheet.getRow(9);
		//Cell year_select = row10.getCell(1);
		//String year=""+year_select;
		int year= (int)workbook.getSheetAt(0).getRow(9).getCell(1).getNumericCellValue();
		String p_year=""+year;
		Cell month_select=row10.getCell(2);
		String month=""+month_select;
		//Cell day_select=row10.getCell(3);
		//String day=""+day_select;
	    
	    WebElement exp_year=driver.findElement(By.xpath(prop.getProperty("passport_expiry_year")));
		Select exp_year1=new Select(exp_year);
		exp_year1.selectByVisibleText(p_year);
		Thread.sleep(2000);
		
	    WebElement exp_month=driver.findElement(By.xpath(prop.getProperty("passport_expiry_month")));
	    Select exp_month1=new Select(exp_month);
		exp_month1.selectByVisibleText(month);
		Thread.sleep(2000);
		
	    WebElement exp_date=driver.findElement(By.xpath(prop.getProperty("passport_expiry_day")));
	    return exp_date;
	}
	
	public WebElement regConfirmation() throws Exception {
		WebElement btn_registration=driver.findElement(By.xpath(prop.getProperty("reg_button")));
	    btn_registration.click();
	    Thread.sleep(3000);
	    /*if(driver.findElement(By.xpath("//div[text()='Matching Record Found']")).isDisplayed()){
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ui-button-text' and text()='OK']")));
	    	WebElement okbtn1=  driver.findElement(By.xpath("//span[@class='ui-button-text' and text()='OK']"));
	    	okbtn1.click();
	    	
	    	Thread.sleep(2000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ui-button-text' and text()='OK']")));
	    	WebElement okbtn2 = driver.findElement(By.xpath("//span[@class='ui-button-text' and text()='OK']"));
	    	okbtn2.click();
	    	Thread.sleep(2000);
	    	btn_registration.click();
	    	
	    }*/
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("confirm_box"))));
	    WebElement confirm_box=driver.findElement(By.xpath(prop.getProperty("confirm_box")));
		confirm_box.click();
		Thread.sleep(1000);
		confirm_box=driver.findElement(By.xpath(prop.getProperty("confirm_box")));
		confirm_box.click();
		Thread.sleep(1000);
		confirm_box=driver.findElement(By.xpath(prop.getProperty("confirm_box")));
		return confirm_box;
	}
	
}
