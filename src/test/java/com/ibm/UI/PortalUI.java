/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2019-10-17
 *
 */
package com.ibm.UI;

import com.ibm.Utilities.SeleniumWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class ContactTabUI.
 */
public class PortalUI extends BaseUIPage {
    /**
     * The driver.
     */
    WebDriver driver;

    /**
     * The exp wait.
     */
    SeleniumWait expWait;

    /**
     * Instantiates a new contact tab UI.
     *
     * @param driver the driver
     */
    public PortalUI(WebDriver driver) {
        super(driver);
        this.driver = driver;
        expWait = new SeleniumWait(driver);
    }

    /**
     * The lnk for LPG.
     */
    @FindBy(xpath = "//*[text()='LPG']")
    public WebElement lnk_LPG;

    /**
     /**
     * The Multiple LPG selection pup-up.
     */
    @FindBy(xpath = "//*[@id=\"T:oc_7140519694rw9eVV1:i2:0:sbr1::content\"]")
    public WebElement Multiple_LPG_radiobutton;

    /**
     * The Select Connect button.
     */
    @FindBy(xpath = "//*[@id=\"T:oc_7140519694rw9eVV1:i2:0:sbr1::content\"]")
    public WebElement select_connection_button;

    /**
     * The text relationshipID.
     */
    @FindBy(xpath = "//*[contains(text(), 'RelationShip Id')]//following-sibling::span[1]")
    public WebElement txt_relationShipID;

    /**
     * The lnk for Book your cylinder.
     */
    @FindBy(xpath = "//*[text()='Book your cylinder']")
    public WebElement lnk_BookYourCylinder;

    /**
     * The DropDown for Refill Cylinder Request For.
     */
    @FindBy(xpath = "//select[contains(@id,'content') and @title='Please Select']")
    public WebElement dropDown_refillCylinderRequestFor;

    /*
    * Customer Book now button.
    * */
    @FindBy(xpath = "//a[@role='button']//*[text()='BOOK NOW']")
    public WebElement btn_BookNow;

    /**
     * Text of Order_Number generated after book now.
     */
    @FindBy(xpath = "//*[contains(text(), 'Order No. #')]//ancestor::span[1]//following-sibling::span")
    public WebElement txt_OrderNumber;

    /*
     * CheckBox of Terms & Condition.
     * */
    @FindBy(xpath = "//*[contains(text(),'I accept the')]//preceding-sibling::span//input[@type='checkbox']")
    public WebElement chkBox_TermsAndCondition;

    /*
     * Customer PAY button.
     * */
    @FindBy(xpath = "//*[text()='PAY']//ancestor::a[@role='button']")
    public WebElement btn_PAY;

    /*
     * Customer select a payment gateway.
     * */
    @FindBy(xpath = "//*[contains(@id,'pt_i4')]//img")
    public WebElement img_PaymentGateway;

    /*
     * Customer select the payment gateway as netbanking.
     * */
    @FindBy(xpath = "//*[@id='OPTNBK']")
    public WebElement lnk_NetBanking;

    /*
     * Customer select the payment channel, e.g. netbanking.
     * */
    @FindBy(xpath = "//select[@id='netBankingBank']")
    public WebElement drpDown_PaymentChannel;

    /*
     * Customer uses make payment button.
     * */
    @FindBy(xpath = "(//*[@id='SubmitBillShip']/span)[3]")
    public WebElement btn_MakePayment;

    /*
     * Customer returns to merchant site.
     * */
    @FindBy(xpath = "//input[@value='Return To the Merchant Site' and @type='submit']")
    public WebElement btn_ReturnToMerchantSite;

    /**
     * Text of successful cylinder order.
     */
    @FindBy(xpath = "//*[contains(text(),'Thank you for your cylinder order')]")
    public WebElement txt_ThankYouForYourCylinderOrder ;

