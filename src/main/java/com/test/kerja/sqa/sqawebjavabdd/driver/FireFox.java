package com.test.kerja.sqa.sqawebjavabdd.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox implements DriverStrategy {

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.geckodriver.driver", "D:/firefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
