/*
 * @author Shivam Tiwari
 * @version 2.2
 * @since 2020-04-25
 * @Update 2021-02-12
 */
package com.ibm.automation;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ibm.Actions.AccountsTabAction;
import com.ibm.Actions.ContactTabAction;
import com.ibm.Actions.HomePageActions;
import com.ibm.Actions.LoginActions;
import com.ibm.Actions.LokamActions;
import com.ibm.Actions.PartnerEmployeeActions;
import com.ibm.Actions.PetChemActions;
import com.ibm.Actions.PortalActions;
import com.ibm.Actions.ProfileServiceRequestAction;
import com.ibm.Actions.RetailAction;
import com.ibm.Actions.SVAgainstTVAction;
import com.ibm.Actions.TTVConnectionManagementAction;
import com.ibm.Actions.UjvalaCustomerOnboardingActions;
import com.ibm.Mobile.Actions.MobileAction;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * The Class TestSessionInitiator.
 */
public class TestSessionInitiator {
	/** The driver. */
	protected WebDriver driver;
	protected AppiumDriver<MobileElement> mobileDriver;

	/** The wdfactory. */
	private final WebDriverFactory wdfactory;
	/** The browser. */
	String browser;
	/** The seleniumserver. */
	String seleniumserver;
	/** The seleniumserverhost. */
	String seleniumserverhost;
	/** The appbaseurl. */
	String appbaseurl;
	/** The applicationpath. */
	String applicationpath;
	/** The chromedriverpath. */
	String chromedriverpath;
	/** The datafileloc. */
	String datafileloc = "";
	/** The timeout. */
	static int timeout;
	/** The chrome options. */
	Map<String, Object> chromeOptions = null;
	/** The capabilities. */
	DesiredCapabilities capabilities;
	/** The login. */
	public LoginActions login;
	/** The home page. */
	public HomePageActions homePage;
	/** The contact page. */
	public ContactTabAction contactPage;
	/** The ujvala actions. */
	public UjvalaCustomerOnboardingActions ujvalaActions;
	/** The accounts page. */
	public AccountsTabAction accountsPage;
	/** The ttv con mng page. */
	public TTVConnectionManagementAction ttvConMngPage;
	/** The sv against TV con mng page. */
	public SVAgainstTVAction svAgainstTVConMngPage;
	/** The profile SR page. */
	public ProfileServiceRequestAction profileSRPage;
	/** The partner emp page. */
	public PartnerEmployeeActions partnerEmpPage;
	/** The LOKAM page. */
	public LokamActions lokamPage;
	/* The Retail page */
	public RetailAction retailPage;
	/*The Portal*/
	public PortalActions portalPage;

	/****** Reshma K******/
	/*The Petchem Page */
	public PetChemActions petChemPage;

	public MobileAction mobileActions;

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * Inits the page.
	 */
	private void _initPage() {
		login = new LoginActions(driver);
		homePage = new HomePageActions(driver);
		contactPage = new ContactTabAction(driver);
		accountsPage = new AccountsTabAction(driver);
		ttvConMngPage = new TTVConnectionManagementAction(driver);
		svAgainstTVConMngPage = new SVAgainstTVAction(driver);
		profileSRPage = new ProfileServiceRequestAction(driver);
		ujvalaActions = new UjvalaCustomerOnboardingActions(driver);
		partnerEmpPage = new PartnerEmployeeActions(driver);
		lokamPage = new LokamActions(driver);
		retailPage = new RetailAction(driver);
		portalPage = new PortalActions(driver);
		petChemPage = new PetChemActions(driver);
	}

	/**
	 * Instantiates a new test session initiator.
	 */
	public TestSessionInitiator() {
		wdfactory = new WebDriverFactory();
		testInitiator();
	}

	public TestSessionInitiator(String mobile) {
		_launchEmulator();
		wdfactory = new WebDriverFactory();
		testInitiatorMobile();
	}

	public void _launchEmulator() {
		try {
			Process p = Runtime.getRuntime().exec("emulator -avd emulatortest1 -gpu host");
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testInitiatorMobile() {
		_configureMobile();
		_initPageMobile();
	}

	/**
	 * Test initiator.
	 */
	private void testInitiator() {
		_configureBrowser();
		_initPage();
	}

	/**
	 * Configure browser.
	 */
	private void _configureBrowser() {
		driver = wdfactory.getDriver(Utilities.getYamlValue("browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		LoggerWriter._initdriver(driver);
	}

	private void _configureMobile() {
		mobileDriver = wdfactory.getMobileDriver();
		mobileDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoggerWriter._initMobiledriver(mobileDriver);
	}

	/**
	 * Launch application.
	 *
	 * @param baseurl the baseurl
	 */
	public void launchApplication(String baseurl) {
		driver.manage().deleteAllCookies();
		driver.get(baseurl);
	}

	private void _initPageMobile() {
		// TODO Auto-generated method stub
		mobileActions = new MobileAction(mobileDriver);

	}

	/**
	 * Open url.
	 *
	 * @param url the url
	 */
	public void openUrl(String url) {
		driver.get(url);
	}

	/**
	 * Gets the yaml val.
	 *
	 * @param yamlMapObj the yaml map obj
	 * @return the yaml val
	 */
	public String getYamlVal(String yamlMapObj) {
		return Utilities.getYamlValue(yamlMapObj);
	}

	/**
	 * Close browser session.
	 */
	public void closeBrowserSession() {
		if (!(getYamlVal("Debug").equalsIgnoreCase("debug"))) {
			System.out.println("Tear DOWN *******************");
			driver.quit();
		}
	}

	public void closeMobileSession() {
		mobileDriver.removeApp("cx.indianoil.in");
		mobileDriver.quit();
		try {
			Process p = Runtime.getRuntime().exec("adb emu kill");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Close browser window.
	 */
	public void closeBrowserWindow() {
		driver.close();
	}
}
