/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-04-25
 */
package com.ibm.Test.Refill;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class CancelRefillOrder.
 * 
 * 
 */
public class CancelRefillOrder extends SuperTest {
	/** The test. */
	TestSessionInitiator test;
	/** The driver. */
//	WebDriver driver;
	/** The logger. */
//	static ExtentTest logger;
	/** The rel number. */
	static String relNumber;

	/** The name. */
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

	/**
	 * TC 04 create default order.
	 */
	@Test
	public void TC04_CreateDefaultOrder() {
		test.homePage.createDefaultOrder();
	}

	/**
	 * * TC 05 verify order deatils.
	 */
	@Test
	public void TC05_VerifyOrderDeatils() {
		test.homePage.verifyOrderCreated();
	}

	/**
	 * TC 06 enter delivery boy information.
	 */
	@Test
	public void TC06_EnterDeliveryBoyInformation() {
		test.homePage.enterDeliveryBoy();
	}

	/**
	 * TC 07 create invoice.
	 */
	@Test
	public void TC07_CreateInvoice() {
		test.homePage.createInvoice();
	}

	/**
	 * TC 08 verify order deatils.
	 */
	@Test
	public void TC08_VerifyOrderDeatils() {
		test.homePage.verifyInvoiceOrderDetails();
	}

	/**
	 * TC 09 complete order.
	 */
	@Test
	public void TC09_CancelledOrder() {
		test.homePage.cancelledInvoicedOrder();
	}

	/**
	 * TC 10 create invoice again and complete.
	 */
	@Test
	public void TC10_createInvoiceAgainAndComplete() {
		test.homePage.createInvoice();
		test.homePage.verifyInvoiceOrderDetails();
		test.homePage.completeInvoicedOrder();
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public void tearDownSession() {
		test.closeBrowserSession();
	}
}
