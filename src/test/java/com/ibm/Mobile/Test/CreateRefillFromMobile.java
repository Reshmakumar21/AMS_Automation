/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Mobile.Test;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.ScreenRecorderUtil;
import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer On-boarding SBC.
 */
public class CreateRefillFromMobile extends SuperTest {

	/** The test. */
	TestSessionInitiator test;
	/** The logger. */
//	static ExtentTest logger;
	/** The relationship number. */
	String relNumber;


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
	public void TC03_1_orderCylinerFromApp() {
		test.mobileActions.orderCylinder();
		test.mobileActions.onlinePaymnet();
		relNumber = "7200000000012316";
	}

	@Test
	public void TC03_2_closeEmulator() {
		test.closeMobileSession();
	}
	@Test
	public void TC04_NavigateToContactTab() {
		test = new TestSessionInitiator();
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
		test.homePage.verifyHomePageDisplay();
		//test.contactPage.naviagteToContactTab();
	}



	@Test
	public void TC05_SearchForRelationShip() {
		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
	}

	/**
	 * TC 03 relation ship drill down.
	 */
	@Test
	public void TC06_RelationShipDrillDown() {
		test.homePage.openRelationShipFromSearchResult();
	}

	/**
	 * TC 04 create default order.
	 */
	@Test
	public void TC07_CreateDefaultOrder() {
		test.homePage.openLatestOrder();
	}

	/**
	 * TC 05 verify order details.
	 */
	@Test
	public void TC08_VerifyOrderDeatils() {
		test.homePage.verifyOrderCreated();
	}

	/**
	 * TC 06 enter delivery boy information.
	 */
	@Test
	public void TC09_EnterDeliveryBoyInformation() {
		test.homePage.enterDeliveryBoy();
	}

	/**
	 * TC 07 create invoice.
	 */
	@Test
	public void TC10_CreateInvoice() {
		test.homePage.createInvoice();
	}

	/**
	 * TC 08 verify order deatils.
	 */
	@Test
	public void TC11_VerifyOrderDeatils() {
		test.homePage.verifyInvoiceOrderDetails();
	}

	/**
	 * TC 09 complete order.
	 */
	@Test
	public void TC12_CompleteOrder() {
		test.homePage.completeInvoicedOrder();
	}

	@Test
	public void TC13_verifyInvertoryTransaction() {
		test.contactPage.verifyInvertoryTransaction();
	}

	@Test
	public void TC14_verifyPaymentsTab() {
		test.contactPage.verifyPaymentsTab();
	}


	/**
	 * Tear down session.
	 * @throws Exception
	 */
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
