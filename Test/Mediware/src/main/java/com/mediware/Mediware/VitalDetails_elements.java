package com.mediware.Mediware;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VitalDetails_elements extends VitalDetails{
	
	public void vital_Click() throws Exception {
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("label"))));
		WebElement menu_frame=driver.findElement(By.xpath(prop.getProperty("callingpagediv")));
		driver.switchTo().frame(menu_frame);
		Thread.sleep(2000);
		/*driver.findElement(By.xpath("(//img[@src='../Img/Pin.png' and @title='Click here to Pin'])[2]")).click();
		Thread.sleep(1000);*/
		WebElement vital = driver.findElement(By.xpath(prop.getProperty("vitalClick")));
		vital.click();
		Thread.sleep(1000);
		WebElement vital_frame=driver.findElement(By.xpath(prop.getProperty("divmainPage")));
		driver.switchTo().frame(vital_frame);
	}
	public WebElement enterVitals() throws Exception {
		//Row row = sheet.getRow(10);
		//Cell year_select = row.getCell(1);
		int temp= (int)workbook.getSheetAt(0).getRow(10).getCell(1).getNumericCellValue();
		String temp1=""+temp;
		assertTrue(driver.findElement(By.id("rptVitals1_txtTemp")).isDisplayed());
		driver.findElement(By.id("rptVitals1_txtTemp")).sendKeys(temp1);
		int bp1= (int)workbook.getSheetAt(0).getRow(11).getCell(1).getNumericCellValue();
		String bp_1=""+bp1;
		driver.findElement(By.id("rptVitals1_txtSbp")).sendKeys(bp_1);
		int bp2= (int)workbook.getSheetAt(0).getRow(12).getCell(1).getNumericCellValue();
		String bp_2=""+bp2;
		driver.findElement(By.id("rptVitals1_txtDbp")).sendKeys(bp_2);
		int weight= (int)workbook.getSheetAt(0).getRow(13).getCell(1).getNumericCellValue();
		String weightValue=""+weight;
		driver.findElement(By.id("rptVitals1_txtWeight")).sendKeys(weightValue);
		int height= (int)workbook.getSheetAt(0).getRow(14).getCell(1).getNumericCellValue();
		String heightValue=""+height;
		driver.findElement(By.id("rptVitals1_txtHeight")).sendKeys(heightValue);
		int wc= (int)workbook.getSheetAt(0).getRow(15).getCell(1).getNumericCellValue();
		String wcValue=""+wc;
		driver.findElement(By.id("rptVitals2_txtComp11")).sendKeys(wcValue);
		WebElement footer=driver.findElement(By.xpath(prop.getProperty("footer")));
		Actions action=new Actions(driver);
		action.moveToElement(footer).build().perform();
		driver.findElement(By.xpath(prop.getProperty("buttonSave"))).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		WebElement assesment=driver.findElement(By.id("CallingPageDiv"));
		driver.switchTo().frame(assesment);
		driver.findElement(By.xpath(prop.getProperty("clickToPin"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("preConsultButton"))).click();
		Thread.sleep(1000);
		WebElement buttonClose = driver.findElement(By.xpath(prop.getProperty("buttonClose")));
		return buttonClose;
	}

}
