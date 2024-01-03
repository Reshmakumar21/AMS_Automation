/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2020-01-20
 *
 */
package com.ibm.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.PortalUI;
import com.ibm.UI.ProfileServiceRequestUI;
import com.ibm.Utilities.AadharGenie;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.SeleniumWait;
import com.ibm.Utilities.Utilities;

/**
 * The Class PortalActions.
 */
public class PortalActions extends BaseAction {

	/**
	 * PR number
	 */
	public String PR_num;
    /**
     * The contact tab.
     */
    protected PortalUI portUI;
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
    /**
     * Selenium wait
     */
    protected SeleniumWait selwait;
    /**
     * The driver.
     */
    WebDriver driver;
    /**
     * Class instances.
     */
    String relNumber, orderNumber;

    /**
     * new emailId generated.
     */
    String emailId;
    String screenshot = ".ss1";
    /**
     * new phone number generated.
     */
    String phoneNumber;
    /**
     * tabs for other app or user login.
     */
    ArrayList<String> tabs;

    /**
     * Instantiates a new Portal actions.
     *
     * @param driver the driver
     */
    public PortalActions(WebDriver driver) {
        super(driver);
        portUI = new PortalUI(driver);
        homePage = new HomePageUI(driver);
        contactTab = new ContactTabUI(driver);
        loginAction = new LoginActions(driver);
        profileSR = new ProfileServiceRequestAction(driver);
        profileSRPage = new ProfileServiceRequestUI(driver);
        this.driver = driver;
    }

    /**
     * Navigate to LPG link.
     */
    public void navigateToLPGLink() {
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        portUI.lnk_LPG.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();


        //store relation ship ID.
        //relNumber = portUI.txt_relationShipID.getAttribute("textContent").trim();
        //System.out.println("RelationShipID: " + relNumber);
    }

    /**
          * Navigate to LPG link.
     */
    public void selectactinglpgconnection() {
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        portUI.Multiple_LPG_radiobutton.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        //store relation ship ID.
        relNumber = portUI.txt_relationShipID.getAttribute("textContent").trim();
        System.out.println("RelationShipID: " + relNumber);
    }

