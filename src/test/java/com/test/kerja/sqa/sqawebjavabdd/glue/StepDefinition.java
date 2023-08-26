package com.test.kerja.sqa.sqawebjavabdd.glue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.kerja.sqa.sqawebjavabdd.config.AutomationFrameworkConfiguration;
import com.test.kerja.sqa.sqawebjavabdd.driver.DriverSingleton;
import com.test.kerja.sqa.sqawebjavabdd.scenariopage.DashboardPage;
import com.test.kerja.sqa.sqawebjavabdd.scenariopage.LoginPage;
import com.test.kerja.sqa.sqawebjavabdd.utils.ConfigurationProperties;
import com.test.kerja.sqa.sqawebjavabdd.utils.ConstantsParam;
import com.test.kerja.sqa.sqawebjavabdd.utils.ScenarioTestCases;
import com.test.kerja.sqa.sqawebjavabdd.utils.UtilsTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	private static WebDriver driver;
	private ExtentTest extentTest;
	static ExtentReports extentReports = new ExtentReports();
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/test/resources/reporttest_testkerja.html");
	private static LoginPage loginPage;
	private static DashboardPage dashboardPage;

//start WEB TEST KERJA---------------------------------------------------------------------------------------------------------------------

//MULAI TESTSTING TEST KERJA-------------------------------------------------------------------------------------------------------------------
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void workSetUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		driver = DriverSingleton.getDriver();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		extentReports.attachReporter(htmlreporter);
		ScenarioTestCases[] tests = ScenarioTestCases.values();
		extentTest = extentReports.createTest(tests[UtilsTest.scenariotestcount].getScenarioTestName());
		UtilsTest.scenariotestcount++;
	}

//---------------------------------------------------------------------------------------------------------------------

	@Given("^Navigation to : Main Web Login")
	public void workZero() throws IOException {
		driver.get(ConstantsParam.URL_MAIN_WEB);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (loginPage.getTxtLoginHighlight().contains(configurationProperties.getLoginhighlightexpected())) {
			System.out.println("Navigation to : " + ConstantsParam.URL_MAIN_WEB + " pass");
			System.out.println(loginPage.getTxtLoginHighlight());
			System.out.println(configurationProperties.getLoginhighlightexpected());
			extentTest.log(Status.PASS, "Navigation to : " + ConstantsParam.URL_MAIN_WEB);
			extentTest.pass("Navigation to : " + ConstantsParam.URL_MAIN_WEB,
					MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		} else {
			System.out.println("Navigation to : " + ConstantsParam.URL_MAIN_WEB + " fail");
			extentTest.log(Status.FAIL, "Navigation to : " + ConstantsParam.URL_MAIN_WEB);
			extentTest.fail("Navigation to : " + ConstantsParam.URL_MAIN_WEB,
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}

	}

	@When("^input username (.*) and password (.*) to login to web")
	public void workOne(String username, String pass) throws IOException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.goToSignin(username, pass);
		System.out.println("input "+username+" and "+pass+" to login to web pass");
		extentTest.log(Status.PASS, "input "+username+" and "+pass+" to login to web pass");
		extentTest.pass("input "+username+" and "+pass+" to login to web pass",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("^enter dashboard page")
	public void workTwo() throws IOException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(configurationProperties.getDashboardproducttext());
		System.out.println(dashboardPage.getdashboardproducttext());

		if (dashboardPage.getdashboardproducttext().contains(configurationProperties.getDashboardproducttext())) {
			System.out.println("scenario enter dashboard page pass");
			extentTest.log(Status.PASS, "enter dashboard page pass");
			System.out.println("scenario enter dashboard page pass");
			extentTest.log(Status.PASS, "enter dashboard page pass");
			extentTest.pass("succesfully enter dashboard page pass",
					MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		} else {
			System.out.println("scenario enter dashboard page fail");
			extentTest.log(Status.PASS, "enter dashboard page fail");
			extentTest.fail("succesfully enter dashboard page fail",
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}

	}

	@Given("^In the dashboard page")
	public void workThree() throws IOException {
		System.out.println("scenario In the dashboard page pass");
		extentTest.log(Status.PASS, "In the dashboard page");
		extentTest.pass("In the dashboard page pass",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@When("^Click Add to Chart One of Products in Dashboard Product")
	public void workFour() throws IOException {
		dashboardPage.selectProducttoBuy(2);
//		dashboardPage.selectProducttoBuyAll();
		dashboardPage.selectDinamicProducttoBuyName();
		System.out.println("Scenario Click Add to Chart One of Products in Dashboard Product pass");
		extentTest.log(Status.PASS, "Click Add to Chart One of Products in Dashboard Product");
	}
	
	@When("^Click Add to Chart All of Products in Dashboard Product")
	public void workEleven() throws IOException {
//		dashboardPage.selectProducttoBuy(2);
		dashboardPage.selectProducttoBuyAll();
		dashboardPage.selectDinamicProducttoBuyName();
		System.out.println("Scenario Click Add to Chart All of Products in Dashboard Product pass");
		extentTest.log(Status.PASS, "Click Add to Chart All of Products in Dashboard Product");
	}

	@When("^Click Shopping Cart Icon with Number at The Right Top Corner")
	public void workFive() throws IOException {
		dashboardPage.checkMyShopingCart();
		System.out.println("Scenario Click Shopping Cart Icon with Number at The Right Top Corner pass");
		extentTest.log(Status.PASS, "Click Shopping Cart Icon with Number at The Right Top Corner");
		extentTest.pass("Click Shopping Cart Icon with Number at The Right Top Corner pass",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@When("^Click Checkout Shoping Cart")
	public void workSix() throws IOException {
		dashboardPage.btnCheckout();
		System.out.println("Scenario Click Checkout Shoping Cart pass");
		extentTest.log(Status.PASS, "Click Checkout Shoping Cart");
		extentTest.pass("Click Checkout Shoping Cart",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		

	}

	@When("^Input Form ID to Continue Checkout")
	public void workSeven() throws IOException {
		dashboardPage.formCheckout("david", "beackam", "16118");
		System.out.println("Scenario Input Form ID to Continue Checkout pass");
		extentTest.log(Status.PASS, "Input Form ID to Continue Checkout");
		extentTest.pass("Input Form ID to Continue Checkout",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@When("^Confirm to Finish Checkout")
	public void workEight() throws IOException {
		dashboardPage.finishCheckout();
		System.out.println("Scenario Confirm to Finish Checkout pass");
		extentTest.log(Status.PASS, "Confirm to Finish Checkout");
		extentTest.pass("Confirm to Finish Checkout",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	
	@Then("^Succesfuly Buy Product")
	public void workNine() throws IOException {
		System.out.println("Scenario Succesfuly Buy Product pass");
		extentTest.log(Status.PASS, "Succesfuly Buy Product");
		extentTest.pass("Succesfuly Buy Product",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@Then("^Back Home Dashboard")
	public void workTen() throws IOException {
		dashboardPage.backhomedashboard();
		System.out.println("Scenario Back Home Dashboard pass");
		extentTest.log(Status.PASS, "Back Home Dashboard");
		extentTest.pass("Back Home Dashboard",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@After
	public void closeObject() {
//		driver.close();
//		driver.quit();
		extentReports.flush();
	}

//CAPTURE PHOTO TESTING
	public String failcaptureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.sqawebjavabdd\\src\\test\\resources\\failevidence\\"
				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}
	
	public String passcaptureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.sqawebjavabdd\\src\\test\\resources\\passevidence\\"
				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "-").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
