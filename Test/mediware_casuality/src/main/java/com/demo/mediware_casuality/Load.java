package com.demo.mediware_casuality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class Load {

	WebDriver driver;
	@BeforeTest
	public void load(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SE-MENTOR\\Desktop\\Test\\TestMaven\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://mediwarecloud.com/MediwareQC/login.aspx");
	}

}
