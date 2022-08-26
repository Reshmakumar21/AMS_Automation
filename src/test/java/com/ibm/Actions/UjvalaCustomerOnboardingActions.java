package com.ibm.Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.Utilities.LoggerWriter;

/**
 * The Class UjvalaCustomerOnboardingActions.
 */
public class UjvalaCustomerOnboardingActions extends BaseAction{
	/** The contact tab. */
	protected ContactTabUI contactTab;

	/** The home page. */
	protected HomePageUI homePage;

	/** The driver. */
	WebDriver driver;

	/** The first name global. */
	public String firstNameGlobal;

	/**
	 * Instantiates a new ujvala customer on-boarding actions.
	 *
	 * @param driver
	 *            the driver
	 */
	public UjvalaCustomerOnboardingActions(WebDriver driver) {
		super(driver);
		contactTab = new ContactTabUI(driver);
		homePage = new HomePageUI(driver);
		this.driver = driver;
	}

	/**
	 * Adds the new identity.
	 */
	public void addNewIdentity() {
		contactTab.waitLong(5);
		contactTab.btn_ContactIdentitiesNewPlus.click();
		for (int i = 0; i < 10; i++) {
			try {
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert box text" + alert.getText());
				alert.accept();
			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * Adds the identity aadhar.
	 */
	public void addIdentityAadhar() {
		for (int i = 0; i < 10; i++) {
			contactTab.waitLong(2);
			try {
				if (driver.findElements(By.xpath("//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Type')]")).size() == 2) {
					break;
				}
			} catch (Exception e) {
				contactTab.waitLong(2);
			}
		}
		System.out.println(driver.findElements(By.xpath("//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Type')]")).size());
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_EPIC_Identity_Type.click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys("POA-POI");
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys("Aadhaar(UID)");
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		String aadharNumberGen = "";
		for (int i = 0; i < 5; i++) {
			aadharNumberGen = CheckAadharApp(("file:///" + System.getProperty("user.dir").replace("\\", "/") + "/Test.Resources/drivers" + "/CheckDigits.html"));
			System.out.println("aadharNumberGen : " + aadharNumberGen);
			contactTab.txt_EPIC_Identity_Num.click();
			contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).click();
			contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(aadharNumberGen);
			contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(Keys.TAB);
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
	}

	/**
	 * Adds the identity ration card.
	 */
	public void addIdentityRationCard() {
		for (int i = 0; i < 10; i++) {
			contactTab.waitLong(2);
			try {
				if (driver.findElements(By.xpath("//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Type')]")).size() == 3) {
					break;
				}
			} catch (Exception e) {
				contactTab.waitLong(2);
			}
		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_EPIC_Identity_Type.click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys("POA-POI");
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys("Ration Card");
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Issue_Date.click();
		contactTab.txt_EPIC_Issue_Date.findElement(By.tagName("input")).click();
		contactTab.txt_EPIC_Issue_Date.findElement(By.tagName("input")).sendKeys("01-Aug-2018");
		contactTab.txt_EPIC_Issue_Date.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		contactTab.txt_EPIC_Issue_State.findElement(By.tagName("input")).sendKeys("Uttar Pradesh");
		contactTab.txt_EPIC_Issue_State.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Verif_Authority.click();
		contactTab.txt_EPIC_Verif_Authority.findElement(By.tagName("input")).click();
		contactTab.txt_EPIC_Verif_Authority.findElement(By.tagName("input")).sendKeys("DONE");
		contactTab.txt_EPIC_Verif_Authority.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		for (int i = 0; i < 5; i++) {
			DateFormat dateFormat = new SimpleDateFormat("yyyymmss");
			Date date = new Date();
			String rationNumber = "175110" + dateFormat.format(date).toString();
			contactTab.txt_EPIC_Identity_Num.click();
			contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).click();
			contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(rationNumber);
			contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(Keys.TAB);
			try {
				Alert alt = driver.switchTo().alert();
				System.out.println(alt.getText());
				alt.accept();
			} catch (Exception e) {
				LoggerWriter.logger.log(Status.PASS, "Aadhar Number : " + rationNumber);
				break;
			}
		}
	}

	/**
	 * Adds the identity internal ujvala certificate.
	 */
	public void addIdentityInternalUjvalaCertificate() {
		for (int i = 0; i < 10; i++) {
			contactTab.waitLong(2);
			try {
				if (driver.findElements(By.xpath("//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Type')]")).size() == 5) {
					break;
				}
			} catch (Exception e) {
				contactTab.waitLong(2);
			}
		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_EPIC_Identity_Type.click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys("INTERNAL-UJJWALA");
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys("Certificate by Distributor");
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).click();
		DateFormat dateFormat = new SimpleDateFormat("yyyymmss");
		Date date = new Date();
		String Number = dateFormat.format(date).toString();
		contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(Number);
		contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(Keys.TAB);
	}

	/**
	 * Check aadhar app.
	 *
	 * @param URL
	 *            the url
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
	 * Adds the identity internal ujvala.
	 */
	public void addIdentityInternalUjvala() {
		for (int i = 0; i < 20; i++) {
			contactTab.waitLong(2);
			try {
				if (driver.findElements(By.xpath("//*[@title='Contact Identities List Applet']//td[contains(@id,'EPIC_Identity_Type')]")).size() == 4) {
					break;
				}
			} catch (Exception e) {
				contactTab.waitLong(2);
			}
		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_EPIC_Identity_Type.click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).click();
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys("INTERNAL-UJJWALA");
		contactTab.txt_EPIC_Identity_Type.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys("14 Point Exclusion Declaration");
		contactTab.txt_EPIC_Identity_Method.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).click();
		DateFormat dateFormat = new SimpleDateFormat("yyyymmss");
		Date date = new Date();
		String Number = dateFormat.format(date).toString();
		contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(Number);
		contactTab.txt_EPIC_Identity_Num.findElement(By.tagName("input")).sendKeys(Keys.TAB);
	}

	/**
	 * Adds the house hold.
	 */
	public void addHouseHold() {
		contactTab.btn_HouseHoldNew.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		Assert.assertTrue(contactTab.checkbox_HouseHoldNewRow.isDisplayed());
		Assert.assertTrue(contactTab.checkbox_ContactsNewRow.isDisplayed());
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_Relation_to_Household.click();
		contactTab.txt_Relation_to_Household.findElement(By.tagName("input")).click();
		contactTab.txt_Relation_to_Household.findElement(By.tagName("input")).sendKeys("SELF");
		contactTab.txt_Relation_to_Household.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		contactTab.txt_EPIC_Contact_Category.click();
		contactTab.txt_EPIC_Contact_Category.findElement(By.tagName("input")).click();
		contactTab.txt_EPIC_Contact_Category.findElement(By.tagName("input")).sendKeys("Gen");
		contactTab.txt_EPIC_Contact_Category.findElement(By.tagName("input")).sendKeys(Keys.TAB);
		performSave();
	}

	/**
	 * Creates the new relation ship ujvala.
	 */
	public void createNewRelationShipUjvala() {
		contactTab.btn_NewRelationShip.click();
		contactTab.lnk_ReationShipAgainst.isDisplayed();
		contactTab.lnk_ReationShipAgainst.sendKeys(Keys.TAB);
		
		contactTab.txt_ReationShipAppletAddress.click();
		contactTab.txt_ReationShipAppletAddress.findElement(By.tagName("input")).click();
		contactTab.txt_ReationShipAppletAddress.findElement(By.tagName("span")).click();
		
//		contactTab.txt_ReationShipAppletAddressSearchIcon.click();
		contactTab.btn_RealtionShipAddressOKButton.click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_RealtionShipNumberAgainst.isDisplayed();
		contactTab.txt_RealtionShipNumberAgainst.click();
		contactTab.txt_RealtionShipNumberAgainst.findElement(By.tagName("input")).click();
		contactTab.txt_RealtionShipNumberAgainst.findElement(By.tagName("input")).sendKeys(Keys.TAB);
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
	}

	/**
	 * Perform save.
	 */
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
	 * Relation ship drill down and set scheme.
	 *
	 * @param scheme
	 *            the scheme
	 * @param schemeType
	 *            the scheme type
	 * @param schemeSubType
	 *            the scheme sub type
	 * @param promotionName
	 *            the promotion name
	 * @param serviceArea
	 *            the service area
	 */
	public void relationShipDrillDownAndSetScheme(String scheme, String schemeType, String schemeSubType, String promotionName, String serviceArea) {
		contactTab.waitLong(5);
		contactTab.dropdown_RealtionShipNumberScheme.sendKeys(scheme);
		contactTab.dropdown_RealtionShipNumberScheme.sendKeys(Keys.TAB);
		contactTab.dropdown_RealtionShipNumberSchemeType.click();
		contactTab.dropdown_RealtionShipNumberSchemeType.sendKeys(schemeType);
		contactTab.dropdown_RealtionShipNumberSchemeType.sendKeys(Keys.TAB);
		contactTab.dropdown_RealtionShipNumberSchemeSubType.click();
		contactTab.dropdown_RealtionShipNumberSchemeSubType.sendKeys(schemeSubType);
		contactTab.dropdown_RealtionShipNumberSchemeSubType.sendKeys(Keys.TAB);
		contactTab.btn_RelationShipProductsIcon.click();
		contactTab.dropdown_PickPromotion.click();
		expWait.waitForDomToLoad();
		contactTab.btn_PickPromotionSearch.click();
		expWait.waitForDomToLoad();
		contactTab.get_SearchResultPromotion(promotionName).click();
		contactTab.btn_OKPromotion.isEnabled();
		contactTab.btn_OKPromotion.click();
		expWait.waitForDomToLoad();
		contactTab.btn_ServiceArea.click();
		contactTab.btn_ServiceArea.sendKeys(serviceArea);
		contactTab.btn_ServiceArea.sendKeys(Keys.TAB);
	}

	/**
	 * Gets the attach file path.
	 *
	 * @return the attach file path
	 */
	public String get_AttachFilePath() {
		return (System.getProperty("user.dir") + "\\src\\resources\\drivers" + "\\AttachPic.jpg");
	}

	/**
	 * Adds the attachment for aadhar.
	 *
	 * @param identityType
	 *            the identity type
	 */
	public void addAttachmentForAadhar(String identityType) {
		driver.navigate().refresh();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.get_identitiesMethodRow(identityType).click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		for (int i = 0; i < 20; i++) {
			if (contactTab.get_identitiesMethodRow(identityType).getAttribute("class").contains("state-highlight")) {
				break;
			} else {
				expWait.waitForDomToLoad();
				expWait.waitForHomePageSipperToDisapper();
			}
		}
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[contains(@title,'Manage Contact Attachments')]//iframe")));
		driver.findElement(By.xpath("//a[text()='New']")).click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		// expWait.waitForHomePageSipperToDisapper();
		String parentWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(get_AttachFilePath());
		expWait.waitForDomToLoad();
		driver.findElement(By.xpath("//input[@value='Check In']")).click();
		expWait.waitForDomToLoad();
		expWait.waitForDomToLoad();
		driver.findElement(By.xpath("//*[@value='Additional Attachments']")).isDisplayed();
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.get_identitiesMethodRow(identityType).click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		for (int i = 0; i < 20; i++) {
			if (contactTab.get_identitiesMethodRow(identityType).getAttribute("class").contains("state-highlight")) {
				break;
			} else {
				expWait.waitForDomToLoad();
				expWait.waitForHomePageSipperToDisapper();
			}
		}
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[contains(@title,'Manage Contact Attachments')]//iframe")));
		driver.findElement(By.xpath("//table//a[contains(text(),'Attach')]")).isDisplayed();
	}

	/**
	 * Connect DB for release wait status.
	 *
	 * @param ucmID
	 *            the ucm ID
	 * @param env
	 *            the env
	 */
	public void connectDBForReleaseWaitStatus(String ucmID, String env) {
		try {
			String dbURL;
			if (env.toLowerCase().contains("sit")) {
				dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.59.7.91)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=tsblpdb.ds.indianoil.in)))";
			} else {
				dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.59.7.163)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=usblpdb)))";
			}
			String strUserID = "AKOHLI";
			String strPassword = "Hrhk1234";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection myConnection = DriverManager.getConnection(dbURL, strUserID, strPassword);
			Statement sqlStatement = myConnection.createStatement();
			// Update
			String readRecordSQL = "update siebel.s_org_ext set x_sl69_status = 'Released' where row_id = '" + ucmID + "'";
			ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);
			int test = sqlStatement.executeUpdate(readRecordSQL);
			System.out.println(test);
			myResultSet.close();
			myConnection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Release wait state.
	 *
	 * @param env
	 *            the env
	 */
	public void releaseWaitState(String env) {
		driver.navigate().refresh();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		connectDBForReleaseWaitStatus(contactTab.dropdown_RealtionShipEPIC_UCM_Id_Label.getAttribute("value"), env);
		driver.navigate().refresh();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		System.out.println(contactTab.dropdown_RealtionShipWaitlistStatus.getAttribute("value"));
	}

	/**
	 * Drill down relation ship.
	 */
	public void drillDownRelationShip() {
		contactTab.isTabDisplayInTabList("Ujjwala Connection Summary");
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		try {
			contactTab.lnk_NewReationShipID.isDisplayed();
		} catch (Exception e) {
			contactTab.isTabDisplayInTabList("Ujjwala Connection Summary");
			expWait.waitForDomToLoad();
			expWait.waitForHomePageSipperToDisapper();
			contactTab.lnk_NewReationShipID.isDisplayed();
		}
		contactTab.lnk_NewReationShipID.click();
	}

	/**
	 * Gets the relation ship number.
	 *
	 * @return the relation ship number
	 */
	public String get_RelationShipNumber() {
		return driver.findElement(By.xpath("//*[@aria-label='Relationship Id']")).getAttribute("value");
	}

	/**
	 * Adds the payment bank details.
	 */
	public void addPaymentBankDetails() {
		driver.navigate().refresh();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
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
	 * Created line items.
	 *
	 * @param loan
	 *            the loan
	 */
	public void createdLineItems(String loan) {
		contactTab.btn_DocumentLineDefault.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_NFRLPGStove.click();
		contactTab.txt_NFRLPGStove.findElement(By.tagName("span")).click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_CityKingLPGStove.click();
		contactTab.btn_OK.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_NFRLPGHose.click();
		contactTab.txt_NFRLPGHose.findElement(By.tagName("span")).click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_SurakshaHose.click();
		contactTab.btn_OK.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.txt_Loan.click();
		contactTab.txt_Loan.sendKeys(loan);
		contactTab.txt_Loan.sendKeys(Keys.TAB);
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		contactTab.btn_DocumentLineRepriceAll.click();
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
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
}
