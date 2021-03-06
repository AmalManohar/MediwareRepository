package com.demo.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logintest {
	WebDriver driver;
	@BeforeMethod
	public void load(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SE-MENTOR\\Desktop\\Test\\TestMaven\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority=1)
	public void login_test() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("amalmanohar55@gmail.com");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("hunkamaroes");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		//driver.findElement(By.xpath("(//div[@class='notranslate _5rpu'])[1]")).sendKeys("this an automation testing");
	}
	
	@AfterMethod
	public void close_browser() throws InterruptedException {
		Thread.sleep(2000);
		//driver.quit();
	}

}
