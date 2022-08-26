package com.ibm.Test.Portal.ServiceRequests;

import com.aventstack.extentreports.ExtentTest;
import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * The Class Customer Portal Name Change.
 */
public class CustomerNameChange extends SuperTest {

    /**
     * The logger.
     */
    static ExtentTest logger;
    /**
     * The rel number.
     */
    static String relNumber;
    /**
     * The test.
     */
    TestSessionInitiator test;

    /**
     * TC 00 set up.
     */
    @BeforeClass
    public void TC00_SetUp() throws Exception {
        Utilities.setYamlFilePath("integration_testData.yml");
        test = new TestSessionInitiator();
    }

    /**
     * TC dB connected to update name change flag.
     */
    @Test
    public void TC01_ConnectDBtoUpdateNameChangeQuery() {
        test.portalPage.executeNameChangeFlagQueryInDB("7200000000008642");
    }

    /**
     * TC enter login info.
     */
    @Test
    public void TC02_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment")
                + ".Portal.Customer.URL"));
        test.login.LoginToPortal(test.getYamlVal("" + test.getYamlVal("environment")
                        + ".Portal.Customer.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment")
                        + ".Portal.Customer.Password"));
        test.login.clickOnSighInButton();
    }

    /**
     * TC search for relation ship.
     */
    @Test
    public void TC03_NavigateToLPGLink() {
        test.portalPage.navigateToLPGLink();
    }

    /**
     * TC User navigate to  EDIT LPG  profile.
     */
    @Test
    public void TC04_NavigateToLPGEdit() {
        test.portalPage.navigateToEditProfileLink();
    }

    /**
     * TC User navigate to name EDIT hyperlink.
     */
    @Test
    public void TC05_NavigateToNameEdit() {
        test.portalPage.navigateToEditName();
    }

    /**
     * TC User input new name details.
     */
    @Test
    public void TC06_InputNewNameDetails() {
        test.portalPage.inputNewNameDetails();
    }

    /**
     * User attach POI document.
     */
    @Test
    public void TC07_AttachRequiredDocument() {
        test.portalPage.inputPOIAttachment();
    }

    /**
     * User Submit name change.
     */
    @Test
    public void TC08_SubmitSR() {
        test.portalPage.submitServiceRequest();
    }

    /**
     * TC name change service request confirmation message.
     */
    @Test
    public void TC09_NameChangeConfirmationMessage() {
        test.portalPage.portalServiceRequestConfirmationMessage();
    }

    /**
     * TC confirmation message validation.
     */
    @Test
    public void TC10_CustomerLogsOut() {
        test.portalPage.customerLogOut();
    }

    /**
     * TC siebel login.
     */
    @Test
    public void TC11_SiebelLogin() {
        test.portalPage.siebelLogin();
    }

    /**
     * TC user search service request number in siebel.
     */
    @Test
    public void TC12_SearchNameChangeSR() {
        test.portalPage.siebelProfileSRSearch();
    }

    /*
     * TC submit name change profile SR.
     */
    @Test
    public void TC13_SubmitNameChangeProfileSR() {
        test.profileSRPage.submitSR();
    }

    /**
     * TC siebel Validation.
     */
    @Test
    public void TC14_SiebelValidationAfterSubmit() {
        test.portalPage.siebelValidationProfileSR("name");
    }

    /*
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }

}









