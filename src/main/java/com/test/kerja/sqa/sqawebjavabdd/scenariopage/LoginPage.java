package com.test.kerja.sqa.sqawebjavabdd.scenariopage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.sqawebjavabdd.driver.DriverSingleton;

public class LoginPage {

	private WebDriver driver;

	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div/div[1]")
	@CacheLookup
	private WebElement txtLoginHighlight;

	@FindBy(css = "#user-name")
	@CacheLookup
	private WebElement txtUsername;

	@FindBy(css = "#password")
	@CacheLookup
	private WebElement txtPassword;

	@FindBy(xpath = "//*[@id=\"login-button\"]")
	@CacheLookup
	private WebElement btnSignin;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
	@CacheLookup
	private WebElement tvdashboard;

	public String getTxtLoginHighlight() {
		return txtLoginHighlight.getText();
	}

	public String getTvdashboard() {
		return tvdashboard.getText();
	}

	public void goToSignin(String email, String password) {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,100)");
		txtUsername.sendKeys(email);
		txtPassword.sendKeys(password);
		btnSignin.click();
	}

//
//	public String getTxtLoginHighlight() {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		String title = jse.executeScript("document.getElementsByClassName('login_logo');").toString();
//		return title;
//	}
}
