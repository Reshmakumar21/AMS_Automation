/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2019-10-17
 *
 */
package com.ibm.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class ContactTabUI.
 */
public class NFR_UI extends BaseUIPage {
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
    public NFR_UI(WebDriver driver) {
        super(driver);
        this.driver = driver;
        expWait = new SeleniumWait(driver);
    }

    /**
     * The btn to add new secondary sales order.
     */
    @FindBy(xpath = "//*[@title='Sales Order List Applet']//button[contains(@aria-label,'New')]")
    public WebElement btn_CreateNewSecondarySalesOrder;

    /**
     * The order type.
     */
    @FindBy(xpath = "(//*[@title='Sales Order List Applet']//td[contains(@id,'Booking_Type')])[1]")
    public WebElement txtBox_OrderType;

    /**
     * The drop down to select order sub type.
     */
    @FindBy(xpath = "(//*[@title='Sales Order List Applet']//td[contains(@id,'Order_Sub_Type')])[1]")
    public WebElement txtBox_OrderSubType;

    /**
     * The link to drill down sales order.
     */
    @FindBy(xpath = "//*[@title='Sales Order List Applet']//td[contains(@id,'Refill_Order__')]/a")
    public WebElement lnk_SalesOrder;

    /**
     * The btn AddInvProducts to add products NFR for a secondary sales order.
     */
    @FindBy(xpath = "//*[@title='Line Items List Applet']//button[contains(@aria-label, 'AddInvProducts')]")
    public WebElement btn_AddInvProducts;

    /**
     * The btn New to add products for a FTL secondary sales order.
     */
    @FindBy(xpath = "//*[@title='Line Items List Applet']//button[contains(@aria-label, 'Line Items:New')]")
    public WebElement btn_LineItemsNew;

    /**
     * The btn New to add products for a FTL secondary sales order.
     */
    @FindBy(xpath = "//*[@title=' List Applet']//*[contains(@data-labelledby, 'EPIC_Scheme_Type')]")
    public WebElement   txtBox_ListAppletSchemeType;

    /**
     * The btn OK under applet list under FTL Sales.
     */
    @FindBy(xpath = "//*[@title=' List Applet']//*[@class='siebui-popup-button']//*[contains(@aria-label, 'OK')]")
    public WebElement btn_OK;

    /**
     * The btn Get Price for FTL Sales.
     */
    @FindBy(xpath = "//*[@title='Line Items']//button[contains(@aria-label, 'Get Price')]")
    public WebElement btn_GetPrice;

    /**
     * The tab Invoice under secondary sale order UI.
     */
    @FindBy(xpath = "//*[@title='Third Level View Bar']//a[text()='Invoice']")
    public WebElement tab_Invoice;

    /**
     * The tab Payments under secondary sale order UI.
     */
    @FindBy(xpath = "//*[@title='Third Level View Bar']//a[text()='Payments']")
    public WebElement tab_Payments;

    /**
     * The payment status under Payments tab of Invoice.
     */
    @FindBy(xpath = "//*[@title='Payments List Applet']//tr[2]//td[contains(@id, '_Payment_Status')]")
    public WebElement txtBox_PaymentStatus;

    /**
     * The payment method under Payments tab of Invoice.
     */
    @FindBy(xpath = "//*[@title='Payments List Applet']//tr[2]//td[contains(@id, '_Payment_Method')]")
    public WebElement txtBox_PaymentMethod;

    /**
     * The Transaction Type under Payments tab of Invoice.
     */
    @FindBy(xpath = "//*[@title='Payments List Applet']//tr[2]//td[contains(@id, '_EPIC_Transaction_Type')]")
    public WebElement txtBox_TransactionType;

    /**
     * The btn Add under Inventory Level after AddInvProducts click.
     */
    @FindBy(xpath = "//button[contains(@aria-label, 'Inventory Level:Add')]")
    public WebElement btn_InventoryLevelAdd;

    /**
     * The txtBox for Year under line item for NFR Order.
     */
    @FindBy(xpath = "(//*[@title='Line Items List Applet']//*[contains(@id,'EPIC_Year')])[3]")
    public WebElement txtBox_Year_NFR_Item;

    /**
     * The txtBox for month under line item for NFR Order.
     */
    @FindBy(xpath = "(//*[@title='Line Items List Applet']//*[contains(@id,'EPIC_Month')])[3]")
    public WebElement txtBox_Month_NFR_Item;
	
    /**
     * The btn Submit.
     */
    @FindBy(xpath = "//*[@title='Sales Order Form Applet']//button[contains(@aria-label, 'Submit')]")
    public WebElement btn_Submit;

    /**
     * The txtBox Order Status.
     */
    @FindBy(xpath = "//*[@title='Sales Order Form Applet']//input[contains(@aria-labelledby, 'Order_Status_Label')]")
    public WebElement txtBox_OrderStatus;

    /**
     * The txtBox Invoice Status.
     */
    @FindBy(xpath = "//*[@title='Invoices List Applet']//td[contains(@id,'_Status')]")
    public WebElement txtBox_InvoiceStatus;

    /**
     * The link to Invoice.
     */
    @FindBy(xpath = "//table[@summary='All Invoices List']//*[contains(@id,'_Invoice_Number')]/a")
    public WebElement lnk_InvoiceNumber;

    /**
    * The link to Invoice.
    */
    @FindBy(xpath = "//*[@title='Line Items List Applet']//*[contains(@id,'_Order_Number')]/a")
    public WebElement lnk_InvoiceLineItemOrderStatus;

}
