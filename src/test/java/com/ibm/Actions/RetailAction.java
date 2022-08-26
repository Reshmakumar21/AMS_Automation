/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2019-03-19
 *
 */
package com.ibm.Actions;


import com.aventstack.extentreports.Status;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.ProfileServiceRequestUI;
import com.ibm.UI.RetailUI;
import com.ibm.Utilities.LoggerWriter;
import com.ibm.Utilities.Utilities;
import org.testng.Assert;
import org.openqa.selenium.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The Class RetailAction.
 */
public class RetailAction extends BaseAction{

    /**
     * The profile SR page UI.
     */
    protected ProfileServiceRequestUI profileSRPage;

    /**
     * The Retail UI.
     */
    protected RetailUI retailUI;

    /**
     * The ContactTab UI.
     */
    protected ContactTabUI contactTab;

    /**
     * The home page.
     */
    protected HomePageUI homePage;

    /**
     * The Login action.
     */
    protected LoginActions loginAction;

    /**
     * The driver.
     */
    WebDriver driver;

    //Class Instances
    String orderNumber, orderStatusFO, orderStatus, tourStatusFO, tourStatus,
            currentSAP_CODE, approverCommentFO, assetID, approvalNote;
    String verifyInboxStatus = "UnVerified";

    /**
     * Instantiates Retail UI actions.
     *
     * @param driver the driver
     */
    public RetailAction(WebDriver driver) {
        super(driver);
        retailUI = new RetailUI(driver);
        contactTab = new ContactTabUI(driver);
        homePage = new HomePageUI(driver);
        profileSRPage = new ProfileServiceRequestUI(driver);
        loginAction = new LoginActions(driver);
        this.driver = driver;
    }


    /**
     * To get SAP_ID of dealer.
     */
    public void getSAPiD(String sapCode) {
        //To split SAP_code into 2 part at special character '_' and use the required data at index 0.
        currentSAP_CODE = sapCode.split("_")[0].trim();
    }

    /**
     * @return available OR not mapped tank.
     */
    private String getAvailableTankValue() {
        //Input SAP code to DB sql and get the non mapped available tank.
        String availableTank = connectDBToFindAvailableTank(currentSAP_CODE);
        System.out.println("Available_Tank: " + availableTank);
        return availableTank.trim();
    }

    /**
     * @return AssetID of dealer.
     */
    private String getAssetID() {
        //Feed order Number from UI to DB sql and get the associated Asset-ID.
        String assetID = connectDBToFindAssetID(orderNumber);
        System.out.println("Asset_ID_Value: " + assetID);
        return assetID.trim();
    }

