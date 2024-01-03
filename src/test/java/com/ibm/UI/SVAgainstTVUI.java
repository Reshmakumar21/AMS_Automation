/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class SVAgainstTVUI.
 */
public class SVAgainstTVUI extends BaseUIPage {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new SV against TVUI.
	 *
	 * @param driver the driver
	 */
	public SVAgainstTVUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	@FindBy(xpath = "//*[@title='Pick Contact List Applet']//td[contains(@id,'First_Name')]")
	public WebElement txt_PickAppletFirstName;

	@FindBy(xpath = "//*[@title='Pick Contact List Applet']//*[text()='OK']")
	public WebElement btn_PickAppletOK;

	@FindBy(xpath = "//*[@title='Pick Contact List Applet']//button[@title='Pick Contact:Go']")
	public WebElement btn_PickAppletGO;



}
