package com.ibm.Mobile.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.ibm.Mobile.UI.MobileUI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileAction {

	AppiumDriver<MobileElement> mobileDriver;

	WebDriverWait wait;

	public static ExtentTest logger;

	protected MobileUI mobileUI;

	protected MobileServiceRequestActions mobilesractions;

	public MobileAction(AppiumDriver<MobileElement> mobileDriver2) {
		this.mobileDriver = mobileDriver2;
		wait = new WebDriverWait(mobileDriver2, 30);
		mobileUI = new MobileUI(mobileDriver2);
		mobilesractions = new MobileServiceRequestActions(mobileDriver2);

	}


	public void loginToInformation() {
		mobileUI.btn_NewConnection().click();
		mobileUI.btn_Login().click();
		mobileUI.txtBox_UserName().sendKeys("9711260561");
		mobileUI.txtBox_Password().sendKeys("Hello@123");
		mobileUI.btn_LoginNow().click();
		mobileUI.txt_PhoneNumber().isDisplayed();
		System.out.println(mobileUI.txt_PhoneNumber().getText());
	}


	public void orderCylinder() {
		mobileUI.btn_OrderCylinder().click();
		mobileUI.btn_OrderNow().click();
		mobileUI.txt_OrderNumber().click();
		System.out.println(mobileUI.txt_OrderNumber().getText());
		//mobileUI.btn_homepage().click();
	}
	public void onlinePaymnet() {
		mobileUI.Agreesterms().click();
        System.out.println(mobileUI.ToatlPayableAmount().getText());
		mobileUI.OnlinePayNowbutton1().click();
		mobileUI.CCAvenue().click();
		mobileUI.CCAvenuePayNowbutton2().click();
		mobileUI.OnlinepaymentNextButton().click();
		mobileUI.OnlinePayNowButton3().click();
		mobileUI.NetBanking().click();
		mobileUI.AvenueTestPayment().click();
		mobileUI.AvenueTestPaybutton().click();
		mobileUI.ReturnToMerchantSiteButton().click();
		System.out.println(mobileUI.TransactionId().getText());
		mobileUI.GoToHomePageButton().click();
	}

	public void openMenu()
	{
		mobileUI.lnk_toolBarMenu().click();


	}

	public void openBookingHistory(){
		mobileUI.lnk_LPGMenuBar().click();
		mobileUI.lnk_LPGHistory().click();
		mobileUI.lnk_LPGBookingHistory().click();
	}

	public void cancelOrder() {
		mobileUI.btn_CancelOrder().click();
		mobileUI.radio_CancelReason().click();
		mobileUI.btn_OK().click();
		mobileUI.txt_CancelledOrderStatus().click();
	}
	public void UpdateMobileNumber() {
		mobileUI.lnk_toolBarMenu().click();
		mobileUI.MyProfilebutton().click();
		mobileUI.EditProfileButton().click();
		mobileUI.AddMobileNo().clear();
		mobilesractions.customerInputNewMobileNumber();
		mobileUI.VerifyMobileNo().click();
		mobilesractions.inputOTPForNewMobileNumber();
		mobileUI.OTPConfirm().click();
		String SRNumber=mobileUI.RequestNumber().getText();
		System.out.println(SRNumber +"Submitted successfully");
		mobileUI.GoToHomePageButton().click();
	}




}
