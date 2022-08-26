/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2020-03-19
 *
 */
package com.ibm.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class LokamUI.
 */
public class LokamUI extends BaseUIPage {

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
    public LokamUI(WebDriver driver) {
        super(driver);
        this.driver = driver;
        expWait = new SeleniumWait(driver);
    }

    /*The button create new lead*/
    @FindBy(xpath = "//*[@title='Lead List List Applet']//button[@aria-label='Lead List:New']")
    public WebElement btn_CreateButtonLead;

    /*The button to search prospect*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//input[@aria-labelledby='ProspectLastName_Label']")
    public WebElement txtBox_ProspectLastName;

    /*The checkBox for Corporate Lead?*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[contains(@aria-labelledby,'Corporate_Prospect_Label') and @type='checkbox']")
    public WebElement chkBox_CorporateLead;

    /*The textBox for Company Name*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[contains(@aria-labelledby,'Account_Label')]")
    public WebElement txtBox_CompanyName;

    /*The button to add new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//button[@aria-label='Pick Prospect:New']")
    public WebElement ClickPlusButton;

    /*The textBox to add new salutation for new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[@aria-labelledby='EPIC_Title_Label']")
    public WebElement AddTitle;

    /*The textBox to add first Name for new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[@aria-labelledby='Last_Name_Label']")
    public WebElement AddFirstName;

    /*The textBox to add last Name for new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[@aria-labelledby='First_Name_Label']")
    public WebElement AddLastName;

    /*The textBox to add mobile number for new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[contains(@aria-labelledby,'Cellular_Phone')]")
    public WebElement AddMobileNumber;

    /*The textBox to add address for new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[contains(@aria-labelledby,'Street_Address_Label')]")
    public WebElement StreetAddress;

    /*The textBox to add pinCode for new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[contains(@aria-labelledby,'Postal_Code_Label')]")
    public WebElement Pincode;

    /*The textBox to add City for new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//input[contains(@aria-labelledby,'City_Label')]")
    public WebElement City;

    /*The button to finish adding new prospect*/
    @FindBy(xpath = "//*[@title='Pick Prospect List Applet']//button[contains(@aria-label,'Pick Prospect:OK')]")
    public WebElement OkButton;

    /*The textBox to add new lead source*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//*[@aria-labelledby='EPIC_Lead_Source_Label']")
    public WebElement AddLeadSource;

    /*The textBox to add new division*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//*[@aria-labelledby='EPIC_LDM_LOB_Division_Label']")
    public WebElement AddDivison;

    /*The textBox to add industry category*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//*[@aria-labelledby='EPIC_Lead_Category_Label']")
    public WebElement txtBox_IndustryCategory;

    /*The textBox to add industry sub category*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//*[@aria-labelledby='EPIC_Lead_SubCategory_Label']")
    public WebElement txtBox_IndustrySubCategory;

    /*The button to convert lead*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//button[contains(@aria-label,'Convert')]")
    public WebElement btn_ConvertLead;

    /*The hyperlink to opportunity id*/
    @FindBy(xpath = "//*[@title='Opportunity Form Applet']//input[contains(@aria-labelledby,'Opportunity_Id')]")
    public WebElement txt_OpportunityId;

    /*The textBox to add monthly fuel*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//input[contains(@aria-labelledby,'Monthly_Requirement')]")
    public WebElement txtBox_MonthlyFuel;

    /*The textBox to add the unit for monthly fuel*/
    @FindBy(xpath = "//*[@title='Lead Details Form Applet']//input[contains(@aria-labelledby,'Measure_Label')]")
    public WebElement txtBox_MonthlyFuelUOM;

    /*The hyperlink for contact last name*/
    @FindBy(xpath = "(//*[@title='Contacts List Applet']//a[@name='Last Name'])[1]")
    public WebElement drillDown_ContactLastName;

    /*The button for contact Dedup*/
    @FindBy(xpath = "//*[@title='Contact Detail Form Applet']//button[contains(@aria-label,'Contact Dedup')]")
    public WebElement btn_ContactDedup;

    /*The textBox for dedup status*/
    @FindBy(xpath = "//*[@title='Contact Detail Form Applet']//*[@aria-labelledby='Status_Label']")
    public WebElement txt_Status;

    /*The textBox for dedup KYC*/
    @FindBy(xpath = "//*[@title='Contact Detail Form Applet']//*[contains(@aria-labelledby,'KYC')]")
    public WebElement txt_KYC;

    /*The drillDown for Opportunity Name*/
    @FindBy(xpath = "(//*[@title='Opportunities List Applet']//a[@class='drilldown'])[2]")
    public WebElement drillDown_AccountName;

    /*The drillDown for Opportunity Name*/
    @FindBy(xpath = "(//*[@title='Opportunities List Applet']//a[@class='drilldown'])[1]")
    public WebElement drillDown_OpptyName;

    /*The button to Convert Opportunity*/
    @FindBy(xpath = "//*[@title='Opportunity Form Applet']//*[@aria-label='Opportunity:Convert']")
    public WebElement btn_ConvertOppty;

    /**
     * The textbox for Site.
     */
    @FindBy(xpath = "//*[@title='Opportunity Form Applet']//*[@aria-label='Site']")
    public WebElement txtBox_Site;


    /**
     * The Button for Site OK dialogue box.
     */
    @FindBy(xpath = "//*[@title='Site List Applet']//button[contains(@aria-label,'OK')]")
    public WebElement btn_SiteOK;


    /**
     * TextBox for RelationShip id
     */
    @FindBy(xpath = "(//*[@title='Relationship List Applet']//*[contains(@id,'EPIC_Consumer_Id')])[3]")
    public WebElement txt_RelationshipRelationShipNumber;

    /**
     * TextBox for RelationShip Type
     */
    @FindBy(xpath = "(//*[@title='Relationship List Applet']//*[contains(@id,'EPIC_Relationship_Type')])[3]")
    public WebElement txt_RelationshipType;

    /**
     * TextBox for RelationShip Type
     */
    @FindBy(xpath = "(//*[@title='Relationship List Applet']//*[contains(@id,'EPIC_Consumer_Status')])[3]")
    public WebElement txt_RelationshipStatus;

    /**
     * TextBox for RelationShip Type
     */
    @FindBy(xpath = "(//*[@title='Relationship List Applet']//*[contains(@id,'EPIC_Consumer_Sub_Status')])[3]")
    public WebElement txt_RelationshipSubStatus;

}
