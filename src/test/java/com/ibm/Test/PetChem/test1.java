/*
 * @author Reshma K
 * @version 1.0
 * @since 2023-01-02
 */
package com.ibm.Test.PetChem;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;
import com.ibm.automation.SuperTest;
import com.ibm.automation.TestSessionInitiator;

/**
 * The Class AccountOnboarding_Commercial.
 */
public class test1 extends SuperTest {
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
    	test.launchApplication(test.getYamlVal("" + "SIT"  + ".URL"));
        test.login.LoginToApplication(test.getYamlVal("" + "SIT" +  ".UserName"),
                test.getYamlVal("" + "SIT" +  ".Password"));
    }

}
