/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class ContactTabUI.
 */
public class ContactTabUI extends BaseUIPage {
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
	public ContactTabUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	/** The btn create new contact. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//button[contains(.,'New')]")
	public WebElement btn_createNewContact;

	/** The drop down salutation. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//input[contains(@aria-labelledby,'Salutation')]")
	public WebElement dropDown_Salutation;

	/** The txt first name. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//input[contains(@aria-labelledby,'First')]")
	public WebElement txt_FirstName;

	/** The txt box first. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//input[contains(@aria-labelledby,'First')]")
	public WebElement txtBox_First;

	/** The txt box last name. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//input[contains(@aria-labelledby,'LastName')]")
	public WebElement txtBox_LastName;

	/** The drop down gender. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//input[contains(@aria-labelledby,'Gender')]")
	public WebElement dropDown_Gender;

	/** The txt box DOB. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//input[contains(@aria-labelledby,'DOB')]")
	public WebElement txtBox_DOB;

	/** The icon search address. */
	@FindBy(xpath = "//*[contains(@aria-labelledby,'EPIC_Address_Line1')]/..//span")
	public WebElement icon_searchAddress;

	/** The btn add adress applet add button. */
	// new address
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//button[@title='Add Address:New']")
	public WebElement btn_AddAdressAppletAddButton;

	/** The txt box pin code. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-label,'Pin')]")
	public WebElement txtBox_PinCode;

	/** The txt box address area. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-labelledby,'Street_Address_4')]")
	public WebElement txtBox_AddressArea;

	/** The txt box address lin 3. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-labelledby,'Street_Address_3')]")
	public WebElement txtBox_AddressLin3;

	/** The txt box address lin 2. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-labelledby,'Street_Address_2')]")
	public WebElement txtBox_AddressLin2;

	/** The txt box address. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-labelledby,'Street_Address')]")
	public WebElement txtBox_Address;

	/** The txt box local body. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-label,'Local Body')]")
	public WebElement txtBox_LocalBody;

	/** The txt box city. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-label,'City')]")
	public WebElement txtBox_City;

	/** The txt box rural. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[contains(@aria-label,'Rural')]")
	public WebElement txtBox_Rural;

	/** The chk box primary address. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//*[@aria-labelledby='SSA_Primary_Field_Label']")
	public WebElement chkBox_PrimaryAddress;

	/** The txt box save address. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//button[contains(.,'Save')]")
	public WebElement txtBox_SaveAddress;

	/** The txt box OK butoon add new address. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//span[contains(text(),'OK')]")
	public WebElement txtBox_OKButoonAddNewAddress;

	/** The txt box identities. */
	// identity
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[contains(@aria-labelledby,'EPIC_Contact_FileName_Label')]")
	public WebElement txtBox_Identities;

	/** The txt box identities search button. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[contains(@aria-labelledby,'EPIC_Contact_FileName_Label')]/..//span")
	public WebElement txtBox_IdentitiesSearchButton;

	/** The btn identities new button. */
	@FindBy(xpath = "//*[@title='Contact Attachment List Applet']//button[@data-display='New']")
	public WebElement btn_IdentitiesNewButton;

	/** The txt identities identity type. */
	// POA-POI
	@FindBy(xpath = "//*[@title='Contact Attachment List Applet']//input[@name='EPIC_Identity_Type']")
	public WebElement txt_IdentitiesIdentityType;

	/** The txt identities identity method. */
	@FindBy(xpath = "//*[@title='Contact Attachment List Applet']//input[contains(@id,'EPIC_Identity_Method')]")
	public WebElement txt_IdentitiesIdentityMethod;

	/** The txt identities identity number. */
	@FindBy(xpath = "//*[@title='Contact Attachment List Applet']//input[contains(@id,'EPIC_Identity_Num')]")
	public WebElement txt_IdentitiesIdentityNumber;

