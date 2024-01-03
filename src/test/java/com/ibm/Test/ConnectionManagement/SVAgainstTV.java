/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Test.ConnectionManagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class SVAgainstTV.
 */
public class SVAgainstTV extends SuperTest {
    /**
     * The test.
     */
    TestSessionInitiator test;

    /**
     * The driver.
     */
    WebDriver driver;


    /**
     * The rel number.
     */
    static String relNumber;

    /**
     * The cust name.
     */
    static String custName;


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
     * TC 02 navigate to contact tab.
     */
    //
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

        test.contactPage.enterNewCustomerInformation(test.getYamlVal("NewCustomer.Salutation"), test.getYamlVal("NewCustomer.FirstName"),
                test.getYamlVal("NewCustomer.LastName"), test.getYamlVal("NewCustomer.Gender"), test.getYamlVal("NewCustomer.DOB"));
        custName = test.contactPage.getFirstName();
    }

    /**
     * TC 05 add new address.
     */
    @Test
    public void TC05_addNewAddress() {

        test.contactPage.addNewAddress(test.getYamlVal("NewCustomer.Address.Line1"), test.getYamlVal("NewCustomer.Address.Line2"),
                test.getYamlVal("NewCustomer.Address.Line3"), test.getYamlVal("NewCustomer.Address.Area"),
                test.getYamlVal("NewCustomer.Address.PinCode"), test.getYamlVal("NewCustomer.Address.City"),
                test.getYamlVal("NewCustomer.Address.Urban"));
    }

    /**
     * TC 06 add identities for new customer.
     */
    @Test
    public void TC06_addIdentitiesForNewCustomer() {

        test.contactPage.addIdentitiesForNewCustomer(test.getYamlVal("NewCustomer.Identities.IdentityType"),
                test.getYamlVal("NewCustomer.Identities.IdentityMethod"), test.getYamlVal("NewCustomer.Identities.IdentityNumber"));
    }

    /**
     * TC 08 enter BPL for new customer.
     */
    @Test
    public void TC08_enterBPLForNewCustomer() {

        test.contactPage.enterBPLForNewCustomer(test.getYamlVal("NewCustomer.BPL"));
    }

    /**
     * TC 09 perform contact dedup.
     */
    @Test
    public void TC09_performContactDedup() {

        test.contactPage.performContactDedup();
    }

    /**
     * TC 10 navigate to general connection summary.
     */
    @Test
    public void TC10_navigateToGeneralConnectionSummary() {

        // test.contactPage.navigateToGeneralConnectionSummary();
    }

    /**
     * TC 11 search for relation ship.
     */
    @Test
    public void TC11_SearchForRelationShip() {

        test.homePage.launchRelationShipTab();
        test.homePage.searchForRelationShipNumber(relNumber);
    }

    /**
     * TC 12 relation ship drill down.
     */
    @Test
    public void TC12_RelationShipDrillDown() {
        test.homePage.openRelationShipFromSearchResult();
    }

    /**
     * TC 13 navigate to document tab and select document type.
     */
    @Test
    public void TC13_navigateToDocumentTabAndSelectDocumentType() {
        test.svAgainstTVConMngPage.navigateToDocumentTab();
        test.svAgainstTVConMngPage.addNewDocumentAndSelectType("TV", "Name Change-Legal Heir");
    }

    /**
     * TC 14 create default document.
     */
    @Test
    public void TC14_createDefaultDocument() {
        test.svAgainstTVConMngPage.createDefaultDocument();
    }

    /**
     * TC 15 select transferrer contact name.
     */
    @Test
    public void TC15_selectTransferreContactName() {
        test.svAgainstTVConMngPage.selectTransferreContactName(custName);
    }

    /**
     * TC 16 submit and invoice document.
     */
    @Test
    public void TC16_submitAndInvoiceDocument() {
        test.svAgainstTVConMngPage.submitDocument();
        test.svAgainstTVConMngPage.invoiceDocument();
    }

    /**
     * TC 17 open invoice document and complete.
     */
    @Test
    public void TC17_openInvoiceDocumentAndComplete() {
        test.svAgainstTVConMngPage.openInvoiceDocumentAndComplete();
    }

    /**
     * TC 18 open order number from invoice.
     */
    @Test
    public void TC18_openOrderNumberFromInvoice() {
        test.svAgainstTVConMngPage.openOrderNumberFromInvoice();
    }

    /**
     * TC 19 search relation ship by name.
     */
    @Test
    public void TC19_searchRelationShipByName() {
        test.svAgainstTVConMngPage.navigateToRelationShipTab();
        test.svAgainstTVConMngPage.searchRelationShipByCustomerName(custName);
        test.svAgainstTVConMngPage.clickOnLastNameAndContactPageDisplay();
    }

    /**
     * TC 20 navigate to document tab and select service area.
     */
    @Test
    public void TC20_navigateToDocumentTabAndSelectServiceArea() {
        test.svAgainstTVConMngPage.navigateToDocumentTab();
        test.svAgainstTVConMngPage.selectServiceArea();
    }

    /**
     * TC 21 open document and create default order.
     */
    @Test
    public void TC21_OpenDocumentAndCreateDefaultOrder() {
        test.svAgainstTVConMngPage.openDocument();
        test.svAgainstTVConMngPage.createDefaultOrder();
    }

    /**
     * TC 21 submit and invoice document.
     */
    @Test
    public void TC22_SubmitAndInvoiceDocument() {
        test.svAgainstTVConMngPage.submitDocumentAndStatus();
        test.svAgainstTVConMngPage.invoiceDocumentAndStatus();
    }

    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}
