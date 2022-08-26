/* 
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2020-03-19
 * 
 */
package com.ibm.Test.LOKAM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Lead Generation of LPG.
 */
public class Lead extends SuperTest {
	/** The test. */
	TestSessionInitiator test;
	/** The driver. */
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
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".FO.URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".FO.UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".FO.Password"));
		test.homePage.verifyHomePageDisplay();
	}


	/**
	 * Test Case 02 navigate to contact tab.
	 */
	@Test
	public void TC02_NavigateToLeadTab() {
		test.lokamPage.navigateToLeadTab();
	}

	/**
	 * Test Case 03 Create New Lead.
	 */
	@Test
	public void TC03_CreateNewLead() {
		test.lokamPage.createNewLead();
	}

	/**
	 * Test Case 04 Search Prospect Individual.
	 */
	@Test
	public void TC04_SearchProspect() {
		test.lokamPage.searchProspectIndividual();
	}

	/**
	 * Test Case 05 Add Prospect.
	 */
	@Test
	public void TC05_InputProspectDetails() {
		test.lokamPage.inputProspectDetails(test.getYamlVal("NewCustomer.Salutation"),
				test.getYamlVal("NewCustomer.FirstName"), test.getYamlVal("NewCustomer.LastName"),
				test.getYamlVal("NewCustomer.Address.Line1"), test.getYamlVal("NewCustomer.Address.PinCode"),
				test.getYamlVal("NewCustomer.Address.City"));
	}

	/**
	 * Test Case 06 Convert lead button.
	 */
	@Test
	public void TC06_ConvertLead() {
		test.lokamPage.convertLead();
	}

	/**
	 * Test Case 07 Convert lead button.
	 */
	@Test
	public void TC07_NavigateToContact() {
		test.lokamPage.navigateToContact();
	}

	/**
	 * Test Case 08 Perform Contact Dedup.
	 */
	@Test
	public void TC08_PerformContactDedup() {
		test.lokamPage.performContactDedup();
	}

	/**
	 * Test Case 09 navigate to opportunity tab.
	 */
	@Test
	public void TC09_NavigateToOpportunityTab() {
		test.lokamPage.navigateToOpportunityTab();
	}

	/**
	 * Test Case 10 convert opportunity.
	 */
	@Test
	public void TC10_ConvertOpportunity() {
		test.lokamPage.convertOpportunity();
	}

	/**
	 * Test Case 11 Validate RelationShip Details.
	 */
	@Test
	public void TC11_ValidateRelationShip() {
		test.lokamPage.validateRelationShipStatus();
	}

	/**
	 * Tear down session.
	 */
	@AfterClass
	public void tearDownSession() {
		test.closeBrowserSession();
	}
}
