/*
 * @author Reshma K
 * @version 1.0
 * @since 2023-01-20
 */
package com.ibm.Test.PetChem;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class AccountOnboarding_Commercial.
 */
public class PRCreationStd extends SuperTest {
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
        test.login.LoginToApplication(test.getYamlVal("" + "UAT" + ".FO" +  ".UserName"),
                test.getYamlVal("" + "UAT" + ".FO" + ".Password"));
    }

    /**
     * TC 02 Navigate to Partner Relationship screen.
     */
    @Test
    public void TC02_navigateToPartnerRelationships() {
    	test.petChemPage.navigateToPartnerRelationship();
    	test.petChemPage.QueryPartner();
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
