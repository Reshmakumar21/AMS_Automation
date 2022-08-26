package com.ibm.Test.Portal.ServiceRequests;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The Class Customer Portal Mobile Number Update.
 */

public class CustomerMobileUpdate extends SuperTest {
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
     * TC enter login info.
     */
    @Test
    public void TC01_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment")
                + ".Portal.Customer.URL"));
        test.login.LoginToPortal(test.getYamlVal("" + test.getYamlVal("environment")
                        + ".Portal.Customer.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment")
                        + ".Portal.Customer.Password"));
        test.login.clickOnSighInButton();
    }

    /**
     * TC customer navigate to LPG link.
     */
    @Test
    public void TC02_NavigateToLPGLink() {
        test.portalPage.navigateToLPGLink();
    }

    /**
     * TC customer navigate to EDIT profile link.
     */
    @Test
    public void TC03_NavigateToEditProfileLink() {
        test.portalPage.navigateToEditProfileLink();
    }

    /**
     * TC customer navigate to add new email-id link.
     */
    @Test
    public void TC04_NavigateToAddNewEmailLink() {
        test.portalPage.navigateToAddNewMobileNumber();
    }

    /**
     * TC customer input new mobile number.
     */
    @Test
    public void TC05_CustomerInputNewMobileNumber() {
        test.portalPage.customerInputNewMobileNumber();
    }

    /**
     * TC customer submit new mobile number.
     */
    @Test
    public void TC06_CustomerSubmitNewMobileNumber() {
        test.portalPage.submitServiceRequest();
    }

    /**
     * TC customer input OTP verification for new email.
     */
    @Test
    public void TC07_CustomerInputOTPForNewMobileNumber() {
        test.portalPage.inputOTPForNewMobileNumber();
    }

    /**
     * TC customer click verify OTP for new email.
     */
    @Test
    public void TC08_CustomerVerifyOTPForNewMobileNumber() {
        test.portalPage.verifyOTPForNewServiceRequest();
    }

    /**
     * TC email address service request confirmation message.
     */
    @Test
    public void TC09_MobileNumberConfirmationMessage() {
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

    /**
     * TC siebel Validation.
     */
    @Test
    public void TC13_SiebelValidationsMobileUpdateVerification() {
        test.portalPage.siebelValidationProfileSR("mobile");
    }

    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}
