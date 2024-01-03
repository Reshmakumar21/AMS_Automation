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
 * The Class LoginPageUI.
 */
public class LoginPageUI extends BaseUIPage {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new login page UI.
	 *
	 * @param driver
	 *            the driver
	 */
	public LoginPageUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	@FindBy(xpath = "//*[text()='Continue' or @type='submit' or text()='Login']")
	public WebElement btn_SignIn;

	@FindBy(xpath = "//*[@id='password' or contains(@name,'Password')]")
	public WebElement txtBox_Password;

	@FindBy(xpath = "//*[@id='username' or contains(@name,'UserName')]")
	public WebElement txtBox_UserName;

	/**
	 * Txt box user name.
	 *
	 * @return the web element
	 */
	public WebElement txtBox_UserName() {
		return expWait.getWhenVisible(By.xpath("//*[@id='username' or contains(@name,'UserName')]"), 60);
	}

	/**
	 * Txt box password.
	 *
	 * @return the web element
	 */
	public WebElement txtBox_Password() {
		return expWait.getWhenVisible(By.xpath("//*[@id='password' or contains(@name,'Password')]"), 60);
	}

	/**
	 * Wait for dom to load.
	 */
	public void waitForDomToLoad() {
		waitLong(2);
		expWait.getWhenVisible(By.xpath("//*"), 120);
	}

	/**
	 * Launch.
	 */
	public void launch() {
		driver.findElement(By.linkText("More information")).click();

		driver.findElement(By.linkText("Go on to the webpage (not recommended)")).click();
	}

}
