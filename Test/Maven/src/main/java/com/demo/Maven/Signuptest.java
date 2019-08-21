package com.demo.Maven;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signuptest {

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
	
	@Test(priority =1)
	public void values_enter() throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("gokul");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("sudheesh");
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("7306117894");
	WebElement element = driver.findElement(By.name("reg_email_confirmation__"));
	Thread.sleep(1000);
	if(element.isDisplayed()) {
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("7306117894");
	}
	
	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("kurupgokul");
	Select select=new Select(driver.findElement(By.id("day")));
	select.selectByVisibleText("5");
	select=new Select(driver.findElement(By.id("month")));
	select.selectByVisibleText("Feb");
	select=new Select(driver.findElement(By.id("year")));
	select.selectByVisibleText("1996");
	driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	assertFalse(driver.findElement(By.xpath("(//input[@type='radio'])[1]")).isSelected());
	assertFalse(driver.findElement(By.xpath("(//input[@type='radio'])[3]")).isSelected());
	driver.findElement(By.id("u_0_15")).click();
	}
	@AfterMethod
	public void close_browser() throws InterruptedException {
		Thread.sleep(2000);
		//driver.quit();
	}
	
}
