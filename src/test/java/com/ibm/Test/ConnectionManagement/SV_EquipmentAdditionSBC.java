/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Test.ConnectionManagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class SV_EquipmentAddition.
 */
public class SV_EquipmentAdditionSBC extends SuperTest {
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
	public void TC06_addNewDocument() {
		test.ttvConMngPage.addNewDocument();
	}

	@Test
	public void TC07_addNewDocumentAndSelectType() {
		test.ttvConMngPage.addNewDocumentAndSelectType("SV", "Addition of Equipment");
	}

	@Test
	public void TC08_createDefaultDocument() {
		test.ttvConMngPage.createDefaultDocument();
	}

	@Test
	public void TC09_addDefaultLineItemAddEquipment() {
		test.ttvConMngPage.addDefaultLineItemAddEquipment();
	}

	@Test
	public void TC10_repriceAllAndAddComment() {
		test.ttvConMngPage.repriceAllAndAddComment();
	}

	@Test
	public void TC11_submitAndInvoiceDocument() {
		test.ttvConMngPage.submitAndInvoiceDocument();
	}

	@Test
	public void TC12_invoiceComplete() {
		test.ttvConMngPage.invoiceComplete();
	}

	@Test
	public void TC13_openOrder() {
		test.ttvConMngPage.openOrder();
	}

	@Test
	public void TC14_navigateToInstallationTab() {
		test.ttvConMngPage.navigateToInstallationTab();
	}

	@Test
	public void TC15_createInvoice() {
		test.ttvConMngPage.createInvoice();
	}

	@Test
	public void TC16_completeInvoice() {
		test.ttvConMngPage.completeInvoice();
	}

	@Test
	public void TC17_validateOrderStatus() {
		test.ttvConMngPage.validateSalesOrderStatus();
	}
	/**
	 * Tear down session.
	 */
	@AfterClass
	public  void tearDownSession() {
		test.closeBrowserSession();
	}
}
