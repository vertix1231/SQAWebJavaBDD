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
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	private WebElement adminTab;
	
	public void goToAdmin() {
	adminTab.click();
}
//	@FindBy(css = "#mainMenuFirstLevelUnorderedList > li")
//	private List<WebElement> btnMenu; 
//	
//	@FindBy(css = "#mainMenuFirstLevelUnorderedList > li.current.main-menu-first-level-list-item > ul > li")
//	private List<WebElement> lstMenuAdmin;
//	
//	@FindBy(id = "btnAdd")
//	private WebElement btnAdd;
//	
//	@FindBy(id = "nasionality_name")
//	private WebElement txtNasionalityName;
//	
//	@FindBy(id = "btnSave")
//	private WebElement btnSave;
//	
//	@FindBy(xpath = "//div[@class='message success fadable']")
//	private WebElement txtMessageSuccess;
//	
//	public void goToNasionalityPage() {
//		System.out.println(btnMenu.get(0).getText());
//		btnMenu.get(0).click();
//		System.out.println(lstMenuAdmin.get(4).getText());
//		lstMenuAdmin.get(4).click();
//	}
//	
//	public void clickAdd() {
//		btnAdd.click();
//	}
//	
//	public void inputNasionalityName(String nasionalityName) {		
//		txtNasionalityName.sendKeys(nasionalityName);
//		btnSave.click();
//	}
//	
//	public String getMessageSuccess() {
//		return txtMessageSuccess.getText();
//	}
}
