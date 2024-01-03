package com.ibm.Test.Portal.ServiceRequests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;


/**
 * The Class Customer Portal Profile Photo.
 */
public class CustomerProfilePhoto extends SuperTest {

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
     * TC search for relation ship.
     */
    @Test
    public void TC02_NavigateToLPGLink() {
        test.portalPage.navigateToLPGLink();

    }

    /**
     * User navigate to  EDIT LPG  profile
     */
    @Test
    public void TC03_NavigateToLPGEdit() {
        test.portalPage.navigateToEditProfileLink();
    }


    /**
     * User click to upload photo
     */
    @Test
    public void TC04_UploadProfilePhoto() {
       test.portalPage.uploadProfilePhoto();
    }

    /**
     * Getting confirmation message text and SR number
     */
    @Test
    public void TC05_ProfilePhotoConfirmationMessage() {
        test.portalPage.portalServiceRequestConfirmationMessage();
    }

    /**
     * user logout from session
     */
    @Test
    public void TC11_CustomerLogsOut() {
        test.portalPage.customerLogOut();
    }

     /**
     * TC siebel login.
     */
    @Test
    public void TC12_SiebelLogin() {
        test.portalPage.siebelLogin();
    }

    /**
     * TC user search service request number in siebel.
     */
    @Test
    public void TC13_SearchNameChangeSR() {
        test.portalPage.siebelProfileSRSearch();
    }

    /**
     * TC siebel Validation.
     */
    @Test
    public void TC14_SiebelValidationProfilePhoto() {
        test.portalPage.siebelValidationProfileSR("photo");
    }

    /*
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}
