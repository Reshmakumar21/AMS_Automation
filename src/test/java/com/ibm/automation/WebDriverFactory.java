/*
 * @author Shivam Tiwari
 * @version 2.2
 * @since 2020-04-25
 * @UpdateDate 2021-02-12
 */
package com.ibm.automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ibm.Utilities.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;

public class WebDriverFactory {
	public WebDriver getDriver(String browserUse) {
		if (browserUse.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions opt = new ChromeOptions();
			opt.setHeadless(Boolean.parseBoolean(Utilities.getYamlValue("headLessMode")));
			opt.setAcceptInsecureCerts(true);
			opt.addArguments("--incognito");
			opt.addArguments("--disable-infobars");
			//opt.addArguments("--window-size=1920,1080");
			WebDriver driver = new ChromeDriver(opt);
//			*********************************************************************************
			EventFiringWebDriver baseDriver = new EventFiringWebDriver(driver);
			EventWatcher watcher = new EventWatcher();
			baseDriver.register(watcher);
//			*********************************************************************************
			try {
				Thread.sleep((new Random().nextInt(10) + 1) * 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return baseDriver;
		}
		if (browserUse.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./Test.Resources/drivers/IEDriverServer.exe");
			WebDriver baseDriver = new InternetExplorerDriver();
			return baseDriver;
		}
		if (browserUse.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Test.Resources/drivers/geckodriver.exe");
			LoggingPreferences preferences = new LoggingPreferences();
			preferences.enable(LogType.BROWSER, Level.OFF);
			preferences.enable(LogType.CLIENT, Level.OFF);
			preferences.enable(LogType.DRIVER, Level.OFF);
			preferences.enable(LogType.PROFILER, Level.OFF);
			preferences.enable(LogType.PERFORMANCE, Level.OFF);
			preferences.enable(LogType.SERVER, Level.OFF);
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.LOGGING_PREFS, preferences);
			FirefoxOptions opt = new FirefoxOptions();
			opt.setAcceptInsecureCerts(true);
			opt.merge(dc);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.proxy.type", 0);
			WebDriver baseDriver = new FirefoxDriver(opt);
			return baseDriver;
		}
		return null;
	}

	public  AppiumDriver<MobileElement> getMobileDriver()  {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "emulatortest1");
		caps.setCapability("platformName", "Android");
		caps.setCapability("ignoreHiddenApiPolicyError", "true");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("app", (new File("consumerapp.apk")).getAbsolutePath());
		caps.setCapability("appPackage", "cx.indianoil.in");
		caps.setCapability("appActivity", "cx.indianoil.in.lpg.view.login.WelcomeActivity");
		caps.setCapability("adbExecTimeout", 20000);
		caps.setCapability("appWaitForLaunch",false);
		URL appServer=null;
		try {
			appServer = new URL("http://0.0.0.0:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("We reached here!");
		AppiumDriver<MobileElement>  driver = new AndroidDriver<MobileElement>(appServer, caps);
		//driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new EventWatcherMobile());

		return driver;
	}
}
