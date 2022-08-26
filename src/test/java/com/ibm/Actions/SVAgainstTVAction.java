/* 
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15 
 * 
 */
package com.ibm.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.SVAgainstTVUI;
import com.ibm.UI.TTVConnectionManagementUI;

/**
 * The Class SVAgainstTVAction.
 */
public class SVAgainstTVAction extends BaseAction{
	/** The ttv con page. */
	protected TTVConnectionManagementUI ttvConPage;

	/** The home page. */
	protected HomePageUI homePage;

	/** The sv against TV page. */
	protected SVAgainstTVUI svAgainstTVPage;

	/** The contact tab. */
	protected ContactTabUI contactTab;

	/** The temp customer name. */
	String tempCustomerName;

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new SV against TV action.
	 *
	 * @param driver
	 *            the driver
	 */
	public SVAgainstTVAction(WebDriver driver) {
		super(driver);
		ttvConPage = new TTVConnectionManagementUI(driver);
		homePage = new HomePageUI(driver);
		svAgainstTVPage = new SVAgainstTVUI(driver);
		contactTab = new ContactTabUI(driver);
		this.driver = driver;
	}

	/**
	 * Adds the new document.
	 *
	 * @param customerName
	 *            the customer name
	 */
	public void addNewDocument(String customerName) {
		contactTab.isTabDisplayInTabList("Documents");
		ttvConPage.btn_AddNewDocument.click();
		ttvConPage.btn_OrderTypeDocument.click();
		ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys("TV");
		ttvConPage.btn_OrderTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		ttvConPage.btn_OrderSubTypeDocument.click();
		ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys("Name Change-Legal Heir");
		ttvConPage.btn_OrderSubTypeDocument.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		System.out.println(ttvConPage.lnk_DocumentNumber.getText());
		ttvConPage.lnk_DocumentNumber.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		ttvConPage.btn_DefaultButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		ttvConPage.txt_DefaultLineItem.isDisplayed();
		ttvConPage.txt_Comment.click();
		ttvConPage.txt_Comment.sendKeys("Test Comment...");
		ttvConPage.txt_TransferreContactName.click();
		ttvConPage.txt_TransferreContactNameIcon.click();
		svAgainstTVPage.txt_PickAppletFirstName.isDisplayed();
		svAgainstTVPage.txt_PickAppletFirstName.click();
		svAgainstTVPage.txt_PickAppletFirstName.findElement(By.tagName("input")).sendKeys(customerName);
		svAgainstTVPage.txt_PickAppletFirstName.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		svAgainstTVPage.btn_PickAppletGO.click();
		expWait.waitForDomToLoad();
		svAgainstTVPage.btn_PickAppletOK.click();
		expWait.waitForDomToLoad();
		ttvConPage.txt_DocumentSubmit.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
		ttvConPage.txt_Invoice.click();
		expWait.waitLong(5);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
		System.out.println("Invoice Status :" + ttvConPage.txt_InvoiceStatus.getAttribute("value"));
		ttvConPage.txt_InvoiceNumber.click();
		contactTab.lnk_InvoiceStatus.click();
		String name = contactTab.lnk_InvoiceStatus.getAttribute("name");
		System.out.println(name);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName(\"" + name + "\")[0].value=\"\";");
		expWait.waitForDomToLoad();
		contactTab.lnk_InvoiceStatus.sendKeys("Completed");
		contactTab.lnk_InvoiceStatus.sendKeys(Keys.TAB);
		// TODO cntrl+s
		expWait.waitLong(5);
		expWait.waitForDomToLoad();
		try {
			contactTab.txt_OrderNumber.click();
		} catch (Exception e) {
			System.out.println("Retry click on Order Number After marking complete status.");
			contactTab.txt_OrderNumber.click();
		}
		// navigate to relation ship
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		homePage.tab_RelationShips.click();
		expWait.waitForDomToLoad();
		homePage.btn_SearchRelationShip.isDisplayed();
		homePage.txt_RelationshipsList.click();
		expWait.waitForDomToLoad();
		homePage.SelectElementFromDropdown(homePage.select_RoleRelationShip, "visibleText", "All Relationships");
		homePage.btn_RelationshipsQueryButton().click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		homePage.txtBox_RelationShipNumber.click();
		homePage.txtBox_FirstNameRelationSearch.click();
		homePage.txtBox_FirstNameRelationSearch.findElement(By.tagName("input")).sendKeys(customerName);
		homePage.txtBox_FirstNameRelationSearch.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		homePage.btn_SearchRelationShipQuery.click();
		homePage.lnk_LastNameLinkRelationShipSearch.isDisplayed();
		homePage.lnk_LastNameLinkRelationShipSearch.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		homePage.lnk_RelationShipNumberCustomerPage.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.isTabDisplayInTabList("Documents");
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_ServiceArea.click();
		contactTab.btn_ServiceArea.sendKeys("NAGARIYA PARIKSHIT");
		contactTab.btn_ServiceArea.sendKeys(Keys.TAB);
		ttvConPage.lnk_DocumentNumber.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		ttvConPage.btn_DefaultButton.click();
		expWait.waitForDomToLoad();
		ttvConPage.btn_DefaultButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		ttvConPage.txt_DefaultLineItem.isDisplayed();
		expWait.waitLong(5);
		contactTab.btn_DocumentsSubmit.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_DocumentsInvoice.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Navigate to document tab.
	 */
	public void navigateToDocumentTab() {
		contactTab.isTabDisplayInTabList("Documents");
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Adds the new document and select type.
	 *
	 * @param documentType
	 *            the document type
	 * @param documentSubType
	 *            the document sub type
	 */
	public void addNewDocumentAndSelectType(String documentType, String documentSubType) {
		ttvConPage.btn_AddNewDocument.click();
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
	}

	/**
	 * Creates the default document.
	 */
	public void createDefaultDocument() {
		ttvConPage.btn_DefaultButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		ttvConPage.txt_DefaultLineItem.isDisplayed();
		ttvConPage.txt_Comment.click();
		ttvConPage.txt_Comment.sendKeys("Test Comment...");
	}

	/**
	 * Select transferrer contact name.
	 *
	 * @param customerName
	 *            the customer name
	 */
	public void selectTransferreContactName(String customerName) {
		ttvConPage.txt_TransferreContactName.click();
		ttvConPage.txt_TransferreContactNameIcon.click();
		svAgainstTVPage.txt_PickAppletFirstName.isDisplayed();
		svAgainstTVPage.txt_PickAppletFirstName.click();
		svAgainstTVPage.txt_PickAppletFirstName.findElement(By.tagName("input")).sendKeys(customerName);
		svAgainstTVPage.txt_PickAppletFirstName.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		svAgainstTVPage.btn_PickAppletGO.click();
		expWait.waitForDomToLoad();
		svAgainstTVPage.btn_PickAppletOK.click();
		expWait.waitForDomToLoad();
	}

	/**
	 * Submit document.
	 */
	public void submitDocument() {
		ttvConPage.txt_DocumentSubmit.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
	}

	/**
	 * Invoice document.
	 */
	public void invoiceDocument() {
		ttvConPage.txt_Invoice.click();
		expWait.waitLong(5);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("Document Status :" + ttvConPage.txt_StatusDocument.getAttribute("value"));
		System.out.println("Invoice Status :" + ttvConPage.txt_InvoiceStatus.getAttribute("value"));
	}

	/**
	 * Open invoice document and complete.
	 */
	public void openInvoiceDocumentAndComplete() {
		ttvConPage.txt_InvoiceNumber.click();
		contactTab.lnk_InvoiceStatus.click();
		String name = contactTab.lnk_InvoiceStatus.getAttribute("name");
		System.out.println(name);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName(\"" + name + "\")[0].value=\"\";");
		expWait.waitForDomToLoad();
		contactTab.lnk_InvoiceStatus.sendKeys("Completed");
		contactTab.lnk_InvoiceStatus.sendKeys(Keys.TAB);
		// TODO cntrl+s
		expWait.waitLong(5);
		expWait.waitForDomToLoad();
	}

	/**
	 * Open order number from invoice.
	 */
	public void openOrderNumberFromInvoice() {
		try {
			contactTab.txt_OrderNumber.click();
		} catch (Exception e) {
			System.out.println("Retry click on Order Number After marking complete status.");
			contactTab.txt_OrderNumber.click();
		}
		// navigate to relation ship
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Navigate to relation ship tab.
	 */
	public void navigateToRelationShipTab() {
		homePage.tab_RelationShips.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		homePage.btn_SearchRelationShip.isDisplayed();
	}

	/**
	 * Search relation ship by customer name.
	 *
	 * @param customerName
	 *            the customer name
	 */
	public void searchRelationShipByCustomerName(String customerName) {
		/*homePage.txt_RelationshipsList.click();
		expWait.waitForDomToLoad();
		homePage.SelectElementFromDropdown(homePage.select_RoleRelationShip, "visibleText", "All Relationships");*/
		homePage.btn_RelationshipsQueryButton().click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		homePage.txtBox_RelationShipNumber.click();
		homePage.txtBox_FirstNameRelationSearch.click();
		homePage.txtBox_FirstNameRelationSearch.findElement(By.tagName("input")).sendKeys(customerName);
		homePage.txtBox_FirstNameRelationSearch.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		homePage.btn_SearchRelationShipQuery.click();
		homePage.lnk_LastNameLinkRelationShipSearch.isDisplayed();
	}

	/**
	 * Click on last name and contact page display.
	 */
	public void clickOnLastNameAndContactPageDisplay() {
		homePage.lnk_LastNameLinkRelationShipSearch.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		homePage.lnk_RelationShipNumberCustomerPage.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Navigate to document tab 2.
	 */
	public void navigateToDocumentTab2() {
		contactTab.isTabDisplayInTabList("Documents");
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Select service area.
	 */
	public void selectServiceArea() {
		contactTab.btn_ServiceArea.click();
		contactTab.btn_ServiceArea.sendKeys("NAGARIYA PARIKSHIT");
		contactTab.btn_ServiceArea.sendKeys(Keys.TAB);
	}

	/**
	 * Open document.
	 */
	public void openDocument() {
		ttvConPage.lnk_DocumentNumber.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Creates the default order.
	 */
	public void createDefaultOrder() {
		ttvConPage.btn_DefaultButton.click();
		expWait.waitForDomToLoad();
	/*	ttvConPage.btn_DefaultButton.click();
		expWait.waitForDomToLoad();*/
		expWait.waitForHomePageSipperToDisapper();
		ttvConPage.txt_DefaultLineItem.isDisplayed();
		expWait.waitLong(5);
	}

	/**
	 * Submit document and status.
	 */
	public void submitDocumentAndStatus() {
		contactTab.btn_DocumentsSubmit.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Invoice document and status.
	 */
	public void invoiceDocumentAndStatus() {
		contactTab.btn_DocumentsInvoice.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}
}
