package com.ibm.Test.NFR_FTL;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

public class FTL_AccountOnboarding extends SuperTest {
	/**
	 * The test.
	 */
	TestSessionInitiator test;
	/**
	 * The driver.
	 */
	WebDriver driver;

	/**
	 * Test Case 00 set up.
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
	 * Test Case 01 enter login info.
	 */
	@Test
	public void TC01_EnterLoginInfo() {
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
		test.homePage.verifyHomePageDisplay();
	}

	/* TC to navigate to Account tab for new account creation */
	@Test
	public void TC02_NavigateToAccountTab() {
		test.accountsPage.navigateToAccountsTab();
	}

	/* TC to create new account for FTL order creation */
	@Test
	public void TC03_CreateNewAccount() {
		String accountName;
		test.accountsPage.createNewContact();
		accountName = test.accountsPage.enterAccountDetails();
		test.accountsPage.clickOnAccountLnk(accountName);
		test.accountsPage.addPaymentProfile(accountName);
		test.accountsPage.accountDedup();
	}

	/* TC to navigate to relationship tab under new account creation */
	@Test
	public void TC04_NavigateToRelationshipsTabUnderAccount() {
		test.accountsPage.relationShipTabNavigation();
	}

	/* TC to create new site under new account creation for FTL order */
	@Test
	public void TC05_CreateNewSite() {
		test.accountsPage.addNewSite();
		test.accountsPage.addNewSiteDetails();
		test.accountsPage.addNewAddressAccount(test.getYamlVal("NewCustomer.Address.Line1"),
				test.getYamlVal("NewCustomer.Address.Line2"), test.getYamlVal("NewCustomer.Address.Line3"),
				test.getYamlVal("NewCustomer.Address.Area"), test.getYamlVal("NewCustomer.Address.PinCode"),
				test.getYamlVal("NewCustomer.Address.City"), test.getYamlVal("NewCustomer.Address.Urban"));
		// test.accountsPage.siteDeDup();
	}

	/* TC to create new relationship for FTL order of new account onboarded */
	@Test
	public void TC06_CreateNewRelationShip() {
		test.accountsPage.addNewRelationShip();
		test.accountsPage.addNewRelationShipDetails();
	}

	/* TC to tick the checkbox for Reseller flag */
	@Test
	public void TC07_TickCheckboxReSellerFlag() {
		test.accountsPage.tickFTLResellerFlag();
	}

	/* TC to navigate to secondary sales order tab */
	@Test
	public void TC08_NavigateToSecondarySalesOrderTab() {
		test.accountsPage.navigateToSecondarySalesTab();
	}

	/* TC to verify secondary sales plus button */
	@Test
	public void TC09_VerifySecondarySalesPlusButton() {
		test.accountsPage.verifySecondarySalesPlusButtonStatus();
	}

	/* TC to unTick the checkbox for Reseller flag */
	@Test
	public void TC10_UnTickCheckBoxReSellerFlag() {
		test.accountsPage.unTickFTLResellerFlag();
	}

	/* TC to click plus button under secondary sales order applet */
	@Test
	public void TC11_ClickAddButtonSecondarySalesOrder() {
		test.accountsPage.clickSecondarySalesPlusButton();
	}

	/* TC to select order sub type and drill down sales order */
	@Test
	public void TC12_SelectOrderSubType() {
		test.contactPage.selectOrderSubType("FTL Sales");
	}

	/* TC add products for secondary sales order of FTL order */
	@Test
	public void TC13_AddProducts() {
		test.contactPage.addProductsFTLSales();
	}

	/* TC verify payment tab under Invoice page */
	@Test
	public void TC14_VerifyPayments() {
		test.contactPage.verifySecondarySalesOrderPayment();
	}

	/**
	 * Tear down session.
	 */
	  @AfterClass
	    public  void tearDownSession() {
	            test.closeBrowserSession();
	        
	    }

}
