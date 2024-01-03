package com.ibm.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class UjvalaCustomerOnboarding.
 */
public class UjvalaCustomerOnboardingePMUY2 extends SuperTest {

	/** The test. */
	static TestSessionInitiator test = new TestSessionInitiator();

	/** The driver. */
	WebDriver driver;

	/** The logger. */

	/** The rel number. */
	static String relNumber;


	/**
	 * TC 00 set up.
	 */
	@BeforeClass
	public void TC00_SetUp() {
		System.out.println();
		System.out.println("***********Before Class ********");
		System.out.println();
		Utilities.setYamlFilePath("integration_testData.yml");
		test = new TestSessionInitiator();
	}

	/**
	 * TC 01 enter login info.
	 */
	@Test
	public void TC01_EnterLoginInfo() {
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
	}

	/**
	 * TC 02 navigate to contact tab.
	 */
	@Test
	public void TC02_NavigateToContactTab() {

		test.contactPage.naviagteToContactTab();
	}

	/**
	 * TC 03 create new contact.
	 */
	@Test
	public void TC03_createNewContact() {

		test.contactPage.createNewContact();
	}

	/**
	 * TC 04 enter new customer information.
	 */
	@Test
	public void TC04_enterNewCustomerInformation() {

		test.contactPage.enterNewCustomerInformation(test.getYamlVal("UjvalaCustomer.Salutation"), test.getYamlVal("UjvalaCustomer.FirstName"),
				test.getYamlVal("UjvalaCustomer.LastName"), test.getYamlVal("UjvalaCustomer.Gender"), test.getYamlVal("UjvalaCustomer.DOB"));
	}

	/**
	 * TC 05 add new address.
	 */
	@Test
	public void TC05_addNewAddress() {

		test.contactPage.addNewAddress(test.getYamlVal("UjvalaCustomer.Address.Line1"), test.getYamlVal("UjvalaCustomer.Address.Line2"),
				test.getYamlVal("UjvalaCustomer.Address.Line3"), test.getYamlVal("UjvalaCustomer.Address.Area"),
				test.getYamlVal("UjvalaCustomer.Address.PinCode"), test.getYamlVal("UjvalaCustomer.Address.City"),
				test.getYamlVal("UjvalaCustomer.Address.Urban"));
	}

	/**
	 * TC 06 add identities for new customer.
	 */
	@Test
	public void TC06_addIdentitiesForNewCustomer() {

		test.contactPage.addIdentitiesForNewCustomer(test.getYamlVal("UjvalaCustomer.Identities.IdentityType"),
				test.getYamlVal("UjvalaCustomer.Identities.IdentityMethod"), test.getYamlVal("UjvalaCustomer.Identities.IdentityNumber"));
		test.contactPage.addIdentitiesForNewCustomerAadhar(test.getYamlVal("NewCustomer.Identities.IdentityType"),
				test.getYamlVal("NewCustomer.Identities.IdentityMethod"));
	}

	/**
	 * TC 08 enter BPL for new customer.
	 */
	@Test
	public void TC08_enterBPLForNewCustomer() {

		test.contactPage.enterBPLForNewCustomer(test.getYamlVal("UjvalaCustomer.BPL"));
	}

	/**
	 * TC 09 perform contact dedup.
	 */
	@Test
	public void TC09_performContactDedup() {

		test.contactPage.performContactDedup();
		test.contactPage.navigateToPaymentProfile();
		test.contactPage.addPaymentBankDetails();
		test.contactPage.navigateToGeneralConnectionSummary();
	}

	/**
	 * TC 10 navigate to ujjwala connection summary.
	 */
	@Test
	public void TC10_navigateToUjjwalaConnectionSummary() {

		test.contactPage.navigateToUjjwalaConnectionSummary();
	}

	/**
	 * TC 11 create new realation ship.
	 */
	@Test
	public void TC11_createNewRealationShip() {

		test.ujvalaActions.createNewRelationShipUjvala();
	}

	/**
	 * TC 12 add house hold.
	 */
	@Test
	public void TC12_addHouseHold() {

		test.ujvalaActions.addHouseHold();
	}


