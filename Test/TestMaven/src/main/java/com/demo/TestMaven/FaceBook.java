package com.demo.TestMaven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FaceBook {
	WebDriver driver;
	@BeforeMethod
	public void load(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SE-MENTOR\\Desktop\\Test\\TestMaven\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	// TODO Auto-generated method stub
	
	@Test
	public void values_enter() {
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Amal");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("manohar");
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("amalmanohar55@gmail.com");
	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("amalmanohar55@gmail.com");
	
	}
	public void close_browser() {
		driver.quit();
	}

	
}
