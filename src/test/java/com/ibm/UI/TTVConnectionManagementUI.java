/* 
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15 
 * 
 */
package com.ibm.UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class TTVConnectionManagementUI.
 */
public class TTVConnectionManagementUI extends BaseUIPage {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new TTV connection management UI.
	 *
	 * @param driver
	 *            the driver
	 */
	public TTVConnectionManagementUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	@FindBy(xpath = "//*[text()='Continue' or @type='submit']")
	public WebElement btn_SignIn;

	@FindBy(xpath = "//*[@title='Documents List Applet']//button[@title='Documents:New']")
	public WebElement btn_AddNewDocument;

	@FindBy(xpath = "//*[@title='Documents List Applet']//*[contains(@data-labelledby,'EPIC_TV_Type')]")
	public WebElement btn_OrderTypeDocument;

	@FindBy(xpath = "//*[@title='Documents List Applet']//tr[2]//td[contains(@data-labelledby,'EPIC_Sub_Type') or contains(@id,'EPIC_Sub_Type')]")
	public WebElement btn_OrderSubTypeDocument;

	@FindBy(xpath = "//*[@title='Documents List Applet']//*[contains(@id,'1_s_1_l_Order_Number')]/a")
	public WebElement lnk_DocumentNumber;

	@FindBy(xpath = "//*[@title='Document Line items List Applet']//*[text()='Default']")
	public WebElement btn_DefaultButton;

	@FindBy(xpath = "//*[@title='Document Line items List Applet']//*[text()='LPG-PR']")
	public WebElement txt_DefaultLineItem;

	@FindBy(xpath = "(//*[@title='Document Line items List Applet']//*[.='New'])[1]")
	public WebElement btn_Plus_DefaultLineItem;

	@FindBy(xpath = "//*[@title='Document Line items List Applet']//*[@name='Equipment_Promo']/../span")
	public WebElement btn_DefaultLineItemAddEquipmentPickApplet;

	@FindBy(xpath = "(//*[@title='Pick Promotion List Applet']//button[@aria-label='Pick Promotion:OK'])[1]")
	public WebElement txt_DefaultLineItemOKButton;

	@FindBy(xpath = "(//*[@title='Pick Promotion List Applet']//button[@aria-label='Pick Promotion:Cancel'])[2]")
	public WebElement txt_DefaultLineItemCancelButton;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[contains(@aria-labelledby,'EPIC_Distributator_Name_Label')]")
	public WebElement txtBox_TargetDistributorName;

	@FindBy(xpath = "//*[@title='Distributors List Applet']//*[@summary='Distributors']//tr[2]//td[2]")
	public WebElement txt_TargetDistributNameFromList;

	@FindBy(xpath = "//*[@title='Distributors List Applet']//*[text()='OK']")
	public WebElement txt_TargetDistributNameOK;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[@aria-labelledby='Description_Label']")
	public WebElement txt_Comment;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[@aria-label='Cylinder To Surrender']")
	public WebElement txtBox_CylinderToSurrender;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[@aria-labelledby='EPIC_Transferre_Contact_Last_Name_Label']")
	public WebElement txt_TransferreContactName;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[@aria-labelledby='EPIC_Transferre_Contact_Last_Name_Label']/../span")
	public WebElement txt_TransferreContactNameIcon;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//button[@aria-label='Documents:Submit']")
	public WebElement txt_DocumentSubmit;

	@FindBy(xpath = "//*[@title='Related Asset List Applet']//*[@aria-label='Related Asset:OK']")
	public WebElement btn_OK_RelatedAsset;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[@aria-labelledby='Status_Label']")
	public WebElement txt_StatusDocument;

	@FindBy(xpath = "//*[@title='Documents Form Applet']//button[@aria-label='Documents:Invoice']")
	public WebElement txt_Invoice;

	@FindBy(xpath = "//*[@title='Invoices List Applet']//td[contains(@id,'Status')]")
	public WebElement txt_InvoiceStatus;

	@FindBy(xpath = "//*[@title='Invoices List Applet']//td[contains(@id,'Invoice_Number')]")
	public WebElement txt_InvoiceNumber;

	@FindBy(xpath = "//a[text()='Invoice:']")
	public WebElement lnk_InvoiceLinkNavigateBack;
	

	@FindBy(xpath = "//*[@title='Document Line items List Applet']//input[contains(@id,'Equipment_Promo')]")
	public WebElement txtBox_EquipmentPromo;
	
	@FindBy(xpath = "//*[@title='Pick Promotion List Applet']//td[text()='Promotion']")
	public WebElement lnk_PickPromotion;
	
	
	@FindBy(xpath = "//*[@title='Pick Promotion List Applet']//*[@data-display='OK']")
	public WebElement btn_PickPromotionOKButton;
	
	@FindBy(xpath = "(//*[@title='Document Line items List Applet']//td[contains(@id,'EPIC_Availability_Code')])[2]")
	public WebElement btn_DestinationAvailabilityCode;
	
	

			@FindBy(xpath = "//*[@title='Pick Bucket Category:OK']")
			public WebElement btn_OKDestination;
			

			@FindBy(xpath = "(//*[contains(text(),'Defective')])[2]")
			public WebElement btn_DestinationLineItem;
	
	

	//*[@title='Pick Bucket Category:OK']
	
	/**
	 * Gets the pick promotion from applet.
	 *
	 * @param promotion
	 *            the promotion
	 * @return the pick promotion from applet
	 */
	public WebElement get_PickPromotionFromApplet(String promotion) {
		return driver.findElement(By.xpath("//*[@title='Pick Promotion List Applet']//*[text()='" + promotion + "']"));
	}
	
	public List<WebElement> get_serialNumberList() {
		return driver.findElements(By.xpath("//*[@title='Document Line items List Applet']//td[contains(@id,'Serial_Number')]"));
	}
	
	public List<WebElement> get_TareWeight() {
		return driver.findElements(By.xpath("//*[@title='Document Line items List Applet']//td[contains(@id,'EPIC_Tare_Weight')]"));
	}
	
	
	public List<WebElement> get_GrossWeight() {
		return driver.findElements(By.xpath("//*[@title='Document Line items List Applet']//td[contains(@id,'EPIC_Gross_Weight')]"));
	}
	
	public List<WebElement> get_RemarksWeight() {
		return driver.findElements(By.xpath("//*[@title='Document Line items List Applet']//td[contains(@id,'EPIC_Remarks')]"));
	}
	
	public List<WebElement> get_SealWeight() {
		return driver.findElements(By.xpath("//*[@title='Document Line items List Applet']//td[contains(@id,'EPIC_Seal')]"));
	}
	

}
