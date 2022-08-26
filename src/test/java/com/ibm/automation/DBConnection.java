/*
 * @author Rohit Thakur
 * @version 1.0
 * @since 2021-02-12
 */

package com.ibm.automation;

import com.ibm.Utilities.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DB connection class.
 */
public class DBConnection {

    /**
     * Connect FMW db to extract data
     * @param dbQuery sql query
     * @return extracted data
     */
    public String connectFMWDBToExtractOTP(String dbQuery) {
        String dbURL = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.FMW.url"));
        String strUserID = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.FMW.UserName"));
        String strPassword = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.FMW.Password"));

        return connectDBToExtractData(dbQuery, dbURL, strUserID, strPassword);
    }

    /**
     * Connect siebel db to extract data.
     * @param dbQuery sql query
     * @return extracted data
     */
    public String connectSiebelDBToExtractData(String dbQuery) {
        String dbURL = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.Siebel.url"));
        String strUserID = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.Siebel.UserName"));
        String strPassword = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.Siebel.Password"));

        return connectDBToExtractData(dbQuery, dbURL, strUserID, strPassword);
    }

    /**
     * Execute a db Query in siebel.
     * @param dbQuery sql query
     */
    public void connectSiebelDBToExecuteUpdateQuery(String dbQuery) {
        String dbURL = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.Siebel.url"));
        String strUserID = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.Siebel.UserName"));
        String strPassword = (Utilities.getYamlValue("" + Utilities.getYamlValue("environment") + ".DB.Siebel.Password"));

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection myConnection = DriverManager.getConnection(dbURL, strUserID, strPassword);
            Statement sqlStatement = myConnection.createStatement();

            ResultSet myResultSet = sqlStatement.executeQuery(dbQuery);
            int test = sqlStatement.executeUpdate(dbQuery);
            System.out.println("Records updated in DB: " + test);
            myResultSet.close();
            myConnection.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    /**
     * Execute a db Query in DB.
     * @param dbQuery sql query
     * @param dbURL db url
     * @param strUserID db userid
     * @param strPassword db password
     * @return data from col 1 row 1.
     */
    public String connectDBToExtractData(String dbQuery, String dbURL, String strUserID, String strPassword) {
        String data = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection myConnection = DriverManager.getConnection(dbURL, strUserID, strPassword);
            Statement sqlStatement = myConnection.createStatement();

            // Extract OTP
            ResultSet myResultSet = sqlStatement.executeQuery(dbQuery);

            // To find data with column index
            if (myResultSet.next()) {
                //data in row 1 column 1
                data = myResultSet.getString(1);
            }
            myResultSet.close();
            myConnection.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return data;
    }
}
