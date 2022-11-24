package com.test.kerja.sqa.sqawebjavabdd.glue;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.test.kerja.sqa.sqawebjavabdd.scenariopage.KerjaOneScenarioPage;
import com.test.kerja.sqa.sqawebjavabdd.utils.ConfigurationProperties;
import com.test.kerja.sqa.sqawebjavabdd.utils.ConstantsDriver;
import com.test.kerja.sqa.sqawebjavabdd.utils.TestCases;
import com.test.kerja.sqa.sqawebjavabdd.utils.UtilsTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	private static WebDriver driver;
	private static KerjaOneScenarioPage kerjaOneScenarioPage;
	private ExtentTest extentTest;
	static ExtentReports extentReports = new ExtentReports();
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/test/resources/reporttest_testkerja.html");

	private final String url = "jdbc:h2:mem:testdb";
	private final String user = "sa";
	private final String password = "";
	public static String fname = null;

//start WEB TEST KERJA---------------------------------------------------------------------------------------------------------------------

//MULAI TESTSTING TEST KERJA-------------------------------------------------------------------------------------------------------------------
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObject() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());

		kerjaOneScenarioPage = new KerjaOneScenarioPage();

		extentReports.attachReporter(htmlreporter);
		TestCases[] tests = TestCases.values();
		extentTest = extentReports.createTest(tests[UtilsTest.testcount].getTestName());
		UtilsTest.testcount++;
	}

//---------------------------------------------------------------------------------------------------------------------

	@Given("^Go to Verint.com")
	public void kerjaOne() {

		driver = DriverSingleton.getDriver();
		driver.get(ConstantsDriver.URL_MAIN_WEB);
		extentTest.log(Status.PASS, "Navigation to : " + ConstantsDriver.URL_MAIN_WEB);

	}

	@When("^Click on search button")
	public void kerjaTwo() {
//		kerjaOneScenarioPage.clickSearch();
//		if (Status.PASS != null) {
//			System.out.println("scenario Click on search button passed");
//			extentTest.log(Status.PASS, "Click on search button");
//
//		} else {
//			System.out.println("scenario Click on search button fail");
//			extentTest.log(Status.FAIL, "Click on search button");
//			try {
//				extentTest.fail("Click on search button",
//						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}

	}

	@And("^Input customer solution")
	public void kerjaThree() {
//		kerjaOneScenarioPage.inputArticleTitle(configurationProperties.getExpectedtext());
//		if (Status.PASS != null) {
//			System.out.println("scenario Input “customer solution” passed");
//			extentTest.log(Status.PASS, "Input “customer solution”");
//
//		} else {
//			System.out.println("scenario Input “customer solution” fail");
//			extentTest.log(Status.FAIL, "Input “customer solution”");
//			try {
//				extentTest.fail("Input “customer solution”",
//						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	@Then("^Check if article title contains customer solution in the Search Result")
	public void kerjaFour() {
////		kerjaOneScenario.getVerifyTextCustomerSolution();
//		String actualText = kerjaOneScenarioPage.getVerifyTextCustomerSolution();
//		String expectedString = configurationProperties.getExpectedtext();
//		if (actualText.toLowerCase().contains(expectedString.toLowerCase())) {
//			System.out.println(
//					"scenario Check if article title contains “customer solution” in the Search Result passed");
//			extentTest.log(Status.PASS, "Check if article title contains “customer solution” in the Search Result");
//
//		} else {
//			System.out
//					.println("scenario Check if article title contains “customer solution” in the Search Result fail");
//			extentTest.log(Status.FAIL, "Check if article title contains “customer solution” in the Search Result");
//			try {
//				extentTest.fail("Check if article title contains “customer solution” in the Search Result",
//						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//
//		}	
//		assertTrue(actualText.contains(expectedString));

	}

	@After
	public void closeObject() {
		extentReports.flush();
	}

//CAPTURE PHOTO TESTING
	public static String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "D:\\ChromeDriver\\buktihasiltesting\\" + getcurrentdateandtime() + ".png";
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

	// Method to initalize connection to the database and execute query

	public void connect() {

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			{
				if (conn != null) {

					PreparedStatement pst = conn
							.prepareStatement("select first_name from actor where last_name = 'Lollobrigida'");
					ResultSet rs = pst.executeQuery();
					{
						while (rs.next()) {

							fname = rs.getString("first_name");
							System.out.println("The value from the table is : " + fname);
						}
					}

				} else
					System.out.println("Failed to connect");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
