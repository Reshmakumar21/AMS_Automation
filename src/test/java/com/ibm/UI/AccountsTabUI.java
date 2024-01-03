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

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class AccountsTabUI.
 */
public class AccountsTabUI extends BaseUIPage {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new accounts tab UI.
	 *
	 * @param driver the driver
	 */
	public AccountsTabUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	@FindBy(xpath = "//*[@title='Account Form Applet']//button[contains(.,'New')]")
	public WebElement btn_createNewAccount;

	@FindBy(xpath = "//*[@title='Account Form Applet']//*[@aria-labelledby='EPIC_Name_Label']")
	public WebElement input_FirstNameAccount;

	@FindBy(xpath = "//*[@title='Account Form Applet']//*[@aria-labelledby='DeDup_Status_Label']")
	public WebElement input_DeDupStatusLabel;

	@FindBy(xpath = "//*[@title='Site List Applet']//td[contains(@id,'_DeDup_Status')]")
	public WebElement txt_SiteDeDupStatus;

	@FindBy(xpath = "//*[@title='Account Form Applet']//*[@aria-labelledby='EPIC_Mobile_Number_Label']")
	public WebElement input_MobileNumberAccount;

	@FindBy(xpath = "//*[@title='Account Form Applet']//*[text()='Account DeDup']")
	public WebElement btn_AccountDedup;

	@FindBy(xpath = "//*[@title='Account Form Applet']//*[contains(@aria-labelledby,'EPIC_Identities_Label')]/..//span")
	public WebElement txtBox_IdentitiesSearchButton;

	@FindBy(xpath = "//*[@title='Account Attachment List Applet']//button[@data-display='New']")
	public WebElement btn_IdentitiesNewButton;

	@FindBy(xpath = "//*[@title='Account Attachment List Applet']//input[@name='EPIC_Identity_Type']")
	public WebElement txt_IdentitiesIdentityType;

	@FindBy(xpath = "//*[@title='Account Attachment List Applet']//input[contains(@id,'EPIC_Identity_Method')]")
	public WebElement txt_IdentitiesIdentityMethod;

	@FindBy(xpath = "//*[@title='Account Attachment List Applet']//input[contains(@id,'EPIC_Identity_Num')]")
	public WebElement txt_IdentitiesIdentityNumber;

	@FindBy(xpath = "//*[@title='Account Attachment List Applet']//button[contains(.,'Ok')]")
	public WebElement btn_IdentitiesOK;

	// Site creation
	@FindBy(xpath = "//*[@title='Site List Applet']//*[contains(@title,'New')]")
	public WebElement btn_SiteNew;

	@FindBy(xpath = "(//*[@title='Site List Applet']//td[contains(@id,'Name')])[1]")
	public WebElement btn_SiteName;

	@FindBy(xpath = "//*[@title='Site List Applet']//td[contains(@id,'Street_Address')]")
	public WebElement btn_StreetAddress;

	@FindBy(xpath = "//*[@title='Third Level View Bar']//*[text()='Relationships']")
	public WebElement tab_Relationships;

	@FindBy(xpath = "//*[@title='Third Level View Bar']//*[text()='Payment Profiles']")
	public WebElement tab_PaymentProfiles;

	@FindBy(xpath = "//*[@title='Site List Applet']//td[contains(@id,'EPIC_Payment_Profile_Name')]")
	public WebElement btn_PaymentProfileName;

	@FindBy(xpath = "//*[@title='Pick Payment Profile List Applet']//*[text()='OK']")
	public WebElement btn_OKButtonPickPromotion;

	@FindBy(xpath = "//*[@title='Pick Payment Profile List Applet']//*[contains(text(),'****') and contains(text(),'XXXX')]")
	public WebElement btn_BankNumberMasking;

	@FindBy(xpath = "//*[@title='Site List Applet']//button[contains(@title,'Site DeDup')]")
	public WebElement btn_SiteDeDup;

	@FindBy(xpath = "//*[@title='Fourth Level View Bar']//a[text()='Relationships']")
	public WebElement tab_RealtionShips;

	// RelationShip creation
	@FindBy(xpath = "//*[@title='Relationship List Applet']//*[contains(@title,'New')]")
	public WebElement btn_RelationShipNew;
	// RelationShip UCMiD
	@FindBy(xpath = "(//*[@title='Relationship List Applet']//td[contains(@id,'EPIC_Relationship_Id')])[1]")
	public WebElement txtBox_RelationShipUCMiD;
	// RelationShip Type
	@FindBy(xpath = "(//*[@title='Relationship List Applet']//td[contains(@id,'_EPIC_Relationship_Type')])[1]")
	public WebElement txtBox_RelationshipType;
	// Customer Segment
	@FindBy(xpath = "(//*[@title='Relationship List Applet']//td[contains(@id,'_Segment')])[1]")
	public WebElement txtBox_CustomerSegment;
	// RelationShip Type
	@FindBy(xpath = "(//*[@title='Relationship List Applet']//td[contains(@id,'EPIC_Consumer_Id')])[1]/a")
	public WebElement txtBox_RelationShipId;
	// CheckBox FTL Reseller Flag on RelationShip applet
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//input[contains(@aria-labelledby,'Retailor_Flag')]")
	public WebElement chkBox_FTLResellerFlag;

	public WebElement get_accountNameLinkFromAccountList(String accountName) {
		return driver.findElement(By.xpath("//*[@title='Accounts List Applet']//a[text()='" + accountName + "']"));
	}

	/*
	 * Document creation.
	 * */

	// Document number
	@FindBy(xpath = "//*[@title='Documents Form Applet']//input[@aria-labelledby='Order_Number_Label']")
	public WebElement txtBox_DocumentNumber;

	// AM approval status
	@FindBy(xpath = "//*[@title='Documents Form Applet']//*[@aria-labelledby='EPIC_AM_Approval_Status_Label']")
	public WebElement txtBox_ApprovalStatusAreaManager;

}
