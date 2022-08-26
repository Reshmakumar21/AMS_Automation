package com.ibm.Test.Retail.PAM.DealerScenarios;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The Retail PAM_Tank_Cancel test class.
 */
public class PAM_Tank_Cancel extends SuperTest {

    /**
     * The test.
     */
    TestSessionInitiator test;

    /**
     * Test Case 00 set up.
     */
    @BeforeClass
    public void TC00_SetUp() {
        System.out.println();
        System.out.println("***********Before Class ********");
        System.out.println();
        Utilities.setYamlFilePath("integration_testData.yml");
        test = new TestSessionInitiator();
        {
            test.retailPage.getSAPiD(test.getYamlVal("" + test.getYamlVal("environment") + ".Retail.UserName"));
        }
    }

    /**
     * Test Case 01 enter login info.
     */
    @Test
    public void TC01_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".URL"));
        test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".Retail.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment") + ".Retail.Password"));
        test.homePage.verifyHomePageDisplay();
    }


    /**
     * Test Case 02 navigate to Partner Relationships view.
     */
    @Test
    public void TC02_NavigateToPartnerRelationshipsView() {
        
        test.retailPage.navigateToPartnerRelationships();
    }


    /**
     * Test Case 03 drill down to Partner name.
     */
    @Test
    public void TC03_DrillDownToPartnerName() {
        
        test.retailPage.drillDownPartnerName();
    }

    /**
     * Test Case 04 Click on Installed asset tab.
     */
    @Test
    public void TC04_ClickOnInstalledAssetTab() {
        
        test.retailPage.navigateToInstalledAssetsTab();
    }

    /**
     * Test Case 05 Create new asset.
     */
    @Test
    public void TC05_CreateNewAsset() {
        
        test.retailPage.createNewAsset();

    }

    /**
     * Test Case 06 Select Product.
     */
    @Test
    public void TC06_SelectProduct() {
        
        test.retailPage.addProduct("Tank");
        test.retailPage.inputProductLineItemValuesFor("Tank");
    }

    /**
     * Test Case 07 Add Attributes.
     */
    @Test
    public void TC07_AddAttributes() {
        
        test.retailPage.addAttributesDetails("Tank");
    }

    /**
     * Test Case 08 Reading Tab.
     */
    @Test
    public void TC08_AddATGReadings() {
        
        test.retailPage.readingTabActions();
    }

    /**
     * Test Case 09 Click on cancel button.
     */
    @Test
    public void TC09_ClickCancelButton() {
        
        test.retailPage.clickCancelButton();
    }

    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }

}