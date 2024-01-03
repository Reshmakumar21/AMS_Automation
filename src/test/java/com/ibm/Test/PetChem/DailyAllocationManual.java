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

import net.sourceforge.tess4j.TesseractException;

/**
 * The Class AccountOnboarding_Commercial.
 */
public class DailyAllocationManual extends SuperTest {
    /**
     * The test.
     */
    TestSessionInitiator test;

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
    	test.launchApplication(test.getYamlVal("" + "UAT"  + ".FO"+  ".URL"));
        test.login.LoginToApplication(test.getYamlVal("" + "UAT" + ".CO" +  ".UserName"),
                test.getYamlVal("" + "UAT" + ".CO" + ".Password"));
    }

    /**
     * TC 02 Navigate to Daily Allocation.
     * @throws IOException
     * @throws TesseractException
     */
    @Test
    public void TC02_navigateToDailyAllocation() throws TesseractException, IOException {
    	test.petChemPage.navigateToTargetManagement();
    	test.petChemPage.dailyAllocation();
    }

    /**
     * TC 03 Daily Allocation details.
     */
    @Test
    public void TC03_dailyAllocation() {
    	test.petChemPage.dailyAllocationDetails();
    	test.petChemPage.dailyAllocationProduct();
    	test.petChemPage.dailyAllocationAccount();
    	test.petChemPage.dailyAllocationProduct2();
    	test.petChemPage.dailyAllocationAccount();
    	test.petChemPage.submitDailyAllocation();
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
