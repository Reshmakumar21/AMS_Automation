/*
 * @author  Reshma K
 * @version 1.0
 * @since   2023-01-02
 *
 */
package com.ibm.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.Utilities.SeleniumWait;

/**
 * The Class AccountsTabUI.
 */
@SuppressWarnings("unused")
public class PetChemUI extends BaseUIPage {

	/** The driver. */
	WebDriver driver;

	/** The exp wait. */
	SeleniumWait expWait;

	/**
	 * Instantiates a new accounts tab UI.
	 *
	 * @param driver the driver
	 */
	public PetChemUI(WebDriver driver) {
		super(driver);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}


	@FindBy(xpath = "//a[@data-tabindex=\"tabScreen7\"]")
	public WebElement purchase_screen;

	@FindBy(xpath = "//button[@title=\"Quotes:Query\"]")
	public WebElement PR_query;

	@FindBy (xpath = "//input[@name=\"Quote_Number\"]")
	public WebElement PR_num_query;

	@FindBy (xpath = "//td[@id=\"1_s_1_l_Created\"]")
	public WebElement PR_created;

	@FindBy (xpath = "//td[@id=\"1_s_1_l_Quote_Number\"]")
	public WebElement PR_drilldown;

	@FindBy (xpath = "//td[@id=\"1_s_2_l_Truck_Capacity\"]")
	public WebElement Truck_capacity;

	@FindBy (xpath = "//input[@name=\"Truck_Capacity\"]")
	public WebElement Truck_cap_input;

	@FindBy (xpath = "(//a[@href=\"#s_vctrl_div_tabScreen_noop\"])[4]")
	public WebElement Approval_subtab;

	/* -------------Daily Allocation ----------------------------------------------------------------
	 *
	 */

	@FindBy (xpath = "//select[@id=\"j_s_sctrl_tabScreen\"]")
	public WebElement Screen;

	@FindBy (xpath = "//option[@value=\"tabScreen38\"]")
	public WebElement Screen_name;

	@FindBy (xpath = "//a[@data-tabindex=\"tabView2\"]")
	public WebElement daily_allocation_view;

	@FindBy (xpath = "//button[@name=\"s_2_1_18_0\"]")
	public WebElement add_button_da;

	@FindBy (xpath = "//button[@id=\"s_2_1_5_0_Ctrl\"]")
	public WebElement submit_da;

	@FindBy (xpath = "//td[@id=\"1_s_1_l_Id\"]")
	public WebElement drilldown_da;

	@FindBy (xpath = "//button[@id=\"s_2_1_17_0_Ctrl\"]")
	public WebElement da_Query;

	@FindBy (xpath = "//input[@id=\"1_Id\"]")
	public WebElement da_input;

	@FindBy (xpath = "//button[@id=\"s_1_1_18_0_Ctrl\"]")
	public WebElement da_add_product;

	@FindBy (xpath = "//span[@id=\"s_1_2_25_0_icon\"]")
	public WebElement da_search_product;

	@FindBy (xpath = "//input[@name=\"s_4_1_38_0\" or contains(@name, 's_6_1_38_0')]")
	public WebElement da_product_part;

	@FindBy (xpath = "//input[@name=\"s_4_1_40_0\"]")
	public WebElement da_product_input;

	@FindBy (xpath = "//*[@id=\"3_s_4_l_Name\"]")
	public WebElement da_product_select;

	@FindBy (xpath = "//button[@id='s_4_1_41_0_Ctrl']")
	public WebElement da_product_ok;

	@FindBy (xpath = "//button[@name=\"s_3_1_17_0\"]")
	public WebElement da_account_add;

	@FindBy (xpath = "//span[@id=\"s_3_2_31_0_icon\"]")
	public WebElement da_account_search;

	@FindBy (xpath = "//td[@id=\"8_s_8_l_Name\"]")
	public WebElement da_account_select;

	@FindBy (xpath = "//button[@title=\"Pick Organization:OK\"]")
	public WebElement da_account_ok;

	@FindBy (xpath = "//td[@id=\"1_s_3_l_EPIC_Quantity\"]")
	public WebElement da_account_quantity;

