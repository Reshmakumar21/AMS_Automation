/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.NFR_UI;
import com.ibm.Utilities.AadharGenie;
import com.ibm.Utilities.LoggerWriter;


/**
 * The Class ContactTabAction.
 */
public class ContactTabAction extends BaseAction {

	/**
	 * The first name global.
	 */
	public String firstNameGlobal;
	
	public Actions interaction;
	/**
	 * The contact tab.
	 */
	protected ContactTabUI contactTab;
	/**
	 * The home page.
	 */
	protected HomePageUI homePage;
	/**
	 * The nfr page.
	 */
	protected NFR_UI nfrPage;
	/**
	 * The driver.
	 */
	WebDriver driver;

	/** The rel num. */
	/* Class Instances */
	String relNum;
	/**
	 * The invoice status.
	 */
	/* FTL & NFR Orders ******************************************************/
	String orderStatus, invoiceStatus;

	/**
	 * Instantiates a new contact tab action.
	 *
	 * @param driver the driver
	 */
	public ContactTabAction(WebDriver driver) {
		super(driver);
		contactTab = new ContactTabUI(driver);
		homePage = new HomePageUI(driver);
		nfrPage = new NFR_UI(driver);
		this.driver = driver;
	}

	/**
	 * Navigate to contact tab.
	 */
	public void naviagteToContactTab() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();

		contactTab.get_MainTabLevel("Contacts").click();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Creates the new contact.
	 */
	public void createNewContact() {
		contactTab.btn_createNewContact.click();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.dropDown_Salutation.isDisplayed();
	}

	/**
	 * Enter new customer information.
	 *
	 * @param salutation the salutation
	 * @param firstName  the first name
	 * @param lastName   the last name
	 * @param gender     the gender
	 * @param dob        the dob
	 */
	public void enterNewCustomerInformation(String salutation, String firstName, String lastName, String gender,
			String dob) {
		contactTab.dropDown_Salutation.click();
		contactTab.dropDown_Salutation.sendKeys(salutation);
		contactTab.dropDown_Salutation.sendKeys(Keys.TAB);
		contactTab.txtBox_First.click();
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss"); Date
		 * date = new Date();
		 */
		// String FirstName = firstName + dateFormat.format(date);
		String FirstName = firstName + printRandomString(6).toLowerCase();
		contactTab.txtBox_First.sendKeys(FirstName);
		System.out.println("First Name : " + FirstName);
		firstNameGlobal = FirstName;
		LoggerWriter.logger.log(Status.PASS, "FirstName : " + FirstName);
		contactTab.txtBox_LastName.click();
		contactTab.txtBox_LastName.sendKeys(lastName);
		contactTab.dropDown_Gender.click();
		contactTab.dropDown_Gender.sendKeys(gender);
		contactTab.dropDown_Gender.sendKeys(Keys.TAB);
		contactTab.txtBox_DOB.click();
		contactTab.txtBox_DOB.sendKeys(dob);
		contactTab.txtBox_DOB.sendKeys(Keys.TAB);
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstNameGlobal;
	}

