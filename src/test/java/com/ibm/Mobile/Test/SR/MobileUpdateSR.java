package com.ibm.Mobile.Test.SR;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.ScreenRecorderUtil;
import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

public class MobileUpdateSR extends SuperTest {
	/** The test. */
	TestSessionInitiator test;
	/** The logger. */
//	static ExtentTest logger;
	/** The relationship number. */
	String relNumber;
	String SRNumber;

	/**
	 * Test Case 00 set up.
	 */
	@BeforeClass
	public void TC00_SetUp() {
		System.out.println();
		System.out.println("***********Before Class ********");
		System.out.println();
		Utilities.setYamlFilePath("integration_testData.yml");

	}

	/**
	 * Test Case 01 enter login info.
	 * @throws Exception
	 */
	@Test
	public void TC00_LaunchEmulator() throws Exception {
		ScreenRecorderUtil.startRecord("TC00_LaunchEmulator");
		Utilities.LaunchEmulator();
	}

	@Test
	public void TC01_SetUpEmulatorSession() {
		test = new TestSessionInitiator("mobile");

	}

	@Test
	public void TC02_loginToMobileApp() {
		test.mobileActions.loginToInformation();

	}
	@Test
	public void TC03_createMobileUpdateSR() {
		test.mobileActions.UpdateMobileNumber();
		relNumber = "7200000000012316";

	}
	@Test
	public void TC04_closeEmulator() {
		test.closeMobileSession();
	}
	/**
	 * Test Case 02 navigate to contact tab.
	 */
	@Test
	public void TC04_NavigateToContactTab() {
		test = new TestSessionInitiator();
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
		test.homePage.verifyHomePageDisplay();
		test.contactPage.naviagteToContactTab();
	}

	@Test
	public void TC05_SearchForRelationShip() {
		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
	}
	@AfterClass
	public void tearDownSession() throws Exception {
		System.out.println("***************** After Class ***********************");
		if (!(StringUtils.isEmpty(relNumber))) {
			Utilities.writeRelationShipNumberInTxtFile(relNumber, test.getYamlVal("environment").toLowerCase());
			System.setProperty("relationShipNumber", relNumber);
		}
		test.closeBrowserSession();
		ScreenRecorderUtil.stopRecord();
	}




}

