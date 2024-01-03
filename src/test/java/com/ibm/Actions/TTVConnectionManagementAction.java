/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.PortalUI;
import com.ibm.UI.TTVConnectionManagementUI;

/**
 * The Class TTVConnectionManagementAction.
 */
public class TTVConnectionManagementAction extends BaseAction {
    /**
     * The ttv con page.
     */
    protected TTVConnectionManagementUI ttvConPage;

    /**
     * The home page.
     */
    protected HomePageUI homePage;

    /**
     * The contact tab.
     */
    protected ContactTabUI contactTab;

    /**
     * The contact tab.
     */
    protected PortalUI portUI;

    /**
     * The driver.
     */
    WebDriver driver;

    /**
     * Class Instances.
     */
    String orderNumber;

    /**
     * Instantiates a new TTV connection management action.
     *
     * @param driver the driver
     */
    public TTVConnectionManagementAction(WebDriver driver) {
        super(driver);
        ttvConPage = new TTVConnectionManagementUI(driver);
        homePage = new HomePageUI(driver);
        contactTab = new ContactTabUI(driver);
        portUI = new PortalUI(driver);
        this.driver = driver;
    }

    /**
     * Adds the new document.
     */
    public void addNewDocumentChange() {
        ttvConPage.btn_AddNewDocument.click();
        ttvConPage.btn_OrderTypeDocument.click();
        ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys("TTV");
        ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        ttvConPage.btn_OrderSubTypeDocument.click();
        ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys("Change Distributor");
        ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        System.out.println(ttvConPage.lnk_DocumentNumber.getText());
        ttvConPage.lnk_DocumentNumber.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.btn_DefaultButton.click();
        ttvConPage.txt_DefaultLineItem.isDisplayed();
    }

    /**
     * Adds the target distributor name.
     */
    public void addTargetDistributorName() {
        ttvConPage.txtBox_TargetDistributorName.click();
		expWait.waitForDomToLoad();
        ttvConPage.txtBox_TargetDistributorName.findElement(By.xpath("following-sibling::span")).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        ttvConPage.txt_TargetDistributNameFromList.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        ttvConPage.txt_TargetDistributNameOK.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        ttvConPage.txt_Comment.click();
        ttvConPage.txt_Comment.sendKeys("Test Comment...");
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
    }

    /**
     * Adds the new document normal.
     */
    public void addComment() {
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.txt_Comment.click();
        ttvConPage.txt_Comment.sendKeys("Test Comment...");
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
    }

