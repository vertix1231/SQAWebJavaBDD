package com.test.kerja.sqa.sqawebjavabdd.scenariopage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.sqawebjavabdd.driver.DriverSingleton;

public class DashboardPage {

	private WebDriver driver;

	public DashboardPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	@CacheLookup
	private WebElement dashboardproducttext;

	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
	@CacheLookup
	private List<WebElement> listProduct;

	@FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
	@CacheLookup
	private List<WebElement> listProductName;

	@FindBy(xpath = "//div[@class=\"inventory_item\"][1]//button[@class=\"btn btn_primary btn_small btn_inventory\"]")
	@CacheLookup
	private WebElement selectProduct;

	@FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
	@CacheLookup
	private WebElement shoppingCart;

	@FindBy(xpath = "//button[@id=\"checkout\"]")
	@CacheLookup
	private WebElement btnCheckout;

	@FindBy(xpath = "//input[@id=\"first-name\"]")
	@CacheLookup
	private WebElement formfnamecheckout;

	@FindBy(xpath = "//input[@id=\"last-name\"]")
	@CacheLookup
	private WebElement formlnamecheckout;

	@FindBy(xpath = "//input[@id=\"postal-code\"]")
	@CacheLookup
	private WebElement formcodecheckout;

	@FindBy(xpath = "//input[@id=\"continue\"]")
	@CacheLookup
	private WebElement btnContinueCheckout;

	@FindBy(xpath = "//button[@id=\"finish\"]")
	@CacheLookup
	private WebElement btnFinishCheckout;

	@FindBy(xpath = "//button[@class=\"btn btn_primary btn_small\"]")
	@CacheLookup
	private WebElement btnbackToDashboardHome;

	public String getdashboardproducttext() {
		return dashboardproducttext.getText();
	}

	public void checkMyShopingCart() {
		shoppingCart.click();
	}

	public void selectProducttoBuy(int n) {
		listProduct.get(n).click();
	}

	public void selectProducttoBuyAll() {
		for (int i = 0; i < listProduct.size(); i++) {
			listProduct.get(i).click();
		}
	}

	public void selectDinamicProducttoBuyName() {
		for (int i = 0; i < listProductName.size(); i++) {
			System.out.println(listProductName.get(i).getText());
		}
	}

	public void btnCheckout() {
		btnCheckout.click();
	}

	public void formCheckout(String fname, String lname, String code) {
		formfnamecheckout.sendKeys(fname);
		formlnamecheckout.sendKeys(lname);
		formcodecheckout.sendKeys(code);
		btnContinueCheckout.click();
	}

	public void finishCheckout() {
		btnFinishCheckout.click();
	}

	public void backhomedashboard() {
		btnbackToDashboardHome.click();
	}
}
