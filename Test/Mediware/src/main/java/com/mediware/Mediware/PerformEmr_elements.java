package com.mediware.Mediware;

import static org.testng.Assert.assertTrue;


import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.demo.mediware_appointment.Appointment_check;

public class PerformEmr_elements extends PerformEmr{

	public WebElement selectDoctor() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("lblDocName")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("doctor_name"))));
	    WebElement doctor_name=driver.findElement(By.xpath(prop.getProperty("doctor_name")));
	    Thread.sleep(1000);
	    Actions actions = new Actions(driver);
	    actions.doubleClick(doctor_name).perform();
	    Thread.sleep(2000);
	    
	    Thread.sleep(2000);
		//String pID=null;
	    XSSFSheet sheet = workbook.getSheetAt(1);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		String patientid = ""+cell;
		List<WebElement> patientList = driver.findElements(By.xpath("//*[@id=\"tblOpWaiting\"]/tbody/tr/td"));                                                         
		for(int i=0;i<patientList.size();i++) {
			//pID= driver.findElement(By.xpath("(//*[@id=\"tblOpWaiting\"]/tbody/tr[3]/td[2])[last()]")).getText();
			//System.out.println(pID);
			if(patientList.get(i).getText().equalsIgnoreCase(patientid)) {	
				 patientList.get(i).click();
			}
		}
		assertTrue(driver.findElement(By.id("imgProdLogo")).isDisplayed());
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("callingpagediv")));
		driver.switchTo().frame(switch_frame);
		Thread.sleep(3000);
		WebElement pin=driver.findElement(By.xpath(prop.getProperty("pin")));
		pin.click();
		WebElement doctorNote=driver.findElement(By.xpath(prop.getProperty("doctorNote")));
		return doctorNote;
	}
	
	public WebElement notes_save() throws Exception {
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("divmainPage")));
		driver.switchTo().frame(switch_frame);
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath(prop.getProperty("chiefComplaints"))).isDisplayed());
		WebElement chiefcomplaints=driver.findElement(By.xpath(prop.getProperty("chiefComplaints")));
		chiefcomplaints.sendKeys("increasing temperature");
		WebElement historycomplaints=driver.findElement(By.xpath(prop.getProperty("historyComplaints")));
		historycomplaints.sendKeys("heavy fever");
		WebElement footer=driver.findElement(By.id("divFooterTools"));
		Actions action=new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(footer).build().perform();
		WebElement btnSave=driver.findElement(By.id("btSave"));
		return btnSave;
	}
	
	public WebElement select_diagnosis() throws Exception {
		//WebElement pin=driver.findElement(By.xpath("//div[@id='DivDialogTitle']//img"));
		//pin.click();
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("callingpagediv")));
		driver.switchTo().frame(switch_frame);
		Thread.sleep(3000);
		WebElement diagnosis=driver.findElement(By.id("WE018"));
		return diagnosis;
		
	}
	public WebElement enter_diagnosis() throws Exception {
		//Appointment_check objappointment=new  Appointment_check(driver);
		//WebDriverWait wait=objappointment.getWait();
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("divmainPage")));
		driver.switchTo().frame(switch_frame);
		Thread.sleep(2000);
		WebElement diagnosisName=driver.findElement(By.xpath(prop.getProperty("diagnosis_name")));
		diagnosisName.click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='rptItemSelection$ctl01$txtDiagnosis']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='(Idiopathic) normal pressure hydrocephalus']")).click();
		
		WebElement addbtn=driver.findElement(By.xpath("//input[@name='rptItemSelection$ctl01$imgAdd']"));
		addbtn.click();
		WebElement footer=driver.findElement(By.xpath("//div[@id='divFooterTools']"));
		Actions action=new Actions(driver);
		action.moveToElement(footer).build().perform();
		WebElement btnSave=driver.findElement(By.id("btSave"));
		return btnSave;
	}
	
	public WebElement select_investigation() throws Exception {
		//WebElement pin=driver.findElement(By.xpath("//div[@id='DivDialogTitle']//img"));
		//pin.click();
		Thread.sleep(2000);
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("callingpagediv")));
		driver.switchTo().frame(switch_frame);
		WebElement investigation=driver.findElement(By.id("WE014"));
		return investigation;
		
	}
	public WebElement enter_investigation() throws Exception {
		//Appointment_check objappointment=new  Appointment_check(driver);
		//WebDriverWait wait=objappointment.getWait();
		//WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("divmainPage")));
		//driver.switchTo().frame(switch_frame);
		Thread.sleep(2000);
		WebElement inv_add1=driver.findElement(By.xpath("//input[@id='grdItemSelection_btnAdd_0']"));
		inv_add1.click();
		Thread.sleep(3000);
		WebElement inv_add2=driver.findElement(By.xpath("//input[@id='grdItemSelection_btnAdd_1']"));
		inv_add2.click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='rptItemSelection$ctl01$txtDiagnosis']")));
		Thread.sleep(2000);
		WebElement footer=driver.findElement(By.xpath("//div[@id='divFooterTools']"));
		Actions action=new Actions(driver);
		action.moveToElement(footer).build().perform();
		WebElement btnSave=driver.findElement(By.id("btSave"));
		btnSave.click();
		
		driver.switchTo().defaultContent();
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("callingpagediv")));
		driver.switchTo().frame(switch_frame);
		Thread.sleep(2000);
		WebElement closeButton = driver.findElement(By.id("btnDialogClose"));
		return closeButton;
	}

}
