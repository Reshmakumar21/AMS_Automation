/* 
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-09-15 
 * @UpdateDate 2021-02-12
 */
package com.ibm.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.ibm.UI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.ibm.Utilities.LoggerWriter;

/**
 * The Class AccountsTabAction.
 */
public class AccountsTabAction extends BaseAction {

	/** The contact tab. */
	protected ContactTabUI contactTab;

	/** The home page. */
	protected HomePageUI homePage;

	/** The account page. */
	protected AccountsTabUI accountPage;

	/** The nfr page. */
	protected NFR_UI nfrPage;
	/**
	 * The Login action.
	 */
	protected LoginActions loginAction;
	/**
	 * The profile SR page.
	 */
	protected ProfileServiceRequestUI profileSRPage;

	/** The driver. */
	WebDriver driver;

	/** The document number. */
	/*
	 * Document creation.
	 */
	String documentNumber;
	
	/** The approval status AM. */
	String approvalStatusAM;

	/**
	 * Instantiates a new accounts tab action.
	 *
	 * @param driver the driver
	 */
	public AccountsTabAction(WebDriver driver) {
		super(driver);
		contactTab = new ContactTabUI(driver);
		homePage = new HomePageUI(driver);
		accountPage = new AccountsTabUI(driver);
		nfrPage = new NFR_UI(driver);
		loginAction = new LoginActions(driver);
		profileSRPage = new ProfileServiceRequestUI(driver);
		this.driver = driver;
	}

	/**
	 * Navigate to accounts tab.
	 */
	public void navigateToAccountsTab() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();

		contactTab.get_MainTabLevel("Accounts").click();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Creates the new contact.
	 */
	public void createNewContact() {
		accountPage.btn_createNewAccount.click();
		expWait.waitForHomePageSipperToDisapper();
		accountPage.input_FirstNameAccount.isDisplayed();
	}

	/**
	 * Enter account details.
	 *
	 * @return the string
	 */
	public String enterAccountDetails() {
		accountPage.input_FirstNameAccount.click();
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String FirstName = "Account" + dateFormat.format(date);
		accountPage.input_FirstNameAccount.sendKeys(FirstName);
		System.out.println("Account Name: " + FirstName);
		accountPage.input_MobileNumberAccount.sendKeys("" + generateID());
		addIdentitiesForNewCustomer("", "", "");
		Assert.assertTrue(
				accountPage.input_DeDupStatusLabel.getAttribute("value").toLowerCase().endsWith("dedup pending"));
		System.out.println(accountPage.input_DeDupStatusLabel.getAttribute("value"));
		return FirstName;

	}

