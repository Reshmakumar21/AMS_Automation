/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-04-25
 */
package com.ibm.Utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


/**
 * The Class LoggerWriter.
 */
public class LoggerWriter {
	/** The logger. */
	public static ExtentTest logger;
	/** The screen shot path. */
	public static String screenShotPath;
	/** Screen shot file */
	protected static File scrShorDirPath = new java.io.File("./"+ screenShotPath+ "//");
	/** The driver. */
	public static WebDriver driver;

	/**
	 * Inits the set logger.
	 *
	 * @param logger the logger
	 */
	public static void _initSetLogger(ExtentTest logger) {
		LoggerWriter.logger = logger;
	}

	/**
	 * Inits the set screen shot path.
	 *
	 * @param path the path
	 */
	public static void _initSetScreenShotPath(String path) {
		LoggerWriter.screenShotPath = path;
	}

	/**
	 * Initdriver.
	 *
	 * @param driver the driver
	 */
	public static void _initdriver(WebDriver driver) {
		LoggerWriter.driver = driver;
	}
	public static void _initMobiledriver(AppiumDriver<MobileElement> mobileDriver2) {
		LoggerWriter.driver = mobileDriver2;
	}
}
