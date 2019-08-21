package com.demo.mediware_casuality;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Casuality_check {

	WebDriver driver;
	Casuality_check(WebDriver driver){
		this.driver=driver;
	}
	public void login_med() {
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys("dsoft");
		
		WebElement click=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		click.click();
		//assertTrue(driver.findElement(By.xpath("//img[@id='imgApp']")).isDisplayed());
	}
	public void application_sel() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Thread.sleep(3000);
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Application Selector']")));
		
		WebElement application_selector=driver.findElement(By.xpath("//img[@title='Application Selector']"));
		js.executeScript("arguments[0].click();",application_selector);
		//application_selector.click();
		
		WebElement switch_frame=driver.findElement(By.xpath("//iframe[@id='CallingPageDiv']"));
		driver.switchTo().frame(switch_frame);
		
		WebElement casuality_select=driver.findElement(By.xpath("//a[@href='Casualty/CasualtyHome.aspx']"));
		casuality_select.click();
		
		//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		Thread.sleep(3000);
		Select select=new Select(driver.findElement(By.id("CmbCounter")));
		select.selectByVisibleText("CASUALITY");
		
		WebElement button_select=driver.findElement(By.xpath("//span[text()='Select']"));
		button_select.click();
		
		WebElement menu_select=driver.findElement(By.id("divHomeMenu"));
		menu_select.click();
		
		//driver.findElement(By.xpath("//img[@id='btnDialogClose']")).click();
	}
	WebElement new_patient_id;
	public void register() throws Exception {
		WebDriverWait wait = getWait();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement reg_select=driver.findElement(By.xpath("//div[@id='CA004']"));
		reg_select.click();
		//new_patient_id=driver.findElement(By.xpath("//input[@id='txtPatientID']"));
		
		WebElement reg_switch_frame=driver.findElement(By.xpath("//iframe[@id='CallingPageDiv']"));
		driver.switchTo().frame(reg_switch_frame);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cmbtitle")));
		Select title_select=new Select(driver.findElement(By.id("cmbtitle")));
		title_select.selectByVisibleText("Mr");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("txtFirstName")).sendKeys("Ravi");
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("cmbGender")));
		Select gender_select=new Select(driver.findElement(By.id("cmbGender")));
		gender_select.selectByVisibleText("Male");
		
		 WebElement dob=driver.findElement(By.xpath("//input[@name='txtDOB']"));
		 dob.click();
		  
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='ui-datepicker-month']"))); Select month_select=new
		Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")) );
		month_select.selectByVisibleText("Mar");
		  
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='ui-datepicker-year']"))); Select year_select=new
		Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"))) ; 
		year_select.selectByVisibleText("1990");
		  
		Thread.sleep(2000);
		 
		driver.findElement(By.xpath("//a[text()='10']")).click();
		 
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cmbvisastat")));
		Select visa_select=new Select(driver.findElement(By.id("cmbvisastat")));
		visa_select.selectByVisibleText("UAE CITIZEN");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cmbCOR")));
		Select cor_select=new Select(driver.findElement(By.id("cmbCOR")));
		cor_select.selectByVisibleText("UAE");
		
		WebElement districts=driver.findElement(By.xpath("//input[@name='txtDistEmirates']"));
		districts.sendKeys("DUBAI");
		
		WebElement doctor=driver.findElement(By.id("RptRegistration_txtDoctor"));
		doctor.click();
		Thread.sleep(2000);
	    doctor.sendKeys(Keys.ARROW_DOWN);
	    Thread.sleep(2000);
	    Actions actions = new Actions(driver);
	    WebElement doctorName = driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
	    actions.doubleClick(doctorName).perform();
		
	    Thread.sleep(3000);
		
		WebElement session=driver.findElement(By.xpath("//input[@name='RptRegistration$ctl01$txtSession']"));
		session.click();
		Thread.sleep(2000);
		session.sendKeys(Keys.ARROW_DOWN);
	    Thread.sleep(2000);
	    Actions action = new Actions(driver);
	    WebElement sessionName = driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
	    actions.doubleClick(sessionName).perform();
	    Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='btnRegistration']")).click();
		
		driver.findElement(By.xpath("//input[@id='btnRegClose']")).click();
		Thread.sleep(6000);
	}
	
	public void patientSearch() throws Exception {
		driver.switchTo().defaultContent();
		String pID=null;
		List<WebElement> patientList = driver.findElements(By.xpath("//tbody//tr//td[@class='PendingPnt NewPnt ']"));                                                         
		//System.out.println(patientList);
		for(int i=0;i<patientList.size();i++) {
			
			pID= driver.findElement(By.xpath("(//tbody//tr//td[@class='PendingPnt NewPnt '])[last()]")).getText();
			System.out.println(pID);
			
			/*if(patientList.get(i).getText().equalsIgnoreCase("NH00000766")) {	
				 pID = patientList.get(i).getText();
				 System.out.println(pID);
			}	*/
		}
		WebElement menu1_select=driver.findElement(By.id("divHomeMenu"));
		menu1_select.click();
		Thread.sleep(2000);
		WebElement patient_search_select=driver.findElement(By.xpath("//div[@id='CAPSE']"));
		patient_search_select.click();
		Thread.sleep(2000);
		WebElement switch_frame1=driver.findElement(By.xpath("//iframe[@id='CallingPageDiv']"));
		driver.switchTo().frame(switch_frame1);
		System.out.println(pID);
		driver.findElement(By.xpath("//input[@id='txtSearchPatientID']")).sendKeys(pID);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='btnDialogClose']")).click();
			}	

	public WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	@AfterTest
	public void close_browser() throws InterruptedException {
		//Thread.sleep(2000);
		//driver.quit();
	}
}
