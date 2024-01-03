package com.ibm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.Utilities;

public class EventWatcher implements WebDriverEventListener {
	@Override
	public void beforeAlertAccept(WebDriver driver) {
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("About to navigate URL : " + url);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to URL : " + url);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// System.out.println("WebElement lookup : "+by+" : "+element.getText());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		//System.out.println("About to click on : " + element.getText());
		//Reporter.log("About to click on : " + element.getText());


		if (Utilities.getYamlValue("ScreenShot").contains("true")) {
			try {
				if (!(element.getText().toString().isEmpty())) {
					System.out.println("About to click on the : " + element.getText().toString());
					Reporter.log("About to click on the : " + element.getText().toString());
					LoggerWriter.logger.log(Status.PASS, "About to click on the text: \"" + element.getText() + "\"",
							MediaEntityBuilder.createScreenCaptureFromPath(Utilities
									.takeScreenshotAuto("aboutToClickOn" + element.getText().replaceAll(":", "_")
									.replaceAll(">","")))
									.build());
				} else {
					if (!(element.getAttribute("title").toString().isEmpty())) {
						System.out.println("About to click on the : " + element.getAttribute("title").toString());
						Reporter.log("About to click on the : " + element.getAttribute("title").toString());
						LoggerWriter.logger.log(Status.PASS,
								"About to click on the title: \"" + element.getAttribute("title") + "\"",
								MediaEntityBuilder
										.createScreenCaptureFromPath(Utilities.takeScreenshotAuto(
												"aboutToClickOn" + element.getAttribute("title").replaceAll(":", "_")
														.replaceAll(">","")))
										.build());
					} else {
						if (!(element.getAttribute("value").toString().isEmpty())) {
							System.out.println("About to click on the : " + element.getAttribute("value").toString());
							Reporter.log("About to click on the : " + element.getAttribute("value").toString());
							LoggerWriter.logger.log(Status.PASS,
									"About to click on the value: \"" + element.getAttribute("value") + "\"",
									MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshotAuto(
											"aboutToClickOn" + element.getAttribute("value").replaceAll(":", "_")
													.replaceAll(">","")))
											.build());
						}
					}
				}
			} catch (Exception e) {
			}
		} else {
			try {
				if (!(element.getText().toString().isEmpty())) {
					System.out.println("About to click on the : " + element.getText().toString());
					Reporter.log("About to click on the : " + element.getText().toString());
					LoggerWriter.logger.log(Status.PASS, "About to click on the text: \"" + element.getText() + "\"");
				} else {
					if (!(element.getAttribute("title").toString().isEmpty())) {
						System.out.println("About to click on the : " + element.getAttribute("title").toString());
						Reporter.log("About to click on the : " + element.getAttribute("title").toString());
						LoggerWriter.logger.log(Status.PASS,
								"About to click on the title: \"" + element.getAttribute("title") + "\"");
					} else {
						if (!(element.getAttribute("value").toString().isEmpty())) {
							System.out.println("About to click on the : " + element.getAttribute("value").toString());
							Reporter.log("About to click on the : " + element.getAttribute("value").toString());
							LoggerWriter.logger.log(Status.PASS,
									"About to click on the value: \"" + element.getAttribute("value") + "\"");
						}
					}
				}
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
	}
}