	/** The txt identities identity number area. */
	@FindBy(xpath = "//*[@title='Contact Attachment List Applet']//td[contains(@id,'EPIC_Identity_Num')]")
	public WebElement txt_IdentitiesIdentityNumberArea;

	/** The btn identities OK. */
	@FindBy(xpath = "//*[@title='Contact Attachment List Applet']//button[contains(.,'Ok')]")
	public WebElement btn_IdentitiesOK;

	/** The dropdown BPL. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[contains(@aria-labelledby,'_BPL')]")
	public WebElement dropdown_BPL;

	/** The icon add phone. */
	@FindBy(xpath = "//*[contains(@aria-labelledby,'Alternate_Phone_#_Label')]/..//span")
	public WebElement icon_addPhone;

	/** The btn phone new button. */
	@FindBy(xpath = "//*[@title='Phone List Applet']//button[@data-display='New']")
	public WebElement btn_PhoneNewButton;

	/** The txt phone no. */
	@FindBy(xpath = "//*[@title='Phone List Applet']//input[@name='Address']")
	public WebElement txt_PhoneNum;

	/** The btn phone go. */
	@FindBy(xpath = "//*[@title='Phone List Applet']//div[@class=\'siebui-btn-grp-search\']//button[@title='Phone:Go']")
	public WebElement btn_PhoneGo;

	/** The btn generate otp. */
	@FindBy(xpath = "//button[@title='Phone:Generate OTP']")
	public WebElement btn_GenerateOTP;

	/** The box verify otp. */
	@FindBy(xpath = "//td[contains(@id,'EPIC_Verify_OTP')]")
	public WebElement box_VerifyOTP;

	/** The txt verify otp. */
	@FindBy(xpath = "//*[@title='Phone List Applet']//input[@name='EPIC_Verify_OTP']")
	public WebElement txt_VerifyOTP;

	/** The btn verify otp. */
	@FindBy(xpath = "//button[@title='Phone:Verify OTP']")
	public WebElement btn_VerifyOTP;

	/** The btn phone ok. */
	@FindBy(xpath = "//button[@title='Phone:OK']")
	public WebElement btn_PhoneOk;

	/** The btn contact dedup. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[contains(@title,'Contact Dedup')]")
	public WebElement btn_ContactDedup;

	/** The btn contact dedup pick record. */
	@FindBy(xpath = "//*[@title='Contact DeDup Results List Applet']//*[contains(text(),'Pick Record')]")
	public WebElement btn_ContactDedupPickRecord;

	/** The txt status. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='Status_Label']")
	public WebElement txt_Status;

	/** The txt KYC. */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[contains(@aria-labelledby,'KYC')]")
	public WebElement txt_KYC;

	/** The btn new relation ship. */
	@FindBy(xpath = "//*[@title='Relationship List Applet']//button[contains(@title,'New')]")
	public WebElement btn_NewRelationShip;

	/** The lnk new reation ship ID. */
	@FindBy(xpath = "//*[@title='Relationship List Applet']//*[contains(@name,'EPIC Consumer Id')]")
	public WebElement lnk_NewReationShipID;

	/** The lnk reation ship against. */
	@FindBy(xpath = "//*[@title='Relationship List Applet']//input[contains(@id,'EPIC_Relationship_Against')]")
	public WebElement lnk_ReationShipAgainst;

	/** The txt reation ship applet address search icon. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//input[contains(@aria-labelledby,'Address_Label')]/../span")
	public WebElement txt_ReationShipAppletAddressSearchIcon;

	/** The txt reation ship applet address. */
	@FindBy(xpath = "//*[@title='Relationship List Applet']//td[contains(@id,'Primary_Account_Street_Address')]")
	public WebElement txt_ReationShipAppletAddress;

	/** The btn realtion ship address OK button. */
	@FindBy(xpath = "//*[@title='Relationship Street Address List Applet']//*[text()='OK']")
	public WebElement btn_RealtionShipAddressOKButton;

