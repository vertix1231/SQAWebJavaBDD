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
import com.test.kerja.sqa.sqawebjavabdd.scenariopage.AdminPage;
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
	private static AdminPage adminPage;

//start WEB TEST KERJA---------------------------------------------------------------------------------------------------------------------

//MULAI TESTSTING TEST KERJA-------------------------------------------------------------------------------------------------------------------
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void workSetUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		driver = DriverSingleton.getDriver();
		loginPage = new LoginPage();
		adminPage = new AdminPage();
		extentReports.attachReporter(htmlreporter);
		ScenarioTestCases[] tests = ScenarioTestCases.values();
		extentTest = extentReports.createTest(tests[UtilsTest.scenariotestcount].getScenarioTestName());
		UtilsTest.scenariotestcount++;
	}

//---------------------------------------------------------------------------------------------------------------------

	@Given("^Go to Main web Login")
	public void workZero() throws IOException {
		driver.get(ConstantsParam.URL_MAIN_WEB);
		if(loginPage.getTxtLoginHighlight().contains(configurationProperties.getLoginhighlightexpected())) {
			extentTest.log(Status.PASS, "Navigation to : " + ConstantsParam.URL_MAIN_WEB);
		}else{
			extentTest.fail("Navigation to : " + ConstantsParam.URL_MAIN_WEB,
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}
		
	}

	@When("^input user and password to login to web")
	public void workOne() throws IOException {
		if (loginPage.getTxtLoginHighlight().contains(configurationProperties.getLoginhighlightexpected())) {
			loginPage.goToSignin("Admin", "admin123");
			System.out.println("input user and password to login to web pass");
			extentTest.log(Status.PASS, "input user and password to login to web");

		} else {
			System.out.println("input user and password to login to web fail");
			extentTest.fail("input user and password to login to web",
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());

		}

	}

	@Then("^enter dashboard page")
	public void workTwo() throws IOException {
		if (loginPage.getTvdashboard().contains(configurationProperties.getDashboardexpectedtext())) {
			System.out.println("scenario enter dashboard page pass");
			extentTest.log(Status.PASS, "enter dashboard page pass");
		} else {
			System.out.println("scenario enter dashboard page fail");
			extentTest.fail("succesfully enter dashboard page fail",
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}

	}

	@Given("^Click admin menu")
	public void workThree() throws IOException {
		adminPage.goToAdmin();
		if(adminPage.getTxtAdmiTabHighlight().contains(configurationProperties.getAdmintabadminmenu())) {
			System.out.println("scenario Click admin menu pass");
			extentTest.log(Status.PASS, "Click admin menu");
		}else{
			System.out.println("scenario Click admin menu fail");
			extentTest.fail("Click admin menu",
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}

	}

	@After
	public void closeObject() {
		extentReports.flush();
	}

//CAPTURE PHOTO TESTING
	public static String failcaptureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.sqawebjavabdd\\src\\test\\resources\\failevidence\\"
				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static String getcurrentdateandtime() {
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