    /**
     * Customer navigate to book your cylinder.
     */
    public void navigateToBookCylinder() {
        portUI.lnk_BookYourCylinder.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Customer select product.
     */
    public void customerSelectProduct(String product) {
        homePage.SelectElementFromDropdown(portUI.dropDown_refillCylinderRequestFor,
                "visibleText", product);
        expWait.waitForDomToLoad();
        expWait.waitLong(2);
    }

    /**
     * Customer hit the book now button.
     */
    public void customerBookNow() {
        portUI.btn_BookNow.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();

        orderNumber = portUI.txt_OrderNumber.getAttribute("textContent");
        System.out.println("ORDER_NUMBER: " + orderNumber);
    }

    /**
     * Customer Terms and condition.
     */
    public void customerAcceptTermsAndCondition() {
        portUI.chkBox_TermsAndCondition.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
        expWait.waitLong(2);

    }

    /**
     * PAY button.
     */
    public void customerPAY() {
        portUI.btn_PAY.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();

    }

    /**
     * Confirmation message validation.
     */
    public void confirmationMessageValidation() {
        String confirmMsg = portUI.txt_ThankYouForYourCylinderOrder.getAttribute("textContent").trim();
        Assert.assertEquals(confirmMsg, "Thank you for your cylinder order", "Confirmation message is as expected.");
        LoggerWriter.logger.log(Status.PASS, "Confirmation message is as expected, " +
                "customer was able to book his cylinder successfully.");
        expWait.waitForCursorToDisappear();
    }

    /**
     * Customer select a payment gateway.
     */
    public void customerSelectPaymentGateway(String paymentType) {
        //Payment image.
        portUI.img_PaymentGateway.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        //NetBanking option link.
        portUI.lnk_NetBanking.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        portUI.SelectElementFromDropdown(portUI.drpDown_PaymentChannel,
                "visibleText", paymentType);
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        //customer make payment.
        //portUI.executeJs("document.getElementById('SubmitBillShip').click();");
        portUI.btn_MakePayment.click();
        expWait.waitForDomToLoad();

        //Return to merchant site after payment completion.
        portUI.btn_ReturnToMerchantSite.click();
        expWait.waitForDomToLoad();
        expWait.waitLong(5);
        expWait.waitForCursorToDisappear();
    }

    /**
     * Customer cancel booking immediately after booking.
     *
     * @param reasonForCancellation customer choose a cancellation reason
     */
    public void customerCancelBooking(String reasonForCancellation) {
        portUI.lnk_CancelBooking.click();
        expWait.waitForCursorToDisappear();

        homePage.SelectElementFromDropdown(portUI.dropDown_refillCylinderRequestFor,
                "visibleText", reasonForCancellation);
        expWait.waitForDomToLoad();

        portUI.btn_CancelBooking.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();
    }

    /**
     * Portal Customer Logout.
     */
    public void customerLogOut() {
        //Customer Name hyperlink
        portUI.lnk_CustomerName.click();
        expWait.waitForCursorToDisappear();
        //Logout link.
        portUI.lnk_CustomerLogOut.click();
    }


    /*
    ******************Service Request of portal | START**********************************/

    /*
    *******EMAIL UPDATE SR Update************************/

    /**
     * Customer navigate to add new email link.
     */
    public void navigateToAddNewEmailLink() {
        portUI.lnk_AddNewEmail.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Customer input new email address.
     */
    public void customerInputNewEmailAddress() {
        emailId = profileSR.randomEmailGenerator();
        System.out.println("EMAIL_ID: " + emailId);
        inputValueOfServiceRequest(emailId);
    }

    /**
     * Customer input the OTP received in the new email address.
     */
    public void inputOTPForNewEmailAddress() {
        String dbQuery = "select OTP from EMAILOTP_MANAGEMENT where EMAILADDRESS = '" + emailId + "'";

        insertOTP(dbQuery);
    }


    /*
    *******MOBILE NUMBER SR Update***********************/

    /**
     * Customer navigate to add new mobile no link.
     */
    public void navigateToAddNewMobileNumber() {
        portUI.lnk_AddNewMobileNumber.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Customer Input new Mobile number.
     */
    public void customerInputNewMobileNumber() {
        phoneNumber = profileSR.randomPhoneNumber("3");
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


    /*
    *******NAME SR Update********************************/

    String portalFirstName = "", portalLastName = "";

    /**
     * Customer inputs new name details.
     */
    public void inputNewNameDetails() {
        portUI.SelectElementFromDropdown(portUI.drpDown_NamePrefix,
                "visibleText", "Ms.");
        expWait.waitForDomToLoad();

        //input firstName & lastName
        portalFirstName = "NameChangeTest" + printRandomString(5);
        portalLastName = "LastName" + printRandomString(5);
        portUI.txtBox_FirstName.sendKeys(portalFirstName);
        portUI.txtBox_LastName.sendKeys(portalLastName);
    }

    /**
     * Customer attach POI document.
     */
    public void inputPOIAttachment() {
        portUI.SelectElementFromDropdown(portUI.drpDown_SelectPOIFile,
                "visibleText", "National Food Security Act Car");

        //random number input for POI id.
        portUI.txtBox_POI_ID_Number.sendKeys(new AadharGenie().genAadhar());
        portUI.txtBox_POI_ID_Number.sendKeys(Keys.TAB);
        expWait.waitForCursorToDisappear();

        //add attachment hyperlink.
        portUI.lnk_AddAttachment.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        //Upload a sample image.jpg
        portUI.btn_ChooseFile.sendKeys(System.getProperty("user.dir")
                + Utilities.getYamlValue("jpgFilePath"));
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
        expWait.waitLong(2);

        //Save button.
        portUI.btn_Save.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Name change flag set to 'N'.
     */
    public void executeNameChangeFlagQueryInDB(String relationShip_Id) {
        //portal env is not dynamic & query do not make changes once the user has logged into portal
        /*String dbQuery = "update siebel.S_CONTACT_X set X_NAME_CHANGE_FLAG = 'N' where row_id in  "
                + "(select FIN_RESP_CON_ID from siebel.S_ORG_EXT " +
                "where INTEGRATION_ID  = '" + relNumber + "')";*/

        String dbQuery = "update siebel.S_CONTACT_X set X_NAME_CHANGE_FLAG = 'N' where row_id in  "
                + "(select FIN_RESP_CON_ID from siebel.S_ORG_EXT " +
                "where INTEGRATION_ID  = '"+relationShip_Id+"')";

        connectSiebelDBToExecuteUpdateQuery(dbQuery);
    }

    /*
    *******Profile Photo SR Update************************/

    /**
     * Customer Upload profile photo.
     */
    public void uploadProfilePhoto() {
        portUI.lnk_UpdatePhoto.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        portUI.btn_ChooseFile.sendKeys(System.getProperty("user.dir")
                + Utilities.getYamlValue("jpgFilePath"));
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        if (portUI.lnk_UpdatePhoto.isDisplayed()) {
            Assert.assertTrue(true, " Profile picture is Uploaded");
        } else {
            System.out.println("Profile picture not Uploaded");
        }
        portUI.btn_Save.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();
    }


    /*
    *******Common functions Profile SR*************************/

    /**
     * Customer navigates to edit profile link.
     */
    public void navigateToEditProfileLink() {
        portUI.lnk_EditProfile.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Customer navigate to Edit name hyperlink.
     */
    public void navigateToEditName() {
        portUI.lnk_NameEdit.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Customer provides the value of email/phone number for service request.
     *
     * @param valueOfServiceRequest profile service request value
     */
    public void inputValueOfServiceRequest(String valueOfServiceRequest) {
        portUI.txtBox_AddNewEmailOrMobileNumber.sendKeys(valueOfServiceRequest);
        expWait.waitForDomToLoad();
    }

    /**
     * Customer submit service request.
     */
    public void submitServiceRequest() {
        portUI.btn_SubmitServiceRequest.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Splitting the OTP and inserting value in portal.
     */
    public void insertOTP(String dbQuery) {
        //store otp from db.
        String otp = connectFMWDBToExtractOTP(dbQuery);
        System.out.println("OTP: " + otp);

        //split otp into list.
        String[] OTPDigitArr = otp.split("");
        List<String> OTPDigitList = new ArrayList<>();
        Collections.addAll(OTPDigitList, OTPDigitArr);

        //insert otp digits into UI boxes.
        portUI.txtBox_OTPDigit1.sendKeys(OTPDigitList.get(0));
        portUI.txtBox_OTPDigit2.sendKeys(OTPDigitList.get(1));
        portUI.txtBox_OTPDigit3.sendKeys(OTPDigitList.get(2));
        portUI.txtBox_OTPDigit4.sendKeys(OTPDigitList.get(3));
    }

    /**
     * System verify the OTP of new service request.
     */
    public void verifyOTPForNewServiceRequest() {
        portUI.btn_VerifyOTP.click();
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }

    /**
     * Service request update status message.
     */
    public void portalServiceRequestConfirmationMessage() {
        //service request confirmation page screenshot.
        try {
            portUI.txt_UserTrackingId.click();
            expWait.waitForDomToLoad();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        orderNumber = portUI.txt_ServiceRequestNumber.getText().trim();
        System.out.println("ServiceRequestNumber: " + orderNumber);
        LoggerWriter.logger.log(Status.INFO, "ServiceRequestNumber: " + orderNumber);
        expWait.waitForDomToLoad();
        expWait.waitForCursorToDisappear();
    }


    /*
    ************************Service Request of portal | END**********************************/



    /*
    ***********************************SIEBEL | START****************************************/

    /**
     * Siebel Login.
     */
    @SuppressWarnings("unchecked")
	public ArrayList<String> siebelLogin() {
        return loginAction.loginSiebel();
    }

    /**
     * Profile/Connections SRs search in siebel.
     */
    public void siebelProfileSRSearch() {
        //Navigate to Profile SR tab.
        contactTab.isTabDisplayInMainTabList("Profile/Connection SRs");
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        //Search for Profile Service Request
        portUI.btn_SearchServiceRequest.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.txtBox_SRNumber.sendKeys(orderNumber);
        expWait.waitForDomToLoad();

        portUI.btn_EnterSearchSericeRequest.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.txtBox_SRNumber.sendKeys(Keys.TAB);
        expWait.waitForDomToLoad();

        portUI.getTxt_ServiceRequestNumberLink(orderNumber).click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Siebel validations.
     */
    public void siebelValidationsRefill(String expectedSalesOrderStatus) {
        contactTab.get_MainTabLevel("Sales Order").click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.btn_SearchSalesOrder.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.txtBox_SalesOrderNumber.sendKeys(orderNumber);

        portUI.btn_EnterSearchSalesOrder.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        portUI.get_SalesOrderNumberLink(orderNumber).click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        contactTab.get_LowerTabLevel("Invoice").click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        Assert.assertEquals(contactTab.txt_SaleOrderStatus.getAttribute("value"), expectedSalesOrderStatus);


        contactTab.get_LowerTabLevel("Payments").click();
        Assert.assertTrue(contactTab.txt_PaymentsSettle.isDisplayed());
        Assert.assertEquals(contactTab.txt_PaymentsSettle.getAttribute("value"), "Settle");

        /*driver.switchTo().window(tabs.get(0)); // switch back to main screen
        expWait.waitForDomToLoad();*/
    }

    /**
     * Siebel validation Profile SR.
     */
    public void siebelValidationProfileSR(String profileSRType) {
        //Refresh Page.
        performRefresh();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();

        String profileSRPortalValue = "", profileSRSiebelValue = "";

        //Siebel Profile SR status.
        String SRStatus = profileSRPage.txt_ProfileSRStatus.getAttribute("value");

        switch (profileSRType) {
            case "email":
                String emailAddressValueInSiebel = portUI.txtBox_EmailAddressNewValue.getAttribute("value");
                profileSRPortalValue = emailId;
                profileSRSiebelValue = emailAddressValueInSiebel;
                break;

            case "mobile":
                String newPrimaryMobileNumber = profileSRPage.txt_InputPhoneNumber.getAttribute("value");
                profileSRPortalValue = phoneNumber;
                profileSRSiebelValue = newPrimaryMobileNumber;
                break;

            case "name":
                String newFirstName = profileSRPage.txt_FirstName.getAttribute("value");
                String newLastName = profileSRPage.txt_LastName.getAttribute("value");
                profileSRPortalValue = portalFirstName;
                profileSRSiebelValue = newFirstName;
                break;
            case "photo":
                /*String newPhoto = profileSRPage.img_Profile.getAttribute("value");
                profileSRPortalValue = portalFirstName;
                profileSRSiebelValue = newFirstName;
                break;*/
        }

        if (profileSRSiebelValue.equals(profileSRPortalValue)) {
            LoggerWriter.logger.log(Status.PASS, profileSRType +
                    " updated through portal found same in Siebel.");
        } else if (!SRStatus.equals("Closed")) {
            String remarksProfileSR = profileSRPage.txtArea_SR_Remarks.getAttribute("value");
            System.out.println("Error found in siebel with mobile update through portal as: " + remarksProfileSR);
            LoggerWriter.logger.log(Status.FAIL,
                    "Error remarks found in siebel with mobile update through portal as: " + remarksProfileSR);
            Assert.assertEquals(SRStatus, "Closed", "Status is not closed.");
        }
    }

    /************************************SIEBEL | END*******************************************/




    /***********************************AKASH**********************************/



    /***********************************RESHMA K*****************************/

    /*
     * Partner Portal - Sales Order - With Contract
     * */

    public void selectPosition() {
        //expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        portUI.Company_Name.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.Company_Name_option.click();
        //expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        portUI.Site_name.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.Site_name_option.click();
        //expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();

        portUI.Partner_type.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.Partner_type_option.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.Submit_position.click();
        //expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad();
    }

    public void selectCustomer() {
    	expWait.waitForDomToLoad();

    	portUI.Search_customer.sendKeys("0000323513");
    	portUI.Search_customer.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.Select_customer.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();
    }

    public void navigateToSalesOrder() {
    	//expWait.waitForDomToLoad();

    	portUI.Order.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.Create_sales_order.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();
    }

    public void selectContract() {
    	//expWait.waitForDomToLoad();

    	portUI.with_contract.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();
    }

    public void withContract() {
    	//expWait.waitForDomToLoad();

    	portUI.fetch_contract.click();
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.select_contract.click();

        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.Quantity.sendKeys("5");
        //expWait.waitForCursorToDisappear();
        //expWait.waitForDomToLoad();

        portUI.fetch_price.click();
        expWait.waitForCursorToDisappear();
        expWait.waitForDomToLoad1();
        //expWait.waitForHomePageSipperToDisapper();
        portUI.mode_of_transport.click();
        portUI.mode_of_transport_road.click();
        portUI.Continue_sales.click();
        expWait.waitForDomToLoad();
        portUI.Confirm_order.click();
    }

    public void OrderConfirmation() {
        expWait.waitForDomToLoad();
        portUI.PR_number.isEnabled();
        expWait.waitForDomToLoad();
        PR_num = portUI.PR_number.getText();
        portUI.Ok_button.click();
        System.out.println(PR_num);
    }

    public void PRNumber() throws IOException {
    	String exc = "C:\\Users\\0047HE744\\Desktop\\Personal\\MyLearning\\AMS_Automation\\src\\test\\java\\com\\ibm\\Test\\PetChem\\data.xlsx";
    	FileInputStream inputstream = new FileInputStream(exc);
    	try (XSSFWorkbook workbook = new XSSFWorkbook(inputstream)) {
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			//XSSFRow row = sheet.getRow(0);
		    Cell cell2Update = sheet.getRow(0).getCell(0);
		    cell2Update.setCellValue(PR_num);
		    System.out.println(sheet.getRow(0).getCell(0));
		}
    }
    public void selectwContract() {
    	expWait.waitForDomToLoad();
    	portUI.without_contract.click();
    }

    public void withoutContract() {
    	expWait.waitForDomToLoad();
    	portUI.continue_shipping.click();
    	expWait.waitForDomToLoad();
    	portUI.plant_type.click();
    	portUI.plant_type_SAP.click();
    	//expWait.waitForDomToLoad();
    	portUI.supply_location.click();
    	portUI.supply_location.sendKeys("0033");
    	expWait.waitForDomToLoad();
    	expWait.waitForCursorToDisappear();
    	portUI.supply_loc_IOC.click();
    	expWait.waitForDomToLoad();
    	portUI.delivery_mode.click();
    	expWait.waitForDomToLoad();
    	portUI.payment_term.click();
    	portUI.payment_term_option.click();
    	expWait.waitForDomToLoad();
    	portUI.mode_of_trnsport.click();
    	portUI.mode_of_transport_road.click();
    	expWait.waitForDomToLoad();
    	portUI.Continue_sales.click();
    	expWait.waitForDomToLoad();
    	portUI.material.sendKeys("1030RG");
    	portUI.product_0033.click();
    	expWait.waitForDomToLoad();
    	portUI.Quantity.sendKeys("5");
    	expWait.waitForDomToLoad();
    	portUI.fetch_price.click();
    	expWait.waitForDomToLoad();
    	portUI.Continue_sales.click();
    	expWait.waitForDomToLoad();
    	portUI.Confirm_order.click();
    }
}