	/** The txt realtion ship number. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[@aria-label='Relationship Id']")
	public WebElement txt_RealtionShipNumber;

	/** The txt realtion ship number against. */
	@FindBy(xpath = "//*[@title='Relationship List Applet']//td[contains(@id,'EPIC_Relationship_Against')]")
	public WebElement txt_RealtionShipNumberAgainst;

	/** The txt primary account address. */
	@FindBy(xpath = "//*[@title='Relationship List Applet']//td[contains(@id,'Primary_Account_Street_Address')]")
	public WebElement txt_PrimaryAccountAddress;

	/** The btn house hold new. */
	@FindBy(xpath = "//*[@title='Households List Applet']//button[@aria-label='Households:New']")
	public WebElement btn_HouseHoldNew;

	/** The checkbox house hold new row. */
	@FindBy(xpath = "//*[@title='Households List Applet']//table//span[contains(@class,'checkbox')]")
	public WebElement checkbox_HouseHoldNewRow;

	/** The checkbox contacts new row. */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//table//span[contains(@class,'checkbox')]")
	public WebElement checkbox_ContactsNewRow;

	/** The btn contact identities new plus. */
	@FindBy(xpath = "//*[@title='Contact Identities List Applet']//button[@title='Contact Identities:New']")
	public WebElement btn_ContactIdentitiesNewPlus;

	/** The txt relation to household. */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//td[contains(@id,'Relation_to_Household')]")
	public WebElement txt_Relation_to_Household;

	/** The txt EPI C contact category. */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//td[contains(@id,'EPIC_Contact_Category')]")
	public WebElement txt_EPIC_Contact_Category;

	/** The txt EPI C identity type. */
	@FindBy(xpath = "//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Type')]")
	public WebElement txt_EPIC_Identity_Type;

	/** The txt EPI C identity method. */
	@FindBy(xpath = "//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Method')]")
	public WebElement txt_EPIC_Identity_Method;

	/** The txt EPI C identity num. */
	@FindBy(xpath = "//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Num')]")
	public WebElement txt_EPIC_Identity_Num;

	/** The txt EPI C issue date. */
	@FindBy(xpath = "//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Issue_Date')]")
	public WebElement txt_EPIC_Issue_Date;

	/** The txt EPI C issue state. */
	@FindBy(xpath = "//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Issue_State')]")
	public WebElement txt_EPIC_Issue_State;

	/** The txt EPI C verif authority. */
	@FindBy(xpath = "//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Verif_Authority')]")
	public WebElement txt_EPIC_Verif_Authority;

	/** The dropdown realtion ship number scheme. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_Scheme_Type_Label')]")
	public WebElement dropdown_RealtionShipNumberScheme;

	/** The dropdown realtion ship number scheme type. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_Scheme_Selected_Label')]")
	public WebElement dropdown_RealtionShipNumberSchemeType;

	/** The dropdown realtion ship number consumer category type. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'Consumer_Category_Label')]")
	public WebElement dropdown_RealtionShipNumberConsumerCategoryType;

	/** The dropdown realtion ship number no of flats. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_No_of_Flats_Label')]")
	public WebElement dropdown_RealtionShipNumberNoOfFlats;

	/** The dropdown realtion ship number scheme sub type. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_Loan_For_Label')]")
	public WebElement dropdown_RealtionShipNumberSchemeSubType;

	/** The dropdown realtion ship EPI C UC M id label. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_UCM_Id_Label')]")
	public WebElement dropdown_RealtionShipEPIC_UCM_Id_Label;

	/** The dropdown realtion ship waitlist status. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-label,'Waitlist Status')]")
	public WebElement dropdown_RealtionShipWaitlistStatus;

	/** The btn relation ship products icon. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_Prod_Prom_Name_New_Label')]/../span")
	public WebElement btn_RelationShipProductsIcon;

	/** The dropdown pick promotion. */
	@FindBy(xpath = "//*[@title='Pick Promotion List Applet']//*[contains(@aria-labelledby,'PopupQueryCombobox_Label')]")
	public WebElement dropdown_PickPromotion;

