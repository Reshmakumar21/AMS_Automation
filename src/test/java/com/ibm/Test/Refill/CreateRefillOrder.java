/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Test.Refill;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class CreateRefillOrder.
 */
public class CreateRefillOrder extends SuperTest {
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
	 *
	 * @throws Exception
	 */
	@BeforeClass(alwaysRun=true)
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
	@Test(priority = 1)
	public void TC01_EnterLoginInfo() {
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
		test.homePage.verifyHomePageDisplay();
	}

	/**
	 * TC 02 search for relation ship.
	 */
	@Test(priority = 2)
	public void TC02_SearchForRelationShip() {
		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
	}

	/**
	 * TC 03 relation ship drill down.
	 */
	@Test(priority = 3)
	public void TC03_RelationShipDrillDown() {
		test.homePage.openRelationShipFromSearchResult();
	}

	/**
	 * TC 04 create default order.
	 */
	@Test(priority = 4)
	public void TC04_CreateDefaultOrder() {
		test.homePage.createDefaultOrder();
	}

	/**
	 * TC 05 verify order details.
	 */
	@Test(priority = 5)
	public void TC05_VerifyOrderDeatils() {
		test.homePage.verifyOrderCreated();
	}

	/**
	 * TC 06 enter delivery boy information.
	 */
	@Test(priority = 6)
	public void TC06_EnterDeliveryBoyInformation() {
		test.homePage.enterDeliveryBoy();
	}

	/**
	 * TC 07 create invoice.
	 */
	@Test(priority = 7)
	public void TC07_CreateInvoice() {
		test.homePage.createInvoice();
	}

	/**
	 * TC 08 verify order deatils.
	 */
	@Test(priority = 8)
	public void TC08_VerifyOrderDeatils() {
		test.homePage.verifyInvoiceOrderDetails();
	}

	/**
	 * TC 09 complete order.
	 */
	@Test(priority = 9)
	public void TC09_CompleteOrder() {
		test.homePage.completeInvoicedOrder();
	}

	@Test(priority = 10)
	public void TC10_verifyInvertoryTransaction() {
		test.contactPage.verifyInvertoryTransaction();
	}

	@Test(priority = 11)
	public void TC11_verifyPaymentsTab() {
		test.contactPage.verifyPaymentsTab();
	}

	/**
	 * Tear down session.
	 */
	@AfterClass(alwaysRun=true)
	public void tearDownSession() {
		test.closeBrowserSession();
	}
}
