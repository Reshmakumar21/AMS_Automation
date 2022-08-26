package com.ibm.automation;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class Iterations {

    public static void main(String[] args) {

        int numberOfIterationsRequired = 2;
        String testngXmlName = "CustomerOnBoardingSBC";

        for (int i = 0; i < numberOfIterationsRequired; i++) {
            List<String> suites = new ArrayList<String>();
            suites.add("./src/resources/suiteFileXML/" + testngXmlName + ".xml"); //path of .xml file
            TestNG tng = new TestNG();
            tng.setTestSuites(suites);

            tng.run(); //run test suite
        }
    }
}