	/**
	 * TC 14 add identity ration card.
	 */
	@Test
	public void TC14_addIdentityRationCard() {

		test.ujvalaActions.addNewIdentity();
		test.ujvalaActions.addIdentityRationCard();
	}

	/**
	 * TC 15 add identity internal ujvala.
	 */
	@Test
	public void TC15_addIdentityInternalUjvala() {

		test.ujvalaActions.addNewIdentity();
		test.ujvalaActions.addIdentityInternalUjvala();
	}

	/**
	 * TC 16 add identity internal ujvala certificate.
	 */
	@Test
	public void TC16_addIdentityInternalUjvalaCertificate() {

		test.ujvalaActions.addNewIdentity();
		test.ujvalaActions.addIdentityInternalUjvalaCertificate();
		test.ujvalaActions.performSave();
	}

	/**
	 * TC 17 add attachment for aadhar ration and point exclusion declaration.
	 */
	@Test
	public void TC17_addAttachmentForAadharRationAndPointExclusionDeclaration() {

		test.ujvalaActions.addAttachmentForAadhar("Aadhaar");
		test.ujvalaActions.addAttachmentForAadhar("Ration Card");
		test.ujvalaActions.addAttachmentForAadhar("Point Exclusion Declaration");
		test.ujvalaActions.performSave();
	}

	/**
	 * TC 18 add payment bank details.
	 */
	@Test
	public void TC18_addPaymentBankDetails() {

		test.ujvalaActions.releaseWaitState(test.getYamlVal("environment"));
		test.contactPage.navigateToPaymentProfile();
	}

	/**
	 * TC 19 drill down relation ship.
	 */
	@Test
	public void TC19_drillDownRelationShip() {

		test.contactPage.navigateToUjjwalaConnectionSummary();
		test.ujvalaActions.performSave();
		test.ujvalaActions.drillDownRelationShip();
	}

	/**
	 * TC 20 relation ship drill down and set scheme.
	 */
	@Test
	public void TC20_relationShipDrillDownAndSetScheme() {

		test.ujvalaActions.relationShipDrillDownAndSetScheme(test.getYamlVal("UjvalaCustomer.RelationShipScheme.Scheme"),
				test.getYamlVal("UjvalaCustomer.RelationShipScheme.SchemeType"), test.getYamlVal("UjvalaCustomer.RelationShipScheme.SubType"),
				"Ujjwala - 14.2 Kg General Package", test.getYamlVal("UjvalaCustomer.RelationShipScheme.ServiceArea"));
	}

	/**
	 * TC 21 navigate to document and create document.
	 */
	@Test
	public void TC21_navigateToDocumentAndCreateDocument() {

		test.contactPage.navigateToDocumentAndCreateDocument(test.getYamlVal("UjvalaCustomer.Document.Type"),
				test.getYamlVal("UjvalaCustomer.Document.SubType"));
	}

	/**
	 * TC 22 created line items.
	 */
	@Test
	public void TC22_createdLineItems() {

		test.ujvalaActions.createdLineItems(test.getYamlVal("UjvalaCustomer.Loan"));
	}

	/**
	 * TC 23 submit document.
	 */
	@Test
	public void TC23_submitDocument() {

		test.contactPage.submitDocument();
	}

	/**
	 * TC 24 invoice document.
	 */
	@Test
	public void TC24_invoiceDocument() {

		test.contactPage.invoiceDocument();
	}

	/**
	 * TC 25 verify installation.
	 */
	@Test
	public void TC25_verifyInstallation() {

		test.contactPage.verifyInstallation();
		relNumber = test.ujvalaActions.get_RelationShipNumber();
	}

	/**
	 * TC 26 verify relationship status.
	 */
	@Test
	public void TC26_verifyRelationshipStatus() {

		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
		test.contactPage.verifyRelationShipStatus(relNumber);
		test.contactPage.verifyConsumerType("SBC");
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public static void tearDownSession() {
		Utilities.writeRelationShipNumberInTxtFile(relNumber, test.getYamlVal("environment").toLowerCase());
		if (test.getYamlVal("Debug").toLowerCase().contains("yes")) {
			test.closeBrowserSession();
		}
		extent.flush();
	}
}
