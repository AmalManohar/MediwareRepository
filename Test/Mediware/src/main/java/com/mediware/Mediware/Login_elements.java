package com.mediware.Mediware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login_elements extends Login{

	public WebElement login_username() throws Exception {
		WebElement username = driver.findElement(By.id(prop.getProperty("usernameId")));
		return username;
	}
	public WebElement login_button() throws Exception {
		WebElement button=driver.findElement(By.xpath(prop.getProperty("loginButton")));
		return button;
	}
}
