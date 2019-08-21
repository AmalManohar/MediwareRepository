package com.demo.mediware_appointment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class Run_appointment {
	
	WebDriver driver;
	@BeforeTest
	public void load() throws Exception{
		

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\leo\\workSpace\\amal\\Test\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://mediwarecloud.com/MediwareQC/login.aspx");
	}

}
