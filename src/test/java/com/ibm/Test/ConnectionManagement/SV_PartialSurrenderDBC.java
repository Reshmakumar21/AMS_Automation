package com.ibm.Test.ConnectionManagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

public class SV_PartialSurrenderDBC extends SuperTest {
    /**
     * The rel number.
     */
    static String relNumber;
    /**
     * The test.
     */
    TestSessionInitiator test;
    /**
     * The driver.
     */
    WebDriver driver;

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
     * TC 02 search for relation ship.
     */
    @Test
    public void TC02_SearchForRelationShip() {
        test.homePage.launchRelationShipTab();
        test.homePage.searchForRelationShipNumber(relNumber);
    }

    /**
     * TC 03 relation ship drill down.
     */
    @Test
    public void TC03_RelationShipDrillDown() {
        test.homePage.openRelationShipFromSearchResult();
    }

    @Test
    public void TC04_navigateToDocumentAfterRelationShipTab() {
        test.contactPage.navigateToDocumentAfterRelationShipTab();
    }

    @Test
    public void TC06_addNewDocument() {
        test.ttvConMngPage.addNewDocument();
    }

    @Test
    public void TC07_addNewDocumentAndSelectType() {
        test.ttvConMngPage.addNewDocumentAndSelectType("SV", "Partial Surrender");
    }

    @Test
    public void TC08_createDefaultDocument() {
        test.ttvConMngPage.createDefaultDocument();
    }


    @Test
    public void TC10_AddComment() {
        test.ttvConMngPage.AddComment();
    }

    @Test
    public void TC11_submitAndInvoiceDocument() {
        test.ttvConMngPage.submitAndInvoiceDocument();
    }

    @Test
    public void TC12_invoiceComplete() {
        test.ttvConMngPage.invoiceComplete();
    }

    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}
