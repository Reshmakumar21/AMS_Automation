/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2020-03-19
 *
 */
package com.ibm.UI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class RetailUI.
 */
public class RetailUI extends BaseUIPage {

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
    public RetailUI(WebDriver driver) {
        super(driver);
        this.driver = driver;
        expWait = new SeleniumWait(driver);
    }

    /*Kindly use proper naming convention while naming any webElement.
    Use below example and refer other UI classes for web element naming.
    Kindly stress on creating stable xPaths.*/


    /**Web element by Anil*/

    /**
     * The drillDown on partner name
     */
    @FindBy(xpath = "//*[@title='Partner Relationship List Applet']//td/a[contains(@name,'Name')]")
    public WebElement drillDown_PartnerName;

    /**
     * Various button under installed assets - New, Modify, Disconnect, Suspend
     *
     * @param buttonName
     * @return
     */
    public WebElement get_ButtonsInstalledAssets(String buttonName) {
        return driver
                .findElement(By.xpath("//*[@title='Products and Services List Applet']//button[contains(@aria-label,'" + buttonName + "')]"));
    }

    /**
     * The "+" sign Line Items
     */
    @FindBy(xpath = "//*[@title='Line Items List Applet']//button[contains(@aria-label,'Line Items:New')]")
    public WebElement btn_PlusSignLineItems;


    /**
     * Gets the Fourth tab level.
     *
     * @param tabName the tab name
     * @return the Fourth tab level
     */
    public WebElement get_FourthTabLevel(String tabName) {
        return driver
                .findElement(By.xpath("//*[@title='Fourth Level View Bar']//a[contains(text(),'" + tabName + "')]"));
    }

    /**
     * Gets the line items attribute Name.
     *
     * @param attributeName the tab name
     * @return the line items attribute Name
     */
    public WebElement get_AttributeName(String attributeName) {
        return driver
                .findElement(By.xpath("//*[@title='Line Item Attributes List Applet']//td[text()='" + attributeName + "']"));

    }


    /**
     * The button to show more or less attributes for line item.
     */
    @FindBy(xpath = "//span[contains(@title,'Line Item Attributes:Show')]")
    public WebElement btn_ShowMoreOrLessLineItemAttributes;


    /**
     * @param columnName
     * @return webElement address of cellValue in first data row of product web table
     */
    public WebElement get_LineItemAppletFirstRowCell(String columnName) {
        int k = 0;
        List<WebElement> listOfLineItemsColumnName = driver.findElements(By.xpath("//*[@title='Line Items List Applet']//th//div"));

        for (int j = 0; j < listOfLineItemsColumnName.size(); j++) {
            if (listOfLineItemsColumnName.get(j).getAttribute("textContent").equalsIgnoreCase(columnName)) {
                k = j + 1;
                break;
            }
        }
        return driver.findElement(By.xpath("//*[@title='Line Items List Applet']//tr[@id='1']/td[" + k + "]"));
    }

    /**
     * @param columnName
     * @return webElement address of cellValue in first data row of product web table
     */
    public WebElement get_LineItemAppletSecondRowCell(String columnName) {
        int k = 0;
        List<WebElement> listOfLineItemsColumnName = driver.findElements(By.xpath("//*[@title='Line Items List Applet']//th//div"));

        for (int j = 0; j < listOfLineItemsColumnName.size(); j++) {
            if (listOfLineItemsColumnName.get(j).getAttribute("textContent").equalsIgnoreCase(columnName)) {
                k = j + 1;
                break;
            }
        }
        return driver.findElement(By.xpath("//*[@title='Line Items List Applet']//tr[@id='2']/td[" + k + "]"));
    }


