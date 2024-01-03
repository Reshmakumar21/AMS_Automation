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
	@Test(priority = 1)
	public void TC01_EnterLoginInfo() {
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
		test.homePage.verifyHomePageDisplay();
	}

	/* TC to navigate to Account tab for new account creation */
	@Test(priority = 2)
	public void TC02_NavigateToAccountTab() {
		test.accountsPage.navigateToAccountsTab();
	}

	/* TC to create new account for FTL order creation */
	@Test(priority = 3)
	public void TC03_CreateNewAccount() {
		String accountName;
		test.accountsPage.createNewContact();
		accountName = test.accountsPage.enterAccountDetails();
		test.accountsPage.clickOnAccountLnk(accountName);
		test.accountsPage.addPaymentProfile(accountName);
		test.accountsPage.accountDedup();
	}

	/* TC to navigate to relationship tab under new account creation */
	@Test(priority = 4)
	public void TC04_NavigateToRelationshipsTabUnderAccount() {
		test.accountsPage.relationShipTabNavigation();
	}

	/* TC to create new site under new account creation for FTL order */
	@Test(priority = 5)
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
	@Test(priority = 6)
	public void TC06_CreateNewRelationShip() {
		test.accountsPage.addNewRelationShip();
		test.accountsPage.addNewRelationShipDetails();
	}

	/* TC to tick the checkbox for Reseller flag */
	@Test(priority = 7)
	public void TC07_TickCheckboxReSellerFlag() {
		test.accountsPage.tickFTLResellerFlag();
	}

	/* TC to navigate to secondary sales order tab */
	@Test(priority = 8)
	public void TC08_NavigateToSecondarySalesOrderTab() {
		test.accountsPage.navigateToSecondarySalesTab();
	}

	/* TC to verify secondary sales plus button */
	@Test(priority = 9)
	public void TC09_VerifySecondarySalesPlusButton() {
		test.accountsPage.verifySecondarySalesPlusButtonStatus();
	}

	/* TC to unTick the checkbox for Reseller flag */
	@Test(priority = 10)
	public void TC10_UnTickCheckBoxReSellerFlag() {
		test.accountsPage.unTickFTLResellerFlag();
	}

	/* TC to click plus button under secondary sales order applet */
	@Test(priority = 11)
	public void TC11_ClickAddButtonSecondarySalesOrder() {
		test.accountsPage.clickSecondarySalesPlusButton();
	}

	/* TC to select order sub type and drill down sales order */
	@Test(priority = 12)
	public void TC12_SelectOrderSubType() {
		test.contactPage.selectOrderSubType("FTL Sales");
	}

	/* TC add products for secondary sales order of FTL order */
	@Test(priority = 13)
	public void TC13_AddProducts() {
		test.contactPage.addProductsFTLSales();
	}

	/* TC verify payment tab under Invoice page */
	@Test(priority = 14)
	public void TC14_VerifyPayments() {
		test.contactPage.verifySecondarySalesOrderPayment();
	}

	/**
	 * Tear down session.
	 */
	  @AfterClass(alwaysRun=true)
	    public  void tearDownSession() {
	            test.closeBrowserSession();

	    }

}
