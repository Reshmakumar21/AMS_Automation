package com.ibm.Test.ConnectionManagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

public class TCRV_Order_Lost extends SuperTest {
	/** The test. */
	 TestSessionInitiator test ;

	/** The driver. */
	WebDriver driver;


	/** The rel number. */
	static String relNumber;


	/**
	 * TC 00 set up.
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

	/**
	 * TC 03 relation ship drill down.
	 */
	@Test
	public void TC03_RelationShipDrillDown() {
		test.homePage.openRelationShipFromSearchResult();
	}

	@Test
	public void TC04_navigateToDocumentAfterRelationShipTab() {
		test.contactPage.navigateToDocumentAfterRelationShipTab();
	}

	@Test
	public void TC05_addNewDocument() {
		test.ttvConMngPage.addNewDocument();
	}

	@Test
	public void TC06_addNewDocumentAndSelectType() {
		test.ttvConMngPage.addNewDocumentAndSelectType("TCRV", "Lost Equipment");
	}

	@Test
	public void TC07_addTCRVLostEquipment() {
		test.ttvConMngPage.addTCRVLostEquipment();
	}

	@Test
	public void TC08_AddComment() {
		test.ttvConMngPage.AddComment();
	}

	@Test
	public void TC09_submitAndInvoiceDocument() {
		test.ttvConMngPage.submitAndInvoiceDocumentLost();
	}

	@Test
	public void TC10_invoiceComplete() {
		test.ttvConMngPage.invoiceComplete();
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public  void tearDownSession() {
			test.closeBrowserSession();
	}
}
