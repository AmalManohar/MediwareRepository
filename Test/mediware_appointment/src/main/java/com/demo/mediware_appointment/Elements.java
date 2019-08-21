package com.demo.mediware_appointment;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

	WebDriver driver;
	Properties prop=new Properties();
	WebElement switch_frame,salutation,first_name,mobile_number,confirm_check,new_ap,
	save_appointment,new_reg,dob,dob_year,dob_month,dob_date,nationality,sessionName,
	emirates_click,emiratesName,visa_stat,cor,na_emirates,na_email,foreigner,
	passport_no,passport_expiry,exp_year,exp_month,exp_date,btn_registration,confirm_box,demodatatemp,
	demodatabp1,demodatabp2,demodataweight,demodataheight,demodatawc,vital_frame,vital,caredesk_select,emr_select;
	public Elements(WebDriver driver) throws Exception {
		this.driver=driver;
		FileInputStream propFile=new FileInputStream("C:\\Users\\user\\Desktop\\leo\\workSpace\\amal\\Test\\mediware_appointment\\config.properties");
		prop.load(propFile);
	}
	
	public WebElement login() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys(prop.getProperty("userName"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		return loginbutton;
	}
	

	
	public WebElement application_selector() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Appointment_check objappointment=new  Appointment_check(driver);
		WebDriverWait wait=objappointment.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Application Selector']")));
		WebElement application_selector=driver.findElement(By.xpath("//img[@title='Application Selector']"));
		js.executeScript("arguments[0].click();",application_selector);
		switch_frame=driver.findElement(By.xpath("//iframe[@id='CallingPageDiv']"));
		driver.switchTo().frame(switch_frame);
		WebElement appointment_select=driver.findElement(By.xpath("//a[@href='AppointmentView.aspx']"));
		return appointment_select;
	}
	
	public WebElement hospitalSelect() {
		
		WebElement hospitalSelect=driver.findElement(By.xpath("//select[@name='cmbClinic']"));
		return hospitalSelect;
	}
	public WebElement next_button() throws Exception{
		Appointment_check obj = new Appointment_check(driver);
		WebDriverWait wait = obj.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNext")));
		WebElement button=driver.findElement(By.id("btnNext"));
		return button;
	}
	public WebElement appointment_take() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='AppNewSlot gray WCPer  NewEvent NewRegistration']"));
		action.moveToElement(element).build().perform();
		Thread.sleep(1000); 
		WebElement element2=driver.findElement(By.xpath("//img[@src='img/Down2.png']"));
        action.moveToElement(element2).build().perform();
        assertTrue(driver.findElement(By.xpath("//img[@src='img/Tool-Add.png']")).isDisplayed());
        Thread.sleep(1000);
        WebElement btn_click=driver.findElement(By.xpath("//img[@src='img/Tool-Add.png']"));
        return btn_click;
	}
	
	public void new_appointment() throws Exception {
		switch_frame=driver.findElement(By.xpath("//iframe[@id='AppointmentDiv']"));
		driver.switchTo().frame(switch_frame);
		salutation=driver.findElement(By.xpath("//select[@name='cmbSalutation']"));
		first_name=driver.findElement(By.id("txtFirstName"));
		mobile_number=driver.findElement(By.id("txtMobile"));
		confirm_check=driver.findElement(By.xpath("//input[@id='chkConfirm']"));
		new_ap=driver.findElement(By.xpath("//input[@id='rdonew']"));
		save_appointment=driver.findElement(By.xpath("//button[@id='btnSaveAppointment']"));
	}
	public WebElement reg() throws Exception {
		driver.switchTo().defaultContent();
		WebElement element = driver.findElement(By.xpath("//div[@class='AppEditSlot app WCPer Left50 W2 EditEvent NewRegistration' and text()=' - Asha']"));
		Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(1000);
        WebElement element2=driver.findElement(By.xpath("//div[@id='divAppTools']"));
        action.moveToElement(element2).build().perform();
        Thread.sleep(1000);
        new_reg=driver.findElement(By.xpath("//img[@title='New Registration']"));
        return new_reg;
	}
	
	public void new_registration() throws Exception{
		Appointment_check obj = new Appointment_check(driver);
		WebDriverWait wait = obj.getWait();
		
		switch_frame=driver.findElement(By.xpath("//iframe[@id='AppointmentDiv']"));
		driver.switchTo().frame(switch_frame);
		
		assertTrue(driver.findElement(By.xpath("//input[@id='txtDOB']")).isDisplayed());
		Thread.sleep(1000);
		dob=driver.findElement(By.xpath("//input[@id='txtDOB']"));
		dob.click();
		Thread.sleep(1000);
		
		WebElement dob_year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select year_select=new Select(dob_year);
		year_select.selectByVisibleText(obj.prop.getProperty("dobYear"));
		
		dob_month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Thread.sleep(1000);
		Select month_select=new Select(dob_month);
		month_select.selectByVisibleText(obj.prop.getProperty("dobMonth"));
		Thread.sleep(1000);
		
		dob_date=driver.findElement(By.xpath("//td[@data-year='1996']//a[text()=5]"));
		dob_date.click();
		nationality=driver.findElement(By.xpath("//input[@id='txtNationality']"));
		nationality.click();
		Thread.sleep(1000);
		nationality.sendKeys(prop.getProperty("nationality"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtNationality']")));
		nationality.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		
	    Thread.sleep(1000);
	    emirates_click=driver.findElement(By.xpath("//input[@id='txtDistEmirates']"));
	    emirates_click.click();
	    emirates_click.sendKeys(prop.getProperty("emirates"));
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtDistEmirates']")));
	    emirates_click.sendKeys(Keys.ARROW_DOWN);
	    emiratesName = driver.findElement(By.xpath("//*[@id=\"divDictionary\"]/ul/li/a"));
	    Thread.sleep(3000);
	    Actions actions = new Actions(driver);
	    actions.doubleClick(emiratesName).perform();
	    Thread.sleep(2000);
	    visa_stat=driver.findElement(By.xpath("//select[@name='cmbvisastat']"));
	    Select visa_status=new Select(visa_stat);
		visa_status.selectByVisibleText(prop.getProperty("visaStat"));
		Thread.sleep(1000);
	    cor=driver.findElement(By.xpath("//select[@name='cmbCOR']"));
	    Select cor1=new Select(cor);
		cor1.selectByVisibleText(prop.getProperty("countryOfResidence"));
		Thread.sleep(1000);
	    na_emirates=driver.findElement(By.xpath("//input[@id='chkNAEmiratesID']"));
		na_emirates.click();
	    na_email=driver.findElement(By.xpath("//input[@id='chkNAEmail']"));
	    na_email.click();
		Thread.sleep(1000);
	    foreigner=driver.findElement(By.xpath("//a[@id='tab2']"));
	    foreigner.click();
	    passport_no=driver.findElement(By.xpath("//input[@name='txtPassportNo']"));
	    passport_no.sendKeys(prop.getProperty("passportNo"));
	    passport_expiry=driver.findElement(By.xpath("//input[@name='txtExpDate']"));
	    passport_expiry.click();
	    exp_year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select exp_year1=new Select(exp_year);
		exp_year1.selectByVisibleText(prop.getProperty("expiryYear"));
		Thread.sleep(2000);
	    exp_month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	    Select exp_month1=new Select(exp_month);
		exp_month1.selectByVisibleText(prop.getProperty("expiryMonth"));
		Thread.sleep(2000);
	    exp_date=driver.findElement(By.xpath("//td[@data-year='2027']//a[text()='10']"));
	    exp_date.click();
	    btn_registration=driver.findElement(By.xpath("//input[@name='btnRegistration']"));
	    btn_registration.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='NO']")));
	    confirm_box=driver.findElement(By.xpath("//span[text()='NO']"));
		confirm_box.click();
		Thread.sleep(1000);
		confirm_box=driver.findElement(By.xpath("//span[text()='NO']"));
		confirm_box.click();
		Thread.sleep(1000);
		confirm_box=driver.findElement(By.xpath("//span[text()='NO']"));
		confirm_box.click();
	}
	public void caredesk() throws Exception {
		switch_frame=driver.findElement(By.xpath("//iframe[@id='CallingPageDiv']"));
		driver.switchTo().frame(switch_frame);
		caredesk_select=driver.findElement(By.xpath("//a[@href='CareDesk/CareDeskHome.aspx']"));
		caredesk_select.click();
		Thread.sleep(1000);
		
		
		String pID=null;
		List<WebElement> patientList = driver.findElements(By.xpath("//tbody//tr//td[@class='PendingPnt NewPnt ']"));                                                         
		for(int i=0;i<patientList.size();i++) {
			pID= driver.findElement(By.xpath("(//tbody//tr//td[@class='PendingPnt NewPnt '])[last()]")).getText();
			System.out.println(pID);
			if(patientList.get(i).getText().equalsIgnoreCase(pID)) {	
				 patientList.get(i).click();
			}
		}
		WebElement menu_frame=driver.findElement(By.xpath("//iframe[@id='CallingPageDiv']"));
		driver.switchTo().frame(menu_frame);
		vital=driver.findElement(By.xpath("//div[@id='CR001' and text()='Vitals']"));
		vital.click();
		vital_frame=driver.findElement(By.xpath("//iframe[@id='DivMainPage']"));
		driver.switchTo().frame(vital_frame);
		demodatatemp=driver.findElement(By.xpath("//input[@name='rptVitals1$ctl00$txtTemp']"));
		demodatabp1=driver.findElement(By.xpath("//input[@name='rptVitals1$ctl00$txtSbp']"));
		demodatabp2=driver.findElement(By.xpath("//input[@name='rptVitals1$ctl00$txtDbp']"));
		demodataweight=driver.findElement(By.xpath("//input[@name='rptVitals1$ctl00$txtWeight']"));
		demodataheight=driver.findElement(By.xpath("//input[@name='rptVitals1$ctl00$txtHeight']"));
		demodatawc=driver.findElement(By.xpath("//input[@name='rptVitals2$ctl00$txtComp11']"));
		
		
	}
	public void emr_select() throws Exception {
		Thread.sleep(2000);
		Appointment_check objappointment=new  Appointment_check(driver);
		WebDriverWait wait=objappointment.getWait();
		switch_frame=driver.findElement(By.xpath("//iframe[@id='CallingPageDiv']"));
		driver.switchTo().frame(switch_frame);
		emr_select=driver.findElement(By.xpath("//a[@href='EMR/DoctorHome.aspx']"));
		emr_select.click();
		//Thread.sleep(2000);
		driver.findElement(By.id("lblDocName")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='. Nsc Nurse']")));
	    WebElement doctor_name=driver.findElement(By.xpath("//a[text()='. Nsc Nurse']"));
	    Thread.sleep(1000);
	    Actions actions = new Actions(driver);
	    actions.doubleClick(doctor_name).perform();
	   
	    Thread.sleep(2000);
		String pID=null;
		List<WebElement> patientList = driver.findElements(By.xpath("//*[@id=\"tblOpWaiting\"]/tbody/tr/td"));                                                         
		for(int i=0;i<patientList.size();i++) {
			//pID= driver.findElement(By.xpath("(//*[@id=\"tblOpWaiting\"]/tbody/tr[3]/td[2])[last()]")).getText();
			//System.out.println(pID);
			if(patientList.get(i).getText().equalsIgnoreCase("NM00003820")) {	
				 patientList.get(i).click();
			}
		}
	}
	public WebElement doctor_note() {
		WebElement pin=driver.findElement(By.xpath("//div[@id='DivDialogTitle']//img"));
		pin.click();
		WebElement doctorNote=driver.findElement(By.xpath("//label[text()='Doctor Notes']"));
		return doctorNote;
	}
	public WebElement notes_save() throws Exception {
		WebElement chiefcomplaints=driver.findElement(By.xpath("//textarea[@name='rptComplaintExam$ctl01$txtDetails']"));
		chiefcomplaints.sendKeys("increasing temperature");
		WebElement historycomplaints=driver.findElement(By.xpath("//textarea[@name='rptComplaintExam$ctl02$txtDetails']"));
		historycomplaints.sendKeys("heavy fever");
		WebElement footer=driver.findElement(By.id("divFooterTools"));
		Actions action=new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(footer).build().perform();
		WebElement btnSave=driver.findElement(By.id("btSave"));
		return btnSave;
	}
	public WebElement select_diagnosis() {
		//WebElement pin=driver.findElement(By.xpath("//div[@id='DivDialogTitle']//img"));
		//pin.click();
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("CallingPageDiv")));
		driver.switchTo().frame(switch_frame);
		WebElement diagnosis=driver.findElement(By.id("WE018"));
		return diagnosis;
		
	}
	public WebElement enter_diagnosis() throws Exception {
		//Appointment_check objappointment=new  Appointment_check(driver);
		//WebDriverWait wait=objappointment.getWait();
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("DivMainPage")));
		driver.switchTo().frame(switch_frame);
		Thread.sleep(1000);
		WebElement diagnosisName=driver.findElement(By.xpath("//input[@name='rptItemSelection$ctl01$txtDiagnosis']"));
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
	public WebElement select_investigation() {
		//WebElement pin=driver.findElement(By.xpath("//div[@id='DivDialogTitle']//img"));
		//pin.click();
		WebElement switch_frame=driver.findElement(By.xpath(prop.getProperty("CallingPageDiv")));
		driver.switchTo().frame(switch_frame);
		WebElement investigation=driver.findElement(By.id("WE014"));
		return investigation;
		
	}
	public WebElement enter_investigation() throws Exception {
		Appointment_check objappointment=new  Appointment_check(driver);
		WebDriverWait wait=objappointment.getWait();
		WebElement inv_add1=driver.findElement(By.xpath("//input[@id='grdItemSelection_btnAdd_0']"));
		inv_add1.click();
		WebElement inv_add2=driver.findElement(By.xpath("//input[@id='grdItemSelection_btnAdd_1']"));
		inv_add2.click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='rptItemSelection$ctl01$txtDiagnosis']")));
		Thread.sleep(1000);
		WebElement footer=driver.findElement(By.xpath("//div[@id='divFooterTools']"));
		Actions action=new Actions(driver);
		action.moveToElement(footer).build().perform();
		WebElement btnSave=driver.findElement(By.id("btSave"));
		return btnSave;
	}
}
