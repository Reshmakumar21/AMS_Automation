/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Test;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Customer On-boarding SBC.
 */
public class CustomerOnboardingSBC extends SuperTest {
	/** The test. */
	TestSessionInitiator test;
	/** The logger. */
//	static ExtentTest logger;
	/** The relationship number. */
	String relNumber;

	/**
	 * Test Case 00 set up.
	 */
	@BeforeClass(alwaysRun=true)
	public void TC00_SetUp() {
		System.out.println();
		System.out.println("***********Before Class ********");
		System.out.println();
		Utilities.setYamlFilePath("integration_testData.yml");
		test = new TestSessionInitiator();
	}

	/**
	 * Test Case 01 enter login info.
	 */
//	@Test
	@Test(priority = 1, groups = {"minimal"})
	public void TC01_EnterLoginInfo() {
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
		test.homePage.verifyHomePageDisplay();
	}

	/**
	 * Test Case 02 navigate to contact tab.
	 */
//	@Test
	@Test(priority = 2, groups = {"minimal"})
	public void TC02_NavigateToContactTab() {
		test.contactPage.naviagteToContactTab();
	}

	/**
	 * Test Case 03 create new contact.
	 */
//	@Test
	@Test(priority = 3, groups = {"minimal"})
	public void TC03_createNewContact() {
		test.contactPage.createNewContact();
	}

	/**
	 * Test Case 04 enter new customer information.
	 */
//	@Test
	@Test(priority = 4, groups = {"minimal"})
	public void TC04_enterNewCustomerInformation() {
		test.contactPage.enterNewCustomerInformation(test.getYamlVal("NewCustomer.Salutation"),
				test.getYamlVal("NewCustomer.FirstName"), test.getYamlVal("NewCustomer.LastName"),
				test.getYamlVal("NewCustomer.Gender"), test.getYamlVal("NewCustomer.DOB"));
	}

	/**
	 * Test Case 05 add new address.
	 */
//	@Test
	@Test(priority = 5, groups = {"minimal"})
	public void TC05_addNewAddress() {
		test.contactPage.addNewAddress(test.getYamlVal("NewCustomer.Address.Line1"),
				test.getYamlVal("NewCustomer.Address.Line2"), test.getYamlVal("NewCustomer.Address.Line3"),
				test.getYamlVal("NewCustomer.Address.Area"), test.getYamlVal("NewCustomer.Address.PinCode"),
				test.getYamlVal("NewCustomer.Address.LocalBody"), test.getYamlVal("NewCustomer.Address.City"),
				test.getYamlVal("NewCustomer.Address.Urban"));
	}

	/**
	 * Test Case 06 add identities for new customer.
	 */
//	@Test
	@Test(priority = 6, groups = {"minimal"})
	public void TC06_addIdentitiesForNewCustomer() {
		test.contactPage.addIdentitiesForNewCustomer(test.getYamlVal("NewCustomer.Identities.IdentityType"),
				test.getYamlVal("NewCustomer.Identities.IdentityMethod"),
				test.getYamlVal("NewCustomer.Identities.IdentityNumber"));
	}

	/**
	 * Test Case 08 enter BPL for new customer.
	 */
//	@Test
	@Test(priority = 7, groups = {"minimal"})
	public void TC08_enterBPLForNewCustomer() {
		test.contactPage.enterBPLForNewCustomer(test.getYamlVal("NewCustomer.BPL"));
	}

	/**
	 * Test Case 09 enter phone no for new customer.
	 */
//	@Test
	@Test(priority = 8, groups = {"minimal"})
	public void TC09_enterPhoneForNewCustomer() {
		String num = Long.toString((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
		//test.contactPage.enterPhoneForNewCustomer(num); Note: changes made
	}

	/**
	 * Test Case 09 perform contact dedup.
	 */
//	@Test
	@Test(priority = 9, groups = {"minimal"})
	public void TC09_performContactDedup() {
		test.contactPage.performContactDedup();
	}


	// Redundant
	/**
	 * Test Case 10 navigate to general connection summary.
	 */
//	@Test
//	@Test(priority = 10, groups = {"minimal"})
//	public void TC10_navigateToGeneralConnectionSummary() {
//		test.contactPage.navigateToGeneralConnectionSummary();
//	}

	/**
	 * Test Case 11 create new relationship ship.
	 */
//	@Test
	@Test(priority = 11, groups = {"minimal"})
	public void TC11_createNewRealationShip() {
		relNumber = test.contactPage.createNewRelationShip(test.getYamlVal("environment"));
	}

	/**
	 * Test Case 12 relation ship drill down and set scheme.
	 */
//	@Test
	@Test(priority = 12, groups = {"minimal"})
	public void TC12_relationShipDrillDownAndSetScheme() {
		test.contactPage.relationShipDrillDownAndSetScheme(test.getYamlVal("NewCustomer.RelationShipScheme.Scheme"),
				test.getYamlVal("NewCustomer.RelationShipScheme.SchemeType"),
				test.getYamlVal("NewCustomer.RelationShipScheme.PromotionName"),
				test.getYamlVal("NewCustomer.RelationShipScheme.ServiceArea"));
	}

	/**
	 * Test Case 13 navigate to document and create document.
	 */
//	@Test
	@Test(priority = 13, groups = {"minimal"})
	public void TC13_navigateToDocumentAndCreateDocument() {
		test.contactPage.navigateToDocumentAndCreateDocument(test.getYamlVal("NewCustomer.Document.Type"),
				test.getYamlVal("NewCustomer.Document.SubType"));
	}

	/**
	 * Test Case 14 created line items.
	 */
//	@Test
	@Test(priority = 14, groups = {"minimal"})
	public void TC14_createdLineItems() {
		test.contactPage.createdLineItems("SBC");
	}

	/**
	 * Test Case 15 submit document.
	 */
//	@Test
	@Test(priority = 15, groups = {"minimal"})
	public void TC15_submitDocument() {
		test.contactPage.submitDocument();
	}

	/**
	 * Test Case 16 invoice document.
	 */
//	@Test
	@Test(priority = 16, groups = {"minimal"})
	public void TC16_invoiceDocument() {
		test.contactPage.invoiceDocument();
	}

	/**
	 * Test Case 17 verify installation.
	 */
//	@Test
	@Test(priority = 17, groups = {"minimal"})
	public void TC17_verifyInstallation() {
		test.contactPage.verifyInstallation();
//		test.contactPage.verifyPricing("SBC");
	}

	/**
	 * Test Case 18 verify relationship ship status.
	 */
//	@Test
	@Test(priority = 18)
	public void TC18_verifyRelationshipStatus() {
		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
		test.contactPage.verifyRelationShipStatus(relNumber);
		test.contactPage.verifyConsumerType("SBC");
	}

//	@Test
	@Test(priority = 19)
	public void TC19_verifyProductsAndAssetsAndInventoryTransactionsOfDocuments() {
		//test.homePage.openRelationShipFromSearchResult();
		//test.contactPage.verifyOnboardedCustPoints();
	}

	/**
	 * Tear down session.
	 */
	@AfterClass(alwaysRun=true)
	public void tearDownSession() {
		System.out.println("***************** After Class ***********************");
		if (!(StringUtils.isEmpty(relNumber))) {
			Utilities.writeRelationShipNumberInTxtFile(relNumber, test.getYamlVal("environment").toLowerCase());
			System.setProperty("relationShipNumber", relNumber);
		}
		//test.closeBrowserSession();
	}
}
