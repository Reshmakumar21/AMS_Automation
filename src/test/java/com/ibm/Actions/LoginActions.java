/*
 * @author  Shivam Tiwari
 * @version 1.0
 * @since   2019-06-15
 *
 */
package com.ibm.Actions;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.ibm.UI.LoginPageUI;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.Utilities;

/**
 * The Class LoginActions.
 */
public class LoginActions extends BaseAction {
    /**
     * The login page.
     */
    protected LoginPageUI loginPage;

    /**
     * The driver.
     */
    protected WebDriver driver;

    /**
     * Instantiates a new login actions.
     *
     * @param driver the driver
     */
    public LoginActions(WebDriver driver) {
        super(driver);
        loginPage = new LoginPageUI(driver);
        this.driver = driver;
    }

    /**
     * Login to application.
     *
     * @param UserName the user name
     * @param Password the password
     */
    public void LoginToApplication(String UserName, String Password) {
        loginPage.txtBox_UserName().isDisplayed();
        loginPage.waitForDomToLoad();
        loginPage.txtBox_UserName.sendKeys(UserName);
        loginPage.txtBox_Password().sendKeys(Password);
        System.out.println("Login Pass new : " + UserName + " " + Password);
        LoggerWriter.logger.log(Status.PASS, "Login Info : " + UserName + " " + Password);
        clickOnSighInButton();
    }

    public void LoginToApplication(String str) {
        if (str.equalsIgnoreCase("SIT")) {
            LoginToApplication(Utilities.getYamlValue("DRSIT.UserName"), Utilities.getYamlValue("DRSIT.Password"));
        }

        if (str.equalsIgnoreCase("UAT")) {
            LoginToApplication(Utilities.getYamlValue("DRUAT.UserName"), Utilities.getYamlValue("DRUAT.Password"));
        }
        clickOnSighInButton();
    }

    public void LoginToPortal(String UserName, String Password) {
        loginPage.txtBox_UserName().isDisplayed();
        loginPage.waitForDomToLoad();
        loginPage.txtBox_UserName.sendKeys(UserName);
        loginPage.btn_SignIn.click();
        loginPage.waitForDomToLoad();
        loginPage.txtBox_Password().sendKeys(Password);
        loginPage.btn_SignIn.click();
        loginPage.waitForDomToLoad();
        System.out.println("Login Pass new : " + UserName + " " + Password);
        LoggerWriter.logger.log(Status.PASS, "Login Info : " + UserName + " " + Password);
    }

    /**
     * Click on sigh in button.
     */
    public void clickOnSighInButton() {
        loginPage.btn_SignIn.isDisplayed();
        expWait.waitForDomToLoad();
        loginPage.waitForDomToLoad();
        loginPage.btn_SignIn.click();
    }

    /**
     * Login Siebel user.
     */
    public ArrayList loginSiebel() {
        return loginSimulator();
    }

    /**
     * Login AM user.
     */
    public ArrayList loginAM() {
        return loginSimulate(".AM");
    }

    /**
     * Login FO user.
     */
    public ArrayList loginFO() {
        return loginSimulate(".FO");
    }

    /**
     * Login Retail FO user.
     */
    public ArrayList loginFORetail() {
        return loginSimulate(".FO.Retail.User1");
    }

    /**
     * Login Retail Second FO user.
     */
    public ArrayList loginSecondFORetail() {
        return loginSimulate(".FO.Retail.User2");
    }

    /**
     * Simulator to open new tab in browser.
     *
     * @return tabs of chrome browser
     */
    private ArrayList loginSimulate(String strUserName) {
        String uRL = "", userID = "", psswrd = "";
        uRL = (util.getYamlValue(Utilities.getYamlValue("environment") + strUserName + ".URL"));
        userID = (util.getYamlValue(Utilities.getYamlValue("environment") + strUserName + ".UserName"));
        psswrd = (util.getYamlValue(Utilities.getYamlValue("environment") + strUserName + ".Password"));

        return tabSwitch(uRL, userID, psswrd);
    }

    /**
     * Simulator to open new tab in browser.
     *
     * @return tabs of chrome browser
     */
    private ArrayList loginSimulator() {
        String uRL = "", userID = "", psswrd = "";
        uRL = (util.getYamlValue(Utilities.getYamlValue("environment") + ".URL"));
        userID = (util.getYamlValue(Utilities.getYamlValue("environment") + ".UserName"));
        psswrd = (util.getYamlValue(Utilities.getYamlValue("environment") + ".Password"));

        return tabSwitch(uRL, userID, psswrd);
    }

    /**
     * Return tabs in the browser for multiple/ different user logins.
     * @param uRL web application uRL
     * @param userID
     * @param psswrd
     * @return new tab/ tabs
     */
    private ArrayList<String> tabSwitch(String uRL, String userID, String psswrd){
        // to open new tab
        executeJs("window.open()");

        // to handle multiple tabs and switch between the tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // switches to new tab

        //navigate to Siebel URL.
        driver.manage().deleteAllCookies();
        driver.get(uRL);
        LoginToApplication(userID, psswrd);
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        return tabs;
    }

    public ArrayList<String> multiWindow(String uRL, String userID, String psswrd) {
		return tabSwitch(uRL, userID, psswrd);

        }
}
