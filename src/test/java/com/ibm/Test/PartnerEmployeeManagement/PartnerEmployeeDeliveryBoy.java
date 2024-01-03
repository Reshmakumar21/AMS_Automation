package com.ibm.Test.PartnerEmployeeManagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class Customer Portal.
 */
public class PartnerEmployeeDeliveryBoy extends SuperTest {

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
    @BeforeClass(alwaysRun=true)
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
    @Test(priority = 1)
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
    @Test(priority = 2)
    public void TC03_NavigateToPartnerSitesTab() {

        test.partnerEmpPage.navigateToPartnerSitesTab();
    }

    /**
     * TC drill down site name.
     */
    @Test(priority = 3)
    public void TC04_DrillDownSiteName() {

        test.partnerEmpPage.drillDownSiteName("GOEL ENTERPRISES BLY");
    }

    /**
     * TC click button add new employee.
     */
    @Test(priority = 4)
    public void TC05_ClickAddNewEmployeeButton() {

        test.partnerEmpPage.clickPlusButtonAddEmployee();
    }

    /**
     * TC select position of the new employee.
     */
    @Test(priority = 5)
    public void TC06_AddPositionEmployee() {

        test.partnerEmpPage.employeePosition("Non-Siebel Access Position");
    }

    /*
     * TC select designation of employee.
     * */
    @Test(priority = 6)
    public void TC07_AddDesignationEmployee() {

        test.partnerEmpPage.employeeDesignation("Delivery Man");
    }

    /**
     * TC add details for new employee-delivery boy.
     */
    @Test(priority = 7)
    public void TC08_AddNewEmployee() {

        test.partnerEmpPage.addEmployeeDetails();
    }

    /*
     * TC perform save action of keyboard.
     * */
    @Test(priority = 8)
    public void TC09_PerformSaveAction() {

        test.partnerEmpPage.performSave();
    }

    /*
     * TC verify User ID of new employee.
     * */
    @Test(priority = 9)
    public void TC10_VerifyGeneratedUserIdEmployee() {

        test.partnerEmpPage.verifyUserID();
    }

    /**
     * Tear down session.
     */
    @AfterClass(alwaysRun=true)
    public void tearDownSession() {
        test.closeBrowserSession();

    }

}
