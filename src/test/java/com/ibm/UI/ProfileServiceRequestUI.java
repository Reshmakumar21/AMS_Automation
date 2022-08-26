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
 * The Class ProfileServiceRequestUI.
 */
public class ProfileServiceRequestUI extends BaseUIPage {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new profile service request UI.
	 *
	 * @param driver the driver
	 */
	public ProfileServiceRequestUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}




	/*COMMON WEBELEMENTS****************************************************/
	/*Profile SR Applet - Service Request List Applet*/

	/** The txt field for MDMUID under More Info Tab of Contacts */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='EPIC_MDM_UId_Label']")
	public WebElement txt_MDMUID;

	/** The btn new service request plus. */
	@FindBy(xpath = "//*[@title='Service Request List Applet']//button[contains(@title,'New')]")
	public WebElement btn_NewServiceRequestPlus;

	/** The txt transaction type. */
	@FindBy(xpath = "(//*[@title='Service Request List Applet']//tr[2]//td)[9]")
	public WebElement txt_TransactionType;

	/** The txt transaction sub type. */
	@FindBy(xpath = "(//*[@title='Service Request List Applet']//tr[2]//td)[10]")
	public WebElement txt_TransactionSubType;

	/** The lnk SR number. */
	@FindBy(xpath = "//*[@title='Service Request List Applet']//td//a")
	public WebElement lnk_SRNumber;

	/** The txt SR status. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Staus_Label']")
	public WebElement txt_SRStatus;

	/** The txt SR status. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-label='Status']")
	public WebElement txt_ProfileSRStatus;

	/** The txt SR status. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[contains(@name, 'Relationship Id')]")
	public WebElement txt_RelationshipID;

	/** The btn attachments new. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//*[text()='New']/..")
	public WebElement btn_AttachmentsNew;

	/** The btn submit SR.
	 @FindBy(xpath = "//*[text()='Submit SR']/..")
	 public WebElement btn_SubmitSR;*/

	/** The btn submit SR. */
