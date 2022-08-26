package com.ibm.automation;

import com.ibm.Utilities.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {

	boolean boolExtractOTP=true;

	private void yes(){
		int i = (new Random().nextInt(10) + 1) * 1000;
		System.out.println(i);
	}

	private String extractOTP(String strData) {
		String strMatch = "";
		if (strData.contains("OTP")) {
			strMatch = "OTP";
		} else if (strData.contains("is :")) {
			strMatch = "is :";
		}
		String[] newdata = strData.split(strMatch);
		String data = newdata[1];
		Pattern pattern = Pattern.compile("(\\d{4})");

		/*
		 * \d is for a digit {} is the number of digits here 4.
		 */

		Matcher matcher = pattern.matcher(data);
		String val = "";
		if (matcher.find()) {
			val = matcher.group(0); // 4 digit number
		}
		return val.replaceAll("//s+", "");
	}

	private String connectDBForPhoneNumberOTP(String env, String query) {
		String otp = "", s1="";
		try {
			String dbURL;
			String strUserID;
			String strPassword;
			if (env.toLowerCase().contains("sit")) {
				dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.59.7.86)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=TMWPDB.ds.indianoil.in)))";
				strUserID = "DCT_SOAUTIL";
				strPassword = "Welcome123";
			} else {
				dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.59.7.152)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=UMWPDB.DS.INDIANOIL.IN)))";
				strUserID = "DCU_SOAUTIL";
				strPassword = "Welcome123";
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection myConnection = DriverManager.getConnection(dbURL, strUserID, strPassword);
			Statement sqlStatement = myConnection.createStatement();
			// SELECT QUERY
			String readRecordSQL = query;
			ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);
			if(myResultSet.next()){
				s1 = myResultSet.getString(1);

			}
			// To find data with column name
			// otp = myResultSet.getString("OTP");

			if (boolExtractOTP == false) {
				otp = s1;
			} else {
				otp = extractOTP(s1);
			}

			myResultSet.close();
			myConnection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;
	}

	public void method(){
		 int a = 123;
				String rev = "";

			String st = Integer.toString(a);


		StringBuilder skt = new StringBuilder(st);
		String sty = String.valueOf(skt.reverse());
		int k = Integer.parseInt(sty);
		System.out.println(k);

	}

	public void method1(){
		String[] args = {"Volvo", "Kia", "Suzuki"};
				int len = args.length;
			args[0] = "Hyundai";
		System.out.println(len);
		System.out.println();
		for(String b:args){
			System.out.println(b);
		}
	}

	public static void main(String[] args) {
		TestMain t = new TestMain();
		//System.out.println(t.connectDBForPhoneNumberOTP("uat", "select SMS_CONTENT from OUTGOING_SMS  where MOBILE_NO = '9158142698' order by DATE_SENT desc FETCH first 1 ROWS only"));;
		//t.yes();
		t.method1();
	}
}
