package com.ibm.Test.SR;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * The Class Profile_SR_Aadhar_Delinking.
 */
public class SR_AadharDeLinking extends SuperTest {
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
    String relNumber;


    /**
     * TC 00 set up.
     *
     * @throws Exception
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

    /* TC Drilldown last name */
    @Test
    public void TC03_LastNameDrillDown() {
        test.contactPage.afterRelationShipSearchClickOnLastName();
    }

    /* TC to store MDMuID value */
    @Test
    public void TC04_NavigateToMoreInfoTabToObtainMDM_UID() {
        test.profileSRPage.getMDMUID();
    }

    /* TC to clean existing SR statuses */
    @Test @Ignore
    public void TC05_CleanExistingSRStatuses() {
        test.profileSRPage.connectDBToUpdateAllSRStatusToClose(relNumber);
    }

    /* TC navigate to profile SR tab */
    @Test
    public void TC06_NavigateToProfileSRTab() {
        test.contactPage.navigateToProfileSRContactPage();
    }

    /* TC select transaction type under Service Request List Applet */
    @Test
    public void TC07_SelectTransactionType() {

        test.profileSRPage.selectTransactionType("Aadhar Seeding");
    }

    /* TC Drill down SR Number under Service Request List Applet */
    @Test
    public void TC08_DrillDownSRNumber() {

        test.profileSRPage.drillDownSRNumber();
    }

    /* TC perform aadhar seeding activity */
    @Test
    public void TC09_SeedAadhar() {

        test.profileSRPage.seedAadhar();
		test.profileSRPage.addAttachmentForProfileSR("Aadhaar(UID)");
    }

    /* Click submit button */
    @Test
    public void TC10_SubmitSRVerifyOMCDedup() {

        test.profileSRPage.submitSRVerifyOMCDedup();
    }

    /* Verify profile SR status */
    @Test
    public void TC11_VerifyProfileSRStatus() {

        test.profileSRPage.verifySRStatus("Closed");
    }

    /* Navigate back to previous page */
    @Test
    public void TC12_NavigateBack() {

        test.profileSRPage.navigateBack(2);
    }

    /* TC select transaction type under Service Request List Applet */
    @Test
    public void TC13_SelectTransactionType() {

        test.profileSRPage.selectTransactionType("Aadhar Delinking");
    }

    /* TC Drill down SR Number under Service Request List Applet */
    @Test
    public void TC14_DrillDownSRNumber() {

        test.profileSRPage.drillDownSRNumber();
    }

    /* TC Drill down SR Number under Service Request List Applet */
    @Test
    public void TC15_InputLinkedAadharNumber() {

        test.profileSRPage.deSeedAadhar();
    }

    /* Click submit button */
    @Test
    public void TC16_ClickSubmit() {

        test.profileSRPage.submitSR();
    }

    /* FO Approval */
    @Test
    public void TC17_ApprovalFO() {

        test.profileSRPage.FODecision("Approve");

    }

    /* Verify profile SR status */
    @Test
    public void TC18_VerifyProfileSRStatus() {

        test.profileSRPage.verifySRStatus("Closed");
    }

    /* Verify MDM */
    @Test
    public void TC19_VerifyMDM() {

        test.profileSRPage.verifyMDM("aadhar");
    }

    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}