    /**
     * Adds the new document normal.
     */
    public void addNewDocumentNormal() {
        ttvConPage.btn_AddNewDocument.click();
        ttvConPage.btn_OrderTypeDocument.click();
        ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys("TV");
        ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        ttvConPage.btn_OrderSubTypeDocument.click();
        ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys("Normal");
        ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        System.out.println(ttvConPage.lnk_DocumentNumber.getText());
        ttvConPage.lnk_DocumentNumber.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.btn_DefaultButton.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.txt_DefaultLineItem.isDisplayed();
        // ConPage.txt_TargetDistributNameOK.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.txt_Comment.click();
        ttvConPage.txt_Comment.sendKeys("Test Comment...");
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
        ttvConPage.txt_DocumentSubmit.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
        ttvConPage.txt_Invoice.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
        System.out.println("Invoice Status :" + ttvConPage.txt_InvoiceStatus.getAttribute("value"));
        ttvConPage.txt_InvoiceStatus.click();
        ttvConPage.txt_InvoiceStatus.findElement(By.tagName("input")).sendKeys("Completed");
        ttvConPage.txt_InvoiceStatus.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        ttvConPage.txt_InvoiceNumber.click();
        ttvConPage.lnk_InvoiceLinkNavigateBack.click();
        System.out.println("Invoice Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
    }

    /**
     * Adds the new document.
     */
    public void addNewDocument() {
        ttvConPage.btn_AddNewDocument.click();
    }

    /**
     * Adds the new document and select type.
     *
     * @param documentType    the document type
     * @param documentSubType the document sub type
     */
    public void addNewDocumentAndSelectType(String documentType, String documentSubType) {
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        ttvConPage.btn_OrderTypeDocument.isDisplayed();
        expWait.waitForDomToLoad();
        ttvConPage.btn_OrderTypeDocument.isDisplayed();
        ttvConPage.btn_OrderTypeDocument.click();
        ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys(documentType);
        ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        ttvConPage.btn_OrderSubTypeDocument.click();
        ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys(documentSubType);
        ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        System.out.println(ttvConPage.lnk_DocumentNumber.getText());
        ttvConPage.lnk_DocumentNumber.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        try {
            ttvConPage.btn_DefaultButton.isDisplayed();
        } catch (Exception e) {
            ttvConPage.lnk_DocumentNumber.click();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
        }
    }

    /**
     * Creates the default document.
     */
    public void createDefaultDocument() {
        ttvConPage.btn_DefaultButton.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.txt_DefaultLineItem.isDisplayed();
    }

    /**
     * add TCRV lost equipment.
     */
    public void addTCRVLostEquipment() {
        {
            ttvConPage.btn_Plus_DefaultLineItem.click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
        }

        try {
            ttvConPage.txtBox_EquipmentPromo.click();
            expWait.waitForHomePageSipperToDisapper();
            ttvConPage.txtBox_EquipmentPromo
                    .findElement(By.xpath("following-sibling::span")).click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
            ttvConPage.lnk_PickPromotion.click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
        } catch (Exception e) {
            driver.navigate().refresh();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();

            ttvConPage.txtBox_EquipmentPromo.click();
            expWait.waitForHomePageSipperToDisapper();
            ttvConPage.txtBox_EquipmentPromo
                    .findElement(By.xpath("following-sibling::span")).click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
            ttvConPage.lnk_PickPromotion.click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
        }

        ttvConPage.btn_PickPromotionOKButton.click();

        //verify presence of alert
        alertVerificationAndAcceptAlert(60);

        try {
            ttvConPage.txt_DefaultLineItemCancelButton.click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
        } catch (Exception e) {

        }
    }

    /**
     * Submit and invoice lost document.
     */
    public void submitAndInvoiceDocumentLost() {
        ttvConPage.txt_DocumentSubmit.click();

        //verify presence of alert
        alertVerificationAndDismissAlert(20);

        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
        ttvConPage.txt_Invoice.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
        System.out.println("Invoice Status :" + ttvConPage.txt_InvoiceStatus.getAttribute("value"));
    }

    /**
     * Adds the default line item add equipment.
     */
    public void addDefaultLineItemAddEquipment() {
        ttvConPage.btn_Plus_DefaultLineItem.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
        ttvConPage.btn_DefaultLineItemAddEquipmentPickApplet.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
        ttvConPage.get_PickPromotionFromApplet("Additional Cylinder Issue - 14.2 Kg").click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
        ttvConPage.txt_DefaultLineItemOKButton.click();
        expWait.waitLong(5);

        //verify presence of alert
        alertVerificationAndAcceptAlert(60);

        try {
            ttvConPage.txt_DefaultLineItemCancelButton.click();
			expWait.waitForHomePageSipperToDisapper();
			expWait.waitForDomToLoad();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Re-price all and add comment.
     */
    public void repriceAllAndAddComment() {
        try {
            expWait.waitForDomToLoad();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
            contactTab.btn_DocumentLineRepriceAll.click();
        } catch (Exception e) {
            performAltEnter();
            expWait.waitForDomToLoad();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
            contactTab.btn_DocumentLineRepriceAll.click();
        }
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
		/*ttvConPage.txt_Comment.click();
		ttvConPage.txt_Comment.sendKeys("Test Comment...");*/
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
    }

    /**
     * Adds the comment.
     */
    public void AddComment() {
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.txt_Comment.click();
        ttvConPage.txt_Comment.sendKeys("Test Comment...");
        if(ttvConPage.txtBox_CylinderToSurrender.getAttribute("aria-readonly").equals("false")) {
            ttvConPage.txtBox_CylinderToSurrender.sendKeys("1");
            expWait.waitForHomePageSipperToDisapper();
            ttvConPage.txtBox_CylinderToSurrender.sendKeys(Keys.ENTER);
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
            try {
                ttvConPage.btn_OK_RelatedAsset.click();
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                ttvConPage.btn_DefaultButton.click();
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Document Status: " + ttvConPage.txt_StatusDocument.getAttribute("value"));
    }

    /**
     * Submit and invoice document.
     */
    public void submitAndInvoiceDocument() {
        ttvConPage.txt_DocumentSubmit.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));

        try {
            if (ttvConPage.txt_DocumentSubmit.getAttribute("disabled").equals("false")) {
                ttvConPage.txt_DocumentSubmit.click();
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

		performRefresh();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        ttvConPage.txt_Invoice.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        System.out.println("Document Status: " + ttvConPage.txt_StatusDocument.getAttribute("value"));
        System.out.println("Invoice Status: " + ttvConPage.txt_InvoiceStatus.getAttribute("textContent"));
    }

    /**
     * Invoice complete.
     */
    public void invoiceComplete() {
        ttvConPage.txt_InvoiceStatus.click();
        ttvConPage.txt_InvoiceStatus.findElement(By.tagName("input")).sendKeys("Completed");
        ttvConPage.txt_InvoiceStatus.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        ttvConPage.txt_InvoiceNumber.click();
        expWait.waitLong(5);
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Open order.
     */
    public void openOrder() {
        try {
            contactTab.txt_OrderNumber.click();
        } catch (Exception e) {
            System.out.println("Retry click on Order Number After marking complete status.");
            contactTab.txt_OrderNumber.click();
        }
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        System.out.println("Invoice Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
    }

    /**
     * Navigate to installation tab.
     */
    public void navigateToInstallationTab() {
        contactTab.get_LowerTabLevel("Installation").click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //store sales order number.
        orderNumber = contactTab.lnk_InstallationOrderNumber.getAttribute("textContent");
        System.out.println("SalesOrderNumber: "+orderNumber);

        contactTab.lnk_InstallationOrderNumber.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        System.out.println("Delivery boy : " + contactTab.txt_InstallationDelivery_Boy.getAttribute("value"));
    }

    /**
     * Creates the invoice.
     */
    public void createInvoice() {
        contactTab.btn_InstallationCreateInvoice.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        performRefresh();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //DAC flag verification.
        new ContactTabAction(driver).flagVerifyDAC();

        contactTab.get_LowerTabLevel("Invoice").click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        System.out.println(contactTab.lnk_InvoiceCashMemoNumber.getText());
        contactTab.lnk_InvoiceCashMemoNumber.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        contactTab.lnk_InvoiceStatus.click();
        expWait.waitForDomToLoad();
    }

    /**
     * Complete invoice.
     */
    public void completeInvoice() {
        String name = contactTab.lnk_InvoiceStatus.getAttribute("name");
        //js to upate the invoice status.
        executeJs("document.getElementsByName(\"" + name + "\")[0].value=\"\";");
        expWait.waitForDomToLoad();

        contactTab.lnk_InvoiceStatus.sendKeys("Completed");
        contactTab.lnk_InvoiceStatus.sendKeys(Keys.ENTER);
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //verify presence of alert
        alertVerificationAndAcceptAlert(8);

        performRefresh();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    /**
     * Validate sales order status.
     */
    public void validateSalesOrderStatus(){
        contactTab.get_MainTabLevel("Sales Order").click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.btn_SearchSalesOrder.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.txtBox_SalesOrderNumber.sendKeys(orderNumber);

        portUI.btn_EnterSearchSalesOrder.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.get_SalesOrderNumberLink(orderNumber).click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        contactTab.get_LowerTabLevel("Invoice").click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        Assert.assertEquals(contactTab.txt_SaleOrderStatus.getAttribute("value"), "Completed",
                "Error ! Invoice status found not completed.");
    }

    public void AddReplacementInformation() {
        fillData(ttvConPage.get_serialNumberList(), "23456789");
        fillData(ttvConPage.get_TareWeight(), "15");
        fillData(ttvConPage.get_GrossWeight(), "20");
        fillData(ttvConPage.get_RemarksWeight(), "Test Remark");
        fillData(ttvConPage.get_SealWeight(), "Y");

        ttvConPage.btn_DestinationAvailabilityCode.click();
        ttvConPage.btn_DestinationAvailabilityCode.findElement(By.tagName("span")).click();
        ttvConPage.btn_DestinationLineItem.click();
        ttvConPage.btn_OKDestination.click();
    }

    public void fillData(List<WebElement> eleList, String data) {

        for (WebElement ele : eleList) {
            ele.click();
            ele.findElement(By.tagName("input")).click();
            ele.findElement(By.tagName("input")).sendKeys(data);
            expWait.waitLong(1);
        }

    }
}
