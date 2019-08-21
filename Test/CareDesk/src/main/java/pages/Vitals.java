package pages;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import core.CommonLib;

public class Vitals {

	WebDriver driver;
	By vitalframe = By.xpath(CommonLib.readElementPropertyFile("PATIENT_INFO_FRAME_XPATH"));
	By vitaloption = By.xpath(CommonLib.readElementPropertyFile("VITAL_OPTION_XPATH"));
	By vitaldetailframe = By.xpath(CommonLib.readElementPropertyFile("VITAL_DETAILS_FRAME_XPATH"));
	By vitaltempfield = By.id(CommonLib.readElementPropertyFile("VITAL_TEMP_ID"));
	By vitalpulsefield = By.id(CommonLib.readElementPropertyFile("VITAL_PULSE_ID"));
	By vitalbp1field = By.id(CommonLib.readElementPropertyFile("VITAL_BP1_ID"));
	By vitalbp2field = By.id(CommonLib.readElementPropertyFile("VITAL_BP2_ID"));
	By vitalsavebutton = By.id(CommonLib.readElementPropertyFile("VITAL_SAVE_BUTTON_ID"));
	By vitalsTest = By.id(CommonLib.readElementPropertyFile("VITALS_SIGN_TEST_XPATH"));
	
	String vitalTemp = CommonLib.readDataPropertyFile("VITALTEMP");
	String vitalpulse = CommonLib.readDataPropertyFile("VITALPULSE");
	String vitalbp1 = CommonLib.readDataPropertyFile("VITALBP1");
	String vitalbp2 = CommonLib.readDataPropertyFile("VITALBP2");
	public Vitals(WebDriver driver) {
		this.driver = driver;
	}
	public void vitasClick() throws Exception {
		WebElement switch_frame=driver.findElement(vitalframe);
		CommonLib.frameSwitch(switch_frame);
		Thread.sleep(2000);
		WebElement vital = driver.findElement(vitaloption);
		vital.click();
		Thread.sleep(1000);

	}
	public void enterVitals() throws Exception {
		//Row row = sheet.getRow(10);
		//Cell year_select = row.getCell(1);
		WebElement switch_frame=driver.findElement(vitaldetailframe);
		CommonLib.frameSwitch(switch_frame);
		//System.out.println(driver.findElement(vitalsTest).getText());
		assertTrue(driver.findElement(vitaltempfield).isDisplayed());
		driver.findElement(vitaltempfield).sendKeys(vitalTemp);
		driver.findElement(vitalpulsefield).sendKeys(vitalpulse);
		driver.findElement(vitalbp1field).sendKeys(vitalbp1);
		driver.findElement(vitalbp2field).sendKeys(vitalbp2);
	
		Thread.sleep(1000);
		driver.findElement(vitalsavebutton).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		
	}
}
