/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2019-10-15
 *
 */
package com.ibm.Actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.ProfileServiceRequestUI;
import com.ibm.Utilities.AadharGenie;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.Utilities;

/**
 * The Class ProfileServiceRequestAction.
 */
public class ProfileServiceRequestAction extends BaseAction {
    /**
     * The profile SR page.
     */
    protected ProfileServiceRequestUI profileSRPage;

    /**
     * The contact tab.
     */
    protected ContactTabUI contactTab;

    /**
     * The home page.
     */
    protected HomePageUI homePage;

    /**
     * The Login action.
     */
    protected LoginActions loginAction;

    /**
     * The driver.
     */
    WebDriver driver;

    // Instance variables
    String transactionType, transactionSubType, SRNumber, SRStatusFO, check = "NotCheck", SRGrievance, aadhr, aadharRefNum;
    //boolean FOSRStat;
    /*
     * Name Change - Profile SR
     ******************************************************/
    String firstName, lastName;
    /*
     * Address Change - Profile SR
     ******************************************************/
    String strAddressLine1, strAddressLine2, strPreviousValueCity;


    /*
     * Seed Aadhar - Profile SR
     *****************************************************/
    /*
     * Email Change - Profile SR
     ******************************************************/
    String genEmail;

    /*
     * DeSeed Aadhar - Profile SR
     *****************************************************/
    String phoneNumber;

    /*
     * Seed Aadhar - Profile SR - Approval FO
     *******************************************/
    boolean boolExtractOTP;
    /*
     * Pin Code Change - Profile SR
     *************************************************/
    String oldPinCode;
    /*
     * COMMON Action Related Functions across Profile SR
     ****************************************************/
    String strMDMID;

    /**
     * Instantiates a new profile service request action.
     *
     * @param driver the driver
     */
    public ProfileServiceRequestAction(WebDriver driver) {
        super(driver);
        contactTab = new ContactTabUI(driver);
        profileSRPage = new ProfileServiceRequestUI(driver);
        homePage = new HomePageUI(driver);
        loginAction = new LoginActions(driver);
        this.driver = driver;
    }

    /******************************************************
     * Add the bank details profile SR.
     */
    public void AddBankDetailsProfileSR(String IFSCCode) {

        profileSRPage.txt_IFSCCode.sendKeys(IFSCCode);
        profileSRPage.txt_IFSCCode.sendKeys(Keys.TAB);
        /*profileSRPage.txt_IFSCCodeSearchIcon.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        profileSRPage.txt_IFSCCodeSearchResult.click();
        profileSRPage.btn_IFSCCodeOK.click();*/
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        profileSRPage.txt_AccountNumber.isDisplayed();
        String account = "";
        /*Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            account = account.concat("" + rand.nextInt(1000));
        }*/
        account = new AadharGenie().genAadhar();
        System.out.println("Account Number Entered : " + account);
        profileSRPage.txt_AccountNumber.sendKeys(account);
        profileSRPage.txt_AccountNumberReenter.sendKeys(account);
        profileSRPage.txt_AccountName.sendKeys("Test Automation");
        /*profileSRPage.btn_AttachmentsNew.click();
        profileSRPage.txt_AttachmentsIdentityType.sendKeys("POA-POI");
        profileSRPage.txt_AttachmentsIdentityType.sendKeys(Keys.TAB);
        profileSRPage.txt_AttachmentsIdentityMethod.sendKeys("Driving Licence");
        profileSRPage.txt_AttachmentsIdentityMethod.sendKeys(Keys.TAB);
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date date = new Date();
        dateFormat = new SimpleDateFormat("mmss");
        profileSRPage.txt_AttachmentsIdentityNumber.sendKeys("DL1D" + dateFormat.format(date));
        profileSRPage.txt_AttachmentsIdentityNumber.sendKeys(Keys.TAB);*/
        performSave();
    }

    public void seedAadhar() {
        String previousAadharValue;

        System.out.println(
                transactionType + " before status: " + profileSRPage.txt_ProfileSRStatus.getAttribute("value"));

        previousAadharValue = profileSRPage.txt_PreviousAadhar.getAttribute("value");
        if (previousAadharValue.isEmpty()) {
            System.out.println("Aadhar Seeding for First Time");
        } else {
            System.out.println("Aadhar seeding for more than one time");
        }

        // Generating new Aadhar number
		profileSRPage.txt_NewAadhar.click();
        profileSRPage.txt_NewAadhar.sendKeys(aadhar());
        profileSRPage.txt_NewAadhar.sendKeys(Keys.TAB);
        performSave();

        System.out.println("Generated Aadhar: " + aadhr);
    }

    /**
     * Profile SR deSeeding of aadhar.
     */
    public void deSeedAadhar() {
        aadharRefNum = profileSRPage.txt_AadharRefrenceNumber.getAttribute("value");
        //Enter previous saved aadhar number
        profileSRPage.txt_ReEnterNewAadhar.click();
        profileSRPage.txt_ReEnterNewAadhar.sendKeys(aadhr);
        profileSRPage.txt_ReEnterNewAadhar.sendKeys(Keys.TAB);
    }

