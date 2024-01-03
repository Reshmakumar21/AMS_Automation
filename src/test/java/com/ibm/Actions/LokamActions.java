/*
 * @author  Rohit Thakur
 * @version 1.0
 * @since   2019-03-19
 *
 */
package com.ibm.Actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.ibm.UI.AccountsTabUI;
import com.ibm.UI.ContactTabUI;
import com.ibm.UI.HomePageUI;
import com.ibm.UI.LokamUI;
import com.ibm.Utilities.LoggerWriter;

/**
 * The Class LokamActions.
 */
public class LokamActions extends BaseAction{

    /**
     * The lead tab.
     */
    protected LokamUI lokamTab;

    /**
     * The contact Tab.
     */
    protected ContactTabUI contactTab;

    /**
     * The Account page.
     */
    protected AccountsTabUI accountPage;

    /**
     * The home page.
     */
    protected HomePageUI homePage;

    /**
     * The driver.
     */
    WebDriver driver;


    /**
     * Class Instances
     */
    String optId, phnNumber;
    boolean flagAccount, flagCorporate;

    /**
     * Instantiates few UI actions.
     *
     * @param driver the driver
     */
    public LokamActions(WebDriver driver) {
    	super(driver);
        contactTab = new ContactTabUI(driver);
        lokamTab = new LokamUI(driver);
        homePage = new HomePageUI(driver);
        accountPage = new AccountsTabUI(driver);
        this.driver = driver;
    }

