/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class HomePageUI.
 */
public class HomePageUI extends BaseUIPage {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new home page UI.
	 *
	 * @param driver
	 *            the driver
	 */
	public HomePageUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	@FindBy(xpath = "//*[@title='First Level View Bar']//*[text()='Relationships']")
	public WebElement tab_RelationShips;

	@FindBy(xpath = "//*[@title='First Level View Bar']//*[text()='Relationships']")
	public WebElement btn_SearchRelationShip;

	@FindBy(xpath = "//div[@role='region']//select")
	public WebElement select_RoleRelationShip;

	@FindBy(xpath = "//a[text()='Relationships List']")
	public WebElement txt_RelationshipsList;

	@FindBy(xpath = "//*[@title=' List Applet']//button[@title='Query']")
	public WebElement btn_RelationshipsQueryButton;

	@FindBy(xpath = "//*[@title='Relationships List Applet']//table//td[contains(@id,'EPIC_Consumer_ID')]")
	public WebElement txtBox_RelationShipNumber;

	@FindBy(xpath = "//*[@title='Relationships List Applet']//table//td[contains(@id,'EPIC_Contact_First_Name')]")
	public WebElement txtBox_FirstNameRelationSearch;

	@FindBy(xpath = "//*[@title='Relationship Form Applet']//a[contains(@name,'Last Name')]")
	public WebElement lnk_LastNameLinkRelationShipSearch;

	@FindBy(xpath = "//*[@title='Relationship List Applet']//a[@name='EPIC Consumer Id']")
	public WebElement lnk_RelationShipNumberCustomerPage;

	// *[@title='Relationship List Applet']//a[@name='EPIC Consumer Id']

	@FindBy(xpath = "//*[@title='Relationships List Applet']//button[@title='Relationships:Go']")
	public WebElement btn_SearchRelationShipQuery;

	@FindBy(xpath = "//*[@title='Relationships List Applet']//table//td[contains(@id,'EPIC_Consumer_ID')]/a")
	public WebElement lnk_RelationShipNumberRearchResult;

	@FindBy(xpath = "//button[@aria-label='Sales Order:DefaultOrder']")
	public WebElement lnk_DefaultButtonRelationShip;

	@FindBy(xpath = "//*[text()='Create Invoice']/..")
	public WebElement btn_CreateInvoice;

	@FindBy(xpath = "//*[text()='Print Invoice']/..")
	public WebElement btn_PrintInvoice;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//table[@summary='Invoice']//td[contains(@id,'Cash_Memo_Status')]")
	public WebElement txtField_CashMemoStatus;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//table[@summary='Invoice']//td[contains(@id,'Cash_Memo_Status')]/input")
	public WebElement txtField_CashMemoStatusTextBox;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//table[@summary='Invoice']//td[contains(@id,'Cash_Memo_Num')]")
	public WebElement lnk_CashMemoNumber;

	@FindBy(xpath = "//*[@title='Invoices Form Applet']//*[@aria-labelledby='Cancel_Reason_Label']")
	public WebElement dropDown_CancelReason;

	@FindBy(xpath = "//*[@title='Invoices Form Applet']//*[@aria-labelledby='Status_Label']")
	public WebElement dropDown_CashMemoStatusLabel;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//*[text()='Cancel Invoice']")
	public WebElement lnk_Field_CancelInvoice;

	@FindBy(xpath = "//*[@title='Cancel Cash Memo Reason Form Applet']//input")
	public WebElement dropDown_Field_CancelInvoiceReason;

	@FindBy(xpath = "//*[@title='Cancel Cash Memo Reason Form Applet']//*[text()='Cancel Cash Memo']")
	public WebElement btn_InvoiceCancelCashMemo;

	@FindBy(xpath = "//td[contains(.,'Delivery Boy')]/following-sibling::td[1]//span")
	public WebElement btn_DeliveryBoy;

	@FindBy(xpath = "(//table[@summary='Delivery Boy']//td[3])[2]")
	public WebElement txt_DeliveryBoySearchResultFromSummary;

	@FindBy(xpath = "//*[@title='Delivery Boy List Applet']//*[text()='OK']")
	public WebElement txt_DeliveryBoySearchResultOKButton;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//table[@summary='Invoice']//td[contains(@id,'Cash_Memo_Num')]")
	public WebElement txtField_CashMemoNumber;

	@FindBy(xpath = "//*[@title='Sales Order Form Applet']//input[@aria-labelledby='Order_Status_Label']")
	public WebElement txt_SalesOrder_OrderStatus;

	@FindBy(xpath = "//*[text()='Cancel Invoice']")
	public WebElement lnk_CancelInvoice;

	@FindBy(xpath = "//*[@title='Cancel Cash Memo Reason Form Applet']//input")
	public WebElement txt_CashMemoReason;

	@FindBy(xpath = "//*[@title='Cancel Cash Memo Reason Form Applet']//button[contains(.,'Memo')]")
	public WebElement btn_CancelMomoButton;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//table[@summary='Invoice']//*[contains(@id,'Print_Flag')]")
	public WebElement txt_PrintFlag;

	@FindBy(xpath = "//*[text()='Print Invoice']")
	public WebElement btn_PrintInvoiceButton;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//*[text()='Return']")
	public WebElement lnk_Return;

	@FindBy(xpath = "//*[@title='Return Reason Form Applet']//input")
	public WebElement txt_ReturnReason;

	@FindBy(xpath = "//*[@title='Return Reason Form Applet']//*[text()='Return']")
	public WebElement txt_ReturnReasonApplet;

	@FindBy(xpath = "//*[@title='Invoice List Applet']//table[@summary='Invoice']//td[contains(@id,'Cash_Memo_Status')]")
	public WebElement txt_ReturnField;

	@FindBy(xpath = "//*[@id='_sweappmenu']//*[@name='Root']")
	public WebElement btn_UserNameUI;

	@FindBy(xpath = "//*[@id='toolbar_popup']//button[text()='Logout']")
	public WebElement btn_LogoutUI;

	@FindBy(xpath = "//*[@title='Sales Order List Applet']//table[@summary='Sales Order']//tr[2]//*[contains(@name,'Refill Order')]")
	public WebElement lnk_OpenRefillOrder;

	/**
	 * Btn relationships query button.
	 *
	 * @return the web element
	 */
	public WebElement btn_RelationshipsQueryButton() {
		expWait.getWhenClickable(By.xpath("//*[@title='Relationships List Applet']//button[@title='Relationships:Query']"), 60).isDisplayed();
		waitForDomToLoad();
		try {
			return expWait.getWhenClickable(By.xpath("//*[@title='Relationships List Applet']//button[@title='Relationships:Query']"), 60);
		} catch (Exception e) {
			return expWait.getWhenClickable(By.xpath("//*[@title='Relationships List Applet']//button[@title='Relationships:Query']"), 60);
		}
	}

	/**
	 * Wait for document to load.
	 */
	public void waitForDomToLoad() {
		waitLong(1);
		expWait.getWhenVisible(By.xpath("//*"), 120);
	}



	/**
	 * Wait for home page sipper to disapper.
	 */
	public void waitForHomePageSipperToDisapper() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String output;
		for (int i = 0; i < 100; i++) {
			output = js.executeScript("return document.getElementsByTagName('html')[0].className").toString();
			if (output.contains("siebui-navigation-tab") && !(output.contains("siebui-busy"))) {
				if (!(i == 0)) {
					System.out.println("WorkFlow Timeout : " + i * 2 + " seconds");
				}
				break;
			} else {
				waitLong(2);
			}
		}
	}
}
