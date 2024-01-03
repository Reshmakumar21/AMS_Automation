/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-04-25
 */
package com.ibm.automation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.Utilities;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

/**
 * The Class SuperTest.
 *
 * @author ShivamTiwari
 */
public class SuperTest extends LoggerWriter {
	/** The reporter. */
	public static ExtentHtmlReporter reporter;
	/** The extent. */
	public static ExtentReports extent = new ExtentReports();
	/** The logger. */
	public static ExtentTest logger;
	String executionReportPath;

	/**
	 * Before due set up.
	 */
	@BeforeSuite(alwaysRun=true)
	public void beforeSuperMaterSetUp(ITestContext ctx) {
		System.out.println();
		System.out.println("***********Before SetUp ********");
		System.out.println();
		System.out.println("*********** Report SetUp Execution ********");
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		System.out.println("Execution Report Folder Name: " + "ExecutionReport" + dateFormat.format(date));
		String str = "./Reports/" + "ExecutionReport" + dateFormat.format(date);
		executionReportPath = str;
		File dir = new File(str);
		File dirScreenShot = new File(str + "/screenshots");
		if (!dir.exists()) {
			dir.mkdirs();
			dirScreenShot.mkdirs();
			LoggerWriter._initSetScreenShotPath(str + "/screenshots");
			File file = new File(str + "/" + "automation_Report.html");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		reporter = new ExtentHtmlReporter(str + "/automation_Report.html");
		System.out.println("Report Path : " + str + "/automation_Report.html");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "IBM Automation");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Shivam Tiwari");
		reporter.config().setDocumentTitle("Automation Test Execution Status");
		reporter.config().setReportName("IOCL AWS Regression Testing");
		reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		reporter.config().setTheme(Theme.DARK);
	}

	/**
	 * After clean up.
	 */
	@AfterSuite(alwaysRun=true)
	public void afterSuperMasterCleanUp(ITestContext ctx) {
		System.out.println("*********** Flush ********");
		extent.flush();
		System.out.println();
		System.out.println();
		System.out.println("*********** Exe Completed ********");
		String newName;
		if (!(((ctx.getSuite().getName().contains("Default"))) || ((ctx.getSuite().getName().contains("Surefire"))))) {
			newName = ctx.getSuite().getName();
		} else if (!(((ctx.getCurrentXmlTest().getName().contains("Default")))
				|| ((ctx.getCurrentXmlTest().getName().contains("Surefire"))))) {
			newName = ctx.getCurrentXmlTest().getName();
		} else {
			String name = "" + ctx.getAllTestMethods()[0].getInstance().getClass();
			newName = name.substring(name.lastIndexOf("."), name.length()).replaceAll("\\.", "");
		}
		File sourceFile = new File(executionReportPath);
		File destFile = new File(executionReportPath.replace("ExecutionReport", newName));
		if (sourceFile.renameTo(destFile)) {
			System.out.println("Directory renamed successfully");
		} else {
			System.out.println("Failed to rename directory");
		}
	}

	/**
	 * Before test method.
	 *
	 * @param testMethod the test method
	 */
	@BeforeMethod(alwaysRun=true)
	public void beforeTestMethod(Method testMethod) {
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------------------------");
		System.out.println("                 Test Started : " + testMethod.getName());
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------\n\n");
	}

	/**
	 * Gets the result.
	 *
	 * @param result the result
	 * @return the result
	 * @throws Exception the exception
	 */
	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.INFO,
					"Fail Step Description :  \"" + result.getName() + "   " + result.getThrowable() + "\"",
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshotAuto(result.getName()))
							.build());
			System.out.println("---------------------------------------------");
			System.out.println("*********  Test Case Fail *******************");
			System.out.println("---------------------------------------------");
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			System.out.println("---------------------------------------------");
			System.out.println("*********  Test Case Skipp *******************");
			System.out.println("---------------------------------------------");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			System.out.println("---------------------------------------------");
			System.out.println("*********  Test Case Pass *******************");
			System.out.println("---------------------------------------------");
		}
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------------------------\n\n");
	}

	@BeforeTest(alwaysRun=true)
	public void beforeMasterSetUp() {
		System.out.println();
		System.out.println("***********Before Test ********");
		System.out.println();
		String className = this.getClass().getSimpleName();
		logger = extent.createTest(className);
		LoggerWriter._initSetLogger(logger);
	}

	@AfterTest(alwaysRun=true)
	public void afterMasterSetUp() {
//		System.out.println("*********** Flush ********");
//		extent.flush();
	}

	/**
	 * Gets the screen shot.
	 *
	 * @return the screen shot
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String getScreenShot() throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenshotName = "SC";
		String destination = LoggerWriter.screenShotPath + "/" + screenshotName + dateName + ".jpg";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	public String readToastmessage() throws TesseractException, IOException{

		String Image= getScreenShot();
		String result= null;
		File imageFile= new File( scrShorDirPath ,Image);
		System.out.println("Image Name is ::" +imageFile.toString());
		ITesseract instance =new Tesseract();
		File tessDataFolder =LoadLibs.extractTessResources("tessdata");
		instance.setDatapath(tessDataFolder.getAbsolutePath());
		result= instance.doOCR(imageFile);
		System.out.println(result);

		return result;

	}
}