	/** The dropdown pick promotion name. */
	@FindBy(xpath = "//*[@title='Pick Promotion List Applet']//*[contains(@aria-labelledby,'PopupQuerySrchspec_Label')]")
	public WebElement dropdown_PickPromotionName;

	/** The btn pick promotion search. */
	@FindBy(xpath = "(//*[@title='Pick Promotion List Applet']//*[@aria-label='Pick Promotion:Go'])[2]")
	public WebElement btn_PickPromotionSearch;

	/** The btn service area. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_Delivery_Area_Code_Label')]")
	public WebElement btn_ServiceArea;

	/** The pick icon service area. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-label,'Service Area')]//following-sibling::span")
	public WebElement pickIcon_ServiceArea;

	/** The pick icon service area. */
	@FindBy(xpath = "(//table[@summary='Service Area']//td[3])[2]")
	public WebElement txt_ServiceAreaSearchResultSummary;

	/** The btn service area OK button. */
	@FindBy(xpath = "//*[@title='Service Area List Applet']//button[contains(@aria-label,'Service Area:OK')]")
	public WebElement btn_ServiceAreaOK;

	/** The btn document new. */
	@FindBy(xpath = "//*[@title='Documents List Applet']//button[@aria-label='Documents:New']")
	public WebElement btn_DocumentNew;

	/** The btn OK promotion. */
	@FindBy(xpath = "//*[@title='Pick Promotion List Applet']//*[text()='OK']")
	public WebElement btn_OKPromotion;

	/** The txt wait list status resltion ship. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'EPIC_SL69_Status_Label')]")
	public WebElement txt_WaitListStatusResltionShip;

	/** The drop down order type documents. */
	@FindBy(xpath = "//*[@title='Documents List Applet']//*[contains(@aria-labelledby,'EPIC_TV_Type')]")
	public WebElement dropDown_OrderTypeDocuments;

	/** The drop down order sub type documents. */
	@FindBy(xpath = "//*[@title='Documents List Applet']//*[contains(@aria-labelledby,'EPIC_Sub_Type')]")
	public WebElement dropDown_OrderSubTypeDocuments;

	/** The drop down order sub type documents cell. */
	@FindBy(xpath = "//*[@title='Documents List Applet']//*[contains(@id,'EPIC_Sub_Type') and @role='gridcell']")
	public WebElement dropDown_OrderSubTypeDocumentsCell;

	/** The lnk document number drill down. */
	@FindBy(xpath = "//*[@title='Documents List Applet']//td/a")
	public WebElement lnk_DocumentNumberDrillDown;

	/** The txt NFRLPG stove. */
	@FindBy(xpath = "(//*[@title='Document Line items List Applet']//td[contains(.,'NFR - LPG Stove')]/following-sibling::td[1])[1]")
	public WebElement txt_NFRLPGStove;

	/** The txt city king LPG stove. */
	@FindBy(xpath = "//*[@title='Replace Product Pick Applet List Applet']//td[contains(.,'City King LPG Stove ROYAL')]")
	public WebElement txt_CityKingLPGStove;

	/** The btn OK. */
	@FindBy(xpath = "//*[@title='Replace Product Pick Applet List Applet']//*[text()='OK']")
	public WebElement btn_OK;

	/** The txt NFRLPG hose. */
	@FindBy(xpath = "(//*[@title='Document Line items List Applet']//td[contains(.,'NFR - LPG Hose')]/following-sibling::td[1])[1]")
	public WebElement txt_NFRLPGHose;

	/** The txt suraksha hose. */
	@FindBy(xpath = "//*[@title='Replace Product Pick Applet List Applet']//td[contains(.,'SURAKSHA LPG-Hose 1.2 MTR')]")
	public WebElement txt_SurakshaHose;