//	@FindBy(xpath = "//button[contains(@aria-label, 'Submit SR')]//*[text()='Submit SR']")
	@FindBy(xpath = "//button[contains(@aria-label, 'Submit SR')]")
	public WebElement btn_SubmitSR;

	/** The TextBox Remarks. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//textarea[@aria-label='Remarks']")
	public WebElement txtArea_SR_Remarks;

	/** The First Name Consumer details. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//input[contains(@aria-labelledby,'First')]")
	public WebElement txtBox_FirstName;

	/** The Last Name Consumer details. */
	@FindBy(xpath = "//*[@title='Relationship Form Applet']//input[contains(@aria-labelledby,'First')]")
	public WebElement txtBox_LastName;

	/** The StatusReasonCode BPC. */
	@FindBy(xpath = "(//*[@title='OMC Response List Applet']//*[contains(@id,'StatusReasonCode')])[3]")
	public WebElement txt_StatusReasonCodeBPC;

	/** The StatusReasonCode BPC. */
	@FindBy(xpath = "(//*[@title='OMC Response List Applet']//*[contains(@id,'StatusReasonCode')])[4]")
	public WebElement txt_StatusReasonCodeHPC;

	/*To get various tabs from lowerTab view*/
	public WebElement get_LowerTabLevel(String tabName) {
		return driver.findElement(By.xpath("//*[@title='Third Level View Bar']//a[contains(text(),'" + tabName + "')]"));
	}

	/*To add new attachment in Profile_SR*/
	@FindBy(xpath = "//*[@title='Service Request Activities']//button[@aria-label='Attachments:New']")
	public WebElement btn_NewAttachmentProfileSR;

	/** The textBox Identity Type*/
	@FindBy(xpath = "//*[@title='Service Request Activities']//input[contains(@aria-labelledby,'EPIC_Identity_Type')]")
	public WebElement txtBox_AttachmentIdentityType;

	/**
	 * Gets the identities method row.
	 *
	 * @param identitiesMethod the identities method
	 * @return the identities method row
	 */
	public WebElement get_identitiesMethodRow(String identitiesMethod) {
		return driver.findElement(By.xpath("//*[@title='Service Request Activities']//td[contains(text(),'"
				+ identitiesMethod + "')]/../td[2]"));
	}


	/*BANK PROFILE SR****************************************************/

	/** The txt IFSC code. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_IFSC_Code_Label']")
	public WebElement txt_IFSCCode;

	/** The txt account number. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Account_No_Masked_Label']")
	public WebElement txt_AccountNumber;

	/** The txt account number reenter. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Account_No._Label']")
	public WebElement txt_AccountNumberReenter;

	/** The txt account name. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Name_As_Per_Bank_Label']")
	public WebElement txt_AccountName;

	/** The txt attachments identity type. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//input[contains(@aria-labelledby,'EPIC_Identity_Type')]")
	public WebElement txt_AttachmentsIdentityType;

	/** The txt attachments identity method. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//input[contains(@aria-labelledby,'EPIC_Identity_Method')]")
	public WebElement txt_AttachmentsIdentityMethod;

	/** The txt attachments identity number. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//input[contains(@aria-labelledby,'EPIC_Identity_Num')]")
	public WebElement txt_AttachmentsIdentityNumber;
	
	/** The btn File upload. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//button[contains(@aria-label, 'FileUpload')]")
	public WebElement btn_FileUpload;

	/** The btn choose file. */
	@FindBy(xpath = "//*[@title='File Upload Form Applet']//input[@type='file']")
	public WebElement btn_ChooseFile;

	/** The btn UploadFile. */
	@FindBy(xpath = "//*[@title='File Upload Form Applet']//button[contains(@aria-label,'Upload File')]")
	public WebElement btn_UploadFile;

	/** The txt IFSC code search icon. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_IFSC_Code_Label']/../span")
	public WebElement txt_IFSCCodeSearchIcon;

	/** The txt IFSC code search result. */
	@FindBy(xpath = "//*[@title='Bank IFSC Code List Applet']//*[contains(text(),'CITI')]")
	public WebElement txt_IFSCCodeSearchResult;

	/** The btn IFSC code OK. */
	@FindBy(xpath = "//*[@title='Bank IFSC Code List Applet']//*[contains(text(),'OK')]")
	public WebElement btn_IFSCCodeOK;





	/*AADHAR SEEDING UI****************************************************/

	/** The txt previous Aadhar Number. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='Previous_Aadhar_Label']")
	public WebElement txt_PreviousAadhar;

	/** The txt New values Aadhar Number. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='Aadhar_Number_Label']")
	public WebElement txt_NewAadhar;

	/** The txt New values Aadhar Number. DeSeeding*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[contains(@aria-labelledby,'Adhar_Number_Label')]")
	public WebElement txt_ReEnterNewAadhar;

	/** The txt Aadhar Refrence Number. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[contains(@aria-labelledby,'Aadhaar_Old_Ref_Num_Label')]")
	public WebElement txt_AadharRefrenceNumber;

	/** The txt New values Aadhar Number. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='Remarks_Label']")
	public WebElement txtbox_Remarks;





	/*NAME CHANGE UI****************************************************/

	/** The txt salutation. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Salutation_Label']")
	public WebElement txt_Salutation;

	/** The txt First Name. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_First_Name_Label']")
	public WebElement txt_FirstName;

	/** The txt Middle Name. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Middle_Name_Label']")
	public WebElement txt_MiddleName;

	/** The txt Last Name. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Last_Name_Label']")
	public WebElement txt_LastName;

	/** The btn plus attachment. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//input[contains(@name, 'EPIC_Identity_Type')]")
	public WebElement txt_IdentityType;

	/** The btn plus attachment. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//input[contains(@name, 'EPIC_Identity_Method')]")
	public WebElement txt_IdentityMethod;

	/** The btn plus attachment. */
	@FindBy(xpath = "//*[@title='Attachments List Applet']//input[contains(@name, 'EPIC_Identity_Num')]")
	public WebElement txt_IdentityNumber;





	/*ADDRESS CHANGE UI****************************************************/

	/** The txt address line 1 */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Address_Line_1_Label']")
	public WebElement txt_AddressLine1;

	/** The txt address line 2 */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Address_Line2_Label']")
	public WebElement txt_AddressLine2;

	/** The txt address line 3 */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Address_Line_3_Label']")
	public WebElement txt_AddressLine3;

	/** The txt landmark */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Customer_Area_Label']")
	public WebElement txt_LandMark;

	/** The txt city */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_City_Label']")
	public WebElement txt_City;

	/** The txt Urban/ Rural */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Urban_Rural_Label']")
	public WebElement txt_UrbanRural;

	/** The txt previous city */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_City_Old_Label']")
	public WebElement txt_previousValueCity;



	/*PHONE NUMBER CHANGE UI****************************************************/

	/** The txt phone number*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Primary_Mobile_Number_Label']")
	public WebElement txt_InputPhoneNumber;

	/** The btn Generate otp*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//button[contains(@aria-label,'Generate OTP')]")
	public WebElement btn_GenerateOTP;

	/** The txt phone number*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[contains(@aria-label,'Verify OTP')]")
	public WebElement txt_VerifyOTP;

	/** The btn verify otp*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//button[contains(@aria-label,'Verify OTP')]")
	public WebElement btn_VerifyOTP;




	/*EMAIL CHANGE UI****************************************************/

	/** The txt phone number*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Email_Address_Label']")
	public WebElement txt_NewEmailID;





	/*PIN CODE CHANGE UI****************************************************/

	/** The txt new pin code*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Pincode_Old_Label']")
	public WebElement txt_PreviousValuePinCode;

	/** The txt new pin code*/
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Pincode_Label']")
	public WebElement txt_NewValuePinCode;




	/*FO APPROVAL UI****************************************************/

	/** The txt New values Aadhar Number. */
	@FindBy(xpath = "//input[@title='User ID']")
	public WebElement txt_UserID;

	/** The txt New values Aadhar Number. */
	@FindBy(xpath = "//input[@title='Password']")
	public WebElement txt_Password;

	/**
	 * Get the SR on FO homepage
	 *
	 * @param SRNumber on home page
	 * @return webelement
	 */
	public WebElement get_nameInboxItem(String SRNumber) {
		return driver.findElement(By.xpath("//table[@summary='My Inbox Items']//*[contains(@title, '" + SRNumber + "')]/a"));
	}

	/** The txt value of Profile SR status FO. */
	@FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//input[@aria-labelledby='EPIC_Staus_Label']")
	public WebElement txt_SRStatusFO;

	/**
	 * To click the Approve or Reject Button
	 *
	 * @param btnApproveReject
	 * @return webelement button
	 */
	public WebElement get_btnApproveReject(String btnApproveReject) {
	    return driver.findElement(By.xpath("//*[@title='Approval History List Applet']//button[contains(@aria-label,'"+btnApproveReject+"')]"));
	}



	/*MDM UI****************************************************/

	/** The tab Contacts MDM homepage UI */
	@FindBy(xpath = "//*[@title='First Level View Bar']//*[text()='Contacts']")
	public WebElement tab_Contacts;

	/** The link for all contacts under contact tab of MDM */
	@FindBy(xpath = "//*[@title='Frequently Viewed Contacts List Applet']//*[text()='All Contacts']")
	public WebElement lnk_AllContacts;

	/** The link for all contacts under contact tab of MDM */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//*[@aria-label='Contacts:Query']")
	public WebElement btn_queryContact;

	/** The link for all contacts under contact tab of MDM */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//button[@title='Contacts:Cancel']//preceding-sibling::button[1]")
	public WebElement btn_SearchContactsQuery;

	/** The link for all contacts under contact tab of MDM */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//td[contains(@id, 'EPIC_UCM_Id')]")
	public WebElement txtBox_UCMiD;

	/** The link for all contacts under contact tab of MDM */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//td[contains(@id, 'EPIC_UCM_Id')]")
	public WebElement txtBox_InputUCMiD;

	/** The link for last name under contacts MDM */
	@FindBy(xpath = "//*[@title='Contacts List Applet']//*[contains(@id,'Last_Name')]/a")
	public WebElement lnk_LastName;

	/** The txt phone under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='Alternate_Phone_Label']")
	public WebElement txt_MDMPhone;

	/** The txt email under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='AlternateEmail_Label']")
	public WebElement txt_MDMEmail;

	/** The txt zipcode under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='Personal_Postal_Code_Label']")
	public WebElement txt_MDMZipCode;

	/** The txt city under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='Personal_City_Label']")
	public WebElement txt_MDMCity;

	/** The txt address line 2 under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='Personal_Street_Address_2_Label']")
	public WebElement txt_MDMAddressLine2;

	/** The txt address line 1 under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='Personal_Address_Label']")
	public WebElement txt_MDMAddressLine1;

	/** The txt first name under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='FirstName_Label']")
	public WebElement txt_MDMFirstName;

	/** The txt last name under contacts MDM */
	@FindBy(xpath = "//*[@title='Contact Form Applet']//*[@aria-labelledby='LastName_Label']")
	public WebElement txt_MDMLastName;

	/** The btn Identities query search */
	@FindBy(xpath = "(//*[@title='Identities List Applet']//button[contains(@aria-label,'Identities:Query')])[1]")
	public WebElement btn_QueryIdentities;

	/** The txtBox Identity number under first row of Identities Applet */
	@FindBy(xpath = "//*[@title='Identities List Applet']//tr[@id='1']//td[contains(@id,'Identity_Number')]")
	public WebElement txtBox_IdentityNumber;

	/** The btn Identities Go query search */
	@FindBy(xpath = "(//*[@title='Identities List Applet']//button[contains(@aria-label,'Identities:Go')])[1]")
	public WebElement btn_GoQueryIdentities;

	/** The txtBox Identity Status under first row of Identities Applet */
	@FindBy(xpath = "//*[@title='Identities List Applet']//tr[@id='1']//td[contains(@id,'Identity_Status')]")
	public WebElement txtBox_IdentityStatus;



	/*SR Grievance UI****************************************************/

	/*Sub-description*Common web elements under grievance service request UI*/
	/** The button to add raise Grievance Service Requests*/
	@FindBy(xpath = "//button[contains(@title, 'New') and contains(@aria-label, 'New')]")
	public WebElement btn_RaiseNewGrievancePlus;

	/*Button for query service request*/
	@FindBy(xpath = "//*[@title='Service Request List Applet']//button[@aria-label='Service Request:Query']")
	public WebElement btn_QueryServiceRequest;

	/** The button to add raise Grievance Service Requests*/
	@FindBy(xpath = "//*[@title='Service Request List Applet']//input[contains(@aria-labelledby,'EPIC_Consumer_Id_Label')]")
	public WebElement txtBox_ConsumerId;

	/** The button to submit new Grievance Service Requests*/
	@FindBy(xpath = "//*[@title='Service Request List Applet']//button[contains(@aria-label, 'Submit')]")
	public WebElement btn_SubmitNewGrievance;

	/** The ReSolve button used by distributor*/
	@FindBy(xpath = "//*[@title='Service Request Form Applet']//button[contains(@aria-label, 'Resolve')]")
	public WebElement btn_Resolve;

	public WebElement getNewSRHyperLink(String SRNumber){
		return driver.findElement(By.xpath("//*[@title='Service Request List Applet']//td[@title='"+SRNumber+"']/a"));
	}


	/** To Store SR Grievance Number*/
	@FindBy(xpath = "//*[@title='Service Request List Applet']//input[contains(@aria-labelledby, 'EPIC_SR_Number_Label')]")
	public WebElement txt_SRGrievanceNumber;

	/** To Store SR Grievance Status*/
	@FindBy(xpath = "//*[@title='Service Request Form Applet']//input[contains(@aria-labelledby, 'Sub_Status_Label')]")
	public WebElement txt_SRGrievanceStatus;

	/** To Store SR Grievance Sub Status*/
	@FindBy(xpath = "//*[@title='Service Request Form Applet']//input[contains(@aria-label, 'Substatus')]")
	public WebElement txt_SRGrievanceSubStatus;

	/** To Store SR Grievance Resolved Date*/
	@FindBy(xpath = "//*[@title='Service Request Form Applet']//input[contains(@aria-label, 'Resolved Date')]")
	public WebElement txt_SRGrievanceResolvedDate;



	/*Sub-description*Pick Consumer Pop Up applet*/
	/** The button to input consumer id*/
	@FindBy(xpath = "//*[@title='Pick Consumer List Applet']//input[@aria-labelledby='PopupQuerySrchspec_Label']")
	public WebElement txtBox_InputConsumerId;

	/** The button to search consumer id*/
	@FindBy(xpath = "(//*[@title='Pick Consumer List Applet']//button[@aria-label='Pick Consumer:Go'])[2]")
	public WebElement btn_SearchConsumerID;

	/** The OK button to accept the consumer id search result*/
	@FindBy(xpath = "//*[@title='Pick Consumer List Applet']//button[@aria-label='Pick Consumer:OK']")
	public WebElement btn_OKConsumerIDResult;

	/*Sub-description*Consumer details under grievance service request UI*/
	/** The text box to input consumer mobile number*/
	@FindBy(xpath = "//*[@title='Service Request List Applet']//input[contains(@aria-labelledby,'Mobile_Number_Label')]")
	public WebElement txtBox_MobileNumber;



	/*Sub-description*SR details under grievance service request UI*/
	/** The button to add SR Category*/
	@FindBy(xpath = "//*[@title='Service Request List Applet']//input[contains(@aria-labelledby,'Category_Label')]//following-sibling::span")
	public WebElement img_SRCategory;

	/** The text area for grievance description*/
	@FindBy(xpath = "//*[@title='Service Request List Applet']//textarea[contains(@aria-labelledby,'Description')]")
	public WebElement txtArea_GrievanceDescription;

	/** The text area for Resolution Remark*/
	@FindBy(xpath = "//*[@title='Service Request Form Applet']//textarea[contains(@aria-labelledby,'Agent_Comments_Label')]")
	public WebElement txtArea_ResolutionRemark;



	/*Sub-description*Service Request Categories Pop Up applet*/
	/** The button to add Service Request Categories*/
	@FindBy(xpath = "//*[@title-preserved='Service Request Categories']//button[contains(@aria-label, ':New')]")
	public WebElement btn_ServiceReqCategoryPlus;

	/** The Input for Category*/
	@FindBy(xpath = "//*[@title='Service Request Categories List Applet']//input[contains(@aria-labelledby, 'EPIC_Category')]")
	public WebElement txtBox_Category;

	/** The Input for Sub Category*/
	@FindBy(xpath = "//*[@title='Service Request Categories List Applet']//input[contains(@aria-labelledby, 'EPIC_Sub_Category')]")
	public WebElement txtBox_SubCategory;

	/** The OK button for Service Request Category*/
	@FindBy(xpath = "//*[@title='Service Request Categories List Applet']//button[contains(@aria-label, 'Service Request Categories:OK')]")
	public WebElement btn_OKServiceReqCategory;



	/*Sub-description*FO User Grievance*/
	/** The RESOLVE button used by FO*/
	@FindBy(xpath = "//*[@title='Service Request Form Applet']//button[contains(@aria-label,'Resolve')]")
	public WebElement btn_ResolveFO;
}
