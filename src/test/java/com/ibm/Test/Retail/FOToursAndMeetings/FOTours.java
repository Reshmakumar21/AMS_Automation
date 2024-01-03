package com.ibm.Test.Retail.FOToursAndMeetings;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The FO Tour class.
 */

public class FOTours extends SuperTest {

    /**
     * The test.
     */
    TestSessionInitiator test;

    /**
     * Test Case 00 set up.
     */
    @BeforeClass
    public void TC00_SetUp() {
        System.out.println();
        System.out.println("***********Before Class ********");
        System.out.println();
        Utilities.setYamlFilePath("integration_testData.yml");
        test = new TestSessionInitiator();
    }

    /**
     * Test Case 01 enter login info.
     */
    @Test
    public void TC01_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".FO.URL"));
        test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".FO.Retail.User1.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment") + ".FO.Retail.User1.Password"));
        test.homePage.verifyHomePageDisplay();
    }

    /**
     * Test Case 02 navigate to Tour view.
     */
    @Test
    public void TC02_NavigateToToursTab() {
        test.retailPage.navigateToToursTab();
    }

    /**
     * Test Case 03 create new tour.
     */
    @Test
    public void TC03_CreateNewTour() {
        test.retailPage.createNewTour("28/Jun/2020", "29/Jun/2020");
    }

    /**
     * Test Case 04 create new tour.
     */
    @Test
    public void TC04_SubmitNewTour() {
        test.retailPage.submitNewTour();
        test.retailPage.logOut();
    }

    /**
     * Test Case 05 second FO decision.
     */
    @Test
    public void TC05_FOTourDecisionBySecondFO() {
        test.retailPage.FOTourDecision("Approve");
    }

    /**
     * Test Case 06 Login Planner FO.
     */
    @Test
    public void TC06_LoginPlannerFO() {
        test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".FO.Retail.User1.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment") + ".FO.Retail.User1.Password"));
        test.homePage.verifyHomePageDisplay();
    }

    /**
     * Test Case 07 navigate to Tour view.
     */
    @Test
    public void TC07_NavigateToToursTab() {
        test.retailPage.navigateToToursTab();
    }

    /**
     * Test Case 08 Search Tour.
     */
    @Test
    public void TC08_SearchTour() {
        test.retailPage.searchTourId();
    }

    /**
     * Test Case 09 Validations.
     */
    @Test
    public void TC09_TourValidation() {
        test.retailPage.validationsTour();
    }

    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}