    /*
     * Customer Cancel Booking link. Immediate after new booking at pay now page.
     * */
    @FindBy(xpath = "//*[contains(text(), 'Cancel Booking')]//ancestor::a[1]")
    public WebElement lnk_CancelBooking;

    /*
     * Customer Cancel Booking button.
     * */
    @FindBy(xpath = "//*[contains(text(), 'CANCEL BOOKING')]//ancestor::a[1]")
    public WebElement btn_CancelBooking;

    /**
     * Text of cancellation of cylinder order.
     */
    @FindBy(xpath = "//*[contains(text(), 'Your request for cancellation is taken against the booking ID:')]//ancestor::span[contains(text(), 'Confirmation!')]")
    public WebElement txt_cancellationBooking;

    /*
     * Customer name hyperlink.
     * */
    @FindBy(xpath = "//*[@id='navLogin']")
    public WebElement lnk_CustomerName;

    /*
     * Customer logOut.
     * */
    @FindBy(xpath = "//*[text()='Log Out']")
    public WebElement lnk_CustomerLogOut;

    /*
     * Text User tracking id.
     * */
    @FindBy(xpath = "//*[contains(text(),'User TrackingId')]")
    public WebElement txt_UserTrackingId;





    /*Service request portal web elements | START******************************************************/

    /*
     * Edit Profile Link.
     * */
    @FindBy(xpath = "//*[text()='Edit']//ancestor::a")
    public WebElement lnk_EditProfile;

    /*
     * Add New Email Link.
     * */
    @FindBy(xpath = "//*[text()='Add new E-mail']//ancestor::a")
    public WebElement lnk_AddNewEmail;

    /*
     * Add New Mobile Number Link.
     * */
    @FindBy(xpath = "//*[text()='Add new mobile No.']//ancestor::a")
    public WebElement lnk_AddNewMobileNumber;

    /*
     * Input New Email textBox.
     * */
    @FindBy(xpath = "//*[text()='Label 1']//preceding-sibling::input")
    public WebElement txtBox_AddNewEmailOrMobileNumber;

    /*
     * Submit button new email.
     * */
    @FindBy(xpath = "//*[text()='SUBMIT']//ancestor::a[@role='button']")
    public WebElement btn_SubmitServiceRequest;

    /*
     * OTP digit 1.
     * */
    @FindBy(xpath = "//*[text()='OTP1']//preceding-sibling::input")
    public WebElement txtBox_OTPDigit1;

    /*
     * OTP digit 2.
     * */
    @FindBy(xpath = "//*[text()='OTP2']//preceding-sibling::input")
    public WebElement txtBox_OTPDigit2;

    /*
     * OTP digit 3.
     * */
    @FindBy(xpath = "//*[text()='OTP3']//preceding-sibling::input")
    public WebElement txtBox_OTPDigit3;

    /*
     * OTP digit 4.
     * */
    @FindBy(xpath = "//*[text()='OTP4']//preceding-sibling::input")
    public WebElement txtBox_OTPDigit4;

    /*
     * Verify OTP button.
     * */
    @FindBy(xpath = "//*[@role='button']//*[text()='VERIFY OTP']")
    public WebElement btn_VerifyOTP;

    /*
     * Text Service Request Confirmation.
     * */
    @FindBy(xpath = "//*[@role='button']//*[text()='VERIFY OTP']")
    public WebElement txt_;

    /*
     * Service Request Number.
     * */
    @FindBy(xpath = "//*[contains(text(),'Your service request')]//following-sibling::span")
    public WebElement txt_ServiceRequestNumber;

    /*NAME_CHANGE_SR*******/

    /*
     * Name change hyperlink.
     * */
    @FindBy(xpath = "//*[text()='(Edit)']//ancestor::a")
    public WebElement lnk_NameEdit;

    /*
     * Name prefix dropdown.
     * */
    @FindBy(xpath = "//select[contains(@id,'soc1')]")
    public WebElement drpDown_NamePrefix;

