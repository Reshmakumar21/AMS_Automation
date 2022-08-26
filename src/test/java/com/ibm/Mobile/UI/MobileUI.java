package com.ibm.Mobile.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.Utilities.SeleniumWait;

import io.appium.java_client.MobileBy;

public class MobileUI {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new login page UI.
	 *
	 * @param driver the driver
	 */
	public MobileUI(WebDriver driver) {
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	/**
	 * Txt box user name.
	 *
	 * @return the web element
	 */
	public WebElement btn_Login() {

		return expWait.getWhenVisible(MobileBy.xpath("//android.widget.TextView[@text='LOG IN']"));
	}

	public WebElement btn_NewConnection() {

		return expWait.getWhenVisible(MobileBy.xpath("//android.widget.TextView[@text=\"New Connection\"]"));
	}

	public WebElement btn_OrderCylinder() {

		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/order_cylinder_layout"));
	}

	public WebElement txtBox_UserName() {

		return expWait
				.getWhenVisible(MobileBy.xpath("//android.widget.EditText[@resource-id='cx.indianoil.in:id/email']"));
	}

	public WebElement txtBox_Password() {

		return expWait.getWhenVisible(MobileBy.xpath("//android.widget.EditText[@text='Password']"));
	}

	public WebElement btn_LoginNow() {

		return expWait.getWhenVisible(MobileBy.xpath("//android.widget.Button[@text='LOGIN NOW']"));
	}

	public WebElement txt_PhoneNumber() {

		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/text_card_number"));
	}

	public WebElement btn_OrderNow() {

		return expWait.getWhenClickable(MobileBy.id("cx.indianoil.in:id/button_order_now"),60);
	}

	public WebElement txt_OrderNumber() {

		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/text_order_number"));
	}

	public WebElement btn_homepage() {

		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/button_homepage"));
	}
	
	public WebElement lnk_toolBarMenu() {

		return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id,'toolbar')]/android.widget.ImageButton"));
	}
	
	public WebElement lnk_LPGMenuBar() {

		return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id,'layout_lpg')]//android.widget.TextView"));
	}
	
	public WebElement lnk_LPGHistory() {

		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/layout_booking_history"));
	}
	
	public WebElement lnk_LPGBookingHistory() {

		return expWait.getWhenVisible(MobileBy.xpath("//*[@text='Booking History']"));
	}
	
	public WebElement btn_CancelOrder() {

		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/button_cancel_order"));
	}
	
	public WebElement radio_CancelReason() {

		return expWait.getWhenVisible(MobileBy.xpath("//*[@text='Empty Cylinder Unavailable']"));
	}
	
	public WebElement btn_OK() {

		return expWait.getWhenVisible(MobileBy.xpath("//*[@text='OK']"));
	}
	
	public WebElement txt_CancelledOrderStatus() {

		return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id,'text_status') and @text='CANCELLED']"));
	}
	public WebElement Toatmessage() {
		
		return expWait.getWhenVisible(MobileBy.xpath("/hierarchy/android.widget.Toast"));
	
	}
	public WebElement MyProfilebutton() {
		
		return expWait.getWhenVisible(MobileBy.xpath("//android.widget.TextView[contains(@text, 'My Profile')]"));
	}
	public WebElement EditProfileButton() {
		
		return expWait.getWhenVisible(MobileBy.xpath("//android.widget.Button[contains(@text, 'EDIT PROFILE')]"));
	}
	public WebElement AddMobileNo() {
		
		return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'cx.indianoil.in:id/edit_mobile_no')]"));	
	}
    public WebElement VerifyMobileNo() {
		
		return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'cx.indianoil.in:id/tv_mobile_verify')]"));	
	}
    public WebElement EnterOTP() {
		
		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/otp_edit_text"));	
	}
    public WebElement ResendOTP() {
		
		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/resend_otp"));	
	}
    public WebElement OTPCancel() {
		
		return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'android:id/button2') and @text='CANCEL']"));	
	}
    public WebElement OTPConfirm() {
		
		return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'android:id/button1') and @text='DONE']"));	
	}
    public WebElement RequestNumber() {
		
		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/button_req_no"));	
	}
    public WebElement GoToHomePageButton() {
		
		return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/btn_home_page"));	
	}
    public WebElement Agreesterms() {
    	
    	return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/agree_terms"));
    }
    public WebElement OnlinePayNowbutton1() {
    	
    	return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/button_pay_online_now"));
    }
    public WebElement ToatlPayableAmount() {
    	
    	return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/text_total_value"));
    }
    public WebElement CCAvenue() {
    	
    	return expWait.getWhenVisible(MobileBy.xpath("//android.widget.TextView[contains(@text, 'CC Avenue')]"));
    }
    public WebElement CCAvenuePayNowbutton2() {
    	
    	return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'cx.indianoil.in:id/btn_primary') and @text='PAY NOW']"));
    }
    public WebElement OnlinepaymentNextButton() {
    	
    	return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'cx.indianoil.in:id/button_proceedNow') and @text='NEXT']"));
    }
    public WebElement OnlinePayNowButton3() {
    	
    	return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'cx.indianoil.in:id/button_proceedNow') and @text='PAY NOW']"));
    }
    public WebElement NetBanking() {
    	
    	return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'cx.indianoil.in:id/textView') and @text='Net Banking']"));
    }
    public WebElement AvenueTestPayment() {
    	
    	return expWait.getWhenVisible(MobileBy.xpath("//*[contains(@resource-id, 'cx.indianoil.in:id/textView') and @text='AvenuesTest']"));
    }
    public WebElement AvenueTestPaybutton() {
    	
    	return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/btnPay"));
    }
    public WebElement ReturnToMerchantSiteButton() {
    	
    	return expWait.getWhenVisible(MobileBy.xpath("//android.widget.Button[contains(@text, 'Return To the Merchant Site')]"));
    }
    public WebElement TransactionId() {
    	
    	return expWait.getWhenVisible(MobileBy.id("cx.indianoil.in:id/tv_paymentTxn"));
    }
    
    
    
    
    
    
	
  
	/**
	 * Wait for dom to load.
	 */
	public void waitForDomToLoad() {
		// waitLong(2);
		expWait.getWhenVisible(By.xpath("//*"), 120);
	}

}
