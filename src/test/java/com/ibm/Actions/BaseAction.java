/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-04-25
 * @UpdateDate 2021-02-12
 */
package com.ibm.Actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.Utilities.SeleniumWait;
import com.ibm.Utilities.Utilities;
import com.ibm.automation.DBConnection;

/**
 * The Class BaseAction.
 */
public class BaseAction extends DBConnection {

	/**
	 * The Webdriver.
	 */
	WebDriver driver;

	/**
	 * Selenium waits.
	 */
	SeleniumWait expWait;

	/**
	 * Utility class.
	 */
	Utilities util;

	/**
	 * Instantiates a new base action.
	 *
	 * @param driver the driver
	 */
	public BaseAction(WebDriver driver) {
		this.driver = driver;
		expWait = new SeleniumWait(driver);
		util = new Utilities();
	}

	/**
	 * Checks if is alert present.
	 *
	 * @return true, if is alert present
	 */
	public boolean isAlertPresent() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (Exception noAlert) {
			System.out.println(noAlert.toString());
			foundAlert = false;
		}
		return foundAlert;
	}

	/**
	 * To perform save.
	 */
	public void performSave() {
		try {
			Actions keyAction = new Actions(driver);
			keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
			expWait.waitForDomToLoad();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To perform refresh.
	 */
	public void performRefresh() {
		try {
			driver.navigate().refresh();
			expWait.waitForDomToLoad();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To perform keyboard ALT+ENTER.
	 */
	public void performAltEnter() {
		Actions act = new Actions(driver);
		Action actions = act.sendKeys(Keys.ENTER).build();
		actions.perform();
	}

	/**
	 * To navigate back.
	 *
	 * @param n number of navigation required to back pages
	 */
	public void navigateBackIterations(int n) {
		for (int i = 1; i <= n; i++) {
			((JavascriptExecutor) driver).executeScript("history.go(-1);");
		}
	}

	/**
	 * To verify if alert is present on UI and Accept the alert.
	 *
	 * @param timeOutInSeconds timeout in seconds
	 */
	public void alertVerificationAndAcceptAlert(int timeOutInSeconds) {
		try {
			Alert simpleAlert = new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
			if (simpleAlert != null) {
				System.out.println("Alert is present");
				driver.switchTo().alert();
				System.out.println(simpleAlert.getText());
				simpleAlert.accept();
				expWait.waitLong(5);
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
		}
	}

	/**
	 * To verify if alert is present on UI and Accept the alert.
	 *
	 * @param timeOutInSeconds the time out in seconds
	 */
	public void alertVerificationAndDismissAlert(int timeOutInSeconds) {
		try {
			Alert simpleAlert = new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
			if (simpleAlert != null) {
				System.out.println("Alert is present");
				driver.switchTo().alert();
				System.out.println(simpleAlert.getText());
				simpleAlert.dismiss();
				expWait.waitLong(5);
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
		}
	}

	/**
	 * Generate random alphabetic string.
	 *
	 * @param n the n
	 * @return the random alphabetic string
	 */
	public String printRandomString(int n) {
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		String res = "";
		for (int i = 0; i < n; i++)
			res = res + alphabet[(int) (Math.random() * 10 % 26)];

		return res.toUpperCase();
	}

	/**
	 * Execute js.
	 *
	 * @param script the script
	 */
	public void executeJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, (Object) null);
	}
}
