package com.ibm.Test.Retail.PAM.FOScenarios;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The Retail PAM FO test class.
 */
public class PAM_FO_CCTV_Approve extends SuperTest {

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
    }

    /**
     * Test Case 01 enter login info.
     */
    @Test
    public void TC01_EnterLoginInfo() {
        test.launchApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".FO.URL"));
        test.login.LoginToApplication(test.getYamlVal("" + test.getYamlVal("environment") + ".FO.Retail.User1.UserName"),
                test.getYamlVal("" + test.getYamlVal("environment") + ".FO.Retail.User1.Password"));
        test.homePage.verifyHomePageDisplay();
    }

    /**
     * Test Case 02 navigate to Partner Relationships view.
     */
    @Test
    public void TC02_NavigateToPartnerRelationshipsView() {
        test.retailPage.navigateToPartnerRelationships();
    }

    /***
     * Search for Partner Name.
     * **/
    @Test
    public void TC03_SearchPartnerName() throws InterruptedException {
        test.retailPage.searchPartnerWithName("BISHAMBER SAHAI& SONS");
    }

    /**
     * Test Case 04 drill down to Partner name.
     */
    @Test
    public void TC04_DrillDownToPartnerName() {
        test.retailPage.drillDownPartnerName();

    }


    /**
     * Test Case 05 click on Installed Assets.
     */
    @Test
    public void TC05_ClickOnInstalledAssetTab() {
        test.retailPage.navigateToInstalledAssetsTab();
    }


    /**
     * Test Case 06 Create new asset.
     */
    @Test
    public void TC06_CreateNewAsset() {
        test.retailPage.createNewAsset();

    }


    /**
     * Test Case 07 Select Product.
     */
    @Test
    public void TC07_SelectAddProduct() {
        test.retailPage.addProduct("CCTV");
        test.retailPage.inputProductLineItemValuesFor("CCTV");
    }


    /**
     * Test Case 08 Add Attributes.
     */
    @Test
    public void TC08_AddAttributes() {
        test.retailPage.addAttributesDetails("CCTV");
    }

    /**
     * Test Case 09 Click to Submit button.
     */
    @Test
    public void TC09_ClickSubmitButton() {
        test.retailPage.clickSubmitButton();
    }

    /**
     * Tear down session.
     */
    @AfterClass
    public void tearDownSession() {
        test.closeBrowserSession();
    }
}
