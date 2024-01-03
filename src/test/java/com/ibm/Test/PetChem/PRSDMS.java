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
public class PRSDMS extends SuperTest {
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
     * TC 02 Navigate to Partner Relationships.
     * @throws IOException
     * @throws TesseractException
     */
    @Test
    public void TC02_navigateToPartnerRelationships() throws TesseractException, IOException {
    	test.petChemPage.navigateToPartnerRelationships();
    	test.petChemPage.navigateToPrimaryPurchase();
    }
    
    /**
     * TC 03 Navigate to Create PR.
     * @throws IOException
     * @throws TesseractException
     */
    @Test
    public void TC03_createPrimaryPurchase() throws TesseractException, IOException {
    	test.petChemPage.createPPPRSDMS();
    }
    

    /**
     * TC 04 PP PR details.
     * @throws IOException
     * @throws TesseractException
     */
    @Test
    public void TC04_productDetailsPrimaryPurchase() throws TesseractException, IOException {
    	test.petChemPage.PPPRdetails();
    	test.petChemPage.PPAddProductsPR();
    	test.petChemPage.PPAddProductsPR2();
    }
    
    /**
     * TC 05 Submit PR.
     * @throws IOException
     * @throws TesseractException
     */
    @Test
    public void TC04_submitPrimaryPurchase() throws TesseractException, IOException {
    	test.petChemPage.PPSubmitPR();
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
