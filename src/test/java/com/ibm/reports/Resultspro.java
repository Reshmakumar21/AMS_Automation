/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-05-01
 */
package com.ibm.reports;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.Utilities.Utilities;


/**
 * The Class ResultsIT.
 */
public class Resultspro {

	/** The testdata. */
	String testdata;

	/** The today. */
	Date today = new Date();

	/** The host. */
	String host = "smtp.gmail.com";

	/** The from. */
	String from = "automation20auto@gmail.com";

	/** The password. */
	String password = "Admin@123";

	/** The port. */
	String port = "587";

	/** The message. */
	Message message;

	/** The text file1. */
	public String textFile1;

	/**
	 * Setup mail config.
	 */
	@BeforeClass
	void setupMailConfig() {
		Utilities.setYamlFilePath("integration_testData.yml");

		System.out.println("%%%%%%%%%%%%%%%%%%%%%");
	}

	/**
	 * Send results mail.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void sendResultsMail() throws Exception {
		try {
			if (Utilities.getYamlValue("results.sendEmail").equalsIgnoreCase("yes")) {
				Properties props = new Properties();
				props.put("mail.smtps.auth", "true");
				Session session = Session.getInstance(props, null);
				Message message = new MimeMessage(getSession());
				setMailRecipient(message);
				message.setSubject(setMailSubject());
				message.setContent(setAttachement());
				Transport transport = session.getTransport("smtps");
				transport.connect(host, from, password);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			} else {
				System.out.println("enteredElse");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		Authenticator authenticator = new Authenticator(from, password);
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtps");
		properties.put("mail.smtps.auth", "true");
		properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", port);
		return Session.getInstance(properties, authenticator);
	}

	/**
	 * Sets the body text.
	 *
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String setBodyText() throws IOException {
		String mailtext = "";
		mailtext = "Hi,<br>";
		mailtext = mailtext + "</br><br>The automated functional test were performed</br><br>";
		mailtext = mailtext + "<br><b><font style= Courier, color = green>Test Name: </font></b>" + getTestName();
		mailtext = mailtext + "<br><b><font color = green>Test Date: </font></b>" + today;
//		mailtext = mailtext + "<br><b><font color = green>Test Browser: </font></b>" + System.getProperty("browser", Utilities.getYamlValue("selenium.browser").toString());
//		mailtext = mailtext + "<br><b><font color = green>Test Environment: </font></b>" + Utilities.getYamlValue("testenv");
//		mailtext = mailtext + "<br><b><font color = green>Test Server: </font></b>" + Utilities.getYamlValue("selenium.server");
//		if (Utilities.getYamlValue("selenium.server").equalsIgnoreCase("remote")) {
//			mailtext = mailtext + "<br><b><font color = green>Test Server host: </font></b>" + Utilities.getYamlValue("selenium.remote.host");
//		}
		mailtext = mailtext + "<br><b><font color = green>Test Case Executed By: </font></b>" + "IOCL Automation Team";
		mailtext = mailtext + "<br><b><font color = green>Test Case Executed By: </font></b>" + System.getProperty("user.name");
		mailtext = mailtext + "<b>" + testSetResult() + "</b>";
		mailtext = mailtext + "<br><br>The detailed test results are given in the attached <i>emailable-report.html</i> </br></br>";
		mailtext = mailtext + "<br><br>Best Regards" + "</br></br>";
		mailtext = mailtext + "<br>IOCL Automation QA Team" + "</br>";
		mailtext = mailtext + "<br><br>Note: This is a system generated mail. Please do not reply." + "</br></br>";
		mailtext = mailtext + "<br>If you have any queries mail to <a href=mailto:stiwari1@in.ibm.com?Subject=Reply of Automation Status>IOCL AutomationQA</a></br>";
		return mailtext;
	}

	/**
	 * Sets the mail subject.
	 *
	 * @return the string
	 */
	private String setMailSubject() {
		if (getTestName().toLowerCase().contains("createnewcourse")) {
			return (System.getProperty("environment", "").toUpperCase() + ": " + System.getProperty("product", "") + "_" + getTestName() + " - " + today);
		} else {
			if (getTestName().toLowerCase().contains("masteropencloseactivity")) {
				return (System.getProperty("environment", "").toUpperCase() + ": " + System.getProperty("product", "") + "_" + getTestName() + " - " + today);
			} else {
				return (System.getProperty("environment", Utilities.getYamlValue("testenv")).toUpperCase() + ": " + getTestName() + " - " + today);
			}
		}
	}

	/**
	 * Sets the mail recipient.
	 *
	 * @param message
	 *            the new mail recipient
	 */
	private void setMailRecipient(Message message) {
		// System.out.println("EnteredsetMailRecipient");
		try {
			for (Object recipient : Utilities.getYamlNodesArray("results.recipients").values()) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.toString()));
				message.addRecipient(Message.RecipientType.BCC, new InternetAddress(recipient.toString()));
			}
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("automation20auto@gmail.com"));
			message.addRecipient(Message.RecipientType.BCC, new InternetAddress("stiwari1@in.ibm.com"));
		} catch (MessagingException me) {
			System.out.println("Exception in Results mail sending:-" + me.getStackTrace());
		}
	}

	/**
	 * Sets the attachement.
	 *
	 * @return the multipart
	 * @throws Exception
	 *             the exception
	 */
	private Multipart setAttachement() throws Exception {
		// Create the message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(setBodyText(), "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		// Part two is attachment
		messageBodyPart = new MimeBodyPart();
		System.out.println("getTestName() :::::::::::: " + getTestName());
		if (getTestName().toLowerCase().contains("runner")) {
			messageBodyPart.attachFile("./target/test-output/emailable-report.html");
			multipart.addBodyPart(messageBodyPart);
		} else {
			messageBodyPart.attachFile("./target/surefire-reports/emailable-report.html");
			multipart.addBodyPart(messageBodyPart);
		}
		return multipart;
	}

	/**
	 * Gets the test name.
	 *
	 * @return the test name
	 */
	private String getTestName() {
		String test = System.getProperty("test", "null");
		String testsuite = System.getProperty("testsuite", "null");
		String testName;
		if (test != "null") {
			testName = test + " was executed";
			return testName;
		} else if (testsuite != "null") {
			testName = testsuite + "were executed";
			return testName;
		} else {
			testName = "complete automation test suite or TestNg xml was executed";
			return testName;
		}
	}

	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	public void getFilePath() {
		File folder = new File("./target/surefire-reports");
		String[] fileNames = folder.list();
		int total = 0;
		for (String fileName : fileNames) {
			if (fileName.contains(".txt")) {
				total++;
				// System.out.println("total is" + total);
				assert total == 1;
				textFile1 = fileName;
				// System.out.println("The filename is:" + textFile1);
			}
		}
	}

	/**
	 * Test set result.
	 *
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String testSetResult() throws IOException {
		String messageToBeSent = ("");
		getFilePath();// calling method getFilepath()
		String textFilePath = "./target/surefire-reports/" + textFile1;
		FileInputStream fstream = new FileInputStream(textFilePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		int num = 4;
		// Read File Line By Line
		String[] strLine = new String[num];
		for (int i = 0; i < num; i++) {
			strLine[i] = br.readLine();
			messageToBeSent = messageToBeSent + "<br>" + strLine[i] + "</br>";
		}
		br.close();
		return messageToBeSent;
	}
}
