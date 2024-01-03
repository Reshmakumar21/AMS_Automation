package com.ibm.Test.Portal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Customer Portal Refill Cancellation.
 */

public class CustomerRefillCancel extends SuperTest {

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
     * TC customer navigate to LPG link.
     */
    @Test
    public void TC02_NavigateToLPGLink() {
        test.portalPage.navigateToLPGLink();
    }

    /**
     * TC customer navigate to LPG link.
     */
    @Test
    public void TC02a_SelectActiveLpgConnection() {
        test.portalPage.selectactinglpgconnection();
    }

    /**
     * TC customer navigate to book your cylinder link.
     */
    @Test
    public void TC03_NavigateToBookCylinder() {
        test.portalPage.navigateToBookCylinder();
    }

    /**
     * TC customer selects the refill product.
     */
    @Test
    public void TC04_SelectRefillCylinderRequestForProduct() {
        test.portalPage.customerSelectProduct("LPG Refill - 14.2 Kg");
    }

    /**
     * TC customer click the book now button.
     */
    @Test
    public void TC05_CustomerBookNow() {
        test.portalPage.customerBookNow();
    }

    /**
     * TC customer accept terms & conditions.
     */
    @Test
    public void TC06_CustomerAcceptTermsAndConditions() {
        test.portalPage.customerAcceptTermsAndCondition();
    }

    /**
     * TC customer PAY.
     */
    @Test
    public void TC07_CustomerAcceptsPAY() {
        test.portalPage.customerPAY();
    }

    /**
     * TC confirmation message validation.
     */
    @Test
    public void TC08_ConfirmationMessageValidation() {
        test.portalPage.confirmationMessageValidation();
    }


    /**
     * TC customer PAY.
     */
    @Test
    public void TC09_CustomerCancelBooking() {
        test.portalPage.customerCancelBooking("Booked by Mistake");
    }

    /**
     * TC confirmation message validation.
     */
    @Test
    public void TC10_ConfirmationMessageValidation() {
        test.portalPage.confirmationMessageValidation();
    }
}
