package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.CommonLib;

public class AssesmentClick {

	WebDriver driver;
	By patientInfoFrame = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By assesmentSummaryOption = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_SUMMARY_OPTION_XPATH"));
	By assesmentSummaryFrame = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_SUMMARY_FRAME_XPATH"));
	By assesmentPrintButton1 = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_SUMMARY_PRINTBUTTON1_XPATH"));
	By assesmentPrintButton2 = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_SUMMARY_PRINTBUTTON2_XPATH"));
	By patientTreatmentSummary = By.xpath(CommonLib.readElementPropertyFile("PATIENT_TREATMENTSUMMARY_XPATH"));
	By patientAssesmentSummaryTest = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_SUMMARY_CLICKTEST_XPATH"));
	By patientAssesmentSummaryFrameTest = By.xpath(CommonLib.readElementPropertyFile("ASSESMENT_SUMMARY_FRAME_XPATH"));
	public AssesmentClick(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void assesmentClick() {
		// TODO Auto-generated method stub
		driver.switchTo().defaultContent();
		WebElement switch_frame = driver.findElement(patientInfoFrame);
		CommonLib.frameSwitch(switch_frame);	
		driver.findElement(assesmentSummaryOption).click();
		WebElement switchframe = driver.findElement(patientAssesmentSummaryFrameTest);
		CommonLib.frameSwitch(switchframe);
		System.out.println(driver.findElement(patientAssesmentSummaryTest).getText());
		assertTrue(driver.findElement(patientAssesmentSummaryTest).isDisplayed());
	}
	public void printAssesmentSummary() throws Exception {
		//WebElement switchframe = driver.findElement(assesmentSummaryFrame);
		//CommonLib.frameSwitch(switchframe);	
		Thread.sleep(2000);
		driver.findElement(assesmentPrintButton1).click();
		Thread.sleep(2000);
		assertTrue(driver.findElement(assesmentPrintButton1).isDisplayed());
		//driver.findElement(assesmentPrintButton2).click();
		driver.switchTo().defaultContent();
	}

}
