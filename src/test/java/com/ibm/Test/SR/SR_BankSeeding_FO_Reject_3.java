/* 
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15 
 * 
 */
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
 * The Class SR_BankSeeding_FO_Reject.
 */
public class SR_BankSeeding_FO_Reject_3 extends SuperTest {
	/** The test. */
	 TestSessionInitiator test ;
	/** The driver. */
	WebDriver driver;
	/** The rel number. */
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
	public void TC05_cleanExistingSRStatuses() {
		
		test.profileSRPage.connectDBToUpdateAllSRStatusToClose(relNumber);
	}

	@Test
	public void TC06_NavigateToProfileSR_Tab() {
		
		test.contactPage.navigateToProfileSRContactPage();
	}

	@Test
	public void TC07_selectTransactionType() {
		
		test.profileSRPage.selectTransactionType("Bank Seeding");
	}

	@Test
	public void TC08_DrillDownSRNumber() {
		
		test.profileSRPage.drillDownSRNumber();
	}

	@Test
	public void TC09_BankSeedingDetails() {
		
		test.profileSRPage.AddBankDetailsProfileSR("APBL0000108");
		test.profileSRPage.addAttachmentForProfileSR("Aadhaar(UID)");
	}

	@Test
	public void TC10_SubmitSR() {

		test.profileSRPage.submitSRVerifyOMCDedup();
	}

	@Test
	public void TC11_VerifyProfileSRStatus() {

		test.profileSRPage.verifySRStatus("In Progress");
	}

	/* FO Approval */
	@Test
	public void TC12_ApprovalFO() {
		
		test.profileSRPage.FODecision("Reject");
	}

	@Test
	public void TC13_VerifyProfileSRStatus() {
		
		test.profileSRPage.verifySRStatus("Rejected");
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public  void tearDownSession() {
			test.closeBrowserSession();
	}
}

