package com.mediware.Mediware;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VitalDetails extends Vitals{

	VitalDetails_elements elements;
	@Test
	public void apatientSelect() throws Exception {
		
		elements = new VitalDetails_elements();
		 Thread.sleep(2000);
		//String pID=null;
		//String patient_Id = patientId.getAttribute("value");
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
	}
	@Test
	public void bvitalClick() throws Exception {
		
		elements.vital_Click();


	}
	@Test
	public void c_enterDetails() throws Exception {
		WebElement vitalClose=elements.enterVitals();
		vitalClose.click();
	}
}
