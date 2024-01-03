/*
 * @author  Reshma K
 * @version 1.0
 * @since   2023-01-02
 */
package com.ibm.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibm.UI.AccountsTabUI;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.NFR_UI;
import com.ibm.UI.PetChemUI;
import com.ibm.UI.ProfileServiceRequestUI;

/**
 * The Class AccountsTabAction.
 */
public class PetChemActions extends BaseAction {

	/** The contact tab. */
	protected ContactTabUI contactTab;

	/** The home page. */
	protected HomePageUI homePage;

	/** The account page. */
	protected AccountsTabUI accountPage;

	/** The nfr page. */
	protected NFR_UI nfrPage;
	/**
	 * The Login action.
	 */
	protected LoginActions loginAction;
	/**
	 * The profile SR page.
	 */
	protected ProfileServiceRequestUI profileSRPage;

	/**
	 * PetChem UI page
	 */
	protected PetChemUI petChem;

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new accounts tab action.
	 *
	 * @param driver the driver
	 */
	public PetChemActions(WebDriver driver) {
		super(driver);
		contactTab = new ContactTabUI(driver);
		homePage = new HomePageUI(driver);
		accountPage = new AccountsTabUI(driver);
		nfrPage = new NFR_UI(driver);
		loginAction = new LoginActions(driver);
		profileSRPage = new ProfileServiceRequestUI(driver);
		petChem = new PetChemUI(driver);
		this.driver = driver;
	}