    /**
     * Navigate to Partner Relationships.
     */
    public void navigateToPartnerRelationships() {
        contactTab.isTabDisplayInMainTabList("Partner Relationships");
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    /**
     * Search Partner Name
     */

    public void searchPartnerWithName(String partnerName) {
        //Search button under Partner Relationship
        retailUI.btn_search.click();
        expWait.waitForDomToLoad();
        //Input Partner Name
        retailUI.txtBox_PartnerName.sendKeys(partnerName);
        //Enter search after input
        retailUI.btn_SearchEnter.click();
        expWait.waitForDomToLoad();
        //TAB action
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
    }

    /**
     * Drill down to Partner name.
     */
    public void drillDownPartnerName() {
        clickViaJavaScript(retailUI.drillDown_PartnerName);
        expWait.waitForHomePageSipperToDisapper();
    }

    private void clickViaJavaScript(WebElement locator) {
        WebElement element = expWait.getWhenClickable(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            executor.executeScript("arguments[0].click();", element);
        } catch (StaleElementReferenceException e) {
            executor.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Navigate to installed asset Tab.
     */
    public void navigateToInstalledAssetsTab() {
        expWait.getWhenVisible(contactTab.get_LowerTabLevel("Service Requests"));
        contactTab.isTabDisplayInTabList("Installed Assets");
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Create new asset.
     */
    public void createNewAsset() {
        retailUI.get_ButtonsInstalledAssets("New").click();
        expWait.waitForDomToLoad();
        expWait.getWhenClickable(retailUI.btn_PlusSignLineItems).click();
        expWait.waitForDomToLoad();
    }

    /**
     * Add product.
     *
     * @param productName
     */
    public void addProduct(String productName) {
        set_LineItemValueAgainstProduct("Product", productName);
    }

    /**
     * Add Product and related values.
     *
     * @param productType
     */
    public void inputProductLineItemValuesFor(String productType) {
        //approvalNote = new Utilities().printRandomString(10);

        //Input line item values against product type
        if (productType.equalsIgnoreCase("Tank")) {
            set_LineItemValueAgainstProduct("Type of Asset Expenditure", "Provided by IOC");
            set_LineItemValueAgainstProduct("Automation Id", "123");
            set_LineItemValueAgainstProduct("Related Product", "MS - BS VI");
            set_LineItemValueAgainstProduct("Approval Date", "09-Apr-2020");
            set_LineItemValueAgainstProduct("Approval Note", "TestApproval");
            set_LineItemValueAgainstProduct("Destination Availability Code", getAvailableTankValue()); // Tank value extracted from DB
        } else if (productType.equalsIgnoreCase("CCTV")) {
            set_LineItemValueAgainstProduct("Type of Asset Expenditure", "Provided by IOC");
            //set_LineItemValueAgainstProduct("Approval Note", approvalNote);
        }
    }

    /**
     * Function mapped to inputProductLineItemValuesFor() & addProduct()
     *
     * @param colName
     * @param setRowValue
     */
    private void set_LineItemValueAgainstProduct(String colName, String setRowValue) {
        expWait.waitForDomToLoad(); //expWait.waitForElementToAppear(retailUI.get_LineItemAppletFirstRowCell(colName));
        retailUI.get_LineItemAppletFirstRowCell(colName).click();
        expWait.waitForDomToLoad();
        driver.switchTo().activeElement().sendKeys(setRowValue);
    }

    /**
     * Add Attributes details.
     */
    public void addAttributesDetails(String productType) {
        //Navigate to Attributes Tab
        retailUI.get_FourthTabLevel("Attributes").click();
        //Verify presence of show more button of Attribute web table
        expWait.getWhenClickable(retailUI.btn_ShowMoreOrLessLineItemAttributes).click();
        expWait.waitForDomToLoad();

        //Input line item attribute values
        if (productType.equalsIgnoreCase("Tank")) {
            //Verify presence of web table Line Item Attributes
            expWait.getWhenVisible(retailUI.get_AttributeName("Water Level High Value (cm)")).isEnabled();
            //Non-Mandatory
            //lineItemAttributeNameAndValue("11 Mesh Gauge Available In The Vent Pipe?", "Yes");
            //Mandatory
            //lineItemAttributeNameAndValue("Breadth (Mtr)", "20");
            lineItemAttributeNameAndValue("Calibration Type", "Mathematical");
            lineItemAttributeNameAndValue("Calibration Value", "20KL(212X604) P1=0 P2=0 DW=0");
            lineItemAttributeNameAndValue("Camlockcoupling", "Yes");
            lineItemAttributeNameAndValue("Date Of Construction", "01/Apr/2020");
            lineItemAttributeNameAndValue("Minimum Oil Level (cm)", "10");
            //lineItemAttributeNameAndValue("No Of Manhole", "4");
            lineItemAttributeNameAndValue("Tank Material", "MS");
            lineItemAttributeNameAndValue("Tankage (KL)", "2");
            lineItemAttributeNameAndValue("Type Of Tank", "Earth Covered");
            lineItemAttributeNameAndValue("Water Level High Value (cm)", "1");
        } else if (productType.equalsIgnoreCase("CCTV")) {
            lineItemAttributeNameAndValue("Fixed IP For Remote Monitoring", "Yes");
            lineItemAttributeNameAndValue("Type", "Normal");
        }

    }

    /**
     * Function mapped to addAttributesDetails()
     *
     * @param attributeName
     * @param attributeValue
     */
    private void lineItemAttributeNameAndValue(String attributeName, String attributeValue) {
        String attrValue = "";
        int numAttempts = 0;
        //Input attribute value once and verify; input again if attribute value not equal to input parameter
        do {
            retailUI.get_AttributeName(attributeName).click();
            expWait.waitForDomToLoad();
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
            expWait.waitForDomToLoad();
            driver.switchTo().activeElement().sendKeys(attributeValue);
            expWait.waitForDomToLoad();
            driver.switchTo().activeElement().sendKeys(Keys.chord(Keys.SHIFT, Keys.TAB));
            expWait.waitForDomToLoad();
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
            expWait.waitForDomToLoad();
            attrValue = driver.switchTo().activeElement().getAttribute("value");
            numAttempts++;

            if (numAttempts == 4) {
                System.out.println("Incorrect 4 attempts");
            }
        }
        while (!(attributeValue.equals(attrValue)) && numAttempts < 5); //if false break the loop
    }

    /**
     * ATG values input into Reading Tab.
     */
    public void readingTabActions() {
        //Navigate to Reading Tab
        retailUI.get_FourthTabLevel("Readings").click();
        //Verify presence of '+' button under Reading tab UI
        expWait.getWhenVisible(retailUI.btn_PlusSignReadings).isEnabled();
        //Expand Tree of product
        retailUI.get_LineItemAppletFirstRowCell("Outline #")
                .findElement(By.xpath("//div[contains(@class,'tree-plus')]")).click();
        //Click second row of product column under Line Item web Table
        retailUI.get_LineItemAppletSecondRowCell("Product").click();
        //Input value for ATG - Not required after new build
        //set_LineItemValueAgainstProductATG("Type of Asset Expenditure", "Outright Purchase");
        set_LineItemValueAgainstProductATG("Automation Id", "123");
        //Click '+' button under Reading tab UI
        expWait.getWhenClickable(retailUI.btn_PlusSignReadings).click();
        expWait.waitForDomToLoad();
        expWait.waitForDomToLoad();

        //homePage.waitLong(3);

        //Input Data under *READING* web table
        set_ReadingsAppletValues("Measurement Type", "Density Temperature Qty");
        set_ReadingsAppletValues("Read Code", "Manual");
        set_ReadingsAppletValues("Product Dip (CM)", "12");
        set_ReadingsAppletValues("Water Dip (CM)", "1");
        set_ReadingsAppletValues("Temperature (°C)", "23");

        //Click calculate button
        expWait.getWhenClickable(retailUI.btn_CalculateReading).click();
        expWait.waitForDomToLoad();

    }

    /**
     * Function mapped to readingTabActions()
     *
     * @param colName
     * @param setRowValue
     */
    private void set_LineItemValueAgainstProductATG(String colName, String setRowValue) {
        retailUI.get_LineItemAppletSecondRowCell(colName).click();
        expWait.waitForDomToLoad();
        driver.switchTo().activeElement().sendKeys(setRowValue);
    }

    /**
     * Function mapped to readingTabActions()
     *
     * @param colName
     * @param setRowValue
     */
    private void set_ReadingsAppletValues(String colName, String setRowValue) {
        retailUI.get_ReadingsAppletFirstRowCell(colName).click();
        expWait.waitForDomToLoad();
        driver.switchTo().activeElement().sendKeys(setRowValue);
    }

    /**
     * Click to Submit Order Button.
     */
    public void clickSubmitButton() {
        //Store Order Number
        orderNumber = retailUI.txtBox_OrderNumber.getAttribute("value");
        System.out.println("OrderNumber: " + orderNumber);
        //Click Submit button
        expWait.getWhenClickable(retailUI.btn_Submit).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

    }

    /**
     * Click to Cancel Order Button.
     */
    public void clickCancelButton() {
        //Input cancel reason
        retailUI.txtBox_CancelReason.sendKeys("Credit Issue");
        expWait.waitForDomToLoad();
        expWait.getWhenClickable(retailUI.btn_Cancel).click();
        expWait.waitForHomePageSipperToDisapper();
    }



    /*Functions related to INSTALLED ASSET AMENDMENT**********************************************************/

    /**
     * @param buttonName workflow button under installed asset.
     */
    private void selectButtonInstalledAsset(String buttonName) {
        retailUI.get_ButtonsInstalledAssets(buttonName).click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
    }

    /**
     * Modify Installed asset.
     */
    public void modifyInstalledAsset() {
        //Modify button under Installed asset applet
        selectButtonInstalledAsset("Modify");
        //Dialogue box to accept modify accept
        retailUI.btn_OkAssetModification.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        //Modifying a part to test the functionality
        set_LineItemValueAgainstProduct("Type of Asset Expenditure", "Outright Purchase");
        expWait.waitForDomToLoad();
    }

    /**
     * Suspend Installed asset.
     */
    public void suspendInstalledAsset() {
        //Suspend button under Installed asset applet
        selectButtonInstalledAsset("Suspend");
    }

    /**
     * Disconnect Installed asset.
     */
    public void disconnectInstalledAsset() {
        //Suspend button under Installed asset applet
        selectButtonInstalledAsset("Decommission");

        //To get commissioning date
        String commissioningDate = retailUI.get_LineItemAppletFirstRowCell("Commissioning Date")
                .getAttribute("textContent");
        //Input Decommissioning date
        set_LineItemValueAgainstProduct("Decommissioning Date", commissioningDate);
        expWait.waitForDomToLoad();
    }



    /*FO UI RELATED ACTION************************************************************************************/

    String tourID = null, nightHalts;

    /**
     * LogOut.
     */
    public void logOut() {
        retailUI.btn_FOUserName.click();
        expWait.waitForDomToLoad();
        retailUI.btn_FOLogout.click();
    }

    /**
     * Search Installed Asset in FO login.
     */
    public void searchInstalledAsset() {
        //Query button to find installed asset
        retailUI.btn_QueryInstalledAsset.click();
        expWait.waitForDomToLoad();
        //Input approval note
        retailUI.txtBox_InstalledAssetAssetID.click();
        retailUI.txtBox_InstalledAssetAssetID.findElement(By.tagName("input")).sendKeys(getAssetID()); //AssetID of dealer as input
        //Search button after data input
        retailUI.btn_GoQueryInstalledAsset.click();
        expWait.waitForDomToLoad();
    }

    /**
     * FO Login.
     */
   /* private ArrayList<String> FOLogin() {
        ArrayList<String> tabs;
        String uRL = "";
        String userID = "";
        String psswrd = "";
        if (Utilities.getYamlValue("environment").toLowerCase().contains("sit")) {
            uRL = Utilities.getYamlValue("url_FO_SIT");
            if (tourID != null) {
                userID = Utilities.getYamlValue("DRSIT.Retail.FO1.UserName");
                psswrd = Utilities.getYamlValue("DRSIT.Retail.FO1.Password");
            } else {
                userID = Utilities.getYamlValue("DRSIT.Retail.FO.UserName");
                psswrd = Utilities.getYamlValue("DRSIT.Retail.FO.Password");
            }
        } else if (Utilities.getYamlValue("environment").toLowerCase().contains("uat")) {
            uRL = Utilities.getYamlValue("url_FO_UAT");
            if (tourID != null) {
                userID = Utilities.getYamlValue("DRUAT.Retail.FO1.UserName");
                psswrd = Utilities.getYamlValue("DRUAT.Retail.FO1.Password");
            } else {
                userID = Utilities.getYamlValue("DRUAT.Retail.FO.UserName");
                psswrd = Utilities.getYamlValue("DRUAT.Retail.FO.Password");
            }
        }
        //to open new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");
        // to handle multiple tabs and switch between the tabs
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // switches to new tab

        //Navigate to FO URL
        driver.get(uRL);
        new LoginActions(driver).LoginToApplication(userID, psswrd);
        new LoginActions(driver).clickOnSighInButton();
        new HomePageActions(driver).verifyHomePageDisplay();
        return tabs;
    }*/

    /**
     * FO Retail related decision.
     *
     * @param btnApproveReject
     */
    public void FORetailDecision(String btnApproveReject) {
        //Login FO
        ArrayList<String> tabs = loginAction.loginFORetail();

        //FO homepage UI
        profileSRPage.get_nameInboxItem(orderNumber).isDisplayed();
        profileSRPage.get_nameInboxItem(orderNumber).click();

        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //Input approver comments
        if (verifyInboxStatus.equalsIgnoreCase("Verified")) {
            retailUI.txtBox_FO_ApproverCommentsSecondRow.click();
            retailUI.txtBox_FO_ApproverCommentsSecondRow.findElement(By.tagName("textarea"))
                    .sendKeys("TEST_AUTOMATED_COMMENT_2");
            expWait.waitForDomToLoad();
        } else {
            retailUI.txtBox_FO_ApproverComments.click();
            retailUI.txtBox_FO_ApproverComments.findElement(By.tagName("textarea"))
                    .sendKeys("TEST_AUTOMATED_COMMENT");
            expWait.waitForDomToLoad();
        }

        //Approve-Reject button
        retailUI.get_btnApproveRejectFO(btnApproveReject).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //Store order status & Approver Comment
        orderStatusFO = retailUI.txtBox_OrderStatus.getAttribute("value");
        approverCommentFO = retailUI.txtBox_FO_ApproverComments.getAttribute("textContent");

        //Logout from FO
        logOut();

        driver.switchTo().window(tabs.get(0)); // switch back to main screen
        if (!retailUI.txtBox_OrderStatus.getAttribute("value").equalsIgnoreCase("Closed")) {
            driver.navigate().refresh();
            expWait.waitForDomToLoad();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
            //Store order status from dealer
            orderStatus = retailUI.txtBox_OrderStatus.getAttribute("value");
        }

    }


    /*FO Tour related operations********************************/

    /**
     * Navigate to Tours tab.
     */
    public void navigateToToursTab() {
        contactTab.isTabDisplayInMainTabList("Tours");
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    public void searchTourId() {
        //Search query button
        retailUI.btn_SearchTour.click();
        expWait.waitForDomToLoad();

        //input search tourId
        retailUI.txt_TourID.findElement(By.tagName("input")).sendKeys(tourID);
        retailUI.txt_TourID.findElement(By.tagName("input")).sendKeys(Keys.ENTER);

        //New Tour Name DrillDown.
        retailUI.txtBox_TourName.findElement(By.tagName("a")).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //Tour Status after approval by other FO.
        tourStatus = retailUI.txtBox_TourStatus.getAttribute("value");
    }

    /**
     * Creating a new tour.
     *
     * @param startDate
     * @param endDate
     */
    public void createNewTour(String startDate, String endDate) {
        //Click + sigh to create new tour.
        retailUI.btn_AddNewTour.click();
        expWait.waitForDomToLoad();
        //Store tourID for further process.
        tourID = retailUI.txt_TourID.getAttribute("title");

        //Input Name for new tour.
        //retailUI.txtBox_TourName.click();
        retailUI.txtBox_TourName.findElement(By.tagName("input")).sendKeys(printRandomString(7));
        retailUI.txtBox_TourName.findElement(By.tagName("input")).sendKeys(Keys.TAB);
        //Input tour type.
        retailUI.txtBox_TourType.click();
        retailUI.txtBox_TourType.findElement(By.xpath("input")).sendKeys("Planned");
        //Input Start Date.
        retailUI.txtBox_StartDate.click();
        retailUI.txtBox_StartDate.findElement(By.xpath("input")).sendKeys(startDate);
        //Input End Date.
        retailUI.txtBox_EndDate.click();
        retailUI.txtBox_EndDate.findElement(By.xpath("input")).sendKeys(endDate);
        //Store Night Halts value for furthur process.
        nightHalts = retailUI.txt_NightHalts.getAttribute("textContent");
        //New Tour Name DrillDown.
        retailUI.txtBox_TourName.findElement(By.tagName("a")).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    /**
     * Submit New Tour.
     */
    public void submitNewTour() {
        //Verify Tour Status before submit.
        tourStatus = retailUI.txtBox_TourStatus.getAttribute("value");
        Assert.assertEquals("Pending", tourStatus);

        //Input distance covered
        retailUI.txtBox_DistanceCovered.sendKeys("101");

        //Click submit button
        retailUI.btn_SubmitNewTour.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //Verify Tour Status after submit.
        tourStatus = retailUI.txtBox_TourStatus.getAttribute("value");
        Assert.assertEquals("Submitted for Approval", tourStatus);

    }

    /**
     * FO Tour decision.
     *
     * @param btnApproveReject to approve or reject
     */
    public void FOTourDecision(String btnApproveReject) {
        //Login FO
        ArrayList<String> tabs = loginAction.loginSecondFORetail();

        //FO homepage UI
        if (tourID != null) {
            profileSRPage.get_nameInboxItem(tourID).isDisplayed();
            profileSRPage.get_nameInboxItem(tourID).click();
        } else {
            System.out.println("TourID_found_null");
        }
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //Approve-Reject button
        retailUI.get_btnApproveRejectFO(btnApproveReject).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

        //Store order status
        tourStatusFO = retailUI.txtBox_TourStatus.getAttribute("value");

        //Logout from FO
        logOut();

        driver.switchTo().window(tabs.get(0)); // switch back to main screen
        /*if (!retailUI.txtBox_TourStatus.getAttribute("value").equalsIgnoreCase("Tour Approved")) {
            driver.navigate().refresh();
            expWait.waitForDomToLoad();
            //Store order status from dealer
            tourStatus = retailUI.txtBox_TourStatus.getAttribute("value");
        }*/

    }

    /*Validations & Verifications******************************************************************/

    /**
     * Validations.
     */
    public void validations() {
        System.out.println("Order_Status_At_Dealer: " + orderStatus);
        System.out.println("Order_Status_At_FO: " + orderStatusFO);
        Assert.assertEquals(orderStatusFO, orderStatus,"Comparing Order Status at Dealer and FO.");
        LoggerWriter.logger.log(Status.PASS, "OrderStatus at Dealer and FO are same.");
    }

    /**
     * Validations tour.
     */
    public void validationsTour() {
        System.out.println("Tour_Status_At_Planner_FO: " + tourStatus);
        System.out.println("Tour_Status_At_Decision_Taker_FO: " + tourStatusFO);
        Assert.assertEquals(tourStatusFO, tourStatus,"Comparing Order Status at Dealer and FO.");
        LoggerWriter.logger.log(Status.PASS, "TourStatus at Planner FO and Decision Taker FO are same.");
    }

    /**
     * Verify Inbox for messages.
     */
    public void verifyInboxDealer() {
        contactTab.get_LowerTabLevel("Inbox").click();
        expWait.waitForDomToLoad();
        String approverComment = retailUI.txtBox_FO_ApproverComments.getAttribute("textContent");
        Assert.assertEquals(approverCommentFO, approverComment, "Comparing approver comments at Dealer and FO.");
        verifyInboxStatus = "Verified";
    }



    /*
     * COMMON DB Functions across RETAIL
     **********************************************************************************************/

    /*
     * To find available tank
     */
    private String connectDBToFindAvailableTank(String sapCode) {
            String dbQuery = "SELECT avl.avail_cd " +
                    "FROM   siebel.s_prod_inv_cat avl " +
                    "WHERE  avl.avail_cd LIKE 'Tank%' " +
                    "       AND avl.avail_cd NOT IN (SELECT DISTINCT avl1.avail_cd " +
                    "                                FROM   siebel.s_asset ast " +
                    "                                       LEFT OUTER JOIN siebel.s_prod_inv_cat " +
                    "                                                       avl1 " +
                    "                                                    ON " +
                    "                                       avl1.row_id = ast.x_category_id " +
                    "                                       LEFT OUTER JOIN siebel.s_prod_int prod " +
                    "                                                    ON prod.row_id = ast.prod_id " +
                    "                                       LEFT OUTER JOIN siebel.s_org_ext org " +
                    "                                                    ON " +
                    "                                       org.row_id = ast.owner_accnt_id " +
                    "                                WHERE  prod.name = 'Tank' " +
                    "                                       AND org.integration_id = '" + sapCode + "' " +
                    "                                       AND ast.status_cd = 'Active' " +
                    "                                       AND ast.x_category_id IS NOT NULL " +
                    "                                UNION " +
                    "                                SELECT DISTINCT avl2.avail_cd " +
                    "                                FROM   siebel.s_order_item ordItm " +
                    "                                       LEFT OUTER JOIN siebel.s_prod_inv_cat " +
                    "                                                       avl2 " +
                    "                                                    ON " +
                    "                                       avl2.row_id = ordItm.x_invt_category_id " +
                    "                                       LEFT OUTER JOIN siebel.s_prod_int prod1 " +
                    "                                                    ON " +
                    "                                       prod1.row_id = ordItm.prod_id " +
                    "                                       JOIN siebel.s_order ord " +
                    "                                         ON ord.row_id = ordItm.order_id " +
                    "                                       LEFT OUTER JOIN siebel.s_org_ext org1 " +
                    "                                                    ON " +
                    "                                       org1.row_id = ordItm.owner_account_id " +
                    "                                WHERE  prod1.name = 'Tank' " +
                    "                                       AND org1.integration_id = '" + sapCode + "' " +
                    "                                       AND ord.status_cd in ('Open','Pending For Approval') " +
                    "                                       AND ordItm.x_invt_category_id IS NOT NULL " +
                    "                               ) " +
                    "FETCH first 1 ROWS only";

            return connectSiebelDBToExtractData(dbQuery);
    }

    /*
     * To find AssetID.
     */
    private String connectDBToFindAssetID(String orderNumbr) {
        String dbQuery = "select serial_num from siebel.s_asset where row_id = ROOT_ASSET_ID and orig_order_id in" +
                "( select row_id from siebel.s_order where order_num='" + orderNumbr + "')";

        return connectSiebelDBToExtractData(dbQuery);
    }
}
