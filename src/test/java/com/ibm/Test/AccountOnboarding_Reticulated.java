package com.ibm.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class AccountOnboarding_Reticulated.
 */
public class AccountOnboarding_Reticulated extends SuperTest {
	/** The test. */
	TestSessionInitiator test;
	/** The driver. */
//	WebDriver driver;
	/** The logger. */
//	static ExtentTest logger;
	/** The rel number. */
	static String relNumber;
	/** The account name. */
	static String accountName;

	/** The name. */
	/**
	 * TC 00 set up.
	 */
	@BeforeClass
	public void TC00_SetUp() {
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
		test.homePage.verifyHomePageDisplay();
	}

	/** The account name. */
	/**

	 */
	@Test
	public void TC02_NavigateToContactTab() {
		test.accountsPage.navigateToAccountsTab();
	}

	/**
	 * TC 03 create new account.
	 */
	@Test
	public void TC03_createNewAccount() {
		test.accountsPage.createNewContact();
	}

	/**
	 * TC 04 enter new account details.
	 */
	@Test
	public void TC04_enterNewAccountDetails() {
		accountName = test.accountsPage.enterAccountDetails();
		System.out.println("accountName : " + accountName);
	}

	/**
	 * TC 05 enter account payment profile.
	 */
	@Test
	public void TC05_enterAccountPaymentProfile() {
		System.out.println("accountName : " + accountName);
		test.accountsPage.clickOnAccountLnk(accountName);
		test.accountsPage.addPaymentProfile(accountName);
	}

	/**
	 * TC 06 add site deatils.
	 */
	@Test
	public void TC06_AddSiteDeatils() {
		test.accountsPage.accountDedup();
	}

	/**
	 * TC 08 relation ship tab navigation.
	 */
	@Test
	public void TC08_relationShipTabNavigation() {
		test.accountsPage.relationShipTabNavigation();
	}

	/**
	 * TC 09 add new site.
	 */
	@Test
	public void TC09_addNewSite() {
		test.accountsPage.addNewSite();
	}

	/**
	 * TC 10 add new site details.
	 */
	@Test
	public void TC10_addNewSiteDetails() {
		test.accountsPage.addNewSiteDetails();
	}

	/**
	 * TC 11 add site details.
	 */
	@Test
	public void TC11_AddSiteDetails() {
		test.accountsPage.addNewAddressAccount(test.getYamlVal("NewCustomer.Address.Line1"),
				test.getYamlVal("NewCustomer.Address.Line2"), test.getYamlVal("NewCustomer.Address.Line3"),
				test.getYamlVal("NewCustomer.Address.Area"), test.getYamlVal("NewCustomer.Address.PinCode"),
				test.getYamlVal("NewCustomer.Address.City"), test.getYamlVal("NewCustomer.Address.Urban"));
		test.accountsPage.siteDeDup();
	}

	/**
	 * TC 12 create new relationship.
	 */
	@Test
	public void TC12_createNewRelationship() {
		relNumber = test.accountsPage.createNewRelationShip(test.getYamlVal("environment"));
	}

	/**
	 * TC 13 relation ship drill down and set scheme.
	 */
	@Test
	public void TC13_relationShipDrillDownAndSetScheme() {
		test.accountsPage.relationShipDrillDownAndSetAccountScheme("Reticulated", "Reticulated",
				"14.2 Kg Reticulated Package", test.getYamlVal("NewCustomer.RelationShipScheme.ServiceArea"));
		test.accountsPage.enterNumberOfFlats();
	}

	/**
	 * TC 14 navigate to document and create document.
	 */
	@Test
	public void TC14_navigateToDocumentAndCreateDocument() {
		test.contactPage.navigateToDocumentAndCreateDocument(test.getYamlVal("NewCustomer.Document.Type"),
				test.getYamlVal("NewCustomer.Document.SubType"));
	}

	/**
	 * TC 15 created line items.
	 */
	@Test
	public void TC15_createdLineItems() {
		test.accountsPage.createdLineItems("SBC");
	}

	/**
	 * TC 16 submit document.
	 */
	@Test
	public void TC16_submitDocument() {
		test.contactPage.submitDocument();
	}

	/**
	 * TC 17 invoice document.
	 */
	@Test
	public void TC17_invoiceDocument() {
		test.contactPage.invoiceDocument();
	}

	/**
	 * TC 18 verify installation.
	 */
	@Test
	public void TC18_verifyInstallation() {
		test.contactPage.verifyInstallation();
	}

	/**
	 * TC 19 verify relationship status.
	 */
	@Test
	public void TC19_verifyRelationshipStatus() {
		test.homePage.launchRelationShipTab();
		test.homePage.searchForRelationShipNumber(relNumber);
		test.contactPage.verifyRelationShipStatus(relNumber);
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public void tearDownSession() {
		try {
			Utilities.writeRelationShipNumberInTxtFile(relNumber, test.getYamlVal("environment").toLowerCase());
			if (test.getYamlVal("Debug").toLowerCase().contains("no")) {

			}
		} catch (Exception e) {
		}

		test.closeBrowserSession();
	}
}