    /**
     * FO decision to approve reject of Profile SR.
     *
     * @param btnApproveReject
     * @return
     */
    public String FODecision(String btnApproveReject) {
        //Login to FO.
        ArrayList<String> tabs = loginAction.loginFO();

        if (profileSRPage.get_nameInboxItem(SRNumber).isDisplayed()) {
            profileSRPage.get_nameInboxItem(SRNumber).click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();

            profileSRPage.get_btnApproveReject(btnApproveReject).click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();

            SRStatusFO = profileSRPage.txt_SRStatusFO.getAttribute("value");
        } else {
            LoggerWriter.logger.log(Status.FAIL,
                    "SR number not available under FO homescreen.");
        }

        driver.switchTo().window(tabs.get(0)); // switch back to main screen
        if (!profileSRPage.txt_SRStatus.getAttribute("value").equalsIgnoreCase("Closed")) {
            driver.navigate().refresh();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
        }
        // For function to return and use result in Validation check
        check = "Check";
        return check;
    }

    /**
     * Profile SR Name change.
     */
    public void NameChange() {
        this.firstName = "NameChangeTest" + printRandomString(5);
        this.lastName = "LastName";
        profileSRPage.txt_Salutation.sendKeys("Miss");
        profileSRPage.txt_FirstName.sendKeys(firstName);
        profileSRPage.txt_LastName.sendKeys(lastName);
    }

    /**
     * Verify name change amendments.
     */
    public void verifyAmendment() {
        profileSRPage.txt_RelationshipID.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        String fName = contactTab.txt_FirstName.getAttribute("value");
        String lName = contactTab.txt_RelationshipSearchLastName.getText();
        System.out.println("FIRSTNAME: " + fName);
        System.out.println("LASTNAME: " + lName);
        if (fName.equalsIgnoreCase(firstName) && lName.equalsIgnoreCase(lastName)) {
            LoggerWriter.logger.log(Status.PASS,
                    "Verification successful for consumer with new name: " + firstName + " " + lastName);
        } else {
            LoggerWriter.logger.log(Status.FAIL,
                    "Verification fail for consumer with old name: " + fName + " " + lName);
        }
    }

    /**
     * Verify name change amendments when name change for a second time.
     */
    public void verifyAmendmentSecondTimeNameChange() {
        profileSRPage.txt_RelationshipID.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        String fName = contactTab.txt_FirstName.getAttribute("value");
        String lName = contactTab.txt_RelationshipSearchLastName.getText();
        System.out.println("FIRSTNAME: " + fName);
        System.out.println("LASTNAME: " + lName);
        if (fName.equalsIgnoreCase(firstName) && lName.equalsIgnoreCase(lastName)) {
            LoggerWriter.logger.log(Status.FAIL,
                    "Verification fail. Consumer name changed in second try for consumer with Name: " +
                            firstName + " " + lastName);
        } else {
            LoggerWriter.logger.log(Status.PASS,
                    "Verification pass. Consumer name did not change in second try for consumer with Name: " +
                            fName + " " + lName);
        }
    }


    /*
     * Phone number Change - Profile SR
     *************************************************/

    /**
     * @return today's date time.
     */
    private String dateFormat() {
        String date = new SimpleDateFormat("ddMMYYYYHHmmss").format(new Date());
        return date;
    }

    /**
     * Profile SR address change.
     */
    public void addressChange() {
        String strPreviousValuePinCode = profileSRPage.txt_PreviousValuePinCode.getAttribute("value");
        strPreviousValueCity = profileSRPage.txt_previousValueCity.getAttribute("value");
        strAddressLine1 = "TA1" + dateFormat();
        strAddressLine2 = "TA2" + dateFormat();

        profileSRPage.txt_NewValuePinCode.click();
        profileSRPage.txt_NewValuePinCode.sendKeys(strPreviousValuePinCode);
        profileSRPage.txt_NewValuePinCode.sendKeys(Keys.TAB);
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        profileSRPage.txt_UrbanRural.click();
        profileSRPage.txt_UrbanRural.sendKeys("Urban");
        profileSRPage.txt_AddressLine1.click();
        profileSRPage.txt_AddressLine1.sendKeys(strAddressLine1);
        profileSRPage.txt_AddressLine1.sendKeys(Keys.TAB);
        profileSRPage.txt_AddressLine2.click();
        profileSRPage.txt_AddressLine2.sendKeys(strAddressLine2);
        profileSRPage.txt_AddressLine2.sendKeys(Keys.TAB);
        profileSRPage.txt_AddressLine3.click();
        profileSRPage.txt_AddressLine3.sendKeys("TA3" + dateFormat());
        profileSRPage.txt_AddressLine3.sendKeys(Keys.TAB);
        profileSRPage.txt_LandMark.click();
        profileSRPage.txt_LandMark.sendKeys("LM" + dateFormat());
        profileSRPage.txt_LandMark.sendKeys(Keys.TAB);
        profileSRPage.txt_City.click();
        profileSRPage.txt_City.sendKeys(strPreviousValueCity);
        profileSRPage.txt_City.sendKeys(Keys.TAB);
    }

