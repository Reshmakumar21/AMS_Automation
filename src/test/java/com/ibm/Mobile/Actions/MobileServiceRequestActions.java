package com.ibm.Mobile.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.ibm.Actions.BaseAction;
import com.ibm.Actions.LoginActions;
import com.ibm.Actions.ProfileServiceRequestAction;
import com.ibm.Mobile.UI.MobileUI;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.PortalUI;
import com.ibm.UI.ProfileServiceRequestUI;
import com.ibm.Utilities.SeleniumWait;
import com.ibm.automation.DBConnection;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileServiceRequestActions extends BaseAction {
	

	
    protected MobileUI mobileUI;
    
    protected DBConnection DBconnection;
    /**
     * The contact tab.
     */
    protected HomePageUI homePage;
    /**
     * The Login action.
     */
    protected LoginActions loginAction;
    /**
     * The contact tab.
     */
    protected ContactTabUI contactTab;
    /**
     * The profile SR page.
     */
    protected ProfileServiceRequestUI profileSRPage;
    /**
     * The ProfileServiceRequestAction.
     */
    protected ProfileServiceRequestAction profileSR;

    public MobileServiceRequestActions(WebDriver driver) {
		super(driver);
	        mobileUI = new MobileUI(driver);
	        homePage = new HomePageUI(driver);
	        contactTab = new ContactTabUI(driver);
	        loginAction = new LoginActions(driver);
	        profileSR = new ProfileServiceRequestAction(driver);
	        profileSRPage = new ProfileServiceRequestUI(driver);
	        this.driver = driver;
	    }
		// TODO Auto-generated constructor stub
	

    

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;
    /**
	 * Instantiates a new login page UI.
	 *
	 * @param driver the driver
     * @return 
	 */
	public void MobileUI(WebDriver driver) {
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}
    
    /**
     * new phone number generated.
     */
    String phoneNumber;
    
    public void inputValueOfServiceRequest(String valueOfServiceRequest) {
        mobileUI.AddMobileNo().sendKeys(valueOfServiceRequest);
    }
	
	/**
     * Customer Input new Mobile number.
     */
    public void customerInputNewMobileNumber() {
        phoneNumber = profileSR.randomPhoneNumber("7");
        System.out.println("MOBILE_NUMBER: " + phoneNumber);
        inputValueOfServiceRequest(phoneNumber);
    }
    
    /**
     * Customer input the OTP received in the updated mobile number.
     */
    public void inputOTPForNewMobileNumber() {
        String dbQuery = "Select OTP from OTP_MANAGEMENT where MOBILENUMBER = '" + phoneNumber
                + "' order by GENERATETIME desc FETCH first 1 ROWS only";

        insertOTP(dbQuery);
    }
    /**
     * Inserting OTP value.
     */
    public void insertOTP(String dbQuery){
        //store otp from db.
        String otp = connectFMWDBToExtractOTP(dbQuery);
        System.out.println("OTP: " + otp);
        mobileUI.EnterOTP().sendKeys(otp);

        
    }


}
