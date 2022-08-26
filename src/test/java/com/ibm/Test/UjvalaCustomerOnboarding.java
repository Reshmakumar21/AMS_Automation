package com.ibm.Test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

public class UjvalaCustomerOnboarding extends SuperTest {
	static TestSessionInitiator test = new TestSessionInitiator();

	WebDriver driver;


	static String relNumber;


	@BeforeClass
	public void TC00_SetUp() {
		System.out.println();
		System.out.println("***********Before Class ********");
		System.out.println();
		Utilities.setYamlFilePath("integration_testData.yml");
		test = new TestSessionInitiator();
	}

	@Test
	public void TC01_EnterLoginInfo() {
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
	}

	@Test
	public void TC02_NavigateToContactTab() {
		
		test.contactPage.naviagteToContactTab();
	}

	@Test
	public void TC03_createNewContact() {
		
		test.contactPage.createNewContact();
	}

	@Test
	public void TC04_enterNewCustomerInformation() {
		
		test.contactPage.enterNewCustomerInformation(test.getYamlVal("UjvalaCustomer.Salutation"), test.getYamlVal("UjvalaCustomer.FirstName"),
				test.getYamlVal("UjvalaCustomer.LastName"), test.getYamlVal("UjvalaCustomer.Gender"), test.getYamlVal("UjvalaCustomer.DOB"));
	}

	@Test
	public void TC05_addNewAddress() {
		
		test.contactPage.addNewAddress(test.getYamlVal("UjvalaCustomer.Address.Line1"), test.getYamlVal("UjvalaCustomer.Address.Line2"),
				test.getYamlVal("UjvalaCustomer.Address.Line3"), test.getYamlVal("UjvalaCustomer.Address.Area"),
				test.getYamlVal("UjvalaCustomer.Address.PinCode"), test.getYamlVal("UjvalaCustomer.Address.City"),
				test.getYamlVal("UjvalaCustomer.Address.Urban"));
	}

	@Test
	public void TC06_addIdentitiesForNewCustomer() {
		
		test.contactPage.addIdentitiesForNewCustomer(test.getYamlVal("UjvalaCustomer.Identities.IdentityType"),
				test.getYamlVal("UjvalaCustomer.Identities.IdentityMethod"), test.getYamlVal("UjvalaCustomer.Identities.IdentityNumber"));
		test.contactPage.addIdentitiesForNewCustomerAadhar(test.getYamlVal("NewCustomer.Identities.IdentityType"),
				test.getYamlVal("NewCustomer.Identities.IdentityMethod"));
	}

	@Test
	public void TC08_enterBPLForNewCustomer() {
		
		test.contactPage.enterBPLForNewCustomer(test.getYamlVal("UjvalaCustomer.BPL"));
	}

	@Test
	public void TC09_performContactDedup() {
		
		test.contactPage.performContactDedup();
		test.contactPage.navigateToPaymentProfile();
		test.contactPage.addPaymentBankDetails();
		test.contactPage.navigateToGeneralConnectionSummary();
	}

	@Test
	public void TC10_navigateToUjjwalaConnectionSummary() {
		
		test.contactPage.navigateToUjjwalaConnectionSummary();
	}

	@Test
	public void TC11_createNewRealationShip() {
		
		test.ujvalaActions.createNewRelationShipUjvala();
	}

	@Test
	public void TC12_addHouseHold() {
		
		test.ujvalaActions.addHouseHold();
	}


	@Test
	public void TC14_addIdentityRationCard() {
		
		test.ujvalaActions.addNewIdentity();
		test.ujvalaActions.addIdentityRationCard();
	}

	@Test
	public void TC15_addIdentityInternalUjvala() {
		
		test.ujvalaActions.addNewIdentity();
		test.ujvalaActions.addIdentityInternalUjvala();
	}

	@Test
	public void TC16_addIdentityInternalUjvalaCertificate() {
		
		test.ujvalaActions.addNewIdentity();
		test.ujvalaActions.addIdentityInternalUjvalaCertificate();
		test.ujvalaActions.performSave();
	}

	@Test
	public void TC17_addAttachmentForAadharRationAndPointExclusionDeclaration() {
		
		test.ujvalaActions.addAttachmentForAadhar("Aadhaar");
		test.ujvalaActions.addAttachmentForAadhar("Ration Card");
		test.ujvalaActions.addAttachmentForAadhar("Point Exclusion Declaration");
		test.ujvalaActions.performSave();
	}

	@Test
	public void TC18_addPaymentBankDetails() {
		
		test.ujvalaActions.releaseWaitState(test.getYamlVal("environment"));
		test.contactPage.navigateToPaymentProfile();
	}

	@Test
	public void TC19_drillDownRelationShip() {
		
		test.contactPage.navigateToUjjwalaConnectionSummary();
		test.ujvalaActions.performSave();
		test.ujvalaActions.drillDownRelationShip();
	}

	@Test
	public void TC20_relationShipDrillDownAndSetScheme() {
		
		test.ujvalaActions.relationShipDrillDownAndSetScheme(test.getYamlVal("UjvalaCustomer.RelationShipScheme.Scheme"),
				test.getYamlVal("UjvalaCustomer.RelationShipScheme.SchemeType"), test.getYamlVal("UjvalaCustomer.RelationShipScheme.SubType"),
				"Ujjwala - 14.2 Kg General Package", test.getYamlVal("UjvalaCustomer.RelationShipScheme.ServiceArea"));
	}

	@Test
	public void TC21_navigateToDocumentAndCreateDocument() {
		
		test.contactPage.navigateToDocumentAndCreateDocument(test.getYamlVal("UjvalaCustomer.Document.Type"),
				test.getYamlVal("UjvalaCustomer.Document.SubType"));
	}

	@Test
	public void TC22_createdLineItems() {
		
		test.ujvalaActions.createdLineItems(test.getYamlVal("UjvalaCustomer.Loan"));
	}

	@Test
	public void TC23_submitDocument() {
		
		test.contactPage.submitDocument();
	}

	@Test
	public void TC24_invoiceDocument() {
		
		test.contactPage.invoiceDocument();
	}

	@Test
	public void TC25_verifyInstallation() {
		
		test.contactPage.verifyInstallation();
		relNumber = test.ujvalaActions.get_RelationShipNumber();
	}

	@Test
	public void TC26_verifyRelationshipStatus() {
		
		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
		test.contactPage.verifyRelationShipStatus(relNumber);
		test.contactPage.verifyConsumerType("SBC");
	}

	@AfterClass
	public static void tearDownSession() {
		Utilities.writeRelationShipNumberInTxtFile(relNumber, test.getYamlVal("environment").toLowerCase());
		if (test.getYamlVal("Debug").toLowerCase().contains("yes")) {
			test.closeBrowserSession();
		}
		extent.flush();
	}
}