	@FindBy (xpath = "//input[@id=\"1_EPIC_Quantity\"]")
	public WebElement da_account_qinput;

	@FindBy (xpath = "//input[@id=\"1_Id\"]")
	public WebElement da_input1;

	@FindBy (xpath = "//input[@id=\"1_Id\"]")
	public WebElement da_input2;

	@FindBy (xpath = "//input[@id=\"1_Id\"]")
	public WebElement da_input3;


	/*
	 *  using csv
	 */

	@FindBy (xpath = "//button[@name=\"s_2_1_8_0\"]")
	public WebElement import_csv_button;

	@FindBy (xpath = "//input[@id=\"s_4_1_19_0\"]")
	public WebElement send_file;

	@FindBy (xpath = "//button[@id=\"s_4_1_8_0_Ctrl\"]")
	public WebElement import_file_button;

	@FindBy (xpath = "//button[@name='s_1_1_0_0']")
	public WebElement submit;

	@FindBy (xpath = "(//span[@class=\"siebui-crumb\"])[1]")
	public WebElement da_page;


	/* PR creation */

	@FindBy (xpath = "//option[@value=\"tabScreen21\"]")
	public WebElement Partner_RelTab;

	@FindBy (xpath = "//select[@name=\"s_vis_div\"]")
	public WebElement Partner_View;

	@FindBy (xpath = "//*[@id=\"s_vis_div\"]/select/option[3]")
	public WebElement Partner_View_Allorg;

	@FindBy (xpath = "//button[@id=\"s_1_1_9_0_Ctrl\"]")
	public WebElement Query_button;

	@FindBy (xpath = "//td[@id=\"1_s_1_l_EPIC_Sold_To_Party_Code\"]")
	public WebElement ShipToParty;

	@FindBy (xpath = "//input[@id=\"1_EPIC_Sold_To_Party_Code\"]")
	public WebElement ShipToParty_Input;

	@FindBy (xpath = "//option[@value=\"tabScreen39\"]")
	public WebElement Screggen_name;

	@FindBy (xpath = "//option[@value=\"tabScreen39\"]")
	public WebElement Screhhen_name;
	
	/*
	 * PR Creation from SDMS*/
	@FindBy (xpath = "//option[@value=\"tabScreen22\"]")
	public WebElement partnerrel_screen;
	
	@FindBy (xpath = "//button[@id=\"s_1_1_9_0_Ctrl\"]")
	public WebElement partnerrel_query;
	
	@FindBy (xpath = "//*[@id=\"1_s_1_l_EPIC_Sold_To_Party_Code\"]")
	public WebElement partnerrel_qval1;
	
	@FindBy (xpath = "//*[@id=\"1_EPIC_Sold_To_Party_Code\"]")
	public WebElement partnerrel_qval2;
	
	@FindBy (xpath = "//*[@id=\"1_s_1_l_Name\"]/a")
	public WebElement partnerrel_dd;
	
	@FindBy (xpath = "//*[@id=\"j_s_vctrl_div_tabScreen\"]")
	public WebElement pp_menu;
	
	@FindBy (xpath = "//*[@id=\"j_s_vctrl_div_tabScreen\"]/option[12]")
	public WebElement pp_screen;
	
	@FindBy (xpath = "//button[@id='s_2_1_8_0_Ctrl']")
	public WebElement pp_add;
	
	@FindBy (xpath = "//*[@id=\"1_s_2_l_EPIC_PR_Type\"]")
	public WebElement pp_reqtype;
	
	@FindBy (xpath = "//input[@id=\"1_EPIC_PR_Type\"]")
	public WebElement pp_sreqtype;
	
	@FindBy (xpath = "//td[@id='1_s_2_l_EPIC_Quote_Sub_type']")
	public WebElement pp_subtype;
	
	@FindBy (xpath = "//span[@id=\"s_2_2_45_0_icon\"]")
	public WebElement pp_ssubtype;
	
	@FindBy (xpath = "(//li[@class=\"ui-menu-item\"])[2]")
	public WebElement pp_ssubtypeselect;
	
