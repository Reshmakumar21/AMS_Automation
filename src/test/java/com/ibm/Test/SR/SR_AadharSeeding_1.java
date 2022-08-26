package com.ibm.Test.SR;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Profile_SR_Aadhar_Seeding.
 */
public class SR_AadharSeeding_1 extends SuperTest {
	/**
	 * The test.
	 */
	TestSessionInitiator test;
	/**
	 * The driver.
	 */
	WebDriver driver;
	/**
	 * The rel number.
	 */
	 String relNumber;

		/**
		 * TC 00 set up.
		 * 
		 * @throws Exception
		 */
		@BeforeClass
		public void TC00_SetUp() throws Exception {
			Utilities.setYamlFilePath("integration_testData.yml");
			test = new TestSessionInitiator();
			relNumber = System.getProperty("relationShipNumber",
					Utilities.getRelationShipFromTxtFile(test.getYamlVal("Txt.RelationShip")));
			System.out.println("Relation Ship Used : " + relNumber);
			if (relNumber.length() < 2) {
				throw new Exception("RelationShip Number is not : " + relNumber);
			}
		}

		/**
		 * TC 01 enter login info.
		 */
		@Test
		public void TC01_EnterLoginInfo() {
			test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
			test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
					test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
			test.homePage.verifyHomePageDisplay();
		}

	/**
	 * TC 02 search for relation ship.
	 */
	@Test
	public void TC02_SearchForRelationShip() {
		
		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
	}

	/* TC Drilldown last name */
	@Test
	public void TC03_LastNameDrillDown() {
		
		test.contactPage.afterRelationShipSearchClickOnLastName();
	}

	/* TC navigate to profile SR tab */
	@Test
	public void TC04_NavigateToProfileSRTab() {
		test.contactPage.navigateToProfileSRContactPage();
	}

	/* TC select transaction type under Service Request List Applet */
	@Test
	public void TC05_SelectTransactionType() {
		
		test.profileSRPage.selectTransactionType("Aadhar Seeding");
	}

	/* TC Drill down SR Number under Service Request List Applet */
	@Test
	public void TC06_DrillDownSRNumber() {
		
		test.profileSRPage.drillDownSRNumber();
	}

	/* TC perform aadhar seeding activity */
	@Test
	public void TC07_SeedAadhar() {
		
		test.profileSRPage.seedAadhar();
		test.profileSRPage.addAttachmentForProfileSR("Aadhaar(UID)");
	}

	/* Click submit button */
	@Test
	public void TC08_ClickSubmit() {
		
		test.profileSRPage.submitSRVerifyOMCDedup();
	}

	/* Verify profile SR status */
	@Test
	public void TC09_VerifyProfileSRStatus() {
		
		test.profileSRPage.verifySRStatus("Closed");
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public  void tearDownSession() {
			test.closeBrowserSession();
	}
}