	/** The txt loan. */
	@FindBy(xpath = "//input[@aria-label='Loan Required For Refill']")
	public WebElement txt_Loan;

	/** The btn document line default. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//*[text()='Default']")
	public WebElement btn_DocumentLineDefault;

	/** The btn document line reprice all. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//*[text()='Reprice All']")
	public WebElement btn_DocumentLineRepriceAll;

	/** The btn document line LPGPR make. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//tr[contains(.,'LPG-PR')]//td[contains(@id,'Make')]")
	public WebElement btn_DocumentLineLPGPRMake;

	/** The btn document line NFR make. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//tr[contains(.,'NFR')]//td[contains(@id,'Make')]")
	public WebElement btn_DocumentLineNFRMake;

	/** The btn document line item delete. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//button[@data-display='Delete']")
	public WebElement btn_DocumentLineItemDelete;

	/** The txt document line DBC quantity. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//tr[contains(.,'14.2 Kg LPG Cylinder')]//td[contains(@id,'Quantity')]")
	public WebElement txt_DocumentLineDBCQuantity;

	/** The btn document line LPGPR year. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//tr[contains(.,'LPG-PR')]//td[contains(@id,'Year')]")
	public WebElement btn_DocumentLineLPGPRYear;

	/** The btn document line LPGPR month. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//tr[contains(.,'LPG-PR')]//td[contains(@id,'Month')]")
	public WebElement btn_DocumentLineLPGPRMonth;

	/** The btn document line LPGPR serial. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//tr[contains(.,'LPG-PR')]//td[contains(@id,'Serial')]")
	public WebElement btn_DocumentLineLPGPRSerial;

	/** The btn document line LPGPR serial DGCC. */
	@FindBy(xpath = "//*[@title='Document Line items List Applet']//tr[contains(.,'LPG-DGCC')]//td[contains(@id,'Serial')]")
	public WebElement btn_DocumentLineLPGPRSerialDGCC;

	/** The btn documents submit. */
	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[text()='Submit']")
	public WebElement btn_DocumentsSubmit;

	/** The btn documents invoice. */
	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[text()='Invoice']")
	public WebElement btn_DocumentsInvoice;

	/** The lnk invoice number. */
	@FindBy(xpath = "//*[@title='Invoices List Applet']//*[@name='Invoice Number']")
	public WebElement lnk_InvoiceNumber;

	/** The lnk invoice number status. */
	@FindBy(xpath = "//*[@title='Invoices List Applet']//td[contains(@id,'Status')]")
	public WebElement lnk_InvoiceNumberStatus;

	/** The txt order status. */
	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[@aria-labelledby='Status_Label']")
	public WebElement txt_OrderStatus;

	/** The txt order number. */
	@FindBy(xpath = "//*[@title='Line Items List Applet']//a[@name='Order Number']")
	public WebElement txt_OrderNumber;

	/** The lnk installation order number. */
	@FindBy(xpath = "//*[@title='Installation List Applet']//a[@name='EPIC Order Number']")
	public WebElement lnk_InstallationOrderNumber;


		/**********DAC FLAG CHECK*******/

	@FindBy(xpath = "//*[@title='Sales Order Form Applet']//button[contains(@aria-label,'Disable DAC')]")
	public WebElement btn_DisableDAC;

	@FindBy(xpath = "//*[@title='Sales Order Form Applet']//input[@aria-label='DAC Disable Reason']")
	public WebElement txtBox_DAC_DisableReason;


	/******************************/

	/** The btn installation create invoice. */
	@FindBy(xpath = "//*[@title='EPIC Refill Order Detail View']//button[contains(@aria-label,'Create Invoice')]")
	public WebElement btn_InstallationCreateInvoice;

	/** The txt installation delivery boy. */
	@FindBy(xpath = "//*[@title='EPIC Refill Order Detail View']//*[@aria-labelledby='Delivery_Boy_Label']")
	public WebElement txt_InstallationDelivery_Boy;

