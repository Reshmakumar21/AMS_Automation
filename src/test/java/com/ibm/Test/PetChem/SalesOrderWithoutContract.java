/*
 * @author Reshma K
 * @version 1.0
 * @since 2023-01-02
 */
package com.ibm.Test.PetChem;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class sales order without contract.
 */
public class SalesOrderWithoutContract extends SuperTest {
    /**
     * The test.
     */
    TestSessionInitiator test;

    /*
     * PR number
     */
    public String PR_number;

    /**
     * TC 00 set up.
     */
    @BeforeClass
    public void TC00_SetUp() {
        Utilities.setYamlFilePath("integration_testData.yml");
        test = new TestSessionInitiator();
    }

    /**
     * TC 01 enter login info.
     */
    @Test
    public void TC01_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + "UAT" + ".Portal" + ".Partner"+  ".URL"));
        test.login.LoginToPortal(test.getYamlVal("" + "UAT" + ".Portal" + ".DCA"+  ".UserName"),
                test.getYamlVal("" + "UAT" + ".Portal" + ".DCA"+ ".Password"));
    }

    /**
     * TC 02 select position.
     */
    @Test
    public void TC02_SelectPosition() {
    	test.portalPage.selectPosition();
    }

    /**
     * TC 03 Select customer.
     */
    @Test
    public void TC03_selectCustomer() {
    	test.portalPage.selectCustomer();
    	test.portalPage.navigateToSalesOrder();
    }

    /**
     * TC 04 Sales order without Contract
     */
    @Test
    public void TC04_orderWithContract() {
    	test.portalPage.selectwContract();
    	test.portalPage.withoutContract();
    }

    /**
     * TC 05 Order Confirmation
     * @throws IOException
     */
    @Test
    public void TC05_OrderConfirmation() throws IOException {
    	test.portalPage.OrderConfirmation();
    	PR_number = test.portalPage.PR_num;
    	System.out.println(PR_number);
    	test.portalPage.PRNumber();
    	//test.closeBrowserWindow();
    }

    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        try {
            //Utilities.writeRelationShipNumberInTxtFile(relNumber, test.getYamlVal("environment").toLowerCase());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (test.getYamlVal("Debug").toLowerCase().contains("nodebug")) {
            //test.closeBrowserSession();
        }
    }
}