    /**
     * @return random email id.
     */
    public String randomEmailGenerator() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Random 9 digits
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(9));
        }
        String s1 = sb.toString();
        String s2 = "ABC";

        return s2.concat(s1).concat("@gmail.com");
    }

    /**
     * Profile SR email change.
     *
     * @param env
     */
    public void emailChange(String env) {
        genEmail = randomEmailGenerator();
        profileSRPage.txt_NewEmailID.sendKeys(genEmail);

    }

    /**
     * Generates random phone number.
     *
     * @param firstDigit - first digit of phone number
     * @return random phone number.
     */
    public String randomPhoneNumber(String firstDigit) {
        // this.digit = digit;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Random 9 digit number
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(9));
        }
        String s1 = sb.toString();
        // String s2 = digit;
        for (int i = 0; i < 20; i++) {
            if ((firstDigit + s1).length() == 10) {
                break;
            } else {
                randomPhoneNumber(firstDigit);
            }
        }
        return firstDigit.concat(s1);
    }

    /**
     * To extract OTP from body of sms.
     *
     * @param strData - body format of sms.
     * @return
     */
    private String extractOTP(String strData) {
        String strMatch = "";
        if (strData.contains("OTP")) {
            strMatch = "OTP";
        } else if (strData.contains("is :")) {
            strMatch = "is :";
        }
        String[] newdata = strData.split(strMatch);
        String data = newdata[1];
        Pattern pattern = Pattern.compile("(\\d{4})");

        /*
         * \d is for a digit {} is the number of digits here 4.
         */

        Matcher matcher = pattern.matcher(data);
        String val = "";
        if (matcher.find()) {
            val = matcher.group(0); // 4 digit number
        }
        return val.replaceAll("//s+", "");
    }

    /**
     * Profile SR phone number change.
     */
    public void phoneNumberChange() {
        String queryPhoneOTP = "", queryOutput = "";
        String randomPhoneNumber = randomPhoneNumber("3");
        System.out.println("PHONE: "+randomPhoneNumber);
        this.phoneNumber = randomPhoneNumber;
        profileSRPage.txt_InputPhoneNumber.sendKeys(phoneNumber);
        profileSRPage.btn_GenerateOTP.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        int count = 0, count1 = 0;
        while (profileSRPage.txt_VerifyOTP.getAttribute("aria-readonly").equals("true")) {
            count++;
            expWait.waitLong((int) 0.25);
            if (count == 240) {
                System.out.println("Waited for " + (count * 0.25) + " seconds. Verify OTP textBox found non-editable.");
                LoggerWriter.logger.log(Status.FAIL, "Verify OTP textBox found non-editable.");
                break;
            }
        }

        if (profileSRPage.txt_VerifyOTP.getAttribute("aria-readonly").equals("false")) {
            do {
                count1++;
                queryPhoneOTP = "select x_generated_otp from siebel.s_srv_req where X_PHONE_NUM_NEW='"+phoneNumber+"'" +
                        " order by created desc FETCH first 1 ROWS only";
                queryOutput = connectSiebelDBToExtractData(queryPhoneOTP);
                // In case query output is null for 1st sql query.
                if (queryOutput.isEmpty()) {
                    // Set boolExtractOTP = true, to pass this value to next method
                    boolExtractOTP = true;
                    queryPhoneOTP = "select SMS_CONTENT from OUTGOING_SMS  where MOBILE_NO = '" + phoneNumber
                            + "' order by DATE_SENT desc FETCH first 1 ROWS only";
                    queryOutput = connectDBForPhoneNumberOTP(queryPhoneOTP);
                }
                if (count1 == 3) {
                    break;
                }
            } while (queryOutput.isEmpty());

            System.out.println("OTP: " + queryOutput);
            if (queryOutput.isEmpty()) {
                LoggerWriter.logger.log(Status.FAIL, "OTP found null in DB.");
                Assert.assertNotEquals(null, queryOutput, "OTP found null in DB.");
            } else {
                System.out.println("PhoneNumber: " + phoneNumber + " with OTP: "
                        + queryOutput + " was used.");
                LoggerWriter.logger.log(Status.INFO, "PhoneNumber: " + phoneNumber + " with OTP: "
                        + queryOutput + " was used.");
                profileSRPage.txt_VerifyOTP.sendKeys(queryOutput);
                profileSRPage.btn_VerifyOTP.click();
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();
            }

        }

    }


    /* MDM UI Action Functions ***************************************************/

    /**
     * Profile SR pin code change.
     */
    public void pinCodeChange() {
        oldPinCode = profileSRPage.txt_PreviousValuePinCode.getAttribute("value");
        profileSRPage.txt_NewValuePinCode.click();
        profileSRPage.txt_NewValuePinCode.sendKeys(oldPinCode);
        profileSRPage.txt_NewValuePinCode.sendKeys(Keys.TAB);
        expWait.waitForDomToLoad();
        homePage.waitLong(5);
    }


    /* COMMON Functions ***************************************************/

    /**
     * Verification under MDM system.
     *
     * @param strMDMVerify
     */
    public void verifyMDM(String strMDMVerify) {
        String uRL = "", userID = "", psswrd = "";

        uRL = (Utilities.getYamlValue(Utilities.getYamlValue("environment") + ".MDM.URL"));
        userID = (Utilities.getYamlValue(Utilities.getYamlValue("environment") + ".MDM.UserName"));
        psswrd = (Utilities.getYamlValue(Utilities.getYamlValue("environment") + ".MDM.Password"));

        // to open new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");
        // to handle multiple tabs and switch between the tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // switches to new tab
        //navigate to MDM url
        driver.get(uRL);
        new LoginActions(driver).LoginToApplication(userID, psswrd);
        //new LoginActions(driver).clickOnSighInButton();
        // new HomePageActions(driver).verifyHomePageDisplay();

        expWait.waitForHomePageSipperToDisapper();
        Assert.assertTrue(profileSRPage.tab_Contacts.isDisplayed());

        profileSRPage.tab_Contacts.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        profileSRPage.lnk_AllContacts.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        profileSRPage.btn_queryContact.click();
        expWait.waitForDomToLoad();

        profileSRPage.txtBox_UCMiD.click();
        expWait.waitForDomToLoad();
        System.out.println("MDM ID: " + strMDMID);
        profileSRPage.txtBox_UCMiD.findElement(By.tagName("input")).sendKeys(strMDMID);
        profileSRPage.txtBox_UCMiD.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        profileSRPage.btn_SearchContactsQuery.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        profileSRPage.lnk_LastName.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        switch (strMDMVerify.toLowerCase()) {
            case "name":
                String strMDMFirstName = profileSRPage.txt_MDMFirstName.getAttribute("value");
                String strMDMLastName = profileSRPage.txt_MDMLastName.getAttribute("value");
                if (firstName.contentEquals(strMDMFirstName) && lastName.contentEquals(strMDMLastName)) {
                    LoggerWriter.logger.log(Status.PASS, "Name in Siebel: " + firstName + " " + lastName + " and MDM: "
                            + strMDMFirstName + " " + strMDMLastName + " are same.");
                } else {
                    LoggerWriter.logger.log(Status.FAIL, "Name in Siebel: " + firstName + " " + lastName + " and MDM: "
                            + strMDMFirstName + " " + strMDMLastName + " are not same.");
                }
                break;
            case "phone":
                String strMDMPhone = profileSRPage.txt_MDMPhone.getAttribute("value");
                if (phoneNumber.contentEquals(strMDMPhone)) {
                    LoggerWriter.logger.log(Status.PASS,
                            "Phone number in Siebel: " + phoneNumber + " and MDM: " + strMDMPhone + " are same.");
                } else {
                    LoggerWriter.logger.log(Status.FAIL,
                            "Phone number in Siebel: " + phoneNumber + " and MDM: " + strMDMPhone + " are not same.");
                }
                break;
            case "email":
                String strMDMEmail = profileSRPage.txt_MDMEmail.getAttribute("value");
                if (genEmail.contentEquals(strMDMEmail)) {
                    LoggerWriter.logger.log(Status.PASS,
                            "Email in Siebel: " + genEmail + " and MDM: " + strMDMEmail + " are same.");
                } else {
                    LoggerWriter.logger.log(Status.FAIL,
                            "Email in Siebel: " + genEmail + " and MDM: " + strMDMEmail + " are not same.");
                }
                break;
            case "pincode":
                String strMDMZipCode = profileSRPage.txt_MDMZipCode.getAttribute("value");
                if (oldPinCode.contentEquals(strMDMZipCode)) {
                    LoggerWriter.logger.log(Status.PASS,
                            "ZipCode in Siebel: " + oldPinCode + " and MDM: " + strMDMZipCode + " are same.");
                } else {
                    LoggerWriter.logger.log(Status.FAIL,
                            "ZipCode in Siebel: " + oldPinCode + " and MDM: " + strMDMZipCode + " are not same.");
                }
                break;
            case "address":
                String strMDMAddressLine1 = profileSRPage.txt_MDMAddressLine1.getAttribute("value");
                String strMDMAddressLine2 = profileSRPage.txt_MDMAddressLine2.getAttribute("value");
                String strMDMCity = profileSRPage.txt_MDMCity.getAttribute("value");
                if (strPreviousValueCity.contentEquals(strMDMCity) && strAddressLine1.contentEquals(strMDMAddressLine1)
                        && strAddressLine2.contentEquals(strMDMAddressLine2)) {
                    LoggerWriter.logger.log(Status.PASS, "Address in Siebel and MDM are same.");
                } else {
                    LoggerWriter.logger.log(Status.FAIL, "Address in Siebel and MDM are not same.");
                }
                break;
            case "aadhar":
                contactTab.isTabDisplayInTabList("Identities");
                profileSRPage.btn_QueryIdentities.click();
                expWait.waitForDomToLoad();
                profileSRPage.txtBox_IdentityNumber.click();
                profileSRPage.txtBox_IdentityNumber.findElement(By.tagName("input"))
                        .sendKeys(aadharRefNum);
                profileSRPage.btn_GoQueryIdentities.click();
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();
                String identityStatus = profileSRPage.txtBox_IdentityStatus.getAttribute("textContent");

                if (identityStatus.isEmpty()) {
                    performAltEnter();
                    expWait.waitForDomToLoad();
                }

                if (identityStatus.equalsIgnoreCase("Inactive")) {
                    LoggerWriter.logger.log(Status.PASS, "Aadhar Status is Inactive as expected.");
                } else {
                    LoggerWriter.logger.log(Status.FAIL, "Aadhar Status is not Inactive.");
                }
        }
    }

    /* Select Transaction Type under Service Request List Applet */
    public void selectTransactionType(String transactionType) {
        this.transactionType = transactionType;
        profileSRPage.btn_NewServiceRequestPlus.click();
        try {
            profileSRPage.txt_TransactionType.isDisplayed();
        } catch (Exception e) {
            System.out.println("Transaction_Type_not_displayed: " + e.getMessage());
        }
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        expWait.waitForDomToLoad();
        profileSRPage.txt_TransactionType.click();
        profileSRPage.txt_TransactionType.findElement(By.tagName("input")).sendKeys(transactionType);
        profileSRPage.txt_TransactionType.findElement(By.tagName("input")).sendKeys(Keys.TAB);
    }

    /* Select Transaction SubType under Service Request List Applet */
    public void selectTransactionSubType(String transactionSubType) {
        this.transactionSubType = transactionSubType;
        try {
            profileSRPage.txt_TransactionSubType.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        expWait.waitForDomToLoad();
        profileSRPage.txt_TransactionSubType.click();
        profileSRPage.txt_TransactionSubType.findElement(By.tagName("input")).sendKeys(transactionSubType);
        profileSRPage.txt_TransactionSubType.findElement(By.tagName("input")).sendKeys(Keys.TAB);
    }

    /* Store UCMID from INFO Tab */
    public void getMDMUID() {
        profileSRPage.get_LowerTabLevel("More Info").click();
        strMDMID = profileSRPage.txt_MDMUID.getAttribute("value").trim().replaceAll("//s+", "");
        System.out.println("MDM_UID: " + strMDMID);
    }

    /* Drill Down SRNumber under Service Request List Applet */
    public void drillDownSRNumber() {
        SRNumber = profileSRPage.lnk_SRNumber.getText().trim().replaceAll("//s+", "");
        System.out.println("SR NUMBER: " + SRNumber);
        profileSRPage.lnk_SRNumber.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    /* Submit SR Button */
    public void submitSR() {
        int count = 0;
        do {
            count++;
            profileSRPage.btn_SubmitSR.click();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();

            System.out.println("SUBMIT_BUTTON_Status: " + profileSRPage.btn_SubmitSR.getAttribute("disabled"));

            if (profileSRPage.btn_SubmitSR.getAttribute("disabled").equalsIgnoreCase("true")) {
                break;
            } else if (count == 3) {
                System.out.println("Tried Submit_SR for three times!");
                break;
            }
        } while (profileSRPage.btn_SubmitSR.isEnabled());
    }

    /* Submit Button Click */
    public void submitSRVerifyOMCDedup() {
        String txtStatusReasonCodeBPC = null, txtStatusReasonCodeHPC = null;
        int count = 0, systemWait = 40;
        do {
            count++;
            if (profileSRPage.txt_ProfileSRStatus.getAttribute("value").equals("Open") &&
                    profileSRPage.btn_SubmitSR.isEnabled() &&
                    profileSRPage.txtArea_SR_Remarks.getAttribute("value").isEmpty()) {

                profileSRPage.btn_SubmitSR.click();
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();

                //verify alert popup presence
                alertVerificationAndAcceptAlert(5);

                profileSRPage.get_LowerTabLevel("Dedup Response").click();
                expWait.waitForHomePageSipperToDisapper();
                expWait.waitForDomToLoad();

                txtStatusReasonCodeBPC = profileSRPage.txt_StatusReasonCodeBPC.getAttribute("textContent");
                txtStatusReasonCodeHPC = profileSRPage.txt_StatusReasonCodeHPC.getAttribute("textContent");
                System.out.println("StatusReasonCodeBPC: " + txtStatusReasonCodeBPC);
                System.out.println("StatusReasonCodeHPC: " + txtStatusReasonCodeHPC);

                /*Ask Siebel Dev team in case you require
                to change the system wait time used below*/
                if (count > 1) {
                    expWait.waitLong(systemWait);
                }
            }

            if (count == 4) {
                System.out.println("SR submission failed after " + count + " times with wait time of "
                        + systemWait + " in each iteration.");
                LoggerWriter.logger.log(Status.FAIL, "SubmitSR failed " + count + " times. " +
                        "OMC DeDup failed due to Technical Error");
                Assert.assertNotEquals(txtStatusReasonCodeBPC, "Technical Error", "OMC_DeDup failure");
                Assert.assertNotEquals(txtStatusReasonCodeHPC, "Technical Error", "OMC_DeDup failure");
                break;
            }

        } while (txtStatusReasonCodeBPC.contains("Technical Error")
                || txtStatusReasonCodeHPC.contains("Technical Error"));
    }

    /* Verify Profile SR status under Service Request List Applet */
    public void verifySRStatus(String SRStat) {
        String SRStatus = profileSRPage.txt_ProfileSRStatus.getAttribute("value");
        if (!SRStat.equals(SRStatus)) {
            performRefresh();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
        }

        expWait.waitLong(1);
        SRStatus = profileSRPage.txt_ProfileSRStatus.getAttribute("value");

        if (transactionSubType == null) {
            System.out.println(transactionType + " after status: " + SRStatus);
        } else {
            System.out.println(transactionType + " status for " + transactionSubType + " : " + SRStatus);
        }

		//when aadhar seeding fail
        if(!SRStat.equals(SRStatus)){
            System.out.println("AadharEntryWasDeletedFromSystemEnv!!");
            deleteAadharEnvVariableEntry();
        }

        /*Validate SR Status in Siebel process*/
        Assert.assertTrue(SRStatus.equals(SRStat),
                "Expected SR status: *" + SRStat + "* and Actual SR status: *" + SRStatus + "*");

        /*Validate SR status in case of FO decision*/
        if (check.equalsIgnoreCase("NotCheck")) {
            System.out.println("FO status check not required.");
        } else {
            Assert.assertEquals(SRStatusFO, SRStatus);
        }

        if (transactionSubType == null) {
            LoggerWriter.logger.log(Status.PASS, "TransactionType: " + transactionType);
        } else {
            LoggerWriter.logger.log(Status.PASS, "TransactionType: " + transactionType
                    + " and TransactionSubType: " + transactionSubType);
        }
    }

    /* Add attachment before submit */
    public void addAttachment() {
        String identityType = "POA-POI";
        String identityMethod = "Voter Identity Card";
        String identityNumber = new AadharGenie().genAadhar(); // random number feed
        profileSRPage.btn_AttachmentsNew.click();
        profileSRPage.txt_IdentityType.isDisplayed();
        profileSRPage.txt_IdentityType.click();
        profileSRPage.txt_IdentityType.sendKeys(identityType);
        profileSRPage.txt_IdentityType.sendKeys(Keys.TAB);
        profileSRPage.txt_IdentityMethod.sendKeys(identityMethod);
        profileSRPage.txt_IdentityMethod.sendKeys(Keys.TAB);
        profileSRPage.txt_IdentityNumber.sendKeys(identityNumber);
        profileSRPage.txt_IdentityNumber.sendKeys(Keys.TAB);
        performSave();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        expWait.waitLong(1);
    }

    /*Navigate back iterations.*/
    public void navigateBack(int numberOfTimes) {
        navigateBackIterations(numberOfTimes);
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

	/**
     * Adds the attachment for aadhar.
     *
     * @param identityType the identity type
     */
    public void addAttachmentForProfileSR(String identityType, String randomParameter) {
        profileSRPage.btn_AttachmentsNew.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        profileSRPage.txt_AttachmentsIdentityType.sendKeys("POA-POI");
        profileSRPage.txt_AttachmentsIdentityType.sendKeys(Keys.TAB);
        profileSRPage.txt_AttachmentsIdentityMethod.sendKeys(identityType);
        profileSRPage.txt_AttachmentsIdentityMethod.sendKeys(Keys.TAB);
        profileSRPage.txt_AttachmentsIdentityNumber.sendKeys(new AadharGenie().genAadhar());
        profileSRPage.txt_AttachmentsIdentityNumber.sendKeys(Keys.TAB);

        //Save and Refresh.
        performSave();
        performRefresh();

        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        for (int i = 0; i < 20; i++) {
            if (profileSRPage.get_identitiesMethodRow(identityType).getAttribute("class").contains("state-highlight")) {
                break;
            } else {
                expWait.waitForDomToLoad();
                expWait.waitForHomePageSipperToDisapper();
            }
        }

        //Switching to Attachment Frame.
        //ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[contains(@title,'Manage SR Attachments')]//iframe"));
        ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//*[contains(@title,'Manage SR Attachments')]//iframe")));
        //driver.switchTo().frame((WebElement) driver.findElement(By.xpath("//*[contains(@title,'Manage SR Attachments')]//iframe")));
        expWait.waitLong(4);
        driver.findElement(By.xpath("//a[text()='New']")).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        String parentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        expWait.waitForDomToLoad();
        expWait.waitForDomToLoad();

        //Attaching a .jpg file for Profile SR mandatory attachment.
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(new UjvalaCustomerOnboardingActions(driver).get_AttachFilePath());
        expWait.waitForDomToLoad();
        expWait.waitForDomToLoad();
        driver.findElement(By.xpath("//input[@value='Check In']")).click();
        expWait.waitForDomToLoad();
        expWait.waitForDomToLoad();
        driver.findElement(By.xpath("//*[@value='Additional Attachments']")).isDisplayed();
        driver.close();

        driver.switchTo().window(parentWindow);
        driver.switchTo().defaultContent();
        performRefresh();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        /*profileSRPage.get_identitiesMethodRow(identityType).click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        for (int i = 0; i < 20; i++) {
            if (profileSRPage.get_identitiesMethodRow(identityType).getAttribute("class").contains("state-highlight")) {
                break;
            } else {
                expWait.waitForDomToLoad();
                expWait.waitForHomePageSipperToDisapper();
            }
        }
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();*/
    }


    /**
     * Attachment to Profile SR.
     *
     * @param identityType aadhar or passport, etc.
     */
    public void addAttachmentForProfileSR(String identityType) {
        String identityNumValue="";
        profileSRPage.btn_AttachmentsNew.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        profileSRPage.txt_AttachmentsIdentityType.sendKeys("POA-POI");
        profileSRPage.txt_AttachmentsIdentityType.sendKeys(Keys.TAB);

        System.out.println("ValueOfAadharInEnvVariable: "+System.getProperty("aadhar"));

        if (System.getProperty("aadhar") == null || System.getProperty("aadhar").length()==0) {
            identityType = "National Food Security Act Car";
            identityNumValue = new AadharGenie().genAadhar();
            System.out.println("IdentityNumValue: "+identityNumValue);
        } else {
            identityNumValue = System.getProperty("aadhar");
            System.out.println("SystemAadhar: "+identityNumValue);
        }

        profileSRPage.txt_AttachmentsIdentityMethod.sendKeys(identityType);
        profileSRPage.txt_AttachmentsIdentityMethod.sendKeys(Keys.TAB);
        profileSRPage.txt_AttachmentsIdentityNumber.sendKeys(identityNumValue);
        profileSRPage.txt_AttachmentsIdentityNumber.sendKeys(Keys.TAB);

        //Save and Refresh.
        performSave();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        //performRefresh();

        profileSRPage.btn_FileUpload.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //Upload jpf file
        profileSRPage.btn_ChooseFile.sendKeys(System.getProperty("user.dir")
                + Utilities.getYamlValue("jpgFilePath"));
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        profileSRPage.btn_UploadFile.click();
        alertVerificationAndAcceptAlert(15);
        alertVerificationAndAcceptAlert(10);
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

	/*
     * COMMON functions
     *************************************************/

    public String aadhar() {
        aadhr = new AadharGenie().genAadhar();
        System.setProperty("aadhar", aadhr);
        return aadhr;
    }

    public void deleteAadharEnvVariableEntry(){
        System.setProperty("aadhar", "");
    }

    /*
     * SR - Grievance
     *************************************************/

    /**
     * Launch Service Requests tab.
     */
    public void launchServiceRequestTab() {
        contactTab.isTabDisplayInMainTabList("Service Requests");
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Click plus button to raise new grievance.
     */
    public void raiseNewGrievance() {
        profileSRPage.btn_RaiseNewGrievancePlus.isDisplayed();
        profileSRPage.btn_RaiseNewGrievancePlus.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        //profileSRPage.btn_SubmitNewGrievance.isDisplayed();
    }

    /**
     * To search for consumer Id under new grievance service request.
     */
    public void inputConsumerId(String relNumber) {
        for (int i = 0; i < 5; i++) {
            profileSRPage.txtBox_ConsumerId
                    .findElement(By.xpath("following-sibling::span")).click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
            if (driver.findElement(By.xpath("//*[@title='Pick Consumer List Applet']//button[@aria-label='Pick Consumer:Query']")).isDisplayed()) {
                break;
            } else {
                driver.navigate().refresh();
                expWait.waitForDomToLoad();
            }
        }
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        profileSRPage.txtBox_InputConsumerId.sendKeys(relNumber);
        profileSRPage.btn_SearchConsumerID.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        try {
            profileSRPage.btn_OKConsumerIDResult.click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
        } catch (Exception e) {
            System.out.println("InputConsumerID_Exception: " + e.toString());
        }
        expWait.waitForDomToLoad();
    }

    /**
     * Verify presence of mobile number and input into UI field if absent.
     */
    public void inputMobileNumber() {
        String valueMobileNumber = profileSRPage.txtBox_MobileNumber.getAttribute("value");
        if (valueMobileNumber.isEmpty()) {
            String newMobileNumber = randomPhoneNumber("4");
			expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
            profileSRPage.txtBox_MobileNumber.sendKeys(newMobileNumber);
        }
    }

    /**
     * Input SR category.
     */
    public void inputSRCategories() {
        profileSRPage.img_SRCategory.isDisplayed();
        profileSRPage.img_SRCategory.click();
        expWait.waitForDomToLoad();

        profileSRPage.btn_ServiceReqCategoryPlus.click();
        expWait.waitForDomToLoad();

        profileSRPage.txtBox_Category.sendKeys("Service Related");
        profileSRPage.txtBox_Category.sendKeys(Keys.TAB);

        profileSRPage.txtBox_SubCategory.sendKeys("Showroom closed on working day");
        profileSRPage.btn_OKServiceReqCategory.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Input Grievance Description.
     */
    public void inputGrievanceDescription() {
        profileSRPage.txtArea_GrievanceDescription.
                sendKeys("AUTOMATED_SCRIPT_WRITING_IN_TEXT_AREA_OF_GRIEVANCE_DESCRIPTION");
    }

    /**
     * Submit Description after filling mandatory details.
     */
    public void submitGrievance() {
        SRGrievance = profileSRPage.txt_SRGrievanceNumber.getAttribute("value");
        System.out.println("Grievance Status before submit: " + SRGrievance);
        profileSRPage.btn_SubmitNewGrievance.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * To search the Grievance SR Number.
     */
    public void searchGrievanceSRNumber() {
        /*contactTab.isTabDisplayInMainTabList("Service Requests");
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();*/

        profileSRPage.btn_QueryServiceRequest.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        profileSRPage.txt_SRGrievanceNumber.sendKeys(SRGrievance);
        profileSRPage.txt_SRGrievanceNumber.sendKeys(Keys.ENTER);

        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    /**
     * Drill Down new SR raised for Grievance.
     */
    public void drillDownSRGrievance() {
        profileSRPage.getNewSRHyperLink(SRGrievance).click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Input Resolution Remarks.
     */
    public void inputResolutionRemarks() {
        int count = 0;
        while (!((profileSRPage.txt_SRGrievanceSubStatus.
                getAttribute("value").toLowerCase()).contains("partner"))) {
            count++;
            driver.navigate().refresh();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();

            if (((profileSRPage.txt_SRGrievanceSubStatus.
                    getAttribute("value").toLowerCase()).contains("partner"))) {
                break;
            } else if (count == 5) {
                break;
            }
        }
        profileSRPage.txtArea_ResolutionRemark.
                sendKeys("AUTOMATED_SCRIPT_WRITING_IN_TEXT_AREA_OF_RESOLUTION_REMARKS_UNDER_DISTRIBUTOR");
        profileSRPage.txtArea_ResolutionRemark.sendKeys(Keys.TAB);
        expWait.waitForDomToLoad();
    }

    /**
     * Input Resolution Remarks.
     */
    public void clickResolveButton() {
        profileSRPage.btn_Resolve.isEnabled();
        profileSRPage.btn_Resolve.click();
        homePage.waitLong(10);
        //if (expWait.isAlertPresent()) {
        try {
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }



    /*
     COMMON FUNCTIONS - SR - Grievance*************************************************/

    /**
     * Grievance Status.
     */
    public void grievanceStatus(String grievanceStat) {
        String grievanceStatus = profileSRPage.txt_SRGrievanceStatus.getAttribute("value");
        System.out.println("GrievanceStatus: " + grievanceStatus + " compared to " + grievanceStat);
        Assert.assertEquals(grievanceStatus, grievanceStat, "Comparing Grievance Status");
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Grievance Sub Status.
     */
    public void grievanceSubStatus(String grievanceSubStat) {
        String grievanceSubStatus = profileSRPage.txt_SRGrievanceSubStatus.getAttribute("value");
        System.out.println("GrievanceStatus: " + grievanceSubStatus + " compared to " + grievanceSubStat);
        Assert.assertEquals(grievanceSubStatus, grievanceSubStat, "Comparing Grievance Status");
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * FO Grievance Actions.
     */
    public void FODecisionGrievance() {
        //Login to FO.
        @SuppressWarnings("unchecked")
		ArrayList<String> tabs = loginAction.loginFO();

        profileSRPage.get_nameInboxItem(SRGrievance).isDisplayed();
        profileSRPage.get_nameInboxItem(SRGrievance).click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        profileSRPage.btn_ResolveFO.isEnabled();
        profileSRPage.txtArea_ResolutionRemark.
                sendKeys("AUTOMATED_SCRIPT_WRITING_IN_TEXT_AREA_OF_RESOLUTION_REMARKS_UNDER_FO");
        profileSRPage.txtArea_ResolutionRemark.sendKeys(Keys.TAB);
        homePage.waitLong(2);
        profileSRPage.btn_ResolveFO.click();
        homePage.waitLong(5);
        try {
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        driver.switchTo().window(tabs.get(0)); // switch back to main screen
        expWait.waitForDomToLoad();
        if (!profileSRPage.txt_SRGrievanceStatus.getAttribute("value")
                .equalsIgnoreCase("Resolved")) {
            driver.navigate().refresh();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
        }
    }

    /**
     * Grievance Status Validations.
     */
    public void grievanceValidation() {
        String grievanceStatus = profileSRPage.txt_SRGrievanceStatus.getAttribute("value");
        String grievanceSubStatus = profileSRPage.txt_SRGrievanceSubStatus.getAttribute("value");
        Assert.assertEquals(grievanceStatus, "Resolved", "Validate Grievance Status");
        Assert.assertEquals(grievanceSubStatus, "Final Resolution", "Validate Grievance Sub Status");
        LoggerWriter.logger.log(Status.PASS, "Grievance status stands RESOLVED with Sub Status as Final Resolution");
    }

    /**
     * Grievance Status Validation Resolved Date.
     */
    public void grievanceValidationResolveDate() {
        String grievanceResolvedDate = profileSRPage.txt_SRGrievanceResolvedDate.getAttribute("value");
        if (grievanceResolvedDate.isEmpty()) {
            LoggerWriter.logger.log(Status.FAIL, "Resolved Date is NOT populated after approval from FO");
        } else {
            LoggerWriter.logger.log(Status.PASS, "Resolved Date is populated after approval from FO");
        }
    }

    /*
     * COMMON DB Functions across Profile SR
     ************************************************/

    /**
     * To get the body of SMS from DB.
     * @param dbQuery sql query as input
     * @return otp
     */
    public String connectDBForPhoneNumberOTP(String dbQuery) {
        String otp = connectFMWDBToExtractOTP(dbQuery);
        if (boolExtractOTP) {
            otp = extractOTP(otp);
        }
        return otp;
    }

    /*
     * To update all the Profile SR status for a relationship
     */
    public void connectDBToUpdateAllSRStatusToClose(String relationshipID) {
        String dbQuery = "update Siebel.s_srv_req set sr_stat_id='Closed' where X_REL_ROW_ID in "
                + "(select ROW_ID from siebel.s_org_ext where integration_id = '" + relationshipID + "')";
        connectSiebelDBToExecuteUpdateQuery(dbQuery);
    }
}