	/** The lnk invoice cash memo number. */
	@FindBy(xpath = "//*[@title='Invoice List Applet']//*[@name='Cash Memo Num']")
	public WebElement lnk_InvoiceCashMemoNumber;

	/** The lnk invoice status. */
	@FindBy(xpath = "//*[@title='Invoices Form Applet']//*[@aria-label='Status']")
	public WebElement lnk_InvoiceStatus;

	/** The txt sale order status. */
	@FindBy(xpath = "//*[@title='Sales Order Form Applet']//*[@aria-label='Order status' or @aria-label='Order Status']")
	public WebElement txt_SaleOrderStatus;

	/** The txt inventory transactions status. */
	@FindBy(xpath = "//*[@title='Inventory Transactions List Applet']//td[contains(@id,'Transaction_Type')]")
	public WebElement txt_InventoryTransactionsStatus;

	/** The txt payments transactions type. */
	@FindBy(xpath = "//*[@title='Payments List Applet']//td[contains(@id,'Transaction_Type')]")
	public WebElement txt_PaymentsTransactionsType;

	/** The txt relationship status. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[@aria-labelledby='EPIC_Consumer_Status_Label']")
	public WebElement txt_RelationshipStatus;

	/** The txt relationship type. LPG or FTL etc. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@aria-labelledby,'Relationship_Type')]")
	public WebElement txt_RelationshipType;

	/** The txt relationship search last name. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[contains(@name,'Last Name')]")
	public WebElement txt_RelationshipSearchLastName;

	/** The txt relationship relation ship number. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[@aria-labelledby='Consumer_Id_Label']")
	public WebElement txt_RelationshipRelationShipNumber;

	/** The txt relationship consumer type. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[@aria-labelledby='Consumer_Type_Label']")
	public WebElement txt_RelationshipConsumerType;

	/** The txt relationship sub status. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//*[@aria-labelledby='EPIC_Consumer_Sub_Status_Label']")
	public WebElement txt_RelationshipSubStatus;

	/** The txt inventory transactions issue. */
	@FindBy(xpath = "//table[@summary='Inventory Transactions']//*[text()='Issue']")
	public WebElement txt_InventoryTransactionsIssue;

	/** The txt inventory transactions receive. */
	@FindBy(xpath = "//table[@summary='Inventory Transactions']//*[text()='Receive']")
	public WebElement txt_InventoryTransactionsReceive;

	/** The txt payments settle. */
	@FindBy(xpath = "//table[@summary='Payments']//*[text()='Settle']")
	public WebElement txt_PaymentsSettle;

	/** The txt payments refund. */
	@FindBy(xpath = "//table[@summary='Payments']//*[text()='Refund']")
	public WebElement txt_PaymentsRefund;

	/** The txt payments refund Status. */
	@FindBy(xpath = "//*[@title='Payments List Applet']//td[contains(@id,'EPIC_Payment_Status') and @title='Paid']")
	public WebElement txt_PaymentsRefundStatus;

	/** The btn pyment profile add button. */
	@FindBy(xpath = "//*[@title='Payment Profile List Applet']//button[@title='Payment Profile:New']")
	public WebElement btn_PymentProfileAddButton;

	/** The btn IFSC button. */
	@FindBy(xpath = "//*[@title='Payment Profile List Applet']//td//input/../span")
	public WebElement btn_IFSCButton;

	/** The txt IFSC button. */
	@FindBy(xpath = "(//*[@title='Payment Profile List Applet']//td//input)[2]")
	public WebElement txt_IFSCButton;

	/** The btn IFSC bank number. */
	@FindBy(xpath = "//*[@title='Bank IFSC Code List Applet']//table[@summary='Bank IFSC Code']//tr[2]//td[2]")
	public WebElement btn_IFSCBankNumber;

	/** The btn OK button IFSC. */
	@FindBy(xpath = "//*[@title='Bank IFSC Code List Applet']//*[text()='OK']")
	public WebElement btn_OKButtonIFSC;

