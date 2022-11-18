package com.test.kerja.sqa.sqawebjavabdd.scenariopage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.kerja.sqa.sqawebjavabdd.driver.DriverSingleton;

public class KerjaOneScenarioPage {
	private WebDriver driver;//deklarasi driver

	public KerjaOneScenarioPage() {

		this.driver = DriverSingleton.getDriver();//getdriver
		PageFactory.initElements(driver, this);//untuk kelola test per page agar bisa men-locate tiap element pada page
	}

	@FindBy(xpath = "//*[@id=\"site-header\"]/div/div[2]/div/div[3]/ul/li[7]/button")
	private WebElement searchBtn;
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[1]/div/div[2]/div/button")
	private WebElement acceptCachebtn;
	//*[@id="search-input--desktop"]
	@FindBy(css = "#search-input--desktop")
	private WebElement inputArticle;
	@FindBy(xpath="//*[@id=\"site-header\"]/div/div[2]/div/div[3]/ul/li[7]/div/div/div[1]/div[2]/div[1]/article[1]/a")
	private WebElement goToArticleSelected;
	@FindBy(xpath="//*[@id=\"site-header\"]/div/div[2]/div/div[3]/ul/li[7]/div/div/div[1]/div[2]/div[1]/article[1]/a")
	private WebElement verifyTextCustomerSolution;

	public String getVerifyTextCustomerSolution() {
		sleepAction();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(verifyTextCustomerSolution));
		System.out.println(verifyTextCustomerSolution.getText());
		return verifyTextCustomerSolution.getText();
	}

	public void clickSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchBtn.click();
	}

	public void inputArticleTitle(String search) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(acceptCachebtn));
		acceptCachebtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputArticle));
		inputArticle.click();
		inputArticle.sendKeys(search.toLowerCase());
		sleepAction();
	}
	
	public void verifyCostumerSolutionArticle() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(goToArticleSelected));
		sleepAction();
		goToArticleSelected.click();

	}
	private void sleepAction() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
