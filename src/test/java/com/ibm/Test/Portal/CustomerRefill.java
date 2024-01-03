package com.ibm.Test.Portal;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Customer Portal Refill.
 */

public class CustomerRefill extends SuperTest {
    /**
     * The test.
     */
    TestSessionInitiator test;

    /**
     * TC 00 set up.
     */
    @BeforeClass(alwaysRun=true)
    public void TC00_SetUp() throws Exception {
        Utilities.setYamlFilePath("integration_testData.yml");
        test = new TestSessionInitiator();
    }

    /**
     * TC enter login info.
     */
    @Test(priority = 1)
    public void TC01_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment")
                + ".Portal.Customer.URL"));
        test.login.LoginToPortal(test.getYamlVal("" + test.getYamlVal("environment")
                        + ".Portal.Customer.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment")
                        + ".Portal.Customer.Password"));
//        test.login.clickOnSighInButton();
    }

    /**
     * TC customer navigate to LPG link.
     */
    @Test(priority = 2)
    public void TC02_NavigateToLPGLink() {
        test.portalPage.navigateToLPGLink();
    }

    /**
     * TC customer navigate to book your cylinder link.
     */
    @Test(priority = 3)
    public void TC03_NavigateToBookCylinder() {
        test.portalPage.navigateToBookCylinder();
    }

    /**
     * TC customer selects the refill product.
     */
    @Test(priority = 4)
    public void TC04_SelectRefillCylinderRequestForProduct() {
        test.portalPage.customerSelectProduct("LPG Refill - 14.2 Kg");
    }

    /**
     * TC customer click the book now button.
     */
    @Test(priority = 5)
    public void TC05_CustomerBookNow() {
        test.portalPage.customerBookNow();
    }

    /**
     * TC customer accept terms & conditions.
     */
    @Test(priority = 6)
    public void TC06_CustomerAcceptTermsAndConditions() {
        test.portalPage.customerAcceptTermsAndCondition();
    }

    /**
     * TC customer PAY.
     */
    @Test(priority = 7)
    public void TC07_CustomerAcceptsPAY() {
        test.portalPage.customerPAY();
    }

    /**
     * TC confirmation message validation.
     */
    @Test(priority = 8)
    public void TC08_ConfirmationMessageValidation() {
        test.portalPage.confirmationMessageValidation();
    }

    /**
     * TC customer select a payment gateway.
     */
    @Test(priority = 9)
    public void TC09_CustomerSelectPaymentGateway() {
        test.portalPage.customerSelectPaymentGateway("AvenuesTest");
    }

    /**
     * TC confirmation message validation.
     */
    @Test(priority = 10)
    public void TC10_CustomerLogsOut() {
        test.portalPage.customerLogOut();
    }

    /**
     * TC siebel login.
     */
    @Test(priority = 11)
    public void TC11_SiebelLogin() {
        test.portalPage.siebelLogin();
    }

    /**
     * TC siebel Validation.
     */
    @Test(priority = 12)
    public void TC12_SiebelValidations() {
        test.portalPage.siebelValidationsRefill("Invoiced");
    }

    /**
     * Tear down session.
     */
    @AfterClass(alwaysRun=true)
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}