	/**
	 * Click on account lnk.
	 *
	 * @param accountName the account name
	 */
	public void clickOnAccountLnk(String accountName) {
		System.out.println("accountName : " + accountName);
		accountPage.get_accountNameLinkFromAccountList(accountName).click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Adds the payment profile.
	 *
	 * @param accountName the account name
	 */
	public void addPaymentProfile(String accountName) {
		accountPage.tab_PaymentProfiles.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();

		contactTab.btn_PymentProfileAddButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_IFSCButton.isDisplayed();
		contactTab.txt_IFSCButton.sendKeys("BARB0FIVEPO");
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_IFSCButton.sendKeys(Keys.TAB);
		contactTab.txt_IFSCButton.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_NameAsPerBank.click();
		contactTab.btn_NameAsPerBank.findElement(By.tagName("input")).click();
		contactTab.btn_NameAsPerBank.findElement(By.tagName("input")).sendKeys("Automation Name");
		expWait.waitForDomToLoad();
		contactTab.btn_AccountNumber.click();
		contactTab.btn_AccountNumber.findElement(By.tagName("input")).click();
		Random rand = new Random();
		String account = "";
		for (int i = 0; i < 4; i++) {
			account = account.concat("" + rand.nextInt(1000));
		}
		System.out.println("Account Number Enter : " + account);
		contactTab.btn_AccountNumber.findElement(By.tagName("input")).sendKeys(account);
		contactTab.btn_AccountType.click();
		contactTab.btn_AccountType.findElement(By.tagName("input")).click();
		contactTab.btn_AccountType.findElement(By.tagName("input")).sendKeys("Savings");
		contactTab.btn_AccountType.findElement(By.tagName("input")).sendKeys(Keys.TAB);
	}

	/**
	 * Account dedup.
	 */
	public void accountDedup() {

		accountPage.btn_AccountDedup.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println(accountPage.input_DeDupStatusLabel.getAttribute("value"));
		Assert.assertTrue(
				accountPage.input_DeDupStatusLabel.getAttribute("value").toLowerCase().endsWith("dedup clear"));

	}

	/**
	 * Relation ship tab navigation.
	 */
	public void relationShipTabNavigation() {
		accountPage.tab_Relationships.isDisplayed();
		expWait.waitForDomToLoad();
		accountPage.tab_Relationships.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Adds the identities for new customer.
	 *
	 * @param identityType   the identity type
	 * @param identityMethod the identity method
	 * @param identityNumber the identity number
	 */
	public void addIdentitiesForNewCustomer(String identityType, String identityMethod, String identityNumber) {
		accountPage.txtBox_IdentitiesSearchButton.click();
		accountPage.btn_IdentitiesNewButton.click();

		accountPage.txt_IdentitiesIdentityType.click();
		accountPage.txt_IdentitiesIdentityType.sendKeys("POA-POI");
		accountPage.txt_IdentitiesIdentityType.sendKeys(Keys.TAB);

		accountPage.txt_IdentitiesIdentityMethod.click();
		accountPage.txt_IdentitiesIdentityMethod.sendKeys("Driving Licence");
		accountPage.txt_IdentitiesIdentityMethod.sendKeys(Keys.TAB);

		// dateFormat = new SimpleDateFormat("mmss");
		accountPage.txt_IdentitiesIdentityNumber.click();
		accountPage.txt_IdentitiesIdentityNumber.sendKeys("DL1DX" + printRandomString(7));
		accountPage.txt_IdentitiesIdentityNumber.sendKeys(Keys.TAB);

		accountPage.btn_IdentitiesOK.click();

		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Adds the new site.
	 */
	public void addNewSite() {
		accountPage.btn_SiteNew.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		accountPage.btn_SiteName.isDisplayed();
	}

	/**
	 * Adds the new site details.
	 */
	public void addNewSiteDetails() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String FirstName = "Account" + dateFormat.format(date);
		System.out.println("Site Name: " + FirstName);
		accountPage.btn_SiteName.findElement(By.tagName("input")).click();
		accountPage.btn_SiteName.findElement(By.tagName("input")).sendKeys(FirstName);

		accountPage.btn_PaymentProfileName.click();
		accountPage.btn_PaymentProfileName.findElement(By.tagName("span")).click();
		// accountPage.btn_BankNumberMasking.isDisplayed();
		accountPage.btn_OKButtonPickPromotion.click();
	}

	/**
	 * Adds the new address account.
	 *
	 * @param line1   the line 1
	 * @param line2   the line 2
	 * @param line3   the line 3
	 * @param area    the area
	 * @param pinCode the pin code
	 * @param city    the city
	 * @param locale  the locale
	 */
	public void addNewAddressAccount(String line1, String line2, String line3, String area, String pinCode, String city,
			String locale) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		expWait.waitForDomToLoad();
		accountPage.btn_StreetAddress.click();
		accountPage.btn_StreetAddress.findElement(By.tagName("span")).click();
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
		contactTab.txtBox_SaveAddress.click();
		contactTab.txtBox_OKButoonAddNewAddress.click();
	}

	/**
	 * Site de dup.
	 */
	public void siteDeDup() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		try {
			Actions keyAction = new Actions(driver);
			keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		accountPage.btn_SiteDeDup.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();

		Assert.assertTrue(accountPage.txt_SiteDeDupStatus.getText().equalsIgnoreCase("Dedup Clear"));

	}

	/**
	 * Creates the new relation ship.
	 *
	 * @param environment the environment
	 * @return the string
	 */
	public String createNewRelationShip(String environment) {
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		accountPage.tab_RealtionShips.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_NewRelationShip.click();
		contactTab.lnk_ReationShipAgainst.isDisplayed();
		contactTab.lnk_ReationShipAgainst.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		try {
			Actions keyAction = new Actions(driver);
			keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		try {
			contactTab.lnk_NewReationShipID.isDisplayed();
		} catch (Exception e) {
			accountPage.tab_RealtionShips.click();
		}
		try {
			contactTab.lnk_NewReationShipID.click();
		} catch (Exception e) {
			accountPage.tab_RealtionShips.click();
			contactTab.lnk_NewReationShipID.click();
		}
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		contactTab.txt_RealtionShipNumber.isDisplayed();
		System.out.println("RealtionShip Number : " + contactTab.txt_RealtionShipNumber.getAttribute("value"));
		LoggerWriter.logger.log(Status.PASS,
				"RelationShipNumber : " + contactTab.txt_RealtionShipNumber.getAttribute("value"));
		return contactTab.txt_RealtionShipNumber.getAttribute("value");
	}

	/**
	 * Relation ship drill down and set account scheme.
	 *
	 * @param consCategory  the cons category
	 * @param schemeType    the scheme type
	 * @param promotionName the promotion name
	 * @param serviceArea   the service area
	 */
	public void relationShipDrillDownAndSetAccountScheme(String consCategory, String schemeType, String promotionName,
			String serviceArea) {
		contactTab.dropdown_RealtionShipNumberScheme.click();
		contactTab.waitLong(5);

		contactTab.dropdown_RealtionShipNumberConsumerCategoryType.sendKeys(consCategory);
		contactTab.dropdown_RealtionShipNumberConsumerCategoryType.sendKeys(Keys.TAB);
		contactTab.dropdown_RealtionShipNumberSchemeType.click();
		contactTab.dropdown_RealtionShipNumberSchemeType.sendKeys(schemeType);
		contactTab.dropdown_RealtionShipNumberSchemeType.sendKeys(Keys.TAB);
		contactTab.btn_RelationShipProductsIcon.click();
		contactTab.dropdown_PickPromotion.click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		try {
			contactTab.get_SearchResultPromotion(promotionName).click();
		} catch (Exception e) {

		}
		contactTab.btn_OKPromotion.isEnabled();
		contactTab.btn_OKPromotion.click();
		expWait.waitForDomToLoad();
		/*
		 * contactTab.btn_ServiceArea.click();
		 * contactTab.btn_ServiceArea.sendKeys(serviceArea);
		 * contactTab.btn_ServiceArea.sendKeys(Keys.TAB);
		 */
		new ContactTabAction(driver).serviceAreaSelection(serviceArea);
	}

	/**
	 * Enter number of flats.
	 */
	public void enterNumberOfFlats() {
		contactTab.dropdown_RealtionShipNumberNoOfFlats.click();
		contactTab.dropdown_RealtionShipNumberNoOfFlats.clear();
		contactTab.dropdown_RealtionShipNumberNoOfFlats.click();
		contactTab.dropdown_RealtionShipNumberNoOfFlats.sendKeys("14");
		contactTab.dropdown_RealtionShipNumberNoOfFlats.sendKeys(Keys.TAB);

	}

	/**
	 * Generate ID.
	 *
	 * @return the long
	 */
	public static long generateID() {
		Random rnd = new Random();
		char[] digits = new char[10];
		digits[0] = (char) (rnd.nextInt(9) + '1');
		for (int i = 1; i < digits.length; i++) {
			digits[i] = (char) (rnd.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}

	/**
	 * Created line items.
	 *
	 * @param consumerType the consumer type
	 */
	public void createdLineItems(String consumerType) {
		// document number
		documentNumber = accountPage.txtBox_DocumentNumber.getAttribute("value");
		System.out.println("DOCUMENT_NUM: " + documentNumber);
		contactTab.btn_DocumentLineDefault.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_DocumentLineRepriceAll.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();

		contactTab.txt_DocumentLineDBCQuantity.click();
		contactTab.txt_DocumentLineDBCQuantity.findElement(By.tagName("input")).clear();
		contactTab.txt_DocumentLineDBCQuantity.findElement(By.tagName("input")).sendKeys("20");
		contactTab.txt_DocumentLineDBCQuantity.findElement(By.tagName("input")).sendKeys(Keys.TAB);

		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
	}

	/**
	 * input make month year.
	 */
	public void enterMakeMonthYear() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
//		*************************************
		contactTab.btn_DocumentLineLPGPRMake.click();
		expWait.waitForDomToLoad();
		contactTab.btn_DocumentLineLPGPRMake.click();
		contactTab.btn_DocumentLineLPGPRMake.findElement(By.tagName("input")).sendKeys("testMake");
		contactTab.btn_DocumentLineLPGPRMake.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRYear.click();
		contactTab.btn_DocumentLineLPGPRYear.findElement(By.tagName("input")).sendKeys("2010");
		contactTab.btn_DocumentLineLPGPRYear.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRMonth.click();
		contactTab.btn_DocumentLineLPGPRMonth.findElement(By.tagName("input")).sendKeys("10");
		contactTab.btn_DocumentLineLPGPRMonth.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRSerial.click();
		contactTab.btn_DocumentLineLPGPRSerial.findElement(By.tagName("input")).sendKeys("3456789AD");
		contactTab.btn_DocumentLineLPGPRSerial.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.btn_DocumentLineLPGPRSerialDGCC.click();
		contactTab.btn_DocumentLineLPGPRSerialDGCC.findElement(By.tagName("input")).sendKeys("3456789AJ");
		contactTab.btn_DocumentLineLPGPRSerialDGCC.findElement(By.tagName("input")).sendKeys(Keys.TAB);

		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
	}

	/**
	 * Adds the new relation ship.
	 */
	public void addNewRelationShip() {
		accountPage.btn_RelationShipNew.click();
		expWait.waitForDomToLoad();
		performSave();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		accountPage.txtBox_RelationShipUCMiD.isDisplayed();
	}

	/**
	 * Adds the new relation ship details.
	 */
	public void addNewRelationShipDetails() {
		String id = accountPage.txtBox_RelationshipType.getAttribute("id");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("document.getElementById(\"" + id + "\")[0].value=\"\";");
		System.out.println("JAVASCRIPT: " + "document.getElementById('" + id + "').textContent=\"\";");
		js.executeScript("document.getElementById('" + id + "').textContent=\"\";");
		expWait.waitForDomToLoad();
		performSave();
		accountPage.txtBox_RelationshipType.click();
		accountPage.txtBox_RelationshipType.findElement(By.tagName("input")).sendKeys("FTL");
		accountPage.txtBox_RelationshipType.sendKeys(Keys.TAB);
		//Customer Segment mandatory for FTL
		accountPage.txtBox_CustomerSegment.click();
		accountPage.txtBox_CustomerSegment.findElement(By.tagName("input")).sendKeys("Individual");

		accountPage.txtBox_RelationShipId.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Tick FTL reseller flag.
	 */
	public void tickFTLResellerFlag() {
		if (!accountPage.chkBox_FTLResellerFlag.isSelected()) {
			accountPage.chkBox_FTLResellerFlag.click();
			expWait.waitForDomToLoad();
		}
	}

	/**
	 * Un tick FTL reseller flag.
	 */
	public void unTickFTLResellerFlag() {
		if (accountPage.chkBox_FTLResellerFlag.isSelected()) {
			accountPage.chkBox_FTLResellerFlag.click();
			expWait.waitForDomToLoad();
		}
	}

	/**
	 * Navigate to secondary sales tab.
	 */
	public void navigateToSecondarySalesTab() {
		contactTab.isTabDisplayInTabList("Secondary Sales Orders");
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Verify secondary sales plus button status.
	 */
	public void verifySecondarySalesPlusButtonStatus() {
		if (nfrPage.btn_CreateNewSecondarySalesOrder.isEnabled()) {
			LoggerWriter.logger.log(Status.FAIL,
					"Plus button for Secondary sales order is enabled after verify seller flag is checked.");
		} else {
			LoggerWriter.logger.log(Status.PASS,
					"Plus button for Secondary sales order is disabled after verify seller flag is checked.");
		}
	}

	/**
	 * Click secondary sales plus button.
	 */
	public void clickSecondarySalesPlusButton() {
		navigateToSecondarySalesTab();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
	}

	/**
	 * Submit document.
	 */
	public void submitDocument() {
		contactTab.btn_DocumentsSubmit.click();

		// alert1
		alertVerificationAndAcceptAlert(15);
		// alert2
		alertVerificationAndAcceptAlert(15);

		if (!accountPage.txtBox_ApprovalStatusAreaManager.getAttribute("value")
				.equalsIgnoreCase("Sent for AM Approval")) {
			performRefresh();
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();
		}
	}

	/**
	 * Document approval by area manager for Exempted account onBoarding.
	 *
	 * @param btnApproveReject the btn approve reject
	 */
	public void documentApprovalByAreaManager(String btnApproveReject) {
		// login to Area Manager.
		ArrayList<String> tabs = loginAction.loginAM();

		if (profileSRPage.get_nameInboxItem(documentNumber).isDisplayed()) {
			profileSRPage.get_nameInboxItem(documentNumber).click();
			expWait.waitForHomePageSipperToDisapper();
			expWait.waitForDomToLoad();

			profileSRPage.get_btnApproveReject(btnApproveReject).click();
			expWait.waitForHomePageSipperToDisapper();
			expWait.waitForDomToLoad();

			// area manager approval status
			accountPage.txtBox_ApprovalStatusAreaManager.sendKeys(Keys.ALT, Keys.ENTER);
			approvalStatusAM = accountPage.txtBox_ApprovalStatusAreaManager.getAttribute("value");

			if (approvalStatusAM.equalsIgnoreCase("Approved")) {
				LoggerWriter.logger.log(Status.PASS, "Area Manager Status approved.");
			} else {
				LoggerWriter.logger.log(Status.FAIL, "Area Manager Status not approved. System error.");
			}

		} else {
			LoggerWriter.logger.log(Status.FAIL,
					"Document number not available under inbox of Area Manager home screen.");
		}

		driver.switchTo().window(tabs.get(0)); // switch back to main screen
		expWait.waitForDomToLoad();

		String siebelApprovalStatusAM = accountPage.txtBox_ApprovalStatusAreaManager.getAttribute("value");

		if (!siebelApprovalStatusAM.equalsIgnoreCase("Approved")) {
			driver.navigate().refresh();
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();

			siebelApprovalStatusAM = accountPage.txtBox_ApprovalStatusAreaManager.getAttribute("value");
		}
		Assert.assertEquals(siebelApprovalStatusAM, approvalStatusAM,
				"Area Manager status NOT APPROVED in" + "siebel and area manager login.");
		LoggerWriter.logger.log(Status.PASS, "Area Manager status APPROVED in siebel and Area Manager login.");
	}

}
