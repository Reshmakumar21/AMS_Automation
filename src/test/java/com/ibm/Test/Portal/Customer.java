package com.ibm.Test.Portal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Customer Portal.
 */

public class Customer extends SuperTest {

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

}