    /*
     * Name change firstName.
     * */
    @FindBy(xpath = "//*[text()='Label 1']//preceding-sibling::input")
    public WebElement txtBox_FirstName;

    /*
     * Name change lastName.
     * */
    @FindBy(xpath = "//*[text()='Label 3']//preceding-sibling::input")
    public WebElement txtBox_LastName;

    /*
     * Select a POI File dropdown.
     * */
    @FindBy(xpath = "//select[contains(@id,'soc2')]")
    public WebElement drpDown_SelectPOIFile;

    /*
     * TextBox POI id number.
     * */
    @FindBy(xpath = "//input[contains(@id, 'it4')]")
    public WebElement txtBox_POI_ID_Number;

    /*
     * POI add attachment hyperlink.
     * */
    @FindBy(xpath = "//*[text()='Add Attachment']//ancestor::a")
    public WebElement lnk_AddAttachment;

    /*
     * POI Add attachment choose file.
     * */
    @FindBy(xpath = "//input[contains(@id,'if1') and @type='file']")
    public WebElement btn_ChooseFile;

    /*
     * POI Add attachment choose file save button.
     * */
    @FindBy(xpath = "//*[text()='Save']//ancestor::a[@role='button']")
    public WebElement btn_Save;


    /*Service request portal web elements | END**********************************************************/




    /*Siebel Web Elements***********************************/

    /*
     * Search button for Sales Order.
     * */
    @FindBy(xpath = "//*[@title='Sales Order List Applet']//button[@aria-label='Sales Order:Query']")
    public WebElement btn_SearchSalesOrder;

    /*
     * Input TextBox for Sales Order.
     * */
    @FindBy(xpath = "//*[@title='Sales Order List Applet']//input[@aria-label='Sales Order #']")
    public WebElement txtBox_SalesOrderNumber;

    /*
     * Search enter button for Sales Order.
     * */
    @FindBy(xpath = "//*[@title='Sales Order List Applet']//button[@aria-label='Sales Order:Go']")
    public WebElement btn_EnterSearchSalesOrder;

    /**
     * Gets the sales order hyperlink.
     *
     * @param salesOrderNumber
     * @return link of sales Order Number
     */
    public WebElement get_SalesOrderNumberLink(String salesOrderNumber) {
        return driver
                .findElement(By.xpath("//*[@title='Sales Order List Applet']//*[text()='"+salesOrderNumber+"']"));
    }

    /*
     * Search button for Service Request.
     * */
    @FindBy(xpath = "//button[@aria-label='Service Request:Query']")
    public WebElement btn_SearchServiceRequest;

    /*
     * Input textBox for SR Number.
     * */
    @FindBy(xpath = "//*[@title='Service Request List Applet']//input[contains(@aria-labelledby,'SR_Number')]")
    public WebElement txtBox_SRNumber;

    /*
     * Search enter button for Service Request.
     * */
    @FindBy(xpath = "//*[@title='Service Request List Applet']//button[contains(@aria-label,'Service Request:Go')]")
    public WebElement btn_EnterSearchSericeRequest;

    /**
     * Gets the service request hyperlink.
     *
     * @param serviceRequestNumber
     * @return link of service request number
     */
    public WebElement getTxt_ServiceRequestNumberLink(String serviceRequestNumber) {
        return driver
                .findElement(By.xpath("//*[@title='Service Request List Applet']//*[text()='"+serviceRequestNumber+"']"));
    }

    /*
     * TextBox of new values email address under profile SR.
     * */
    @FindBy(xpath = "//*[@title='Service Request Detail Form Applet']//*[@aria-labelledby='EPIC_Email_Address_Label']")
    public WebElement txtBox_EmailAddressNewValue;


    /*Web Elements - PORTAL - AKASH******************************************/

    @FindBy(xpath = "lnk_UpdatePhoto")
    public WebElement lnk_UpdatePhoto;
}
