package com.ibm.Test.NFR_FTL;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class NFR sales order.
 */
public class NFROrder extends SuperTest {

    /**
     * The test.
     */
     TestSessionInitiator test ;

    /**
     * The driver.
     */
    WebDriver driver;


    /**
     * The rel number.
     */
     String relNumber;



	/**
	 * TC 00 set up.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public void TC00_SetUp() throws Exception {
		Utilities.setYamlFilePath("integration_testData.yml");
		test = new TestSessionInitiator();
		relNumber = System.getProperty("relationShipNumber",
				Utilities.getRelationShipFromTxtFile(test.getYamlVal("Txt.RelationShip")));
		System.out.println("Relation Ship Used : " + relNumber);
		if (relNumber.length() < 2) {
			throw new Exception("RelationShip Number is not : " + relNumber);
		}
	}

	/**
	 * TC 01 enter login info.
	 */
	@Test
	public void TC01_EnterLoginInfo() {
		test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
		test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".UserName"),
				test.getYamlVal("" + test.getYamlVal("environment") + ".Password"));
		test.homePage.verifyHomePageDisplay();
	}

    /**
     * TC search for relation ship.
     */
    @Test
    public void TC02_SearchForRelationShip() {
        test.homePage.launchRelationShipTab();
        test.homePage.searchForRelationShipNumber(relNumber);
    }

    /*TC drill down relationShip*/
    @Test
    public void TC03_RelationShipDrillDown() {
        test.homePage.openRelationShipFromSearchResult();
    }

    /* TC to clean existing Secondary Sales statuses */
    @Test
    public void TC04_cleanExistingSecondarySalesStatuses() {
        
        test.contactPage.connectDBToUpdateAllSecondarySalesStatusToClose(relNumber);
    }

    /*TC navigate to secondary sales order*/
    @Test
    public void TC05_NavigateToSecondarySalesOrders() {
        
        test.contactPage.navigateToSecondarySalesOrders();
    }

    /*TC select order sub type and drill down sales order*/
    @Test
    public void TC06_SelectOrderSubType(){
        
        test.contactPage.selectOrderSubType("NFR Sales");
    }

    /*TC add products for secondary sales order*/
    @Test
    public void TC07_AddProducts(){
        
        test.contactPage.addProductsNFRSales();
    }

    /*TC verify payment tab*/
    @Test
    public void TC08_VerifyPayments(){
        
        test.contactPage.verifySecondarySalesOrderPayment();
    }


    /**
     * Tear down session.
     */
    @AfterClass
    public  void tearDownSession() {
            test.closeBrowserSession();
        
    }

}
