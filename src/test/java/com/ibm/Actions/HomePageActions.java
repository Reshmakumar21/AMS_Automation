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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.Utilities;

/**
 * The Class HomePageActions.
 */
public class HomePageActions extends BaseAction{
	/** The home page. */
	protected HomePageUI homePage;

	/** The contact tab. */
	protected ContactTabUI contactTab;

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new home page actions.
	 *
	 * @param driver
	 *            the driver
	 */
	public HomePageActions(WebDriver driver) {
		super(driver);
		homePage = new HomePageUI(driver);
		contactTab = new ContactTabUI(driver);
		this.driver = driver;
	}

	/**
	 * Verify home page display.
	 */
	public void verifyHomePageDisplay() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		Assert.assertTrue(homePage.tab_RelationShips.isDisplayed());
		Utilities.takeScreenshot("Test");
	}

	/**
	 * Launch relation ship tab.
	 */
	public void launchRelationShipTab() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		homePage.tab_RelationShips.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		homePage.btn_SearchRelationShip.isDisplayed();
	}

	/**
	 * Search for relation ship number.
	 *
	 * @param relationShipNumber
	 *            the relation ship number
	 */
	public void searchForRelationShipNumber(String relationShipNumber) {
		/*homePage.txt_RelationshipsList.click();
		expWait.waitForDomToLoad();
		homePage.SelectElementFromDropdown(homePage.select_RoleRelationShip, "visibleText", "All Relationships");*/
		homePage.btn_RelationshipsQueryButton().click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		homePage.txtBox_RelationShipNumber.click();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("relationShip Number : " + relationShipNumber);
		homePage.txtBox_RelationShipNumber.findElement(By.tagName("input")).sendKeys(relationShipNumber);
		homePage.txtBox_RelationShipNumber.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		homePage.btn_SearchRelationShipQuery.click();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Open relation ship from search result.
	 */
	public void openRelationShipFromSearchResult() {
		homePage.lnk_RelationShipNumberRearchResult.click();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Creates the default order.
	 */
	public void createDefaultOrder() {
		homePage.lnk_DefaultButtonRelationShip.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Verify order created.
	 */
	public void verifyOrderCreated() {
		String status = homePage.txt_SalesOrder_OrderStatus.getAttribute("value");
		//Assert.assertTrue( status.equalsIgnoreCase("Open"),"OrderStatus : " + status);
		LoggerWriter.logger.log(Status.PASS, "OrderStatus : " + status);
	}

	/**
	 * Enter delivery boy.
	 */
	public void enterDeliveryBoy() {
		homePage.btn_DeliveryBoy.click();
		//expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		homePage.txt_DeliveryBoySearchResultFromSummary.click();
		homePage.txt_DeliveryBoySearchResultOKButton.click();
		performSave();
		expWait.waitForHomePageSipperToDisapper();
		//expWait.waitForDomToLoad();
		performRefresh();
		expWait.waitForHomePageSipperToDisapper();
		//expWait.waitForDomToLoad();
	}

	/**
	 * Creates the invoice.
	 */
	public void createInvoice() {
		homePage.btn_CreateInvoice.isDisplayed();
		//expWait.waitForDomToLoad();
		homePage.btn_CreateInvoice.click();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Verify invoice order details.
	 */
	public void verifyInvoiceOrderDetails() {
		System.out.println("momo status : " + homePage.txtField_CashMemoStatus.getText());
		LoggerWriter.logger.log(Status.PASS, "Invoice Memo Status : " + homePage.txtField_CashMemoStatus.getText());
		System.out.println("momo status : " + homePage.txtField_CashMemoNumber.getText());
		LoggerWriter.logger.log(Status.PASS, "Invoice Memo Number : " + homePage.txtField_CashMemoNumber.getText());
		System.out.println("Status : " + homePage.txt_SalesOrder_OrderStatus.getAttribute("value")); // Invoiced
		String status = homePage.txt_SalesOrder_OrderStatus.getAttribute("value");
		Assert.assertTrue( status.equalsIgnoreCase("Invoiced"),"OrderStatus : " + status);
		LoggerWriter.logger.log(Status.PASS, "OrderStatus : " + status);
	}

	/**
	 * Complete invoiced order.
	 */
	public void completeInvoicedOrder() {

		//DAC flag verification.
		new ContactTabAction(driver).flagVerifyDAC();

		//DAC flag verification.
		try {
			new ContactTabAction(driver).flagVerifyDAC();
		}catch (Exception e){

		}

		contactTab.get_LowerTabLevel("Invoice").click();
		expWait.waitForHomePageSipperToDisapper();
		//expWait.waitForDomToLoad();

		//homePage.txtField_CashMemoStatus.click();
		//homePage.txtField_CashMemoStatusTextBox.sendKeys(Keys.TAB);
		//expWait.waitForDomToLoad();
		homePage.txtField_CashMemoStatus.click();
		homePage.txtField_CashMemoStatusTextBox.sendKeys("Completed");
		expWait.waitForDomToLoad();
		homePage.txtField_CashMemoStatusTextBox.sendKeys(Keys.TAB);
		//expWait.waitLong(5);
//		Alert simpleAlert = driver.switchTo().alert();
//		System.out.println(simpleAlert.getText());
//		LoggerWriter.logger.log(Status.PASS, "Alert display : " + simpleAlert.getText());
//		simpleAlert.accept();
		// status completed
		performSave();

		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("Status : " + homePage.txt_SalesOrder_OrderStatus.getAttribute("value")); // Completed
		String status = homePage.txt_SalesOrder_OrderStatus.getAttribute("value");
		if(!(status.toLowerCase().contains("completed"))) {
			driver.navigate().refresh();
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();
		}
		Assert.assertTrue( status.equalsIgnoreCase("Completed"),"OrderStatus : " + status);
		LoggerWriter.logger.log(Status.PASS, "OrderStatus : " + status);
	}

	@Override
	public void performSave() {
		try {
			Actions keyAction = new Actions(driver);
			keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cancelled invoiced order.
	 */
	public void cancelledInvoicedOrder() {
		homePage.lnk_CancelInvoice.click();
		homePage.txt_CashMemoReason.click();
		homePage.txt_CashMemoReason.sendKeys("48 hours Cancellation");
		homePage.txt_CashMemoReason.sendKeys(Keys.TAB);
		homePage.btn_CancelMomoButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("Status : " + homePage.txt_SalesOrder_OrderStatus.getAttribute("value")); // Completed
		String status = homePage.txt_SalesOrder_OrderStatus.getAttribute("value");
		Assert.assertTrue( status.equalsIgnoreCase("Open"),"OrderStatus : " + status);
		LoggerWriter.logger.log(Status.PASS, "OrderStatus : " + status);
	}

	/**
	 * Return invoiced order.
	 */
	public void returnInvoicedOrder() {
		System.out.println(homePage.txt_PrintFlag.getText());
		Assert.assertTrue( homePage.txt_PrintFlag.getText().equalsIgnoreCase("N"),"Print Flag : " + homePage.txt_PrintFlag.getText());
		homePage.btn_PrintInvoiceButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		driver.navigate().back();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		// contactTab.isTabDisplayInTabList("Invoice");
		homePage.txt_PrintFlag.isDisplayed();
		homePage.lnk_Return.click();
		homePage.txt_ReturnReason.click();
		homePage.txt_ReturnReason.sendKeys("Door Closed");
		homePage.txt_ReturnReason.sendKeys(Keys.TAB);
		homePage.txt_ReturnReasonApplet.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println(homePage.txt_PrintFlag.getText());
		Assert.assertTrue( homePage.txt_PrintFlag.getText().equalsIgnoreCase("Y"),"Print Flag : " + homePage.txt_PrintFlag.getText());
		System.out.println(homePage.txt_ReturnField.getText());
		Assert.assertTrue( homePage.txt_ReturnField.getText().equalsIgnoreCase("Returned"),"Invoice Status : " + homePage.txt_ReturnField.getText());
		String status = homePage.txt_SalesOrder_OrderStatus.getAttribute("value");
		Assert.assertTrue( status.equalsIgnoreCase("Invoiced"),"OrderStatus : " + status);
	}

	/**
	 * Cancel invoiced order.
	 */
	public void cancelInvoicedOrder() {
		homePage.lnk_CashMemoNumber.click();
		homePage.dropDown_CancelReason.click();
		homePage.dropDown_CancelReason.sendKeys("48 hours Cancellation");
		homePage.dropDown_CancelReason.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		homePage.dropDown_CashMemoStatusLabel.click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		homePage.dropDown_CashMemoStatusLabel.clear();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		String className = homePage.dropDown_CashMemoStatusLabel.getAttribute("class");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementsByClassName(\"" + className + "\")[0].value=\"Cancelled\"";
		System.out.println(script);
		js.executeScript(script);
		homePage.dropDown_CashMemoStatusLabel.sendKeys("Cancelled");
		homePage.dropDown_CashMemoStatusLabel.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		driver.navigate().back();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Logout from UI.
	 */
	public void logOut(){
		homePage.btn_UserNameUI.click();
		expWait.waitForDomToLoad();
		homePage.btn_LogoutUI.click();
	}

	public void openLatestOrder() {
		homePage.lnk_OpenRefillOrder.click();
	}

	public void verifyOrderCancel() {
		String status = homePage.txt_SalesOrder_OrderStatus.getAttribute("value");
		Assert.assertTrue( status.equalsIgnoreCase("Cancelled"),"OrderStatus : " + status);
		LoggerWriter.logger.log(Status.PASS, "OrderStatus : " + status);
	}
	public void verifyPaymentrefund() {

	}
}
