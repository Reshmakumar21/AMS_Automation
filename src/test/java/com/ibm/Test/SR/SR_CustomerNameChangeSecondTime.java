package com.ibm.Test.SR;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Profile_SR_Address_Change.
 */
public class SR_CustomerNameChangeSecondTime extends SuperTest {
	/**
	 * The test.
	 */
	 TestSessionInitiator test ;

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

	@Test
	public void TC03_LastNameDrillDown() {

		test.contactPage.afterRelationShipSearchClickOnLastName();
	}

	/* TC to store MDMuID value */
	@Test
	public void TC04_NavigateToMoreInfoTabToObtainMDM_UID() {

		test.profileSRPage.getMDMUID();
	}

	/* TC to clean existing SR statuses */
	@Test @Ignore
	public void TC05_CleanExistingSRStatuses() {

		test.profileSRPage.connectDBToUpdateAllSRStatusToClose(relNumber);
	}

	@Test
	public void TC06_NavigateToProfileSR_Tab() {

		test.contactPage.navigateToProfileSRContactPage();
	}

	@Test
	public void TC07_SelectTransactionType() {

		test.profileSRPage.selectTransactionType("Customer Name Correction");
	}

	@Test
	public void TC08_DrillDownSRNumber() {

		test.profileSRPage.drillDownSRNumber();
	}

	@Test
	public void TC09_NameChange() {

		test.profileSRPage.NameChange();
	}

	@Test
	public void TC10_AddAttachment() {

		test.profileSRPage.addAttachment();
	}

	@Test
	public void TC11_ClickSubmit() {

		test.profileSRPage.submitSR();
	}

	@Test
	public void TC12_VerifyProfileSRStatus() {

		test.profileSRPage.verifySRStatus("Closed");
	}

	@Test
	public void TC13_VerifyAmendment() {

		test.profileSRPage.verifyAmendment();
	}

	@Test
	public void TC14_LastNameDrillDown() {

		test.contactPage.afterRelationShipSearchClickOnLastName();
	}

	@Test
	public void TC15_NavigateToProfileSR_Tab() {

		test.contactPage.navigateToProfileSRContactPage();
	}

	@Test
	public void TC16_selectTransactionType() {

		test.profileSRPage.selectTransactionType("Customer Name Correction");
	}

	@Test
	public void TC17_DrillDownSRNumber() {

		test.profileSRPage.drillDownSRNumber();
	}

	@Test
	public void TC18_NameChange() {

		test.profileSRPage.NameChange();
	}

	@Test
	public void TC19_AddAttachment() {

		test.profileSRPage.addAttachment();
	}

	@Test
	public void TC20_ClickSubmit() {

		test.profileSRPage.submitSR();
	}

	@Test
	public void TC21_VerifyProfileSRStatus() {

		test.profileSRPage.verifySRStatus("Cancelled");
	}

	@Test
	public void TC22_VerifyAmendment() {

		test.profileSRPage.verifyAmendmentSecondTimeNameChange();
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public  void tearDownSession() {
			test.closeBrowserSession();
	}
}