	/** The btn name as per bank. */
	@FindBy(xpath = "//*[@title='Payment Profile List Applet']//td[contains(@id,'EPIC_Name_As_Per_Bank')]")
	public WebElement btn_NameAsPerBank;

	/** The btn bank account number. */
	@FindBy(xpath = "//*[@title='Payment Profile List Applet']//td[contains(@id,'Bank_Acct_Id')]")
	public WebElement btn_BankAccountNumber;

	/** The btn account number. */
	@FindBy(xpath = "//*[@title='Payment Profile List Applet']//td[contains(@id,'EPIC_Bank_Account_Number')]")
	public WebElement btn_AccountNumber;

	/** The btn account type. */
	@FindBy(xpath = "//*[@title='Payment Profile List Applet']//td[contains(@id,'EPIC_Account_Type')]")
	public WebElement btn_AccountType;

//	Verification Points Update

	/** The txt payment status. */
@FindBy(xpath = "//*[@title='Payments List Applet']//td[contains(@id,'EPIC_Payment_Status') and @title='Paid']")
	public WebElement txt_PaymentStatus;

	/** The txt total due. */
	@FindBy(xpath = "//*[@title='Invoices Form Applet']//input[contains(@aria-labelledby,'Total_Due_Label')]")
	public WebElement txt_TotalDue;

	/** The txt district. */
	@FindBy(xpath = "//*[@title='Contact Addresses List Applet']//input[contains(@aria-label,'District')]")
	public WebElement txt_District;

	/** The txt invoice amount. */
	@FindBy(xpath = "//*[@title='Invoices Form Applet']//input[contains(@aria-label,'Invoice Amount')]")
	public WebElement txt_InvoiceAmount;

	/** The txt order total. */
	@FindBy(xpath = "//*[@title='Sales Order Form Applet']//input[contains(@aria-label,'Order Total')]")
	public WebElement txt_OrderTotal;

	/** The txt invoice amount installation. */
	@FindBy(xpath = "//*[@title='Invoices Form Applet']//input[contains(@aria-label,' Invoice Amount')]")
	public WebElement txt_InvoiceAmount_Installation;

	/** The txt invoice amount installation line. */
	@FindBy(xpath = "//*[@title='Invoice List Applet']//td[contains(@id,'Cash_Memo_Amt')]")
	public WebElement txt_InvoiceAmount_InstallationLine;

	/** The txt inventory transaction type installation 1. */
	@FindBy(xpath = "//*[@title='Inventory Transactions List Applet']//td[contains(@name,'Transaction_Type')]")
	public WebElement txt_InventoryTransactionType_Installation1;

	/** The txt inventory transaction qty installation. */
	@FindBy(xpath = "//*[@title='Inventory Transactions List Applet']//td[contains(@id,'Quantity')]")
	public WebElement txt_InventoryTransactionQty_Installation;

	/** The txt payments installation. */
	@FindBy(xpath = "//*[@title='Payments List Applet']//td[contains(@id,'Transaction_Amount')]")
	public WebElement txt_Payments_Installation;

	/** The txt products active. */
	@FindBy(xpath = "//*[@title='Products List Applet']//td[contains(@title,'Checked')]")
	public WebElement txt_Products_Active;

	/** The txt inventory transactions type documents. */
	@FindBy(xpath = "//*[@title='Inventory Transactions List Applet']//td[contains(@id,'Transaction_Type')]")
	public WebElement txt_InventoryTransactionsType_Documents;

	/** The CLDP button. */
	@FindBy(xpath = "//button[@name=\"s_2_1_4_0\"]")
	public WebElement CLDP_dedup;

	/** The CLDP button. */
	@FindBy(xpath = "//td[@id=\"1_s_3_l_Cash_Memo_Status\"]")
	public WebElement invoice_open;

	/** The CLDP button. */
	@FindBy(xpath = "//input[@id=\"1_Cash_Memo_Status\"]")
	public WebElement invoice_complete;