	/**
	 * Adds the new address.
	 *
	 * @param line1   the line 1
	 * @param line2   the line 2
	 * @param line3   the line 3
	 * @param area    the area
	 * @param pinCode the pin code
	 * @param city    the city
	 * @param locale  the locale
	 */
	// Address
	public void addNewAddress(String line1, String line2, String line3, String area, String pinCode, String city,
			String locale) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		expWait.waitForDomToLoad();
		contactTab.icon_searchAddress.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_AddAdressAppletAddButton.click();
		contactTab.txtBox_Address.click();
		dateFormat = new SimpleDateFormat("mm_ss");
		contactTab.txtBox_Address.sendKeys(line1 + dateFormat.format(date));
		contactTab.txtBox_AddressLin2.click();
		contactTab.txtBox_AddressLin2.sendKeys(line2 + dateFormat.format(date));
		contactTab.txtBox_AddressLin3.click();
		contactTab.txtBox_AddressLin3.sendKeys(line3 + dateFormat.format(date));
		contactTab.txtBox_AddressArea.click();
		contactTab.txtBox_AddressArea.sendKeys(area);
		contactTab.txtBox_PinCode.click();
		contactTab.txtBox_PinCode.sendKeys(pinCode);
		contactTab.txtBox_PinCode.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txtBox_City.click();
		contactTab.txtBox_City.sendKeys(city);
		contactTab.txtBox_Rural.click();
		contactTab.txtBox_Rural.sendKeys(locale);
		contactTab.txtBox_Rural.sendKeys(Keys.TAB);
		contactTab.chkBox_PrimaryAddress.click();
		contactTab.txtBox_SaveAddress.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		contactTab.txtBox_OKButoonAddNewAddress.click();
	}

	/**
	 * Adds the new address.
	 *
	 * @param line1   the line 1
	 * @param line2   the line 2
	 * @param line3   the line 3
	 * @param area    the area
	 * @param pinCode the pin code
	 * @param localBody the local body
	 * @param city    the city
	 * @param locale  the locale
	 */
	// Address
	public void addNewAddress(String line1, String line2, String line3, String area, String pinCode, String localBody, String city,
			String locale) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		expWait.waitForDomToLoad();
		contactTab.icon_searchAddress.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_AddAdressAppletAddButton.click();
		contactTab.txtBox_Address.click();
		dateFormat = new SimpleDateFormat("mm_ss");
		contactTab.txtBox_Address.sendKeys(line1 + dateFormat.format(date));
		contactTab.txtBox_AddressLin2.click();
		contactTab.txtBox_AddressLin2.sendKeys(line2 + dateFormat.format(date));
		contactTab.txtBox_AddressLin3.click();
		contactTab.txtBox_AddressLin3.sendKeys(line3 + dateFormat.format(date));
		contactTab.txtBox_AddressArea.click();
		contactTab.txtBox_AddressArea.sendKeys(area);
		contactTab.txtBox_PinCode.click();
		contactTab.txtBox_PinCode.sendKeys(pinCode);
		contactTab.txtBox_PinCode.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txtBox_LocalBody.click();
		contactTab.txtBox_LocalBody.sendKeys(localBody);
		contactTab.txtBox_LocalBody.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txtBox_City.click();
		contactTab.txtBox_City.sendKeys(city);
		contactTab.txtBox_Rural.click();
		contactTab.txtBox_Rural.sendKeys(locale);
		contactTab.txtBox_Rural.sendKeys(Keys.TAB);
		contactTab.chkBox_PrimaryAddress.click();
		contactTab.txtBox_SaveAddress.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		contactTab.txtBox_OKButoonAddNewAddress.click();
	}

	/**
	 * Adds the identities for new customer.
	 *
	 * @param identityType   the identity type
	 * @param identityMethod the identity method
	 * @param identityNumber the identity number
	 */
	public void addIdentitiesForNewCustomer(String identityType, String identityMethod, String identityNumber) {
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss"); Date
		 * date = new Date();
		 */
		contactTab.txtBox_IdentitiesSearchButton.isDisplayed();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		contactTab.txtBox_IdentitiesSearchButton.click();
		contactTab.btn_IdentitiesNewButton.click();
		contactTab.txt_IdentitiesIdentityType.click();
		contactTab.txt_IdentitiesIdentityType.sendKeys("POA-POI");
		contactTab.txt_IdentitiesIdentityType.sendKeys(Keys.TAB);
		contactTab.txt_IdentitiesIdentityMethod.click();
		contactTab.txt_IdentitiesIdentityMethod.sendKeys("Driving Licence");
		contactTab.txt_IdentitiesIdentityMethod.sendKeys(Keys.TAB);
		// dateFormat = new SimpleDateFormat("mmss");
		contactTab.txt_IdentitiesIdentityNumber.click();
		contactTab.txt_IdentitiesIdentityNumber.sendKeys(identityNumber + printRandomString(6));
		contactTab.txt_IdentitiesIdentityNumber.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		contactTab.btn_IdentitiesOK.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Adds the identities for new customer aadhar via Aadhar Genie.
	 *
	 * @param identityType the identity type
	 */
	public void addIdentitiesForNewCustomerAadhar(String identityType) {
		contactTab.txtBox_IdentitiesSearchButton.isDisplayed();
		expWait.waitForDomToLoad();
		contactTab.txtBox_IdentitiesSearchButton.click();
		contactTab.btn_IdentitiesNewButton.click();
		contactTab.txt_IdentitiesIdentityType.click();
		contactTab.txt_IdentitiesIdentityType.sendKeys("POA-POI");
		contactTab.txt_IdentitiesIdentityType.sendKeys(Keys.TAB);
		contactTab.txt_IdentitiesIdentityMethod.click();
		contactTab.txt_IdentitiesIdentityMethod.sendKeys("Aadhaar(UID)");
		String aadharNumberGen = "";
		aadharNumberGen = new AadharGenie().genAadhar();
		System.out.println("aadharNumberGen : " + aadharNumberGen);
		contactTab.txt_IdentitiesIdentityNumberArea.click();
		contactTab.txt_IdentitiesIdentityNumberArea.findElement(By.tagName("input")).click();
		contactTab.txt_IdentitiesIdentityNumberArea.findElement(By.tagName("input")).sendKeys(aadharNumberGen);
		contactTab.txt_IdentitiesIdentityNumberArea.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		LoggerWriter.logger.log(Status.INFO, "Aadhar Number : " + aadharNumberGen);
		contactTab.btn_IdentitiesOK.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Adds the identities for new customer aadhar.
	 *
	 * @param identityType   the identity type
	 * @param identityMethod the identity method
	 */
	public void addIdentitiesForNewCustomerAadhar(String identityType, String identityMethod) {
		contactTab.txtBox_IdentitiesSearchButton.isDisplayed();
		expWait.waitForDomToLoad();
		contactTab.txtBox_IdentitiesSearchButton.click();
		contactTab.btn_IdentitiesNewButton.click();
		contactTab.txt_IdentitiesIdentityType.click();
		contactTab.txt_IdentitiesIdentityType.sendKeys("POA-POI");
		contactTab.txt_IdentitiesIdentityType.sendKeys(Keys.TAB);
		contactTab.txt_IdentitiesIdentityMethod.click();
		contactTab.txt_IdentitiesIdentityMethod.sendKeys("Aadhaar(UID)");
		String aadharNumberGen = "";
		for (int i = 0; i < 5; i++) {
			aadharNumberGen = CheckAadharApp(("file:///" + System.getProperty("user.dir").replace("\\", "/")
					+ "/Test.Resources/drivers" + "/CheckDigits.html"));
			System.out.println("aadharNumberGen : " + aadharNumberGen);
			contactTab.txt_IdentitiesIdentityNumberArea.click();
			contactTab.txt_IdentitiesIdentityNumberArea.findElement(By.tagName("input")).click();
			contactTab.txt_IdentitiesIdentityNumberArea.findElement(By.tagName("input")).sendKeys(aadharNumberGen);
			contactTab.txt_IdentitiesIdentityNumberArea.findElement(By.tagName("input")).sendKeys(Keys.TAB);
			contactTab.waitLong(5);
			try {
				Alert alt = driver.switchTo().alert();
				System.out.println(alt.getText());
				alt.accept();
			} catch (Exception e) {
				LoggerWriter.logger.log(Status.PASS, "Aadhar Number : " + aadharNumberGen);
				break;
			}
		}
		contactTab.btn_IdentitiesOK.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Check aadhar app.
	 *
	 * @param URL the url
	 * @return the string
	 */
	public String CheckAadharApp(String URL) {
		System.setProperty("webdriver.chrome.driver", "./Test.Resources/drivers/chromedriver.exe");
		WebDriver baseDriver = new ChromeDriver();
		baseDriver.get(URL);
		String randNumber = "";
		String status = "";
		try {
			for (int j = 0; j < 5; j++) {
				Random rand = new Random();
				for (int i = 0; i < 5; i++) {
					randNumber = randNumber.concat("" + rand.nextInt(100));
				}
				JavascriptExecutor js = (JavascriptExecutor) baseDriver;
				System.out.println(baseDriver.findElement(By.name("out")).getAttribute("value"));
				randNumber = "9" + randNumber;
				contactTab.waitLong(1);
				js.executeScript("document.getElementsByName('num')[0].value='" + randNumber + "';");
				contactTab.waitLong(1);
				js.executeScript("compute();");
				contactTab.waitLong(1);
				js.executeScript("check();");
				contactTab.waitLong(1);
				status = baseDriver.findElement(By.name("out")).getAttribute("value");
				if (status.equals("OK")) {
					randNumber = status = baseDriver.findElement(By.name("num")).getAttribute("value");
					return randNumber;
				} else {
					js.executeScript("document.getElementsByName('num')[0].value='';");
					randNumber = "";
					status = "";
				}
			}
		} catch (Exception e) {
		} finally {
			baseDriver.close();
		}
		return null;
	}

	/**
	 * Enter BPL for new customer.
	 *
	 * @param bpl the bpl
	 */
	public void enterBPLForNewCustomer(String bpl) {
		contactTab.dropdown_BPL.click();
		contactTab.dropdown_BPL.sendKeys(bpl);
		contactTab.dropdown_BPL.sendKeys(Keys.TAB);

		performSave();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();

		performAltEnter();

		contactTab.dropdown_BPL.click();
		contactTab.dropdown_BPL.sendKeys(bpl);
		contactTab.dropdown_BPL.sendKeys(Keys.TAB);
		performSave();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
	}

	/**
	 * Enter Phone for new customer.
	 */
	public void enterPhoneForNewCustomer(String num) {
		expWait.waitForDomToLoad();
		contactTab.icon_addPhone.click();
		contactTab.btn_PhoneNewButton.click();
		contactTab.txt_PhoneNum.click();
		contactTab.txt_PhoneNum.sendKeys(num);
		contactTab.txt_PhoneNum.sendKeys(Keys.TAB);
		contactTab.btn_PhoneGo.click();
		contactTab.btn_GenerateOTP.click();
		// wait 2 seconds for the OTP to be generated
		expWait.waitLong(5);
		String dbQuery = "select TEXT from Spicedigital_DB_UPD where MOBILENUMBER='" + num + "' ORDER BY CREATEDATETIME desc";
		String OTP = connectSiebelDBToExtractData(dbQuery);
		OTP = OTP.substring(38, 42);
		System.out.println("OTP is " + OTP);
		contactTab.box_VerifyOTP.click();
		contactTab.txt_VerifyOTP.sendKeys(OTP);
		contactTab.txt_VerifyOTP.sendKeys(Keys.TAB);
		contactTab.btn_VerifyOTP.click();

		expWait.waitLong(6);
		contactTab.btn_PhoneOk.click();
		expWait.waitLong(5);
	}
//		contactTab.txt_IdentitiesIdentityMethod.sendKeys("Driving Licence");
//		contactTab.txt_IdentitiesIdentityMethod.sendKeys(Keys.TAB);
//		// dateFormat = new SimpleDateFormat("mmss");
//		contactTab.txt_IdentitiesIdentityNumber.click();
//		contactTab.txt_IdentitiesIdentityNumber.sendKeys(identityNumber + printRandomString(6));
//		contactTab.txt_IdentitiesIdentityNumber.sendKeys(Keys.TAB);
//		expWait.waitForDomToLoad();
//		contactTab.btn_IdentitiesOK.click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//	}

	/**
	 * Perform contact dedup.
	 */
	public void performContactDedup() {
		contactTab.btn_ContactDedup.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_ContactDedupPickRecord.isDisplayed();
		Assert.assertTrue(!(contactTab.txt_Status.getAttribute("value").toString().isEmpty()), "Depup Fail");
		Assert.assertTrue(!(contactTab.txt_KYC.getAttribute("value").isEmpty()), "Depup Fail KYC Level blank");
		System.out.println(Float.parseFloat(contactTab.txt_KYC.getAttribute("value")) > 5);
		Assert.assertTrue(Float.parseFloat(contactTab.txt_KYC.getAttribute("value")) > 5, "KYC status lower than 5 ");
	}

	/**
	 * Navigate to general connection summary.
	 */
	public void navigateToGeneralConnectionSummary() {
		contactTab.isTabDisplayInTabList("General Connection Summary");
		contactTab.waitLong(4);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Navigate to ujjwala connection summary.
	 */
	public void navigateToUjjwalaConnectionSummary() {
		contactTab.isTabDisplayInTabList("Ujjwala Connection Summary");
		contactTab.waitLong(4);
	}

	/**
	 * Navigate to payment profile.
	 */
	public void navigateToPaymentProfile() {
		contactTab.waitLong(4);
		contactTab.isTabDisplayInTabList("Payment Profile");
		contactTab.waitLong(4);
	}

	/**
	 * Adds the payment bank details.
	 */
	public void addPaymentBankDetails() {
		contactTab.btn_PymentProfileAddButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_IFSCButton.isDisplayed();
		contactTab.txt_IFSCButton.sendKeys("BARB0FIVEPO");
		contactTab.txt_IFSCButton.sendKeys(Keys.TAB);
		contactTab.txt_IFSCButton.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_NameAsPerBank.click();
		contactTab.btn_NameAsPerBank.findElement(By.tagName("input")).click();
		contactTab.btn_NameAsPerBank.findElement(By.tagName("input")).sendKeys("TestAuto");
		contactTab.btn_BankAccountNumber.click();
		contactTab.btn_BankAccountNumber.findElement(By.tagName("input")).click();
		Random rand = new Random();
		String account = "";
		for (int i = 0; i < 4; i++) {
			account = account.concat("" + rand.nextInt(1000));
		}
		System.out.println("Account Number Enter : " + account);
		contactTab.btn_BankAccountNumber.findElement(By.tagName("input")).sendKeys(account);
		contactTab.btn_AccountType.click();
		contactTab.btn_AccountType.findElement(By.tagName("input")).click();
		contactTab.btn_AccountType.findElement(By.tagName("input")).sendKeys("Savings");
		contactTab.btn_AccountType.findElement(By.tagName("input")).sendKeys(Keys.TAB);
	}

	/**
	 * Navigate to document after relation ship tab.
	 */
	public void navigateToDocumentAfterRelationShipTab() {
		contactTab.isTabDisplayInTabList("Documents");
	}

	/**
	 * Navigate to profile SR contact page.
	 */
	public void navigateToProfileSRContactPage() {
		contactTab.isTabDisplayInTabList("Profile SR");
	}

	/**
	 * Creates the new relationship ship.
	 *
	 * @param environment the environment
	 * @return the string
	 */
	public String createNewRelationShip(String environment) {
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		navigateToGeneralConnectionSummary();
		contactTab.btn_NewRelationShip.click();
		contactTab.lnk_ReationShipAgainst.isDisplayed();
		// no need
//		contactTab.lnk_ReationShipAgainst.sendKeys(Keys.TAB);

		contactTab.txt_ReationShipAppletAddress.click();
		contactTab.txt_ReationShipAppletAddress.findElement(By.tagName("input")).click();
		contactTab.txt_ReationShipAppletAddress.findElement(By.tagName("span")).click();

		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
//		contactTab.txt_ReationShipAppletAddressSearchIcon.click();
		contactTab.btn_RealtionShipAddressOKButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_RealtionShipNumberAgainst.isDisplayed();
		contactTab.txt_RealtionShipNumberAgainst.click();
		contactTab.txt_RealtionShipNumberAgainst.findElement(By.tagName("input")).click();
		contactTab.txt_RealtionShipNumberAgainst.findElement(By.tagName("input")).sendKeys(Keys.TAB);

		// Rel_Id for conversion
		String relID_BeforeSaving = contactTab.lnk_NewReationShipID.getAttribute("textContent");
		System.out.println("relID_BeforeSaving: " + relID_BeforeSaving);

		performSave();

		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		try {
			contactTab.lnk_NewReationShipID.isDisplayed();
		} catch (Exception e) {
			navigateToGeneralConnectionSummary();
		}
		try {
			contactTab.lnk_NewReationShipID.click();
		} catch (Exception e) {
			navigateToGeneralConnectionSummary();
			contactTab.lnk_NewReationShipID.click();
		}
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		contactTab.txt_RealtionShipNumber.isDisplayed();
		relNum = contactTab.txt_RealtionShipNumber.getAttribute("value");
		System.out.println("RealtionShip Number : " + relNum);
		LoggerWriter.logger.log(Status.PASS, "RelationShipNumber : " + relNum);
		return relNum;
	}

	/**
	 * Relation ship drill down and set scheme.
	 *
	 * @param scheme        the scheme
	 * @param schemeType    the scheme type
	 * @param promotionName the promotion name
	 * @param serviceArea   the service area
	 */
	public void relationShipDrillDownAndSetScheme(String scheme, String schemeType, String promotionName,
			String serviceArea) {
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		contactTab.dropdown_RealtionShipNumberScheme.click();
		contactTab.waitLong(5);
		contactTab.dropdown_RealtionShipNumberScheme.sendKeys(scheme);
		contactTab.dropdown_RealtionShipNumberScheme.sendKeys(Keys.TAB);
		contactTab.dropdown_RealtionShipNumberSchemeType.click();
		contactTab.dropdown_RealtionShipNumberSchemeType.sendKeys(schemeType);
		contactTab.dropdown_RealtionShipNumberSchemeType.sendKeys(Keys.TAB);
		contactTab.btn_RelationShipProductsIcon.click();
		contactTab.dropdown_PickPromotion.click();
		expWait.waitForDomToLoad();
		contactTab.btn_PickPromotionSearch.click();
		expWait.waitForDomToLoad();
		contactTab.get_SearchResultPromotion(promotionName).click();
		contactTab.btn_OKPromotion.isEnabled();
		contactTab.btn_OKPromotion.click();
		expWait.waitForDomToLoad();

		// to select service area
		serviceAreaSelection(serviceArea);
	}

	/**
	 * Select Service Area.
	 *
	 * @param serviceArea the service area
	 */
	public void serviceAreaSelection(String serviceArea) {
		/*
		 * contactTab.btn_ServiceArea.click();
		 * contactTab.btn_ServiceArea.sendKeys(serviceArea);
		 * contactTab.btn_ServiceArea.sendKeys(Keys.TAB);
		 */

		contactTab.pickIcon_ServiceArea.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_ServiceAreaSearchResultSummary.click();
		expWait.waitForDomToLoad();
		contactTab.btn_ServiceAreaOK.click();
		expWait.waitForDomToLoad();
	}

	/**
	 * Navigate to document and create document.
	 *
	 * @param type    the type
	 * @param subType the sub type
	 */
//	public void navigateToDocumentAndCreateDocument(String type, String subType) {
//		expWait.waitForDomToLoad();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		if (contactTab.txt_WaitListStatusResltionShip.getAttribute("value").equalsIgnoreCase("Waitlisted")) {
//			// update waitList Status to released
//			connectDBToUpdateWaitListStatus(relNum);
//			// Click waitList textBox
//			contactTab.txt_WaitListStatusResltionShip.click();
//			performAltEnter();
//			expWait.waitForDomToLoad();
//			expWait.waitForHomePageSipperToDisapper();
//		}
//
//		{
//			contactTab.isTabDisplayInTabList("Documents");
//			expWait.waitForHomePageSipperToDisapper();
//			expWait.waitForDomToLoad();
//			try {
//				contactTab.btn_DocumentNew.isDisplayed();
//			} catch (Exception e) {
//				contactTab.isTabDisplayInTabList("Documents");
//				expWait.waitForDomToLoad();
//				expWait.waitForHomePageSipperToDisapper();
//			}
//		}
//
//		System.out.println("WaitListStatus: " + contactTab.txt_WaitListStatusResltionShip.getAttribute("value"));
//		contactTab.btn_DocumentNew.click();
//		try {
//			contactTab.dropDown_OrderTypeDocuments.click();
//		} catch (Exception e) {
//			contactTab.btn_DocumentNew.click();
//			contactTab.dropDown_OrderTypeDocuments.click();
//		}
//		expWait.waitForDomToLoad();
//		contactTab.dropDown_OrderTypeDocuments.sendKeys(type);
//		expWait.waitForDomToLoad();
//		contactTab.dropDown_OrderTypeDocuments.sendKeys(Keys.TAB);
//		contactTab.dropDown_OrderSubTypeDocumentsCell.click();
//		expWait.waitForDomToLoad();
//		contactTab.dropDown_OrderSubTypeDocuments.sendKeys(subType);
//		expWait.waitLong(2);
//		//contactTab.dropDown_OrderSubTypeDocuments.click();
//
//		driver.findElement(By.xpath("//li[text()='New Connection']")).click();
//		//TODO - Type New connection
//		/*if(subType.equalsIgnoreCase("New connection")) {
//			contactTab.dropDown_OrderSubTypeDocuments.findElement(By.tagName("input")).click();
//
//			try {
//				Robot robot = new Robot();
//
//				robot.keyPress(KeyEvent.VK_RIGHT);
//				robot.keyPress(KeyEvent.VK_BACK_SPACE);
//				robot.keyPress(KeyEvent.VK_N);
//				expWait.waitForDomToLoad();
//				contactTab.dropDown_OrderSubTypeDocuments.sendKeys(Keys.ENTER);
//				expWait.waitForDomToLoad();
//
//			} catch (Exception e) {
//
//			}
//		}*/
//
//		contactTab.dropDown_OrderSubTypeDocuments.sendKeys(Keys.TAB);
//		System.out.println("random seed number : " + contactTab.lnk_DocumentNumberDrillDown.getText());
//
//		performSave();
//		expWait.waitForHomePageSipperToDisapper();
//		expWait.waitForDomToLoad();
//		expWait.waitLong(30);
//
//		contactTab.lnk_DocumentNumberDrillDown.isDisplayed();
//		contactTab.lnk_DocumentNumberDrillDown.click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//	}

	public void navigateToDocumentAndCreateDocument(String type, String subType) {
		contactTab.CLDP_dedup.click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		// Added ctrl+s
		performSave();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
//		if (contactTab.txt_WaitListStatusResltionShip.getAttribute("value").equalsIgnoreCase("Waitlisted")) {
//			// update waitList Status to released
//			connectDBToUpdateWaitListStatus(relNum);
//			// Click waitList textBox
//			contactTab.txt_WaitListStatusResltionShip.click();
//			performAltEnter();
//			expWait.waitForDomToLoad();
//			expWait.waitForHomePageSipperToDisapper();
//		}

		{
			contactTab.isTabDisplayInTabList("Documents");
			expWait.waitForHomePageSipperToDisapper();
			expWait.waitForDomToLoad();
			try {
				contactTab.btn_DocumentNew.isDisplayed();
			} catch (Exception e) {
				contactTab.isTabDisplayInTabList("Documents");
				expWait.waitForDomToLoad();
				expWait.waitForHomePageSipperToDisapper();
			}
		}

		System.out.println("WaitListStatus: " + contactTab.txt_WaitListStatusResltionShip.getAttribute("value"));
		contactTab.btn_DocumentNew.click();
		try {
			contactTab.dropDown_OrderTypeDocuments.click();
		} catch (Exception e) {
			contactTab.btn_DocumentNew.click();
			contactTab.dropDown_OrderTypeDocuments.click();
		}
		expWait.waitForDomToLoad();
		contactTab.dropDown_OrderTypeDocuments.sendKeys(type);
		expWait.waitForDomToLoad();
		contactTab.dropDown_OrderTypeDocuments.sendKeys(Keys.TAB);
		contactTab.dropDown_OrderSubTypeDocumentsCell.click();
		expWait.waitForDomToLoad();
		contactTab.dropDown_OrderSubTypeDocuments.sendKeys(subType);
		expWait.waitForDomToLoad();
		contactTab.dropDown_OrderSubTypeDocuments.sendKeys(Keys.TAB);
		expWait.waitLong(2);
		//contactTab.dropDown_OrderSubTypeDocuments.click();

//		driver.findElement(By.xpath("//li[text()='New Connection']")).click();
		//TODO - Type New connection
		/*if(subType.equalsIgnoreCase("New connection")) {
			contactTab.dropDown_OrderSubTypeDocuments.findElement(By.tagName("input")).click();

			try {
				Robot robot = new Robot();

				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyPress(KeyEvent.VK_N);
				expWait.waitForDomToLoad();
				contactTab.dropDown_OrderSubTypeDocuments.sendKeys(Keys.ENTER);
				expWait.waitForDomToLoad();

			} catch (Exception e) {

			}
		}*/

		contactTab.dropDown_OrderSubTypeDocuments.sendKeys(Keys.TAB);
		System.out.println("random seed number : " + contactTab.lnk_DocumentNumberDrillDown.getText());

		performSave();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		expWait.waitLong(10);		// changed 30 to 10

		contactTab.lnk_DocumentNumberDrillDown.isDisplayed();
		contactTab.lnk_DocumentNumberDrillDown.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Created line items.
	 *
	 * @param consumerType the consumer type
	 */
	public void createdLineItems(String consumerType) {
		contactTab.btn_DocumentLineDefault.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_DocumentLineRepriceAll.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();

		// TODO New Change in submit

//		try {
//			contactTab.btn_DocumentLineNFRMake.click();
//			contactTab.btn_DocumentLineItemDelete.click();
//			expWait.waitLong(5);
//			Alert simpleAlert = driver.switchTo().alert();
//			System.out.println(simpleAlert.getText());
//			simpleAlert.accept();
//		} catch (Exception e) {
//			System.out.println("************ : btn_DocumentLineNFRMake No line diaply : Alert not displayed");
//		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
//		*************************************

		contactTab.btn_DocumentLineLPGPRMake.click();
		expWait.waitForDomToLoad();
		contactTab.btn_DocumentLineLPGPRMake.click();
		contactTab.btn_DocumentLineLPGPRMake.findElement(By.tagName("input")).sendKeys("testMake");
		contactTab.btn_DocumentLineLPGPRMake.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRYear.click();
		contactTab.btn_DocumentLineLPGPRYear.findElement(By.tagName("input")).sendKeys("2019");
		contactTab.btn_DocumentLineLPGPRYear.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRMonth.click();
		contactTab.btn_DocumentLineLPGPRMonth.findElement(By.tagName("input")).sendKeys("12");
		contactTab.btn_DocumentLineLPGPRMonth.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRSerial.click();
		contactTab.btn_DocumentLineLPGPRSerial.findElement(By.tagName("input")).sendKeys("3456789AD");
		contactTab.btn_DocumentLineLPGPRSerial.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRSerialDGCC.click();
		contactTab.btn_DocumentLineLPGPRSerialDGCC.findElement(By.tagName("input")).sendKeys("3456789AJ");
		contactTab.btn_DocumentLineLPGPRSerialDGCC.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		if (consumerType.equalsIgnoreCase("DBC")) {
			contactTab.txt_DocumentLineDBCQuantity.click();
			contactTab.txt_DocumentLineDBCQuantity.findElement(By.tagName("input")).clear();
			contactTab.txt_DocumentLineDBCQuantity.findElement(By.tagName("input")).sendKeys("2");
			contactTab.txt_DocumentLineDBCQuantity.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
	}

	/**
	 * Submit document.
	 */
	public void submitDocument() {
		contactTab.btn_DocumentsSubmit.click();
		// accept alert
		alertVerificationAndAcceptAlert(20);

		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForHomePageSipperToDisapper();
		if (contactTab.txt_OrderStatus.getAttribute("value").equalsIgnoreCase("Open")) {
			performRefresh();
		}
		System.out.println(contactTab.txt_OrderStatus.getAttribute("value"));
		Assert.assertTrue(contactTab.txt_OrderStatus.getAttribute("value").equalsIgnoreCase("Submitted"));
	}

	/**
	 * Invoice document.
	 */
	public void invoiceDocument() {
		contactTab.btn_DocumentsInvoice.isDisplayed();
		expWait.waitForDomToLoad();

//		performRefresh();
//		expWait.waitForHomePageSipperToDisapper();
//		expWait.waitForDomToLoad();

		contactTab.btn_DocumentsInvoice.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
//		System.out.println(contactTab.txt_OrderStatus.getAttribute("value"));
//		Assert.assertTrue(contactTab.txt_OrderStatus.getAttribute("value").equalsIgnoreCase("Invoiced"));
//		contactTab.lnk_InvoiceNumber.isDisplayed();
//		System.out.println("Invoice Number : " + contactTab.lnk_InvoiceNumber.getText());

//		performRefresh();
//		expWait.waitForHomePageSipperToDisapper();
//		expWait.waitForDomToLoad();

		contactTab.lnk_InvoiceNumberStatus.click();
		contactTab.lnk_InvoiceNumberStatus.findElement(By.tagName("input")).sendKeys("Completed");
		contactTab.lnk_InvoiceNumberStatus.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		expWait.waitLong(5);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		try {
			interaction  = new Actions(driver);
			interaction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
		performRefresh();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();

		//already invoice tab is selected
//		try {
//			contactTab.get_LowerTabLevel("Invoice").click();
//		} catch (Exception e) {
//			performRefresh();
//			expWait.waitForHomePageSipperToDisapper();
//			contactTab.get_LowerTabLevel("Invoice").click();
//		}

//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		expWait.waitForDomToLoad();



//		try {
//			contactTab.lnk_InvoiceNumber.click();
//		} catch (Exception e) {
//			System.out.println("Retry click on Invoice Number After marking complete status.");
//			contactTab.lnk_InvoiceNumber.click();
//		}
//		expWait.waitLong(5);
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//



//		________________________________
//		contactTab.txt_OrderNumber.isDisplayed();
//
//		int amount = (int) Float.parseFloat(
//				(contactTab.txt_InvoiceAmount.getAttribute("value").replaceAll(",", "")).replaceAll("Rs.", ""));
//		System.out.println("amount :" + amount);
//
//		Assert.assertTrue(amount > 0);
//
//		contactTab.get_LowerTabLevel("Payments").click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		contactTab.txt_PaymentStatus.isDisplayed();
//		if (contactTab.txt_PaymentStatus.getAttribute("title").equalsIgnoreCase("Paid")) {
//			amount = (int) Float.parseFloat(
//					(contactTab.txt_TotalDue.getAttribute("value").replaceAll(",", "")).replaceAll("Rs.", ""));
//			Assert.assertTrue(amount == 0);
////			Assert.assertTrue(contactTab.txt_TotalDue.getAttribute("value").equalsIgnoreCase("Rs.0.00"));
//		} else {
//			amount = (int) Float.parseFloat(
//					(contactTab.txt_TotalDue.getAttribute("value").replaceAll(",", "")).replaceAll("Rs.", ""));
//			Assert.assertFalse((amount == 0));
////			Assert.assertTrue(!(contactTab.txt_TotalDue.getAttribute("value").equals("Rs.0.00")));
//		}
//		contactTab.get_LowerTabLevel("Line Items").click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//
////		________________________________

//		contactTab.txt_OrderNumber.click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();

	}

	/**
	 * Verify installation.
	 */
	public void verifyInstallation() {
		contactTab.get_LowerTabLevel("Installation").click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.lnk_InstallationOrderNumber.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println("Delivery boy : " + contactTab.txt_InstallationDelivery_Boy.getAttribute("value"));

		// Delivery Boy selection
//		homePage.btn_DeliveryBoy.click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		homePage.txt_DeliveryBoySearchResultFromSummary.click();
//		homePage.txt_DeliveryBoySearchResultOKButton.click();
//
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();

		try {
			if (contactTab.btn_InstallationCreateInvoice.getAttribute("disabled").equalsIgnoreCase("true")) {
				performSave();
				driver.navigate().refresh();
				expWait.waitForDomToLoad();
				expWait.waitForHomePageSipperToDisapper();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		contactTab.btn_InstallationCreateInvoice.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();

		performRefresh();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();

		// DAC flag verification.
	    flagVerifyDAC();

	    // no need already invoice tab will be opened
		// Invoice tab.
//		contactTab.get_LowerTabLevel("Invoice").click();
//		expWait.waitForHomePageSipperToDisapper();
//		expWait.waitForDomToLoad();

	    // stopped at disable dac

		// Invoice number hyperlink.
//		System.out.println(contactTab.lnk_InvoiceCashMemoNumber.getText());
//		contactTab.lnk_InvoiceCashMemoNumber.click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		contactTab.lnk_InvoiceStatus.click();
//		expWait.waitForDomToLoad();
//		// js to remove the previous value of status for Invoice cash memo
//		String name = contactTab.lnk_InvoiceStatus.getAttribute("name");
//		executeJs("document.getElementsByName(\"" + name + "\")[0].value=\"\";");
//		expWait.waitForDomToLoad();
//
//		contactTab.lnk_InvoiceStatus.sendKeys("Completed");
//		contactTab.lnk_InvoiceStatus.sendKeys(Keys.TAB);
//		expWait.waitLong(5);
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();

		// TODO: also verify in complete test

//		try {
//			contactTab.lnk_InvoiceCashMemoNumber.click();
//			contactTab.txt_OrderNumber.click();
//		} catch (Exception e) {
//			System.out.println("Retry click on Order Number After marking complete status.");
//			contactTab.txt_OrderNumber.click();
//		}
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		System.out.println(contactTab.txt_SaleOrderStatus.getAttribute("value"));
//		contactTab.get_LowerTabLevel("Inventory Transactions").click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		System.out.println(contactTab.txt_InventoryTransactionsStatus.getAttribute("title"));
//		Assert.assertTrue(contactTab.txt_InventoryTransactionsStatus.getAttribute("title").equalsIgnoreCase("Issue"));
//		contactTab.get_LowerTabLevel("Payments").click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		System.out.println(contactTab.txt_PaymentsTransactionsType.getAttribute("title"));
//		Assert.assertTrue(contactTab.txt_PaymentsTransactionsType.getAttribute("title").equalsIgnoreCase("Settle"));
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
////		New Verification to be Test
//		System.out.println(contactTab.txt_OrderTotal.getAttribute("value"));
//		contactTab.get_LowerTabLevel("Invoice").click();
//		expWait.waitForDomToLoad();
//		expWait.waitForHomePageSipperToDisapper();
//		int amount = (int) Float.parseFloat(
//				(contactTab.txt_OrderTotal.getAttribute("value").replaceAll(",", "")).replaceAll("Rs.", ""));
//		Assert.assertFalse((amount == 0));
////		Assert.assertTrue(!contactTab.txt_OrderTotal.getAttribute("value").equals("Rs.0.00"));
//		System.out.println(contactTab.txt_InvoiceAmount_InstallationLine.getAttribute("title"));
//		amount = (int) Float
//				.parseFloat((contactTab.txt_InvoiceAmount_InstallationLine.getAttribute("title").replaceAll(",", ""))
//						.replaceAll("Rs.", ""));
//		Assert.assertFalse((amount == 0));
////		Assert.assertTrue(!contactTab.txt_InvoiceAmount_InstallationLine.getAttribute("title").equals("Rs.0.00"));
	}

    /**
     * DAC Flag Verification.
     */
    public void flagVerifyDAC() {
        //DAC flag verification.
        if (contactTab.btn_DisableDAC.isEnabled()) {
            contactTab.txtBox_DAC_DisableReason.click();
            expWait.waitForDomToLoad();
            contactTab.txtBox_DAC_DisableReason.sendKeys("Network Issue");
            expWait.waitForDomToLoad();
            contactTab.btn_DisableDAC.click();

            alertVerificationAndAcceptAlert(15);

            expWait.waitForHomePageSipperToDisapper();
            //expWait.waitForDomToLoad();
        }
        contactTab.invoice_open.click();
        contactTab.invoice_complete.sendKeys("Completed", Keys.TAB);
        expWait.waitForDomToLoad();
    }

	/**
	 * Verify pricing.
	 *
	 * @param consumerType the consumer type
	 */
	public void verifyPricing(String consumerType) {
		contactTab.get_LowerTabLevel("Inventory Transactions").click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();

		if (consumerType.equalsIgnoreCase("SBC")) {
			Assert.assertTrue(contactTab.txt_InventoryTransactionQty_Installation.getAttribute("title").equals("1"));
		}

		if (consumerType.equalsIgnoreCase("DBC")) {
			Assert.assertTrue(contactTab.txt_InventoryTransactionQty_Installation.getAttribute("title").equals("2"));
		}

		System.out.println(contactTab.txt_InventoryTransactionQty_Installation.getAttribute("title"));
	}

	/**
	 * Verify relation ship status.
	 *
	 * @param relNumber the RelationShip number
	 */
	public void verifyRelationShipStatus(String relNumber) {
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		for (int i = 0; i < 20; i++) {
			if (contactTab.txt_RelationshipRelationShipNumber.getAttribute("value").equals(relNumber)) {
				break;
			} else {
				expWait.waitLong((int) 1.25);
			}
		}
		for (int i = 0; i <= 5; i++) {
			if (!(contactTab.txt_RelationshipStatus.getAttribute("value").equalsIgnoreCase("ACTIVE"))) {
				performAltEnter();
				expWait.waitForHomePageSipperToDisapper();
				expWait.waitForDomToLoad();
			}
		}
		System.out.println("RelationshipStatus: " + contactTab.txt_RelationshipStatus.getAttribute("value"));
		System.out.println("RelationshipSubStatus: " + contactTab.txt_RelationshipSubStatus.getAttribute("value"));
		Assert.assertTrue(contactTab.txt_RelationshipStatus.getAttribute("value").equalsIgnoreCase("ACTIVE"));
		Assert.assertTrue(contactTab.txt_RelationshipSubStatus.getAttribute("value").equalsIgnoreCase("ACTIVE"));
	}

	/**
	 * Verify consumer type.
	 *
	 * @param consumerType the consumer type
	 */
	public void verifyConsumerType(String consumerType) {
		if (consumerType.equalsIgnoreCase("SBC")) {
			System.out.println("Consumer Type : " + contactTab.txt_RelationshipConsumerType.getAttribute("value"));
			Assert.assertTrue(contactTab.txt_RelationshipConsumerType.getAttribute("value")
					.equalsIgnoreCase("Single Bottle Connection"));
		}
		if (consumerType.equalsIgnoreCase("DBC")) {
			System.out.println("Consumer Type : " + contactTab.txt_RelationshipConsumerType.getAttribute("value"));
			Assert.assertTrue(contactTab.txt_RelationshipConsumerType.getAttribute("value")
					.equalsIgnoreCase("Double Bottle Connection"));
		}
	}

	/**
	 * After relation ship search click on last name.
	 */
	public void afterRelationShipSearchClickOnLastName() {
		contactTab.txt_RelationshipSearchLastName.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_ContactDedup.isDisplayed();
	}

	/**
	 * Verify invertory transaction.
	 */
	public void verifyInvertoryTransaction() {
		contactTab.get_LowerTabLevel("Inventory Transactions").click();
		Assert.assertTrue(contactTab.txt_InventoryTransactionsIssue.isDisplayed());
		Assert.assertTrue(contactTab.txt_InventoryTransactionsReceive.isDisplayed());
	}

	/**
	 * Verify payments tab.
	 */
	public void verifyPaymentsTab() {
		contactTab.get_LowerTabLevel("Payments").click();
		Assert.assertTrue(contactTab.txt_PaymentsSettle.isDisplayed());
		Assert.assertTrue(contactTab.txt_SaleOrderStatus.getAttribute("value").equals("Completed"));
	}

	/**
	 * Verify onboarded cust points.
	 */
	public void verifyOnboardedCustPoints() {
		try {
			contactTab.isTabDisplayInTabList("Products");
		} catch (Exception e) {
			contactTab.isTabDisplayInTabList("Products");
		}
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		System.out.println(contactTab.txt_Products_Active.getAttribute("title"));
		Assert.assertTrue(contactTab.txt_Products_Active.getAttribute("title").equals("Checked"));

		contactTab.isTabDisplayInTabList("Assets");
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		contactTab.get_AssetNameAndCheckActive("LPG-PR").isDisplayed();
		contactTab.get_AssetNameAndCheckActive("LPG-CL").isDisplayed();
		contactTab.get_AssetNameAndCheckActive("LPG-DGCC").isDisplayed();

		contactTab.isTabDisplayInTabList("Documents");
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		contactTab.lnk_DocumentNumberDrillDown.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();

		contactTab.isTabDisplayInTabList("Inventory Transactions");
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();

		System.out.println(contactTab.txt_InventoryTransactionsType_Documents.getAttribute("title"));
		Assert.assertTrue(
				contactTab.txt_InventoryTransactionsType_Documents.getAttribute("title").equalsIgnoreCase("Issue"));
	}

	/**
	 * Navigate to Secondary Sales Order.
	 */
	public void navigateToSecondarySalesOrders() {
		contactTab.isTabDisplayInTabList("Secondary Sales Orders");
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Select Secondary Sales Order Sub Type and drill down order sub type.
	 *
	 * @param OrderSubType the order sub type
	 */
	public void selectOrderSubType(String OrderSubType) {
		nfrPage.btn_CreateNewSecondarySalesOrder.click();
		expWait.waitForDomToLoad();
		nfrPage.txtBox_OrderType.findElement(By.xpath("input")).sendKeys(Keys.TAB);
		// JavaScript to update value of order sub type
		String id = nfrPage.txtBox_OrderSubType.findElement(By.xpath("input")).getAttribute("id");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(\"" + id + "\").value=\"\"");
		js.executeScript("document.getElementById(\"" + id + "\").value=\"" + OrderSubType + "\"");
		String shiftTab = Keys.chord(Keys.SHIFT, Keys.TAB);
		nfrPage.txtBox_OrderSubType.findElement(By.xpath("input")).sendKeys(shiftTab);
		nfrPage.lnk_SalesOrder.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Add products to NFR Secondary Sales Order.
	 */
	public void addProductsNFRSales() {
		nfrPage.btn_AddInvProducts.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		nfrPage.btn_InventoryLevelAdd.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		nfrPage.txtBox_Year_NFR_Item.click();
		nfrPage.txtBox_Year_NFR_Item.findElement(By.xpath("input")).sendKeys("2020");
		expWait.waitForDomToLoad();
		nfrPage.txtBox_Month_NFR_Item.click();
		nfrPage.txtBox_Month_NFR_Item.findElement(By.xpath("input")).sendKeys("12");
		expWait.waitForDomToLoad();
		nfrPage.btn_Submit.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		/*
		 * invoiceStatus = nfrPage.txtBox_InvoiceStatus.getAttribute("value");
		 * System.out.println("Invoice Status before Invoice completion: " +
		 * invoiceStatus);
		 */
		// To complete Invoice created for NFR sales
		completeInvoice();
	}

	/**
	 * Add products to FTL Secondary Sales Order.
	 */
	public void addProductsFTLSales() {
		nfrPage.btn_LineItemsNew.click(); // Click New button under Line item applet
		expWait.waitForDomToLoad();
		nfrPage.txtBox_ListAppletSchemeType.findElement(By.xpath("input")).sendKeys("General Scheme");
		nfrPage.btn_OK.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		nfrPage.btn_GetPrice.click(); // Click Get price button
		expWait.waitForHomePageSipperToDisapper();
		nfrPage.btn_Submit.click();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		// To complete Invoice created for FTL sales
		completeInvoice();
	}

	/**
	 * Complete invoice.
	 */
	private void completeInvoice() {
		nfrPage.tab_Invoice.click();
		expWait.waitForDomToLoad();
		nfrPage.lnk_InvoiceNumber.isDisplayed();
		nfrPage.lnk_InvoiceNumber.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		// JavaScript to interact with web element
		String name = contactTab.lnk_InvoiceStatus.getAttribute("name");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName(\"" + name + "\")[0].value=\"\";");
		expWait.waitLong(2);
		contactTab.lnk_InvoiceStatus.sendKeys("Completed");
		contactTab.lnk_InvoiceStatus.sendKeys(Keys.ENTER);
		contactTab.lnk_InvoiceStatus.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		nfrPage.lnk_InvoiceLineItemOrderStatus.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		orderStatus = nfrPage.txtBox_OrderStatus.getAttribute("value");
		if (!(orderStatus.equalsIgnoreCase("Completed"))) {
			LoggerWriter.logger.log(Status.FAIL, "Order Status not Completed after invoice completion.");
			Assert.assertEquals(orderStatus, "Completed", "Verify Order Status");
		} else {
			LoggerWriter.logger.log(Status.PASS, "Order Status is Completed after invoice completion.");
		}
	}

	/**
	 * Verify secondary sales order payment.
	 */
	public void verifySecondarySalesOrderPayment() {
		nfrPage.tab_Payments.click();
		expWait.waitForDomToLoad();
		String paymentStatus = nfrPage.txtBox_PaymentStatus.getAttribute("title");
		String paymentMethod = nfrPage.txtBox_PaymentMethod.getAttribute("title");
		String transactionType = nfrPage.txtBox_TransactionType.getAttribute("title");
		if (paymentMethod.equalsIgnoreCase("Cash") && paymentStatus.equalsIgnoreCase("Paid")
				&& transactionType.equalsIgnoreCase("Settle")) {
			LoggerWriter.logger.log(Status.PASS, "Payment for Secondary sales order successfully verified.");
		} else {
			LoggerWriter.logger.log(Status.FAIL, "Expected Payment columns for Secondary sales do not match.");
		}
	}

	/**
	 * Connect DB to update all secondary sales status to close.
	 *
	 * @param relationshipID the relationship ID
	 */
	public void connectDBToUpdateAllSecondarySalesStatusToClose(String relationshipID) {
		String dbQuery = "update siebel.s_order set Status_Cd = 'Cancelled' where ACCNT_ID in "
				+ "(select ROW_ID from siebel.s_org_ext where integration_id = '" + relationshipID + "') "
				+ " AND X_EPIC_SUB_TYPE IN ('OS26','OS50','OS25')";

		connectSiebelDBToExecuteUpdateQuery(dbQuery);
	}

	/**
	 * Connect DB to update WaitList Status while onboarding.
	 *
	 * @param relationshipID the relationship ID
	 */
	public void connectDBToUpdateWaitListStatus(String relationshipID) {
		String dbQuery = "UPDATE SIEBEL.S_ORG_EXT set X_SL69_STATUS = 'Released' " + "WHERE INTEGRATION_ID= '"
				+ relationshipID + "'";

		connectSiebelDBToExecuteUpdateQuery(dbQuery);
	}
}