    /**
     * @param columnName
     * @param attributeName
     * @return
     */
    public WebElement get_LineItemAttributeValueCell(String columnName, String attributeName) {
        int k = 0, m = 0, p = 0;

        List<WebElement> colName = driver.findElements(By.xpath("//*[@title='Line Item Attributes List Applet']//th//div"));
        for (int j = 0; j < colName.size(); j++) {
            System.out.println("ValueCol: " + colName.get(j).getAttribute("textContent") +
                    "\n" +
                    "IndexValue: " + j);
            if (colName.get(j).getAttribute("textContent").equalsIgnoreCase(columnName)) {
                k = j + 1;
                break;
            }
        }

        List<WebElement> requiredColName = driver.findElements(By.xpath("//*[@title='Line Item Attributes List Applet']//th//div"));
        for (int n = 0; n < requiredColName.size(); n++) {
            System.out.println("ValueColName: " + colName.get(n).getAttribute("textContent") +
                    "\n" +
                    "IndexValueName: " + n);
            if (colName.get(n).getAttribute("textContent").equalsIgnoreCase("Name")) {
                p = n + 1;
                break;
            }
        }

        //List<WebElement> rowValueName = driver.findElements(By.xpath("//*[@title='Line Item Attributes List Applet']//td["+p+"]"));
        ArrayList<WebElement> rowValueName = new ArrayList<>(driver.findElements(By.xpath("//*[@title='Line Item Attributes List Applet']//td[" + p + "]")));
        System.out.println("//*[@title='Line Item Attributes List Applet']//td[" + p + "]");
        System.out.println("RowSIZE: " + rowValueName.size());
        for (int l = 0; l < rowValueName.size(); l++) {
            System.out.println("rowValue: " + rowValueName.get(l).getAttribute("textContent") +
                    "\n" +
                    "IndexValue: " + l);
            if (rowValueName.get(l).getAttribute("textContent").equalsIgnoreCase(attributeName)) {
                m = l + 1;
                break;
            }
        }
        System.out.println("//*[@title='Line Item Attributes List Applet']//tr[" + m + "]//td[" + k + "]");
        return driver.findElement(By.xpath("//*[@title='Line Item Attributes List Applet']//tr[" + m + "]//td[" + k + "]"));
    }


    /**
     * The "+" sign Reading
     */
    @FindBy(xpath = "//*[@title='Readings List Applet']//button[contains(@aria-label,'Readings:New')]")
    public WebElement btn_PlusSignReadings;

    /**
     * @param columnName
     * @return webElement address of cellValue in first data row of readings web table
     */
    public WebElement get_ReadingsAppletFirstRowCell(String columnName) {
        int k = 0;
        List<WebElement> listOfLineItemsColumnName = driver.findElements(By.xpath("//*[@title='Readings List Applet']//th//div"));

        for (int j = 0; j < listOfLineItemsColumnName.size(); j++) {
           /* System.out.println("ValueOfColumn--> "+listOfLineItemsColumnName.get(j).getAttribute("textContent"));
            System.out.println("ValueOfIndex--> "+j);*/
            if (listOfLineItemsColumnName.get(j).getAttribute("textContent").equalsIgnoreCase(columnName)) {
                k = j + 1;
                break;
            }
        }
        //System.out.println("XPATH-->"+"//*[@title='Readings List Applet']//table//tr[@id='1']//td[" + k + "]");
        return driver.findElement(By.xpath("//*[@title='Readings List Applet']//tr[@id='1']//td[" + k + "]"));
    }

    /**
     * The btn calculate under Readings
     */
    @FindBy(xpath = "//*[@title='Readings List Applet']//button[contains(@aria-label,'Calculate')]")
    public WebElement btn_CalculateReading;

    /**
     * The text box order number
     */
    @FindBy(xpath = "//*[@title='Sales Order Form Applet']//input[contains(@aria-labelledby,'OrderNumber')]")
    public WebElement txtBox_OrderNumber;

    /**
     * The click on submit button
     */
    @FindBy(xpath = "//*[@title='Sales Order Form Applet']//button[contains(@aria-label,'Submit')]")
    public WebElement btn_Submit;

    /**
     * The text box cancel reason
     */
    @FindBy(xpath = "//*[@title='Sales Order Form Applet']//input[contains(@aria-label,'Reason')]")
    public WebElement txtBox_CancelReason;

    /**
     * The click on Cancel button
     */
    @FindBy(xpath = "//*[@title='Sales Order Form Applet']//button[contains(@aria-label,'Cancel Order')]")
    public WebElement btn_Cancel;




    /*Order amendment UI******************************************************/

    /**
     * The Query button installed asset
     */
    @FindBy(xpath = "//*[@aria-label='Products and Services:Query']")
    public WebElement btn_QueryInstalledAsset;

    /**
     * The textbox installed asset Asset-ID
     */
    @FindBy(xpath = "//*[@title='Products and Services List Applet']//tr[@id='1']//td[contains(@id,'Serial_Number')]")
    public WebElement txtBox_InstalledAssetAssetID;

