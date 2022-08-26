package com.ibm.Test.PartnerEmployeeManagement;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The Class Partner Employee Terminate.
 */
public class PartnerEmployeeTerminate extends SuperTest {

    /**
     * The test.
     */
    TestSessionInitiator test;
    /**
     * The logger.
     */
    /**
     * The rel number.
     */
    /**
     * The driver.
     */
    WebDriver driver;


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
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
        test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".Employee.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment") + ".Employee.Password"));
        test.homePage.verifyHomePageDisplay();
    }

    /**
     * TC navigate to Partner Sites.
     */
    @Test
    public void TC02_ChangeDistributorEntitlement() {

        test.partnerEmpPage.verifyRoleInSiteMap();
    }

    /**
     * TC navigate to Partner Sites.
     */
    @Test
    public void TC03_NavigateToPartnerSitesTab() {

        test.partnerEmpPage.navigateToPartnerSitesTab();
    }

    /**
     * TC drill down site name.
     */
    @Test
    public void TC04_DrillDownSiteName() {

        test.partnerEmpPage.drillDownSiteName("GOEL ENTERPRISES BLY");
    }

    /**
     * TC click button add new employee.
     */
    @Test
    public void TC05_ClickAddNewEmployeeButton() {

        test.partnerEmpPage.clickPlusButtonAddEmployee();
    }

    /**
     * TC select position of the new employee.
     */
    @Test
    public void TC06_AddPositionEmployee() {

        test.partnerEmpPage.employeePosition("Non-Siebel Access Position");
    }

    /*
     * TC select designation of employee.
     * */
    @Test
    public void TC07_AddDesignationEmployee() {

        test.partnerEmpPage.employeeDesignation("Showroom Staff");
    }

    /**
     * TC add details for new employee-delivery boy.
     */
    @Test
    public void TC08_AddNewEmployee() {

        test.partnerEmpPage.addEmployeeDetails();
    }

    /*
     * TC perform save action of keyboard.
     * */
    @Test
    public void TC09_PerformSaveAction() {

        test.partnerEmpPage.performSave();
    }

    /*
     * TC verify User ID of new employee.
     * */
    @Test
    public void TC10_VerifyGeneratedUserIdEmployee() {

        test.partnerEmpPage.verifyUserID();
    }

    /*
     * TC terminate employee.
     * */
    @Test
    public void TC11_TerminateEmployee() {

        test.partnerEmpPage.terminateEmployee();
    }

    /*
     * TC perform save action of keyboard.
     * */
    @Test
    public void TC12_PerformSaveAction() {

        test.partnerEmpPage.performSave();
    }

    /*
     * TC verify employee current status.
     * */
    @Test
    public void TC13_VerifyEmployeeEmploymentStatus() {

        test.partnerEmpPage.verifyEmployeeEmploymentStatus();
    }


    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }

}