package com.ibm.Test.Grievance;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The Class SR_Grievance.
 */
public class SR_Grievance extends SuperTest {
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
     * Test Case 00 set up.
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
     * Test Case 01 enter login info.
     */
    @Test
    public void TC01_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
        test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
                test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
        test.homePage.verifyHomePageDisplay();
    }

    /**
     * TC 02 search for Service Request tab.
     */
    @Test
    public void TC02_OpenServiceRequestTab() {

        test.profileSRPage.launchServiceRequestTab();
    }

    /**
     * TC 03 add button to raise new grievance service request.
     */
    @Test
    public void TC03_ClickAddNewGrievanceButton() {

        test.profileSRPage.raiseNewGrievance();
    }

    /**
     * TC 04 Enter Consumer ID on UI.
     */
    @Test
    public void TC04_InputConsumerId() {

        test.profileSRPage.inputConsumerId(relNumber);
    }

    /**
     * TC 05 Enter Consumer ID on UI.
     */
    @Test
    public void TC05_InputMobileNumber() {

        test.profileSRPage.inputMobileNumber();
    }

    /**
     * TC 06 Select SR categories.
     */
    @Test
    public void TC06_SelectSRCategories() {

        test.profileSRPage.inputSRCategories();
    }

    /**
     * TC 07 Input Grievance Description.
     */
    @Test
    public void TC07_InputGrievanceDescription() {

        test.profileSRPage.inputGrievanceDescription();
    }

    /**
     * TC 08 Submit Grievance.
     */
    @Test
    public void TC08_SubmitGrievance() {

        test.profileSRPage.submitGrievance();
    }

    /**
     * TC 09 Search Grievance number.
     */
    @Test
    public void TC09_SearchGrievanceSRNumber() {

        test.profileSRPage.searchGrievanceSRNumber();
    }

    /**
     * TC 10 Drill Down New SR request.
     */
    @Test
    public void TC10_DrillDownNewSRGrievance() {

        test.profileSRPage.drillDownSRGrievance();
    }

    /**
     * TC 11 Verify Status of Grievance service request | Expected - In Progress.
     */
    @Test
    public void TC11_VerifyGrievanceStatus() {

        test.profileSRPage.grievanceStatus("In Progress");
    }

    /**
     * TC 12 Input Resolution Remarks by Distributor.
     */
    @Test
    public void TC12_InputResolutionRemarks() {

        test.profileSRPage.inputResolutionRemarks();
    }

    /**
     * TC 13 CLick RESOLVE button by Distributor.
     */
    @Test
    public void TC13_ClickResolveButton() {

        test.profileSRPage.clickResolveButton();
    }

    /**
     * TC 14 Drill Grievance SR request.
     */
    @Test
    public void TC14_DrillDownSRGrievance() {

        test.profileSRPage.drillDownSRGrievance();
    }

    /**
     * TC 15 Verify Status of Grievance service request | Expected - In Progress.
     */
    @Test
    public void TC15_VerifyGrievanceStatus2() {

        test.profileSRPage.grievanceStatus("In Progress");
        test.profileSRPage.grievanceSubStatus("Resolved by Partner");
    }

    /**
     * TC 16 Perform FO actions.
     */
    @Test
    public void TC16_FODecision() {

        test.profileSRPage.FODecisionGrievance();
    }


    /**
     * TC 17 Perform Validations.
     */
    @Test
    public void TC17_ValidationGrievanceStatus() {

        test.profileSRPage.grievanceValidation();
    }

    /**
     * TC 18 Perform Validation Resolved Date.
     */
    @Test
    public void TC18_ValidationGrievanceResolvedDate() {

        test.profileSRPage.grievanceValidationResolveDate();
    }


    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();

    }
}