	@FindBy (xpath = "//*[@id=\"1_s_2_l_Quote_Number\"]/a")
	public WebElement pp_drilldown;
	
	@FindBy (xpath = "//span[@id=\"s_4_1_37_0_icon\"]")
	public WebElement pp_supplyPlantQuery;
	
	@FindBy (xpath = "//td[@id=\"2_s_5_l_Inventory_Name\"]")
	public WebElement pp_supplyPlantSelect;
	
	@FindBy (xpath = "//button[@id=\"s_5_1_164_0_Ctrl\"]")
	public WebElement pp_supplyPlantOK;
	
	@FindBy (xpath = "//span[@id=\"s_4_1_3_0_icon\"]")
	public WebElement pp_agentNameSearch;
	
	@FindBy (xpath = "//button[@id=\"s_6_1_164_0_Ctrl\"]")
	public WebElement pp_agentQueryOk;
	
	@FindBy (xpath = "//span[@id=\"s_4_1_10_0_icon\"]")
	public WebElement pp_distributionSearch;
	
	@FindBy (xpath = "//button[@id=\"s_7_1_164_0_Ctrl\"]")
	public WebElement pp_distributionOk;
	
	@FindBy (xpath = "//span[@id=\"s_4_1_20_0_icon\"]")
	public WebElement pp_incoTermsSelect;
	
	@FindBy (xpath = "(//li[@class=\"ui-menu-item\"])[1]")
	public WebElement pp_incoTermsDelivered;

	@FindBy (xpath = "//span[@id=\"s_4_1_118_0_icon\"]")
	public WebElement pp_modeOfTransport;
	
	@FindBy (xpath = "(//li[@class=\"ui-menu-item\"])[6]")
	public WebElement pp_modeOfTransportRoad;
	
	@FindBy (xpath = "//span[@id=\"s_4_1_119_0_icon\"]")
	public WebElement pp_paymentTerm;
	
	@FindBy (xpath = "(//li[@class=\"ui-menu-item\"])[7]")
	public WebElement pp_paymentTermTwodays;
	
	@FindBy (xpath = "//button[@id=\"s_2_1_1_0_Ctrl\"]")
	public WebElement pp_multiAdd;
	
	@FindBy (xpath = "//button[@title=\"Products:Query\"]")
	public WebElement pp_productQuery;
	
	@FindBy (xpath = "//td[@id=\"1_s_8_l_Part__\"]")
	public WebElement pp_productPartNo;
	
	@FindBy (xpath = "//td[@id=\"1_s_9_l_Part__\"]")
	public WebElement pp_productPartNo1;
	
	@FindBy (xpath = "//input[@id=\"1_Part__\"]")
	public WebElement pp_productPartNoValue;
	
	@FindBy (xpath = "//button[@title=\"Products:Add & Close\"]")
	public WebElement pp_productAddClose;
	
	@FindBy (xpath = "//td[@id=\"1_s_2_l_Quantity_Requested\"]")
	public WebElement pp_quantityReqd;
	
	@FindBy (xpath = "//td[@id=\"2_s_2_l_Quantity_Requested\"]")
	public WebElement pp_quantityReqd1;
	
	@FindBy (xpath = "//input[@id=\"1_Quantity_Requested\"]")
	public WebElement pp_quantityReqdVal;
	
	@FindBy (xpath = "//input[@id=\"2_Quantity_Requested\"]")
	public WebElement pp_quantityReqdVal1;
	
	@FindBy (xpath = "//td[@id=\"1_s_2_l_Truck_Capacity\"]")
	public WebElement pp_truckCap;
	
	@FindBy (xpath = "//td[@id=\"2_s_2_l_Truck_Capacity\"]")
	public WebElement pp_truckCap1;
	
	@FindBy (xpath = "//input[@id=\"1_Truck_Capacity\"]")
	public WebElement pp_truckCapVal;
	
	@FindBy (xpath = "//input[@id=\"2_Truck_Capacity\"]")
	public WebElement pp_truckCapVal1;
	
	@FindBy (xpath = "//button[@id=\"s_4_1_78_0_Ctrl\"]")
	public WebElement pp_submitPR;
}