    /**
     * The after query go button installed asset
     */
    @FindBy(xpath = "//*[@aria-label='Products and Services:Go']")
    public WebElement btn_GoQueryInstalledAsset;

    /**
     * The asset modify button installed asset
     */
    @FindBy(xpath = "//*[@aria-label='OK']")
    public WebElement btn_OkAssetModification;




    /*FO UI WEB ELEMENTS*********************************************************************************/


    /**
     * FO user display verify button.
     */
    @FindBy(xpath = "//*[@id='_sweappmenu']//*[@name='Root']")
    public WebElement btn_FOUserName;

    /**
     * FO logout button.
     */
    @FindBy(xpath = "//*[@id='toolbar_popup']//button[text()='Logout']")
    public WebElement btn_FOLogout;

    /**
     * Search Button for Partner Name
     */
    @FindBy(xpath = "//*[@title='Partner Relationship List Applet']//button[@aria-label='Partner Relationship:Query']")
    public WebElement btn_search;

    /**
     * Input text for Partner Name
     */
    @FindBy(xpath = "//*[@title='Partner Relationship List Applet']//input[contains(@aria-labelledby,'Name')]")
    public WebElement txtBox_PartnerName;

    /**
     * Enter button for Partner Name
     */
    @FindBy(xpath = "//*[@title='Partner Relationship List Applet']//button[@aria-label='Partner Relationship:Go']")
    public WebElement btn_SearchEnter;

    /**
     * The text Box for FO comments
     */
    @FindBy(xpath = "(//*[@title='Inbox History List Applet']//td[contains(@id,'Approver_Comments')])[1]")
    public WebElement txtBox_FO_ApproverComments;

    /**
     * The text Box for FO comments second row.
     */
    @FindBy(xpath = "(//*[@title='Inbox History List Applet']//td[contains(@id,'Approver_Comments')])[2]")
    public WebElement txtBox_FO_ApproverCommentsSecondRow;

    /**
     * To click the Approve or Reject Button
     *
     * @param btnApproveReject
     * @return web element button
     */
    public WebElement get_btnApproveRejectFO(String btnApproveReject) {
        return driver.findElement(By.xpath("//button[contains(@aria-label,'" + btnApproveReject + "')]"));
    }

    /**
     * The text Box for FO Order Status
     */
    @FindBy(xpath = "//*[@title='Sales Order Form Applet']//*[contains(@aria-labelledby,'Status_Label')]")
    public WebElement txtBox_OrderStatus;


    /*TOURS****************************************/

    /**
     * The btn to search TOUR.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//button[@aria-label='Tours:Query']")
    public WebElement btn_SearchTour;

    /**
     * The btn to raise new TOUR.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//button[@aria-label='Tours:New']")
    public WebElement btn_AddNewTour;

    /**
     * The text of TOUR_ID.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//tr[@id='1']//td[contains(@id,'Tour_Number')]")
    public WebElement txt_TourID;

    /**
     * The textBox for Tour Name.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//tr[@id='1']//td[contains(@id,'Name')]")
    public WebElement txtBox_TourName;

    /**
     * The textBox for Tour Type.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//tr[@id='1']//*[contains(@id,'Tour_Type')]")
    public WebElement txtBox_TourType;

    /**
     * The textBox for Tour Start Date.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//tr[@id='1']//*[contains(@id,'Start_Date')]")
    public WebElement txtBox_StartDate;

    /**
     * The textBox for Tour End Date.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//tr[@id='1']//*[contains(@id,'End_Date')]")
    public WebElement txtBox_EndDate;

    /**
     * The text for Tour Night Halts.
     */
    @FindBy(xpath = "//*[@title='Tours List Applet']//tr[@id='1']//*[contains(@id,'Night_Haults')]")
    public WebElement txt_NightHalts;

    /**
     * The textBox for Tour Distance Covered.
     */
    @FindBy(xpath = "//*[@title='Tours Form Applet']//*[contains(@aria-labelledby,'Distance_Covered')]")
    public WebElement txtBox_DistanceCovered;

    /**
     * The textBox for Tour Status.
     */
    @FindBy(xpath = "//*[@title='Tours Form Applet']//*[@aria-labelledby='Status_Label']")
    public WebElement txtBox_TourStatus;

    /**
     * The btn to Submit new TOUR.
     */
    @FindBy(xpath = "//*[@title='Tours Form Applet']//button[@aria-label='Tours:Submit']")
    public WebElement btn_SubmitNewTour;


}