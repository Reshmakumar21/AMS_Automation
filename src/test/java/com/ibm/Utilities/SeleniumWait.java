/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-04-25
 */
package com.ibm.Utilities;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class SeleniumWait.
 */
public class SeleniumWait {

	/** The driver. */
	WebDriver driver;
	public Object waitForToast;

	/**
	 * Instantiates a new selenium wait.
	 * 
	 * @param driver
	 *            the driver
	 */
	public SeleniumWait(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Gets the when visible.
	 * 
	 * @param locator
	 *            the locator
	 * @param timeout
	 *            the timeout
	 * @return the when visible
	 */
	public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element;
		if (driver == null){
			System.out.println("********** fail***********");
		}
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		
		return element;
	}
	
	
	
	/**
	 * Gets the when visible.
	 *
	 * @param locator the locator
	 * @return the when visible
	 */
	public WebElement getWhenVisible(By locator) {
		int timeout = 60;
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		return element;
	}

	/**
	 * Gets the when visible list.
	 *
	 * @param locator the locator
	 * @param timeout the timeout
	 * @return the when visible list
	 */
	public List<WebElement> getWhenVisibleList(By locator, int timeout) {
		List<WebElement> element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(locator));
		return element;
	}

	/**
	 * Gets the web element when visible with polling interval
	 * and ignoring few of exceptions.
	 *
	 * @param locator the web element locator
	 * @return the web element when visible
	 */
	public WebElement getWhenVisible(WebElement locator) {
		int timeout = 120; //time in seconds
		int pollingTime = 1; //time in seconds
		WebElement element;

		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout, pollingTime)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(ElementNotVisibleException.class)
				.ignoring(ElementNotInteractableException.class);

		element = wait.until(ExpectedConditions
				.visibilityOf(locator));

		return element;
	}

	/**
	 * Gets the when clickable.
	 * 
	 * @param locator
	 *            the locator
	 * @param timeout
	 *            the timeout
	 * @return the when clickable
	 */
	public WebElement getWhenClickable(By locator, int timeout) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public WebElement getWhenClickable(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Click when ready.
	 * 
	 * @param locator
	 *            the locator
	 * @param timeout
	 *            the timeout
	 */
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(locator));
		element.click();
	}

	/**
	 * Wait for dom to load.
	 */
	public void waitForDomToLoad1() {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*")));
	}

	/**
	 * Wait for element to disappear.
	 *
	 * @param locator the locator
	 * @param timeOut the time out
	 */
	public void waitForElementToDisappear(By locator, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		driver.manage()
				.timeouts()
				.implicitlyWait(
						90,
						TimeUnit.SECONDS);
	}

	/**
	 * Gets the when visible with out implicit.
	 *
	 * @param locator the locator
	 * @param timeout the timeout
	 * @return the when visible with out implicit
	 */
	public WebElement getWhenVisibleWithOutImplicit(By locator, int timeout) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		driver.manage()
				.timeouts()
				.implicitlyWait(
						90,
						TimeUnit.SECONDS);
		return element;
	}
	
	/**
	 * Checks if is alert present.
	 *
	 * @return true, if is alert present
	 */
	/*To verify alert visibility
	*
	* @return boolean
	*
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
	 * Wait for document to load.
	 */
	public void waitForDomToLoad() {
		waitLong((int )1.25);
		getWhenVisible(By.xpath("//*"), 120);
	}
	
	public void waitLong(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wait for home page sipper to disapper.
	 */
	public void waitForHomePageSipperToDisapper() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String output;
		for (int i = 0; i < 100; i++) {
			output = (String) js.executeScript("return document.getElementsByTagName('html')[0].className").toString();
			if (output.contains("siebui-navigation-tab") && !(output.contains("siebui-busy"))) {
				if (!(i == 0)) {
					System.out.println("WorkFlow Timeout : " + i * 2 + " seconds");
				}
				break;
			} else {
				waitLong(2);
			}
		}
	}
	
	/**
	 * Wait for portal cursor to disappear.
	 */
	public void waitForCursorToDisappear() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String output;

		for (int i = 0; i < 100; i++) {
			output = js.executeScript("return document.getElementsByTagName('body')[0].style.cursor").toString();
			if ((output.contains("auto") || output.isEmpty())
					&& !(output.contains("wait"))) {
				if (!(i == 0)) {
					System.out.println("WorkFlow Timeout : " + i * 2 + " seconds");
				}
				break;
			} else {
				waitLong(2);
			}
		}
	}

	public WebElement presenceOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}
}
