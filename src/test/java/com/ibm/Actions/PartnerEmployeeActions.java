/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Actions;

import com.aventstack.extentreports.Status;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.PartnerEmployeeUI;
import com.ibm.Utilities.LoggerWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * The Class PartnerEmployeeActions.
 */
public class PartnerEmployeeActions extends BaseAction {
    /**
     * The contact tab.
     */
    protected ContactTabUI contactTab;

    /**
     * The Partner Sites tab.
     */
    protected PartnerEmployeeUI partnerEmpPage;

    /**
     * The home page.
     */
    protected HomePageUI homePage;


    /**
     * The driver.
     */
    WebDriver driver;

    /*Class Variabled*/
    String phoneNumber;

    /**
     * Instantiates a new contact tab action.
     *
     * @param driver the driver
     */
    public PartnerEmployeeActions(WebDriver driver) {
        super(driver);
        contactTab = new ContactTabUI(driver);
        partnerEmpPage = new PartnerEmployeeUI(driver);
        homePage = new HomePageUI(driver);
        this.driver = driver;
    }

    /**
     * To veirfy distibutor role under user preference in site map.
     */
    public void verifyRoleInSiteMap() {
       if (!partnerEmpPage.btn_SiteMap.isDisplayed()) {
            driver.navigate().refresh();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
        }
        partnerEmpPage.btn_SiteMap.isDisplayed();
        expWait.waitForDomToLoad();
        partnerEmpPage.btn_SiteMap.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        partnerEmpPage.txtBox_SiteMapFilterInput.
                findElement(By.xpath("input")).sendKeys("User Preferences");
        partnerEmpPage.lnk_ResultSiteMapFilterInput.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        try {
            String chkBoxValue = partnerEmpPage.chkBox_ActivePosition.getAttribute("title");
            if (chkBoxValue.equalsIgnoreCase("Unchecked")) {
                partnerEmpPage.chkBox_ActivePosition.click();
                partnerEmpPage.btn_ChangePosition.click();
                expWait.waitForDomToLoad();
                expWait.waitForHomePageSipperToDisapper();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigate to Partner Site tab.
     */
    public void navigateToPartnerSitesTab() {
        contactTab.isTabDisplayInMainTabList("Partner Sites");
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }


    /**
     * Drill Down Site tab.
     */
    public void drillDownSiteName(String siteName) {
        expWait.waitForDomToLoad();
        //partnerEmpPage.lnk_SiteName.click();
        partnerEmpPage.getLink_SiteName(siteName).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }


    /**
     * Add employee plus button.
     */
    public void clickPlusButtonAddEmployee() {
        System.out.println("UserIdTestValue: " + partnerEmpPage.txtBox_UserIdEmployee.getAttribute("value"));
        partnerEmpPage.btn_PlusEmployee.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /*
    Add position of the required employee
    */
    public void employeePosition(String EmployeePosition) {
        boolean flag = false;
        partnerEmpPage.txtBox_Position.click();
        expWait.waitForDomToLoad();
        try {
            partnerEmpPage.btn_PositionOccupiedOK.isDisplayed();
        } catch (Exception e) {
            partnerEmpPage.txtBox_Position.click();
        }
        partnerEmpPage.txtBox_SearchPositionOccupied.sendKeys(EmployeePosition);
        partnerEmpPage.txtBox_SearchPositionOccupied.sendKeys(Keys.TAB);
        partnerEmpPage.txtBox_SearchPositionOccupied.sendKeys(Keys.ENTER);
        //partnerEmpPage.btn_GoPositionOccupied.click(); //Button inaccessible
        expWait.waitForDomToLoad();

        partnerEmpPage.btn_PositionOccupiedAdd.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        expWait.waitForDomToLoad();

        partnerEmpPage.btn_PositionOccupiedOK.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        //expWait.waitLong(5);

   /*     try {
            Alert simpleAlert = driver.switchTo().alert();
            System.out.println("Error message: " + simpleAlert.getText());
            simpleAlert.accept();
            flag = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }*/

        alertVerificationAndAcceptAlert(20);

        if (flag == true) {
            partnerEmpPage.btn_PositionOccupiedOK.click();
        }
        //expWait.waitForDomToLoad();
    }

    /*
     * Add designation of employee.
     * */
    public void employeeDesignation(String EmployeeDesignation) {
        partnerEmpPage.txtBox_Designation.click();
        expWait.waitForDomToLoad();
        partnerEmpPage.txtBox_Designation.sendKeys(EmployeeDesignation);
    }

    /**
     * Add employee details.
     */
    public void addEmployeeDetails() {
        //Adding new phone number to employee
        phoneNumber = (new ProfileServiceRequestAction(driver).randomPhoneNumber("4"));
        System.out.println("PhoneNumber: " + phoneNumber);

        partnerEmpPage.txtBox_FirstName.sendKeys("FN");
        partnerEmpPage.txtBox_LastName.sendKeys("LN");
        partnerEmpPage.txtBox_Gender.sendKeys("Male");
        partnerEmpPage.txtBox_DoB.sendKeys("26-May-1990");

        expWait.waitForHomePageSipperToDisapper();

        partnerEmpPage.txtBox_MobilePhone.findElement(By.xpath("following-sibling::span")).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        partnerEmpPage.btn_PlusMobilePhone.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        partnerEmpPage.txtBox_Phone.findElement(By.xpath("input")).sendKeys(phoneNumber);
        partnerEmpPage.btn_OKAddPhone.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }


    public void verifyUserID() {
        //Validations
        String userIDEmployee = "";
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        partnerEmpPage.btn_QuerySearchEmployee.click();
        expWait.waitForDomToLoad();
        partnerEmpPage.txtBox_MobilePhonePosition2.sendKeys(phoneNumber);
        partnerEmpPage.btn_QueryGoSearchEmployee.click();
        expWait.waitForDomToLoad();
        userIDEmployee = partnerEmpPage.txtBox_UserIdEmployee.getAttribute("value");

        if (userIDEmployee.isEmpty()) {
            expWait.waitLong(8);
            userIDEmployee = partnerEmpPage.txtBox_UserIdEmployee.getAttribute("value");
        }
        System.out.println("User id of new employee: " + userIDEmployee);

        Assert.assertNotEquals(userIDEmployee, null,
                "Verifying User Id for employee should not be null");
        LoggerWriter.logger.log(Status.PASS,
                "Successfully created UserId: " + userIDEmployee + " for new employee");
    }

    public void terminateEmployee() {
        String dateOfAppointment = "";
        try {
            partnerEmpPage.chkBox_EmployeeTerminated.click();
        } catch (Exception e) {
            partnerEmpPage.chkBox_EmployeeTerminated.click();
        }
        expWait.waitForDomToLoad();
        partnerEmpPage.chkBox_EmployeeTerminated.sendKeys(Keys.TAB);
        expWait.waitLong(5);
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        dateOfAppointment = partnerEmpPage.txtBox_dateOfAppointment.getAttribute("value");
        partnerEmpPage.txtBox_dateOfAppointment.clear();
        partnerEmpPage.txtBox_TerminationDate.sendKeys(dateOfAppointment);
        partnerEmpPage.txtBox_TerminationReason.sendKeys("Terminated By Distributor");
        partnerEmpPage.txtBox_dateOfAppointment.sendKeys("31/Dec/2019");
    }

    public void verifyEmployeeEmploymentStatus() {
        String employeeDetailsStatus = partnerEmpPage.chkBox_EmployeeEmploymentStatus.getAttribute("value");
        String txtBoxEmployeeEmploymentStatusAccessibility = partnerEmpPage.chkBox_EmployeeEmploymentStatus.getAttribute("aria-readonly");
        if (employeeDetailsStatus.equalsIgnoreCase("Terminated")
                && txtBoxEmployeeEmploymentStatusAccessibility.equalsIgnoreCase("true")) {
            LoggerWriter.logger.log(Status.PASS, "Employee Current Employment Status Is *Terminated* As Expected");
        } else {
            LoggerWriter.logger.log(Status.FAIL, "Employee Current Employment Status: " + employeeDetailsStatus
                    + " While Expected Was: Terminated");
        }
    }
}