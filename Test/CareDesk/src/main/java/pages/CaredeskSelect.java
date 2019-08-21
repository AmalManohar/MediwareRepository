package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.CommonLib;

public class CaredeskSelect {

	WebDriver driver;
	By CareDeskIcon = By.xpath(CommonLib.readElementPropertyFile("CAREDESK_ICON_XPATH"));
	public CaredeskSelect(WebDriver driver) {
		this.driver = driver;
	}
	

	public void careDeskIconSelect() throws Exception {
		
		Thread.sleep(2000);
		driver.findElement(CareDeskIcon).click();
	}
}