    /**
     * Navigate to lead tab.
     */
    public void navigateToLeadTab() {
        contactTab.get_MainTabLevel("Leads").click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        contactTab.get_SecondTabLevel("My Leads").click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    /**
     * Create New lead.
     */
    public void createNewLead() {
        lokamTab.btn_CreateButtonLead.click();
        expWait.waitForDomToLoad();
    }

    /**
     * Search Prospect Individual.
     */
    public void searchProspectIndividual() {
        lokamTab.txtBox_ProspectLastName.findElement(By.xpath("following-sibling::span")).click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        lokamTab.ClickPlusButton.click();
        expWait.waitForHomePageSipperToDisapper();
    }



    /**
     * Starts-LOKAM corporate functions***********
     */

    /**
     * Search Prospect Corporate.
     */
    public boolean searchProspectCorporate() {
            searchProspectIndividual();
        lokamTab.chkBox_CorporateLead.click();
        do{
            lokamTab.txtBox_CompanyName.click();
        }while(lokamTab.txtBox_CompanyName.getAttribute("aria-readonly")
                .equalsIgnoreCase("true"));
        lokamTab.txtBox_CompanyName.sendKeys("CompanY" +
                printRandomString(5).toLowerCase());
        return flagCorporate = true;
    }

    /**
     * Input Industry Details.
     */
    public void inputIndustryDetails() {
        lokamTab.txtBox_IndustryCategory.sendKeys("Telecom");
        lokamTab.txtBox_IndustrySubCategory.sendKeys("Telecom - Vendor");
    }

    /**
     * Perform Account Creation.
     */
    public String accountCreation() {
        //set flag for input to satisfy conditions in other functions
        flagAccount = true;
        String accountName = lokamTab.drillDown_AccountName.getAttribute("value");
        lokamTab.drillDown_AccountName.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        accountPage.input_MobileNumberAccount.sendKeys(phnNumber);
        new AccountsTabAction(driver).addIdentitiesForNewCustomer("", "", "");
        return accountName;
    }

    /**
     * End-LOKAM corporate functions***********
     */



    /**
     * Input Prospect details.
     */
    public void inputProspectDetails(String salutation,String firstName, String lastName,
                        String addressLine, String pinCode,String city) {
        //Input of salutation, firstName and lastName
        lokamTab.AddTitle.sendKeys(salutation);
        //Adding Random alphabetic string to generate new name
        lokamTab.AddFirstName.sendKeys(firstName
                + printRandomString(5).toLowerCase());
        lokamTab.AddLastName.sendKeys(lastName);

        //Generating random new mobile number starting with digit 3
        phnNumber = new ProfileServiceRequestAction(driver)
                .randomPhoneNumber("3");
        lokamTab.AddMobileNumber.sendKeys(phnNumber);
        lokamTab.StreetAddress.sendKeys(addressLine);
        lokamTab.City.sendKeys(city);
        lokamTab.Pincode.sendKeys(pinCode);
        //performSave
        performSave();
        lokamTab.OkButton.click();
        expWait.waitForHomePageSipperToDisapper();

        //flag comparison to true in case of lead creation for corporate
        if (flagCorporate) {
            inputIndustryDetails();
        }
        //Add Lead Source
        lokamTab.AddLeadSource.sendKeys("SRM");
        lokamTab.AddDivison.sendKeys("LPG");
        //Other Mandatory fields
        lokamTab.txtBox_MonthlyFuel.sendKeys("45");
        lokamTab.txtBox_MonthlyFuelUOM.sendKeys("KL");
        //performSave();
        performSave();
		expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }


    /**
     * Convert lead
     */
    public void convertLead() {
        lokamTab.btn_ConvertLead.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }

    /**
     * Navigate to Contact tab.
     */
    public void navigateToContact() {
        contactTab.get_LowerTabLevel("Contacts").click();
        expWait.waitForHomePageSipperToDisapper();
        lokamTab.drillDown_ContactLastName.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }


    /**
     * Perform Contact Dedup.
     */
    public void performContactDedup() {
        lokamTab.btn_ContactDedup.click();
        expWait.waitForDomToLoad();
        expWait.waitForHomePageSipperToDisapper();
        contactTab.btn_ContactDedupPickRecord.isDisplayed();
        Assert.assertTrue( !(lokamTab.txt_Status.getAttribute("value").isEmpty()),"Depup Fail");
        Assert.assertTrue(!(lokamTab.txt_KYC.getAttribute("value").isEmpty()),"Depup Fail KYC Level blank");
    }

    /**
     * Navigate To Opportunity tab.
     */
    public void navigateToOpportunityTab() {
        contactTab.get_LowerTabLevel("Opportunities").click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
    }


    /**
     * Convert Opportunity.
     */
    public void convertOpportunity() {
        lokamTab.drillDown_OpptyName.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();
        optId = lokamTab.txt_OpportunityId.getAttribute("value");

        if (flagAccount) {
            lokamTab.txtBox_Site.findElement(By.xpath("following-sibling::span")).click();
            expWait.waitForHomePageSipperToDisapper();
            expWait.waitForDomToLoad();
            lokamTab.btn_SiteOK.click();
            expWait.waitForDomToLoad();
        }

        lokamTab.btn_ConvertOppty.click();
        expWait.waitForHomePageSipperToDisapper();
        expWait.waitForDomToLoad();

    }

    /**
     * Validate Relationship status after lead creation.
     */
    public void validateRelationShipStatus() {
        String relID, relType, relStatus, relSubStatus;
        if (flagAccount) {
            relID = lokamTab.txt_RelationshipRelationShipNumber.getText();
            System.out.println(relID);
            relType = lokamTab.txt_RelationshipType.getText();
            System.out.println(relType);
            relStatus = lokamTab.txt_RelationshipStatus.getText();
            System.out.println(relStatus);
            relSubStatus = lokamTab.txt_RelationshipSubStatus.getText();
            System.out.println(relSubStatus);
            Assert.assertTrue(lokamTab.txt_RelationshipStatus.getText().equalsIgnoreCase("IN PROCESS"));
            Assert.assertTrue(lokamTab.txt_RelationshipSubStatus.getText().equalsIgnoreCase("IN PROCESS"));
            LoggerWriter.logger.log(Status.PASS, "RelationShip_Id: " + relID + " with transaction_type: "
                    + relType + " has RelationShip_Status: " + relStatus + " & RelationShip_SubStatus: " + relSubStatus);
        } else {
            relID = contactTab.txt_RelationshipRelationShipNumber.getAttribute("value");
            System.out.println(relID);
            relType = contactTab.txt_RelationshipType.getAttribute("value");
            System.out.println(relType);
            relStatus = contactTab.txt_RelationshipStatus.getAttribute("value");
            System.out.println(relStatus);
            relSubStatus = contactTab.txt_RelationshipSubStatus.getAttribute("value");
            System.out.println(relSubStatus);
            Assert.assertTrue(contactTab.txt_RelationshipStatus.getAttribute("value").equalsIgnoreCase("IN PROCESS"));
            Assert.assertTrue(contactTab.txt_RelationshipSubStatus.getAttribute("value").equalsIgnoreCase("IN PROCESS"));
            LoggerWriter.logger.log(Status.PASS, "RelationShip_Id: " + relID + " with transaction_type: "
                    + relType + " has RelationShip_Status: " + relStatus + " & RelationShip_SubStatus: " + relSubStatus);
        }
    }

}