	public void navigateToPRScreen() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		petChem.purchase_screen.click();
	}

	public void queryPR(String PR_num) {
		expWait.waitForDomToLoad();
		petChem.PR_query.click();
		expWait.waitForDomToLoad();
		petChem.PR_num_query.sendKeys(PR_num, Keys.ENTER);
	}

	public void drilldownPR() {
		expWait.waitForDomToLoad();
		petChem.PR_created.click();
		petChem.PR_drilldown.click();
	}

	public void truckCapacity() {
		expWait.waitForDomToLoad();
		petChem.Truck_capacity.click();
		petChem.Truck_cap_input.sendKeys("Non Standard" + Keys.ENTER);
	}

	public void approvePR() {
		expWait.waitForDomToLoad();
		petChem.Approval_subtab.click();
	}


	/*-----Daily Allocation ---------------------------------------------------------------
	 *
	 */

	public void navigateToTargetManagement() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		petChem.Screen.click();
		//((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		expWait.waitForDomToLoad();
		petChem.Screen_name.click();
		expWait.waitForDomToLoad();
		petChem.daily_allocation_view.click();
	}

	public void dailyAllocationQuery() {
		expWait.waitForDomToLoad();
		petChem.da_Query.click();
		expWait.waitForDomToLoad();
		petChem.da_input.sendKeys("1-8200N1WP", Keys.ENTER);
	}

	public void dailyAllocation() {
		expWait.waitForDomToLoad();
		petChem.add_button_da.click();
		expWait.waitForDomToLoad();
		petChem.submit_da.click();
	}

	public void dailyAllocationDetails() {
		expWait.waitForDomToLoad();
		petChem.drilldown_da.click();
	}

	public void dailyAllocationProduct() {
		expWait.waitForDomToLoad();
		petChem.da_add_product.click();
		expWait.waitForDomToLoad();
		petChem.da_search_product.click();
		expWait.waitForDomToLoad();
		petChem.da_product_part.clear();
		petChem.da_product_part.sendKeys("Part #");
		expWait.waitForDomToLoad();
		petChem.da_product_input.sendKeys("1030RG", Keys.ENTER);
		expWait.waitForDomToLoad();
		petChem.da_product_select.click();
		expWait.waitForDomToLoad();
		petChem.da_product_ok.click();
	}

	public void dailyAllocationAccount() {
		expWait.waitForDomToLoad();
		petChem.da_account_add.click();
		expWait.waitForDomToLoad();
		petChem.da_account_search.click();
		expWait.waitForDomToLoad();
		petChem.da_account_select.click();
		expWait.waitForDomToLoad();
		petChem.da_account_ok.click();
		expWait.waitForDomToLoad();
		petChem.da_account_quantity.click();
		expWait.waitForDomToLoad();
		petChem.da_account_qinput.sendKeys("300", Keys.CONTROL, "s");
	}

	public void dailyAllocationProduct2() {
		expWait.waitForDomToLoad();
		petChem.da_add_product.click();
		expWait.waitForDomToLoad();
		petChem.da_search_product.click();
		expWait.waitForDomToLoad();
		petChem.da_product_part.clear();
		petChem.da_product_part.sendKeys("Part #");
		expWait.waitForDomToLoad();
		petChem.da_product_input.sendKeys("1110MG", Keys.ENTER);
		expWait.waitForDomToLoad();
		petChem.da_product_select.click();
		expWait.waitForDomToLoad();
		petChem.da_product_ok.click();
	}

	/*
	 * Using csv
	 */

	public void importDailyAllocation() {
		expWait.waitForDomToLoad();
		petChem.import_csv_button.click();
		expWait.waitForDomToLoad();
		petChem.send_file.sendKeys("C:/Users/0047HE744/Documents/DailyAllocation.csv");
		expWait.waitForDomToLoad();
		petChem.import_file_button.click();
	}

	public void submitDailyAllocation() {
		expWait.waitForDomToLoad();
		petChem.submit.click();
	}

	/*        PR creation             */

	public void navigateToPartnerRelationship() {
		//expWait.waitForDomToLoad();
		petChem.Screen.click();
		expWait.waitForDomToLoad();
		petChem.Partner_RelTab.click();
	}

	public void QueryPartner() {
		expWait.waitForDomToLoad();
		petChem.Partner_View.click();
		expWait.waitForDomToLoad();
		petChem.Partner_View_Allorg.click();
		expWait.waitForDomToLoad();
		petChem.Query_button.click();
		expWait.waitForDomToLoad();
		petChem.ShipToParty.click();
		expWait.waitForDomToLoad();
		petChem.ShipToParty_Input.sendKeys("0000323513", Keys.ENTER);
		expWait.waitForDomToLoad();
	}

	public void PRCreation() {

	}
	
	/*
	 * PR Creation from SDMS*/
	public void navigateToPartnerRelationships() {
		expWait.waitForDomToLoad();
		expWait.waitForHomePageSipperToDisapper();
		petChem.Screen.click();
		expWait.waitForDomToLoad();
		petChem.partnerrel_screen.click();
	}
	
	public void navigateToPrimaryPurchase() {
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		petChem.partnerrel_query.click();
		expWait.waitForDomToLoad();
		petChem.partnerrel_qval1.click();
		expWait.waitForDomToLoad();
		petChem.partnerrel_qval2.sendKeys("0000323513", Keys.ENTER);
		expWait.waitForDomToLoad();
		petChem.partnerrel_dd.click();
		expWait.waitForDomToLoad();
		petChem.pp_menu.click();
		expWait.waitForDomToLoad();
		petChem.pp_screen.click();
	}
	
	public void createPPPRSDMS() {
		expWait.waitForHomePageSipperToDisapper();
		expWait.waitForDomToLoad();
		petChem.pp_add.click();
		expWait.waitForDomToLoad();
		petChem.pp_reqtype.click();
		expWait.waitForDomToLoad();
		petChem.pp_sreqtype.sendKeys("Primary Purchase", Keys.ENTER);
		expWait.waitForDomToLoad();
		petChem.pp_subtype.click();
		expWait.waitForDomToLoad();
		petChem.pp_ssubtype.click();
		expWait.waitForDomToLoad();
		petChem.pp_ssubtypeselect.click();
	}
	
	public void PPPRdetails() {
		expWait.waitForDomToLoad();
		petChem.pp_drilldown.click();
		expWait.waitForDomToLoad();
		petChem.pp_supplyPlantQuery.click();
		expWait.waitForDomToLoad();
		petChem.pp_supplyPlantSelect.click();
		expWait.waitForDomToLoad();
		petChem.pp_supplyPlantOK.click();
		expWait.waitForDomToLoad();
		petChem.pp_agentNameSearch.click();
		expWait.waitForDomToLoad();
		petChem.pp_agentQueryOk.click();
		expWait.waitForDomToLoad();
		petChem.pp_distributionSearch.click();
		expWait.waitForDomToLoad();
		petChem.pp_distributionOk.click();
		expWait.waitForDomToLoad();
		petChem.pp_incoTermsSelect.click();
		expWait.waitForDomToLoad();
		petChem.pp_incoTermsDelivered.click();
		expWait.waitForDomToLoad();
		petChem.pp_modeOfTransport.click();
		expWait.waitForDomToLoad();
		petChem.pp_modeOfTransportRoad.click();
		expWait.waitForDomToLoad();
		petChem.pp_paymentTerm.click();
		expWait.waitForDomToLoad();
		petChem.pp_paymentTermTwodays.click();
		expWait.waitForDomToLoad();
	}
	
	public void PPAddProductsPR() {
		expWait.waitForDomToLoad();
		petChem.pp_multiAdd.click();
		expWait.waitForDomToLoad();
		petChem.pp_productQuery.click();
		expWait.waitForDomToLoad();
		petChem.pp_productPartNo.click();
		expWait.waitForDomToLoad();
		petChem.pp_productPartNoValue.sendKeys("1030RG", Keys.ENTER);
		expWait.waitForDomToLoad();
		petChem.pp_productAddClose.click();
		expWait.waitForDomToLoad();
		petChem.pp_quantityReqd.click();
		expWait.waitForDomToLoad();
		petChem.pp_quantityReqdVal.sendKeys("5");
		expWait.waitForDomToLoad();
		petChem.pp_truckCap.click();
		expWait.waitForDomToLoad();
		petChem.pp_truckCapVal.sendKeys("Non Standard", Keys.ENTER);
		expWait.waitForDomToLoad();
	}
	
	public void PPAddProductsPR2() {
		expWait.waitForDomToLoad();
		petChem.pp_multiAdd.click();
		expWait.waitForDomToLoad();
		petChem.pp_productQuery.click();
		expWait.waitForDomToLoad();
		petChem.pp_productPartNo1.click();
		expWait.waitForDomToLoad();
		petChem.pp_productPartNoValue.sendKeys("1110MG", Keys.ENTER);
		expWait.waitForDomToLoad();
		petChem.pp_productAddClose.click();
		expWait.waitForDomToLoad();
		petChem.pp_quantityReqd1.click();
		expWait.waitForDomToLoad();
		petChem.pp_quantityReqdVal1.sendKeys("5");
		expWait.waitForDomToLoad();
		petChem.pp_truckCap1.click();
		expWait.waitForDomToLoad();
		petChem.pp_truckCapVal1.sendKeys("Non Standard", Keys.ENTER);
		expWait.waitForDomToLoad();
	}
	
	public void PPSubmitPR() {
		expWait.waitForDomToLoad();
		petChem.pp_submitPR.click();
		expWait.waitForDomToLoad();
		alertVerificationAndAcceptAlert(3);
		
	}
}



