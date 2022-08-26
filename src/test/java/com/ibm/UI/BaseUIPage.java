/* 
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15 
 * 
 */
package com.ibm.UI;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * The Class BaseUIPage.
 */
public class BaseUIPage {
	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new base UI page.
	 *
	 * @param driver
	 *            the driver
	 */
	public BaseUIPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver = this.driver;
	}

	/**
	 * Execute js.
	 *
	 * @param script
	 *            the script
	 */
	public void executeJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, (Object) null);
	}

	/**
	 * Select element from dropdown.
	 *
	 * @param selectElement
	 *            the select element
	 * @param selectorType
	 *            the selector type
	 * @param sel
	 *            the sel
	 */
	public void SelectElementFromDropdown(WebElement selectElement, String selectorType, String sel) {
		Select select = new Select(selectElement);
		if (selectorType.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(sel));
		}
		if (selectorType.equalsIgnoreCase("visibleText")) {
			select.selectByVisibleText(sel);
		}
		if (selectorType.equalsIgnoreCase("value")) {
			select.selectByValue(sel);
		}
	}

	/**
	 * Gets the window handle.
	 *
	 * @return the window handle
	 */
	public void getWindowHandle() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void setDriverState(String winHandle) {
		driver.switchTo().window(winHandle);
	}

	/**
	 * Gets the element by text.
	 *
	 * @param elementlist
	 *            the elementlist
	 * @param elementtext
	 *            the elementtext
	 * @return the element by text
	 */
	protected WebElement getElementByText(List<WebElement> elementlist, String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().equalsIgnoreCase(elementtext)) {
				element = elem;
			}
		}
		if (element == null) {
		}
		return element;
	}

	/**
	 * Wait long.
	 *
	 * @param i
	 *            the i
	 */
	public void waitLong(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
