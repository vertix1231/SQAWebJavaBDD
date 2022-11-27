package com.test.kerja.sqa.sqawebjavabdd.scenariopage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.sqawebjavabdd.driver.DriverSingleton;

public class AdminPage {

	private WebDriver driver;

	public AdminPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	private WebElement adminTab;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")
	private WebElement txtAdmiTabHighlight;

	public String getTxtAdmiTabHighlight() {
		return txtAdmiTabHighlight.getText();
	}

	public void goToAdmin() {
		adminTab.click();

	}

}
