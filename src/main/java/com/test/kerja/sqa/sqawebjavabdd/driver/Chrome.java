package com.test.kerja.sqa.sqawebjavabdd.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false); //keluarkan sebagian fungsi yang tidak standar pada automation,kalau true semua
		options.addArguments("--no-sandbox");

		return new ChromeDriver(options);
	}

}
