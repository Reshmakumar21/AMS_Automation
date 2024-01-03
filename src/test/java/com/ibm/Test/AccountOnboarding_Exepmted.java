/*
 * @author Shivam Tiwari
 * @version 2.2
 * @since 2020-04-25
 * UpdateDate 2021-02-12
 */
package com.ibm.Test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class AccountOnboarding_Exepmted.
 */
public class AccountOnboarding_Exepmted extends SuperTest {

    /**
     * The rel number.
     */
    static String relNumber;
    /**
     * The account name.
     */
    static String accountName;
    /**
     * The test.
     */
    TestSessionInitiator test;

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

    /**
     * TC 02 navigate to contact tab.
     */
    @Test
    public void TC02_NavigateToContactTab() {
        test.accountsPage.navigateToAccountsTab();
    }

    /**
     * TC 03 create new contact.
     */
    @Test
    public void TC03_CreateNewContact() {
        test.accountsPage.createNewContact();
    }

    /**
     * TC 04 enter account details.
     */
    @Test
    public void TC04_EnterAccountDetails() {
        accountName = test.accountsPage.enterAccountDetails();
    }

    /**
     * TC 05 click on account lnk by new create account.
     */
    @Test
    public void TC05_NavigateViaAccountLink() {
        test.accountsPage.clickOnAccountLnk(accountName);
    }

    /**
     * TC 06 add payment profile.
     */
    @Test
    public void TC06_AddPaymentProfile() {
        test.accountsPage.addPaymentProfile(accountName);
    }

    /**
     * TC 07 account dedup.
     */
    @Test
    public void TC07_AccountDedup() {
        test.accountsPage.accountDedup();
    }

    /**
     * TC 08 relation ship tab navigation.
     */
    @Test
    public void TC08_RelationShipTabNavigation() {
        test.accountsPage.relationShipTabNavigation();
    }

    /**
     * TC 09 add new site.
     */
    @Test
    public void TC09_AddNewSite() {
        test.accountsPage.addNewSite();
    }

    /**
     * TC 10 add new site details.
     */
    @Test
    public void TC10_AddNewSiteDetails() {
        test.accountsPage.addNewSiteDetails();
    }

    /**
     * TC 11 add new address account.
     */
    @Test
    public void TC11_AddNewAddressAccount() {
        test.accountsPage.addNewAddressAccount(test.getYamlVal("NewCustomer.Address.Line1"),
                test.getYamlVal("NewCustomer.Address.Line2"), test.getYamlVal("NewCustomer.Address.Line3"),
                test.getYamlVal("NewCustomer.Address.Area"), test.getYamlVal("NewCustomer.Address.PinCode"),
                test.getYamlVal("NewCustomer.Address.City"), test.getYamlVal("NewCustomer.Address.Urban"));
    }

    /**
     * TC 12 site de dup.
     */
    @Test
    public void TC12_SiteDeDup() {
        test.accountsPage.siteDeDup();
    }

    /**
     * TC 13 create new relation ship.
     */
    @Test
    public void TC13_CreateNewRealationShip() {
        relNumber = test.accountsPage.createNewRelationShip(test.getYamlVal("environment"));
    }

    /**
     * TC 14 relation ship drill down and set scheme.
     */
    @Test
    public void TC14_RelationShipDrillDownAndSetScheme() {
        test.accountsPage.relationShipDrillDownAndSetAccountScheme("Exempted", "Hostel",
                "14.2 Kg Exempted Package with PR", test.getYamlVal("NewCustomer.RelationShipScheme.ServiceArea"));
        //test.accountsPage.enterNumberOfFlats();
    }

    /**
     * TC 15 navigate to document and create document.
     */
    @Test
    public void TC15_NavigateToDocumentAndCreateDocument() {
        test.contactPage.navigateToDocumentAndCreateDocument(test.getYamlVal("NewCustomer.Document.Type"),
                test.getYamlVal("NewCustomer.Document.SubType"));
    }

    /**
     * TC 16 created line items.
     */
    @Test
    public void TC16_CreateLineItems() {
        test.accountsPage.createdLineItems("SBC");
        test.accountsPage.enterMakeMonthYear();
    }

    /**
     * TC 17 submit document.
     */
    @Test
    public void TC17_SubmitDocument() {
        test.accountsPage.submitDocument();
    }

    /**
     * TC 18 approval from Area Manager.
     */
    @Test
    public void TC18_AreaManagerApproval() {
        test.accountsPage.documentApprovalByAreaManager("Approve");
    }

    /**
     * TC 19 submit document.
     */
    @Test
    public void TC19_SubmitDocument() {
        test.contactPage.submitDocument();
    }

    /**
     * TC 20 invoice document.
     */
    @Test
    public void TC20_InvoiceDocument() {
        test.contactPage.invoiceDocument();
    }

    /**
     * TC 21 verify installation.
     */
    @Test
    public void TC21_VerifyInstallation() {
        test.contactPage.verifyInstallation();
    }

    /**
     * TC 22 verify relationship status.
     */
    @Test
    public void TC22_VerifyRelationshipStatus() {
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
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (test.getYamlVal("Debug").toLowerCase().contains("nodebug")) {
            test.closeBrowserSession();
        }
    }
}
