/*
 * @author Reshma K
 * @version 1.0
 * @since 2022-12-29
 */
package com.ibm.Test.PetChem;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class PR approval.
 */
public class PRApproval extends SuperTest {
	String PR_num;
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
     * TC 01 Login to FO - UAT - HTIM_IDAM
     */
    @Test
    public void TC01_loginToFO() {
    	test.launchApplication(test.getYamlVal("" + "UAT"  + ".FO"+  ".URL"));
        test.login.LoginToApplication(test.getYamlVal("" + "UAT" + ".FO" +  ".UserName"),
                test.getYamlVal("" + "UAT" + ".FO" + ".Password"));
    }


    /*
     * TC 02 Purchase screen navigation
     */
    @Test
    public void TC02_purchaseScreenNavigation() {
    	test.petChemPage.navigateToPRScreen();
    }
    
    /*
    @Test
    public void TC03_getPRnumber() throws IOException {
    	String exc = "C:\\Users\\0047HE744\\Desktop\\Personal\\MyLearning\\AMS_Automation\\src\\test\\java\\com\\ibm\\Test\\PetChem\\data.xlsx";
    	FileInputStream inputstream = new FileInputStream(exc);
    	try (XSSFWorkbook workbook = new XSSFWorkbook(inputstream)) {
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			XSSFCell PRnum = row.getCell(0);
			PR_num = PRnum.getStringCellValue();
			System.out.println(PR_num);
		}
    }
    */

    /*
     * TC 03 Query for PR
     */
    @Test
    public void TC03_queryPR() {
    	
    	test.petChemPage.queryPR(PR_num);
    }

    /*
     * TC 04 PR approval
     */
    @Test
    public void TC04_PRApproval() {
    	test.petChemPage.drilldownPR();
    	test.petChemPage.truckCapacity();
    	test.petChemPage.approvePR();
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
