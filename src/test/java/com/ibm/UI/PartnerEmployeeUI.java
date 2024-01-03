/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2019-10-17
 *
 */
package com.ibm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class ContactTabUI.
 */
public class PartnerEmployeeUI extends BaseUIPage {
    /**
     * The driver.
     */
    WebDriver driver;

    /**
     * The exp wait.
     */
    SeleniumWait expWait;

    /**
     * Instantiates a new contact tab UI.
     *
     * @param driver the driver
     */
    public PartnerEmployeeUI(WebDriver driver) {
        super(driver);
        this.driver = driver;
        expWait = new SeleniumWait(driver);
    }

    /**
     * The lnk for LPG.
     */
    @FindBy(xpath = "//*[text()='LPG']")
    public WebElement lnk_LPG;


    /**
     * The button for SiteMap on homepage.
     */
    @FindBy(xpath = "//*[contains(@aria-label, 'Application Toolbar')]//*[@title='Site Map']")
    public WebElement btn_SiteMap;

    /**
     * The textBox for SiteMap Filter Input search.
     */
    @FindBy(xpath = "//*[contains(@title, 'Home Page view of the CME Application')]//*[@class='sitemapFilter']")
    public WebElement txtBox_SiteMapFilterInput;


    /**
     * The hyperlink for output after SiteMap Filter Input search.
     */
    @FindBy(xpath = "(//*[@title='Home Page view of the CME Application']//a[text()='User Preferences'])[2]")
    public WebElement lnk_ResultSiteMapFilterInput;


    /**
     * The CheckBox for 1st row under Change position.
     */
    @FindBy(xpath = "(//*[contains(@title, 'Change Position List Applet')]//td[contains(@aria-labelledby, 'altCheckBox')])[1]")
    public WebElement chkBox_ActivePosition;


    /**
     * The button for Change position.
     */
    @FindBy(xpath = "//*[contains(@title, 'Change Position List Applet')]//button[contains(@aria-label, ':Change')]")
    public WebElement btn_ChangePosition;

    /**
     * The hyperlink for Site Name.
     */

	/*@FindBy(xpath = "(//*[@title='Sites List Applet']//a[contains(@name, 'Site Name')])[2]")
    public WebElement lnk_SiteName;*/
	 public WebElement getLink_SiteName(String siteName){
        return driver.findElement(By.xpath("(//*[@title='Sites List Applet']//*[contains(@id,'Site_Name')]//a[text()='"+siteName+"'])"));
    }

    /**
     * The Plus button to add new employee.
     */
    @FindBy(xpath = "//*[@title='Employees List Applet']//button[contains(@title, 'Employees:New')]")
    public WebElement btn_PlusEmployee;

    /**
     * The textBox for position selection.
     */
  /*  @FindBy(xpath = "(//td[contains(@id,'_Position')])[1]")
    public WebElement txtBox_Position;*/


    /**
     * The textBox for position selection.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//*[@aria-labelledby='Position_Label']/following-sibling::span")
    public WebElement txtBox_Position;

    /**
     * The textBox to search for a position occupied.
     */
    @FindBy(xpath = "//*[@title='Add Positions List Applet']//*[contains(@aria-labelledby,'PopupQuerySrchspec')]")
    public WebElement txtBox_SearchPositionOccupied;

    /**
     * The Go btn to search position occupied.
     */
    @FindBy(xpath = "(//*[@title='Add Positions List Applet']//button[contains(@title,'Go')])")
    public WebElement btn_GoPositionOccupied;

    /**
     * The button for adding position occupied pop up.
     */
    @FindBy(xpath = "//*[@title='Positions Occupied List Applet']//button[contains(@aria-label, ':Add')]")
    public WebElement btn_PositionOccupiedAdd;

    /**
     * The button for adding position occupied pop up.
     */
    @FindBy(xpath = "//*[@title='Positions Occupied List Applet']//button[contains(@aria-label, ':OK')]")
    public WebElement btn_PositionOccupiedOK;

    /**
     * The textBox for designation selection.
     */
    /*@FindBy(xpath = "(//td[contains(@id,'Job_title')])[1]")
    public WebElement txtBox_Designation;*/


    /**
     * The textBox for designation selection.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//input[@aria-labelledby='Job_Title_Label']")
    public WebElement txtBox_Designation;


    /**
     * The textBox for First Name.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//input[@aria-labelledby='FirstName_Label']")
    public WebElement txtBox_FirstName;

    /**
     * The textBox for Last Name.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//input[@aria-labelledby='LastName_Label']")
    public WebElement txtBox_LastName;

    /**
     * The textBox for Gender.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//input[@aria-labelledby='PersonalTitle_Label']")
    public WebElement txtBox_Gender;

    /**
     * The textBox for DoB.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//input[@aria-labelledby='DoB_Label']")
    public WebElement txtBox_DoB;


    /**
     * The textBox for Mobile Phone.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//*[@aria-labelledby='Cell_Phone_No_Label']")
    public WebElement txtBox_MobilePhone;


    /**
     * The plus btn for Mobile Phone.
     */
    @FindBy(xpath = "//*[@title='Phone List Applet']//*[@aria-label='Phone:New']")
    public WebElement btn_PlusMobilePhone;


    /**
     * The textBox for Mobile Phone number in Pop Up.
     */
    @FindBy(xpath = "//*[@title='Phone List Applet']//td[contains(@id, 'Address')]")
    public WebElement txtBox_Phone;


    /**
     * The btn OK under Phone add applet.
     */
    @FindBy(xpath = "//*[@title='Phone List Applet']//*[contains(@title, 'OK')]")
    public WebElement btn_OKAddPhone;


    /**
     * The btn for Query employee search.
     */
    @FindBy(xpath = "(//*[@title='Employees List Applet']//button[contains(@title, 'Employees:Query')])[1]")
    public WebElement btn_QuerySearchEmployee;


    /**
     * The txtBox of Mobile phone number under Employee Form Applet.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//input[@aria-labelledby='Cell_Phone_No_Label']")
    public WebElement txtBox_MobilePhonePosition2;

    /**
     * The btn for query search employee go.
     */
    @FindBy(xpath = "(//*[@title='Employees List Applet']//button[contains(@title, 'Employees:Go')])[1]")
    public WebElement btn_QueryGoSearchEmployee;


    /**
     * The textBox for Partner Name.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//input[contains(@aria-labelledby,'LoginName_Label')]")
    public WebElement txtBox_UserIdEmployee;

    /**
     * The textBox for employee employment current status.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//*[@aria-labelledby='Employment_Status_Label']")
    public WebElement chkBox_EmployeeEmploymentStatus;


    /**
     * The chkBox for Employee Terminated.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//*[@aria-labelledby='EPIC_Emp_Terminated_Label']")
    public WebElement chkBox_EmployeeTerminated;

    /**
     * The txtBox for Employee Termination reason.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//*[@aria-labelledby='EPIC_Termination_Reason_Label']")
    public WebElement txtBox_TerminationReason;

    /**
     * The txtBox for Employee Appointment Date.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//*[@aria-labelledby='Date_of_appointment_Label']")
    public WebElement txtBox_dateOfAppointment;

    /**
     * The txtBox for Employee Termination Date.
     */
    @FindBy(xpath = "//*[@title='Employee Form Applet']//*[contains(@aria-labelledby,'Termination_Date')]")
    public WebElement txtBox_TerminationDate;

}