	/**
	 * Gets the search result promotion.
	 *
	 * @param promotion the promotion
	 * @return the search result promotion
	 */
	// ***************** TTV relationship document
	public WebElement get_SearchResultPromotion(String promotion) {
		return driver.findElement(
				By.xpath("//*[@title='Pick Promotion List Applet']//table//*[text()='" + promotion + "']"));
	}

	/**
	 * Gets the lower tab level.
	 *
	 * @param tabName the tab name
	 * @return the lower tab level
	 */
	public WebElement get_LowerTabLevel(String tabName) {
		return driver
				.findElement(By.xpath("//*[@title='Third Level View Bar']//*[contains(text(),'" + tabName + "')]"));
	}

	/**
	 * Gets the second tab level.
	 *
	 * @param tabName the tab name
	 * @return the second tab level
	 */
	public WebElement get_SecondTabLevel(String tabName) {
		return driver
				.findElement(By.xpath("//*[@title='Second Level View Bar']//*[contains(text(),'" + tabName + "')]"));
	}

	/**
	 * Gets the main tab level.
	 *
	 * @param tabName the tab name
	 * @return the main tab level
	 */
	public WebElement get_MainTabLevel(String tabName) {
		return driver
				.findElement(By.xpath("//*[@title='First Level View Bar']//*[contains(text(),'" + tabName + "')]"));
	}

	/**
	 * Gets the identities method row.
	 *
	 * @param identitiesMethod the identities method
	 * @return the identities method row
	 */
	public WebElement get_identitiesMethodRow(String identitiesMethod) {
		return driver.findElement(By.xpath("//*[@title='Contact Identities List Applet']//td[contains(text(),'"
				+ identitiesMethod + "')]/../td[2]"));
	}

	/**
	 * Gets the identities method highlight.
	 *
	 * @param identitiesMethod the identities method
	 * @return the identities method highlight
	 */
	public WebElement get_identitiesMethodHighlight(String identitiesMethod) {
		return driver.findElement(By.xpath(
				"//*[@title='Contact Identities List Applet']//td[contains(text(),'" + identitiesMethod + "')]/.."));
	}

	/**
	 * Checks if is tab display in tab list.
	 *
	 * @param tabName the tab name
	 */
	public void isTabDisplayInTabList(String tabName) {
		  String tabList = driver.findElement(By.xpath("//*[@title='Third Level View Bar']//select"))
                .getAttribute("innerText");
        if (!(tabList.contains(tabName))) {
            get_LowerTabLevel(tabName).click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
        } else {
            try {
                Select optiondropdown = new Select(
                        driver.findElement(By.xpath("//*[@title='Third Level View Bar']//select")));
                optiondropdown.selectByVisibleText(tabName);
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();
            } catch (Exception e) {
            }
        }
	}

	/**
	 * Gets the asset name and check active.
	 *
	 * @param productType the product type
	 * @return the asset name and check active
	 */
	public WebElement get_AssetNameAndCheckActive(String productType) {
		return driver.findElement(By.xpath("//*[@title='Assets List Applet']//td[text()='" + productType
				+ "']/following-sibling::td[text()='Active']"));
	}

	/**
	 * Checks if is tab display in main tab list.
	 *
	 * @param tabName the tab name
	 */
	public void isTabDisplayInMainTabList(String tabName) {
		java.util.List<WebElement> tablist = driver
				.findElements(By.xpath("//*[@title='First Level View Bar']//li[@role='tab']"));
		for (WebElement webElement : tablist) {
			if (webElement.getAttribute("textContent").equalsIgnoreCase(tabName)) {
				get_MainTabLevel(tabName).click();
			}
		}
		try {
			Select optiondropdown = new Select(
					driver.findElement(By.xpath("//*[@title='First Level View Bar']//select")));
			optiondropdown.selectByVisibleText(tabName);
		} catch (Exception e) {
		}
	}
}
