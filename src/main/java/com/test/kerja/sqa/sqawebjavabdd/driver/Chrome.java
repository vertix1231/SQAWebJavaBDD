package com.test.kerja.sqa.sqawebjavabdd.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {

	public WebDriver setStrategy() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "/src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("useAutomationExtension", false); //keluarkan sebagian fungsi yang tidak standar pada automation,kalau true semua
		options.addArguments("--no-sandbox");

		return new ChromeDriver(options);
	}

}
